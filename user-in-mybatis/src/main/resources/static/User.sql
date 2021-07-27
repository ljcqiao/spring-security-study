CREATE TABLE `role`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(32) DEFAULT NULL,
	PRIMARY KEY (`id`) 
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

CREATE TABLE `user`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`username` varchar(32) DEFAULT NULL,
	`password` varchar(255) DEFAULT NULL,
	`enable` int(1) DEFAULT NULL,
	`account_non_expired` int(1) DEFAULT NULL,
	`credentials_non_expired` int(1) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

CREATE TABLE `user_role`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`uid` int(11)  DEFAULT NULL,
	`rid` int(11)  DEFAULT NULL,
	PRIMARY KEY (`id`),
	KEY `uid` (`uid`),
	KEY `rid` (`rid`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

	
