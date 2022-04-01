# 邮箱配置表结构脚本

```sql
-- 建表语句
DROP TABLE IF EXISTS email_config;
CREATE TABLE email_config (
    id               INT         NOT NULL AUTO_INCREMENT COMMENT '主键;自增id',
    email_type       VARCHAR(2) COMMENT '邮箱类型;1.阿里邮箱 2.QQ邮箱 3.网易邮箱',
    host             VARCHAR(20) COMMENT '邮箱服务器',
    port             INT COMMENT '端口号',
    username         VARCHAR(50) NOT NULL COMMENT '邮箱平台账号',
    password         VARCHAR(50) NOT NULL COMMENT '邮箱平台授权码',
    protocol         VARCHAR(10) COMMENT '协议;smtp',
    default_encoding VARCHAR(10) COMMENT '邮件编码',
    enbale           VARCHAR(1)  NOT NULL DEFAULT 1 COMMENT '是否启用;0禁用 1启用',
    state            VARCHAR(1)  NOT NULL DEFAULT 1 COMMENT '是否删除;0删除 1存在',
    created_by       VARCHAR(10) NOT NULL COMMENT '创建人',
    created_time     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_by       VARCHAR(10) COMMENT '更新人',
    updated_time     TIMESTAMP            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT = '电子邮箱配置表';

-- 索引语句
CREATE UNIQUE INDEX UK_USERNAME ON email_config(username);
```
