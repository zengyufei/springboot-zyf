INSERT INTO `user_group`(`id`, `user_group_name`, `parent_id`, `parent_name`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (1, '顶级用户组', 0, '关联所有用户组', '2018-04-03 22:36:32', '2018-04-03 22:36:32', 6, 1, 0, 8);
INSERT INTO `user_group`(`id`, `user_group_name`, `parent_id`, `parent_name`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (2, '二级用户组', 1, '关联二级用户', '2018-04-05 18:08:13', '2018-04-05 18:08:13', 1, 1, 0, 74);


INSERT INTO `user`(`id`, `real_name`, `age`, `username`, `password`, `type`, `enable`, `enable_time`, `create_time`, `update_time`, `sex`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (1, '管理员', 11, 'admin', 'admin', 0, 1, '2018-03-24 15:53:33', '2018-03-24 15:53:33', '2018-04-06 16:05:59', 0, 1, 1, 0, 18);
INSERT INTO `user`(`id`, `real_name`, `age`, `username`, `password`, `type`, `enable`, `enable_time`, `create_time`, `update_time`, `sex`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (2, 'test', 31, 'test', 'test', 1, 1, '1984-11-08 00:29:10', '2018-03-25 21:36:27', '2018-03-25 21:36:27', 1, 1, 1, 0, 52);

INSERT INTO `role`(`id`, `role_name`, `description`, `parent_id`, `enable`, `enable_time`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (1, '系统管理员', '这是一种管理员角色', '0', 1, '2018-03-24 19:56:21', '2018-03-24 19:56:21', '2018-03-24 19:56:21', 1, 1, 0, 0);
INSERT INTO `role`(`id`, `role_name`, `description`, `parent_id`, `enable`, `enable_time`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (2, '普通用户', '普通用户角色', '0', 1, '2018-03-24 19:56:21', '2018-03-24 19:56:21', '2018-03-24 19:56:21', 1, 1, 1, 0);

INSERT INTO `permission`(`id`, `permission_name`, `permission`, `level`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (1, '用户模块', 'sys:user:*', 1, '0', '2018-03-24 20:58:22', '2018-04-01 09:23:32', 1, 1, 0, 1, 0);
INSERT INTO `permission`(`id`, `permission_name`, `permission`, `level`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (2, '用户新增', 'sys:user:add', 2, '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 1);
INSERT INTO `permission`(`id`, `permission_name`, `permission`, `level`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (3, '用户修改', 'sys:user:update', 2, '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 2);
INSERT INTO `permission`(`id`, `permission_name`, `permission`, `level`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (4, '用户删除', 'sys:user:delete', 2, '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 3);
INSERT INTO `permission`(`id`, `permission_name`, `permission`, `level`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (5, '用户查询', 'sys:user:get', 2, '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 1, 0, 4);
INSERT INTO `permission`(`id`, `permission_name`, `permission`, `level`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (6, '用户列表查看', 'sys:user:list', 2, '1', '2018-03-24 20:58:22', '2018-03-28 14:47:47', 1, 1, 0, 8, 5);
INSERT INTO `permission`(`id`, `permission_name`, `permission`, `level`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (7, '角色模块', 'sys:role:*', 1, '0', '2018-03-25 11:11:15', '2018-03-25 11:14:56', 1, 1, 0, 51, 0);


INSERT INTO `operation`(`id`, `operation_name`, `operation_code`, `level`, `url`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (1, '用户页面', 'user_page', 1, '/user.html', '0', '2018-03-24 20:58:22', '2018-04-03 20:15:07', 1, 1, 0, 2, 0);
INSERT INTO `operation`(`id`, `operation_name`, `operation_code`, `level`, `url`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (2, '用户新增按钮', 'user_add', 2, '/user', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 1);
INSERT INTO `operation`(`id`, `operation_name`, `operation_code`, `level`, `url`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (3, '用户修改按钮', 'user_update', 2, '/user', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 2);
INSERT INTO `operation`(`id`, `operation_name`, `operation_code`, `level`, `url`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (4, '用户删除按钮', 'user_delete', 2, '/user', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 3);
INSERT INTO `operation`(`id`, `operation_name`, `operation_code`, `level`, `url`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (5, '用户查询按钮', 'user_select', 2, '/user', '1', '2018-03-24 20:58:22', '2018-03-24 20:58:22', 1, 1, 0, 0, 4);
INSERT INTO `operation`(`id`, `operation_name`, `operation_code`, `level`, `url`, `parent_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`, `sort`)
VALUES (7, '角色页面', 'role_page', 1, '/role.html', '0', '2018-03-25 11:11:15', '2018-03-25 11:14:56', 1, 1, 0, 51, 0);

INSERT INTO `user_group_user`(`id`, `user_group_id`, `user_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (1, 1, 1, '2018-04-28 22:55:26', '2018-04-28 22:55:30', 1, 1, 0, 21);
INSERT INTO `user_group_user`(`id`, `user_group_id`, `user_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (2, 1, 2, '2018-04-28 22:55:26', '2018-04-28 22:55:30', 1, 1, 0, 21);

INSERT INTO `user_group_role`(`id`, `user_group_id`, `role_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (1, 1, 1, '2018-04-03 23:04:25', '2018-04-03 23:04:25', 1, 1, 0, 1);
INSERT INTO `user_group_role`(`id`, `user_group_id`, `role_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (2, 1, 2, '2018-04-03 23:04:25', '2018-04-03 23:04:25', 1, 1, 0, 1);


INSERT INTO `user_role`(`id`, `user_id`, `role_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (1, 1, 1, '2018-03-25 21:49:33', '2018-03-25 21:49:33', 1, 1, 0, 0);
INSERT INTO `user_role`(`id`, `user_id`, `role_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (2, 1, 2, '2018-03-25 21:50:04', '2018-03-25 21:50:04', 1, 1, 0, 0);

INSERT INTO `role_permission`(`id`, `role_id`, `permission_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (1, 1, 1, '2018-04-03 20:43:28', '2018-04-03 20:43:28', 1, 1, 0, 0);
INSERT INTO `role_permission`(`id`, `role_id`, `permission_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (2, 1, 2, '2018-04-03 20:43:28', '2018-04-03 20:43:28', 1, 1, 0, 0);

INSERT INTO `permission_operation`(`id`, `permission_id`, `operation_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (1, 1, 1, '2018-04-28 23:02:58', '2018-04-28 23:03:01', 1, 1, 0, 21);
INSERT INTO `permission_operation`(`id`, `permission_id`, `operation_id`, `create_time`, `update_time`, `create_id`, `update_id`, `delete_flag`, `version`)
VALUES (2, 1, 2, '2018-04-28 23:02:58', '2018-04-28 23:03:01', 1, 1, 0, 21);
