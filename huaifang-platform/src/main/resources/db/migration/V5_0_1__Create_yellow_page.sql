DROP TABLE IF EXISTS `d_yellow_page`;
CREATE TABLE `d_yellow_page` (
  `id`           INT(11)     NOT NULL AUTO_INCREMENT
  COMMENT '公告ID',
  `type`         SMALLINT    NOT NULL DEFAULT 0
  COMMENT '类型 0:常用电话 1：物业 2:卫生医疗 3：其它',
  `name`         VARCHAR(64) NOT NULL DEFAULT ''
  COMMENT '名称',
  `mobile_phone` VARCHAR(32)          DEFAULT ''
  COMMENT '联系电话',
  `note`         VARCHAR(1024)        DEFAULT ''
  COMMENT '备注',
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET = utf8
  COMMENT '迷你黄页';

INSERT INTO `d_function` VALUES ('9', '7', '黄页管理', '1', '1', NULL, '/api/core/yellowPage/list', '5', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '9');
