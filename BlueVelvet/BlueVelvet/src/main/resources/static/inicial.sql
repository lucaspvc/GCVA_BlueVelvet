CREATE TABLE `db`.`product` (
                           `id` INT NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(30) NULL,
                           `short_description` VARCHAR(50) NULL,
                           `full_description` VARCHAR(100) NULL,
                           `brand` VARCHAR(45) NULL,
                           `category` VARCHAR(45) NULL,
                           `list_price` DECIMAL(14,2) NULL,
                           `discount` DECIMAL(14,2) NULL,
                           `enabled` BIT NULL,
                           `in_stock` BIT NULL,
                           `creation_time` DATETIME NULL,
                           `update_time` DATETIME NULL,
                           `cost` DECIMAL(14,2) NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
);