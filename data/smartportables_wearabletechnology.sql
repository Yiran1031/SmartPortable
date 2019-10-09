-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: smartportables
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `wearabletechnology`
--

DROP TABLE IF EXISTS `wearabletechnology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wearabletechnology` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(40) DEFAULT NULL,
  `type` varchar(40) DEFAULT NULL,
  `cond` varchar(40) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `num` int(11) DEFAULT '99',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wearabletechnology`
--

LOCK TABLES `wearabletechnology` WRITE;
/*!40000 ALTER TABLE `wearabletechnology` DISABLE KEYS */;
INSERT INTO `wearabletechnology` VALUES ('001w','Garmin',169.99,'garmin.jpg','FitnessWatches','New',10,99),('002w','apple watch nike',279,'applewatch.jpg','FitnessWatches','New',10,99),('003w','FitBit',99.95,'fitbit.jpg','FitnessWatches','New',10,99),('004w','Samsung-galaxy watch',259.99,'samsungwatch.jpg','SmartWatches','new',2,99),('005w','Samsung-gear',299.99,'gear.jpg','SmartWatches','new',100,99),('006w','beats',299.99,'beats.jpg','Headphones','new',100,99),('007w','bose',229.99,'bose.jpg','Headphones','new',30,99),('008w','sony',199.99,'sony.jpg','Headphones','new',0,99),('009w','Oculus Go',249,'oculus.jpg','VirtualReality','new',0,99),('010w','Google Daydream',99,'daydream.jpg','VirtualReality','new',29,99),('011w','PlayStation-VR',349.99,'psvr.jpg','VirtualReality','new',100,99),('012w','Poof',49.99,'poog.jpg','PetTracker','new',0,99);
/*!40000 ALTER TABLE `wearabletechnology` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-20 22:15:10
