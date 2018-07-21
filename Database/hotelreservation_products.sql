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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `ProductId` text,
  `ProductName` text,
  `Category` text,
  `Type` text,
  `HotelName` text,
  `Price` double DEFAULT NULL,
  `Location` text,
  `Image` text,
  `SQuantity` int(11) DEFAULT NULL,
  `RQuantity` int(11) DEFAULT NULL,
  `Sales` double DEFAULT NULL,
  `Description` text,
  `Accessories` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('0010LF','Park Lane New York sauna','LF','Sauna','Park Lane New York',50,'NewYork','Hotel3Sauna.jpg',5,5,250,'Hotel3 provides this sauna that is amazing','NULL'),('0011LF','Park Lane New York Fitness Center','LF','Fitness Center','Park Lane New York',150,'NewYork','Hotel3FitnessCenter.jpg',10,5,1500,'Hotel3 provides this sauna that is amazing','NULL'),('0012LF','Park Lane New York CG Kids Club','LF','CG Kids Club','Park Lane New York',150,'NewYork','Hotel3kidsclub.jpg',10,5,1500,'Hotel3 provides this kids club that is amazing','NULL'),('001D','Food and Stuff','Dining','Breakfast','Trump Hotel',10,'Chicago','D1.jpg',22,33,220,'Wake up to good food at food and stufff.','NULL'),('001LF','Trump Hotel Spa','LF','Indian Style Spa','Trump Hotel',100,'Chicago','Hotel1Spa.jpg',5,10,500,'Trump Hotel provides this spa that is amazing','NULL'),('001R','Superior001','Room','Superior','Trump Hotel',100,'Chicago','RS1.jpg',10,10,1000,'Trump Hotel provide you with amazing Superior rooms','[001LF,002LF]'),('001S','Trump Hotel Presendential','S','Presendential','Trump Hotel',326,'Chicago','mil_ju.jpg',10,10,3260,'Trump Hotel Provides great services','NULL'),('002D','Eat and Chat','Dining','Lunch','Trump Hotel',20,'Chicago','D2.jpg',20,40,400,'Have a lovely afternoon and our premier restaurant','NULL'),('002LF','Trump Hotel Fitness Center','LF','Fitness Center','Trump Hotel',100,'Chicago','Hotel1FitnessCenter.jpg',10,5,1000,'Trump Hotel provides this fitness center that is amazing','NULL'),('002R','Deluxe002','Room','Deluxe','Trump Hotel',200,'Chicago','RS2.jpg',10,10,2000,'Deluxe Room with all the facilities here at Hotel 2','[001LF,002LF]'),('002S','Trump Hotel Executive ','S','Executive','Trump Hotel ',333,'Chicago','kim_queen.jpg',10,10,3330,'Hotel 1 Provides great service','NULL'),('003D','All you can','Dining','Buffet','Trump Hotel',15,'Chicago','D3.jpg',10,20,150,'Up for a challenge? Come eat all you can here at our buffet.','NULL'),('003LF','Trump Hotel  Sauna','LF','Sauna','Trump Hotel',50,'Chicago','Hotel1Sauna.jpg',5,10,250,'Hotel1 provides this sauna that is amazing','NULL'),('003R','Premier003','Room','Premier','Trump Hotel',250,'Chicago','RS3.jpg',10,10,2500,'Premier rooms only for Premier people, are you one?','[001LF,002LF]'),('003S','Trump Hotel Royal','S','Royal','Trump Hotel',265,'Chicago','kim_jusu.jpg',10,10,2650,'Hotel 1 Provides great service','NULL'),('004D','Pizzaria','Dining','Lunch','Washington Jefferson Hotel',25,'WashingtonDC ','D4.jpg',50,45,1250,'Who doesn\'r love pizza. Come and have on of DC\'s best.','NULL'),('004LF','Trump Hotel  CG Kids Club','LF','CG Kids Club','Trump Hotel',10,'Chicago','Hotel1kidsclub.jpg',5,10,50,'Hotel1 provides this kid club that is amazing ','NULL'),('004R','PremierPlus004','Room','PremierPlus','Trump Hotel',300,'Chicago','RS4.jpg',10,10,3000,'Better than Premier, welcome to Premier Plus Room series','[001LF,002LF]'),('004S','Trump Hotel Imperial','S','Imperial','Trump Hotel',333,'Chicago','gwen_jun.jpg',10,10,3330,'Hotel 1 Provides great service','NULL'),('005D','Heritage','Dining','Dinner','Washington Jefferson Hotel',100,'WashingtonDC ','D5.jpg',60,22,6000,'Heritage is one of DC\'s finest. Named as a must visit restaurant. You would be amazed.','NULL'),('005LF','Washington Jefferson Hotel Spa','LF','Indian Style Spa','Washington Jefferson Hotel',150,'WashingtonDC','Hotel2Spa.jpg',10,10,1500,'Hotel2 provides this spa that is amazing','NULL'),('005R','Superior005','Room','Superior','Washington Jefferson Hotel',100,'WashingtonDC','RS5.jpg',10,10,1000,'Superior room fits best for your needs ','[001LF,002LF]'),('005S','Washington Jefferson Hotel Presendential','S','Presedential','Washington Jefferson Hotel',365,'Washington','gwen_dul.jpg',10,10,3650,'Hotel 2 is amazing','NULL'),('006D','Buffet Place','Dining','Buffet','Washington Jefferson Hotel',150,'WashingtonDC ','D6.jpg',20,44,3000,'Well all you can eat. Is there anything better?','NULL'),('006LF','Washington Jefferson Hotel Fitness Center','LF','Fitness Center','Washington Jefferson Hotel',100,'WashingtonDC','Hotel2FitnessCenter.jpg',5,10,500,'Hotel2 provides this fitness center that is amazing','NULL'),('006R','Deluxe006','Room','Deluxe','Washington Jefferson Hotel',200,'WashingtonDC','RS6.jpg',10,10,2000,'Deluxe rooms for an offordable price, check in!','[001LF,002LF]'),('006S','Washington Jefferson Hotel Executive','S ','Executive','Washington Jefferson Hotel',215,'Washington','felix_du.jpg',10,10,2150,'Hotel 2 is amazing','NULL'),('007D','Dhaba','Dining','Breakfast','Park Lane New York',75,'NewYork','D7.jpg',100,15,7500,'Have a variety at your place, Welcome to Dhaba.','NULL'),('007LF','Washington Jefferson Hotel  Sauna','LF','Sauna','Washington Jefferson Hotel',50,'WashingtonDC','Hotel2Sauna.jpg',5,10,250,'Hotel2 provides this sauna that is amazing','NULL'),('007R','Premier007','Room','Premier','Washington Jefferson Hotel',250,'WashingtonDC','RS7.jpg',10,10,2500,'Premier rooms in Hotel 2','[001LF,002LF]'),('007S ','Washington Jefferson Hotel Royal','S','Royal','Washington Jefferson Hotel',356,'Washington','felix_su.jpg',10,10,3560,'Hotel 2 is amazing','NULL'),('008D','Grill Land','Dining','Lunch','Park Lane New York',100,'NewYork','D8.jpg',25,45,2500,'Welcome to a fantisic cuisine experience. Just have a seat and enjoy.','NULL'),('008LF','Washington Jefferson Hotel  CG Kids Club','LF','CG Kids Club','Washington Jefferson Hotel',20,'WashingtonDC','Hotel2kidsclub.jpg',10,10,200,'Hotel2 provides this kid club that is amazing','NULL'),('008R','PremierPlus008','Room','PremierPlus','Washington Jefferson Hotel',300,'WashingtonDC','RS8.jpg',10,10,3000,'Hotel 2 Premier Plus rooms , Check it out !','[001LF,002LF]'),('008S','Washington Jefferson Hotel Imperial','S ','Imerial','Washington Jefferson Hotel',324,'Washington','kim_queen.jpg',10,10,3240,'Hotel 2 uis amazng','NULL'),('009D','OP Sushi and Seafood','Dining','Buffet','Park Lane New York',50,'NewYork','D9.jpg',30,65,1500,'Know for world class sushi, we have more seafood to complement your taste buds','NULL'),('009LF','Park Lane New York Spa','LF','Indian Style Spa','Park Lane New York',100,'Newyork','Hotel3Spa.jpg',10,10,1000,'Hotel3 provides this spa that is amazing','NULL'),('009R','Superior009','Room','Superior','Park Lane New York',100,'NewYork','RS9.jpg',10,10,1000,'Hotel 3 provide huge Superior rooms','[001LF,002LF]'),('009S','Park Lane New York Presedential','S ','Presedential','Park Lane New York',216,'WashingtonDC','kim_queen.jpg',10,10,2160,'Hotel 3 provides imperial services','NULL'),('010R','Deluxe010','Room','Deluxe','Park Lane New York',200,'NewYork','RS10.jpg',10,10,2000,'Deluxe rooms are amazing only at Hotel 3','[001LF,002LF]'),('010S','Park Lane New York Executive','S','Executive','Park Lane New York',329,'NewYork','gwen_jun.jpg',10,10,3290,'Hotel 3 provides imperial services','NULL'),('011R','Premier011','Room','Premier','Park Lane New York',250,'NewYork','RS11.jpg',10,10,2500,'Premier rooms at Hotel 3 is something you shuould not miss','[001LF,002LF]'),('011S','Park Lane New York Royal','S ','Royal','Park Lane New York',321,'NewYork','felix_du.jpg',10,10,3210,'Hotel 3 provides imperial services','NULL'),('012R','PremierPlus12','Room','PremierPlus','Park Lane New York',300,'NewYork','RS12.jpg',10,10,3000,'Hotel 3 Premier Plus rooms','[001LF,002LF]'),('012S','Park Lane New York Imperial','S','Imperial','Park Lane New York',324,'NewYork','kim_king.jpg',10,10,3240,'Hotel 3 provides imperial services','NULL');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
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
