/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : pblog

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-04 22:19:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `borrowingbooks`
-- ----------------------------
DROP TABLE IF EXISTS `borrowingbooks`;
CREATE TABLE `borrowingbooks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `p_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowingbooks
-- ----------------------------
INSERT INTO `borrowingbooks` VALUES ('3', '1', '3', '2018-10-14');
INSERT INTO `borrowingbooks` VALUES ('9', '5', '1', '2018-10-16');
INSERT INTO `borrowingbooks` VALUES ('24', '1', '6', '2018-10-30');
INSERT INTO `borrowingbooks` VALUES ('25', '1', '15', '2018-10-31');
INSERT INTO `borrowingbooks` VALUES ('26', '1', '2', '2018-10-31');
INSERT INTO `borrowingbooks` VALUES ('28', '5', '19', '2018-11-03');
INSERT INTO `borrowingbooks` VALUES ('29', '1', '16', '2018-11-04');
INSERT INTO `borrowingbooks` VALUES ('31', '2', '20', '2018-11-04');
