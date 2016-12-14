/*
SQLyog Ultimate v11.42 (64 bit)
MySQL - 5.5.47 : Database - alllist
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`alllist` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `alllist`;

/*Table structure for table `t_local_auth` */

DROP TABLE IF EXISTS `t_local_auth`;

CREATE TABLE `t_local_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_status` bit(1) DEFAULT NULL COMMENT '逻辑删除状态',
  `del_reason` varchar(255) DEFAULT NULL COMMENT '删除原因',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_local_auth` */

insert  into `t_local_auth`(`id`,`create_date`,`update_date`,`delete_status`,`del_reason`,`user_id`,`password`) values (1,'2016-12-14 14:54:37','2016-12-14 14:54:37','\0',NULL,1,'44729aa5133510b40f92c48e128a2758');

/*Table structure for table `t_oauth2` */

DROP TABLE IF EXISTS `t_oauth2`;

CREATE TABLE `t_oauth2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  `del_reason` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `oauth_type` varchar(2) DEFAULT NULL,
  `oauth_name` varchar(40) DEFAULT NULL,
  `oauth_id` varchar(200) DEFAULT NULL,
  `oauth_key` varchar(100) DEFAULT NULL,
  `oauth_secret` varchar(100) DEFAULT NULL,
  `access_token` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_oauth2` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  `delete_status` bit(1) DEFAULT NULL,
  `del_reason` varchar(255) DEFAULT NULL,
  `sex` bit(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `last_login_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`create_date`,`update_date`,`username`,`delete_status`,`del_reason`,`sex`,`age`,`last_login_date`) values (1,'2016-12-14 14:54:36','2016-12-14 14:54:36','imant','\0',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
