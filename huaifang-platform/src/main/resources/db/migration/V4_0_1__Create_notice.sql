DROP TABLE IF EXISTS `d_notice`;
CREATE TABLE `d_notice` (
  `id`         INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '公告ID',
  `type`       SMALLINT     NOT NULL DEFAULT 0
  COMMENT '类型 0:社区 1：物业',
  `position`   SMALLINT     NOT NULL DEFAULT 0
  COMMENT '位置 0：普通 1：轮播',
  `title`      VARCHAR(255) NOT NULL DEFAULT ''
  COMMENT '标题',
  `banner_uri` VARCHAR(255)          DEFAULT ''
  COMMENT '轮播图uri',
  `content`    LONGTEXT     NOT NULL
  COMMENT '内容',
  `is_online`  BIT          NOT NULL DEFAULT 0
  COMMENT '是否上线',
  `c_user`     VARCHAR(64)  NOT NULL DEFAULT ''
  COMMENT '发布用户',
  `c_time`     TIMESTAMP             DEFAULT CURRENT_TIMESTAMP
  COMMENT '添加时间',
  `p_time`     TIMESTAMP    NULL
  COMMENT '发布时间',
  read_count   INT(11)               DEFAULT 0
  COMMENT '阅读次数',
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET = utf8
  COMMENT '通知公告';

INSERT INTO `d_function` VALUES ('7', '0', '业务管理', '1', '1', NULL, '#', '3', NULL, NULL);
INSERT INTO `d_function` VALUES ('8', '7', '公告管理', '1', '1', NULL, '/api/core/notice/list', '1', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '7');
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '8');
