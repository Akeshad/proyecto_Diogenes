-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Diogenes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Diogenes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Diogenes` DEFAULT CHARACTER SET utf8 ;
USE `Diogenes` ;

-- -----------------------------------------------------
-- Table `Diogenes`.`Philosopher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Diogenes`.`Philosopher` ;

CREATE TABLE IF NOT EXISTS `Diogenes`.`Philosopher` (
  `name` VARCHAR(45) NOT NULL,
  `timesLost` INT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Diogenes`.`Argument`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Diogenes`.`Argument` ;

CREATE TABLE IF NOT EXISTS `Diogenes`.`Argument` (
  `weapon` VARCHAR(100) NOT NULL,
  `text` VARCHAR(900) NOT NULL,
  `strength` INT NOT NULL,
  `timesLost` INT NOT NULL,
  `type1` VARCHAR(45) NOT NULL,
  `type2` VARCHAR(45) NOT NULL,
  `Philosopher_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`weapon`),
  INDEX `fk_Argument_Philosopher1_idx` (`Philosopher_name` ASC) VISIBLE,
  CONSTRAINT `fk_Argument_Philosopher1`
    FOREIGN KEY (`Philosopher_name`)
    REFERENCES `Diogenes`.`Philosopher` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Diogenes`.`Game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Diogenes`.`Game` ;

CREATE TABLE IF NOT EXISTS `Diogenes`.`Game` (
  `index` INT NULL,
  `Philosopher_name` VARCHAR(45) NOT NULL,
  INDEX `fk_Game_Philosopher1_idx` (`Philosopher_name` ASC) VISIBLE,
  PRIMARY KEY (`Philosopher_name`),
  CONSTRAINT `fk_Game_Philosopher1`
    FOREIGN KEY (`Philosopher_name`)
    REFERENCES `Diogenes`.`Philosopher` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Diogenes`.`Actions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Diogenes`.`Actions` ;

CREATE TABLE IF NOT EXISTS `Diogenes`.`Actions` (
  `action_index` INT NOT NULL,
  `tipo` TINYINT NULL,
  `Philosopher_name` VARCHAR(45) NULL,
  INDEX `fk_Actions_Philosopher1_idx` (`Philosopher_name` ASC) VISIBLE,
  PRIMARY KEY (`action_index`),
  CONSTRAINT `fk_Actions_Philosopher1`
    FOREIGN KEY (`Philosopher_name`)
    REFERENCES `Diogenes`.`Philosopher` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Diogenes`.`Message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Diogenes`.`Message` ;

CREATE TABLE IF NOT EXISTS `Diogenes`.`Message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `link` VARCHAR(45) NULL,
  `txt` VARCHAR(45) NULL,
  `Actions_action_index` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Message_Actions1_idx` (`Actions_action_index` ASC) VISIBLE,
  CONSTRAINT `fk_Message_Actions1`
    FOREIGN KEY (`Actions_action_index`)
    REFERENCES `Diogenes`.`Actions` (`action_index`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
