/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : pblog

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-04 22:19:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `p_admin`
-- ----------------------------
DROP TABLE IF EXISTS `p_admin`;
CREATE TABLE `p_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) DEFAULT NULL,
  `admin_pwd` varchar(20) DEFAULT NULL,
  `admin_email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_admin
-- ----------------------------
INSERT INTO `p_admin` VALUES ('1', 'admin', 'root', '1324688478@qq.com');
