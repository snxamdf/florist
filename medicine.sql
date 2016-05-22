/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : medicine

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-05-22 18:19:18
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `t_gen_modules` VALUES ('medicine01', 'true', 'medicine', '医药管理', 'yhy', 'web-medicine,');

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
INSERT INTO `t_gen_projects` VALUES ('web-medicine', 'true', 'medicine', '医药管理子项目', null, null, null, null, null, null, null, null);
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
INSERT INTO `t_gen_tables` VALUES ('medicine01004', 'true', 'true', 't_medicine_med_sales', '药品销售记录表', '药品登记', 'sys', null, 'medicine01,');

-- ----------------------------
-- Table structure for t_medicine_chain
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine_chain`;
CREATE TABLE `t_medicine_chain` (
  `id` varchar(50) NOT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modifier` varchar(50) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `deletion` int(11) DEFAULT NULL,
  `history` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine_chain
-- ----------------------------
INSERT INTO `t_medicine_chain` VALUES ('157787ba-bdf3-4b78-951e-1ff673af44d2', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 11:47:51', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 11:47:51', '0', '0', '0', null, '北京二店');
INSERT INTO `t_medicine_chain` VALUES ('665648ed-6fa1-49e0-885c-8a80a50c4202', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 11:47:45', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 11:47:45', '0', '0', '0', null, '北京一店');

-- ----------------------------
-- Table structure for t_medicine_med
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine_med`;
CREATE TABLE `t_medicine_med` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modifier` varchar(50) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `deletion` int(11) DEFAULT NULL,
  `history` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `type_id` varchar(50) DEFAULT NULL,
  `spec` varchar(255) DEFAULT NULL COMMENT '规格',
  `price` decimal(10,2) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `vendor` varchar(255) DEFAULT NULL COMMENT '生产厂商',
  `mstate` varchar(50) DEFAULT '0' COMMENT '状态',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `barcode` varchar(255) DEFAULT NULL COMMENT '条形码编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine_med
