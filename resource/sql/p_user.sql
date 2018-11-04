/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : pblog

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-04 22:19:53
*/

SET FOREIGN_KEY_CHECKS=0;

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
