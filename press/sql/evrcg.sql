# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: evrcg
# ------------------------------------------------------
# Server version 6.0.10-alpha-community

#
# Source for table eaboutus
#

DROP TABLE IF EXISTS `eaboutus`;
CREATE TABLE `eaboutus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `detail` text COMMENT '内容',
  `type` varchar(255) DEFAULT NULL COMMENT '类别（下拉列表，列表值固定如下：关于我们、加入我们、联系我们）',
  `time` varchar(255) DEFAULT NULL COMMENT '时间（预留）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关于我们表';

#
# Dumping data for table eaboutus
#
LOCK TABLES `eaboutus` WRITE;
/*!40000 ALTER TABLE `eaboutus` DISABLE KEYS */;

INSERT INTO `eaboutus` VALUES (1,'a','<img alt=\"\" src=\"/uploadfiles/images/11.jpg\" style=\"width:100%\" /><img alt=\"\" src=\"/uploadfiles/images/12.jpg\" style=\"width:100%\" />\r\n','关于我们','');
INSERT INTO `eaboutus` VALUES (2,'撒旦法','<img alt=\"\" src=\"/uploadfiles/images/13.jpg\" style=\"width:100%\" />\r\n','加入我们','');
INSERT INTO `eaboutus` VALUES (3,'阿斯蒂芬','<img alt=\"\" src=\"/uploadfiles/images/14.jpg\" style=\"width:100%\" />\r\n','联系我们','');
/*!40000 ALTER TABLE `eaboutus` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table eagreement
#

DROP TABLE IF EXISTS `eagreement`;
CREATE TABLE `eagreement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `detail` text COMMENT '内容',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户协议表';

#
# Dumping data for table eagreement
#
LOCK TABLES `eagreement` WRITE;
/*!40000 ALTER TABLE `eagreement` DISABLE KEYS */;

INSERT INTO `eagreement` VALUES (1,'用户协议','从来从来 从来','');
/*!40000 ALTER TABLE `eagreement` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ebook
#

DROP TABLE IF EXISTS `ebook`;
CREATE TABLE `ebook` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '书名',
  `subtitle` varchar(255) DEFAULT NULL COMMENT '副标题',
  `flag` varchar(255) DEFAULT NULL COMMENT '书的标识（唯一）',
  `image` varchar(255) DEFAULT NULL COMMENT '封面',
  `detail` text COMMENT '内容简介',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `type` varchar(255) DEFAULT NULL COMMENT '类别（下拉列表，对应etype表）',
  `status` varchar(255) DEFAULT NULL COMMENT '状态（下拉列表，对应estatus表）',
  `setnum` varchar(255) DEFAULT NULL COMMENT '集数',
  `playnum` int(11) DEFAULT NULL COMMENT '播放数',
  `ordernum` int(11) DEFAULT NULL COMMENT '订阅数',
  `recommend` int(11) DEFAULT NULL COMMENT '推荐度',
  `supportnum` int(11) DEFAULT NULL COMMENT '赞数',
  `downnum` int(11) DEFAULT NULL COMMENT '下载量（预留）',
  `code` varchar(255) DEFAULT NULL COMMENT '书的验证码（预留）',
  `time` varchar(255) DEFAULT NULL COMMENT '发行时间',
  `stick` int(11) DEFAULT NULL COMMENT '系统推荐度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='图书表';

#
# Dumping data for table ebook
#
LOCK TABLES `ebook` WRITE;
/*!40000 ALTER TABLE `ebook` DISABLE KEYS */;

