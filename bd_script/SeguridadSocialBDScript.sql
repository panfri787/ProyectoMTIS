CREATE SCHEMA IF NOT EXISTS `SeguridadSocial` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS `SeguridadSocial`.`TipoEmpleo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `categoriaProfesional` VARCHAR(45) NULL,
  `cargo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SeguridadSocial`.`Empleado` (
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `mesesRestantesParo` INT NULL,
  `fechaInicioParo` DATE NULL,
  `fechaFinParo` DATE NULL,
  `prestacionParo` FLOAT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SeguridadSocial`.`Empleo` (
  `idEmpleo` INT NOT NULL AUTO_INCREMENT,
  `puesto` VARCHAR(45) NULL,
  `sueldoHora` FLOAT NULL,
  `horasSemanales` FLOAT NULL,
  `fechaInicio` DATE NULL,
  `fechaFin` DATE NULL,
  `TipoEmpleo_id` INT NOT NULL,
  PRIMARY KEY (`idEmpleo`, `TipoEmpleo_id`),
  INDEX `fk_Empleo_TipoEmpleo1_idx` (`TipoEmpleo_id` ASC),
  CONSTRAINT `fk_Empleo_TipoEmpleo1`
    FOREIGN KEY (`TipoEmpleo_id`)
    REFERENCES `SeguridadSocial`.`TipoEmpleo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SeguridadSocial`.`Empleado_has_Empleo` (
  `Empleado_dni` VARCHAR(9) NOT NULL,
  `Empleo_idEmpleo` INT NOT NULL,
  PRIMARY KEY (`Empleado_dni`, `Empleo_idEmpleo`),
  INDEX `fk_Empleado_has_Empleo_Empleo1_idx` (`Empleo_idEmpleo` ASC),
  INDEX `fk_Empleado_has_Empleo_Empleado_idx` (`Empleado_dni` ASC),
  CONSTRAINT `fk_Empleado_has_Empleo_Empleado`
    FOREIGN KEY (`Empleado_dni`)
    REFERENCES `SeguridadSocial`.`Empleado` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_has_Empleo_Empleo1`
    FOREIGN KEY (`Empleo_idEmpleo`)
    REFERENCES `SeguridadSocial`.`Empleo` (`idEmpleo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SeguridadSocial`.`Curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `fechaInicio` DATE NULL,
  `fechaFin` DATE NULL,
  `TipoEmpleo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Curso_TipoEmpleo1_idx` (`TipoEmpleo_id` ASC),
  CONSTRAINT `fk_Curso_TipoEmpleo1`
    FOREIGN KEY (`TipoEmpleo_id`)
    REFERENCES `SeguridadSocial`.`TipoEmpleo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;