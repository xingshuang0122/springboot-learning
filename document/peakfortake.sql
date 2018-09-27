/*
Navicat MySQL Data Transfer

Source Server         : shuang
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : peakfortake

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-09-27 13:24:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '北京', '北京');
INSERT INTO `address` VALUES ('2', '天津', '天津');
INSERT INTO `address` VALUES ('3', '安徽', '宿州');
INSERT INTO `address` VALUES ('4', '广东', '广州');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', 'green', '路虎', '1');
INSERT INTO `car` VALUES ('2', 'white', '奔驰', '2');
INSERT INTO `car` VALUES ('3', 'blue', '玛莎拉蒂', '4');
INSERT INTO `car` VALUES ('4', 'yellow', '兰博基尼', '4');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'baby', '1');
INSERT INTO `person` VALUES ('2', 'kingboy', '2');
INSERT INTO `person` VALUES ('3', 'boy', '3');
INSERT INTO `person` VALUES ('4', 'kingbaby', '4');

-- ----------------------------
-- Table structure for testuser
-- ----------------------------
DROP TABLE IF EXISTS `testuser`;
CREATE TABLE `testuser` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testuser
-- ----------------------------
INSERT INTO `testuser` VALUES ('1', '心慌', '阿红公开号个客户能够in哦个按哦该');
INSERT INTO `testuser` VALUES ('2', '哈哈哈', '嗯嗯');
INSERT INTO `testuser` VALUES ('3', 'xxxxx', '11');
INSERT INTO `testuser` VALUES ('10', 'xing', '阿克江华工科技阿婆精品街安平街');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test', '222');
INSERT INTO `user` VALUES ('2', 'sfs', '213');
INSERT INTO `user` VALUES ('3', '测试', '123456');
INSERT INTO `user` VALUES ('4', 'xing', '77');
INSERT INTO `user` VALUES ('11', '水电费', 'dasf');
