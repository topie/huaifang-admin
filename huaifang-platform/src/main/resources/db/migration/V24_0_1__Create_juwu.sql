DROP TABLE IF EXISTS d_juwu_info;
CREATE TABLE d_juwu_info (
  id          INT(11)   NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  title       VARCHAR(255)            DEFAULT ''
  COMMENT '栏目名称',
  content     LONGTEXT                DEFAULT NULL
  COMMENT '内容:kindEditor',
  update_time TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间:datetime',
  status      VARCHAR(16)             DEFAULT ''
  COMMENT '状态:skip',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '村务公开';

INSERT INTO `d_function` VALUES ('35', '7', '村务公开管理', '1', '1', NULL, '/api/core/juwuInfo/list', '7', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '35');
