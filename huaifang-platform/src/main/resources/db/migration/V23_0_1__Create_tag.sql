DROP TABLE IF EXISTS d_tag;
CREATE TABLE d_tag (
  id       INT(11) NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  tag_name VARCHAR(255)          DEFAULT ''
  COMMENT '标签名',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '标签';


DROP TABLE IF EXISTS d_user_tag;
CREATE TABLE d_user_tag (
  user_id INT(11) NOT NULL DEFAULT 0
  COMMENT '用户ID',
  tag_id  INT(11) NOT NULL DEFAULT 0
  COMMENT '标签名',
  PRIMARY KEY (user_id, tag_id)
)
  DEFAULT CHARSET = utf8
  COMMENT '用户标签';


INSERT INTO `d_function` VALUES ('34', '7', '标签管理', '1', '1', NULL, '/api/core/tag/list', '9', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '34');
