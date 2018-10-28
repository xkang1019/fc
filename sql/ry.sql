/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.3-m13 : Database - ry
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `qrtz_blob_triggers` */

CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_blob_triggers` */

/*Table structure for table `qrtz_calendars` */

CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(200) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_calendars` */

/*Table structure for table `qrtz_cron_triggers` */

CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `cron_expression` varchar(200) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_cron_triggers` */

insert  into `qrtz_cron_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`cron_expression`,`time_zone_id`) values ('RuoyiScheduler','__TASK_CLASS_NAME__1','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('RuoyiScheduler','__TASK_CLASS_NAME__2','DEFAULT','0/20 * * * * ?','Asia/Shanghai');

/*Table structure for table `qrtz_fired_triggers` */

CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(200) DEFAULT NULL,
  `job_group` varchar(200) DEFAULT NULL,
  `is_nonconcurrent` varchar(1) DEFAULT NULL,
  `requests_recovery` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_fired_triggers` */

/*Table structure for table `qrtz_job_details` */

CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `job_class_name` varchar(250) NOT NULL,
  `is_durable` varchar(1) NOT NULL,
  `is_nonconcurrent` varchar(1) NOT NULL,
  `is_update_data` varchar(1) NOT NULL,
  `requests_recovery` varchar(1) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_job_details` */

insert  into `qrtz_job_details`(`sched_name`,`job_name`,`job_group`,`description`,`job_class_name`,`is_durable`,`is_nonconcurrent`,`is_update_data`,`requests_recovery`,`job_data`) values ('RuoyiScheduler','__TASK_CLASS_NAME__1','DEFAULT',NULL,'com.ruoyi.quartz.util.ScheduleJob','0','0','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0com.ruoyi.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0 com.ruoyi.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,�)�xpt\0\0pppt\00/10 * * * * ?t\0系统默认（无参）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0ryTaskt\0\nryNoParamst\0\0t\00t\01x\0'),('RuoyiScheduler','__TASK_CLASS_NAME__2','DEFAULT',NULL,'com.ruoyi.quartz.util.ScheduleJob','0','0','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0com.ruoyi.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0 com.ruoyi.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,�)�xpt\0\0pppt\00/20 * * * * ?t\0系统默认（有参）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0ryTaskt\0ryParamst\0ryt\00t\01x\0');

/*Table structure for table `qrtz_locks` */

CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_locks` */

insert  into `qrtz_locks`(`sched_name`,`lock_name`) values ('RuoyiScheduler','STATE_ACCESS'),('RuoyiScheduler','TRIGGER_ACCESS');

/*Table structure for table `qrtz_paused_trigger_grps` */

CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_paused_trigger_grps` */

/*Table structure for table `qrtz_scheduler_state` */

CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_scheduler_state` */

insert  into `qrtz_scheduler_state`(`sched_name`,`instance_name`,`last_checkin_time`,`checkin_interval`) values ('RuoyiScheduler','PC2017122223301540295518364',1540295709629,15000);

/*Table structure for table `qrtz_simple_triggers` */

CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simple_triggers` */

/*Table structure for table `qrtz_simprop_triggers` */

CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `str_prop_1` varchar(512) DEFAULT NULL,
  `str_prop_2` varchar(512) DEFAULT NULL,
  `str_prop_3` varchar(512) DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) DEFAULT NULL,
  `bool_prop_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simprop_triggers` */

/*Table structure for table `qrtz_triggers` */

CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_triggers` */

insert  into `qrtz_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`job_name`,`job_group`,`description`,`next_fire_time`,`prev_fire_time`,`priority`,`trigger_state`,`trigger_type`,`start_time`,`end_time`,`calendar_name`,`misfire_instr`,`job_data`) values ('RuoyiScheduler','__TASK_CLASS_NAME__1','DEFAULT','__TASK_CLASS_NAME__1','DEFAULT',NULL,1538895820000,-1,5,'PAUSED','CRON',1538895817000,0,NULL,0,'��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0com.ruoyi.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0 com.ruoyi.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,�)�xpt\0\0pppt\00/10 * * * * ?t\0系统默认（无参）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0ryTaskt\0\nryNoParamst\0\0t\00t\01x\0'),('RuoyiScheduler','__TASK_CLASS_NAME__2','DEFAULT','__TASK_CLASS_NAME__2','DEFAULT',NULL,1538895820000,-1,5,'PAUSED','CRON',1538895817000,0,NULL,0,'��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0com.ruoyi.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0 com.ruoyi.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,�)�xpt\0\0pppt\00/20 * * * * ?t\0系统默认（有参）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0ryTaskt\0ryParamst\0ryt\00t\01x\0');

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

/*Table structure for table `sys_config` */

CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(100) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

/*Data for the table `sys_config` */

insert  into `sys_config`(`config_id`,`config_name`,`config_key`,`config_value`,`config_type`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'主框架页-默认皮肤样式名称','sys.index.skinName','skin-default','Y','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','默认 skin-default、蓝色 skin-blue、黄色 skin-yellow'),(2,'用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','初始化密码 123456');

/*Table structure for table `sys_dept` */

CREATE TABLE `sys_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` int(11) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT '' COMMENT '负责人',
  `phone` varchar(11) DEFAULT '' COMMENT '联系电话',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`dept_id`,`parent_id`,`ancestors`,`dept_name`,`order_num`,`leader`,`phone`,`email`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`) values (100,0,'0','若依科技',0,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(101,100,'0,100','深圳总公司',1,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(102,100,'0,100','长沙分公司',2,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(103,101,'0,100,101','研发部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(104,101,'0,100,101','市场部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(105,101,'0,100,101','测试部门',3,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(106,101,'0,100,101','财务部门',4,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(107,101,'0,100,101','运维部门',5,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(108,102,'0,100,102','市场部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(109,102,'0,100,102','财务部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00');

/*Table structure for table `sys_dict_data` */

CREATE TABLE `sys_dict_data` (
  `dict_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT '' COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT '' COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

/*Data for the table `sys_dict_data` */

