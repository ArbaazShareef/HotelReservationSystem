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
-- Table structure for table `dining`
--

DROP TABLE IF EXISTS `dining`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dining` (
  `ProductId` varchar(250) NOT NULL,
  `ProductName` varchar(250) DEFAULT NULL,
  `Category` varchar(250) DEFAULT NULL,
  `Type` varchar(250) DEFAULT NULL,
  `HotelName` varchar(250) DEFAULT NULL,
  `Price` varchar(250) DEFAULT NULL,
  `Location` varchar(250) DEFAULT NULL,
  `Image` varchar(250) DEFAULT NULL,
  `SQunatity` varchar(250) DEFAULT NULL,
  `RQuantity` varchar(250) DEFAULT NULL,
  `Sales` varchar(250) DEFAULT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  `Accessories` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dining`
--

LOCK TABLES `dining` WRITE;
/*!40000 ALTER TABLE `dining` DISABLE KEYS */;
INSERT INTO `dining` VALUES ('001D','Food and Stuff','Dining','Breakfast','Hotel 1','10','Chicago','D1.png','22','33','220','Wake up to good food at food and stufff.',NULL),('002D','Eat and Chat','Dining','Lunch','Hotel 1','20','Chicago','D2.png','20','40','400','Have a lovely afternoon and our premier restaurant',NULL),('003D','All you can','Dining','Buffet','Hotel 1','15','Chicago','D3.png','10','20','150','Up for a challenge? Come eat all you can here at our buffet.',NULL),('004D','Pizzaria','Dining','Lunch','Hotel 2','25','WashingtonDC ','D4.png','50','45','1250','Who doesn\'r love pizza. Come and have on of DC\'s best.',NULL),('005D','Heritage','Dining','Dinner','Hotel 2','100','WashingtonDC ','D5.png','60','22','6000','Heritage is one of DC\'s finest. Named as a must visit restaurant. You would be amazed.',NULL),('006D','Buffet Place','Dining','Buffet','Hotel 2','150','WashingtonDC ','D6.png','20','44','3000','Well all you can eat. Is there anything better?',NULL),('007D','Dhaba','Dining','Breakfast','Hotel 3','75','NewYork','D7.png','100','15','7500','Have a variety at your place, Welcome to Dhaba.',NULL),('008D','Grill Land','Dining','Lunch','Hotel 3','100','NewYork','D8.png','25','45','2500','Welcome to a fantisic cuisine experience. Just have a seat and enjoy.',NULL),('009D','OP Sushi and Seafood','Dining','Buffet','Hotel 3','50','NewYork','D9.png','30','65','1500','Know for world class sushi, we have more seafood to complement your taste buds',NULL);
/*!40000 ALTER TABLE `dining` ENABLE KEYS */;
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
