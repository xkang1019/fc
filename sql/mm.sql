/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.39 : Database - clouddo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `sl_diary` */

CREATE TABLE `sl_diary` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `weather` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '天气',
  `creationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `content` text COLLATE utf8_bin COMMENT '内容',
  `cardId` int(20) DEFAULT NULL COMMENT '卡片id',
  `cardImg` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '卡片背景',
  `contenTimg` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '内容图片',
  `pvNumber` tinyint(5) DEFAULT NULL COMMENT '访问量',
  `collectNumber` tinyint(5) DEFAULT NULL COMMENT '收藏量',
  `likeNumber` tinyint(6) DEFAULT NULL COMMENT '点赞量',
  `commentNumber` tinyint(6) DEFAULT NULL COMMENT '评论量',
  `transpondNumber` tinyint(6) DEFAULT NULL COMMENT '转发量',
  `haedImg` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '头像',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `type` tinyint(2) DEFAULT NULL COMMENT '类型',
  `cardContent` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '卡片短话',
  `userId` int(10) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sl_diary` */

insert  into `sl_diary`(`id`,`weather`,`creationTime`,`content`,`cardId`,`cardImg`,`contenTimg`,`pvNumber`,`collectNumber`,`likeNumber`,`commentNumber`,`transpondNumber`,`haedImg`,`name`,`type`,`cardContent`,`userId`) values (1,'天气晴1','2018-09-27 17:32:25','大撒大撒',1,'1','https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',1,1,1,1,1,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png','1',0,NULL,140),(2,'天气晴2','2018-09-27 17:32:20','的撒大',1,'1','https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',1,1,1,1,1,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png','1',0,NULL,140),(3,'天气晴3','2018-09-27 17:32:20','的撒大',1,'1','https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',1,1,1,1,1,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png','1',0,NULL,140),(4,'天气晴4','2018-09-27 17:32:19','我想知道你做什么！！！',1,NULL,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',NULL,NULL,NULL,NULL,NULL,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',NULL,1,NULL,140),(5,'天气晴5','2018-09-27 17:32:19','的撒大',1,NULL,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',NULL,NULL,NULL,NULL,NULL,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',NULL,0,NULL,140),(6,'天气晴6','2018-09-27 17:32:18','的撒大',1,NULL,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',NULL,NULL,NULL,NULL,NULL,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',NULL,0,NULL,140),(7,'天气晴7','2018-09-27 17:32:09','d撒旦撒',0,NULL,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',NULL,NULL,NULL,NULL,NULL,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',NULL,0,'',140),(8,'天气晴8','2018-09-28 17:32:12','dsad',0,NULL,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',NULL,NULL,NULL,NULL,NULL,'https://senlinmima.oss-cn-beijing.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20180811174657.png',NULL,0,'',140),(11,NULL,'2018-10-09 00:00:00','完全二群无',0,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'',139),(12,NULL,'2018-10-09 00:00:00','尾萼蔷薇',0,NULL,'http://tmp/wx852add591d6befab.o6zAJs_G5ccx5Ihp8TbPfhQBxUPI.bXtj1V7pffu675a91342c764dcf4f4bc336767e9acb2.png,http://tmp/wx852add591d6befab.o6zAJs_G5ccx5Ihp8TbPfhQBxUPI.dv96j7vtIxVA08be0ac97bfdab1b78abda8f8c18164c.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'',139),(13,NULL,'2018-10-19 00:00:00','hahhaha',0,NULL,'http://tmp/wx852add591d6befab.o6zAJs7ZpTL-gYDR3Vht3sBNC96Y.a53e188b9ecb6e417bdf3d3bbd911ebf.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'',140);

/*Table structure for table `sys_cards` */

CREATE TABLE `sys_cards` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '卡片ID',
  `card_url` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '卡片存放地址',
  `card_content` varchar(150) COLLATE utf8_bin DEFAULT NULL COMMENT '卡片描述内容',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_cards` */

insert  into `sys_cards`(`id`,`card_url`,`card_content`,`creation_time`) values (11,'http://suyongapp.oss-cn-beijing.aliyuncs.com/1538807841298.png','双鱼座很骚','2018-09-11 11:19:08'),(12,'https://senlinmima.oss-cn-beijing.aliyuncs.com/a1.png','有人曾说:\"如果你热爱自然就应该去新西兰\"@今日头条','2018-09-11 11:19:08'),(13,'https://senlinmima.oss-cn-beijing.aliyuncs.com/a2.png','埃菲尔铁塔每七年刷新一次？这些关于法兰西的冷知你可能不知道。@森林密码','2018-09-20 11:19:19');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