insert  into `sys_dict_data`(`dict_code`,`dict_sort`,`dict_label`,`dict_value`,`dict_type`,`css_class`,`list_class`,`is_default`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,1,'男','0','sys_user_sex','','','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','性别男'),(2,2,'女','1','sys_user_sex','','','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','性别女'),(3,3,'未知','2','sys_user_sex','','','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','性别未知'),(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','显示菜单'),(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','隐藏菜单'),(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','停用状态'),(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','停用状态'),(10,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统默认是'),(11,2,'否','N','sys_yes_no','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统默认否'),(12,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知'),(13,2,'公告','2','sys_notice_type','','success','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','公告'),(14,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(15,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','关闭状态'),(16,1,'新增','1','sys_oper_type','','info','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','新增操作'),(17,2,'修改','2','sys_oper_type','','info','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','修改操作'),(18,3,'删除','3','sys_oper_type','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','删除操作'),(19,4,'授权','4','sys_oper_type','','primary','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','授权操作'),(20,5,'导出','5','sys_oper_type','','warning','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','导出操作'),(21,6,'导入','6','sys_oper_type','','warning','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','导入操作'),(22,7,'强退','7','sys_oper_type','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','强退操作'),(23,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','生成操作'),(24,8,'清空数据','9','sys_oper_type','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','清空操作'),(25,1,'成功','0','sys_common_status','','primary','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(26,2,'失败','1','sys_common_status','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','停用状态');

/*Table structure for table `sys_dict_type` */

CREATE TABLE `sys_dict_type` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

/*Data for the table `sys_dict_type` */

insert  into `sys_dict_type`(`dict_id`,`dict_name`,`dict_type`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'用户性别','sys_user_sex','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','用户性别列表'),(2,'菜单状态','sys_show_hide','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','菜单状态列表'),(3,'系统开关','sys_normal_disable','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统开关列表'),(4,'任务状态','sys_job_status','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','任务状态列表'),(5,'系统是否','sys_yes_no','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统是否列表'),(6,'通知类型','sys_notice_type','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知类型列表'),(7,'通知状态','sys_notice_status','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知状态列表'),(8,'操作类型','sys_oper_type','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','操作类型列表'),(9,'系统状态','sys_common_status','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','登录状态列表');

/*Table structure for table `sys_job` */

CREATE TABLE `sys_job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT '' COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT '' COMMENT '任务方法',
  `method_params` varchar(200) DEFAULT '' COMMENT '方法参数',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '0' COMMENT '计划执行错误策略（0默认 1继续 2等待 3放弃）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';

/*Data for the table `sys_job` */

insert  into `sys_job`(`job_id`,`job_name`,`job_group`,`method_name`,`method_params`,`cron_expression`,`misfire_policy`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'ryTask','系统默认（无参）','ryNoParams','','0/10 * * * * ?','0','1','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(2,'ryTask','系统默认（有参）','ryParams','ry','0/20 * * * * ?','0','1','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','');

/*Table structure for table `sys_job_log` */

CREATE TABLE `sys_job_log` (
  `job_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT NULL COMMENT '任务方法',
  `method_params` varchar(200) DEFAULT '' COMMENT '方法参数',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` text COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

/*Data for the table `sys_job_log` */

/*Table structure for table `sys_logininfor` */

CREATE TABLE `sys_logininfor` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=408 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

/*Data for the table `sys_logininfor` */

insert  into `sys_logininfor`(`info_id`,`login_name`,`ipaddr`,`login_location`,`browser`,`os`,`status`,`msg`,`login_time`) values (100,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','密码输入错误1次','2018-10-07 15:03:51'),(101,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','密码输入错误2次','2018-10-07 15:03:59'),(102,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-07 15:04:49'),(103,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-07 15:09:47'),(104,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','密码输入错误1次','2018-10-07 15:33:27'),(105,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','密码输入错误2次','2018-10-07 15:33:33'),(106,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-07 15:33:39'),(107,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-07 18:50:00'),(108,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-07 18:50:01'),(109,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-07 18:50:03'),(110,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-07 18:50:03'),(111,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-07 18:50:05'),(112,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','密码输入错误1次','2018-10-07 18:53:47'),(113,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-07 18:54:18'),(114,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-07 18:54:28'),(115,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-07 19:19:40'),(116,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 11:10:47'),(117,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 11:15:08'),(118,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 11:19:29'),(119,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-08 11:20:18'),(120,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','密码输入错误1次','2018-10-08 11:20:42'),(121,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 11:20:59'),(122,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 11:26:41'),(123,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 11:28:12'),(124,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 11:30:41'),(125,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 11:36:03'),(126,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 11:39:35'),(127,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 11:47:30'),(128,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 12:57:09'),(129,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 12:58:41'),(130,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 14:22:57'),(131,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-08 14:32:23'),(132,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 14:32:27'),(133,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 14:40:18'),(134,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 14:46:51'),(135,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 14:49:52'),(136,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-08 14:50:02'),(137,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-08 14:51:32'),(138,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 14:51:36'),(139,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 14:54:02'),(140,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 14:55:40'),(141,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:00:07'),(142,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:03:58'),(143,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:10:52'),(144,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:14:58'),(145,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:20:54'),(146,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:22:36'),(147,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:22:39'),(148,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:25:40'),(149,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:27:17'),(150,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:33:55'),(151,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:42:09'),(152,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-08 15:48:37'),(153,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 15:48:47'),(154,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 16:10:54'),(155,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 18:50:42'),(156,'xkang','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-08 18:56:35'),(157,'xkang','127.0.0.1','XX XX','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-08 18:56:39'),(158,'xkang','127.0.0.1','XX XX','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-08 18:56:44'),(159,'aaa','127.0.0.1','XX XX','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-08 18:56:54'),(160,'aaa','127.0.0.1','XX XX','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-08 18:57:01'),(161,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-08 18:57:15'),(162,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-08 18:57:19'),(163,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-08 18:57:25'),(164,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-09 10:35:35'),(165,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-09 10:36:55'),(166,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-09 10:36:59'),(167,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-09 10:37:05'),(168,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-09 10:37:12'),(169,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-09 10:37:16'),(170,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-09 11:03:39'),(171,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-09 11:03:51'),(172,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','密码输入错误1次','2018-10-09 11:03:56'),(173,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-09 11:04:02'),(174,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-09 11:04:13'),(175,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-09 11:07:41'),(176,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-09 11:22:03'),(177,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-09 15:35:16'),(178,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-09 15:35:34'),(179,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-09 15:35:38'),(180,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-09 15:35:40'),(181,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-09 15:35:50'),(182,'admin','127.0.0.1','XX XX','Chrome Mobile','Mac OS X (iPhone)','0','登录成功','2018-10-09 15:36:24'),(183,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-09 18:19:46'),(184,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-09 18:20:09'),(185,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-09 18:20:13'),(186,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-09 18:20:24'),(187,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-09 18:20:31'),(188,'admin','127.0.0.1','XX XX','Internet Explorer 9','Windows 7','0','登录成功','2018-10-09 18:20:43'),(189,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-09 18:20:58'),(190,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 10:38:35'),(191,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 11:53:01'),(192,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 15:29:09'),(193,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 15:39:07'),(194,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 15:39:15'),(195,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-10 15:49:53'),(196,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 15:54:10'),(197,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 15:55:18'),(198,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 15:55:22'),(199,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 15:59:20'),(200,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 15:59:23'),(201,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 16:00:16'),(202,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','密码输入错误1次','2018-10-10 16:00:22'),(203,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 16:00:27'),(204,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 16:14:08'),(205,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 16:29:34'),(206,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 16:34:43'),(207,'admin','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 16:34:45'),(208,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 16:34:47'),(209,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 16:37:15'),(210,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 16:37:18'),(211,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 16:38:53'),(212,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 16:38:57'),(213,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 16:42:13'),(214,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 16:42:17'),(215,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 17:10:59'),(216,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 17:15:51'),(217,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 17:15:54'),(218,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 17:23:27'),(219,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 17:23:30'),(220,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 17:25:38'),(221,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 17:25:42'),(222,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 17:26:20'),(223,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','密码输入错误1次','2018-10-10 17:26:24'),(224,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','密码输入错误2次','2018-10-10 17:26:29'),(225,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 17:26:33'),(226,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-10 17:35:46'),(227,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 17:36:05'),(228,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 17:36:29'),(229,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 17:36:32'),(230,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-10 17:36:48'),(231,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 17:37:15'),(232,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 17:37:19'),(233,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-10 17:39:20'),(234,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-10 17:39:24'),(235,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-11 10:47:03'),(236,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 10:59:48'),(237,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:01:22'),(238,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','退出成功','2018-10-11 11:02:40'),(239,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:02:54'),(240,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:03:21'),(241,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:15:57'),(242,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:19:34'),(243,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-11 11:19:38'),(244,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:19:45'),(245,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:19:47'),(246,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-11 11:19:51'),(247,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:19:55'),(248,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:20:01'),(249,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:31:42'),(250,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:32:09'),(251,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-11 11:35:01'),(252,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-11 11:38:32'),(253,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:38:35'),(254,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:41:16'),(255,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:41:19'),(256,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:47:13'),(257,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:47:33'),(258,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-11 11:47:37'),(259,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:49:50'),(260,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:49:53'),(261,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:53:36'),(262,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:54:03'),(263,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-11 11:54:09'),(264,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-11 11:54:15'),(265,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','密码输入错误1次','2018-10-11 11:54:17'),(266,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:55:00'),(267,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:58:10'),(268,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:58:12'),(269,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 11:58:33'),(270,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 11:58:37'),(271,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 12:01:22'),(272,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 12:02:28'),(273,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 12:02:34'),(274,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 12:46:24'),(275,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 13:02:56'),(276,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 13:04:26'),(277,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 13:04:58'),(278,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 13:07:08'),(279,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 13:10:44'),(280,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 13:11:26'),(281,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 13:11:56'),(282,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 13:21:01'),(283,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 13:22:37'),(284,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 13:22:43'),(285,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','退出成功','2018-10-11 13:26:43'),(286,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 13:28:00'),(287,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 13:28:00'),(288,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 13:28:00'),(289,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 13:32:51'),(290,'admin','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-11 15:12:50'),(291,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 16:06:45'),(292,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 16:11:50'),(293,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 16:11:52'),(294,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 16:13:28'),(295,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 16:13:47'),(296,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','密码输入错误1次','2018-10-11 16:13:51'),(297,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','退出成功','2018-10-11 16:17:24'),(298,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','1','验证码错误','2018-10-11 16:19:07'),(299,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-11 16:19:11'),(300,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 16:32:03'),(301,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 16:32:05'),(302,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 16:32:05'),(303,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 16:35:57'),(304,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 16:36:24'),(305,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 16:55:46'),(306,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 17:03:09'),(307,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 17:05:59'),(308,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 17:07:19'),(309,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 17:10:05'),(310,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 17:17:30'),(311,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 17:41:10'),(312,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 17:41:10'),(313,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 17:41:36'),(314,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 17:41:39'),(315,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 17:54:53'),(316,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 17:54:55'),(317,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 17:56:40'),(318,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 17:56:43'),(319,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 18:09:41'),(320,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 18:09:46'),(321,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','退出成功','2018-10-11 18:12:19'),(322,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 18:12:33'),(323,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 18:12:44'),(324,'aaaa','127.0.0.1','XX XX','Chrome','Windows 7','0','登录成功','2018-10-11 18:12:47'),(325,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','退出成功','2018-10-11 18:12:59'),(326,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 18:13:02'),(327,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','退出成功','2018-10-11 18:16:03'),(328,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 18:16:05'),(329,'0000','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-11 18:16:21'),(330,'0000','127.0.0.1','XX XX','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-11 18:16:24'),(331,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 18:16:34'),(332,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 18:21:50'),(333,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 18:21:52'),(334,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-11 18:22:41'),(335,'aaaa','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-11 18:22:44'),(336,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 11:49:45'),(337,'dsadsadsadasd','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-12 12:03:47'),(338,'dsadsadsadasd','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-12 12:04:31'),(339,'dsadsadsadasd','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 12:08:23'),(340,'dsadsadsadasd','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 12:08:36'),(341,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 14:25:23'),(342,'dsadsadsadasd','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','退出成功','2018-10-12 14:25:45'),(343,'dsadsadsadasd','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 14:26:32'),(344,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 14:28:25'),(345,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 16:00:01'),(346,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-12 16:56:39'),(347,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','密码输入错误1次','2018-10-12 16:56:46'),(348,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 17:24:13'),(349,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','验证码错误','2018-10-12 17:24:42'),(350,'dsklafjhkdshfdjkghfdkj','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-12 17:25:09'),(351,'dsklafjhkdshfdjkghfdkj','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-12 17:26:02'),(352,'dsklafjhkdshfdjkghfdkj','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-12 17:27:03'),(353,'dsklafjhkdshfdjkghfdkj','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-12 17:27:09'),(354,'dsklafjhkdshfdjkghfdkj','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-12 17:27:11'),(355,'dsklafjhkdshfdjkghfdkj','127.0.0.1','XX 内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-12 17:27:14'),(356,'dsadsadsadasd','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 17:27:59'),(357,'dsadsadsafdsfdsfdsfdg','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 17:30:33'),(358,'dsadsadsafdsfdsfdsfdg','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 18:17:54'),(359,'admin','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','登录成功','2018-10-12 18:23:10'),(360,'dsadsadsafdsfdsfdsfdg','127.0.0.1','XX 内网IP','Chrome','Windows 7','0','退出成功','2018-10-12 18:32:24'),(361,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:01:49'),(362,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:01:54'),(363,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:02:02'),(364,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:02:16'),(365,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:02:24'),(366,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:02:55'),(367,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:03:20'),(368,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:03:21'),(369,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:03:22'),(370,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:03:23'),(371,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:03:24'),(372,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:03:31'),(373,'aaaa','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:04:11'),(374,'aaaa','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:04:18'),(375,'aaaa','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:04:26'),(376,'aaaa','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:04:32'),(377,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:07:14'),(378,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:07:17'),(379,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:13'),(380,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:14'),(381,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:14'),(382,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:15'),(383,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:16'),(384,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:17'),(385,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:18'),(386,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:19'),(387,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:20'),(388,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:20'),(389,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 16:10:21'),(390,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:10:24'),(391,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:10:30'),(392,'admin','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:11:19'),(393,'ry','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:15:43'),(394,'ry','127.0.0.1','内网IP','Chrome','Windows 7','1','用户不存在/密码错误','2018-10-17 16:15:59'),(395,'admin','127.0.0.1','内网IP','Chrome','Windows 7','0','登录成功','2018-10-17 16:17:48'),(396,'admin','127.0.0.1','内网IP','Chrome','Windows 7','0','退出成功','2018-10-17 16:18:30'),(397,'admin','127.0.0.1','内网IP','Chrome','Windows 7','0','登录成功','2018-10-17 16:52:40'),(398,'admin','127.0.0.1','内网IP','Chrome','Windows 7','0','退出成功','2018-10-17 17:03:02'),(399,'admin','127.0.0.1','内网IP','Chrome','Windows 7','0','登录成功','2018-10-17 17:03:21'),(400,'aaaa','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 17:04:01'),(401,'aaaa','127.0.0.1','内网IP','Chrome','Windows 7','1','密码输入错误1次','2018-10-17 17:04:07'),(402,'aaaa','127.0.0.1','内网IP','Chrome','Windows 7','0','登录成功','2018-10-17 17:04:13'),(403,'aaaa','127.0.0.1','内网IP','Chrome','Windows 7','1','验证码错误','2018-10-17 17:10:17'),(404,'aaaa','127.0.0.1','内网IP','Chrome','Windows 7','0','登录成功','2018-10-17 17:10:22'),(405,'admin','127.0.0.1','内网IP','Chrome','Windows 7','0','登录成功','2018-10-22 16:59:03'),(406,'admin','192.168.0.103','内网IP','Mobile Safari','Mac OS X (iPhone)','0','登录成功','2018-10-23 16:35:05'),(407,'admin','127.0.0.1','内网IP','Chrome','Windows 7','0','登录成功','2018-10-23 19:40:48');

/*Table structure for table `sys_menu` */

CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1056 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`menu_name`,`parent_id`,`order_num`,`url`,`menu_type`,`visible`,`perms`,`icon`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'系统管理',0,1,'#','M','0','','fa fa-gear','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统管理目录'),(2,'系统监控',0,2,'#','M','0','','fa fa-video-camera','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统监控目录'),(3,'系统工具',0,3,'#','M','0','','fa fa-bars','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统工具目录'),(100,'用户管理',1,1,'/system/user','C','0','system:user:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','用户管理菜单'),(101,'角色管理',1,2,'/system/role','C','0','system:role:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','角色管理菜单'),(102,'菜单管理',1,3,'/system/menu','C','0','system:menu:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','菜单管理菜单'),(103,'部门管理',1,4,'/system/dept','C','0','system:dept:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','部门管理菜单'),(104,'岗位管理',1,5,'/system/post','C','0','system:post:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','岗位管理菜单'),(105,'字典管理',1,6,'/system/dict','C','0','system:dict:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','字典管理菜单'),(106,'参数设置',1,7,'/system/config','C','0','system:config:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','参数设置菜单'),(107,'通知公告',1,8,'/system/notice','C','0','system:notice:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知公告菜单'),(108,'日志管理',1,9,'#','M','0','','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','日志管理菜单'),(109,'在线用户',2,1,'/monitor/online','C','0','monitor:online:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','在线用户菜单'),(110,'定时任务',2,2,'/monitor/job','C','0','monitor:job:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','定时任务菜单'),(111,'数据监控',2,3,'/monitor/data','C','0','monitor:data:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','数据监控菜单'),(112,'表单构建',3,1,'/tool/build','C','0','tool:build:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','表单构建菜单'),(113,'代码生成',3,2,'/tool/gen','C','0','tool:gen:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','代码生成菜单'),(114,'系统接口',3,3,'/tool/swagger','C','0','tool:swagger:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统接口菜单'),(500,'操作日志',108,1,'/monitor/operlog','C','0','monitor:operlog:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','操作日志菜单'),(501,'登录日志',108,2,'/monitor/logininfor','C','0','monitor:logininfor:view','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','登录日志菜单'),(1000,'用户查询',100,1,'#','F','0','system:user:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1001,'用户新增',100,2,'#','F','0','system:user:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1002,'用户修改',100,3,'#','F','0','system:user:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1003,'用户删除',100,4,'#','F','0','system:user:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1004,'用户导出',100,5,'#','F','0','system:user:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1005,'重置密码',100,5,'#','F','0','system:user:resetPwd','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1006,'角色查询',101,1,'#','F','0','system:role:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1007,'角色新增',101,2,'#','F','0','system:role:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1008,'角色修改',101,3,'#','F','0','system:role:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1009,'角色删除',101,4,'#','F','0','system:role:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1010,'角色导出',101,4,'#','F','0','system:role:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1011,'菜单查询',102,1,'#','F','0','system:menu:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1012,'菜单新增',102,2,'#','F','0','system:menu:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1013,'菜单修改',102,3,'#','F','0','system:menu:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1014,'菜单删除',102,4,'#','F','0','system:menu:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1015,'部门查询',103,1,'#','F','0','system:dept:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1016,'部门新增',103,2,'#','F','0','system:dept:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1017,'部门修改',103,3,'#','F','0','system:dept:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1018,'部门删除',103,4,'#','F','0','system:dept:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1019,'岗位查询',104,1,'#','F','0','system:post:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1020,'岗位新增',104,2,'#','F','0','system:post:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1021,'岗位修改',104,3,'#','F','0','system:post:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1022,'岗位删除',104,4,'#','F','0','system:post:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1023,'岗位导出',104,4,'#','F','0','system:post:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1024,'字典查询',105,1,'#','F','0','system:dict:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1025,'字典新增',105,2,'#','F','0','system:dict:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1026,'字典修改',105,3,'#','F','0','system:dict:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1027,'字典删除',105,4,'#','F','0','system:dict:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1028,'字典导出',105,4,'#','F','0','system:dict:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1029,'参数查询',106,1,'#','F','0','system:config:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1030,'参数新增',106,2,'#','F','0','system:config:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1031,'参数修改',106,3,'#','F','0','system:config:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1032,'参数删除',106,4,'#','F','0','system:config:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1033,'参数导出',106,4,'#','F','0','system:config:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1034,'公告查询',107,1,'#','F','0','system:notice:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1035,'公告新增',107,2,'#','F','0','system:notice:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1036,'公告修改',107,3,'#','F','0','system:notice:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1037,'公告删除',107,4,'#','F','0','system:notice:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1038,'操作查询',500,1,'#','F','0','monitor:operlog:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1039,'操作删除',500,2,'#','F','0','monitor:operlog:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1040,'详细信息',500,3,'#','F','0','monitor:operlog:detail','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1041,'日志导出',500,3,'#','F','0','monitor:operlog:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1042,'登录查询',501,1,'#','F','0','monitor:logininfor:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1043,'登录删除',501,2,'#','F','0','monitor:logininfor:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1044,'日志导出',501,2,'#','F','0','monitor:logininfor:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1045,'在线查询',109,1,'#','F','0','monitor:online:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1046,'批量强退',109,2,'#','F','0','monitor:online:batchForceLogout','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1047,'单条强退',109,3,'#','F','0','monitor:online:forceLogout','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1048,'任务查询',110,1,'#','F','0','monitor:job:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1049,'任务新增',110,2,'#','F','0','monitor:job:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1050,'任务修改',110,3,'#','F','0','monitor:job:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1051,'任务删除',110,4,'#','F','0','monitor:job:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1052,'状态修改',110,5,'#','F','0','monitor:job:changeStatus','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1053,'任务导出',110,5,'#','F','0','monitor:job:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1054,'生成查询',113,1,'#','F','0','tool:gen:list','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1055,'生成代码',113,2,'#','F','0','tool:gen:code','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','');

/*Table structure for table `sys_notice` */

CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(2) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(500) NOT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

/*Data for the table `sys_notice` */

insert  into `sys_notice`(`notice_id`,`notice_title`,`notice_type`,`notice_content`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'温馨提醒：2018-07-01 若依新版本发布啦','2','新版本内容','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','管理员'),(2,'维护通知：2018-07-01 若依系统凌晨维护','1','维护内容','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','管理员');

/*Table structure for table `sys_oper_log` */

CREATE TABLE `sys_oper_log` (
  `oper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(30) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(255) DEFAULT '' COMMENT '请求参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

/*Data for the table `sys_oper_log` */

insert  into `sys_oper_log`(`oper_id`,`title`,`business_type`,`method`,`operator_type`,`oper_name`,`dept_name`,`oper_url`,`oper_ip`,`oper_location`,`oper_param`,`status`,`error_msg`,`oper_time`) values (1,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin',NULL,'/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"null\" ]\r\n}',1,'There is no session with id [null]','2018-10-08 16:15:06'),(2,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin',NULL,'/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"1839d54b-d86a-40ab-ba0c-4b7984feb98c\" ]\r\n}',0,NULL,'2018-10-08 16:20:02'),(3,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin',NULL,'/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"1839d54b-d86a-40ab-ba0c-4b7984feb98c\" ]\r\n}',0,NULL,'2018-10-08 16:20:07'),(4,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin',NULL,'/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"09e1ff69-dc93-4825-b748-5ebaa69b0085\" ]\r\n}',0,NULL,'2018-10-08 18:55:18'),(5,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin',NULL,'/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"09e1ff69-dc93-4825-b748-5ebaa69b0085\" ]\r\n}',0,NULL,'2018-10-08 18:55:20'),(6,'用户管理',1,'com.ruoyi.web.controller.system.UserController.addSave()',1,'admin',NULL,'/system/user/add','127.0.0.1','XX XX','{\r\n  \"deptId\" : [ \"105\" ],\r\n  \"loginName\" : [ \"aaaa\" ],\r\n  \"userName\" : [ \"xkang\" ],\r\n  \"password\" : [ \"123456\" ],\r\n  \"email\" : [ \"xkang1019@163.com\" ],\r\n  \"phonenumber\" : [ \"18576750145\" ],\r\n  \"sex\" : [ \"0\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"roleIds\" : [ \"2\" ',0,NULL,'2018-10-08 18:56:26'),(7,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin',NULL,'/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"69efe205-cec5-4ed4-8339-3427d6cc485d\" ]\r\n}',1,'There is no session with id [69efe205-cec5-4ed4-8339-3427d6cc485d]','2018-10-08 18:57:40'),(8,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin',NULL,'/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"69efe205-cec5-4ed4-8339-3427d6cc485d\" ]\r\n}',1,'There is no session with id [69efe205-cec5-4ed4-8339-3427d6cc485d]','2018-10-08 18:57:45'),(9,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin',NULL,'/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"69efe205-cec5-4ed4-8339-3427d6cc485d\" ]\r\n}',1,'There is no session with id [69efe205-cec5-4ed4-8339-3427d6cc485d]','2018-10-08 18:57:55'),(10,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin',NULL,'/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"69efe205-cec5-4ed4-8339-3427d6cc485d\" ]\r\n}',1,'There is no session with id [69efe205-cec5-4ed4-8339-3427d6cc485d]','2018-10-08 18:59:33'),(11,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin',NULL,'/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"69efe205-cec5-4ed4-8339-3427d6cc485d\" ]\r\n}',1,'com.ruoyi.framework.shiro.session.OnlineSession cannot be cast to com.ruoyi.framework.shiro.session.OnlineSession','2018-10-08 19:01:16'),(12,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"4d7daf9d-6bff-45d6-93a5-bfa586d10b62\" ]\r\n}',0,NULL,'2018-10-09 10:37:24'),(13,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"4d7daf9d-6bff-45d6-93a5-bfa586d10b62\" ]\r\n}',0,NULL,'2018-10-09 10:40:50'),(14,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"4d7daf9d-6bff-45d6-93a5-bfa586d10b62\" ]\r\n}',0,NULL,'2018-10-09 10:49:04'),(15,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"4d7daf9d-6bff-45d6-93a5-bfa586d10b62\" ]\r\n}',0,NULL,'2018-10-09 10:49:29'),(16,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"4d7daf9d-6bff-45d6-93a5-bfa586d10b62\" ]\r\n}',0,NULL,'2018-10-09 10:52:27'),(17,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"4d7daf9d-6bff-45d6-93a5-bfa586d10b62\" ]\r\n}',1,'There is no session with id [4d7daf9d-6bff-45d6-93a5-bfa586d10b62]','2018-10-09 10:55:05'),(18,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"4d7daf9d-6bff-45d6-93a5-bfa586d10b62\" ]\r\n}',0,NULL,'2018-10-09 10:56:47'),(19,'代码生成',8,'com.ruoyi.web.controller.tool.GenController.genCode()',1,'admin','研发部门','/tool/gen/genCode/test','127.0.0.1','XX XX','{ }',0,NULL,'2018-10-09 11:25:58'),(20,'代码生成',8,'com.ruoyi.web.controller.tool.GenController.genCode()',1,'admin','研发部门','/tool/gen/genCode/testdome','127.0.0.1','XX XX','{ }',0,NULL,'2018-10-09 15:38:16'),(21,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"3b8ad6b6-b22e-4c28-8fc4-7667815d3141\" ]\r\n}',1,'There is no session with id [3b8ad6b6-b22e-4c28-8fc4-7667815d3141]','2018-10-10 15:54:47'),(22,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"a0e6f739-6312-410c-ab11-c6fbe45f5038\" ]\r\n}',0,NULL,'2018-10-10 15:55:03'),(23,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"d21d4688-d2ac-4135-bfd6-cb08727b01e8\" ]\r\n}',0,NULL,'2018-10-10 15:56:10'),(24,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"0ecfc5ef-912c-4542-9196-00ef04089275\" ]\r\n}',0,NULL,'2018-10-10 15:59:46'),(25,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"06853ef4-1a8b-4d8f-a98b-51868e1ab6a7\" ]\r\n}',0,NULL,'2018-10-10 16:00:46'),(26,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"2a69d044-8246-4150-8cb9-7b63bda3b0a7\" ]\r\n}',0,NULL,'2018-10-10 16:37:00'),(27,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"516f9a2b-a7d6-45da-a017-8e44714b9c40\" ]\r\n}',1,'There is no session with id [516f9a2b-a7d6-45da-a017-8e44714b9c40]','2018-10-10 16:37:04'),(28,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"e21f958c-ef28-4e8e-9a2e-26d8b45cb095\" ]\r\n}',0,NULL,'2018-10-10 16:37:27'),(29,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"9104de1d-b81d-46d9-a646-a7898dd933d5\" ]\r\n}',0,NULL,'2018-10-10 16:39:09'),(30,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"648ae4d5-0287-452a-88f9-47e8d4dcbe15\" ]\r\n}',0,NULL,'2018-10-10 16:42:49'),(31,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"648ae4d5-0287-452a-88f9-47e8d4dcbe15\" ]\r\n}',0,NULL,'2018-10-10 17:11:22'),(32,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"a01f5ff1-d43e-4248-acfb-63830828ffaa\" ]\r\n}',0,NULL,'2018-10-10 17:17:07'),(33,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"8b543d02-f795-45ec-b147-e3318d1fa407\" ]\r\n}',0,NULL,'2018-10-10 17:23:36'),(34,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"8b543d02-f795-45ec-b147-e3318d1fa407\" ]\r\n}',0,NULL,'2018-10-10 17:25:22'),(35,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"93c63fa6-ce3c-4be9-884f-bd6fd909af5d\" ]\r\n}',0,NULL,'2018-10-10 17:25:53'),(36,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"37dd59a7-a831-41c0-9bb6-07de6ddfa372\" ]\r\n}',0,NULL,'2018-10-10 17:26:48'),(37,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"421703e8-cc17-41f4-9a10-50eb50159249\" ]\r\n}',0,NULL,'2018-10-10 17:37:39'),(38,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"dc57cd1c-77f5-4125-b678-d61141edeeea\" ]\r\n}',0,NULL,'2018-10-10 17:39:41'),(39,'在线用户',7,'com.ruoyi.web.controller.monitor.UserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"645dd1cd-0071-46a2-bbc2-cfda3f5f9f15\" ]\r\n}',0,NULL,'2018-10-10 17:49:12'),(40,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"55da7c0a-cdec-4c03-a1b8-6817f4edfd9c\" ]\r\n}',0,NULL,'2018-10-11 11:03:20'),(41,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"a58402a6-3607-4457-89f0-407160cd1f75\" ]\r\n}',1,'There is no session with id [a58402a6-3607-4457-89f0-407160cd1f75]','2018-10-11 11:19:15'),(42,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"74a9ff4d-f183-4521-a273-8e38c0bf2fcc\" ]\r\n}',1,'There is no session with id [74a9ff4d-f183-4521-a273-8e38c0bf2fcc]','2018-10-11 11:31:50'),(43,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"74a9ff4d-f183-4521-a273-8e38c0bf2fcc\" ]\r\n}',0,NULL,'2018-10-11 11:33:20'),(44,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"74a9ff4d-f183-4521-a273-8e38c0bf2fcc\" ]\r\n}',0,NULL,'2018-10-11 11:33:35'),(45,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"74a9ff4d-f183-4521-a273-8e38c0bf2fcc\" ]\r\n}',0,NULL,'2018-10-11 11:35:59'),(46,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"74a9ff4d-f183-4521-a273-8e38c0bf2fcc\" ]\r\n}',0,NULL,'2018-10-11 11:38:07'),(47,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"96cfa03f-c3a5-4d5e-97b5-6b858bfa7a3b\" ]\r\n}',0,NULL,'2018-10-11 11:39:09'),(48,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"d1cbc6b1-7c32-491b-9732-da991b529f24\" ]\r\n}',0,NULL,'2018-10-11 11:41:26'),(49,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"1fa14f03-3d7b-4870-a39f-05f4f38147bf\" ]\r\n}',1,'There is no session with id [1fa14f03-3d7b-4870-a39f-05f4f38147bf]','2018-10-11 11:47:52'),(50,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"1fa14f03-3d7b-4870-a39f-05f4f38147bf\" ]\r\n}',0,NULL,'2018-10-11 11:49:02'),(51,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"1fa14f03-3d7b-4870-a39f-05f4f38147bf\" ]\r\n}',1,'There is no session with id [1fa14f03-3d7b-4870-a39f-05f4f38147bf]','2018-10-11 11:49:29'),(52,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"be6f7d78-d979-4c13-9c1e-28dca69a2153\" ]\r\n}',0,NULL,'2018-10-11 11:50:35'),(53,'角色管理',2,'com.ruoyi.web.controller.system.SysRoleController.editSave()',1,'admin','研发部门','/system/role/edit','127.0.0.1','XX 内网IP','{\r\n  \"roleId\" : [ \"2\" ],\r\n  \"roleName\" : [ \"普通角色\" ],\r\n  \"roleKey\" : [ \"common\" ],\r\n  \"roleSort\" : [ \"2\" ],\r\n  \"status\" : [ \"0\" ],\r\n  \"remark\" : [ \"普通角色\" ],\r\n  \"menuIds\" : [ \"3,112,113,1054,1055,114\" ]\r\n}',0,NULL,'2018-10-11 11:54:04'),(54,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"02373de5-33d8-46aa-9895-4d4ab7b3a996\" ]\r\n}',1,'There is no session with id [02373de5-33d8-46aa-9895-4d4ab7b3a996]','2018-10-11 11:55:58'),(55,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"01f6210d-53a0-4e87-befc-bdcce7b99b2d\" ]\r\n}',0,NULL,'2018-10-11 11:56:02'),(56,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"b49387bc-988a-44d8-af89-b92db9d42664\" ]\r\n}',0,NULL,'2018-10-11 11:58:19'),(57,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"0217c464-5313-4223-a075-8a45572b53b6\" ]\r\n}',0,NULL,'2018-10-11 11:58:42'),(58,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"0e8cc975-b0a7-4974-9537-c6b73bdbe135\" ]\r\n}',0,NULL,'2018-10-11 12:02:27'),(59,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"0c1a0288-64cc-4469-a117-3908a36b8ddc\" ]\r\n}',0,NULL,'2018-10-11 13:07:13'),(60,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX XX','{\r\n  \"sessionId\" : [ \"0c1a0288-64cc-4469-a117-3908a36b8ddc\" ]\r\n}',1,'There is no session with id [0c1a0288-64cc-4469-a117-3908a36b8ddc]','2018-10-11 13:07:56'),(61,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"6ff9127e-6644-447c-b47f-f160dc48be96\" ]\r\n}',0,NULL,'2018-10-11 13:11:39'),(62,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"93ec595e-7b7c-4390-9404-773a3e142760\" ]\r\n}',0,NULL,'2018-10-11 13:22:51'),(63,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"5eb0f6c1-4346-4889-9580-e040aaa5a046\" ]\r\n}',1,'There is no session with id [5eb0f6c1-4346-4889-9580-e040aaa5a046]','2018-10-11 13:22:54'),(64,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"5eb0f6c1-4346-4889-9580-e040aaa5a046\" ]\r\n}',0,NULL,'2018-10-11 13:23:46'),(65,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"5eb0f6c1-4346-4889-9580-e040aaa5a046\" ]\r\n}',1,'There is no session with id [5eb0f6c1-4346-4889-9580-e040aaa5a046]','2018-10-11 13:31:33'),(66,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"77f9738b-756c-4236-bd04-1cf23f062dee\" ]\r\n}',0,NULL,'2018-10-11 13:31:37'),(67,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"79a62145-a63c-439e-b33f-0a4f8a29f377\" ]\r\n}',0,NULL,'2018-10-11 13:34:03'),(68,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"9f670d2e-7a70-4a78-9f84-18bb3f3661ed\" ]\r\n}',0,NULL,'2018-10-11 16:12:32'),(69,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"db0713ee-cadc-4eb4-b02d-045278565d9d\" ]\r\n}',1,'There is no session with id [db0713ee-cadc-4eb4-b02d-045278565d9d]','2018-10-11 16:32:26'),(70,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"db0713ee-cadc-4eb4-b02d-045278565d9d\" ]\r\n}',0,NULL,'2018-10-11 16:33:27'),(71,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"95cf5a04-c174-405a-936a-f72e5ea88410\" ]\r\n}',0,NULL,'2018-10-11 16:36:47'),(72,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"95cf5a04-c174-405a-936a-f72e5ea88410\" ]\r\n}',0,NULL,'2018-10-11 16:38:50'),(73,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"16082c2b-4329-429b-83bd-a4bf89a16856\" ]\r\n}',0,NULL,'2018-10-11 17:42:23'),(74,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"9aa3f02c-069f-4a8e-9a1a-9a8db6f4b8ed\" ]\r\n}',0,NULL,'2018-10-11 17:55:01'),(75,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"3dd9dedf-2406-4d01-9582-d22a33067319\" ]\r\n}',0,NULL,'2018-10-11 17:55:05'),(76,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"9751ec8a-1e19-4e05-8673-4360187ede8b\" ]\r\n}',0,NULL,'2018-10-11 17:56:48'),(77,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"1e16afa9-7251-4cce-b604-250a3cbf5c37\" ]\r\n}',0,NULL,'2018-10-11 18:10:48'),(78,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"3385919d-ca5e-4de4-a0f8-82ce2f94699e\" ]\r\n}',0,NULL,'2018-10-11 18:12:56'),(79,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"024d23f1-75e3-41d6-b5d0-346d81a1b6e2\" ]\r\n}',0,NULL,'2018-10-11 18:16:42'),(80,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"6527ff11-723c-4d02-9c19-d828ca3fb2f3\" ]\r\n}',0,NULL,'2018-10-11 18:21:29'),(81,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"7d650f3e-72b1-4986-8574-257fbf1003b7\" ]\r\n}',0,NULL,'2018-10-11 18:22:55'),(82,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','XX 内网IP','{\r\n  \"sessionId\" : [ \"82b38e6c-738d-45ca-a06d-df205d04335c\" ]\r\n}',0,NULL,'2018-10-12 14:28:30'),(83,'代码生成',8,'com.ruoyi.web.controller.tool.GenController.genCode()',1,'admin','研发部门','/tool/gen/genCode/testdome','127.0.0.1','XX 内网IP','{ }',0,NULL,'2018-10-12 15:59:35'),(84,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','内网IP','{\r\n  \"sessionId\" : [ \"7c9d8ea8-69c8-4c85-ad2f-a3a60a9d3dfb\" ]\r\n}',0,NULL,'2018-10-17 16:52:52'),(85,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','内网IP','{\r\n  \"sessionId\" : [ \"3326c3cb-7339-4561-9a26-b7d295395c8f\" ]\r\n}',0,NULL,'2018-10-17 17:09:04'),(86,'在线用户',7,'com.ruoyi.web.controller.monitor.SysUserOnlineController.forceLogout()',1,'admin','研发部门','/monitor/online/forceLogout','127.0.0.1','内网IP','{\r\n  \"sessionId\" : [ \"18c0f895-c55e-4199-b974-598832ff58e6\" ]\r\n}',0,NULL,'2018-10-17 17:10:38');

/*Table structure for table `sys_post` */

CREATE TABLE `sys_post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

/*Data for the table `sys_post` */

insert  into `sys_post`(`post_id`,`post_code`,`post_name`,`post_sort`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'ceo','董事长',1,'0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(2,'se','项目经理',2,'0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(3,'hr','人力资源',3,'0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(4,'user','普通员工',4,'0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','');

/*Table structure for table `sys_role` */

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_key`,`role_sort`,`data_scope`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'管理员','admin',1,'1','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','管理员'),(2,'普通角色','common',2,'2','0','0','admin','2018-03-16 11:33:00','admin','2018-10-11 11:54:04','普通角色');

/*Table structure for table `sys_role_dept` */

CREATE TABLE `sys_role_dept` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `dept_id` int(11) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

/*Data for the table `sys_role_dept` */

insert  into `sys_role_dept`(`role_id`,`dept_id`) values (2,100),(2,101),(2,105);

/*Table structure for table `sys_role_menu` */

CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`role_id`,`menu_id`) values (2,3),(2,112),(2,113),(2,114),(2,1054),(2,1055);

/*Table structure for table `sys_user` */

CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(20) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`dept_id`,`login_name`,`user_name`,`user_type`,`email`,`phonenumber`,`sex`,`avatar`,`password`,`salt`,`status`,`del_flag`,`login_ip`,`login_date`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,103,'admin','若依','00','ry@163.com','15888888888','1','','29c67a30398638269fe600f73a054934','111111','0','0','127.0.0.1','2018-10-23 19:40:49','admin','2018-03-16 11:33:00','ry','2018-10-23 19:40:48','管理员'),(2,105,'ry','若依','00','ry@qq.com','15666666666','1','','8e6d98b90472783cc73c17047ddccf36','222222','0','0','127.0.0.1','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','测试员'),(3,105,'aaaa','xkang','00','xkang1019@163.com','18576750145','0','','b0e4d99caed1d37e5f7e1dda229575b3','dee742','0','0','127.0.0.1','2018-10-17 17:10:22','admin','2018-10-08 18:56:26','','2018-10-17 17:10:22',''),(6,NULL,'dsklafjhkdshfdjkghfdkj','微信用户','00','','','0','','ccb45b69d19ad70f0f9e1dff649b49d7','123456','0','0','',NULL,'dsklafjhkdshfdjkghfdkj','2018-10-12 17:26:59','',NULL,''),(7,NULL,'dsadsadsadasd','微信用户','00','','','0','','06776a2df46c4e5b997bbfdccc86404a','123456','0','0','127.0.0.1','2018-10-12 17:27:29','dsadsadsadasd','2018-10-12 17:27:28','','2018-10-12 17:27:28',''),(8,NULL,'dsadsadsafdsfdsfdsfdg','微信用户','00','','','0','','96dd799403b14f1ff63fb08bd52d9b8f','123456','0','0','127.0.0.1','2018-10-12 18:17:25','dsadsadsafdsfdsfdsfdg','2018-10-12 17:30:33','','2018-10-12 18:17:25','');

