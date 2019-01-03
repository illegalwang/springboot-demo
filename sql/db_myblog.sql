/*
Navicat MySQL Data Transfer

Source Server         : 本机mysql
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : db_myblog

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-01-02 15:17:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for index_group_child
-- ----------------------------
DROP TABLE IF EXISTS `index_group_child`;
CREATE TABLE `index_group_child` (
  `WEB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `GROUP_ID` int(11) NOT NULL,
  `WEB_URL` varchar(255) NOT NULL,
  `WEB_NAME` varchar(255) NOT NULL,
  `WEB_ICON` varchar(255) DEFAULT NULL,
  `IF_DES` int(255) NOT NULL DEFAULT '0' COMMENT '是否有描述信息（0：没有，1：有）',
  PRIMARY KEY (`WEB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of index_group_child
-- ----------------------------
INSERT INTO `index_group_child` VALUES ('1', '1', 'https://illegalwang.github.io/ExtAPI/', 'Extjs-api 前端框架', 'https://github.com/favicon.ico', '1');
INSERT INTO `index_group_child` VALUES ('2', '1', 'http://jquery.cuishifeng.cn/index.html', 'jquery js库', 'http://jquery.cuishifeng.cn/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('3', '2', 'https://www.bilibili.com/', 'bilibili 哔哩哔哩', 'https://www.bilibili.com/favicon.ico', '1');
INSERT INTO `index_group_child` VALUES ('4', '2', 'http://www.youku.com/', 'youku 优酷视频', 'http://www.youku.com/favicon.ico', '1');
INSERT INTO `index_group_child` VALUES ('5', '2', 'https://www.mgtv.com/', 'mogoTV 芒果TV', 'https://www.mgtv.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('6', '3', 'http://study.163.com/', '网易云课堂', 'http://study.163.com/favicon.ico', '1');
INSERT INTO `index_group_child` VALUES ('7', '3', 'https://www.nowcoder.com/', '牛客-专业IT笔试面试备考平台', 'https://www.nowcoder.com/favicon.ico', '1');
INSERT INTO `index_group_child` VALUES ('8', '3', 'https://www.shiyanlou.com/', '实验楼-在线编程实验', 'https://www.shiyanlou.com/favicon.ico', '1');
INSERT INTO `index_group_child` VALUES ('9', '3', 'https://leetcode-cn.com/', 'LeetCode 编程题库', 'https://leetcode-cn.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('10', '4', 'http://spring.io/', 'spring 官网', 'http://spring.io/favicon.ico', '1');
INSERT INTO `index_group_child` VALUES ('11', '4', 'http://www.bootcss.com/', 'bootstrap 官网', 'http://www.bootcss.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('12', '4', 'https://www.oracle.com/index.html', 'oracle 官网', 'https://www.oracle.com/favicon.ico', '1');
INSERT INTO `index_group_child` VALUES ('13', '5', 'https://www.baidu.com/', 'baidu 百度一下，你就知道', 'https://www.baidu.com/favicon.ico', '1');
INSERT INTO `index_group_child` VALUES ('15', '9', 'https://www.baidu.com/', '百度一下，你就知道', 'https://www.baidu.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('16', '9', 'https://blog.csdn.net/', 'csdn , 第一时间获取新闻讯息', 'https://blog.csdn.net/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('17', '8', 'https://www.swiper.com.cn/', '开源，强大的滑动插件', 'https://www.swiper.com.cn/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('18', '8', 'http://man.linuxde.net/', 'linux 命令大全', 'http://man.linuxde.net/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('19', '8', 'https://www.appinn.com/markdown/#overview', 'markdown 语法说明', 'https://www.appinn.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('20', '4', 'http://freemarker.foofun.cn/', 'freemarker 中文官方文档', 'http://freemarker.foofun.cn/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('21', '1', 'https://pagehelper.github.io/', 'mybatis 分页插件 pagehelper', 'https://pagehelper.github.io/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('22', '1', 'http://www.mvnrepository.com/', 'maven 管理库', 'http://www.mvnrepository.com/assets/images/7080b8b0f6f48e6fbaffd5f9d85fcc7f-favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('23', '1', 'http://hadoop.apache.org/docs/r2.7.3/api/index.html', 'Apache Hadoop Main 2.7.3 API', 'http://hadoop.apache.org/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('24', '1', 'http://echarts.baidu.com/index.html', 'echarts 百度开源报表', 'http://echarts.baidu.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('25', '1', 'http://dubbo.io/', 'dubbo 微服务框架', 'http://dubbo.io/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('26', '1', 'http://54sb.org/journal_1_245.php', '代码人生，小狗窝博客', 'http://54sb.org/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('27', '1', 'https://www.layui.com/', 'layUI 经典模块化前端框架', 'https://www.layui.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('28', '1', 'https://tool.lu/', '程序员在线工具箱', 'https://tool.lu/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('29', '1', 'http://www.jq22.com/', 'jquery 插件库', 'http://www.jq22.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('30', '4', 'https://github.com/', 'github 最好的版本控制工具。。。之一', 'https://github.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('31', '4', 'http://www.mybatis.org/mybatis-3/', 'mybatis orm框架', 'http://www.mybatis.org/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('32', '4', 'http://www.eclipse.org/', 'eclipse 开发环境', 'http://www.eclipse.org/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('33', '4', 'https://open.alipay.com/platform/home.htm', '蚂蚁金服-支付宝开发接口', 'https://open.alipay.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('34', '4', 'https://start.spring.io/', 'spring boot 项目生成网站', 'https://start.spring.io/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('35', '3', 'https://www.cnblogs.com/summit7ca/p/6944215.html', 'Emmet 语法快速编写html', 'https://www.cnblogs.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('36', '3', 'https://segmentfault.com/a/1190000013950461', 'springboot+vue 前后端分离框架搭建', 'https://segmentfault.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('37', '8', 'https://www.sojson.com/qr.html', '二维码解析，美化，生成', 'https://www.sojson.com/favicon.ico', '0');
INSERT INTO `index_group_child` VALUES ('38', '8', 'http://tool.uixsj.cn/', '现实君工具箱', 'http://tool.uixsj.cn/favicon.ico', '0');

-- ----------------------------
-- Table structure for index_web_group
-- ----------------------------
DROP TABLE IF EXISTS `index_web_group`;
CREATE TABLE `index_web_group` (
  `GROUP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(255) NOT NULL,
  `LITTLE_TITLE` varchar(255) DEFAULT NULL,
  `IMAGE` varchar(255) DEFAULT NULL,
  `USER_ID` varchar(32) NOT NULL,
  `THEME` int(11) NOT NULL,
  PRIMARY KEY (`GROUP_ID`,`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of index_web_group
-- ----------------------------
INSERT INTO `index_web_group` VALUES ('1', 'Coding常用网站', '工具api', '/img/webgroup/itwjimg.jpg', '9314552ded3a4052947012f41a211733', '1');
INSERT INTO `index_web_group` VALUES ('2', '娱乐网站', '视频音频', '/img/webgroup/game.png', '9314552ded3a4052947012f41a211733', '2');
INSERT INTO `index_web_group` VALUES ('3', '学习网站', 'tools', '/img/webgroup/learn.jpg', '9314552ded3a4052947012f41a211733', '3');
INSERT INTO `index_web_group` VALUES ('4', '技术官网', '', '/img/webgroup/official.jpg', '9314552ded3a4052947012f41a211733', '1');
INSERT INTO `index_web_group` VALUES ('8', '常用编程软件', 'software', '/img/webgroup/user_img/fdd1545732279658168bba66f02bffa75e4.jpg', '9314552ded3a4052947012f41a211733', '3');
INSERT INTO `index_web_group` VALUES ('9', '32131', '12321', '/img/webgroup/user_img/ok1545793371607ab791b05749fc2df036.png', '9314552ded3a4052947012f41a211733', '2');
INSERT INTO `index_web_group` VALUES ('10', '小视频', '小视频', '/img/webgroup/user_img/微信图片_201812201752511545793435567ff58e34e62d9105ca3f.jpg', '9314552ded3a4052947012f41a211733', '1');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MENU_NAME` varchar(200) NOT NULL COMMENT '菜单名称',
  `MENU_PATH` varchar(255) DEFAULT NULL COMMENT '菜单路径',
  `PARENT_ID` int(11) NOT NULL DEFAULT '0' COMMENT '父id',
  `MENU_SORT` int(11) DEFAULT NULL COMMENT '排序',
  `CSS_CLASS` varchar(255) DEFAULT NULL COMMENT 'css样式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '文章管理', '', '0', '1', 'glyphicon glyphicon-file');
INSERT INTO `sys_menu` VALUES ('2', '评论管理', '', '0', '2', 'glyphicon glyphicon-pencil');
INSERT INTO `sys_menu` VALUES ('3', '系统管理', '#systemSetting', '0', '99', 'glyphicon glyphicon-cog');
INSERT INTO `sys_menu` VALUES ('4', '用户管理', '/user/usermanager', '3', '1', 'glyphicon glyphicon-user');
INSERT INTO `sys_menu` VALUES ('5', '菜单管理', '/menu/menumanager', '3', '2', 'glyphicon glyphicon-th-list');
INSERT INTO `sys_menu` VALUES ('6', '角色管理', '', '3', '3', 'glyphicon glyphicon-asterisk');
INSERT INTO `sys_menu` VALUES ('7', '修改密码', '', '3', '4', 'glyphicon glyphicon-edit');
INSERT INTO `sys_menu` VALUES ('22', '测试菜单', '#newCreate', '0', '4', 'glyphicon glyphicon-flag');
INSERT INTO `sys_menu` VALUES ('24', '测试子菜单', '', '22', '1', 'glyphicon glyphicon-fast-backward');
INSERT INTO `sys_menu` VALUES ('25', '测试三菜单', '', '22', '3', 'glyphicon glyphicon-camera');
INSERT INTO `sys_menu` VALUES ('26', '测试四菜单', '', '22', '3', 'glyphicon glyphicon-headphones');
INSERT INTO `sys_menu` VALUES ('27', '测试五菜单', '', '22', '6', 'glyphicon glyphicon-indent-right');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PERMISSION_NAME` varchar(255) NOT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'add', '', '添加权限');
INSERT INTO `sys_permission` VALUES ('2', 'delete', '', '删除权限');
INSERT INTO `sys_permission` VALUES ('3', 'update', '', '修改权限');
INSERT INTO `sys_permission` VALUES ('4', 'select', '', '查询权限');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员');
INSERT INTO `sys_role` VALUES ('2', '管理员');
INSERT INTO `sys_role` VALUES ('3', '用户');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `ROLE_ID` varchar(255) DEFAULT NULL,
  `MENU_ID` varchar(255) DEFAULT NULL,
  `PERMISSION_ID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('1', null, '1');
INSERT INTO `sys_role_resource` VALUES ('1', null, '2');
INSERT INTO `sys_role_resource` VALUES ('1', null, '3');
INSERT INTO `sys_role_resource` VALUES ('1', null, '4');
INSERT INTO `sys_role_resource` VALUES ('2', null, '1');
INSERT INTO `sys_role_resource` VALUES ('2', null, '3');
INSERT INTO `sys_role_resource` VALUES ('2', null, '4');
INSERT INTO `sys_role_resource` VALUES ('3', null, '4');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` varchar(32) NOT NULL COMMENT 'id',
  `USERNAME` varchar(100) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(100) NOT NULL COMMENT '密码',
  `TRUE_NAME` varchar(100) DEFAULT NULL,
  `INDEX_THEME` int(11) NOT NULL COMMENT '网站模板（1到4）',
  `EMAIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('9314552ded3a4052947012f41a211733', 'administrator', 'ce1712b709166a6e693779ebad1a1e3f', '超级管理员', '3', null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `USER_ID` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('27466997347244d8b107ab9e76464cdc', '2');
INSERT INTO `sys_user_role` VALUES ('9314552ded3a4052947012f41a211733', '1');
