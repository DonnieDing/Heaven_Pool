/*
Navicat MySQL Data Transfer

Source Server         : localhost（MySQL）
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : heavenpool

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2021-05-10 16:19:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for acl_permission
-- ----------------------------
DROP TABLE IF EXISTS `acl_permission`;
CREATE TABLE `acl_permission` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '权限id',
  `pid` char(19) NOT NULL DEFAULT '' COMMENT '所属上级id',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '权限名称',
  `type` tinyint(3) NOT NULL DEFAULT '0' COMMENT '类型(1:菜单,2:按钮)',
  `permission_value` varchar(50) DEFAULT NULL COMMENT '权限值',
  `path` varchar(100) DEFAULT NULL COMMENT '访问路径',
  `component` varchar(100) DEFAULT NULL COMMENT '组件路径',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_pid` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限';

-- ----------------------------
-- Records of acl_permission
-- ----------------------------
INSERT INTO `acl_permission` VALUES ('1', '0', '全部数据', '0', null, null, null, null, null, '0', '2019-11-15 17:13:06', '2019-11-15 17:13:06');
INSERT INTO `acl_permission` VALUES ('1195268474480156673', '1', '权限管理', '1', null, '/acl', 'Layout', null, null, '0', '2019-11-15 17:13:06', '2019-11-18 13:54:25');
INSERT INTO `acl_permission` VALUES ('1195268616021139457', '1195268474480156673', '用户管理', '1', null, 'user/list', '/acl/user/list', null, null, '0', '2019-11-15 17:13:40', '2019-11-18 13:53:12');
INSERT INTO `acl_permission` VALUES ('1195268788138598401', '1195268474480156673', '角色管理', '1', null, 'role/list', '/acl/role/list', null, null, '0', '2019-11-15 17:14:21', '2019-11-15 17:14:21');
INSERT INTO `acl_permission` VALUES ('1195268893830864898', '1195268474480156673', '菜单管理', '1', null, 'menu/list', '/acl/menu/list', null, null, '0', '2019-11-15 17:14:46', '2019-11-15 17:14:46');
INSERT INTO `acl_permission` VALUES ('1195269143060602882', '1195268616021139457', '查看', '2', 'user.list', '', '', null, null, '0', '2019-11-15 17:15:45', '2019-11-17 21:57:16');
INSERT INTO `acl_permission` VALUES ('1195269295926206466', '1195268616021139457', '添加', '2', 'user.add', 'user/add', '/acl/user/form', null, null, '0', '2019-11-15 17:16:22', '2019-11-15 17:16:22');
INSERT INTO `acl_permission` VALUES ('1195269473479483394', '1195268616021139457', '修改', '2', 'user.update', 'user/update/:id', '/acl/user/form', null, null, '0', '2019-11-15 17:17:04', '2019-11-15 17:17:04');
INSERT INTO `acl_permission` VALUES ('1195269547269873666', '1195268616021139457', '删除', '2', 'user.remove', '', '', null, null, '0', '2019-11-15 17:17:22', '2019-11-15 17:17:22');
INSERT INTO `acl_permission` VALUES ('1195269821262782465', '1195268788138598401', '修改', '2', 'role.update', 'role/update/:id', '/acl/role/form', null, null, '0', '2019-11-15 17:18:27', '2019-11-15 17:19:53');
INSERT INTO `acl_permission` VALUES ('1195269903542444034', '1195268788138598401', '查看', '2', 'role.list', '', '', null, null, '0', '2019-11-15 17:18:47', '2019-11-15 17:18:47');
INSERT INTO `acl_permission` VALUES ('1195270037005197313', '1195268788138598401', '添加', '2', 'role.add', 'role/add', '/acl/role/form', null, null, '0', '2019-11-15 17:19:19', '2019-11-18 11:05:42');
INSERT INTO `acl_permission` VALUES ('1195270442602782721', '1195268788138598401', '删除', '2', 'role.remove', '', '', null, null, '0', '2019-11-15 17:20:55', '2019-11-15 17:20:55');
INSERT INTO `acl_permission` VALUES ('1195270621548568578', '1195268788138598401', '角色权限', '2', 'role.acl', 'role/distribution/:id', '/acl/role/roleForm', null, null, '0', '2019-11-15 17:21:38', '2019-11-15 17:21:38');
INSERT INTO `acl_permission` VALUES ('1195270744097742849', '1195268893830864898', '查看', '2', 'permission.list', '', '', null, null, '0', '2019-11-15 17:22:07', '2019-11-15 17:22:07');
INSERT INTO `acl_permission` VALUES ('1195270810560684034', '1195268893830864898', '添加', '2', 'permission.add', '', '', null, null, '0', '2019-11-15 17:22:23', '2019-11-15 17:22:23');
INSERT INTO `acl_permission` VALUES ('1195270862100291586', '1195268893830864898', '修改', '2', 'permission.update', '', '', null, null, '0', '2019-11-15 17:22:35', '2019-11-15 17:22:35');
INSERT INTO `acl_permission` VALUES ('1195270887933009922', '1195268893830864898', '删除', '2', 'permission.remove', '', '', null, null, '0', '2019-11-15 17:22:41', '2019-11-15 17:22:41');
INSERT INTO `acl_permission` VALUES ('1195349439240048642', '1', '讲师管理', '1', null, '/teacher', 'Layout', null, null, '0', '2019-11-15 22:34:49', '2019-11-15 22:34:49');
INSERT INTO `acl_permission` VALUES ('1195349699995734017', '1195349439240048642', '讲师列表', '1', null, 'table', '/edu/teacher/list', null, null, '0', '2019-11-15 22:35:52', '2019-11-15 22:35:52');
INSERT INTO `acl_permission` VALUES ('1195349810561781761', '1195349439240048642', '添加讲师', '1', null, 'save', '/edu/teacher/save', null, null, '0', '2019-11-15 22:36:18', '2019-11-15 22:36:18');
INSERT INTO `acl_permission` VALUES ('1195349876252971010', '1195349810561781761', '添加', '2', 'teacher.add', '', '', null, null, '0', '2019-11-15 22:36:34', '2019-11-15 22:36:34');
INSERT INTO `acl_permission` VALUES ('1195349979797753857', '1195349699995734017', '查看', '2', 'teacher.list', '', '', null, null, '0', '2019-11-15 22:36:58', '2019-11-15 22:36:58');
INSERT INTO `acl_permission` VALUES ('1195350117270261762', '1195349699995734017', '修改', '2', 'teacher.update', 'edit/:id', '/edu/teacher/save', null, null, '0', '2019-11-15 22:37:31', '2019-11-15 22:37:31');
INSERT INTO `acl_permission` VALUES ('1195350188359520258', '1195349699995734017', '删除', '2', 'teacher.remove', '', '', null, null, '0', '2019-11-15 22:37:48', '2019-11-15 22:37:48');
INSERT INTO `acl_permission` VALUES ('1195350299365969922', '1', '课程分类', '1', null, '/subject', 'Layout', null, null, '0', '2019-11-15 22:38:15', '2019-11-15 22:38:15');
INSERT INTO `acl_permission` VALUES ('1195350397751758850', '1195350299365969922', '课程分类列表', '1', null, 'list', '/edu/subject/list', null, null, '0', '2019-11-15 22:38:38', '2019-11-15 22:38:38');
INSERT INTO `acl_permission` VALUES ('1195350500512206850', '1195350299365969922', '导入课程分类', '1', null, 'save', '/edu/subject/save', null, null, '0', '2019-11-15 22:39:03', '2019-11-15 22:39:03');
INSERT INTO `acl_permission` VALUES ('1195350612172967938', '1195350397751758850', '查看', '2', 'subject.list', '', '', null, null, '0', '2019-11-15 22:39:29', '2019-11-15 22:39:29');
INSERT INTO `acl_permission` VALUES ('1195350687590748161', '1195350500512206850', '导入', '2', 'subject.import', '', '', null, null, '0', '2019-11-15 22:39:47', '2019-11-15 22:39:47');
INSERT INTO `acl_permission` VALUES ('1195350831744782337', '1', '课程管理', '1', null, '/course', 'Layout', null, null, '0', '2019-11-15 22:40:21', '2019-11-15 22:40:21');
INSERT INTO `acl_permission` VALUES ('1195350919074385921', '1195350831744782337', '课程列表', '1', null, 'list', '/edu/course/list', null, null, '0', '2019-11-15 22:40:42', '2019-11-15 22:40:42');
INSERT INTO `acl_permission` VALUES ('1195351020463296513', '1195350831744782337', '发布课程', '1', null, 'info', '/edu/course/info', null, null, '0', '2019-11-15 22:41:06', '2019-11-15 22:41:06');
INSERT INTO `acl_permission` VALUES ('1195351159672246274', '1195350919074385921', '完成发布', '2', 'course.publish', 'publish/:id', '/edu/course/publish', null, null, '0', '2019-11-15 22:41:40', '2019-11-15 22:44:01');
INSERT INTO `acl_permission` VALUES ('1195351326706208770', '1195350919074385921', '编辑课程', '2', 'course.update', 'info/:id', '/edu/course/info', null, null, '0', '2019-11-15 22:42:19', '2019-11-15 22:42:19');
INSERT INTO `acl_permission` VALUES ('1195351566221938690', '1195350919074385921', '编辑课程大纲', '2', 'chapter.update', 'chapter/:id', '/edu/course/chapter', null, null, '0', '2019-11-15 22:43:17', '2019-11-15 22:43:17');
INSERT INTO `acl_permission` VALUES ('1195351862889254913', '1', '统计分析', '1', null, '/statistics', 'Layout', null, null, '0', '2019-11-15 22:44:27', '2019-11-15 22:44:27');
INSERT INTO `acl_permission` VALUES ('1195351968841568257', '1195351862889254913', '生成统计', '1', null, 'create', '/statistics/create', null, null, '0', '2019-11-15 22:44:53', '2019-11-15 22:44:53');
INSERT INTO `acl_permission` VALUES ('1195352054917074946', '1195351862889254913', '统计图表', '1', null, 'show', '/statistics/show', null, null, '0', '2019-11-15 22:45:13', '2019-11-15 22:45:13');
INSERT INTO `acl_permission` VALUES ('1195352054917074947', '1195351862889254913', '数据统计', '1', null, 'allDataShow', '/statistics/allDataShow', null, null, '0', '2021-02-21 11:42:53', '2021-02-21 11:42:57');
INSERT INTO `acl_permission` VALUES ('1195352127734386690', '1195352054917074946', '查看', '2', 'daily.list', '', '', null, null, '0', '2019-11-15 22:45:30', '2019-11-15 22:45:30');
INSERT INTO `acl_permission` VALUES ('1195352215768633346', '1195351968841568257', '生成', '2', 'daily.add', '', '', null, null, '0', '2019-11-15 22:45:51', '2019-11-15 22:45:51');
INSERT INTO `acl_permission` VALUES ('1195352547621965825', '1', '内容管理', '1', null, '/cms', 'Layout', null, null, '0', '2019-11-15 22:47:11', '2021-04-27 14:29:47');
INSERT INTO `acl_permission` VALUES ('1195352856645701633', '1195353513549205505', '查看', '2', 'banner.list', '', '', null, null, '0', '2019-11-15 22:48:24', '2019-11-15 22:48:24');
INSERT INTO `acl_permission` VALUES ('1195352909401657346', '1195353513549205505', '添加', '2', 'banner.add', 'banner/add', '/cms/banner/form', null, null, '0', '2019-11-15 22:48:37', '2019-11-18 10:52:10');
INSERT INTO `acl_permission` VALUES ('1195353051395624961', '1195353513549205505', '修改', '2', 'banner.update', 'banner/update/:id', '/cms/banner/form', null, null, '0', '2019-11-15 22:49:11', '2019-11-18 10:52:05');
INSERT INTO `acl_permission` VALUES ('1195353513549205505', '1195352547621965825', 'Bander列表', '1', null, 'banner/list', '/cms/banner/list', null, null, '0', '2019-11-15 22:51:01', '2019-11-18 10:51:29');
INSERT INTO `acl_permission` VALUES ('1195353513549205506', '1195352547621965825', 'Bander预览', '1', null, 'banner/show', '/cms/banner/show', null, null, '0', '2021-04-27 14:24:29', '2021-04-27 14:24:31');
INSERT INTO `acl_permission` VALUES ('1195353672110673921', '1195353513549205505', '删除', '2', 'banner.remove', '', '', null, null, '0', '2019-11-15 22:51:39', '2019-11-15 22:51:39');
INSERT INTO `acl_permission` VALUES ('1195354076890370050', '1', '订单管理', '1', null, '/order', 'Layout', null, null, '0', '2019-11-15 22:53:15', '2019-11-15 22:53:15');
INSERT INTO `acl_permission` VALUES ('1195354153482555393', '1195354076890370050', '订单列表', '1', null, 'list', '/order/list', null, null, '0', '2019-11-15 22:53:33', '2019-11-15 22:53:58');
INSERT INTO `acl_permission` VALUES ('1195354315093282817', '1195354153482555393', '查看', '2', 'order.list', '', '', null, null, '0', '2019-11-15 22:54:12', '2019-11-15 22:54:12');
INSERT INTO `acl_permission` VALUES ('1196301740985311234', '1195268616021139457', '分配角色', '2', 'user.assgin', 'user/role/:id', '/acl/user/roleForm', null, null, '0', '2019-11-18 13:38:56', '2019-11-18 13:38:56');
INSERT INTO `acl_permission` VALUES ('1386930078113390594', '1195354076890370050', '订单预览', '1', null, 'show', 'order/show', null, null, '0', '2021-04-27 14:27:53', '2021-04-27 14:27:53');
INSERT INTO `acl_permission` VALUES ('1387692921549090817', '1386930078113390594', '查看', '2', 'select', '', '', null, null, '0', '2021-04-29 16:59:09', '2021-04-29 16:59:09');

-- ----------------------------
-- Table structure for acl_role
-- ----------------------------
DROP TABLE IF EXISTS `acl_role`;
CREATE TABLE `acl_role` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '角色id',
  `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色编码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of acl_role
-- ----------------------------
INSERT INTO `acl_role` VALUES ('1', '系统管理员', null, null, '0', '2019-11-11 13:09:32', '2019-11-18 10:27:18');
INSERT INTO `acl_role` VALUES ('1193757683205607426', '课程管理员', null, null, '0', '2019-11-11 13:09:45', '2019-11-18 10:25:44');
INSERT INTO `acl_role` VALUES ('1387932235117731841', '测试角色', null, null, '0', '2021-04-30 08:50:06', '2021-04-30 08:50:06');

-- ----------------------------
-- Table structure for acl_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `acl_role_permission`;
CREATE TABLE `acl_role_permission` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '主键id',
  `role_id` char(19) NOT NULL DEFAULT '' COMMENT '角色id',
  `permission_id` char(19) NOT NULL DEFAULT '' COMMENT '权限id',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_permission_id` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限';

-- ----------------------------
-- Records of acl_role_permission
-- ----------------------------
INSERT INTO `acl_role_permission` VALUES ('1195352704094867233', '1193757683205607426', '1195350919074385921', '0', '2021-02-20 16:58:34', '2021-02-20 16:58:37');
INSERT INTO `acl_role_permission` VALUES ('1195352705667564576', '1193757683205607426', '1195351566221938690', '0', '2021-02-20 17:00:17', '2021-02-20 17:00:18');
INSERT INTO `acl_role_permission` VALUES ('1195352705667564678', '1193757683205607426', '1', '0', '2021-02-20 17:00:47', '2021-02-20 17:00:49');
INSERT INTO `acl_role_permission` VALUES ('1195352706867542336', '1193757683205607426', '1195351020463296513', '0', '2021-02-20 16:59:19', '2021-02-20 16:59:21');
INSERT INTO `acl_role_permission` VALUES ('1195352706867564576', '1193757683205607426', '1195351326706208770', '0', '2021-02-20 16:59:31', '2021-02-20 16:59:33');
INSERT INTO `acl_role_permission` VALUES ('1196312702601695234', '1', '1', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702652026881', '1', '1195268474480156673', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702668804098', '1', '1195268616021139457', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702698164226', '1', '1195269143060602882', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702723330049', '1', '1195269295926206466', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702744301569', '1', '1195269473479483394', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702765273089', '1', '1195269547269873666', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702790438913', '1', '1196301740985311234', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702945628161', '1', '1195268788138598401', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702970793985', '1', '1195269821262782465', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703000154114', '1', '1195269903542444034', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703025319938', '1', '1195270037005197313', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703046291458', '1', '1195270442602782721', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703063068673', '1', '1195270621548568578', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703084040193', '1', '1195268893830864898', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703113400321', '1', '1195270744097742849', '0', '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703134371842', '1', '1195270810560684034', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703159537665', '1', '1195270862100291586', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703184703490', '1', '1195270887933009922', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703209869313', '1', '1195349439240048642', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703230840834', '1', '1195349699995734017', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703251812354', '1', '1195349979797753857', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703272783873', '1', '1195350117270261762', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703293755394', '1', '1195350188359520258', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703327309826', '1', '1195349810561781761', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703348281345', '1', '1195349876252971010', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703365058561', '1', '1195350299365969922', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703386030082', '1', '1195350397751758850', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703440556034', '1', '1195350612172967938', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703486693378', '1', '1195350500512206850', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703511859202', '1', '1195350687590748161', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703654465537', '1', '1195350831744782337', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703683825665', '1', '1195350919074385921', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703700602882', '1', '1195351159672246274', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703717380098', '1', '1195351326706208770', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703738351618', '1', '1195351566221938690', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703759323137', '1', '1195351020463296513', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703776100353', '1', '1195351862889254913', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703792877570', '1', '1195351968841568257', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703830626305', '1', '1195352215768633346', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703843209217', '1', '1195352054917074946', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703868375041', '1', '1195352127734386690', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703889346561', '1', '1195352547621965825', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703901929473', '1', '1195353513549205505', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703918706689', '1', '1195352856645701633', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703952261121', '1', '1195352909401657346', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703973232642', '1', '1195353051395624961', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703990009857', '1', '1195353672110673921', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312704048730114', '1', '1195354076890370050', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312704069701633', '1', '1195354153482555393', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312704094867233', '1193757683205607426', '1195350831744782337', '0', '2021-02-20 16:15:58', '2021-02-20 16:16:01');
INSERT INTO `acl_role_permission` VALUES ('1196312704094867364', '1193757683205607426', '1195351159672246274', '0', '2021-02-20 16:41:57', '2021-02-20 16:42:00');
INSERT INTO `acl_role_permission` VALUES ('1196312704094867457', '1', '1195354315093282817', '0', '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312704094867567', '1', '1195352054917074947', '0', '2021-05-10 15:10:28', '2021-05-10 15:10:31');
INSERT INTO `acl_role_permission` VALUES ('1387932591503548417', '1387932235117731841', '1', '0', '2021-04-30 08:51:31', '2021-04-30 08:51:31');

-- ----------------------------
-- Table structure for acl_user
-- ----------------------------
DROP TABLE IF EXISTS `acl_user`;
CREATE TABLE `acl_user` (
  `id` char(19) NOT NULL COMMENT '用户id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名称',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '用户密码',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `salt` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `token` varchar(100) DEFAULT NULL COMMENT '用户签名',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of acl_user
-- ----------------------------
INSERT INTO `acl_user` VALUES ('1', 'admin', '$2a$10$0/E5EhjcDYUxm.WTuO0RpOsNlZGsHf3zdMEpI1zHiT8GWuFsAhY8G', 'admin', 'http://192.168.0.196:8002/archive/2020/12/28/0a0c4774-cdea-42b8-b219-4801dc72380e.gif', null, '0', '2019-11-01 10:39:47', '2019-11-01 10:39:47');
INSERT INTO `acl_user` VALUES ('1362644652288671746', 'class_admin', '$2a$10$ZwcMZNPJ6uPzS60Rd09iye7P50RGm0uG/uJB9zHRaJd3X0rVCfM5W', 'nickname', 'http://192.168.0.196:8002/archive/2020/12/28/0a0c4774-cdea-42b8-b219-4801dc72380e.gif', null, '0', '2021-04-27 09:21:48', '2021-04-27 16:31:18');
INSERT INTO `acl_user` VALUES ('1381876564723011585', 'Dcl_Snow', '$2a$10$ZwcMZNPJ6uPzS60Rd09iye7P50RGm0uG/uJB9zHRaJd3X0rVCfM5W', '昵称', 'http://192.168.0.196:8002/archive/2020/12/28/0a0c4774-cdea-42b8-b219-4801dc72380e.gif', null, '0', '2021-04-13 15:47:02', '2021-04-13 15:47:02');

-- ----------------------------
-- Table structure for acl_user_role
-- ----------------------------
DROP TABLE IF EXISTS `acl_user_role`;
CREATE TABLE `acl_user_role` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '主键id',
  `role_id` char(19) NOT NULL DEFAULT '0' COMMENT '角色id',
  `user_id` char(19) NOT NULL DEFAULT '0' COMMENT '用户id',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of acl_user_role
-- ----------------------------
INSERT INTO `acl_user_role` VALUES ('1', '1', '1', '0', '2019-11-11 13:09:53', '2019-11-11 13:09:53');
INSERT INTO `acl_user_role` VALUES ('1381877785181589505', '1', '1381876564723011585', '0', '2021-04-13 15:51:53', '2021-04-13 15:51:53');
INSERT INTO `acl_user_role` VALUES ('2', '1193757683205607426', '1362644652288671746', '0', '2021-02-19 14:06:57', '2021-02-19 14:06:59');

-- ----------------------------
-- Table structure for crm_banner
-- ----------------------------
DROP TABLE IF EXISTS `crm_banner`;
CREATE TABLE `crm_banner` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '轮播图id',
  `title` varchar(20) DEFAULT '' COMMENT '标题',
  `image_url` varchar(500) NOT NULL DEFAULT '' COMMENT '图片地址',
  `link_url` varchar(500) DEFAULT '' COMMENT '链接地址',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='首页banner表';

-- ----------------------------
-- Records of crm_banner
-- ----------------------------
INSERT INTO `crm_banner` VALUES ('1194607458461216769', 'banner1', 'http://192.168.0.196:8004/archive/2021/02/21/364d70d0-182d-49f6-af89-43c5fb9b18f5.jpg', '/course', '2', '0', '2019-11-13 21:26:27', '2019-11-14 09:12:15');
INSERT INTO `crm_banner` VALUES ('1332135220014530562', 'banner3', 'http://192.168.0.196:8004/archive/2021/02/21/8fc3a46f-6e01-44a1-bafe-7419787fa3b6.jpg', '/course', '3', '0', '2020-11-27 09:32:41', '2020-11-27 09:32:41');
INSERT INTO `crm_banner` VALUES ('1332136173518241794', 'banner2', 'http://192.168.0.196:8004/archive/2021/02/21/cdff801f-1b5c-4d15-b230-42aee1476c2d.jpg', '/course', '0', '0', '2020-11-27 09:36:28', '2020-11-27 09:36:28');

-- ----------------------------
-- Table structure for edu_chapter
-- ----------------------------
DROP TABLE IF EXISTS `edu_chapter`;
CREATE TABLE `edu_chapter` (
  `id` char(19) NOT NULL COMMENT '章节id',
  `course_id` char(19) NOT NULL COMMENT '课程id',
  `title` varchar(50) NOT NULL COMMENT '章节标题',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '显示排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='课程';

-- ----------------------------
-- Records of edu_chapter
-- ----------------------------
INSERT INTO `edu_chapter` VALUES ('1289477499608125442', '1289474026963591170', '第一章', '4', '2020-08-01 16:26:08', '2020-08-01 16:26:08');
INSERT INTO `edu_chapter` VALUES ('1291572702452154370', '1291572591215017986', '第一章：java基础', '1', '2020-08-07 11:11:43', '2020-08-07 11:11:43');
INSERT INTO `edu_chapter` VALUES ('1291572790889054209', '1291572591215017986', '第二章：java实战', '0', '2020-08-07 11:12:04', '2020-08-07 11:12:04');
INSERT INTO `edu_chapter` VALUES ('1291578497965355009', '1291578418688815106', '第一章：C++基础', '1', '2020-08-07 11:34:45', '2020-08-07 11:34:45');
INSERT INTO `edu_chapter` VALUES ('1291579860443066370', '1291579791601954818', '第一章：vue基础', '1', '2020-08-07 11:40:10', '2020-08-07 11:40:10');
INSERT INTO `edu_chapter` VALUES ('1331164335128461314', '1331164298201808898', '第一章', '0', '2020-11-24 17:14:44', '2020-11-24 17:14:44');
INSERT INTO `edu_chapter` VALUES ('1331165789134274562', '1331164298201808898', '第二章', '0', '2020-11-24 17:20:31', '2020-11-24 17:20:31');
INSERT INTO `edu_chapter` VALUES ('1331835408744525826', '1331835380135178242', '第一章', '0', '2020-11-26 13:41:20', '2020-11-26 13:41:20');
INSERT INTO `edu_chapter` VALUES ('1331838148992380930', '1331838122803146754', '第一章', '0', '2020-11-26 13:52:14', '2020-11-26 13:52:14');

-- ----------------------------
-- Table structure for edu_comment
-- ----------------------------
DROP TABLE IF EXISTS `edu_comment`;
CREATE TABLE `edu_comment` (
  `id` char(19) NOT NULL COMMENT '评论id',
  `course_id` varchar(19) NOT NULL DEFAULT '' COMMENT '课程id',
  `teacher_id` char(19) NOT NULL DEFAULT '' COMMENT '讲师id',
  `member_id` varchar(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_teacher_id` (`teacher_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Records of edu_comment
-- ----------------------------
INSERT INTO `edu_comment` VALUES ('1336957065519706114', '1291572591215017986', '', '1333590624326131713', 'Dcl_Snow', 'http://192.168.0.196:8002/archive/2020/12/28/0a0c4774-cdea-42b8-b219-4801dc72380e.gif', '测试评论', '0', '2020-12-10 16:52:59', '2020-12-10 16:52:59');
INSERT INTO `edu_comment` VALUES ('1338387493090881538', '1331838122803146754', '1189390295668469762', '1333590624326131713', 'Dcl_Snow', 'http://192.168.0.196:8002/archive/2020/12/28/0a0c4774-cdea-42b8-b219-4801dc72380e.gif', '添加评论', '0', '2020-12-14 15:36:59', '2020-12-14 15:36:59');

-- ----------------------------
-- Table structure for edu_course
-- ----------------------------
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE `edu_course` (
  `id` char(19) NOT NULL COMMENT '课程id',
  `teacher_id` char(19) NOT NULL COMMENT '讲师id',
  `subject_id` char(19) NOT NULL COMMENT '二级分类id',
  `subject_parent_id` char(19) DEFAULT NULL COMMENT '一级分类id',
  `title` varchar(50) NOT NULL COMMENT '课程标题',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '总课时',
  `cover` varchar(255) NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '销售数量',
  `view_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `status` varchar(10) NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `is_deleted` tinyint(3) DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_title` (`title`),
  KEY `idx_subject_id` (`subject_id`),
  KEY `idx_teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='课程';

-- ----------------------------
-- Records of edu_course
-- ----------------------------
INSERT INTO `edu_course` VALUES ('1291572591215017986', '1', '1287584831156346881', '1287584829847724033', 'java高级编程', '0.01', '40', 'http://192.168.0.196:8004/archive/2021/02/22/00106e18-ff6d-4d54-8473-a52fc5b0b5b6.jpg', '10', '58', '1', 'Normal', '0', '2020-08-07 11:11:17', '2021-02-22 10:40:56');
INSERT INTO `edu_course` VALUES ('1291578418688815106', '1189426437876985857', '1287584832318169090', '1287584829847724033', 'C++基础编程', '0.01', '23', 'http://192.168.0.196:8004/archive/2021/02/22/d95f376e-b8a9-491b-9e6e-f897ddf4410e.jpg', '3', '35', '1', 'Normal', '0', '2020-08-07 11:34:26', '2021-02-22 10:41:08');
INSERT INTO `edu_course` VALUES ('1291579791601954818', '1285513791865458689', '1287584828027396097', '1287584827628937217', 'vue基础编程', '0.00', '30', 'http://192.168.0.196:8004/archive/2021/02/22/9b5dda17-1a52-445e-afaa-6a14d86f3db3.jpg', '15', '35', '1', 'Normal', '0', '2020-08-07 11:39:53', '2021-02-22 10:41:18');
INSERT INTO `edu_course` VALUES ('1331164298201808898', '1', '1287584829436682241', '1287584827628937217', 'JavaScript教程', '9.90', '10', 'http://192.168.0.196:8004/archive/2021/02/22/6fce545c-c28f-4bae-b886-27b81c002c98.jpg', '26', '45', '1', 'Normal', '0', '2020-11-24 17:14:35', '2021-02-22 10:41:26');
INSERT INTO `edu_course` VALUES ('1331835380135178242', '1189389726308478977', '1331834561998434305', '1331834561885188097', '投资理论', '199.00', '20', 'http://192.168.0.196:8004/archive/2021/02/22/f655f6d6-0cf6-4a49-8dad-a9065671b825.jpg', '50', '99', '1', 'Normal', '0', '2020-11-26 13:41:14', '2021-02-22 10:41:37');
INSERT INTO `edu_course` VALUES ('1331838122803146754', '1189390295668469762', '1331834561998434305', '1331834561885188097', '投资思维', '299.00', '30', 'http://192.168.0.196:8004/archive/2021/02/22/97691d6a-ab3b-4491-89b1-9a7eda54f213.jpg', '69', '87', '1', 'Normal', '0', '2020-11-26 13:52:07', '2021-02-22 10:41:46');
INSERT INTO `edu_course` VALUES ('1331841464677773314', '1189426437876985857', '1331834562019405825', '1331834561885188097', '电磁感应', '0.00', '15', 'http://192.168.0.196:8004/archive/2021/02/22/6fd2afc1-e22c-41fc-bf4d-08988a6adc3f.jpg', '18', '67', '1', 'Normal', '0', '2020-11-26 14:05:24', '2021-02-22 10:41:55');
INSERT INTO `edu_course` VALUES ('1331842442500059137', '1', '1287584828027396097', '1287584827628937217', 'Vue高级编程', '0.00', '40', 'http://192.168.0.196:8004/archive/2021/02/22/700ae206-e00b-40fa-9784-7a0a044019b6.jpg', '34', '34', '1', 'Normal', '0', '2020-11-26 14:09:17', '2021-02-22 10:42:04');

-- ----------------------------
-- Table structure for edu_course_collect
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_collect`;
CREATE TABLE `edu_course_collect` (
  `id` char(19) NOT NULL COMMENT '收藏ID',
  `course_id` char(19) NOT NULL COMMENT '课程id',
  `member_id` char(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='课程收藏';

-- ----------------------------
-- Records of edu_course_collect
-- ----------------------------
INSERT INTO `edu_course_collect` VALUES ('1196269345666019330', '1192252213659774977', '1', '1', '2019-11-18 11:30:12', '2019-11-18 11:30:12');

-- ----------------------------
-- Table structure for edu_course_description
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_description`;
CREATE TABLE `edu_course_description` (
  `id` char(19) NOT NULL COMMENT '课程简介id',
  `description` text COMMENT '课程简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程简介';

-- ----------------------------
-- Records of edu_course_description
-- ----------------------------
INSERT INTO `edu_course_description` VALUES ('1291572591215017986', '<p>java高级编程课程</p>', '2020-08-07 11:11:18', '2021-02-22 10:40:56');
INSERT INTO `edu_course_description` VALUES ('1291578418688815106', '<p>C++真的好难啊</p>', '2020-08-07 11:34:26', '2021-02-22 10:41:08');
INSERT INTO `edu_course_description` VALUES ('1291579791601954818', '<p>vue是一门基于javascript的课程</p>', '2020-08-07 11:39:54', '2021-02-22 10:41:18');
INSERT INTO `edu_course_description` VALUES ('1323098697537433601', '<p>机器学习示例课程，总课程80节</p>', '2020-11-02 14:55:04', '2020-11-02 16:18:53');
INSERT INTO `edu_course_description` VALUES ('1331164298201808898', '<p>JavaScript课程</p>', '2020-11-24 17:14:35', '2021-02-22 10:41:26');
INSERT INTO `edu_course_description` VALUES ('1331835380135178242', '<p>投资是货币收入或其他任何能以货币计量其价值的财富拥有者牺牲当前消费、购买或购置资本品以期在未来实现价值增值的谋利性经营性活动。</p>', '2020-11-26 13:41:14', '2021-02-22 10:41:37');
INSERT INTO `edu_course_description` VALUES ('1331838122803146754', '<p>当钢铁侠的导演为了丰富角色找到埃隆&middot;马斯克时，他对当制作人表达了强烈的兴趣，电影中一部分镜头是在SpaceX总部空旷的厂区拍摄，在最后的字幕表里，埃隆&middot;马斯克的名字列在&ldquo;特别感谢&rdquo;那一栏。</p>', '2020-11-26 13:52:07', '2021-02-22 10:41:46');
INSERT INTO `edu_course_description` VALUES ('1331841464677773314', '<p>电磁课程</p>', '2020-11-26 14:05:24', '2021-02-22 10:41:55');
INSERT INTO `edu_course_description` VALUES ('1331842442500059137', '<p>vue</p>', '2020-11-26 14:09:17', '2021-02-22 10:42:04');

-- ----------------------------
-- Table structure for edu_subject
-- ----------------------------
DROP TABLE IF EXISTS `edu_subject`;
CREATE TABLE `edu_subject` (
  `id` char(19) NOT NULL COMMENT '课程分类ID',
  `title` varchar(19) NOT NULL COMMENT '课程分类标题',
  `parent_id` char(19) NOT NULL DEFAULT '0' COMMENT '父id',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='课程科目';

-- ----------------------------
-- Records of edu_subject
-- ----------------------------
INSERT INTO `edu_subject` VALUES ('1287584827628937217', '前端开发', '0', '0', '2020-07-27 11:05:20', '2020-07-27 11:05:20');
INSERT INTO `edu_subject` VALUES ('1287584828027396097', 'vue', '1287584827628937217', '0', '2020-07-27 11:05:20', '2020-07-27 11:05:20');
INSERT INTO `edu_subject` VALUES ('1287584828836896769', 'javascript', '1287584827628937217', '0', '2020-07-27 11:05:20', '2020-07-27 11:05:20');
INSERT INTO `edu_subject` VALUES ('1287584829436682241', 'jquery', '1287584827628937217', '0', '2020-07-27 11:05:20', '2020-07-27 11:05:20');
INSERT INTO `edu_subject` VALUES ('1287584829847724033', '后端开发', '0', '0', '2020-07-27 11:05:20', '2020-07-27 11:05:20');
INSERT INTO `edu_subject` VALUES ('1287584831156346881', 'java', '1287584829847724033', '0', '2020-07-27 11:05:21', '2020-07-27 11:05:21');
INSERT INTO `edu_subject` VALUES ('1287584832318169090', 'C++', '1287584829847724033', '0', '2020-07-27 11:05:21', '2020-07-27 11:05:21');
INSERT INTO `edu_subject` VALUES ('1287584833152835586', '数据库开发', '0', '0', '2020-07-27 11:05:21', '2020-07-27 11:05:21');
INSERT INTO `edu_subject` VALUES ('1287584833853284353', 'mysql', '1287584833152835586', '0', '2020-07-27 11:05:21', '2020-07-27 11:05:21');
INSERT INTO `edu_subject` VALUES ('1331834561780330498', '性能测试', '0', '0', '2020-11-26 13:37:58', '2020-11-26 13:37:58');
INSERT INTO `edu_subject` VALUES ('1331834561805496322', 'Loadrunner', '1331834561780330498', '0', '2020-11-26 13:37:58', '2020-11-26 13:37:58');
INSERT INTO `edu_subject` VALUES ('1331834561839050753', 'Jmeter', '1331834561780330498', '0', '2020-11-26 13:37:58', '2020-11-26 13:37:58');
INSERT INTO `edu_subject` VALUES ('1331834561864216578', 'postman并发测试', '1331834561780330498', '0', '2020-11-26 13:37:58', '2020-11-26 13:37:58');
INSERT INTO `edu_subject` VALUES ('1331834561885188097', '经济学', '0', '0', '2020-11-26 13:37:59', '2020-11-26 13:37:59');
INSERT INTO `edu_subject` VALUES ('1331834561906159617', '海洋经济', '1331834561885188097', '0', '2020-11-26 13:37:59', '2020-11-26 13:37:59');
INSERT INTO `edu_subject` VALUES ('1331834561939714050', '贸易经济', '1331834561885188097', '0', '2020-11-26 13:37:59', '2020-11-26 13:37:59');
INSERT INTO `edu_subject` VALUES ('1331834561998434305', '投资学', '1331834561885188097', '0', '2020-11-26 13:37:59', '2020-11-26 13:37:59');
INSERT INTO `edu_subject` VALUES ('1331834562019405825', '财政学', '1331834561885188097', '0', '2020-11-26 13:37:59', '2020-11-26 13:37:59');

-- ----------------------------
-- Table structure for edu_teacher
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE `edu_teacher` (
  `id` char(19) NOT NULL COMMENT '讲师id',
  `name` varchar(20) NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int(10) unsigned NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) DEFAULT NULL COMMENT '讲师头像',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='讲师';

-- ----------------------------
-- Records of edu_teacher
-- ----------------------------
INSERT INTO `edu_teacher` VALUES ('1', '杰夫·贝佐斯', '1986年，毕业于美国普林斯顿大学，进入纽约的一家高新技术开发公司FITEL，主要从事计算机系统开发。\n1988年，进入华尔街的Bankers Trust Co，担任副总裁。\n1990年至1994年，与他人一起组建套头基金交易管理公司D.E. Shaw & Co，于1992年成为副总裁。\n1995年7月16日成立Cadabra网络书店，后将Cadabra更名为亚马逊。', '首席', '2', 'http://192.168.0.196:8002/archive/2021/02/22/262570ac-6fe0-402b-8596-523666b0f52a.png', '0', '0', '2019-10-30 14:18:46', '2021-02-22 09:51:28');
INSERT INTO `edu_teacher` VALUES ('1189389726308478977', '沃伦·巴菲特', '1947年，沃伦·巴菲特进入宾夕法尼亚大学攻读财务和商业管理。但他觉得教授们的空头理论不过瘾，两年后转学到内布拉斯加大学林肯分校，一年内获得了经济学学士学位。\n1950年巴菲特申请哈佛大学被拒之门外，考入哥伦比亚大学商学院，拜师于著名投资学理论学家本杰明·格雷厄姆。在格雷厄姆门下，巴菲特如鱼得水。\n格雷厄姆反对投机，主张通过分析企业的赢利情况、资产情况及未来前景等因素来评价股票，他传授给巴菲特丰富的知识和诀窍。\n1951年，21周岁的巴菲特获得了哥伦比亚大学经济学硕士学位。', '首席', '2', 'http://192.168.0.196:8002/archive/2021/02/22/3ccb8684-1a40-4af5-b631-c54eb9eab092.png', '1', '0', '2019-10-30 11:53:03', '2021-02-22 09:51:43');
INSERT INTO `edu_teacher` VALUES ('1189390295668469762', '埃隆·马斯克', '1981年，10岁的埃隆·马斯克利用自己攒的零花钱和父亲赞助的部分资金买了人生中第一台电脑，之后又买了一本编程教科书，并且学会了如何编程。\n1983年，12岁的埃隆·马斯克成功设计出一个名叫“Blastar”的太空游戏软件，之后以500美元的价格出售给了《PC and Office Technology》杂志，赚到了人生的第一桶金。\n1988年，17岁的埃隆·马斯克从比勒陀利亚男子高中毕业后离开家庭，只身前往加拿大，寄居于母亲亲戚家中。\n1989年，埃隆·马斯克获得加拿大国籍，并于次年申请进入了位于安大略省的皇后大学。\n1992年，埃隆·马斯克依靠奖学金转入美国宾夕法尼亚大学沃顿商学院攻读经济学，大学期间，埃隆·马斯克开始深入关注互联网、清洁能源、太空这三个影响人类未来发展的领域。 埃隆·马斯克在取得经济学学士学位后，又留校一年拿到了物理学学士学位。\n1995年，24岁的埃隆·马斯克进入斯坦福大学攻读材料科学和应用物理 [17]  博士课程，但在入学后的第2天，埃隆·马斯克决定离开学校开始创业。', '首席', '2', 'http://192.168.0.196:8002/archive/2021/02/22/c5f5d938-17b0-4c80-b7ab-139315ed25a2.png', '2', '0', '2019-10-30 11:55:19', '2021-02-22 09:51:58');
INSERT INTO `edu_teacher` VALUES ('1189426437876985857', '尼古拉·特斯拉', '1856年7月10日，出生于当时奥地利帝国的斯米良。1895年，他替美国尼亚加拉发电站制造发电机组，该发电站至今仍是世界著名水电站之一。1897年，他使马可尼的无线电通信理论成为现实。1898年，他制造出世界上第一艘无线电遥控船，无线电遥控技术取得专利。1899年，他发明了X光（X-Ray）摄影技术。其他发明包括：收音机、传真机、真空管、霓虹灯管、飞弹导航等。以他的名字命名了磁密度单位（1Tesla=10000Gause），表明他在磁学上的贡献。', '首席', '2', 'http://192.168.0.196:8002/archive/2021/02/22/0dd8eecd-ad19-447e-98fd-9b93f6624502.png', '0', '0', '2019-10-30 14:18:56', '2021-02-22 09:52:14');
INSERT INTO `edu_teacher` VALUES ('1189426464967995393', '比尔·盖茨', '1955年10月28日，威廉·亨利·盖茨三世（William Henry Gates III），即比尔·盖茨的正式姓名，出生于美国西海岸华盛顿州的西雅图市。\n1973年，盖茨考进了哈佛大学，盖茨在SAT（美国大学入学考试）标准化测试中得分1590（满分1600）。虽然盖茨记忆力很好，但他却有不少“臭毛病”：经常逃课、不爱洗澡、在编程或玩牌时就只吃比萨饼和喝苏打水。与同宿舍的史蒂夫·鲍尔默（Steve Ballmer）结为密友。在哈佛的时候，盖茨为第一台微型计算机MITS Altair开发了BASIC编程语言的一个版本。\n1976年11月26日，盖茨和艾伦注册了“微软”（Microsoft）商标。他们曾一度考虑将公司名称定为“艾伦和盖茨公司”（Allen & Gates Inc.），但后来决定改为“Micro-Soft”（注：即“微型软件”的英文缩写），并把该名称中间的英文连字符去掉。当时艾伦23岁，盖茨21岁。', '高级讲师', '1', 'http://192.168.0.196:8002/archive/2021/02/22/d940f67e-71fe-4fdb-b573-a9b2b0a9dc7f.png', '0', '0', '2019-10-30 14:19:02', '2021-02-22 10:00:02');
INSERT INTO `edu_teacher` VALUES ('1192249914833055746', '拉里·佩奇', '拉里·佩奇1973年出生在美国密歇根州东兰辛市的一个犹太家庭，父亲卡尔文森·佩奇是一个密歇根州立大学计算机教授，拥有计算机科学博士学位，母亲葛洛丽亚·佩奇也是密歇根州立大学（MSU）的一个计算机教授，是一名犹太教徒。\n1996年，佩奇和布林开始合作研究一名为“BackRub”的搜索引擎，到1998年上半年逐步完善这项技术后，两人合作运行Google搜索，并以PageRank为基础给网页排名，同时两人也开始为这项技术寻找合作伙伴。', '高级讲师', '1', 'http://192.168.0.196:8002/archive/2021/02/22/a295e40c-507f-4b8f-ae30-c5960d6f1862.png', '2', '0', '2019-11-07 09:18:25', '2021-02-22 10:21:10');
INSERT INTO `edu_teacher` VALUES ('1285513791865458689', '谢尔盖·布林', '谢尔盖·布林，全名谢尔盖·米哈伊洛维奇·布林，出生在俄罗斯莫斯科，Google公司联合创始人之一。\n谢尔盖·布林出生在苏联莫斯科的一个犹太家庭，父母两人皆毕业于莫斯科国立大学。\n谢尔盖6岁时（1979年），全家决定自苏联移民至美国居住。移民至美国后，他的父亲成为一位在马里兰大学任教的数学教授，而母亲叶夫根尼娅则为美国航空航天局的戈达德太空飞行中心工作。\n互联网魅力深深地吸引着布林，他把互联网视为通往未来的必经之路。早在上大学的时候，布林就已经发明了一种超文本语言格式的搜索系统1998年9月，24岁的布林和25岁的佩奇决定合伙开个公司，公司提供的唯一服务就是搜索引擎。在对商业计划一无所知的情况下，布林从一位斯坦福校友那里顺利地拿到了第一笔投资：10万美元，依靠这10万美元，在朋友的一个车库里，布林和佩奇开始了Google的征程。', '讲师', '2', 'http://192.168.0.196:8002/archive/2021/02/22/4a424294-b45b-42d0-b08e-2d7d476a3748.png', '1', '0', '2020-07-21 17:55:46', '2021-04-19 16:41:56');
INSERT INTO `edu_teacher` VALUES ('1286195532611514369', '马克·扎克伯格', '马克·艾略特·扎克伯格，1984年5月14日生于美国纽约州白原市，社交网站Facebook的创始人兼首席执行官，被人们冠以“第二盖茨”的美誉。\n1984年5月14日，扎克伯格出生于纽约的一个犹太人家庭。扎克伯格开始写程序是在中学时期。他的父亲在20世纪90年代曾教导他Atari BASIC Programming，之后聘请软件研发者David Newman当他的家教。Newman曾说扎克伯格是一个神童。\n2004年，就读哈佛大学本科的扎克伯格和两位室友一起，只用了一个星期的时间就建立起了Facebook，并最终因为网站大受欢迎而决定辍学，迁移至加州硅谷专心创业。\n如今，它已成为世界上最重要的社交网站之一，就连前美国总统奥巴马、英国女王伊丽莎白二世等政界要人都成了Facebook 的用户。', '讲师', '2', 'http://192.168.0.196:8002/archive/2021/02/22/1878e0ee-0b88-4619-9575-128262fd5726.png', '3', '0', '2020-07-23 15:04:46', '2021-04-19 16:48:18');
INSERT INTO `edu_teacher` VALUES ('1286210099911651329', '杰克·多西', '杰克·多西，1976年11月19日出生，美国软件设计师和商人，Twitter和Square联合创始人兼CEO。\n曾从密苏里州科技大学转到纽约大学之后不久，就退学前往加州找工作。可是多西在加州的职场生涯一开始并不顺利，他曾多次跳槽。\n2008年多西和比兹斯通、埃文·威廉姆斯共同创建了Twitter。', '讲师', '2', 'http://192.168.0.196:8002/archive/2021/02/22/286fb2f8-72ef-407b-9548-8f4a991f28fd.png', '1', '0', '2020-07-23 16:02:39', '2021-04-19 16:50:05');
INSERT INTO `edu_teacher` VALUES ('1331164018223628290', '陈士骏', '陈士骏是美国华裔企业家，毕业于美国伊利诺伊大学厄巴纳-香槟分校，为网络影音分享网站YouTube的创始人之一。\n目前是美国杂志Business 2.0公布的全球排名第28最具影响力企业人物。', '讲师', '2', 'http://192.168.0.196:8002/archive/2021/02/22/bb376655-7552-44a9-b8cf-f880ca8e1f62.png', '0', '0', '2020-11-24 17:13:28', '2021-04-19 17:02:03');
INSERT INTO `edu_teacher` VALUES ('1349250977928081410', 'Dcl_Snow', '现在精伦电子集团旗下普利商用机器有限公司架构组任职。', '讲师', '1', 'http://192.168.0.196:8002/archive/2021/02/22/0bb16794-2270-4813-8f26-139a4411606b.png', '1', '1', '2021-01-13 15:04:36', '2021-02-22 10:24:22');

-- ----------------------------
-- Table structure for edu_video
-- ----------------------------
DROP TABLE IF EXISTS `edu_video`;
CREATE TABLE `edu_video` (
  `id` char(19) NOT NULL COMMENT '视频id',
  `course_id` char(19) DEFAULT NULL COMMENT '课程id',
  `chapter_id` char(19) NOT NULL COMMENT '章节id',
  `title` varchar(50) NOT NULL COMMENT '视频节点标题',
  `video_source_id` varchar(100) DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) DEFAULT NULL COMMENT '原始文件名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `play_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '播放次数',
  `is_free` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否可以试听：0收费(默认) 1免费',
  `duration` float NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
  `status` varchar(20) NOT NULL DEFAULT 'Empty' COMMENT 'Empty未上传 Transcoding转码中  Normal正常',
  `size` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_chapter_id` (`chapter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='课程视频';

-- ----------------------------
-- Records of edu_video
-- ----------------------------
INSERT INTO `edu_video` VALUES ('1291573110968975361', '1291572591215017986', '1291572702452154370', '第一小节：', 'd6864320a48d48959bf4c0be5cf13aa2', 'English With Lucy.mp4', '1', '0', '0', '0', 'Empty', '0', '1', '2020-08-07 11:13:21', '2020-12-09 11:26:56');
INSERT INTO `edu_video` VALUES ('1291573229105741825', '1291572591215017986', '1291572790889054209', '第一小节：实战准备工作+', 'a7f3b91abddb4206a262239f548c3890', 'English With Lucy.mp4', '1', '0', '0', '0', 'Empty', '0', '1', '2020-08-07 11:13:49', '2020-12-09 11:28:52');
INSERT INTO `edu_video` VALUES ('1291578647525847041', '1291578418688815106', '1291578497965355009', '第一小节：数组', '86380d286b2c43889e6992378f8fb83b', '222.mp4', '1', '0', '0', '0', 'Empty', '0', '1', '2020-08-07 11:35:21', '2020-08-07 11:35:21');
INSERT INTO `edu_video` VALUES ('1291580678927937537', '1291579791601954818', '1291579860443066370', '第一小节：vue指令', 'cf1ad0dc7d9f4e82926774faa80ed80f', '222.mp4', '1', '0', '0', '0', 'Empty', '0', '1', '2020-08-07 11:43:25', '2020-08-07 11:43:25');
INSERT INTO `edu_video` VALUES ('1331165671295303682', '1331164298201808898', '1331164335128461314', '课时1', '2ae932eebf5a464fa3ee528a060820e2', 'English With Lucy.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2020-11-24 17:20:03', '2020-11-24 17:20:03');

-- ----------------------------
-- Table structure for statistics_daily
-- ----------------------------
DROP TABLE IF EXISTS `statistics_daily`;
CREATE TABLE `statistics_daily` (
  `id` char(19) NOT NULL COMMENT '统计分析id',
  `date_calculated` varchar(20) NOT NULL COMMENT '统计日期',
  `register_num` int(11) NOT NULL DEFAULT '0' COMMENT '注册人数',
  `login_num` int(11) NOT NULL DEFAULT '0' COMMENT '登录人数',
  `video_view_num` int(11) NOT NULL DEFAULT '0' COMMENT '每日播放视频数',
  `course_num` int(11) NOT NULL DEFAULT '0' COMMENT '每日新增课程数',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `statistics_day` (`date_calculated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站统计日数据';

-- ----------------------------
-- Records of statistics_daily
-- ----------------------------
INSERT INTO `statistics_daily` VALUES ('1292669328344342531', '2020-08-07', '12', '162', '121', '110', '2021-01-22 15:14:35', '2021-01-22 15:14:38');
INSERT INTO `statistics_daily` VALUES ('1292669399337132032', '2020-08-08', '9', '141', '152', '190', '2021-01-22 15:16:32', '2021-01-22 15:16:35');
INSERT INTO `statistics_daily` VALUES ('1292669399337132033', '2020-08-10', '3', '150', '161', '151', '2020-08-10 11:49:36', '2020-08-10 11:49:36');
INSERT INTO `statistics_daily` VALUES ('1363676164769464322', '2020-08-06', '2', '0', '0', '0', '2021-02-22 10:25:08', '2021-02-22 10:25:08');
INSERT INTO `statistics_daily` VALUES ('1382242764137205762', '2020-08-09', '4', '0', '0', '0', '2021-04-14 16:02:10', '2021-04-14 16:02:10');

-- ----------------------------
-- Table structure for umc_user
-- ----------------------------
DROP TABLE IF EXISTS `umc_user`;
CREATE TABLE `umc_user` (
  `id` char(19) NOT NULL COMMENT '会员id',
  `openid` varchar(128) DEFAULT NULL COMMENT '微信openid',
  `mobile` varchar(11) DEFAULT '' COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '会员密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `sex` tinyint(2) unsigned DEFAULT NULL COMMENT '性别 1 女，2 男',
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
  `avatar` varchar(255) DEFAULT NULL COMMENT '会员头像',
  `sign` varchar(100) DEFAULT NULL COMMENT '会员签名',
  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用 1（true）已禁用，  0（false）未禁用',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of umc_user
-- ----------------------------
INSERT INTO `umc_user` VALUES ('1', null, '15970000000', '96e79218965eb72c92a549dd5a330112', 'Dcl_Snow', '2', '28', 'http://192.168.0.196:8002/archive/2020/12/28/0a0c4774-cdea-42b8-b219-4801dc72380e.gif', null, '0', '0', '2020-12-01 09:55:56', '2020-12-01 09:55:56');
