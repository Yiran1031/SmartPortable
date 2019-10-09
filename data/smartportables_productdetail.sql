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
-- Table structure for table `productdetail`
--

DROP TABLE IF EXISTS `productdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productdetail` (
  `ProductType` varchar(40) NOT NULL,
  `Id` varchar(45) NOT NULL,
  `productName` varchar(45) DEFAULT NULL,
  `productPrice` double DEFAULT NULL,
  `productImage` varchar(45) DEFAULT NULL,
  `productManufacturer` varchar(45) DEFAULT NULL,
  `productCondition` varchar(45) DEFAULT NULL,
  `ProductDiscount` varchar(45) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProductType`,`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdetail`
--

LOCK TABLES `productdetail` WRITE;
/*!40000 ALTER TABLE `productdetail` DISABLE KEYS */;
INSERT INTO `productdetail` VALUES ('FitnessWatches','001w','Garmin',169.99,'garmin.jpg','smartportables','New','10.0',99),('FitnessWatches','002w','apple watch nike',279,'applewatch.jpg','smartportables','New','10.0',99),('FitnessWatches','003w','FitBit',99.95,'fitbit.jpg','smartportables','New','10.0',99),('Headphones','006w','beats',299.99,'beats.jpg','smartportables','new','100.0',99),('Headphones','007w','bose',229.99,'bose.jpg','smartportables','new','30.0',99),('Headphones','008w','sony',199.99,'sony.jpg','smartportables','new','0.0',99),('Laptops','001l','Dell-Inspiron 2',849.99,'inspiron.jpg','smartportables','New','100.0',98),('Laptops','002l','Pixelbook',999,'pixelbook.jpg','smartportables','New','300.0',99),('Laptops','004l','SamsungPlus2',499,'samsung.jpg','smartportables','New','150.0',99),('Laptops','005l','Acer',169,'acer.jpg','smartportables','New','30.0',98),('Laptops','006l','dell 7900',399.99,'7900.jpg','smartportables','New','10.0',98),('Laptops','007l','ASUS',399.99,'asus.jpg','smartportables','New','10.0',99),('PetTracker','012w','Poof',49.99,'poog.jpg','smartportables','new','0.0',99),('Phone','001p','GalaxyS9',719.99,'galaxy.jpg','smartportables','new','200.0',99),('Phone','002p','LG-stylo4',299.99,'stylo.jpg','smartportables','new','90.0',209),('Phone','003p','MotoG6',249.99,'moto.jpg','smartportables','new','50.0',99),('Phone','004p','Nokia',229.99,'nokia.jpg','smartportables','New','0.0',99),('Phone','006p','IphoneX',888,'iphoneX.jpg','smartportables','new','100.0',99),('SmartWatches','004w','Samsung-galaxy watch',259.99,'samsungwatch.jpg','smartportables','new','2.0',99),('SmartWatches','005w','Samsung-gear',299.99,'gear.jpg','smartportables','new','100.0',99),('VirtualReality','009w','Oculus Go',249,'oculus.jpg','smartportables','new','0.0',99),('VirtualReality','010w','Google Daydream',99,'daydream.jpg','smartportables','new','29.0',99),('VirtualReality','011w','PlayStation-VR',349.99,'psvr.jpg','smartportables','new','100.0',99),('VoiceAssistant','001v','lenovo',99.99,'lenovo_va.jpg','smartportables','New','10.0',99),('VoiceAssistant','002v','Echo',49.99,'echo.jpg','smartportables','New','10.0',99),('VoiceAssistant','003v','Google Home',129,'google_home.jpg','smartportables','New','10.0',99),('VoiceAssistant','004v','Echo Show',229.99,'echoshow.jpg','smartportables','New','15.0',99);
/*!40000 ALTER TABLE `productdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-20 22:15:09
