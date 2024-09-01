USE `myspringdb`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pw` varchar(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `members`
--

INSERT INTO `members` 
VALUES 
('user','{bcrypt}$2a$10$WELUmGnDSxHn0QDIsKUJjuSOyemBiPsSAJogQGwkojhYyJkTnRKtK',1),
('manager','{bcrypt}$2a$10$f52YD9X6eVvTVWxhxUtXuuKmB5zbFPnlwx2aP2fjVVJ.SeZkF0xwa',1),
('admin','{bcrypt}$2a$10$YMrcB/ON2Gmwy4ZE9YKFoufaG5HjZwAsShnGvY4CWTjMW1ZwO3CV2',1);


--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `roles_idx_1` (`user_id`,`role`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles` 
VALUES 
('user','ROLE_USER'),
('manager','ROLE_USER'),
('manager','ROLE_MANAGER'),
('admin','ROLE_USER'),
('admin','ROLE_MANAGER'),
('admin','ROLE_ADMIN');


