/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.23-0ubuntu0.16.04.1 : Database - iris
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`iris` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `iris`;

/*Table structure for table `t_sys_dict` */

DROP TABLE IF EXISTS `t_sys_dict`;

CREATE TABLE `t_sys_dict` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(200) NOT NULL COMMENT '字典代码',
  `name` varchar(200) DEFAULT NULL COMMENT '字典名称',
  `is_valid` int(1) DEFAULT NULL COMMENT '是否有效（0:否；1:是）',
  `serial` int(10) DEFAULT NULL COMMENT '顺序',
  `update_user_id` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(50) DEFAULT NULL COMMENT '更新时间',
  `create_user_id` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='字典';

/*Data for the table `t_sys_dict` */

insert  into `t_sys_dict`(`id`,`code`,`name`,`is_valid`,`serial`,`update_user_id`,`update_time`,`create_user_id`,`create_time`,`remark`) values (1,'is_valid','是否有效',1,0,NULL,NULL,NULL,NULL,'（无效、有效）'),(2,'user_type','人员类型',1,1,NULL,NULL,NULL,NULL,'（系统、用户）'),(3,'room_state','房间状态',1,2,NULL,NULL,NULL,NULL,'（已创建、可进入、正在进行、暂停、已销毁）'),(8,'token_state','令牌状态',1,3,NULL,NULL,NULL,NULL,NULL),(9,'person_type','人员角色类型',1,4,NULL,NULL,NULL,NULL,NULL),(10,'state','janus服务状态',1,5,NULL,NULL,NULL,NULL,NULL),(11,'is_not','是否',1,6,NULL,NULL,NULL,NULL,NULL),(12,'publisher_state','参与者状态',1,7,NULL,NULL,NULL,NULL,NULL),(13,'scope','权限范围',1,8,'','2020-04-22 14:33:48','','2020-04-22 14:33:48',''),(14,'authorized_grant_types','授权模式',1,9,'','2020-04-22 14:44:32','','2020-04-22 14:44:32','');

/*Table structure for table `t_sys_dict_item` */

DROP TABLE IF EXISTS `t_sys_dict_item`;

CREATE TABLE `t_sys_dict_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dict_id` bigint(20) unsigned DEFAULT NULL COMMENT '字典编号',
  `dict_code` varchar(200) DEFAULT NULL COMMENT '字典代码',
  `value` varchar(200) DEFAULT NULL COMMENT '值',
  `label` varchar(200) DEFAULT NULL COMMENT '标签项',
  `serial` int(11) DEFAULT NULL COMMENT '顺序',
  `update_user_id` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(50) DEFAULT NULL COMMENT '更新时间',
  `create_user_id` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='字典项';

/*Data for the table `t_sys_dict_item` */

