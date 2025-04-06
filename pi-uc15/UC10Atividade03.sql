-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema gameverse
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`funcionarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `genero` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `endereco` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`jogos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`jogos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `plataforma` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NOT NULL,
  `descricao` LONGTEXT NOT NULL,
  `fabricante` VARCHAR(90) NOT NULL,
  `estoque` INT NOT NULL,
  `valor` DECIMAL(7,2) NOT NULL,
  `jogo_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `jogo_id_idx` (`jogo_id` ASC) VISIBLE,
  CONSTRAINT `jogo_id`
    FOREIGN KEY (`jogo_id`)
    REFERENCES `mydb`.`jogos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vendas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade_comprada` INT NOT NULL,
  `data_compra` DATETIME NOT NULL,
  `funcionario_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `atendente_id_idx` (`funcionario_id` ASC) VISIBLE,
  INDEX `cliente_id_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `produto_id_idx` (`produto_id` ASC) VISIBLE,
  CONSTRAINT `atendente_id`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `mydb`.`funcionarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cliente_id`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `mydb`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `produto_id`
    FOREIGN KEY (`produto_id`)
    REFERENCES `mydb`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- -----------------------------------------------------
-- Table `mydb`.`vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vendas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade_comprada` INT NOT NULL,
  `data_compra` DATETIME NOT NULL,
  `funcionario_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  `pagamento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `atendente_id_idx` (`funcionario_id` ASC) VISIBLE,
  INDEX `cliente_id_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `produto_id_idx` (`produto_id` ASC) VISIBLE,
  CONSTRAINT `atendente_id`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `mydb`.`funcionarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cliente_id`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `mydb`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `produto_id`
    FOREIGN KEY (`produto_id`)
    REFERENCES `mydb`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
