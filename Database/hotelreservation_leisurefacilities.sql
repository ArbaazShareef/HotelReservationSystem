-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelreservation
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `leisurefacilities`
--

DROP TABLE IF EXISTS `leisurefacilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leisurefacilities` (
  `ProductId` varchar(255) NOT NULL,
  `ProductName` varchar(255) DEFAULT NULL,
  `Category` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `HotelName` varchar(255) DEFAULT NULL,
  `Price` varchar(255) DEFAULT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `SQuantity` varchar(255) DEFAULT NULL,
  `RQuantity` varchar(255) DEFAULT NULL,
  `Sales` varchar(255) DEFAULT NULL,
  `Description` varchar(5000) DEFAULT NULL,
  `Accessories` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leisurefacilities`
--

LOCK TABLES `leisurefacilities` WRITE;
/*!40000 ALTER TABLE `leisurefacilities` DISABLE KEYS */;
INSERT INTO `leisurefacilities` VALUES ('0010LF','Hotel3 sauna','LF','Sauna','Hotel3','50','Newyork','Hotel3Sauna.jpg','5','5','250','Hotel3 provides this sauna that is amazing',NULL),('0011LF','Hotel3 Fitness Center','LF','Fitness Center','Hotel3','150','Newyork','Hotel3FitnessCenter.jpg','10','5','1500','Hotel3 provides this sauna that is amazing',NULL),('0012LF','Hotel3  CG Kids Club','LF','CG Kids Club','Hotel3','150','Newyork','Hotel3kidsclub.jpg','10','5','1500','Hotel3 provides this kids club that is amazing',NULL),('001LF','Hotel1 Spa','LF','Indian Style Spa','Hotel1','100','Chicago','Hotel1Spa.jpg','5','10','500','Hotel1 provides this spa that is amazing',NULL),('002LF','Hotel1 Fitness Center','LF','Fitness Center','Hotel1','100','Chicago','Hotel1FitnessCenter.jpg','10','5','1000','Hotel1 provides this fitness center that is amazing',NULL),('003LF','Hotel1  Sauna','LF','Sauna','Hotel1','50','Chicago','Hotel1Sauna.jpg','5','10','250','Hotel1 provides this sauna that is amazing',NULL),('004LF','Hotel1  CG Kids Club','LF','CG Kids Club','Hotel1','10','Chicago','Hotel1kidsclub.jpg','5','10','50','Hotel1 provides this kid club that is amazing ',NULL),('005LF','Hotel2 Spa','LF','Indian Style Spa','Hotel2','150','WashingtonDC','Hotel2Spa.jpg','10','10','1500','Hotel2 provides this spa that is amazing',NULL),('006LF','Hotel2 Fitness Center','LF','Fitness Center','Hotel2','100','WashingtonDC','Hotel2FitnessCenter.jpg','5','10','500','Hotel2 provides this fitness center that is amazing',NULL),('007LF','Hotel2  Sauna','LF','Sauna','Hotel2','50','WashingtonDC','Hotel2Sauna.jpg','5','10','250','Hotel2 provides this sauna that is amazing',NULL),('008LF','Hotel2  CG Kids Club','LF','CG Kids Club','Hotel2','20','WashingtonDC','Hotel2kidsclub.jpg','5','10','100','Hotel2 provides this kid club that is amazing',NULL),('009LF','Hotel3 Spa','LF','Indian Style Spa','Hotel3','100','Newyork','Hotel3Spa.jpg','10','10','1000','Hotel3 provides this spa that is amazing',NULL);
/*!40000 ALTER TABLE `leisurefacilities` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-01 14:26:32
