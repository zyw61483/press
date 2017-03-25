# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: yshop
# ------------------------------------------------------
# Server version 6.0.10-alpha-community

#
# Source for table ecart
#

DROP TABLE IF EXISTS `ecart`;
CREATE TABLE `ecart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '用户名（手机号）',
  `code` varchar(255) DEFAULT NULL COMMENT '商品条码',
  `goods` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `price` double(8,2) DEFAULT NULL COMMENT '单价',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `totalprice` double DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

#
# Dumping data for table ecart
#
LOCK TABLES `ecart` WRITE;
/*!40000 ALTER TABLE `ecart` DISABLE KEYS */;

/*!40000 ALTER TABLE `ecart` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ecash
#

DROP TABLE IF EXISTS `ecash`;
CREATE TABLE `ecash` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '用户名（手机号）',
  `account` varchar(255) DEFAULT NULL COMMENT '账号',
  `money` double(8,2) DEFAULT NULL COMMENT '金额',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提现';

#
# Dumping data for table ecash
#
LOCK TABLES `ecash` WRITE;
/*!40000 ALTER TABLE `ecash` DISABLE KEYS */;

/*!40000 ALTER TABLE `ecash` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table eincome
#

DROP TABLE IF EXISTS `eincome`;
CREATE TABLE `eincome` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '用户名（手机号）',
  `from` varchar(255) DEFAULT NULL COMMENT '来源用户',
  `level` varchar(255) DEFAULT NULL COMMENT '来源级别',
  `consume` double(8,2) DEFAULT NULL COMMENT '消费金额',
  `income` double(8,2) DEFAULT NULL COMMENT '收益',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收益';

#
# Dumping data for table eincome
#
LOCK TABLES `eincome` WRITE;
/*!40000 ALTER TABLE `eincome` DISABLE KEYS */;

/*!40000 ALTER TABLE `eincome` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table elog
#

DROP TABLE IF EXISTS `elog`;
CREATE TABLE `elog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '用户名（手机号）',
  `intro` varchar(255) DEFAULT NULL COMMENT '操作内容',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志';

#
# Dumping data for table elog
#
LOCK TABLES `elog` WRITE;
/*!40000 ALTER TABLE `elog` DISABLE KEYS */;

/*!40000 ALTER TABLE `elog` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table enews
#

DROP TABLE IF EXISTS `enews`;
CREATE TABLE `enews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` varchar(255) DEFAULT NULL COMMENT '类别',
  `detail` text COMMENT '内容',
  `name` varchar(255) DEFAULT NULL COMMENT '发布者',
  `time` varchar(255) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `seq` int(11) DEFAULT NULL COMMENT '顺序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章类别';

#
# Dumping data for table enewstype
#
LOCK TABLES `enewstype` WRITE;
/*!40000 ALTER TABLE `enewstype` DISABLE KEYS */;

/*!40000 ALTER TABLE `enewstype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table eorder
#

DROP TABLE IF EXISTS `eorder`;
CREATE TABLE `eorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` varchar(255) DEFAULT NULL COMMENT '订单号',
  `price` double DEFAULT NULL COMMENT '订单金额',
  `time` varchar(255) DEFAULT NULL COMMENT '订单时间',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名（手机号）',
  `realname` varchar(255) DEFAULT NULL COMMENT '收货人',
  `address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `tel` varchar(255) DEFAULT NULL COMMENT '收货电话',
  `status` varchar(255) DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';

#
# Dumping data for table eorder
#
LOCK TABLES `eorder` WRITE;
/*!40000 ALTER TABLE `eorder` DISABLE KEYS */;

/*!40000 ALTER TABLE `eorder` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table eorderlist
#

DROP TABLE IF EXISTS `eorderlist`;
CREATE TABLE `eorderlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` varchar(255) DEFAULT NULL COMMENT '订单号',
  `code` varchar(255) DEFAULT NULL COMMENT '条码',
  `goods` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `price` double DEFAULT NULL COMMENT '商品单价',
  `cost` double(8,2) DEFAULT NULL COMMENT '成本',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `totalprice` double(8,2) DEFAULT NULL COMMENT '总价',
  `totalcost` double(8,2) DEFAULT NULL COMMENT '总成本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单商品列表';

#
# Dumping data for table eorderlist
#
LOCK TABLES `eorderlist` WRITE;
/*!40000 ALTER TABLE `eorderlist` DISABLE KEYS */;

/*!40000 ALTER TABLE `eorderlist` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table eproduct
#

DROP TABLE IF EXISTS `eproduct`;
CREATE TABLE `eproduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '条码',
  `goods` varchar(255) DEFAULT NULL COMMENT '商品名',
  `type` varchar(255) DEFAULT NULL COMMENT '类别',
  `cap` varchar(255) DEFAULT NULL COMMENT '容量',
  `spec` varchar(255) DEFAULT NULL COMMENT '规格',
  `price` double(8,2) DEFAULT NULL COMMENT '价格',
  `cost` double(8,2) DEFAULT NULL COMMENT '成本',
  `degree` int(11) DEFAULT NULL COMMENT '度数',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `detail` int(11) DEFAULT NULL COMMENT '商品描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table eproduct
#
LOCK TABLES `eproduct` WRITE;
/*!40000 ALTER TABLE `eproduct` DISABLE KEYS */;

/*!40000 ALTER TABLE `eproduct` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table eproducttype
#

DROP TABLE IF EXISTS `eproducttype`;
CREATE TABLE `eproducttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '商品类别名',
  `seq` int(11) DEFAULT NULL COMMENT '顺序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类别';

#
# Dumping data for table eproducttype
#
LOCK TABLES `eproducttype` WRITE;
/*!40000 ALTER TABLE `eproducttype` DISABLE KEYS */;

/*!40000 ALTER TABLE `eproducttype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table erecord
#

DROP TABLE IF EXISTS `erecord`;
CREATE TABLE `erecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intro` varchar(255) DEFAULT NULL COMMENT '记录具体内容',
  `money` double(8,2) DEFAULT NULL COMMENT '入账金额',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名（手机号）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='对账记录';

#
# Dumping data for table erecord
#
LOCK TABLES `erecord` WRITE;
/*!40000 ALTER TABLE `erecord` DISABLE KEYS */;

/*!40000 ALTER TABLE `erecord` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table euser
#

DROP TABLE IF EXISTS `euser`;
CREATE TABLE `euser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '用户名（手机号）',
  `wechat` varchar(255) DEFAULT NULL COMMENT '微信号',
  `realname` varchar(255) DEFAULT NULL COMMENT '姓名',
  `account` varchar(255) DEFAULT NULL COMMENT '账号',
  `balance` double(8,2) DEFAULT NULL COMMENT '余额',
  `acc` int(11) DEFAULT NULL COMMENT '积分',
  `bname` varchar(255) DEFAULT NULL COMMENT '上上级代理',
  `mname` varchar(255) DEFAULT NULL COMMENT '上级代理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员';

#
# Dumping data for table euser
#
LOCK TABLES `euser` WRITE;
/*!40000 ALTER TABLE `euser` DISABLE KEYS */;

/*!40000 ALTER TABLE `euser` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