insert  into `t_sys_dict_item`(`id`,`dict_id`,`dict_code`,`value`,`label`,`serial`,`update_user_id`,`update_time`,`create_user_id`,`create_time`,`remark`) values (1,1,'is_valid','0','无效',1,NULL,NULL,NULL,NULL,NULL),(2,1,'is_valid','1','有效',2,NULL,NULL,NULL,NULL,NULL),(3,2,'user_type','0','系统用户',1,NULL,NULL,NULL,NULL,NULL),(4,2,'user_type','1','普通用户',2,NULL,NULL,NULL,NULL,NULL),(10,3,'room_state','created','已创建',1,NULL,NULL,NULL,NULL,NULL),(11,3,'room_state','joinable','可进入',2,NULL,NULL,NULL,NULL,NULL),(12,3,'room_state','progressing','正在进行',3,NULL,NULL,NULL,NULL,NULL),(13,3,'room_state','stop','暂停',4,NULL,NULL,NULL,NULL,NULL),(14,3,'room_state','destroyed','已销毁',5,NULL,NULL,NULL,NULL,NULL),(15,8,'token_state','remove','移除',1,NULL,NULL,NULL,NULL,NULL),(16,8,'token_state','enable','可用',2,NULL,NULL,NULL,NULL,NULL),(17,8,'token_state','disable','不可用',3,NULL,NULL,NULL,NULL,NULL),(18,9,'person_type','admin','管理者',1,NULL,NULL,NULL,NULL,NULL),(19,9,'person_type','publisher','发布者',2,NULL,NULL,NULL,NULL,NULL),(20,9,'person_type','subscriber','旁观者',3,NULL,NULL,NULL,NULL,NULL),(21,9,'person_type','overseer','监督者',4,NULL,NULL,NULL,NULL,NULL),(22,10,'janus_state','0','离线',1,NULL,NULL,NULL,NULL,NULL),(23,10,'janus_state','1','在线',2,NULL,NULL,NULL,NULL,NULL),(24,11,'is_not','0','否',1,NULL,NULL,NULL,NULL,NULL),(25,11,'is_not','1','是',2,NULL,NULL,NULL,NULL,NULL),(26,12,'publisher_state','init','初始化',1,NULL,NULL,NULL,NULL,NULL),(27,12,'publisher_state','joined','已加入',2,NULL,NULL,NULL,NULL,NULL),(28,12,'publisher_state','kicked','被踢出',NULL,NULL,NULL,NULL,NULL,NULL),(29,12,'publisher_state','blacked','被拉黑',NULL,NULL,NULL,NULL,NULL,NULL),(30,13,'scope','read','只读',1,'','2020-04-22 14:43:17','','2020-04-22 14:43:17',''),(31,13,'scope','write','只写',2,'','2020-04-22 14:43:33','','2020-04-22 14:43:33',''),(32,13,'scope','all','全部',3,'','2020-04-22 14:43:49','','2020-04-22 14:43:49',''),(33,14,'authorized_grant_types','password','密码模式',1,'','2020-04-22 14:44:46','','2020-04-22 14:44:46',''),(34,14,'authorized_grant_types','client_credentials','客户端模式',2,'','2020-04-22 14:44:59','','2020-04-22 14:44:59',''),(35,14,'authorized_grant_types','refresh_token','刷新',3,'','2020-04-22 14:45:17','','2020-04-22 14:45:17',''),(36,14,'authorized_grant_types','authorization_code','授权码模式',4,'','2020-04-22 14:45:37','','2020-04-22 14:45:37',''),(37,37,'state','1','2',1,'','2020-04-27 14:44:26','','2020-04-27 14:44:26',''),(38,15,'state','1','2',1,'','2020-04-27 14:44:26','','2020-04-27 14:44:26',''),(39,15,'state','1','2',1,'','2020-04-27 14:44:26','','2020-04-27 14:44:26',''),(40,15,'state','2','3',1,'','2020-04-27 14:44:26','','2020-04-27 14:44:26',''),(41,15,'state','2','3',2,'','2020-04-27 15:02:22','','2020-04-27 15:02:22',''),(42,15,'state','1','1',1,'','2020-04-27 15:02:33','','2020-04-27 15:02:33',''),(43,43,'state','1234','2',1,'','2020-04-27 15:02:42','','2020-04-27 15:02:42','');

/*Table structure for table `t_sys_param` */

DROP TABLE IF EXISTS `t_sys_param`;

CREATE TABLE `t_sys_param` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `config_key` varchar(200) NOT NULL COMMENT '配置键',
  `config_value` varchar(200) DEFAULT NULL COMMENT '配置值',
  `is_valid` int(1) NOT NULL COMMENT '是否有效（0:否；1:是）',
  `serial` int(11) DEFAULT NULL COMMENT '顺序',
  `update_user_id` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(50) DEFAULT NULL COMMENT '更新时间',
  `create_user_id` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `config_key_index` (`config_key`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='系统参数';

/*Data for the table `t_sys_param` */

insert  into `t_sys_param`(`id`,`name`,`config_key`,`config_value`,`is_valid`,`serial`,`update_user_id`,`update_time`,`create_user_id`,`create_time`,`remark`) values (3,'用户默认登录密码','resetPassword','111111',1,1,'','2020-04-22 09:51:31',NULL,'2020-04-22 09:51:31','密码重置数值'),(7,'进入房间令牌长度','allowedLen','4',1,2,NULL,'2020-04-22 09:51:31',NULL,'2020-04-27 16:22:31','进入房间令牌长度');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
