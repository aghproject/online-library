drop database if exists onlinelibrary;
create database onlinelibrary;
use onlinelibrary;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(10) NOT NULL DEFAULT 'user',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NULL,
  `building_num` VARCHAR(45) NULL,
  `local_num` VARCHAR(45) NULL,
  `zipcode` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_address_1`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `author` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `desc` TEXT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `desc` TEXT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `author_id` INT NULL,
  `title` VARCHAR(45) NULL,
  `desc` TEXT NULL,
  `category_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_book_1`
  FOREIGN KEY (`author_id`)
  REFERENCES `author` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_book_2`
  FOREIGN KEY (`category_id`)
  REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_reservation_1`
  FOREIGN KEY (`book_id`)
  REFERENCES `book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_2`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `copy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NULL,
  `rented` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_copy_1`
  FOREIGN KEY (`book_id`)
  REFERENCES `book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `loan` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `copy_id` INT NULL,
  `user_id` INT NULL,
  `start_date` DATE NULL,
  `end_date` VARCHAR(45) NULL,
  `archive` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_loan_1`
  FOREIGN KEY (`copy_id`)
  REFERENCES `copy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_loan_2`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `fine` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `copy_id` INT NULL,
  `due_date` DATE NULL,
  `in_date` DATE NULL,
  `value` DECIMAL NULL,
  `paid` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_fine_1`
  FOREIGN KEY (`copy_id`)
  REFERENCES `copy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fine_2`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `comment` TEXT NULL,
  `rate` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_feedback_1`
  FOREIGN KEY (`book_id`)
  REFERENCES `book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_2`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;


INSERT INTO `user` VALUES (1, 'Peter', 'Test', 'test@test.pl', 'test', 'user');
INSERT INTO `address` VALUES (1, 'ulica', '10', '33', '32-432', 'Kraków', 'Polska', 1);
INSERT INTO `author` VALUES (1, 'Adam', 'Mickiewicz', 'jakis tam opis');
INSERT INTO `category` VALUES (1, 'Przygodowe', 'Opis kategorii przygodowe');
INSERT INTO `book` VALUES (1, 1, 'W pustyni i puszczy', 'Ksiazka o puszczy', 1);
INSERT INTO `book` VALUES (2, 1, 'Effective Java', 'Ksiazka o Javie', 1);
INSERT INTO `book` VALUES (3, 1, 'AngularJS', 'Ksiazka o Javascript', 1);
INSERT INTO `reservation` VALUES (1, 1, 1);
INSERT INTO `copy` VALUES (1, 1, 1);
INSERT INTO `copy` VALUES (2, 2, 1);
INSERT INTO `copy` VALUES (3, 3, 1);
INSERT INTO `copy` VALUES (4, 2, 0);
INSERT INTO `copy` VALUES (5, 3, 0);
INSERT INTO `loan` VALUES (1, 1, 1, '2015-12-12', '2015-01-01', 0);
INSERT INTO `loan` VALUES (2, 2, 1, '2015-12-19', '2015-02-01', 0);
INSERT INTO `loan` VALUES (3, 3, 1, '2015-12-23', '2015-04-01', 0);
INSERT INTO `fine` VALUES (1, 1, 1, '2016-01-01', '2016-10-01', 10.00, '0');
INSERT INTO `feedback` VALUES (1, 1, 1, 'komentarz do pustyni i puszczy', 3);

