-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.18 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5174
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for hibernate
CREATE DATABASE IF NOT EXISTS `hibernate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hibernate`;

-- Dumping structure for table hibernate.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(38) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `age` varchar(50) DEFAULT NULL COMMENT '年龄',
  `address` varchar(138) DEFAULT NULL COMMENT '地址',
  `sex` varchar(50) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table hibernate.user: ~5 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `password`, `age`, `address`, `sex`) VALUES
	(2, 'z', 'z', '2', 'z', 'man'),
	(3, 'a20171009', 'b', 'c', 'd', 'e'),
	(4, 'xaasdfasdf', 'y', '4', 'a', 'man'),
	(5, 'x', 'y', 'z', 'a', 'man'),
	(6, 'x', 'y', 'z', 'a', 'man'),
	(7, 'x', 'y', 'z', 'a', 'man');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
