-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.7.3-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for money
CREATE DATABASE IF NOT EXISTS `money` /*!40100 DEFAULT CHARACTER SET utf32 COLLATE utf32_vietnamese_ci */;
USE `money`;

-- Dumping structure for table money.budget
CREATE TABLE IF NOT EXISTS `budget` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `budget_time` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `create_at` datetime DEFAULT current_timestamp(),
  `update_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `FK_budget_category` (`category_id`),
  KEY `FK_budget_user` (`user_id`),
  CONSTRAINT `FK_budget_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_budget_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- Dumping data for table money.budget: ~0 rows (approximately)
/*!40000 ALTER TABLE `budget` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget` ENABLE KEYS */;

-- Dumping structure for table money.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `icon` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_at` datetime DEFAULT current_timestamp(),
  `update_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `FK_c_user` (`user_id`),
  CONSTRAINT `FK_c_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- Dumping data for table money.category: ~9 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `user_id`, `name`, `icon`, `type`, `create_at`, `update_at`) VALUES
	(1, NULL, 'Ăn uống', 'coffee', 0, '2023-02-10 16:20:51', '2023-02-10 16:55:14'),
	(2, NULL, 'Chi tiêu hàng ngày', 'shopping-cart', 0, '2023-02-10 16:21:14', '2023-02-10 16:46:51'),
	(3, NULL, 'Quần áo', 'skin', 0, '2023-02-10 16:21:20', '2023-02-10 16:46:16'),
	(4, NULL, 'Tiền lãi', 'bank', 1, '2023-02-10 16:44:32', '2023-02-10 16:57:45'),
	(5, NULL, 'Đi lại', 'car', 0, '2023-02-10 16:21:38', '2023-02-10 16:48:40'),
	(6, NULL, 'Y tế', 'medicine-bo', 0, '2023-02-10 16:21:50', '2023-02-10 16:58:10'),
	(7, NULL, 'Giáo dục', 'read', 0, '2023-02-10 16:22:04', '2023-02-10 17:02:46'),
	(8, NULL, 'Tiền nhà', 'home', 0, '2023-02-10 16:22:14', '2023-02-10 16:54:06'),
	(9, NULL, 'Phí liên lạc', 'phone', 0, '2023-02-10 16:22:25', '2023-02-10 17:02:10'),
	(10, NULL, 'Trả nợ', 'dollar-circle', 0, '2023-02-10 16:43:09', '2023-02-10 16:54:52'),
	(11, NULL, 'Tiền lương', 'wallet', 1, '2023-02-10 16:43:22', '2023-02-10 17:00:51'),
	(12, NULL, 'Tiền phụ cấp', 'send', 1, '2023-02-10 16:43:39', '2023-02-10 17:01:20'),
	(13, NULL, 'Tiền thưởng', 'gift', 1, '2023-02-10 16:43:47', '2023-02-10 16:59:28'),
	(14, NULL, 'Vay', 'transaction', 1, '2023-02-10 16:44:06', '2023-02-10 16:59:25');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table money.transaction
CREATE TABLE IF NOT EXISTS `transaction` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `wallet_id` int(11) DEFAULT NULL,
  `user_category_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `note` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `create_at` datetime DEFAULT current_timestamp(),
  `update_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `FK_tr_user` (`user_id`),
  KEY `FK_tr_wallet` (`wallet_id`),
  KEY `FK_transaction_category` (`user_category_id`),
  CONSTRAINT `FK_tr_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tr_wallet` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_transaction_category` FOREIGN KEY (`user_category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- Dumping data for table money.transaction: ~0 rows (approximately)
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;

-- Dumping structure for table money.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `role` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `create_at` datetime DEFAULT current_timestamp(),
  `update_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- Dumping data for table money.user: ~0 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table money.user_info
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `first_name` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `last_name` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `sex` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `phone_number` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `date_of_birth` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `update_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `FK__user` (`user_id`),
  CONSTRAINT `FK__user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- Dumping data for table money.user_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

-- Dumping structure for table money.wallet
CREATE TABLE IF NOT EXISTS `wallet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `wallet_name` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `create_at` datetime DEFAULT current_timestamp(),
  `update_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `FK_w_user` (`user_id`),
  CONSTRAINT `FK_w_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- Dumping data for table money.wallet: ~0 rows (approximately)
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