INSERT INTO `ebook` VALUES (1,'超级恐龙','超级恐龙','cjkl','/admin/ifiles/ebooks/20160427151313717.png','天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大','孙毅','科幻类','完结','三集',1,1,1,1,1,'','2016-01-01',1);
INSERT INTO `ebook` VALUES (2,'超级恐龙1','超级恐龙1','cjkl1','/admin/ifiles/ebooks/20160427151302082.png','天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大','孙毅','科幻类','完结','三集',2,2,2,2,2,'','2016-01-01',2);
INSERT INTO `ebook` VALUES (3,'超级恐龙2','超级恐龙2','cjkl2','/admin/ifiles/ebooks/20160427151252246.png','天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大','孙毅','科幻类','完结','三集',3,3,3,3,3,'','2016-01-01',3);
INSERT INTO `ebook` VALUES (4,'超级恐龙3','超级恐龙3','cjkl3','/admin/ifiles/ebooks/20160427151237583.png','天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大','孙毅','科幻类','完结','三集',4,4,4,4,4,'','2016-01-01',4);
INSERT INTO `ebook` VALUES (5,'超级恐龙4','超级恐龙4','cjkl4','/admin/ifiles/ebooks/20160427151226295.png','天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大','孙毅','科幻类','完结','三集',5,5,5,5,5,'','2016-01-01',5);
INSERT INTO `ebook` VALUES (6,'超级恐龙5','超级恐龙5','cjkl5','/admin/ifiles/ebooks/20160427151215174.png','天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天空之广大天','孙毅','科幻类','完结','三集',9,7,6,7,12,'','2016-01-01',6);
/*!40000 ALTER TABLE `ebook` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table efaq
#

DROP TABLE IF EXISTS `efaq`;
CREATE TABLE `efaq` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `detail` text COMMENT '内容',
  `type` varchar(255) DEFAULT NULL COMMENT '类别（下拉列表，暂时只有一个固定值如下：热点问题）',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='常见问题表';

#
# Dumping data for table efaq
#
LOCK TABLES `efaq` WRITE;
/*!40000 ALTER TABLE `efaq` DISABLE KEYS */;

INSERT INTO `efaq` VALUES (1,'常见问it','倒萨发烧发到   ','热点问题','');
INSERT INTO `efaq` VALUES (2,'常见问it','倒萨发烧发到   ','热点问题','\"\"');
INSERT INTO `efaq` VALUES (3,'常见问it','倒萨发烧发到   ','热点问题','\"\"');
/*!40000 ALTER TABLE `efaq` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table emessage
#

DROP TABLE IF EXISTS `emessage`;
CREATE TABLE `emessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `detail` text COMMENT '内容',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `status` varchar(255) DEFAULT NULL COMMENT '状态（下拉列表，固定值如下：发布、未发布）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息推送表';

#
# Dumping data for table emessage
#
LOCK TABLES `emessage` WRITE;
/*!40000 ALTER TABLE `emessage` DISABLE KEYS */;

/*!40000 ALTER TABLE `emessage` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table enews
#

DROP TABLE IF EXISTS `enews`;
CREATE TABLE `enews` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `image` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `detail` text COMMENT '内容',
  `type` varchar(255) DEFAULT NULL COMMENT '类别（预留）',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `stick` int(11) DEFAULT NULL COMMENT '置顶数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='新闻表';

#
# Dumping data for table enews
#
LOCK TABLES `enews` WRITE;
/*!40000 ALTER TABLE `enews` DISABLE KEYS */;

INSERT INTO `enews` VALUES (1,'新闻','/admin/ifiles/enewss/20160427151322370.png','','最新广告','2016-01-02',1);
/*!40000 ALTER TABLE `enews` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table eorder
#

DROP TABLE IF EXISTS `eorder`;
CREATE TABLE `eorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '书名',
  `flag` varchar(255) DEFAULT NULL COMMENT '书的标识（对应ebook表flag）',
  `image` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `time` varchar(255) DEFAULT NULL COMMENT '订阅时间（预留）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='订阅表';

#
# Dumping data for table eorder
#
LOCK TABLES `eorder` WRITE;
/*!40000 ALTER TABLE `eorder` DISABLE KEYS */;

INSERT INTO `eorder` VALUES (3,'超级恐龙5','cjkl5','/admin/ifiles/ebooks/20160427151215174.png','13504319972','20160427172735882');
INSERT INTO `eorder` VALUES (4,'超级恐龙5','cjkl5','/admin/ifiles/ebooks/20160427151215174.png','13504319972','20160427172735882');
INSERT INTO `eorder` VALUES (5,'超级恐龙5','cjkl5','/admin/ifiles/ebooks/20160427151215174.png','13504319972','20160427172735882');
INSERT INTO `eorder` VALUES (6,'超级恐龙5','cjkl5','/admin/ifiles/ebooks/20160427151215174.png','13504319972','20160427172735882');
INSERT INTO `eorder` VALUES (7,'超级恐龙5','cjkl5','/admin/ifiles/ebooks/20160427151215174.png','13504319972','20160427172735882');
/*!40000 ALTER TABLE `eorder` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table eresandroid
#

DROP TABLE IF EXISTS `eresandroid`;
CREATE TABLE `eresandroid` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '资源名',
  `image` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `flag` varchar(255) DEFAULT NULL COMMENT '书的标识（对应ebook表flag）',
  `mark` varchar(255) DEFAULT NULL COMMENT '资源标识，与flag组合唯一',
  `path` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `free` varchar(255) DEFAULT NULL COMMENT '是否免费（下拉列表，固定值如下：免费、收费）（预留）',
  `time` varchar(255) DEFAULT NULL COMMENT '发布时间',
  `playnum` int(11) DEFAULT NULL COMMENT '播放数',
  `supportnum` int(11) DEFAULT NULL COMMENT '赞数',
  `duration` varchar(255) DEFAULT NULL COMMENT '时长',
  `downnum` int(11) DEFAULT NULL COMMENT '下载量（预留）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Android资源表';

#
# Dumping data for table eresandroid
#
LOCK TABLES `eresandroid` WRITE;
/*!40000 ALTER TABLE `eresandroid` DISABLE KEYS */;

