# 全局配置表
DROP TABLE IF EXISTS global_config;
CREATE TABLE global_config
(
    id           bigint       NOT NULL AUTO_INCREMENT COMMENT 'id',
    config_key   VARCHAR(32)  NOT NULL COMMENT '配置key',
    config_value VARCHAR(32)  NOT NULL COMMENT '配置内容',
    description  VARCHAR(255) NOT NULL COMMENT '描述',
    created_by   VARCHAR(32)  NOT NULL COMMENT '创建人',
    created_time DATETIME     NOT NULL COMMENT '创建时间',
    updated_by   VARCHAR(32)  NOT NULL COMMENT '更新人',
    updated_time DATETIME     NOT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT = '全局配置表';

CREATE UNIQUE INDEX uni_key ON global_config (config_key);

# 员工表
DROP TABLE IF EXISTS employee;
CREATE TABLE employee
(
    id           VARCHAR(32)  NOT NULL AUTO_INCREMENT COMMENT 'id',
    account      VARCHAR(32)  NOT NULL COMMENT '账号',
    password     VARCHAR(255) NOT NULL COMMENT '密码',
    name         VARCHAR(10)  NOT NULL COMMENT '姓名',
    cellphone    VARCHAR(13) COMMENT '手机号',
    created_by   VARCHAR(32)  NOT NULL COMMENT '创建人',
    created_time DATETIME     NOT NULL COMMENT '创建时间',
    updated_by   VARCHAR(32)  NOT NULL COMMENT '更新人',
    updated_time DATETIME     NOT NULL COMMENT '更新时间',
    deleted      VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (id)
) COMMENT = '员工信息表';

CREATE UNIQUE INDEX uni_account ON employee(account);
