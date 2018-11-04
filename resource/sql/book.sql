/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : pblog

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-04 22:18:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) DEFAULT NULL,
  `book_author` varchar(20) DEFAULT NULL,
  `book_publish` varchar(20) DEFAULT NULL,
  `book_category` int(11) DEFAULT NULL,
  `book_price` double DEFAULT NULL,
  `book_introduction` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `book_category` (`book_category`),
  CONSTRAINT `book_category` FOREIGN KEY (`book_category`) REFERENCES `book_category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '巨人的陨落', '肯.福莱特', '江苏凤凰文艺出版社', '1', '129', '在第一次世界大战中发生的故事');
INSERT INTO `book` VALUES ('2', '三体', '刘慈欣', '南京大学出版社', '1', '68', '科幻小说');
INSERT INTO `book` VALUES ('3', '复活', '列夫.托尔斯泰', '上海译文出版社', '1', '19', '俄国小说');
INSERT INTO `book` VALUES ('6', '平凡的世界', '路遥', '上海文艺出版社', '1', '88', '孙少平和孙少安两兄弟...');
INSERT INTO `book` VALUES ('15', '白鹿原', '陈忠实', '南京出版社', '1', '36', '当代小说');
INSERT INTO `book` VALUES ('16', '计算机网络', '谢希仁', '电子工业出版社', '3', '49', '计算机专业书籍');
INSERT INTO `book` VALUES ('17', '霍乱时期的爱情', '加西亚·马尔克斯', '译林出版社', '9', '39', '外国小说');
INSERT INTO `book` VALUES ('18', '天才在左疯子在右', '高铭', '北京联合出版公司', '1', '39.8', '心理学');
INSERT INTO `book` VALUES ('19', '废都', '贾平凹', '商务印书馆', '8', '29', '当代小说');
INSERT INTO `book` VALUES ('20', 'jQuery', 'Ryan', '中国电力出版社', '3', '78', 'js库');

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

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '信息工程学院');
INSERT INTO `dept` VALUES ('2', '体育学院');
INSERT INTO `dept` VALUES ('3', '美术学院');
INSERT INTO `dept` VALUES ('4', '电子工程学院');

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

-- ----------------------------
-- Table structure for `p_user`
-- ----------------------------
DROP TABLE IF EXISTS `p_user`;
CREATE TABLE `p_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `user_pwd` varchar(20) DEFAULT NULL,
  `user_email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_user
-- ----------------------------
INSERT INTO `p_user` VALUES ('1', 'yxc', '123456', 'for@163.com');
INSERT INTO `p_user` VALUES ('2', 'zhangfei', '123456', 'forzf@163.com');
INSERT INTO `p_user` VALUES ('5', '李四', '123456', null);
INSERT INTO `p_user` VALUES ('6', 'LeBronJames', '123456', '1111@qq.com');
INSERT INTO `p_user` VALUES ('7', '科比', null, null);
INSERT INTO `p_user` VALUES ('8', '柏拉图', null, null);
INSERT INTO `p_user` VALUES ('9', '拿破仑', null, null);
INSERT INTO `p_user` VALUES ('10', '欧文', null, null);
INSERT INTO `p_user` VALUES ('11', '库兹马', null, null);
INSERT INTO `p_user` VALUES ('12', '球哥', null, null);
INSERT INTO `p_user` VALUES ('13', '魔术师', null, null);
INSERT INTO `p_user` VALUES ('16', '周杰伦', null, null);
