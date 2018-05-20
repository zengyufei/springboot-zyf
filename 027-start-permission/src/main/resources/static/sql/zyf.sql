/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50620
 Source Host           : localhost:3306
 Source Schema         : zyf

 Target Server Type    : MySQL
 Target Server Version : 50620
 File Encoding         : 65001

 Date: 10/05/2018 16:06:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operation_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `operation_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `level` tinyint(11) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_id` int(11) NULL DEFAULT 0,
  `update_id` int(11) NULL DEFAULT 0,
  `delete_flag` tinyint(1) NULL DEFAULT 0,
  `version` int(11) NULL DEFAULT 0,
  `sort` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of operation
-- ----------------------------
INSERT INTO `operation` VALUES (1, '用户页面', 'sada43', 1, '/user1', '0', '2018-03-24 20:58:22', '2018-04-03 20:15:07', 1, 1, 0, 2, 0);
INSERT INTO `operation` VALUES (2, '用户新增按钮', 'das234dd', 2, '/user', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 1);
INSERT INTO `operation` VALUES (3, '用户修改按钮', 'ferre324', 2, '/user', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 2);
INSERT INTO `operation` VALUES (4, '用户删除按钮', '4r3fdg', 2, '/user', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 3);
INSERT INTO `operation` VALUES (5, '用户查询按钮', 'ret324hfg', 2, '/user', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 4);
INSERT INTO `operation` VALUES (7, '角色页面', 'rf456', 1, '/role', '0', '2018-03-25 11:11:15', '2018-03-25 11:14:56', 1, 1, 0, 51, 0);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `level` tinyint(11) NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_id` int(11) NULL DEFAULT 0,
  `update_id` int(11) NULL DEFAULT 0,
  `delete_flag` tinyint(1) NULL DEFAULT 0,
  `version` int(11) NULL DEFAULT 0,
  `sort` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '用户模块', 'sys:user:*', 1, '0', '2018-03-24 20:58:22', '2018-04-01 09:23:32', 1, 1, 0, 1, 0);
INSERT INTO `permission` VALUES (2, '用户新增', 'sys:user:add', 2, '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 1);
INSERT INTO `permission` VALUES (3, '用户修改', 'sys:user:update', 2, '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 2);
INSERT INTO `permission` VALUES (4, '用户删除', 'sys:user:delete', 2, '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 3);
INSERT INTO `permission` VALUES (5, '用户查询', 'sys:user:get', 2, '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 4);
INSERT INTO `permission` VALUES (6, '用户列表查看', 'sys:user:list', 2, '1', '2018-03-24 20:58:22', '2018-03-28 14:47:47', 1, 1, 0, 8, 5);
INSERT INTO `permission` VALUES (7, '角色模块', 'sys:role:*', 1, '0', '2018-03-25 11:11:15', '2018-03-25 11:14:56', 1, 1, 0, 51, 0);

-- ----------------------------
-- Table structure for permission_operation
-- ----------------------------
DROP TABLE IF EXISTS `permission_operation`;
CREATE TABLE `permission_operation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NOT NULL,
  `operation_id` int(11) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_id` int(11) NULL DEFAULT 0,
  `update_id` int(11) NULL DEFAULT 0,
  `delete_flag` tinyint(1) NULL DEFAULT 0,
  `version` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permission_operation
-- ----------------------------
INSERT INTO `permission_operation` VALUES (1, 1, 1, '2018-04-28 23:02:58', '2018-04-28 23:03:01', 1, 1, 0, 21);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `enable` tinyint(4) NULL DEFAULT 1,
  `enable_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_id` int(11) NULL DEFAULT 0,
  `update_id` int(11) NULL DEFAULT 0,
  `delete_flag` tinyint(1) NULL DEFAULT 0,
  `version` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '系统管理员', '这是一种管理员角色', '0', 1, '2018-03-24 19:56:21', '2018-03-24 19:56:21', '2018-03-24 19:56:21', 1, 1, 0, 0);
INSERT INTO `role` VALUES (2, '普通用户', '普通用户角色', '0', 1, '2018-03-24 19:56:21', '2018-03-24 19:56:21', '2018-03-24 19:56:21', 1, 1, 0, 0);
INSERT INTO `role` VALUES (3, '1ADFCFF111', '2EFJAJF', '3EDAEED', 1, '2018-04-03 23:02:35', '2018-04-03 23:02:35', '2018-04-03 23:02:36', 6, 1, 1, 6);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_id` int(11) NULL DEFAULT 0,
  `update_id` int(11) NULL DEFAULT 0,
  `delete_flag` tinyint(1) NULL DEFAULT 0,
  `version` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (51, 1, 1, '2018-04-03 20:43:28', '2018-04-03 20:43:28', 1, 1, 0, 0);
