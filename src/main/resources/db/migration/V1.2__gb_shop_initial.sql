-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gb-shop
-- ------------------------------------------------------
-- Server version	8.0.22

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(250) NOT NULL DEFAULT 'none',
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;

INSERT INTO `product` VALUES (1,'milk',6),(2,'bread',4),(3,'chocolate',7),(4,'tomato',15),(5,'potato',5),(6,'apples',16),(7,'beer',5),(8,'cheese',50),(9,'brandy',60),(10,'fish',24),(11,'crekers',10),(12,'ice cream',6),(13,'juce',9),(14,'butter',12),(15,'meat',45),(16,'eggs',6),(17,'chicken',22),(18,'kandies',32),(19,'sugar',5),(20,'salt',2),(21,'pepper',3),(22,'Yoghurt',7),(23,'Cake',15);

UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;

INSERT INTO `roles` VALUES (1,'ROLE_EMPLOYEE'),(2,'ROLE_MANAGER'),(3,'ROLE_ADMIN');

UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `enabled` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES (1,'admin','$2y$12$1ZWRy1ZMMaoZfJ8AQc4eZ.OI93nvv6XA0d2AQYimx51WnkBQEtP4K',1),(2,'user','$2y$12$h567nKuTuC2t9Rverw77V.63bbJv9ej5ow1cPCqkGEDRUk6kYIoc2',1);

UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_ID` (`role_id`),
  CONSTRAINT `FK_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FK_USER_ID_01` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;

INSERT INTO `users_roles` VALUES (1,1),(2,1),(1,2),(1,3);

UNLOCK TABLES;
