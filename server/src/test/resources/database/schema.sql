USE `testlibrary`;

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
  `id` INT NOT NULL,
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
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `desc` TEXT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `desc` TEXT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `book` (
  `id` INT NOT NULL,
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
  `id` INT NOT NULL,
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
  `id` INT NOT NULL,
  `book_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_copy_1`
  FOREIGN KEY (`book_id`)
  REFERENCES `book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `loan` (
  `id` INT NOT NULL,
  `copy_id` INT NULL,
  `user_id` INT NULL,
  `start_date` DATE NULL,
  `end_date` VARCHAR(45) NULL,
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
  `id` INT NOT NULL,
  `user_id` INT NULL,
  `copy_id` INT NULL,
  `due_date` DATE NULL,
  `in_date` DATE NULL,
  `value` VARCHAR(45) NULL,
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
  `id` INT NOT NULL,
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