INSERT INTO `role_permission` VALUES (52, 1, 3, '2018-04-03 20:43:28', '2018-04-03 20:43:28', 1, 1, 0, 0);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(1) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1, 'test', 1, '2018-03-29 08:50:21', '2018-03-29 08:50:21');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `age` int(1) NULL DEFAULT 0,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` tinyint(1) NULL DEFAULT 0,
  `enable` tinyint(4) NULL DEFAULT 1,
  `enable_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `sex` tinyint(4) NULL DEFAULT 0,
  `create_id` int(11) NULL DEFAULT 0,
  `update_id` int(11) NULL DEFAULT 0,
  `delete_flag` tinyint(1) NULL DEFAULT 0,
  `version` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '管理员', 11, 'admin', 'admin', 0, 1, '2018-03-24 15:53:33', '2018-03-24 15:53:33', '2018-04-06 16:05:59', 0, 1, 1, 0, 18);
INSERT INTO `user` VALUES (2, 'fnlywtlbbdre', 31, 'wzwaykobtp', 'admin', 1, 1, '1984-11-08 00:29:10', '2018-03-25 21:36:27', '2018-03-25 21:36:27', 1, 1, 1, 0, 52);
INSERT INTO `user` VALUES (3, 'bltyknymyfhgr', 80, 'lkwrqgnaigbhkdvzef', 'admin', 2, 1, '1981-07-11 11:53:11', '2018-03-25 21:38:27', '2018-04-06 16:10:58', 1, 1, 1, 0, 8);
INSERT INTO `user` VALUES (4, 'jexzmxd', 51, 'cokmehkukxain', 'admin', 1, 1, '2014-10-16 00:55:11', '2018-03-25 21:39:36', '2018-03-25 21:52:23', 0, 1, 1, 0, 4);
INSERT INTO `user` VALUES (5, 'ekbwcdgjxjej', 96, 'dgmdiariutkukki', 'admin', 2, 1, '2014-03-18 05:36:52', '2018-03-25 21:42:51', '2018-03-25 21:52:31', 0, 1, 1, 0, 43);
INSERT INTO `user` VALUES (6, 'wyjjsdl', 63, 'bekevi', 'admin', 2, 1, '2000-03-04 15:40:34', '2018-03-25 21:50:04', '2018-03-25 21:50:04', 1, 1, 1, 0, 23);
INSERT INTO `user` VALUES (7, 'ylhglrfqaqfcgxqulh', 27, 'bmbacieguo', 'admin', 2, 1, '1976-05-27 09:19:54', '2018-03-25 21:50:15', '2018-03-25 21:50:15', 0, 1, 1, 0, 63);
INSERT INTO `user` VALUES (8, 'mopbtdusevy', 96, 'xuhjxfmjhf', 'admin', 1, 1, '1989-05-20 00:54:47', '2018-03-26 09:01:39', '2018-03-26 09:01:39', 1, 1, 1, 0, 81);
INSERT INTO `user` VALUES (10, 'qqfsspllgawwpmzwxo', 15, 'gnhnlqc', 'admin', 2, 1, '1995-01-03 19:45:36', '2018-03-26 09:03:00', '2018-03-26 09:03:00', 0, 1, 1, 0, 22);
INSERT INTO `user` VALUES (11, 'mlfbhj', 97, 'mxdnubliuwuevwzl', 'admin', 1, 1, '1979-07-09 18:18:08', '2018-03-26 09:03:09', '2018-03-26 09:03:09', 0, 1, 1, 0, 16);
INSERT INTO `user` VALUES (12, 'etuirpxl', 43, 'qmvgiorxmzmsmttibr', 'admin', 0, 1, '1984-02-20 01:10:35', '2018-03-26 09:03:13', '2018-03-26 09:03:13', 1, 1, 1, 0, 73);
INSERT INTO `user` VALUES (13, 'oginwohnqumihwffum', 67, 'yhdmzikygjoynunmrt', 'admin', 1, 1, '2003-09-25 00:46:22', '2018-03-26 09:03:17', '2018-03-26 09:03:17', 1, 1, 1, 0, 48);
INSERT INTO `user` VALUES (14, 'aockwh', 67, 'hecpvvptpokwgm', 'admin', 1, 1, '2005-12-05 06:39:38', '2018-03-26 09:03:21', '2018-03-26 09:03:21', 0, 1, 1, 0, 17);

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `parent_id` int(255) NULL DEFAULT 0,
  `parent_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_id` int(11) NULL DEFAULT 0,
  `update_id` int(11) NULL DEFAULT 0,
  `delete_flag` tinyint(1) NULL DEFAULT 0,
  `version` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES (1, '1DAEDFC1111', 0, '', '2018-04-03 22:36:32', '2018-04-03 22:36:32', 6, 1, 0, 8);
