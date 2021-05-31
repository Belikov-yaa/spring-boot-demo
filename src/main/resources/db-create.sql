CREATE TABLE `gb-shop`.`product` (
                                     `id` INT NOT NULL,
                                     `title` VARCHAR(250) NOT NULL DEFAULT 'none',
                                     `price` INT NULL,
                                     PRIMARY KEY (`id`),
                                     UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

