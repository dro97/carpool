-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: carpool
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carpool_users`
--

DROP TABLE IF EXISTS `carpool_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `carpool_users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `university` varchar(45) DEFAULT NULL,
  `user_type` varchar(45) DEFAULT NULL,
  `register_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `usercode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carpool_users`
--

LOCK TABLES `carpool_users` WRITE;
/*!40000 ALTER TABLE `carpool_users` DISABLE KEYS */;
INSERT INTO `carpool_users` VALUES (1,'jesus28','nameTest',NULL,NULL,NULL,'1','2020-04-09 00:23:14','tesJesus',NULL,'ANDFJAWEF'),(2,'jsol','joseluis','testLast',NULL,NULL,'1','2020-04-09 00:42:00','testEmail',NULL,'JKSHDGUWE'),(3,'dro','test48','testLast',NULL,NULL,'1','2020-04-09 00:43:08','testEmail',NULL,'2342523'),(4,NULL,NULL,'lastname',NULL,NULL,NULL,'2020-04-09 01:28:44','testEmail',NULL,'3423'),(5,NULL,NULL,'lastname',NULL,NULL,NULL,'2020-04-09 01:32:15','testEmail',NULL,NULL),(6,NULL,NULL,'lastname',NULL,NULL,NULL,'2020-04-09 01:56:08','testEmail',NULL,NULL),(7,'jose123','Jose','Perez','30303030','UVM','2','2020-04-11 07:24:13','jose@gmail.com',NULL,'fkejntovmmdliuf'),(8,'ferguz','Fernado','Rojas','23423532','UVM','1','2020-04-11 07:57:53','ferguz@gmail.com',NULL,'xypupzircpfkztg'),(9,'ferguz2','Fernado2','Rojas2','a3423da','UVM','1','2020-04-11 07:58:31','ferguz2@gmail.com',NULL,'pwrlvqebzhnwgyn'),(10,'Albert','Alberto','Rojas','23453434gdsfgdf','UVM','1','2020-04-11 19:23:14','albert@gmail.com',NULL,'TJZCNRAAZJIFKDE'),(11,'Albert2','Alberto2','Rojas2','23453434gdsfgdf','UVM','2','2020-04-11 19:28:18','albert2@gmail.com',NULL,'WHWYMWWYRAPCRGG'),(12,'Albert3','Alberto3','Rojas2','23453434gdsfgdf','UVM','1','2020-04-11 19:53:51','albert3@gmail.com',NULL,'RKZGAHUSRICWFUW'),(13,'Albert4','Alberto4','Rojas2','23453434gdsfgdf','UVM','1','2020-04-11 19:55:20','albert4@gmail.com',NULL,'VFLYWDSOOPSIHBV'),(14,'Roberto22','Roberto','Jasta','dfaf23f','UVM','1','2020-04-11 19:56:06','robert@gmail.com',NULL,'QUEXTWIRGRRQAQR'),(15,'Roberto222','Roberto','Jasta','dfaf23f','UVM','1','2020-04-11 19:56:21','robert2@gmail.com',NULL,'IMOUTIXHATAHABR'),(16,'maick','Miguel','Rodriguez','5234523453425','UVM','2','2020-04-11 21:46:50','mike@gmail.com',NULL,'MVWGRKDICGHFYLN'),(17,'maick2','Miguel','Rodriguez','5234523453425','UVM','2','2020-04-11 21:52:36','mike2@gmail.com','HOLI123','KNSMTWBTMMWTKNB'),(18,'ferguzbo','Fernando','Rodrigo','332523523','UVM','2','2020-04-12 06:11:58','ferguzbo@gmail.com',NULL,'WUYDTJGNPNQWEMJ'),(19,'Jorge2','Jorge','Perez',NULL,'UVM','1','2020-04-12 20:08:07','jorge@gmail.com','34534dfgdf','JROPITGTZGNPYHX');
/*!40000 ALTER TABLE `carpool_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extra_info`
--

DROP TABLE IF EXISTS `extra_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `extra_info` (
  `id_extra` int(11) NOT NULL AUTO_INCREMENT,
  `recomendations` varchar(45) DEFAULT NULL,
  `descriptions` varchar(45) DEFAULT NULL,
  `extra_info_id_extra` int(11) NOT NULL,
  PRIMARY KEY (`id_extra`,`extra_info_id_extra`),
  KEY `fk_carpool_users_extra_info_idx` (`extra_info_id_extra`),
  CONSTRAINT `fk_carpool_users_extra_info` FOREIGN KEY (`extra_info_id_extra`) REFERENCES `carpool_users` (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra_info`
--

LOCK TABLES `extra_info` WRITE;
/*!40000 ALTER TABLE `extra_info` DISABLE KEYS */;
INSERT INTO `extra_info` VALUES (1,'testRecomendaciones','test',4),(2,'testRecomendaciones','test',6);
/*!40000 ALTER TABLE `extra_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participations`
--

DROP TABLE IF EXISTS `participations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `participations` (
  `idparticipations` int(11) NOT NULL AUTO_INCREMENT,
  `carpool_users_idusers` int(11) NOT NULL,
  `rides_idrides` int(11) NOT NULL,
  PRIMARY KEY (`idparticipations`,`carpool_users_idusers`,`rides_idrides`),
  KEY `fk_carpool_users_has_rides_rides1_idx` (`rides_idrides`),
  KEY `fk_carpool_users_has_rides_carpool_users1_idx` (`carpool_users_idusers`),
  CONSTRAINT `fk_carpool_users_has_rides_carpool_users1` FOREIGN KEY (`carpool_users_idusers`) REFERENCES `carpool_users` (`idusers`),
  CONSTRAINT `fk_carpool_users_has_rides_rides1` FOREIGN KEY (`rides_idrides`) REFERENCES `rides` (`idrides`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participations`
--

LOCK TABLES `participations` WRITE;
/*!40000 ALTER TABLE `participations` DISABLE KEYS */;
INSERT INTO `participations` VALUES (1,1,1),(2,2,1),(3,3,1),(6,3,1),(7,8,1),(4,7,2),(5,3,2),(8,7,7),(10,1,7),(11,2,7),(12,3,7),(13,8,7),(9,11,8),(14,10,8),(15,12,8),(16,14,8),(17,15,8),(18,18,9),(19,11,10),(20,18,11);
/*!40000 ALTER TABLE `participations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rides`
--

DROP TABLE IF EXISTS `rides`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rides` (
  `idrides` int(11) NOT NULL AUTO_INCREMENT,
  `ride_date` timestamp NULL DEFAULT NULL,
  `origin` varchar(45) DEFAULT NULL,
  `destiny` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `ridercode` varchar(45) DEFAULT NULL,
  `ridecode` varchar(100) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrides`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rides`
--

LOCK TABLES `rides` WRITE;
/*!40000 ALTER TABLE `rides` DISABLE KEYS */;
INSERT INTO `rides` VALUES (1,'2008-06-01 01:06:50','Juriquilla','Alameda','description Test','8877','1111',NULL),(2,'2020-04-14 20:10:10','UVM','Bernardo Quintana','Los Espero en tal lugar y paso por de febrearo','fkejntovmmdliuf','2222',NULL),(7,'2020-04-11 20:10:10','UVM','Bernardo Quintana','Los Espero en tal lugar y paso por de febrearo','fkejntovmmdliuf','7777','CREADO'),(8,'2020-04-11 20:10:10','UVM','Bernardo Quintana','Los Espero en tal lugar y paso por de febrearo','WHWYMWWYRAPCRGG','8888','CREADO'),(9,'2020-04-12 20:10:10','mi casa','la plaza','El ferguz es hacker','WUYDTJGNPNQWEMJ','9999','CREADO'),(10,'2020-04-13 20:10:10','mi casa','la plaza','El ferguz es hacker','WHWYMWWYRAPCRGG','09051f6e-60d9-4130-9603-df46c178227f','CREADO'),(11,'2020-04-13 20:10:10','mi casa','la plaza','El ferguz es hacker','WUYDTJGNPNQWEMJ','da33bdad-3c7f-4332-99b1-bebd5b68c376','CREADO');
/*!40000 ALTER TABLE `rides` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_admins`
--

DROP TABLE IF EXISTS `system_admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `system_admins` (
  `idamdin` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idamdin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_admins`
--

LOCK TABLES `system_admins` WRITE;
/*!40000 ALTER TABLE `system_admins` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'carpool'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-14 19:49:54
