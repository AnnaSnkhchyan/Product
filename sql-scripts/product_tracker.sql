DROP SCHEMA IF EXISTS `product_tracker`;

CREATE SCHEMA `product_tracker`;

use `product_tracker`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `language`;

SET NAMES 'utf8';

CREATE TABLE `language` (

 `code` char(3) NOT NULL,
 `name` varchar(20) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET= utf8; 

DROP TABLE IF EXISTS `category_translation`;

SET NAMES 'utf8';

CREATE TABLE `category_translation` (
  `type` int(11) NOT NULL,
  `language_code` varchar(128) NOT NULL,
  `title` varchar(128) DEFAULT NULL,
  
  PRIMARY KEY (`type`,`language_code`),
  
  KEY `FK_CATEGORY1_idx` (`type`),
  
  CONSTRAINT `FK_CATEGORY1` 
  FOREIGN KEY (`type`) 
  REFERENCES `category` (`id`), 
  
  KEY `FK_LANGUAGE_codex` (`language_code`),
  
  CONSTRAINT `FK_LANGUAGE` 
  FOREIGN KEY (`language_code`) 
  REFERENCES `language` (`code`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `product`;
SET NAMES 'utf8';
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `code` varchar(256) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

   KEY `FK_CATEGORY2_idx` (`type`),
  
  CONSTRAINT `FK_CATEGORY2` 
  FOREIGN KEY (`type`) 
  REFERENCES `category` (`id`), 

  KEY `FK_PRODUCTSTATUS_idx` (`status_id`),
  
  CONSTRAINT `FK_PRODUCTSTATUS` 
  FOREIGN KEY (`status_id`) 
  REFERENCES `product_status` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `product_status`;
SET NAMES 'utf8';
CREATE TABLE `product_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` ENUM('false', 'true') NOT NULL DEFAULT 'false',
  
  PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  UNIQUE KEY `user_idx_1` (`username`),
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`),
  CONSTRAINT `authorities_ibfk_1`
  FOREIGN KEY (`username`) 
  REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `category` VALUES 
	(1),
	(2);

INSERT INTO `language` VALUES 
	('en','English'),
	('ru','Russian'),
	('arm','Armenian');
    
INSERT INTO `category_translation` VALUES 
	(1,'en','Computer'),
	(1,'ru','Компьютер'),
	(1,'arm','Համակարգիչ'),
    (2,'en','Telephone'),
	(2,'ru','Телефон'),
	(2,'arm','Հեռախոս');
    
    INSERT INTO `product_status` VALUES 
	(1,'false'),
	(2,'false'),
	(3,'false'),
    (4,'false'),
	(5,'false'),
	(6,'false');  
    
INSERT INTO `product` VALUES 
	(1,1,'PC_123',1000,1),
	(2,1,'PC_456',1500,2),
	(3,1,'PC_789',2000,3),
    (4,2,'TL_123',500,4),
	(5,2,'TL_456',600,5),
	(6,2,'TL_789',700,6); 
    
INSERT INTO `users` 
VALUES 
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);
 
INSERT INTO `authorities` 
VALUES 
('john','ROLE_USER'),
('mary','ROLE_USER'),
('susan','ROLE_ADMIN');

  


