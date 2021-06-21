CREATE TABLE `gb-shop`.`product` (
                                     `id` INT NOT NULL,
                                     `title` VARCHAR(250) NOT NULL DEFAULT 'none',
                                     `price` INT NULL,
                                     PRIMARY KEY (`id`),
                                     UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('milk', '6');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('bread', '4');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('chocolate', '7');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('tomato', '15');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('potato', '5');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('apples', '16');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('beer', '5');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('cheese', '50');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('brandy', '60');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('fish', '24');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('crekers', '10');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('ice cream', '6');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('juice', '9');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('butter', '12');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('meat', '45');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('eggs', '6');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('chicken', '22');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('kandies', '32');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('sugar', '5');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('salt', '2');
INSERT INTO `gb-shop`.`product` (`title`, `price`) VALUES ('pepper', '3');