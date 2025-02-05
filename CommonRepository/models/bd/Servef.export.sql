SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Servef` DEFAULT CHARACTER SET utf8 ;
USE `Servef` ;

-- -----------------------------------------------------
-- Table `Servef`.`TipoEmpleo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Servef`.`TipoEmpleo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `categoriaProfesional` VARCHAR(45) NULL DEFAULT NULL,
  `cargo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Servef`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Servef`.`Curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `fechaInicio` DATE NULL DEFAULT NULL,
  `fechaFin` DATE NULL DEFAULT NULL,
  `TipoEmpleo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Curso_TipoEmpleo1_idx` (`TipoEmpleo_id` ASC),
  CONSTRAINT `fk_Curso_TipoEmpleo1`
    FOREIGN KEY (`TipoEmpleo_id`)
    REFERENCES `Servef`.`TipoEmpleo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Servef`.`Empleo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Servef`.`Empleo` (
  `idEmpleo` INT NOT NULL AUTO_INCREMENT,
  `puesto` VARCHAR(45) NULL DEFAULT NULL,
  `sueldoHora` FLOAT NULL DEFAULT NULL,
  `horasSemanales` FLOAT NULL DEFAULT NULL,
  `fechaInicio` DATE NULL DEFAULT NULL,
  `fechaFin` DATE NULL DEFAULT NULL,
  `TipoEmpleo_id` INT NOT NULL,
  PRIMARY KEY (`idEmpleo`, `TipoEmpleo_id`),
  INDEX `fk_Empleo_TipoEmpleo1_idx` (`TipoEmpleo_id` ASC),
  CONSTRAINT `fk_Empleo_TipoEmpleo1`
    FOREIGN KEY (`TipoEmpleo_id`)
    REFERENCES `Servef`.`TipoEmpleo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Servef`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Servef`.`Empleado` (
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `mesesRestantesParo` INT NULL DEFAULT NULL,
  `fechaInicioParo` DATE NULL DEFAULT NULL,
  `fechaFinParo` DATE NULL DEFAULT NULL,
  `prestacionParo` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Servef`.`Empleado_has_Empleo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Servef`.`Empleado_has_Empleo` (
  `Empleado_dni` VARCHAR(9) NOT NULL,
  `Empleo_idEmpleo` INT NOT NULL,
  PRIMARY KEY (`Empleado_dni`, `Empleo_idEmpleo`),
  INDEX `fk_Empleado_has_Empleo_Empleo1_idx` (`Empleo_idEmpleo` ASC),
  INDEX `fk_Empleado_has_Empleo_Empleado_idx` (`Empleado_dni` ASC),
  CONSTRAINT `fk_Empleado_has_Empleo_Empleado`
    FOREIGN KEY (`Empleado_dni`)
    REFERENCES `Servef`.`Empleado` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_has_Empleo_Empleo1`
    FOREIGN KEY (`Empleo_idEmpleo`)
    REFERENCES `Servef`.`Empleo` (`idEmpleo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