INSERT INTO `eresandroid` VALUES (1,'资源5','/admin/ifiles/eresandroids/20160428101542677.png','cjkl5','zy5','/admin/ifiles/eresandroids/20160428101542682.unity3d','免费','2016-01-01',8,5,'5\"',9);
INSERT INTO `eresandroid` VALUES (2,'资源4','/admin/ifiles/eresandroids/20160428101124443.png','cjkl5','zy4','/admin/ifiles/eresandroids/20160428101124456.unity3d','免费','2016-01-01',4,4,'4\"',6);
/*!40000 ALTER TABLE `eresandroid` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table eresios
#

DROP TABLE IF EXISTS `eresios`;
CREATE TABLE `eresios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '资源名',
  `image` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `flag` varchar(255) DEFAULT NULL COMMENT '书的标识（对应ebook表flag）',
  `mark` varchar(255) DEFAULT NULL COMMENT '资源标识，与flag组合唯一',
  `path` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `vpath` varchar(255) DEFAULT NULL COMMENT '视频地址',
  `free` varchar(255) DEFAULT NULL COMMENT '是否免费（下拉列表，固定值如下：免费、收费）（预留）',
  `time` varchar(255) DEFAULT NULL COMMENT '发布时间',
  `playnum` int(11) DEFAULT NULL COMMENT '播放数',
  `supportnum` int(11) DEFAULT NULL COMMENT '赞数',
  `duration` varchar(255) DEFAULT NULL COMMENT '时长',
  `downnum` int(11) DEFAULT NULL COMMENT '下载量（预留）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='iOS资源表';

#
# Dumping data for table eresios
#
LOCK TABLES `eresios` WRITE;
/*!40000 ALTER TABLE `eresios` DISABLE KEYS */;

/*!40000 ALTER TABLE `eresios` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table estatus
#

DROP TABLE IF EXISTS `estatus`;
CREATE TABLE `estatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item` varchar(255) DEFAULT NULL COMMENT '状态名',
  `seq` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='书状态表';

#
# Dumping data for table estatus
#
LOCK TABLES `estatus` WRITE;
/*!40000 ALTER TABLE `estatus` DISABLE KEYS */;

INSERT INTO `estatus` VALUES (1,'完结',1);
/*!40000 ALTER TABLE `estatus` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table esuggest
#

DROP TABLE IF EXISTS `esuggest`;
CREATE TABLE `esuggest` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题（预留）',
  `detail` text COMMENT '内容',
  `image` varchar(255) DEFAULT NULL COMMENT '图片',
  `flag` varchar(255) DEFAULT NULL COMMENT '所属书标识（如无所属书则为系统建议）',
  `mark` varchar(255) DEFAULT NULL COMMENT '所属资源标识',
  `type` varchar(255) DEFAULT NULL COMMENT '类别（下拉列表，固定值如下：用户、管理员）',
  `name` varchar(255) DEFAULT NULL COMMENT '用户',
  `admin` varchar(255) DEFAULT NULL COMMENT '管理员',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='建议表';

#
# Dumping data for table esuggest
#
LOCK TABLES `esuggest` WRITE;
/*!40000 ALTER TABLE `esuggest` DISABLE KEYS */;

