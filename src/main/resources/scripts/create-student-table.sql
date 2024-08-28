CREATE DATABASE IF NOT EXISTS `myspringdb`;

USE `myspringdb`;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
	`id` int not null auto_increment,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null,
    primary key(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;