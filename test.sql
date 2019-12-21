/*
Navicat MySQL Data Transfer

Source Server         : sql
Source Server Version : 50018
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-12-20 21:55:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data` (
  `tid` int(11) NOT NULL auto_increment,
  `thing` varchar(255) NOT NULL,
  `time` int(11) NOT NULL,
  PRIMARY KEY  (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES ('1', '打架', '500');
INSERT INTO `data` VALUES ('2', '打架', '500');
INSERT INTO `data` VALUES ('3', '打架啊', '100');
INSERT INTO `data` VALUES ('4', '洛海峡', '50');
INSERT INTO `data` VALUES ('5', '李金明', '500');
INSERT INTO `data` VALUES ('1014', '水水水水', '111');
INSERT INTO `data` VALUES ('1015', '顶顶顶顶', '222');
INSERT INTO `data` VALUES ('1016', '顶顶顶顶', '222');
INSERT INTO `data` VALUES ('1017', 'uuu', '10');
INSERT INTO `data` VALUES ('1018', 'uuu', '10');
INSERT INTO `data` VALUES ('1019', '噢噢噢噢', '7200');
INSERT INTO `data` VALUES ('1020', '顶顶顶顶', '222');
INSERT INTO `data` VALUES ('1021', '顶顶顶顶', '222');
INSERT INTO `data` VALUES ('1022', '学习', '900');
INSERT INTO `data` VALUES ('1023', '学习', '900');
INSERT INTO `data` VALUES ('1024', '学习', '900');
INSERT INTO `data` VALUES ('1025', '噢噢噢噢', '7200');
INSERT INTO `data` VALUES ('1026', '水水水水', '111');
INSERT INTO `data` VALUES ('1027', '学习', '900');

-- ----------------------------
-- Table structure for thing
-- ----------------------------
DROP TABLE IF EXISTS `thing`;
CREATE TABLE `thing` (
  `tid` int(11) NOT NULL auto_increment,
  `uid` int(11) default NULL,
  `thing` varchar(255) default NULL,
  `time` varchar(255) default NULL,
  PRIMARY KEY  (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of thing
-- ----------------------------
INSERT INTO `thing` VALUES ('25', '1013', '顶顶顶顶', '222');
INSERT INTO `thing` VALUES ('26', '1013', '水水水水', '111');
INSERT INTO `thing` VALUES ('32', '1013', '噢噢噢噢', '7200');
INSERT INTO `thing` VALUES ('33', '1013', '学习', '900');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `uname` varchar(255) default NULL,
  `upw` varchar(255) NOT NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1011', '1', '1');
INSERT INTO `user` VALUES ('1013', null, '456');
INSERT INTO `user` VALUES ('1014', null, '654');
INSERT INTO `user` VALUES ('1015', null, '789');
INSERT INTO `user` VALUES ('1016', null, '987');
INSERT INTO `user` VALUES ('1017', null, '159');
INSERT INTO `user` VALUES ('1018', null, '951');
INSERT INTO `user` VALUES ('1019', null, '753');
INSERT INTO `user` VALUES ('1020', null, '357');
INSERT INTO `user` VALUES ('1022', null, '1');
INSERT INTO `user` VALUES ('1023', null, '520');
INSERT INTO `user` VALUES ('1111', null, '456');
INSERT INTO `user` VALUES ('1114', null, '456');
INSERT INTO `user` VALUES ('1115', null, '4');
