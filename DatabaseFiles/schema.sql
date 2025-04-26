-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: BankManagementSystem
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `Acc_Id` int NOT NULL,
  `Acc_Type` varchar(20) DEFAULT NULL,
  `Acc_Status` varchar(20) DEFAULT NULL,
  `Balance` decimal(12,2) DEFAULT NULL,
  `C_Id` int DEFAULT NULL,
  PRIMARY KEY (`Acc_Id`),
  KEY `C_Id` (`C_Id`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`C_Id`) REFERENCES `customer` (`C_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `Adm_Id` int NOT NULL,
  `Adm_Pass` varchar(20) DEFAULT NULL,
  `Adm_Name` varchar(20) DEFAULT NULL,
  `Adm_Email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Adm_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `C_Id` int NOT NULL,
  `C_Name` varchar(30) DEFAULT NULL,
  `Phone_NO` varchar(15) DEFAULT NULL,
  `C_Email` varchar(40) DEFAULT NULL,
  `Date_Of_Birth` date DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Address` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`C_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `Login_Id` int NOT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Paasword` varchar(20) DEFAULT NULL,
  `Role` varchar(10) DEFAULT NULL,
  `C_Id` int DEFAULT NULL,
  PRIMARY KEY (`Login_Id`),
  KEY `C_Id` (`C_Id`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`C_Id`) REFERENCES `customer` (`C_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `Trans_Id` int NOT NULL,
  `Trans_Status` varchar(20) DEFAULT NULL,
  `Trans_Type` varchar(20) DEFAULT NULL,
  `Amount` decimal(12,2) DEFAULT NULL,
  `Trans_Date` date DEFAULT NULL,
  `Acc_ID` int DEFAULT NULL,
  PRIMARY KEY (`Trans_Id`),
  KEY `Acc_ID` (`Acc_ID`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`Acc_ID`) REFERENCES `account` (`Acc_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-26 23:56:01
