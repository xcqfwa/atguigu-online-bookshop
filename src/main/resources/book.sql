-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: book
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Current Database: `book`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `book` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `book`;

--
-- Table structure for table `t_book`
--

DROP TABLE IF EXISTS `t_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` decimal(11,2) NOT NULL,
  `sales` int NOT NULL,
  `stock` int NOT NULL,
  `img_path` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_book`
--

LOCK TABLES `t_book` WRITE;
/*!40000 ALTER TABLE `t_book` DISABLE KEYS */;
INSERT INTO `t_book` VALUES (1,'解忧杂货店','东野圭吾',27.20,100,100,'static/img/1.jpeg'),(2,'边城','沈从文',23.00,100,100,'static/img/2.jpeg'),(3,'中国哲学史','冯友兰',44.50,100,100,'static/img/3.jpeg'),(4,'忽然七日',' 劳伦',19.33,100,100,'static/img/4.jpeg'),(5,'苏东坡传','林语堂',19.30,100,100,'static/img/5.jpeg'),(6,'百年孤独','马尔克斯',29.50,100,100,'static/img/6.jpeg'),(7,'扶桑','严歌苓',19.80,100,100,'static/img/7.jpeg'),(8,'给孩子的诗','北岛',22.20,100,100,'static/img/8.jpeg'),(9,'为奴十二年','所罗门',16.50,100,100,'static/img/9.jpeg'),(10,'平凡的世界','路遥',55.00,100,100,'static/img/10.jpeg'),(11,'悟空传','今何在',14.00,100,100,'static/img/11.jpeg'),(12,'硬派健身','斌卡',31.20,100,100,'static/img/12.jpeg'),(13,'从晚清到民国','唐德刚',39.90,100,100,'static/img/13.jpeg'),(14,'三体','刘慈欣',56.50,100,100,'static/img/14.jpeg'),(15,'看见','柴静',19.50,100,100,'static/img/15.jpeg'),(16,'活着','余华',11.00,100,100,'static/img/16.jpeg'),(17,'小王子','安托万',19.20,100,100,'static/img/17.jpeg'),(18,'我们仨','杨绛',11.30,100,100,'static/img/18.jpeg'),(19,'生命不息,折腾不止','罗永浩',25.20,100,100,'static/img/19.jpeg'),(20,'皮囊','蔡崇达',23.90,100,100,'static/img/20.jpeg'),(21,'恰到好处的幸福','毕淑敏',16.40,100,100,'static/img/21.jpeg'),(22,'大数据预测','埃里克',37.20,100,100,'static/img/22.jpeg'),(23,'人月神话','布鲁克斯',55.90,100,100,'static/img/23.jpeg'),(24,'C语言入门经典','霍尔顿',45.00,100,100,'static/img/24.jpeg'),(25,'数学之美','吴军',29.90,100,100,'static/img/25.jpeg'),(26,'Java编程思想','埃史尔',70.50,100,100,'static/img/26.jpeg'),(27,'设计模式之禅','秦小波',20.20,100,100,'static/img/27.jpeg'),(28,'图解机器学习','杉山将',33.80,100,100,'static/img/28.jpeg'),(29,'艾伦图灵传','安德鲁',47.20,100,100,'static/img/29.jpeg'),(30,'教父','马里奥普佐',29.00,100,100,'static/img/30.jpeg');
/*!40000 ALTER TABLE `t_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order` (
  `order_id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `total_money` decimal(11,2) NOT NULL,
  `status` int NOT NULL DEFAULT '0',
  `user_id` int NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_item`
--

DROP TABLE IF EXISTS `t_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_money` decimal(11,2) DEFAULT NULL,
  `count` int NOT NULL,
  `order_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_item`
--

LOCK TABLES `t_order_item` WRITE;
/*!40000 ALTER TABLE `t_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','admin','admin@admin.com');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-08 17:17:18
