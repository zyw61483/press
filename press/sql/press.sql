# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: press
# ------------------------------------------------------
# Server version 6.0.10-alpha-community

#
# Source for table eactive
#

DROP TABLE IF EXISTS `eactive`;
CREATE TABLE `eactive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '参加活动用户',
  `realname` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `address` varchar(255) DEFAULT NULL COMMENT '用户地址',
  `code` varchar(255) DEFAULT NULL COMMENT '活动编号',
  `time` varchar(255) DEFAULT NULL COMMENT '参加活动时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户参加活动记录';

#
# Dumping data for table eactive
#
LOCK TABLES `eactive` WRITE;
/*!40000 ALTER TABLE `eactive` DISABLE KEYS */;

/*!40000 ALTER TABLE `eactive` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ebook
#

DROP TABLE IF EXISTS `ebook`;
CREATE TABLE `ebook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `detail` varchar(255) DEFAULT NULL COMMENT '简介',
  `resfile` varchar(255) DEFAULT NULL COMMENT '资源文件，暂定图片，视频，音频',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `publisher` varchar(255) DEFAULT NULL COMMENT '出版社',
  `publishtime` varchar(255) DEFAULT NULL COMMENT '出版时间',
  `sets` varchar(255) DEFAULT NULL COMMENT '系列',
  `type` varchar(255) DEFAULT NULL COMMENT '类别，暂定文本，视频，音频',
  `name` varchar(255) DEFAULT NULL COMMENT '发布者',
  `time` varchar(255) DEFAULT NULL COMMENT '发布时间',
  `flag` varchar(255) DEFAULT NULL COMMENT '置顶，数字大的在上面',
  `browse` int(11) DEFAULT NULL COMMENT '浏览次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源';

#
# Dumping data for table ebook
#
LOCK TABLES `ebook` WRITE;
/*!40000 ALTER TABLE `ebook` DISABLE KEYS */;

/*!40000 ALTER TABLE `ebook` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ebooksets
#

DROP TABLE IF EXISTS `ebooksets`;
CREATE TABLE `ebooksets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL COMMENT '书的类别',
  `item` varchar(255) DEFAULT NULL COMMENT '系列',
  `seq` varchar(255) DEFAULT NULL COMMENT '顺序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系列';

#
# Dumping data for table ebooksets
#
LOCK TABLES `ebooksets` WRITE;
/*!40000 ALTER TABLE `ebooksets` DISABLE KEYS */;

/*!40000 ALTER TABLE `ebooksets` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ebooktype
#

DROP TABLE IF EXISTS `ebooktype`;
CREATE TABLE `ebooktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '类别名称',
  `seq` varchar(255) DEFAULT NULL COMMENT '顺序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源类型';

#
# Dumping data for table ebooktype
#
LOCK TABLES `ebooktype` WRITE;
/*!40000 ALTER TABLE `ebooktype` DISABLE KEYS */;

/*!40000 ALTER TABLE `ebooktype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table egame
#

DROP TABLE IF EXISTS `egame`;
CREATE TABLE `egame` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '参与游戏用户',
  `time` varchar(255) DEFAULT NULL COMMENT '参与时间',
  `score` int(11) DEFAULT NULL COMMENT '游戏分数',
  `duration` int(11) DEFAULT NULL COMMENT '时长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏';

#
# Dumping data for table egame
#
LOCK TABLES `egame` WRITE;
/*!40000 ALTER TABLE `egame` DISABLE KEYS */;

/*!40000 ALTER TABLE `egame` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ehelp
#

DROP TABLE IF EXISTS `ehelp`;
CREATE TABLE `ehelp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `detail` text COMMENT '内容',
  `type` varchar(255) DEFAULT NULL COMMENT '类别，暂定联系方式，用户手册，用户协议',
  `name` varchar(255) DEFAULT NULL COMMENT '发布者',
  `time` varchar(255) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='说明文档';

#
# Dumping data for table ehelp
#
LOCK TABLES `ehelp` WRITE;
/*!40000 ALTER TABLE `ehelp` DISABLE KEYS */;

