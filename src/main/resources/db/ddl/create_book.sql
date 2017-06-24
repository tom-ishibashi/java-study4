CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `publisher` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
;