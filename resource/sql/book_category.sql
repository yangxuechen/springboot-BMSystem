/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : pblog

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-04 22:19:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book_category`
-- ----------------------------
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_category
-- ----------------------------
INSERT INTO `book_category` VALUES ('1', '小说');
INSERT INTO `book_category` VALUES ('2', '历史');
INSERT INTO `book_category` VALUES ('3', '计算机');
INSERT INTO `book_category` VALUES ('4', '哲学');
INSERT INTO `book_category` VALUES ('5', '社会科学');
INSERT INTO `book_category` VALUES ('6', '政治法律');
INSERT INTO `book_category` VALUES ('7', '军事科学');
INSERT INTO `book_category` VALUES ('8', '中国文学');
INSERT INTO `book_category` VALUES ('9', '外国文学');
INSERT INTO `book_category` VALUES ('10', '外国传记');
INSERT INTO `book_category` VALUES ('11', '英语');
INSERT INTO `book_category` VALUES ('12', '俄国小说');
INSERT INTO `book_category` VALUES ('13', '心理学');
INSERT INTO `book_category` VALUES ('14', '言情小说');
INSERT INTO `book_category` VALUES ('15', '武侠小说');
INSERT INTO `book_category` VALUES ('16', '环境科学');
INSERT INTO `book_category` VALUES ('17', '纪实文学');