INSERT INTO `user_group` VALUES (2, 'hjfhjhjk', 1, 'rpiilkhhihlhdgka', '2018-04-05 18:08:13', '2018-04-05 18:08:13', 1, 1, 0, 74);

-- ----------------------------
-- Table structure for user_group_role
-- ----------------------------
DROP TABLE IF EXISTS `user_group_role`;
CREATE TABLE `user_group_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_group_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_id` int(11) NULL DEFAULT 0,
  `update_id` int(11) NULL DEFAULT 0,
  `delete_flag` tinyint(1) NULL DEFAULT 0,
  `version` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_group_role
-- ----------------------------
INSERT INTO `user_group_role` VALUES (1, 2, 1, '2018-04-03 23:04:25', '2018-04-03 23:04:25', 1, 1, 0, 1);

-- ----------------------------
-- Table structure for user_group_user
-- ----------------------------
DROP TABLE IF EXISTS `user_group_user`;
CREATE TABLE `user_group_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_id` int(11) NULL DEFAULT 0,
  `update_id` int(11) NULL DEFAULT 0,
  `delete_flag` tinyint(1) NULL DEFAULT 0,
  `version` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_group_user
-- ----------------------------
INSERT INTO `user_group_user` VALUES (1, 1, 1, '2018-04-28 22:55:26', '2018-04-28 22:55:30', 1, 1, 0, 21);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_id` int(11) NULL DEFAULT 0,
  `update_id` int(11) NULL DEFAULT 0,
  `delete_flag` tinyint(1) NULL DEFAULT 0,
  `version` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (20, 5, 2, '2018-03-25 21:49:33', '2018-03-25 21:49:33', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (21, 6, 2, '2018-03-25 21:50:04', '2018-03-25 21:50:04', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (22, 7, 1, '2018-03-25 21:50:15', '2018-03-25 21:50:15', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (23, 7, 2, '2018-03-25 21:50:15', '2018-03-25 21:50:15', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (24, 4, 1, '2018-03-25 21:52:03', '2018-03-25 21:52:03', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (25, 1, 1, '2018-03-25 21:52:06', '2018-03-25 21:52:06', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (26, 3, 2, '2018-03-25 21:52:10', '2018-03-25 21:52:10', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (27, 3, 1, '2018-03-25 21:52:17', '2018-03-25 21:52:17', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (29, 4, 2, '2018-03-25 21:52:23', '2018-03-25 21:52:23', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (30, 5, 1, '2018-03-25 21:52:31', '2018-03-25 21:52:31', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (31, 8, 2, '2018-03-26 09:01:39', '2018-03-26 09:01:39', 1, 1, 0, 0);
INSERT INTO `user_role` VALUES (32, 12, 1, '2018-03-26 09:03:13', '2018-03-26 09:03:13', 1, 1, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
