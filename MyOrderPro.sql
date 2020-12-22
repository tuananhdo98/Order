CREATE DATABASE  IF NOT EXISTS `MyOrder` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `MyOrder`;
-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: MyOrder
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id` bigint NOT NULL,
  `logo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `subtotal` double DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2evipy1wj5jl73a0nbew0xl9u` (`order_id`),
  KEY `FKinivj2k1370kw224lavkm3rqm` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES (14,NULL,19,2),(15,NULL,20,1),(16,NULL,21,2),(17,NULL,22,1),(18,NULL,23,3),(19,NULL,24,2),(20,NULL,25,3),(21,NULL,26,3),(22,NULL,27,3),(23,NULL,28,8),(24,NULL,29,2),(25,NULL,30,3),(26,NULL,31,1),(27,NULL,32,2),(28,NULL,33,8);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address_order` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `date_order` datetime DEFAULT NULL,
  `get_img` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `into_money` int DEFAULT NULL,
  `name_order` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name_user_order` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `note_order` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `order_number` bigint DEFAULT NULL,
  `order_status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone_number` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `shiping` int DEFAULT NULL,
  `total_number_order` bigint DEFAULT NULL,
  `total_order` int DEFAULT NULL,
  `vat` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
INSERT INTO `order_product` VALUES (21,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-16 23:16:08','extravaganzza.png',79000,'PIZZA 4 VỊ (BIG 4)','Do Anh Tuan','',1,'DANG_XU_LY','3473524284',40000,3,454700,37700),(22,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-16 23:16:08','menu.png',149000,'PIZZA XÚC XÍCH PEPPERONI','Do Anh Tuan','',1,'DANG_XU_LY','3473524284',40000,3,454700,37700),(32,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-17 00:00:28','extravaganzza.png',237000,'PIZZA 4 VỊ (BIG 4)','Nguyen Van Beo','',3,'DANG_XU_LY','0981558607',40000,6,715400,61400),(33,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-17 00:00:28','teriyaki-chicken2-full.png',79000,'PIZZAMIN SEA - HẢI SẢN NHIỆT ĐỚI','Nguyen Van Beo','',1,'DANG_XU_LY','0981558607',40000,6,715400,61400),(23,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-16 23:16:08','thucdon1.png',149000,'PIZZAMIN SEA - HẢI SẢN NHIỆT ĐỚI','Do Anh Tuan','',1,'DANG_XU_LY','3473524284',40000,3,454700,37700),(24,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-16 23:31:43','extravaganzza.png',79000,'PIZZA 4 VỊ (BIG 4)','Nguyen Van Beo','',1,'DANG_XU_LY','3473524284',40000,3,454700,37700),(25,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-16 23:31:43','thucdon1.png',298000,'PIZZAMIN SEA - HẢI SẢN NHIỆT ĐỚI','Nguyen Van Beo','',2,'DANG_XU_LY','3473524284',40000,3,454700,37700),(26,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-16 23:33:35','thucdon1.png',149000,'PIZZAMIN SEA - HẢI SẢN NHIỆT ĐỚI','Nguyen Van Beo','',1,'DANG_XU_LY','0983182312',40000,1,203900,14900),(27,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-16 23:35:55','thucdon1.png',149000,'PIZZAMIN SEA - HẢI SẢN NHIỆT ĐỚI','Nguyễn Kim Châm','Ship now !',1,'DANG_XU_LY','0986686789',40000,1,203900,14900),(31,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-17 00:00:28','menu.png',298000,'PIZZA XÚC XÍCH PEPPERONI','Nguyen Van Beo','',2,'DANG_XU_LY','0981558607',40000,6,715400,61400),(29,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-16 23:44:42','extravaganzza.png',79000,'PIZZA 4 VỊ (BIG 4)','Nguyen Van Beo','nmmnn',1,'DANG_XU_LY','3473524284',40000,3,377700,30700),(30,'Số nhà 83 - Ngõ 72 -  Hoàng Cầu - Ô chợ dừa -  Hà Nội ','2020-12-16 23:44:42','thucdon1.png',149000,'PIZZAMIN SEA - HẢI SẢN NHIỆT ĐỚI','Nguyen Van Beo','nmmnn',1,'DANG_XU_LY','3473524284',40000,3,377700,30700);
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `desciption` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` int DEFAULT NULL,
  `size` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,NULL,'Hải sản tươi ngọt kèm với sốt cà chua hòa quyện với nhau, giúp giải ngán!','menu.png','PIZZA XÚC XÍCH PEPPERONI',149000,NULL,NULL),(2,NULL,'Vừa sang vừa ngon, vừa đã mắt vừa đã miệng, bữa tiệc Thịt Bò phối Hải Sản tươi - không thể tuyệt vời hơn!!','extravaganzza.png','PIZZA 4 VỊ (BIG 4)',79000,NULL,NULL),(3,NULL,'Hải sản tươi ngọt kèm với sốt cà chua hòa quyện với nhau, giúp giải ngán!','thucdon1.png','PIZZAMIN SEA - HẢI SẢN NHIỆT ĐỚI',149000,NULL,NULL),(4,NULL,'Thịt bò lại ăn kèm phô mai Mozzarella thơm béo, hòa quyện cùng 2 loại sốt Cà Chua và Phô Mai thì còn gì bằng. Thịt ngập trong đủ loại sốt và phô mai, chỉ muốn nuốt trọn cả chiếc bánh!!','thucdon4.png','PRIME BEEF - PIZZA BÒ MÊ-HI-CÔ THƯỢNG HẠNG',149000,NULL,NULL),(5,NULL,'Hương vị truyền thống của đất nước Ý, hương vị pizza ngất ngây đã qua bao thế hệ, nhưng vẫn không hề mất điểm trong lòng những fan cứng của pizza.','360x240-(1).png','PIZZA PHỞ',149000,NULL,NULL),(6,NULL,'Vừa sang vừa ngon, vừa đã mắt vừa đã miệng, bữa tiệc Thịt Bò phối Hải Sản tươi - không thể tuyệt vời hơn!!','1-nữa-min.png','PIZZA XÚC XÍCH PEPPERONI',79000,NULL,NULL),(7,NULL,'Hải sản tươi ngọt kèm với sốt cà chua hòa quyện với nhau, giúp giải ngán!','extravaganzza.png','PRIDE BIKE SHORTS',79000,NULL,NULL),(8,NULL,'Hải sản tươi ngọt kèm với sốt cà chua hòa quyện với nhau, giúp giải ngán!','teriyaki-chicken2-full.png','PIZZAMIN SEA - HẢI SẢN NHIỆT ĐỚI',79000,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'USER'),(3,'ASSISTANT');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizecake`
--

DROP TABLE IF EXISTS `sizecake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sizecake` (
  `id` bigint NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizecake`
