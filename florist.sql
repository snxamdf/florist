/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : florist

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2016-05-25 17:38:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_florist_flowers
-- ----------------------------
DROP TABLE IF EXISTS `t_florist_flowers`;
CREATE TABLE `t_florist_flowers` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `type_id` varchar(50) DEFAULT NULL COMMENT '类型',
  `no` varchar(50) DEFAULT NULL COMMENT '编号',
  `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `material` varchar(255) DEFAULT NULL COMMENT '材料',
  `creater` varchar(50) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modifier` varchar(50) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `deletion` int(11) DEFAULT NULL,
  `history` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_florist_flowers
-- ----------------------------
INSERT INTO `t_florist_flowers` VALUES ('1', '1', '1', '1', '1', '1', '1', '2016-05-24 09:50:24', '72c29994-a075-11e4-a96d-005056a8', '2016-05-25 10:04:27', '0', '0', '0', '0', '/web/florist/69d5f79682c4474a87a35786311d9e1c.png');
INSERT INTO `t_florist_flowers` VALUES ('2', '2', '2', '2', '2', '2', '2', '2016-05-24 10:17:50', '72c29994-a075-11e4-a96d-005056a8', '2016-05-25 10:14:10', '0', '0', '0', '0', '/web/florist/c44f1a00320c49f9996ebc96b6f3689f.png');
INSERT INTO `t_florist_flowers` VALUES ('50ddff52-0bf8-465a-84ed-031ecc7371bc', '21', '2', '12', '1', '2', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 10:49:19', '72c29994-a075-11e4-a96d-005056a8', '2016-05-25 09:57:58', '0', '0', '0', null, '/web/florist/57d889b8ca1e4347aa281b1114b129ed.png');

-- ----------------------------
-- Table structure for t_florist_order
-- ----------------------------
DROP TABLE IF EXISTS `t_florist_order`;
CREATE TABLE `t_florist_order` (
  `id` varchar(50) NOT NULL,
  `order_no` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `flowers_no` varchar(50) DEFAULT NULL COMMENT '鲜花编号',
  `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `addr` varchar(255) DEFAULT NULL COMMENT '地址',
  `uid` varchar(50) DEFAULT NULL COMMENT '购买人编号',
  `flowers_id` varchar(50) DEFAULT NULL COMMENT '鲜花id',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `creater` varchar(50) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modifier` varchar(50) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `deletion` int(11) DEFAULT NULL,
  `history` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '购买人姓名',
  `phone` varchar(50) DEFAULT NULL COMMENT '购买人电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_florist_order
-- ----------------------------
INSERT INTO `t_florist_order` VALUES ('11b496d6-5858-45f5-b2e6-3bcc430c6d91', '89091', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:30:45', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:30:45', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('24d822f3-c2e4-4f47-8f8c-483e124ce4b3', '96810', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:26:37', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:26:37', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('53894d5a-b874-48dd-b543-b8b4e1a38b33', '72081', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:35:18', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:35:18', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('56a6cccc-b571-4074-9d9c-68e6f1a3ff1f', '452858', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:38:46', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:38:46', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('6661cf2f-dd1e-4e95-80f2-412d8cfd5df7', '49979', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:35:34', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:35:34', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('6c1032a9-6b2c-4b05-94b2-1d5fed9fe3eb', '86367', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:29:10', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:29:10', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('7a064c1b-e681-47cc-8d3b-a5a992ba0bb4', '43674', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:34:21', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:34:21', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('82e991f8-4cac-4b35-8000-c01b66c89d16', '26585', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:36:30', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:36:30', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('a0d196ad-ae8b-4a8b-b9c0-19c9f519e65e', '37828', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:31:09', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:31:09', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('a32f726f-2ea2-4833-a941-abc2249f82ab', '994805', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:37:17', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:37:17', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('a8d0fe5e-7a79-48fc-9aca-5608cc4673b9', '658378', '2', '2', '', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', null, 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 17:03:36', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 17:03:36', '0', '0', '0', null, '', '');
INSERT INTO `t_florist_order` VALUES ('ab07f515-40b1-409e-ac6d-f0ebac4dcd03', '21154', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:37:05', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:37:05', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('d170d197-3d40-4648-b3fe-db3505f3781b', '774298', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:38:21', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:38:21', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('d1c61161-d7c9-473c-b61a-ee24b254bb10', '29707', '2', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2', '3', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:36:39', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 16:36:39', '0', '0', '0', null, '3', '3');
INSERT INTO `t_florist_order` VALUES ('f26ca520-4b22-4383-8b01-c63dab862462', '291818', '1', '1', '123', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '1', '123', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 17:04:42', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '2016-05-25 17:04:42', '0', '0', '0', null, '123', '123');

-- ----------------------------
-- Table structure for t_florist_type
-- ----------------------------
DROP TABLE IF EXISTS `t_florist_type`;
CREATE TABLE `t_florist_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `creater` varchar(50) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modifier` varchar(50) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `deletion` int(11) DEFAULT NULL,
  `history` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_florist_type
-- ----------------------------
INSERT INTO `t_florist_type` VALUES ('1', '类型m', null, '2016-05-24 11:01:04', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 12:41:18', '0', '0', '0', '0');
INSERT INTO `t_florist_type` VALUES ('1caaf2bb-a54a-46f8-b419-c9dc06cd699a', '123', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 11:06:18', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 11:06:18', '0', '0', '0', null);
INSERT INTO `t_florist_type` VALUES ('2', '类型2', null, '2016-05-24 11:01:07', null, '2016-05-24 11:01:11', '0', '0', '0', '0');
INSERT INTO `t_florist_type` VALUES ('8d0af055-81c6-459e-bf1c-fcac2a18781b', '添加类型', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 11:05:37', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 11:05:37', '0', '0', '0', null);

-- ----------------------------
-- Table structure for t_gen_modules
-- ----------------------------
DROP TABLE IF EXISTS `t_gen_modules`;
CREATE TABLE `t_gen_modules` (
  `id` varchar(50) NOT NULL COMMENT '标识',
  `generate` varchar(5) DEFAULT NULL COMMENT '是否生成',
  `code` varchar(100) DEFAULT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `project_id` varchar(50) DEFAULT NULL COMMENT '所属项目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块信息';

-- ----------------------------
-- Records of t_gen_modules
-- ----------------------------
INSERT INTO `t_gen_modules` VALUES ('sys01', 'true', 'sys', '系统模块', 'sxm', 'web-sys,');

-- ----------------------------
-- Table structure for t_gen_projects
-- ----------------------------
DROP TABLE IF EXISTS `t_gen_projects`;
CREATE TABLE `t_gen_projects` (
  `id` varchar(50) NOT NULL COMMENT '标识',
  `generate` varchar(5) DEFAULT NULL COMMENT '是否生成',
  `code` varchar(100) DEFAULT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `path` varchar(1000) DEFAULT NULL COMMENT '路径',
  `pkg` varchar(255) DEFAULT NULL COMMENT '包名',
  `main_src` varchar(255) DEFAULT NULL COMMENT '主代码',
  `main_res` varchar(255) DEFAULT NULL COMMENT '主资源',
  `main_app` varchar(255) DEFAULT NULL COMMENT '主应用',
  `test_src` varchar(255) DEFAULT NULL COMMENT '测试代码',
  `test_res` varchar(255) DEFAULT NULL COMMENT '测试资源',
  `views` varchar(255) DEFAULT NULL COMMENT '页面路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目信息';

-- ----------------------------
-- Records of t_gen_projects
-- ----------------------------
INSERT INTO `t_gen_projects` VALUES ('web-florist', 'true', 'florist', '鲜花预订项目', null, null, null, null, null, null, null, null);
INSERT INTO `t_gen_projects` VALUES ('web-sys', 'true', 'sys', '系统模块', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_gen_tables
-- ----------------------------
DROP TABLE IF EXISTS `t_gen_tables`;
CREATE TABLE `t_gen_tables` (
  `id` varchar(50) NOT NULL COMMENT '标识',
  `generate` varchar(5) DEFAULT NULL COMMENT '是否生成',
  `menu` varchar(5) DEFAULT NULL COMMENT '是否菜单',
  `code` varchar(100) DEFAULT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `comments` varchar(1000) DEFAULT NULL COMMENT '备注',
  `extend` varchar(100) DEFAULT NULL COMMENT '继承',
  `ignore_col` varchar(4000) DEFAULT NULL COMMENT '忽略列',
  `module_id` varchar(50) DEFAULT NULL COMMENT '所属模块',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表信息';

-- ----------------------------
-- Records of t_gen_tables
-- ----------------------------
INSERT INTO `t_gen_tables` VALUES ('sys01001', 'true', 'false', 't_sys_role', '权限管理', '权限管理表', 'sys', null, 'sys01,');
INSERT INTO `t_gen_tables` VALUES ('sys01002', 'true', 'false', 't_sys_user_roles', '用户角色关系表', '用户角色关系表', 'sys', null, 'sys01,');
INSERT INTO `t_gen_tables` VALUES ('sys01003', 'true', 'false', 't_sys_users', '用户表', '用户表', 'sys', null, 'sys01,');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` varchar(50) NOT NULL COMMENT '标识',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `genre` varchar(50) DEFAULT NULL COMMENT '类型',
  `creater` varchar(100) NOT NULL COMMENT '创建人员',
  `created` datetime NOT NULL COMMENT '创建日期',
  `modifier` varchar(100) NOT NULL COMMENT '修改人员',
  `modified` datetime NOT NULL COMMENT '修改日期',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本号',
  `deletion` int(11) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `history` int(11) NOT NULL DEFAULT '0' COMMENT '历史数据',
  `memo` varchar(1000) DEFAULT NULL COMMENT '备注',
  `code` varchar(100) DEFAULT NULL COMMENT '编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', 'BMS管理员', 'bms:role:admin', 'root', '2016-05-23 22:41:30', 'root', '2016-05-23 22:41:34', '1', '0', '0', '0', '10000');
INSERT INTO `t_sys_role` VALUES ('2', 'WEB管理员', 'web:role:admin', 'root', '2016-05-23 22:44:29', 'root', '2016-05-23 22:44:32', '1', '0', '0', '0', '10000');
INSERT INTO `t_sys_role` VALUES ('3', 'WEB普通用户', 'web:role:comm', 'comm', '2016-05-23 16:16:48', 'comm', '2016-05-23 16:17:07', '1', '0', '0', '0', '10001');
INSERT INTO `t_sys_role` VALUES ('4', 'BMS普通用户', 'bms:role:comm', 'comm', '2016-05-23 16:19:40', 'comm', '2016-05-23 16:19:50', '1', '0', '0', '0', '10001');

-- ----------------------------
-- Table structure for t_sys_users
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_users`;
CREATE TABLE `t_sys_users` (
  `id` varchar(50) NOT NULL,
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录名称',
  `passwd` varchar(255) DEFAULT NULL,
  `uname` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `addr` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `creater` varchar(50) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modifier` varchar(50) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `deletion` int(11) DEFAULT NULL,
  `history` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_users
-- ----------------------------
INSERT INTO `t_sys_users` VALUES ('72c29994-a075-11e4-a96d-005056a8', 'admin', 'bddc3baefabe4037262a2700648ea6663504e374656c8d208258a2ba1937d0a9943d9b423dddc9b6', '管理员', 'asdf', '15164383713', null, '2016-05-25 17:33:06', '72c29994-a075-11e4-a96d-005056a8', '0', '0', '0', null, '2016-05-25 17:33:06');
INSERT INTO `t_sys_users` VALUES ('cbe2a006-48f3-43cb-aa3f-183058909e3a', 'weba', 'ae8603575d73ab66c327bb72666ce5f46833be5bbceb959ddeb133f1be00e979389a75d4102e95d3', '浣熊用', 'ddd', '123123', '72c29994-a075-11e4-a96d-005056a8', '2016-05-25 14:17:31', '72c29994-a075-11e4-a96d-005056a8', '0', '0', '0', null, '2016-05-25 14:17:31');

-- ----------------------------
-- Table structure for t_sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_roles`;
CREATE TABLE `t_sys_user_roles` (
  `id` varchar(50) NOT NULL COMMENT '标识',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户标识',
  `role_id` varchar(50) DEFAULT NULL COMMENT '角色标识',
  `creater` varchar(50) NOT NULL COMMENT '创建人员',
  `created` datetime NOT NULL COMMENT '创建日期',
  `modifier` varchar(50) NOT NULL COMMENT '修改人员',
  `modified` datetime NOT NULL COMMENT '修改日期',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本号',
  `deletion` int(11) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `history` int(11) NOT NULL DEFAULT '0' COMMENT '历史数据',
  `memo` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_user_roles_userid` (`user_id`),
  KEY `fk_user_roles_roleid` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色信息表';

-- ----------------------------
-- Records of t_sys_user_roles
-- ----------------------------
INSERT INTO `t_sys_user_roles` VALUES ('00106bc7-0e8a-481b-8041-a2df25cfd0ad', '72c29994-a075-11e4-a96d-005056a8', '2', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 16:31:40', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 16:31:40', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('0950d3ae-e39c-4d09-a721-a2d0cdb7c2f3', 'ed2f58bc-2a46-45ed-bf5b-ed0e4d8e237f', '3', 'anonymousUser', '2016-05-25 13:58:31', 'anonymousUser', '2016-05-25 13:58:31', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('121f8ae4-d60d-4c87-9489-ac2162fe7dfe', '72c29994-a075-11e4-a96d-005056a8', '1', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 16:31:40', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 16:31:40', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('124d9fed-763b-42fd-af86-2760ff6bade5', 'cbe2a006-48f3-43cb-aa3f-183058909e3a', '3', '72c29994-a075-11e4-a96d-005056a8', '2016-05-25 14:17:31', '72c29994-a075-11e4-a96d-005056a8', '2016-05-25 14:17:31', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('1523d2c7-ce26-4986-9e50-9d9867085d8f', '482726ab-7a5a-43d9-8047-b47a602c1ee2', '3', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 15:13:05', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 15:13:05', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('266c923b-a4a7-450f-9c7f-84e7315d20ae', '6484e02d-8138-4057-a160-d6a0527fc2aa', '3', 'anonymousUser', '2016-05-25 13:58:45', 'anonymousUser', '2016-05-25 13:58:45', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('47377ffe-82a9-4108-ae1c-8596e6416443', '72c29994-a075-11e4-a96d-005056a8', '4', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 16:31:40', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 16:31:40', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('47e276a0-3b8e-479c-8206-d049ebcfe5db', 'cfca4cc9-0ab1-42d5-bea4-944cbfaee646', '4', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 16:18:00', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 16:18:00', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('4af2ffe5-388c-4574-b8d7-f226cc64ee77', '72c29994-a075-11e4-a96d-005056a8', '3', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 16:31:40', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 16:31:40', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('4df8cd5d-fc76-4b88-8920-d10261ca0f39', 'faf7898f-3d19-4fe8-b87b-3481c0058025', '3', 'anonymousUser', '2016-05-25 14:03:42', 'anonymousUser', '2016-05-25 14:03:42', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('b878e34c-137e-437b-aae9-4224b57f363c', 'c2304c7e-0132-42ba-8ebc-9f69614233a7', '3', 'anonymousUser', '2016-05-25 13:59:22', 'anonymousUser', '2016-05-25 13:59:22', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('b9d65f90-0f30-4333-8bce-e7aa46bc145e', '', '2', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 15:17:28', '72c29994-a075-11e4-a96d-005056a8', '2016-05-24 15:17:28', '0', '0', '0', null);
INSERT INTO `t_sys_user_roles` VALUES ('cad81aa6-7f05-4d55-92d5-221ae346e304', 'da0ef717-a908-4c8d-ab8b-b5ba6150457d', '3', 'anonymousUser', '2016-05-25 13:55:26', 'anonymousUser', '2016-05-25 13:55:26', '0', '0', '0', null);

-- ----------------------------
-- View structure for v_gen_columns
-- ----------------------------
DROP VIEW IF EXISTS `v_gen_columns`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_gen_columns` AS select uuid() AS `id`,`c`.`TABLE_NAME` AS `table_name`,lcase(`c`.`COLUMN_NAME`) AS `name`,ifnull(if((`c`.`COLUMN_COMMENT` = ''),lcase(`c`.`COLUMN_NAME`),`c`.`COLUMN_COMMENT`),lcase(`c`.`COLUMN_NAME`)) AS `comment`,lcase(`c`.`DATA_TYPE`) AS `types`,(case `c`.`DATA_TYPE` when 'datetime' then 19 when 'int' then `c`.`NUMERIC_PRECISION` when 'tinyint' then `c`.`NUMERIC_PRECISION` when 'smallint' then `c`.`NUMERIC_PRECISION` when 'bigint' then `c`.`NUMERIC_PRECISION` when 'decimal' then `c`.`NUMERIC_PRECISION` else ifnull(`c`.`CHARACTER_MAXIMUM_LENGTH`,0) end) AS `length`,(case `c`.`DATA_TYPE` when 'int' then `c`.`NUMERIC_SCALE` when 'decimal' then `c`.`NUMERIC_SCALE` else 0 end) AS `scale`,`c`.`COLUMN_DEFAULT` AS `defaults`,if((`c`.`IS_NULLABLE` = 'no'),'0','1') AS `nullable`,if((`c`.`COLUMN_KEY` = 'pri'),'1','0') AS `pkey`,`c`.`ORDINAL_POSITION` AS `ordinal` from `information_schema`.`columns` `c` where (`c`.`TABLE_SCHEMA` = 'florist') order by `c`.`ORDINAL_POSITION` ;