-- ----------------------------
INSERT INTO `t_medicine_med` VALUES ('977db33d-3a0a-4a03-ba02-b27c8e2453f9', '感康', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 11:50:45', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 15:20:17', '0', '0', '0', null, '89157944-7891-4ec3-ae40-5ef915a87025', '10m', '12.50', '哈药', '哈药哈药哈药', '入库', '17', '20040');
INSERT INTO `t_medicine_med` VALUES ('a716bce8-fd5e-4a6e-a63c-844c93b4252a', '药品1', 'anonymousUser', '2016-05-21 11:53:16', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 15:56:41', '0', '0', '0', null, '89157944-7891-4ec3-ae40-5ef915a87025', '10m', '43.00', '哈药1', '哈药哈药哈药', '入库', '40', '20041');
INSERT INTO `t_medicine_med` VALUES ('bd1ca7df-941d-4827-ab6c-3906c38cdb9c', '中西药', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 12:46:47', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 12:46:47', '0', '0', '0', null, '8106a58c-1c0a-4764-9f52-a13ce70090dc', '10m', '12.50', '哈药', '哈药哈药哈药', '入库', '12', '20042');
INSERT INTO `t_medicine_med` VALUES ('e12b0eaa-206b-4d0c-9552-e6a57a1fbd5f', '中西药', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 12:45:58', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 12:45:58', '0', '0', '0', null, '8106a58c-1c0a-4764-9f52-a13ce70090dc', '10m', '12.50', '哈药', '哈药哈药哈药', '入库', '54', '20043');

-- ----------------------------
-- Table structure for t_medicine_med_sales
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine_med_sales`;
CREATE TABLE `t_medicine_med_sales` (
  `id` varchar(50) NOT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modifier` varchar(50) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `deletion` int(11) DEFAULT NULL,
  `history` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `med_id` varchar(50) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL COMMENT '销售数量',
  `barcode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine_med_sales
-- ----------------------------
INSERT INTO `t_medicine_med_sales` VALUES ('2007fa97-07ad-46f5-a87e-47b493b7f0f4', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 15:56:41', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 15:56:41', '0', '0', '0', null, 'a716bce8-fd5e-4a6e-a63c-844c93b4252a', '1', '20041');
INSERT INTO `t_medicine_med_sales` VALUES ('31e1bf69-1fc0-4577-9720-f2f79862fa8a', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 15:20:32', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 15:20:32', '0', '0', '0', null, 'a716bce8-fd5e-4a6e-a63c-844c93b4252a', '1', '20041');
INSERT INTO `t_medicine_med_sales` VALUES ('ff14871d-6b94-4215-9766-b57650877494', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 15:19:57', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 15:19:57', '0', '0', '0', null, '977db33d-3a0a-4a03-ba02-b27c8e2453f9', '1', '20040');

-- ----------------------------
-- Table structure for t_medicine_med_type
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine_med_type`;
CREATE TABLE `t_medicine_med_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
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
-- Records of t_medicine_med_type
-- ----------------------------
INSERT INTO `t_medicine_med_type` VALUES ('8106a58c-1c0a-4764-9f52-a13ce70090dc', '感冒药', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 11:45:03', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 11:45:03', '0', '0', '0', null);
INSERT INTO `t_medicine_med_type` VALUES ('89157944-7891-4ec3-ae40-5ef915a87025', '中西药', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 11:45:15', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 11:45:15', '0', '0', '0', null);

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
INSERT INTO `t_sys_role` VALUES ('1', 'BMS管理员', 'bms:role:admin', 'root', '2016-05-21 22:41:30', 'root', '2016-05-21 22:41:34', '1', '0', '0', '0', '10000');
INSERT INTO `t_sys_role` VALUES ('2', 'WEB管理员', 'web:role:admin', 'root', '2016-05-21 22:44:29', 'root', '2016-05-21 22:44:32', '1', '0', '0', '0', '10000');

-- ----------------------------
-- Table structure for t_sys_users
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_users`;
CREATE TABLE `t_sys_users` (
  `id` varchar(50) NOT NULL,
  `loginname` varchar(50) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `uname` varchar(50) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `chainid` varchar(50) DEFAULT NULL,
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
INSERT INTO `t_sys_users` VALUES ('482726ab-7a5a-43d9-8047-b47a602c1ee2', 'yhy', 'e2290662de798d053c10a2ae37584eacd7fc748f68fc0a665ad2faee97563cc7a552cd456593e02c', '张三', '1', '1', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 10:29:08', '72c29994-a075-11e4-a96d-005056a8', '0', '0', '0', null, '2016-05-22 10:39:53');
INSERT INTO `t_sys_users` VALUES ('626fe671-ad52-4791-9fa7-d1cdcb8a6e03', '123', '5999d5bd2358ccb1c893d8f07093ce83eea5c9e1eb3445fb73663a617c103d5335d8c0f3d4d0b9ea', '智', '0', '1', '72c29994-a075-11e4-a96d-005056a8', '2016-05-22 15:29:15', '72c29994-a075-11e4-a96d-005056a8', '0', '1', '0', null, '2016-05-22 15:31:24');
INSERT INTO `t_sys_users` VALUES ('72c29994-a075-11e4-a96d-005056a8', 'admin', 'd5541cd80576c4e0cf787d1ae395d32e8110ae86a4af356dc8325e8bb12d77b52f45b84b8d72721e', '管理员', '0', 'a716bce8-fd5e-4a6e-a63c-844c93b4', 'root', '2015-02-03 20:23:34', 'root', '0', '0', '0', '0', '2016-05-21 20:05:44');

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
  KEY `fk_user_roles_roleid` (`role_id`),
  CONSTRAINT `fk_user_roles_roleid` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`),
  CONSTRAINT `fk_user_roles_userid` FOREIGN KEY (`user_id`) REFERENCES `t_sys_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色信息表';

-- ----------------------------
-- Records of t_sys_user_roles
-- ----------------------------
INSERT INTO `t_sys_user_roles` VALUES ('1', '72c29994-a075-11e4-a96d-005056a8', '1', 'root', '2016-05-21 22:43:08', 'root', '2016-05-21 22:43:13', '1', '0', '0', '0');
INSERT INTO `t_sys_user_roles` VALUES ('2', '72c29994-a075-11e4-a96d-005056a8', '2', 'root', '2016-05-21 22:45:03', 'root', '2016-05-21 22:45:05', '1', '0', '0', '0');

-- ----------------------------
-- View structure for v_gen_columns
-- ----------------------------
DROP VIEW IF EXISTS `v_gen_columns`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_gen_columns` AS select uuid() AS `id`,`c`.`TABLE_NAME` AS `table_name`,lcase(`c`.`COLUMN_NAME`) AS `name`,ifnull(if((`c`.`COLUMN_COMMENT` = ''),lcase(`c`.`COLUMN_NAME`),`c`.`COLUMN_COMMENT`),lcase(`c`.`COLUMN_NAME`)) AS `comment`,lcase(`c`.`DATA_TYPE`) AS `types`,(case `c`.`DATA_TYPE` when 'datetime' then 19 when 'int' then `c`.`NUMERIC_PRECISION` when 'tinyint' then `c`.`NUMERIC_PRECISION` when 'smallint' then `c`.`NUMERIC_PRECISION` when 'bigint' then `c`.`NUMERIC_PRECISION` when 'decimal' then `c`.`NUMERIC_PRECISION` else ifnull(`c`.`CHARACTER_MAXIMUM_LENGTH`,0) end) AS `length`,(case `c`.`DATA_TYPE` when 'int' then `c`.`NUMERIC_SCALE` when 'decimal' then `c`.`NUMERIC_SCALE` else 0 end) AS `scale`,`c`.`COLUMN_DEFAULT` AS `defaults`,if((`c`.`IS_NULLABLE` = 'no'),'0','1') AS `nullable`,if((`c`.`COLUMN_KEY` = 'pri'),'1','0') AS `pkey`,`c`.`ORDINAL_POSITION` AS `ordinal` from `information_schema`.`columns` `c` where (`c`.`TABLE_SCHEMA` = 'medicine') order by `c`.`ORDINAL_POSITION` ;
