 CREATE TABLE `user_group` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `user_group_name` varchar(255) DEFAULT '',
   `parent_id` int(255) DEFAULT '0',
   `parent_name` varchar(255) DEFAULT NULL,
   `create_time` datetime DEFAULT NULL,
   `update_time` datetime DEFAULT NULL,
   `create_id` int(11) DEFAULT '0',
   `update_id` int(11) DEFAULT '0',
   `delete_flag` tinyint(1) DEFAULT '0',
   `version` int(11) DEFAULT '0',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 CREATE TABLE `user` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `real_name` varchar(255) DEFAULT '',
   `age` tinyint(1) DEFAULT '0',
   `username` varchar(255) NOT NULL,
   `password` varchar(255) NOT NULL,
   `type` tinyint(1) DEFAULT '0',
   `enable` tinyint(1) DEFAULT '1',
   `enable_time` datetime DEFAULT NULL,
   `create_time` datetime DEFAULT NULL,
   `update_time` datetime DEFAULT NULL,
   `sex` tinyint(1) DEFAULT '0',
   `create_id` int(11) DEFAULT '0',
   `update_id` int(11) DEFAULT '0',
   `delete_flag` tinyint(1) DEFAULT '0',
   `version` int(11) DEFAULT '0',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
   `delete_flag` tinyint(1) DEFAULT '0',
   `version` int(11) DEFAULT '0',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT '',
  `permission` varchar(255) DEFAULT '',
  `level` tinyint(1) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 CREATE TABLE `operation` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `operation_name` varchar(255) DEFAULT '',
   `operation_code` varchar(255) DEFAULT '',
   `level` tinyint(1) DEFAULT NULL,
   `url` varchar(255) DEFAULT '',
   `parent_id` varchar(255) DEFAULT '0',
   `create_time` datetime DEFAULT NULL,
   `update_time` datetime DEFAULT NULL,
   `create_id` int(11) DEFAULT '0',
   `update_id` int(11) DEFAULT '0',
   `delete_flag` tinyint(1) DEFAULT '0',
   `version` int(11) DEFAULT '0',
   `sort` int(11) DEFAULT '0',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_group_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_group_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_group_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `permission_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NOT NULL,
  `operation_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_id` int(11) DEFAULT '0',
  `update_id` int(11) DEFAULT '0',
  `delete_flag` tinyint(1) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;