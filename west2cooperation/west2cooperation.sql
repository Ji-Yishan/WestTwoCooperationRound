/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 8.0.31 : Database - west2cooperation
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`west2cooperation` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `west2cooperation`;

/*Table structure for table `audit` */

CREATE TABLE `audit` (
  `audit` int DEFAULT NULL,
  `name` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `audit` */

insert  into `audit`(`audit`,`name`) values 
(0,'审核中'),
(1,'审核通过'),
(2,'审核不通过');

/*Table structure for table `degree` */

CREATE TABLE `degree` (
  `degree` int DEFAULT NULL COMMENT '用户等级',
  `name` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '等级名字'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `degree` */

insert  into `degree`(`degree`,`name`) values 
(0,'普通用户'),
(1,'管理员');

/*Table structure for table `project` */

CREATE TABLE `project` (
  `pname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '项目名称',
  `pLocation` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片地址',
  `content` varchar(300) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '内容',
  `targetFund` int DEFAULT NULL COMMENT '目标金额',
  `fund` int DEFAULT '0' COMMENT '已得金额',
  `audit` int NOT NULL DEFAULT '0' COMMENT '审核是否通过',
  `username` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `pid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'uuid',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `project` */

insert  into `project`(`pname`,`pLocation`,`content`,`targetFund`,`fund`,`audit`,`username`,`pid`) values 
('asef','C:\\Users\\86187\\IdeaProjects\\west2cooperation\\target\\west2cooperation-1.0-SNAPSHOT\\upload','asrtbarae',110,0,1,'wuh','09a3fe6ac9124860b88baef5296f8fce'),
('help!!!',NULL,'i\'m poor need money',10,1,0,'www','5g247g3d19194e208a398cd60b510c78'),
('wuhu','C:\\Users\\86187\\IdeaProjects\\west2cooperation\\target\\west2cooperation-1.0-SNAPSHOT\\upload','hehehe',111,12,0,'wuh','6f83465d19194e208a398cd60b510c78');

/*Table structure for table `user` */

CREATE TABLE `user` (
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `contact` varchar(15) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '手机号码',
  `idcard` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '身份证号',
  `degree` int NOT NULL DEFAULT '0' COMMENT '是否为管理员',
  `userid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'uuid',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user` */

insert  into `user`(`username`,`password`,`contact`,`idcard`,`degree`,`userid`) values 
('666','666','0','0',0,'07c899607c1b4da8951a907484a1cb05'),
('ab','aaaaaa','0','0',0,'554aa720b1d4429fae539e53b4ebf92a'),
('wuh','aaaaaa','wuhuwuhu','123123',0,'5ce9d95fb5b6439b80a06f7d3e2a1777'),
('wuh','1','wuhuwuhu','1212124',1,'863d5a78c55c4178bf9d1ca48440bb4b'),
('a','aaaaaa','0','0',0,'a01191b250a14cb58e30113d92fcf6ab'),
('wuh','word','wuhuwuhu','1212124',0,'a1e86d78a9b84cdeacf9a7eceb9872b9');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
