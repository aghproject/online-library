
INSERT INTO `user` VALUES (1, 'Peter', 'Test', 'test@test.pl', 'test', 'user');
INSERT INTO `address` VALUES (1, 'ulica', '10', '33', '32-432', 'Kraków', 'Polska', 1);
INSERT INTO `author` VALUES (1, 'Adam', 'Mickiewicz', 'jakis tam opis');
INSERT INTO `category` VALUES (1, 'Przygodowe', 'Opis kategorii przygodowe');
INSERT INTO `book` VALUES (1, 1, 'W pustyni i puszczy', 'Ksiazka o puszczy', 1);
INSERT INTO `book` VALUES (2, 1, 'Effective Java', 'Ksiazka o Javie', 1);
INSERT INTO `book` VALUES (3, 1, 'AngularJS', 'Ksiazka o Javascript', 1);
INSERT INTO `reservation` VALUES (1, 1, 1);
INSERT INTO `copy` VALUES (1, 1);
INSERT INTO `copy` VALUES (2, 2);
INSERT INTO `copy` VALUES (3, 3);
INSERT INTO `loan` VALUES (1, 1, 1, '2015-12-12', '2015-01-01');
INSERT INTO `loan` VALUES (2, 2, 1, '2015-12-19', '2015-02-01');
INSERT INTO `loan` VALUES (3, 3, 1, '2015-12-23', '2015-04-01');
INSERT INTO `fine` VALUES (1, 1, 1, '2016-01-01', '2016-10-01', 10.00, '0');
INSERT INTO `feedback` VALUES (1, 1, 1, 'komentarz do pustyni i puszczy', 3);

