DROP TABLE IF EXISTS `categories`;

create table `categories`
(
    `id`          int auto_increment
        primary key,
    `title`       varchar(255)  not null,
    `description` varchar(1000) null
) charset = utf8mb4;

insert into `categories`
values (1, 'food', "Продукты питания");

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product`
(
    `id`        int(11)       NOT NULL AUTO_INCREMENT primary key,
    category_id int           not null,
    `title`     varchar(250)  NOT NULL DEFAULT 'none',
    description varchar(1000) not null,
    `price`     int                    DEFAULT NULL,
    constraint FK_CATEGORY_ID
        foreign key (category_id) references categories (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


--
-- Dumping data for table `product`
--

LOCK
    TABLES `product` WRITE;

INSERT INTO `product`
VALUES (1, 1, 'milk', '-', 6),
       (2, 1, 'bread', '-', 4),
       (3, 1, 'chocolate', '-', 7),
       (4, 1, 'tomato', '-', 15),
       (5, 1, 'potato', '-', 5),
       (6, 1, 'apples', '-', 16),
       (7, 1, 'beer', '-', 5),
       (8, 1, 'cheese', '-', 50),
       (9, 1, 'brandy', '-', 60),
       (10, 1, 'fish', '-', 24),
       (11, 1, 'creeks', '-', 10),
       (12, 1, 'ice cream', '-', 6),
       (13, 1, 'juice', '-', 9),
       (14, 1, 'butter', '-', 12),
       (15, 1, 'meat', '-', 45),
       (16, 1, 'eggs', '-', 6),
       (17, 1, 'chicken', '-', 22),
       (18, 1, 'candies', '-', 32),
       (19, 1, 'sugar', '-', 5),
       (20, 1, 'salt', '-', 2),
       (21, 1, 'pepper', '-', 3),
       (22, 1, 'Yoghurt', '-', 7),
       (23, 1, 'Cake', '-', 15);

UNLOCK
    TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


--
-- Dumping data for table `roles`
--

LOCK
    TABLES `roles` WRITE;

INSERT INTO `roles`
VALUES (1, 'ROLE_EMPLOYEE'),
       (2, 'ROLE_MANAGER'),
       (3, 'ROLE_ADMIN');

UNLOCK
    TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`
(
    id         int auto_increment
        primary key,
    username   varchar(50)       not null,
    password   char(80)          not null,
    first_name varchar(50)       not null,
    last_name  varchar(50)       not null,
    email      varchar(50)       not null,
    enabled    tinyint default 1 not null
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `users`
--

LOCK
    TABLES `users` WRITE;

INSERT INTO users (id, username, password, first_name, last_name, email, enabled)
VALUES (1, 'admin', '$2y$12$1ZWRy1ZMMaoZfJ8AQc4eZ.OI93nvv6XA0d2AQYimx51WnkBQEtP4K', 'admin', 'admin', 'admin@mail.ru',
        1);
INSERT INTO users (id, username, password, first_name, last_name, email, enabled)
VALUES (2, 'user', '$2y$12$h567nKuTuC2t9Rverw77V.63bbJv9ej5ow1cPCqkGEDRUk6kYIoc2', 'Bob', 'Dilan',
        'bob.dilan@gmail.com', 1);

UNLOCK
    TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles`
(
    `user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    KEY `FK_ROLE_ID` (`role_id`),
    CONSTRAINT `FK_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
    CONSTRAINT `FK_USER_ID_01` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Dumping data for table `users_roles`
--

LOCK
    TABLES `users_roles` WRITE;

INSERT INTO `users_roles`
VALUES (1, 1),
       (2, 1),
       (1, 2),
       (1, 3);

UNLOCK
    TABLES;

create table orders_statuses
(
    id    int auto_increment
        primary key,
    title varchar(50) null
)
    charset = utf8;

INSERT INTO `orders_statuses` (`title`)
VALUES ('Создан'),
       ('Оплачен'),
       ('Отправлен'),
       ('Получен'),
       ('Закрыт'),
       ('Отменен');

create table orders
(
    id           int auto_increment
        primary key,
    user_id      int                                 not null,
    price        int                                 not null,
    phone_number varchar(20)                         not null,
    status_id    int                                 not null,
    create_at    timestamp default CURRENT_TIMESTAMP not null,
    constraint FK_STATUS_ID
        foreign key (status_id) references orders_statuses (id),
    constraint FK_USER_ID
        foreign key (user_id) references users (id)
)
    charset = utf8;

create table orders_item
(
    id         int auto_increment
        primary key,
    product_id int not null,
    order_id   int not null,
    quantity   int not null,
    item_price int not null,
    constraint FK_ORDER_ID
        foreign key (order_id) references orders (id),
    constraint FK_PRODUCT_ID_ORD_IT
        foreign key (product_id) references product (id)
)
    charset = utf8;

create table products_images
(
    id         int auto_increment
        primary key,
    product_id int          not null,
    path       varchar(250) not null,
    constraint FK_PRODUCT_ID_IMG
        foreign key (product_id) references product (id)
)
    charset = utf8;

