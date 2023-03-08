# 建表语句
###钱包表
CREATE TABLE `demo`.`wallet` (
`id` INT NOT NULL AUTO_INCREMENT,
`cardId` VARCHAR(45) NOT NULL COMMENT '钱包卡号',
`amount` DECIMAL NULL COMMENT '金额',
`userId` INT NOT NULL COMMENT '用户ID',
`password` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `cardId_UNIQUE` (`cardId` ASC));
###钱包明细表
CREATE TABLE `demo2`.`bill` (
`id` INT NOT NULL,
`cardId` INT NOT NULL COMMENT '钱包卡号',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`amount` DECIMAL NULL COMMENT '金额',
`type` INT NULL COMMENT '1.支出  2.存入 3.退款',
 PRIMARY KEY (`id`));

