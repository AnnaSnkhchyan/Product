package com.product.springdemo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;



@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@EnableJpaRepositories("com.product.springdemo.repository")
@EnableTransactionManagement
@ComponentScan("com.product.springdemo")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class DemoAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	
	public DataSource basicDataSource() {
	  
	    // org.apache.commons.dbcp.BasicDataSource
	    ComboPooledDataSource basicDataSource = new ComboPooledDataSource();
	    try {
			basicDataSource.setDriverClass("com.mysql.jdbc.Driver");		
		}
		catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
	    
	    logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
	    
	    basicDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
	    basicDataSource.setUser(env.getProperty("jdbc.user"));
	    basicDataSource.setPassword(env.getProperty("jdbc.password"));
	    
	    basicDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		basicDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		basicDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));		
		basicDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
	    return basicDataSource;
	  }
	
	
	    
	 @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//	    entityManagerFactory.setPersistenceUnitName("hibernate-persistence");
	    entityManagerFactory.setDataSource(dataSource);
	    entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	    entityManagerFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan")); 
	    entityManagerFactory.setJpaProperties(getHibernateProperties());
	    return entityManagerFactory;
	  }

	    private Properties getHibernateProperties() {

			// set hibernate properties
			Properties props = new Properties();

			props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
			props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
			
			return props;				
		}
	    
	    private int getIntProperty(String propName) {
			
			String propVal = env.getProperty(propName);
			
			// now convert to int
			int intPropVal = Integer.parseInt(propVal);
			
			return intPropVal;
		}
	    
	    @Bean
	    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	      //org.springframework.orm.jpa.JpaTransactionManager
	      JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
	      jpaTransactionManager.setEntityManagerFactory(emf);
	      return jpaTransactionManager;
	    }
	
}