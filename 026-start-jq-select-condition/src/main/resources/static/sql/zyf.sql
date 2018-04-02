/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : zyf

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2018-04-02 22:39:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) DEFAULT '',
  `permission` varchar(255) DEFAULT '',
  `level` int(11) DEFAULT NULL,
  `href_url` varchar(255) DEFAULT '',
  `icon_Url` varchar(255) DEFAULT '',
  `parent_id` varchar(255) DEFAULT '0',
  `enable` tinyint(4) DEFAULT '1',
  `enable_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '1',
  `version` int(11) DEFAULT '0',
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '用户模块', 'sys:user:*', '1', '/user', '/icon/user.png', '0', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', '2018-04-01 09:23:32', '1', '1', '1', '1', '0');
INSERT INTO `resource` VALUES ('2', '用户新增', 'sys:user:add', '2', '/user', '', '1', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', '2018-03-24 20:58:22', '1', '1', '1', '0', '1');
INSERT INTO `resource` VALUES ('3', '用户修改', 'sys:user:update', '2', '/user', '', '1', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', '2018-03-24 20:58:22', '1', '1', '1', '0', '2');
INSERT INTO `resource` VALUES ('4', '用户删除', 'sys:user:delete', '2', '/user', '', '1', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', '2018-03-24 20:58:22', '1', '1', '1', '0', '3');
INSERT INTO `resource` VALUES ('5', '用户查询', 'sys:user:get', '2', '/user', '', '1', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', '2018-03-24 20:58:22', '1', '1', '1', '0', '4');
INSERT INTO `resource` VALUES ('6', '用户列表查看', 'sys:user:list', '2', '/user', '0', '1', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', '2018-03-28 14:47:47', '1', '1', '1', '8', '5');
INSERT INTO `resource` VALUES ('7', '角色模块', 'sys:role:*', '1', '/role', '/icon/role.png', '0', '1', '2000-05-23 01:14:55', '2018-03-25 11:11:15', '2018-03-25 11:14:56', '1', '1', '1', '51', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT '',
  `description` varchar(255) DEFAULT '',
  `parent_id` varchar(255) DEFAULT '0',
  `enable` tinyint(4) DEFAULT '1',
  `enable_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '1',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员', '这是一种管理员角色', '0', '1', '2018-03-24 19:56:21', '2018-03-24 19:56:21', '2018-03-24 19:56:21', '1', '1', '1', '0');
