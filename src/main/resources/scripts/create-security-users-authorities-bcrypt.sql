USE `myspringdb`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('user','{bcrypt}$2a$10$WELUmGnDSxHn0QDIsKUJjuSOyemBiPsSAJogQGwkojhYyJkTnRKtK',1),
('manager','{bcrypt}$2a$10$f52YD9X6eVvTVWxhxUtXuuKmB5zbFPnlwx2aP2fjVVJ.SeZkF0xwa',1),
('admin','{bcrypt}$2a$10$YMrcB/ON2Gmwy4ZE9YKFoufaG5HjZwAsShnGvY4CWTjMW1ZwO3CV2',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('user','ROLE_USER'),
('manager','ROLE_USER'),
('manager','ROLE_MANAGER'),
('admin','ROLE_USER'),
('admin','ROLE_MANAGER'),
('admin','ROLE_ADMIN');


