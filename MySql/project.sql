CREATE DATABASE  IF NOT EXISTS `project` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `project`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	5.6.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attribute_object`
--

DROP TABLE IF EXISTS `attribute_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attribute_object` (
  `type_id` int(11) NOT NULL,
  `attr_id` int(11) NOT NULL,
  PRIMARY KEY (`type_id`,`attr_id`),
  KEY `attr_fk_idx` (`attr_id`),
  CONSTRAINT `obj_fk` FOREIGN KEY (`type_id`) REFERENCES `object_types` (`type_id`) ON UPDATE CASCADE,
  CONSTRAINT `attr_fk` FOREIGN KEY (`attr_id`) REFERENCES `attributes` (`attr_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute_object`
--

LOCK TABLES `attribute_object` WRITE;
/*!40000 ALTER TABLE `attribute_object` DISABLE KEYS */;
INSERT INTO `attribute_object` VALUES (0,0),(0,1),(0,2),(1,2),(2,2),(1,3),(4,4),(2,5),(3,5),(3,6),(2,7),(2,8);
/*!40000 ALTER TABLE `attribute_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attributes`
--

DROP TABLE IF EXISTS `attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attributes` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT,
  `attr_name` varchar(45) NOT NULL,
  `attr_type` varchar(45) NOT NULL,
  PRIMARY KEY (`attr_id`),
  UNIQUE KEY `attr_id_UNIQUE` (`attr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attributes`
--

LOCK TABLES `attributes` WRITE;
/*!40000 ALTER TABLE `attributes` DISABLE KEYS */;
INSERT INTO `attributes` VALUES (0,'first_name','string'),(1,'last_name','string'),(2,'account_number','string'),(3,'title','string'),(4,'service','string'),(5,'card_number','string'),(6,'expiration_date','date'),(7,'pin','int'),(8,'balance','float');
/*!40000 ALTER TABLE `attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bills` (
  `value` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`value`),
  UNIQUE KEY `value_UNIQUE` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (100,33),(500,31),(1000,58),(5000,10);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object_types`
--

DROP TABLE IF EXISTS `object_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `object_types` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`type_id`),
  UNIQUE KEY `type_id_UNIQUE` (`type_id`),
  KEY `object_types_fk_idx` (`parent_id`),
  CONSTRAINT `object_types_fk` FOREIGN KEY (`parent_id`) REFERENCES `object_types` (`type_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object_types`
--

LOCK TABLES `object_types` WRITE;
/*!40000 ALTER TABLE `object_types` DISABLE KEYS */;
INSERT INTO `object_types` VALUES (0,'customer',NULL),(1,'company',NULL),(2,'account',NULL),(3,'card',NULL),(4,'serv_list',NULL);
/*!40000 ALTER TABLE `object_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objects`
--

DROP TABLE IF EXISTS `objects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objects` (
  `obj_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`obj_id`),
  UNIQUE KEY `obj_id_UNIQUE` (`obj_id`),
  KEY `obj_type_fk_idx` (`type_id`),
  KEY `obj_fk_idx` (`parent_id`),
  CONSTRAINT `object_fk` FOREIGN KEY (`parent_id`) REFERENCES `objects` (`obj_id`) ON UPDATE CASCADE,
  CONSTRAINT `obj_type_fk` FOREIGN KEY (`type_id`) REFERENCES `object_types` (`type_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objects`
--

LOCK TABLES `objects` WRITE;
/*!40000 ALTER TABLE `objects` DISABLE KEYS */;
INSERT INTO `objects` VALUES (0,0,NULL),(1,0,NULL),(2,2,NULL),(3,2,NULL),(4,3,NULL),(5,3,NULL),(6,1,7),(7,4,8),(8,4,NULL),(9,3,NULL),(10,2,NULL),(11,1,12),(12,4,13),(13,4,14),(14,4,NULL),(15,3,NULL),(16,2,NULL);
/*!40000 ALTER TABLE `objects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `params`
--

DROP TABLE IF EXISTS `params`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `params` (
  `obj_id` int(11) NOT NULL,
  `attr_id` int(11) NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`obj_id`,`attr_id`),
  KEY `par_attr_fk_idx` (`attr_id`),
  CONSTRAINT `par_attr_fk` FOREIGN KEY (`attr_id`) REFERENCES `attributes` (`attr_id`) ON UPDATE CASCADE,
  CONSTRAINT `par_obj_fk` FOREIGN KEY (`obj_id`) REFERENCES `objects` (`obj_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `params`
--

LOCK TABLES `params` WRITE;
/*!40000 ALTER TABLE `params` DISABLE KEYS */;
INSERT INTO `params` VALUES (0,0,'Ivan'),(0,1,'Ivanov'),(0,2,'42307810590380710235'),(1,0,'Alex'),(1,1,'Vorobyov'),(1,2,'53118810980380710255'),(2,2,'42307810590380710235'),(2,5,'4276123454368010'),(2,7,'165008766'),(2,8,'55195.5'),(3,2,'53118810980380710255'),(3,5,'5469345678901234'),(3,7,'1218695574'),(3,8,'144704.06'),(4,5,'4276123454368010'),(4,6,'2016-07-01'),(5,5,'5469345678901234'),(5,6,'2018-07-01'),(6,2,'67890123456789012345'),(6,3,'SBERBANK'),(7,4,'Repay a loan'),(8,4,'Payment of tax'),(9,5,'4276907890123456'),(9,6,'2019-07-01'),(10,2,'67890123456789012345'),(10,5,'4276907890123456'),(10,7,'-18809919'),(10,8,'1191544.5'),(11,2,'78901234567890123456'),(11,3,'HOUSING'),(12,4,'Pay for electricity'),(13,4,'Pay for water supply'),(14,4,'Pay for gas'),(15,5,'5469901234567890'),(15,6,'2020-01-01'),(16,2,'78901234567890123456'),(16,5,'5469901234567890'),(16,7,'-1689838499'),(16,8,'2001853.5');
/*!40000 ALTER TABLE `params` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-13  1:01:58