INSERT INTO `role` VALUES ('2', '普通用户', '普通用户角色', '0', '1', '2018-03-24 19:56:21', '2018-03-24 19:56:21', '2018-03-24 19:56:21', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '1',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('46', '1', '1', '2018-03-28 18:22:33', '2018-03-28 18:22:33', '1', '1', '1', '0');
INSERT INTO `role_resource` VALUES ('47', '1', '3', '2018-03-28 18:22:33', '2018-03-28 18:22:33', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'test', '1', '2018-03-29 08:50:21', '2018-03-29 08:50:21');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) DEFAULT '',
  `age` tinyint(11) DEFAULT '0',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` tinyint(1) DEFAULT '0',
  `enable` tinyint(4) DEFAULT '1',
  `enable_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `sex` tinyint(4) DEFAULT '0',
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '1',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '管理员', '11', 'admin', 'admin', '0', '1', '2018-03-24 15:53:33', '2018-03-24 15:53:33', '2018-03-25 21:52:06', '0', '1', '1', '1', '14');
INSERT INTO `user` VALUES ('2', 'fnlywtlbbdre', '31', 'wzwaykobtp', 'admin', '1', '1', '1984-11-08 00:29:10', '2018-03-25 21:36:27', '2018-03-25 21:36:27', '1', '1', '1', '0', '52');
INSERT INTO `user` VALUES ('3', 'bltyknymyfhgr', '80', 'lkwrqgnaigbhkdvzef', 'admin', '2', '1', '1981-07-11 11:53:11', '2018-03-25 21:38:27', '2018-03-25 21:52:17', '1', '1', '1', '1', '4');
INSERT INTO `user` VALUES ('4', 'jexzmxd', '51', 'cokmehkukxain', 'admin', '1', '1', '2014-10-16 00:55:11', '2018-03-25 21:39:36', '2018-03-25 21:52:23', '0', '1', '1', '1', '4');
INSERT INTO `user` VALUES ('5', 'ekbwcdgjxjej', '96', 'dgmdiariutkukki', 'admin', '2', '1', '2014-03-18 05:36:52', '2018-03-25 21:42:51', '2018-03-25 21:52:31', '1', '1', '1', '1', '43');
INSERT INTO `user` VALUES ('6', 'wyjjsdl', '63', 'bekevi', 'admin', '2', '1', '2000-03-04 15:40:34', '2018-03-25 21:50:04', '2018-03-25 21:50:04', '1', '1', '1', '1', '23');
INSERT INTO `user` VALUES ('7', 'ylhglrfqaqfcgxqulh', '27', 'bmbacieguo', 'admin', '2', '1', '1976-05-27 09:19:54', '2018-03-25 21:50:15', '2018-03-25 21:50:15', '0', '1', '1', '1', '63');
INSERT INTO `user` VALUES ('8', 'mopbtdusevy', '96', 'xuhjxfmjhf', 'admin', '1', '1', '1989-05-20 00:54:47', '2018-03-26 09:01:39', '2018-03-26 09:01:39', '1', '1', '1', '1', '81');
INSERT INTO `user` VALUES ('10', 'qqfsspllgawwpmzwxo', '15', 'gnhnlqc', 'admin', '2', '1', '1995-01-03 19:45:36', '2018-03-26 09:03:00', '2018-03-26 09:03:00', '0', '1', '1', '1', '22');
INSERT INTO `user` VALUES ('11', 'mlfbhj', '97', 'mxdnubliuwuevwzl', 'admin', '1', '1', '1979-07-09 18:18:08', '2018-03-26 09:03:09', '2018-03-26 09:03:09', '0', '1', '1', '1', '16');
INSERT INTO `user` VALUES ('12', 'etuirpxl', '43', 'qmvgiorxmzmsmttibr', 'admin', '0', '1', '1984-02-20 01:10:35', '2018-03-26 09:03:13', '2018-03-26 09:03:13', '1', '1', '1', '1', '73');
INSERT INTO `user` VALUES ('13', 'oginwohnqumihwffum', '67', 'yhdmzikygjoynunmrt', 'admin', '1', '1', '2003-09-25 00:46:22', '2018-03-26 09:03:17', '2018-03-26 09:03:17', '1', '1', '1', '1', '48');
INSERT INTO `user` VALUES ('14', 'aockwh', '67', 'hecpvvptpokwgm', 'admin', '1', '1', '2005-12-05 06:39:38', '2018-03-26 09:03:21', '2018-03-26 09:03:21', '0', '1', '1', '1', '17');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '1',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('20', '5', '2', '2018-03-25 21:49:33', '2018-03-25 21:49:33', '1', '1', '0', '0');
INSERT INTO `user_role` VALUES ('21', '6', '2', '2018-03-25 21:50:04', '2018-03-25 21:50:04', '1', '1', '1', '0');
INSERT INTO `user_role` VALUES ('22', '7', '1', '2018-03-25 21:50:15', '2018-03-25 21:50:15', '1', '1', '1', '0');
INSERT INTO `user_role` VALUES ('23', '7', '2', '2018-03-25 21:50:15', '2018-03-25 21:50:15', '1', '1', '1', '0');
INSERT INTO `user_role` VALUES ('24', '4', '1', '2018-03-25 21:52:03', '2018-03-25 21:52:03', '1', '1', '0', '0');
INSERT INTO `user_role` VALUES ('25', '1', '1', '2018-03-25 21:52:06', '2018-03-25 21:52:06', '1', '1', '1', '0');
INSERT INTO `user_role` VALUES ('26', '3', '2', '2018-03-25 21:52:10', '2018-03-25 21:52:10', '1', '1', '0', '0');
INSERT INTO `user_role` VALUES ('27', '3', '1', '2018-03-25 21:52:17', '2018-03-25 21:52:17', '1', '1', '1', '0');
INSERT INTO `user_role` VALUES ('28', '3', '2', '2018-03-25 21:52:17', '2018-03-25 21:52:17', '1', '1', '1', '0');
INSERT INTO `user_role` VALUES ('29', '4', '2', '2018-03-25 21:52:23', '2018-03-25 21:52:23', '1', '1', '1', '0');
INSERT INTO `user_role` VALUES ('30', '5', '1', '2018-03-25 21:52:31', '2018-03-25 21:52:31', '1', '1', '1', '0');
INSERT INTO `user_role` VALUES ('31', '8', '2', '2018-03-26 09:01:39', '2018-03-26 09:01:39', '1', '1', '1', '0');
INSERT INTO `user_role` VALUES ('32', '12', '1', '2018-03-26 09:03:13', '2018-03-26 09:03:13', '1', '1', '1', '0');
