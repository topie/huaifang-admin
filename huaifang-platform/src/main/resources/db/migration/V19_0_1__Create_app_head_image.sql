DROP TABLE IF EXISTS d_app_head_image;
CREATE TABLE d_app_head_image (
  id           INT(11)   NOT NULL    AUTO_INCREMENT
  COMMENT 'ID:hidden',
  image        VARCHAR(255)          DEFAULT ''
  COMMENT '头图:image',
  is_top       BIT                   DEFAULT 0
  COMMENT '是否置顶',
  publish_time TIMESTAMP NULL        DEFAULT CURRENT_TIMESTAMP
  COMMENT '发布时间:datetime',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT 'APP头图管理';
INSERT INTO `d_function` VALUES ('32', '2', 'APP头图管理', '1', '1', NULL, '/api/core/appHeadImage/list', '7', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '32');

