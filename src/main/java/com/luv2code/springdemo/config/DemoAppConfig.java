package com.luv2code.springdemo.config;

import java.util.HashMap;
import java.util.Map;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@EnableJpaRepositories("com.luv2code.springdemo.repository")
@EnableTransactionManagement
@ComponentScan("com.luv2code.springdemo")
public class DemoAppConfig implements WebMvcConfigurer {

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	  public BasicDataSource dataSource() {
	    // org.apache.commons.dbcp.BasicDataSource
	    BasicDataSource basicDataSource = new BasicDataSource();
	    basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    basicDataSource.setUrl("jdbc:mysql://localhost:3306/product_tracker?useSSL=false");
	    basicDataSource.setUsername("hbstudent");
	    basicDataSource.setPassword("hbstudent");
	    return basicDataSource;
	  }
	
	
	    
	 @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//	    entityManagerFactory.setPersistenceUnitName("hibernate-persistence");
	    entityManagerFactory.setDataSource(dataSource);
	    entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	    entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
	    entityManagerFactory.setPackagesToScan("com.luv2code.springdemo");
	     
	    entityManagerFactory.setJpaPropertyMap(hibernateJpaProperties());
	    return entityManagerFactory;
	  }
	    
	    private Map<String, ?> hibernateJpaProperties() {
	        HashMap<String, String> properties = new HashMap<>();
	        properties.put("hibernate.hbm2ddl.auto", "create");
	        properties.put("hibernate.show_sql", "false");
	        properties.put("hibernate.format_sql", "false");
	        properties.put("hibernate.hbm2ddl.import_files", "insert-data.sql");
	        properties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
	         
	        properties.put("hibernate.c3p0.min_size", "5");
	        properties.put("hibernate.c3p0.max_size", "20");
	        properties.put("hibernate.c3p0.timeout", "3000"); // 5mins
	         
	        return properties;
	      }

	    @Bean
	    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	      //org.springframework.orm.jpa.JpaTransactionManager
	      JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
	      jpaTransactionManager.setEntityManagerFactory(emf);
	      return jpaTransactionManager;
	    }
	
}