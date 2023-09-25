# 创建数据库 spring_boot
CREATE DATABASE IF NOT EXISTS spring_boot;

# 选择数据库 spring_boot
USE spring_boot;

# 创建用户表 t_user

CREATE TABLE `t_user`
(
    `id`         BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `login_name` VARCHAR(200) NULL DEFAULT NULL COMMENT '用户名称' COLLATE 'utf8_general_ci',
    `nick_name`  VARCHAR(200) NULL DEFAULT NULL COMMENT '用户昵称' COLLATE 'utf8_general_ci',
    `password`   VARCHAR(200) NULL DEFAULT NULL COMMENT '用户密码' COLLATE 'utf8_general_ci',
    PRIMARY KEY (`id`)
);

# 添加用户表 t_user 的数据
INSERT INTO `t_user`(`id`, `login_name`, `nick_name`, `password`)
VALUES (1, 'MYXH', '末影小黑xh', '520.ILY!'),
       (2, 'root', 'root 用户', '000000'),
       (3, 'admin', '管理员', '123456'),
       (4, 'test', '测试员', 'test');
