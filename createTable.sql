-- 客户表
CREATE TABLE `tbclient`
(
    `clientid`              bigint                                                  NOT NULL COMMENT '唯一标识客户号',
    `clientname`            varchar(255)                                            NOT NULL COMMENT '客户名称',
    `clientsex`             int                                                     NOT NULL COMMENT '性别：1男；0女',
    `clientnation`          int                                                     NOT NULL COMMENT '名族：对应字典查询',
    `userphoneno`           varchar(20)  DEFAULT NULL,
    `clientbirthdayaddress` varchar(255)                                            NOT NULL COMMENT '出生地地址',
    `identityid`            varchar(20)                                             NOT NULL COMMENT '身份证号',
    `address`               varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '现居住地',
    `reserve1`              varchar(255) DEFAULT NULL COMMENT '备用1',
    `reserve2`              varchar(255) DEFAULT NULL COMMENT '备用2',
    `reserve3`              varchar(255) DEFAULT NULL COMMENT '备用3',
    `reserve4`              varchar(255) DEFAULT NULL COMMENT '备用4',
    PRIMARY KEY (`clientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 字典表
CREATE TABLE `tbdict`
(
    `key`         varchar(255)                                            NOT NULL COMMENT 'key',
    `keyname`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'key名称',
    `keyvalue`    varchar(255)                                            NOT NULL COMMENT 'key值',
    `keydescribe` varchar(255)                                            NOT NULL COMMENT 'key值描述',
    `status`      int                                                     NOT NULL COMMENT 'key状态',
    `reserve1`    varchar(255) DEFAULT NULL COMMENT '备用字段1',
    `reserve2`    varchar(255) DEFAULT NULL COMMENT '备用字段2',
    `reserve3`    varchar(255) DEFAULT NULL COMMENT '备用字段3',
    `reserve4`    varchar(255) DEFAULT NULL COMMENT '备用字段4'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 用户表
CREATE TABLE `useraccount`
(
    `userid`       bigint       NOT NULL COMMENT '系统唯一用户号',
    `username`     varchar(50)  NOT NULL COMMENT '系统唯一对客户用户名',
    `userpassword` varchar(100) NOT NULL COMMENT '用户密码',
    `status`       varchar(1)   NOT NULL COMMENT '用户状态：0登录，1下线，2锁定',
    `reserve1`     varchar(50) DEFAULT NULL COMMENT '备用字段1',
    `reserve2`     varchar(50) DEFAULT NULL COMMENT '备用字段2',
    `reserve3`     varchar(50) DEFAULT NULL COMMENT '备用字段3',
    `reserve4`     varchar(50) DEFAULT NULL COMMENT '备用字段4',
    PRIMARY KEY (`userid`, `username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;