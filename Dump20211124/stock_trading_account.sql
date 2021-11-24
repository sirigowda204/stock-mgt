-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: stock
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `trading_account`
--

DROP TABLE IF EXISTS `trading_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trading_account` (
  `account_number` int NOT NULL,
  `funds` decimal(10,2) NOT NULL,
  `portfolio_value` decimal(10,2) NOT NULL,
  `tax` decimal(10,2) NOT NULL,
  `net_profit` decimal(10,2) NOT NULL,
  `b_id` int NOT NULL,
  `trader_id` int NOT NULL,
  PRIMARY KEY (`account_number`),
  UNIQUE KEY `account_number` (`account_number`),
  KEY `b_id` (`b_id`),
  KEY `trader_id` (`trader_id`),
  CONSTRAINT `trading_account_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `broker` (`b_id`),
  CONSTRAINT `trading_account_ibfk_2` FOREIGN KEY (`trader_id`) REFERENCES `trader` (`trader_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trading_account`
--

LOCK TABLES `trading_account` WRITE;
/*!40000 ALTER TABLE `trading_account` DISABLE KEYS */;
INSERT INTO `trading_account` VALUES (1111,155000.60,230000.10,10588.23,60000.00,321,6755),(1234,105000.30,230000.20,8823.53,50000.00,117,5511),(5533,400000.20,280000.80,12253.29,75000.00,192,7890),(6345,350000.53,120000.90,3529.41,20000.00,101,4532),(6578,50000.21,180000.20,12352.94,70000.00,101,5544),(7345,80000.32,16000.20,705.88,4000.00,117,8745),(9753,200000.30,420000.70,15882.35,90000.00,203,9876),(9987,120000.30,100000.26,4411.76,25000.00,245,8463);
/*!40000 ALTER TABLE `trading_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-24 20:42:46