INSERT INTO `esuggest` VALUES (1,'1','1111111111111111111','/admin/ifiles/esuggests/20160427115546887.png','cjkl5','','用户','13504319972','','','2016-01-01');
INSERT INTO `esuggest` VALUES (2,'2','kjasdkfjadslfkljdsaf2222222222222222222','/admin/ifiles/esuggests/20160427115546887.png','cjkl5','','管理员','13504319972','admin','','2016-01-01');
INSERT INTO `esuggest` VALUES (3,'3','kjasdkfjadslfkljdsaf333333333333333','/admin/ifiles/esuggests/20160427115546887.png','cjkl5','','用户','13504319972','','','2016-01-01');
INSERT INTO `esuggest` VALUES (4,'4','kjasdkfjadslfkljdsaf4444444444444444444','/admin/ifiles/esuggests/20160427115546887.png','cjkl5','','管理员','13504319972','admin','','2016-01-01');
INSERT INTO `esuggest` VALUES (5,NULL,'回到家大家的',NULL,'cjkl5',NULL,'用户','13504319972',NULL,'13504319972','2016-04-27');
INSERT INTO `esuggest` VALUES (6,NULL,'鉴定九点半','/admin/ifiles/esuggests/20160427170000151jpg','cjkl5',NULL,'用户','13504319972',NULL,'5464','2016-04-27');
INSERT INTO `esuggest` VALUES (7,'1','1111111111111111111','/admin/ifiles/esuggests/20160427115546887.png','cjkl4','','用户','13504319972','','','2016-01-01');
/*!40000 ALTER TABLE `esuggest` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table esysset
#

DROP TABLE IF EXISTS `esysset`;
CREATE TABLE `esysset` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item` varchar(255) DEFAULT NULL COMMENT '系数名',
  `factor` int(11) DEFAULT NULL COMMENT '系数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系数设置表';

#
# Dumping data for table esysset
#
LOCK TABLES `esysset` WRITE;
/*!40000 ALTER TABLE `esysset` DISABLE KEYS */;

/*!40000 ALTER TABLE `esysset` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table esysuser
#

DROP TABLE IF EXISTS `esysuser`;
CREATE TABLE `esysuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `type` varchar(255) DEFAULT NULL COMMENT '类型（下拉列表，固定值如下：系统管理员、资源管理员、信息管理员）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

#
# Dumping data for table esysuser
#
LOCK TABLES `esysuser` WRITE;
/*!40000 ALTER TABLE `esysuser` DISABLE KEYS */;

INSERT INTO `esysuser` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3','系统管理员');
/*!40000 ALTER TABLE `esysuser` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table etype
#

DROP TABLE IF EXISTS `etype`;
CREATE TABLE `etype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item` varchar(255) DEFAULT NULL COMMENT '类别名',
  `seq` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='书类别表';

#
# Dumping data for table etype
#
LOCK TABLES `etype` WRITE;
/*!40000 ALTER TABLE `etype` DISABLE KEYS */;

INSERT INTO `etype` VALUES (1,'科幻类',1);
/*!40000 ALTER TABLE `etype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table euser
#

DROP TABLE IF EXISTS `euser`;
CREATE TABLE `euser` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名（手机号）',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `image` varchar(255) DEFAULT NULL COMMENT '头像',
  `childname` varchar(255) DEFAULT NULL COMMENT '孩子姓名',
  `childage` int(11) DEFAULT NULL COMMENT '孩子年龄',
  `childsex` varchar(255) DEFAULT NULL COMMENT '孩子性别（下拉列表，固定值如下：男、女）',
  `parentname` varchar(255) DEFAULT NULL COMMENT '家长姓名',
  `parentage` int(11) DEFAULT NULL COMMENT '家长年龄',
  `parentsex` varchar(255) DEFAULT NULL COMMENT '家长性别（下拉列表，固定值如下：男、女）',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `regtime` varchar(255) DEFAULT NULL COMMENT '注册时间',
  `logcount` int(11) DEFAULT NULL COMMENT '登录次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Dumping data for table euser
#
LOCK TABLES `euser` WRITE;
/*!40000 ALTER TABLE `euser` DISABLE KEYS */;

INSERT INTO `euser` VALUES (1,'13504319972','','/admin/ifiles/eusers/20160428150845171jpg','张张',NULL,'男','',NULL,'男','','','',7);
/*!40000 ALTER TABLE `euser` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table structure
#

DROP TABLE IF EXISTS `structure`;
CREATE TABLE `structure` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tableName` varchar(255) DEFAULT NULL COMMENT '表名',
  `fieldName` varchar(255) DEFAULT NULL COMMENT '字段名',
  `cnName` varchar(255) DEFAULT NULL COMMENT '中文名',
  `fieldType` varchar(255) DEFAULT NULL COMMENT '字段类型（下拉列表，固定值如下：文本、长文本、数字、日期、时间）',
  `isValid` int(11) DEFAULT NULL COMMENT '是否可用（下拉列表，固定值如下：0，1）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='高级搜索表';

#
# Dumping data for table structure
#
LOCK TABLES `structure` WRITE;
/*!40000 ALTER TABLE `structure` DISABLE KEYS */;

/*!40000 ALTER TABLE `structure` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
