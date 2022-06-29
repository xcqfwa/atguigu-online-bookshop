/*
 Navicat Premium Data Transfer

 Source Server         : root-localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : online_bookstore

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 29/06/2022 08:25:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE  IF NOT EXISTS `online_bookstore`;;

USE `online_bookstore`;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `sales` int NOT NULL,
  `stock` int NOT NULL,
  `img_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, '解忧杂货店', '东野圭吾', 27.20, 100, 100, 'static/img/1.jpeg');
INSERT INTO `t_book` VALUES (2, '边城', '沈从文', 23.00, 100, 100, 'static/img/2.jpeg');
INSERT INTO `t_book` VALUES (3, '中国哲学史', '冯友兰', 44.50, 100, 100, 'static/img/3.jpeg');
INSERT INTO `t_book` VALUES (4, '忽然七日', ' 劳伦', 19.33, 102, 98, 'static/img/4.jpeg');
INSERT INTO `t_book` VALUES (5, '苏东坡传', '林语堂', 19.30, 102, 98, 'static/img/5.jpeg');
INSERT INTO `t_book` VALUES (6, '百年孤独', '马尔克斯', 29.50, 100, 100, 'static/img/6.jpeg');
INSERT INTO `t_book` VALUES (7, '扶桑', '严歌苓', 19.80, 100, 100, 'static/img/7.jpeg');
INSERT INTO `t_book` VALUES (8, '给孩子的诗', '北岛', 22.20, 100, 100, 'static/img/8.jpeg');
INSERT INTO `t_book` VALUES (9, '为奴十二年', '所罗门', 16.50, 102, 98, 'static/img/9.jpeg');
INSERT INTO `t_book` VALUES (10, '平凡的世界', '路遥', 55.00, 100, 100, 'static/img/10.jpeg');
INSERT INTO `t_book` VALUES (11, '悟空传', '今何在', 14.00, 100, 100, 'static/img/11.jpeg');
INSERT INTO `t_book` VALUES (12, '硬派健身', '斌卡', 31.20, 100, 100, 'static/img/12.jpeg');
INSERT INTO `t_book` VALUES (13, '从晚清到民国', '唐德刚', 39.90, 100, 100, 'static/img/13.jpeg');
INSERT INTO `t_book` VALUES (14, '三体', '刘慈欣', 56.50, 101, 99, 'static/img/14.jpeg');
INSERT INTO `t_book` VALUES (15, '看见', '柴静', 19.50, 100, 100, 'static/img/15.jpeg');
INSERT INTO `t_book` VALUES (16, '活着', '余华', 11.00, 100, 100, 'static/img/16.jpeg');
INSERT INTO `t_book` VALUES (17, '小王子', '安托万', 19.20, 102, 98, 'static/img/17.jpeg');
INSERT INTO `t_book` VALUES (18, '我们仨', '杨绛', 11.30, 100, 100, 'static/img/18.jpeg');
INSERT INTO `t_book` VALUES (19, '生命不息,折腾不止', '罗永浩', 25.20, 100, 100, 'static/img/19.jpeg');
INSERT INTO `t_book` VALUES (20, '皮囊', '蔡崇达', 23.90, 100, 100, 'static/img/20.jpeg');
INSERT INTO `t_book` VALUES (21, '恰到好处的幸福', '毕淑敏', 16.40, 101, 99, 'static/img/21.jpeg');
INSERT INTO `t_book` VALUES (22, '大数据预测', '埃里克', 37.20, 100, 100, 'static/img/22.jpeg');
INSERT INTO `t_book` VALUES (23, '人月神话', '布鲁克斯', 55.90, 100, 100, 'static/img/23.jpeg');
INSERT INTO `t_book` VALUES (24, 'C语言入门经典', '霍尔顿', 45.00, 100, 100, 'static/img/24.jpeg');
INSERT INTO `t_book` VALUES (25, '数学之美', '吴军', 29.90, 100, 100, 'static/img/25.jpeg');
INSERT INTO `t_book` VALUES (26, 'Java编程思想', '埃史尔', 70.50, 101, 99, 'static/img/26.jpeg');
INSERT INTO `t_book` VALUES (27, '设计模式之禅', '秦小波', 20.20, 100, 100, 'static/img/27.jpeg');
INSERT INTO `t_book` VALUES (28, '图解机器学习', '杉山将', 33.80, 100, 100, 'static/img/28.jpeg');
INSERT INTO `t_book` VALUES (29, '艾伦图灵传', '安德鲁', 47.20, 100, 100, 'static/img/29.jpeg');
INSERT INTO `t_book` VALUES (30, '教父', '马里奥普佐', 29.00, 100, 100, 'static/img/30.jpeg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `status` int NOT NULL DEFAULT 0,
  `user_id` int NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `total_price` decimal(11, 2) NULL DEFAULT NULL,
  `count` int NOT NULL,
  `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id` ASC) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', 'admin@admin.com');

SET FOREIGN_KEY_CHECKS = 1;