/*Table structure for table `sys_user_online` */

CREATE TABLE `sys_user_online` (
  `sessionId` varchar(50) NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) DEFAULT '0' COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线用户记录';

/*Data for the table `sys_user_online` */

insert  into `sys_user_online`(`sessionId`,`login_name`,`dept_name`,`ipaddr`,`login_location`,`browser`,`os`,`status`,`start_timestamp`,`last_access_time`,`expire_time`) values ('9ee34e6c-6bfa-499e-bf29-de1e2d44a524','admin',NULL,'127.0.0.1','内网IP','Chrome','Windows 7','on_line','2018-10-23 19:40:40','2018-10-23 19:52:07',1800000);

/*Table structure for table `sys_user_post` */

CREATE TABLE `sys_user_post` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `post_id` int(11) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

/*Data for the table `sys_user_post` */

insert  into `sys_user_post`(`user_id`,`post_id`) values (1,1),(2,2),(3,3),(5,4),(6,4),(7,4),(8,4);

/*Table structure for table `sys_user_role` */

CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values (1,1),(2,2),(3,2),(5,2),(6,2),(7,2),(8,2);

/*Table structure for table `testdome` */

CREATE TABLE `testdome` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `aaa` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `bbbb` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='测试';

/*Data for the table `testdome` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
