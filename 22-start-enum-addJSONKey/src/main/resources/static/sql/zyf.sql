/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : zyf

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2018-03-23 08:20:59
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
  `href_url` varchar(255) DEFAULT '',
  `icon_Url` varchar(255) DEFAULT '',
  `parent_id` varchar(255) DEFAULT '',
  `enable` tinyint(4) DEFAULT '1',
  `enable_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '1',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT '',
  `description` varchar(255) DEFAULT '',
  `parent_id` varchar(255) DEFAULT '',
  `enable` tinyint(4) DEFAULT '1',
  `enable_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '1',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
