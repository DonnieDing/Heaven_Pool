/*
Navicat MySQL Data Transfer

Source Server         : localhost（MySQL）
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : heavenpool

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-07-11 16:01:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户是否可用：默认1：启用，0：锁定',
  `roles` text COMMENT '用户角色，多个角色之间使用逗号分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$7NghKrkFZ7AgOWMVynyGkuuKi85digVKErPc8Oia.c0Y9soeowVLW', '1', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `sys_user` VALUES ('2', 'user', '$2a$10$oVRuDO9V7L1jLBqblA5KAO.1eBfpYjHjbkOJpQZ.pyFqelwAgR6Na', '1', 'ROLE_USER');