/*!40000 ALTER TABLE `ehelp` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ehelptype
#

DROP TABLE IF EXISTS `ehelptype`;
CREATE TABLE `ehelptype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '类别名',
  `seq` varchar(255) DEFAULT NULL COMMENT '顺序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='说明文档类型';

#
# Dumping data for table ehelptype
#
LOCK TABLES `ehelptype` WRITE;
/*!40000 ALTER TABLE `ehelptype` DISABLE KEYS */;

/*!40000 ALTER TABLE `ehelptype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table enews
#

DROP TABLE IF EXISTS `enews`;
CREATE TABLE `enews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `image` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `detail` text COMMENT '详细内容，使用fckeditor',
  `type` varchar(255) DEFAULT NULL COMMENT '类别',
  `name` varchar(255) DEFAULT NULL COMMENT '发布者',
  `time` varchar(255) DEFAULT NULL COMMENT '发布时间',
  `flag` int(11) DEFAULT NULL COMMENT '置顶标志，数字大的置顶',
  `browse` int(11) DEFAULT NULL COMMENT '浏览次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';

#
# Dumping data for table enews
#
LOCK TABLES `enews` WRITE;
/*!40000 ALTER TABLE `enews` DISABLE KEYS */;

/*!40000 ALTER TABLE `enews` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table enewstype
#

DROP TABLE IF EXISTS `enewstype`;
CREATE TABLE `enewstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '文章类别名',
  `seq` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章类型';

#
# Dumping data for table enewstype
#
LOCK TABLES `enewstype` WRITE;
/*!40000 ALTER TABLE `enewstype` DISABLE KEYS */;

/*!40000 ALTER TABLE `enewstype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table eroll
#

DROP TABLE IF EXISTS `eroll`;
CREATE TABLE `eroll` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `image` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `link` varchar(255) DEFAULT NULL COMMENT '链接',
  `type` varchar(255) DEFAULT NULL COMMENT '类别',
  `name` varchar(255) DEFAULT NULL COMMENT '发布者',
  `time` varchar(255) DEFAULT NULL COMMENT '发布时间',
  `flag` int(11) DEFAULT NULL COMMENT '置顶标志',
  `browse` varchar(255) DEFAULT NULL COMMENT '浏览次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='轮播';

#
# Dumping data for table eroll
#
LOCK TABLES `eroll` WRITE;
/*!40000 ALTER TABLE `eroll` DISABLE KEYS */;

/*!40000 ALTER TABLE `eroll` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table erolltype
#

DROP TABLE IF EXISTS `erolltype`;
CREATE TABLE `erolltype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '轮播分类名',
  `seq` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='轮播分类';

#
# Dumping data for table erolltype
#
LOCK TABLES `erolltype` WRITE;
/*!40000 ALTER TABLE `erolltype` DISABLE KEYS */;

/*!40000 ALTER TABLE `erolltype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table euser
#

DROP TABLE IF EXISTS `euser`;
CREATE TABLE `euser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `realname` varchar(255) DEFAULT NULL COMMENT '姓名',
  `acount` int(11) DEFAULT NULL COMMENT '账户，备用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

#
# Dumping data for table euser
#
LOCK TABLES `euser` WRITE;
/*!40000 ALTER TABLE `euser` DISABLE KEYS */;

/*!40000 ALTER TABLE `euser` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table structure
#

DROP TABLE IF EXISTS `structure`;
CREATE TABLE `structure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tableName` varchar(255) DEFAULT NULL,
  `fieldName` varchar(255) DEFAULT NULL,
  `cnName` varchar(255) DEFAULT NULL,
  `fieldType` varchar(255) DEFAULT NULL,
  `isValid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

#
# Dumping data for table structure
#
LOCK TABLES `structure` WRITE;
/*!40000 ALTER TABLE `structure` DISABLE KEYS */;
CREATE TABLE `esysuser` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键',
  `name` varchar(255) default NULL COMMENT '用户名',
  `password` varchar(255) default NULL COMMENT '密码',
  `type` varchar(255) default NULL COMMENT '类型（下拉列表，固定值如下：系统管理员、资源管理员、信息管理员）',
  PRIMARY KEY  (`id`)
)
/*!40000 ALTER TABLE `structure` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