--

LOCK TABLES `sizecake` WRITE;
/*!40000 ALTER TABLE `sizecake` DISABLE KEYS */;
INSERT INTO `sizecake` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `sizecake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `fisrtname` varchar(30) COLLATE utf8_bin NOT NULL,
  `lastname` varchar(30) COLLATE utf8_bin NOT NULL,
  `password` varchar(64) COLLATE utf8_bin NOT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2020-12-16 21:28:00','tuandaph05012@fpt.edu.vn',_binary '','Do Anh','Tuan','$2a$10$lorLwcsidmV.GooCNIMGJ.PRw39lgd89nZPHjg0gRuT1DhUCaODZC',NULL),(2,'2020-12-16 21:32:35','nguoidung@gmail.com',_binary '','Nguyễn Thị','Hoa','$2a$10$iR.ii2KHfIsZDPFyEJAfJu96yEybZz7WyFMWQbYdttrP/bajctqxG',NULL),(3,'2020-12-16 21:33:14','banhang@gmail.com',_binary '','Phùng Chí','Thành','$2a$10$fuIluQYp5nLVizDKTPDjtu171r7gUxJdlqgSsibjJeI3Q53yCYjke',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'MyOrder'
--

--
-- Dumping routines for database 'MyOrder'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-17 12:06:52
