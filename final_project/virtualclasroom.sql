/*
SQLyog Enterprise - MySQL GUI v8.05 
MySQL - 5.0.24-community-nt : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

/*Table structure for table `answer` */

DROP TABLE IF EXISTS `answer`;

CREATE TABLE `answer` (
  `answer_id` int(12) NOT NULL auto_increment,
  `answer_content` varchar(1000) NOT NULL,
  `answer_on` int(12) NOT NULL,
  `answer_by` varchar(50) NOT NULL,
  `answer_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `askquestion` */

DROP TABLE IF EXISTS `askquestion`;

CREATE TABLE `askquestion` (
  `question_id` int(12) NOT NULL auto_increment,
  `subject` char(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `uploaded_by` char(30) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `filename` varchar(20) default NULL,
  `filecontent` mediumblob,
  `uploadtime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `documents` */

DROP TABLE IF EXISTS `documents`;

CREATE TABLE `documents` (
  `post_id` int(11) NOT NULL auto_increment,
  `upload_time` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `filecontent` mediumblob,
  `upload_by` varchar(50) NOT NULL default '',
  `filename` varchar(100) default NULL,
  `postcontent` varchar(1000) NOT NULL default '',
  PRIMARY KEY  (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `lecture` */

DROP TABLE IF EXISTS `lecture`;

CREATE TABLE `lecture` (
  `lecture_id` int(12) NOT NULL auto_increment,
  `uploaded_by` varchar(50) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `title` varchar(100) NOT NULL,
  `filename` varchar(100) NOT NULL,
  `upload_time` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `file_content` longblob NOT NULL,
  PRIMARY KEY  (`lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `library` */

DROP TABLE IF EXISTS `library`;

CREATE TABLE `library` (
  `book_id` int(12) NOT NULL auto_increment,
  `uploadedby` char(20) NOT NULL,
  `subject` varchar(25) NOT NULL,
  `title` varchar(100) NOT NULL,
  `filetype` varchar(50) NOT NULL,
  `filename` varchar(100) NOT NULL,
  `filecontent` longblob NOT NULL,
  `uploadtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `writername` varchar(50) default NULL,
  PRIMARY KEY  (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `onlineuser` */

DROP TABLE IF EXISTS `onlineuser`;

CREATE TABLE `onlineuser` (
  `sno` int(5) NOT NULL auto_increment,
  `userid` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY  (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `id` int(12) NOT NULL auto_increment,
  `content` varchar(1000) NOT NULL,
  `reply_by` varchar(50) NOT NULL,
  `reply_on` int(12) NOT NULL,
  `reply_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  KEY `reply_on` (`reply_on`),
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`id`) REFERENCES `documents` (`post_id`),
  CONSTRAINT `reply_ibfk_2` FOREIGN KEY (`id`) REFERENCES `documents` (`post_id`),
  CONSTRAINT `reply_ibfk_3` FOREIGN KEY (`reply_on`) REFERENCES `documents` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `student_login` */

DROP TABLE IF EXISTS `student_login`;

CREATE TABLE `student_login` (
  `sno` int(15) NOT NULL auto_increment,
  `userid` varchar(20) NOT NULL,
  `password` varchar(20) default NULL,
  PRIMARY KEY  (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `Sno` int(12) NOT NULL auto_increment,
  `first_name` char(15) NOT NULL,
  `last_name` char(15) NOT NULL,
  `userid` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `sex` char(15) default NULL,
  `Emailid` varchar(50) NOT NULL default '',
  `Class` char(10) NOT NULL,
  PRIMARY KEY  (`Sno`,`userid`),
  UNIQUE KEY `Sno` (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
