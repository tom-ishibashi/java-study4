CREATE TABLE `library_book_link` (
  `library_id` int(11) NOT NULL DEFAULT '0',
  `book_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`library_id`,`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
;
