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
-- Table structure for table `customerorders`
--

DROP TABLE IF EXISTS `customerorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customerorders` (
  `OrderId` int(11) NOT NULL,
  `userName` varchar(40) NOT NULL,
  `orderName` varchar(40) NOT NULL,
  `orderPrice` double DEFAULT NULL,
  `userAddress` varchar(40) DEFAULT NULL,
  `creditCardNo` varchar(40) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`OrderId`,`userName`,`orderName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerorders`
--

LOCK TABLES `customerorders` WRITE;
/*!40000 ALTER TABLE `customerorders` DISABLE KEYS */;
INSERT INTO `customerorders` VALUES (1,'customer','fwww',111,'aaa','12333','2018-10-18'),(2,'customer','Smart Watches',399.99,'60616','12345','2018-10-19'),(2,'customer','Virtual Reality',399.99,'aaa','3333','2018-10-19'),(2,'user02','Smart Watches',399.99,'66666','12333','2018-10-19'),(3,'user02','Virtual Reality',399.99,'xxx','11111','2018-10-20'),(4,'user02','Smart Watches',399.99,'sss','11111','2018-10-21'),(5,'user02','Virtual Reality',399.99,'dddd','11111','2018-10-22'),(6,'user02','Virtual Reality',399.99,'sss','1211','2018-10-23'),(7,'customer','Smart Watches',399.99,'aaa','1111','2018-10-23'),(8,'customer','Headphones01',200,'3333','11111','2018-10-23'),(8,'customer','SmartWatches01',250,'3333','11111','2018-10-23'),(9,'customer03','phone7',499,'60661','3333','2018-10-23'),(10,'customer04','SmartWatches01',250,'60661','123333','2018-10-23'),(11,'user02','phone7',499,'60616','11111','2018-10-23'),(12,'user02','phone7',499,'60618','123123','2018-10-23'),(12,'user02','phone8',799,'60618','123123','2018-10-23'),(13,'user02','SmartWatches01',250,'60616','111','2018-10-23'),(14,'user02','SmartWatches01',250,'60614','4782','2018-10-23'),(15,'user02','Headphones01',200,'60613','2777','2018-10-23'),(15,'user02','phone7',499,'60613','2777','2018-10-23'),(16,'user02','Alienware',999,'60616','22222','2018-10-23'),(17,'user02','dell 7900',500,'60612','2222','2018-10-23'),(18,'user02','iphonexs',999,'60661','66666','2018-10-23'),(19,'user02','Alienware',999,'60607','77777777777','2018-10-23'),(20,'user02','Alienware',999,'60607','777777777','2018-10-23'),(21,'user02','iphonexs',999,'60616','22222','2018-10-23'),(22,'user02','dell 7900',500,'60618','6666666','2018-10-23'),(23,'user02','phone8',799,'60616','123','2018-10-23'),(24,'user02','iphonexs',999,'60616','123333','2018-10-25'),(25,'user02','iphonexs',999,'60616','12345','2018-10-25'),(26,'user02','phone7',499,'123','123123','2018-10-26'),(27,'user02','phone7',499,'60616','1231223','2018-10-26'),(28,'user02','iphonexs',999,'test','00000','2018-11-04'),(29,'user02','Phone01',399.99,'test','123455','2018-11-04'),(30,'user02','phone_4',123,'test','11111','2018-11-04'),(31,'user02','Dell-Inspiron 2',849.99,'aaa','1233','2018-11-20'),(32,'customer','Acer',169,'test','1233','2018-11-20'),(32,'customer','beats',299.99,'test','1233','2018-11-20'),(32,'customer','dell 7900',399.99,'test','1233','2018-11-20');
/*!40000 ALTER TABLE `customerorders` ENABLE KEYS */;
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
