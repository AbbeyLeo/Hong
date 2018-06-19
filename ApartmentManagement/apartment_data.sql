/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : apartment

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-11-30 15:36:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `apartment`
-- ----------------------------
DROP TABLE IF EXISTS `apartment`;
CREATE TABLE `apartment` (
  `apart_id` int(30) NOT NULL AUTO_INCREMENT COMMENT '宿舍id标识',
  `apart_code` varchar(30) NOT NULL COMMENT '宿舍号或宿舍名字',
  `apart_category` varchar(30) NOT NULL COMMENT '宿舍男女宿舍类型',
  `apart_build_name` varchar(30) NOT NULL COMMENT '宿舍楼名字',
  `apart_now_person` int(30) DEFAULT '0',
  `apart_max_person` int(30) DEFAULT NULL,
  PRIMARY KEY (`apart_id`),
  KEY `apart_name` (`apart_code`),
  KEY `apart_code` (`apart_code`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apartment
-- ----------------------------
INSERT INTO `apartment` VALUES ('33', 'A101', '男', '艾佛森', '4', '4');
INSERT INTO `apartment` VALUES ('34', 'A102', '男', '艾佛森', '4', '4');
INSERT INTO `apartment` VALUES ('36', 'A103', '男', '艾佛森', '4', '4');
INSERT INTO `apartment` VALUES ('37', 'A104', '男', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('38', 'A105', '男', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('39', 'A106', '男', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('40', 'A107', '男', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('41', 'A108', '男', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('42', 'A109', '男', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('43', 'A201', '女', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('44', 'A202', '女', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('45', 'A203', '女', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('46', 'A204', '女', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('47', 'A205', '女', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('48', 'A206', '女', '艾佛森', '0', '4');
INSERT INTO `apartment` VALUES ('49', 'A207', '女', '艾佛森', '0', '4');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(30) NOT NULL,
  `stu_name` varchar(50) NOT NULL,
  `stu_apart_name` varchar(30) NOT NULL,
  `stu_gender` varchar(10) NOT NULL,
  `stu_date` varchar(30) DEFAULT NULL COMMENT '入住日期',
  PRIMARY KEY (`stu_id`),
  KEY `stu_apart` (`stu_apart_name`),
  CONSTRAINT `stu_apart` FOREIGN KEY (`stu_apart_name`) REFERENCES `apartment` (`apart_code`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1250129521', '猴年的', 'A101', '男', '2017-11-30 15:32:47');
INSERT INTO `student` VALUES ('1250129522', '猴年的', 'A101', '男', '2017-11-30 15:33:03');
INSERT INTO `student` VALUES ('1250129523', '猴年的', 'A101', '男', '2017-11-30 15:33:09');
INSERT INTO `student` VALUES ('1250129524', '猴年的', 'A101', '男', '2017-11-30 15:33:12');
INSERT INTO `student` VALUES ('1250129526', '猴年的', 'A102', '男', '2017-11-30 15:33:35');
INSERT INTO `student` VALUES ('1250129527', '猴年的', 'A102', '男', '2017-11-30 15:33:39');
INSERT INTO `student` VALUES ('1250129528', '猴年的', 'A102', '男', '2017-11-30 15:33:44');
INSERT INTO `student` VALUES ('1250129529', '猴年的', 'A102', '男', '2017-11-30 15:33:51');
INSERT INTO `student` VALUES ('1250129530', '猴年的', 'A103', '男', '2017-11-30 15:34:02');
INSERT INTO `student` VALUES ('1250129531', '猴年的', 'A103', '男', '2017-11-30 15:34:05');
INSERT INTO `student` VALUES ('1250129532', '猴年的', 'A103', '男', '2017-11-30 15:34:08');
INSERT INTO `student` VALUES ('1250129533', '猴年的', 'A103', '男', '2017-11-30 15:34:11');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `limit` int(1) NOT NULL COMMENT '权限',
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'hong', 'hong', '0');
INSERT INTO `user` VALUES ('3', 'test', 'test', '1');
INSERT INTO `user` VALUES ('4', 'admin', 'admina', '0');
