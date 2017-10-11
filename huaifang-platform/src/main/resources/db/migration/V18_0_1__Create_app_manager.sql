DROP TABLE IF EXISTS d_app_manager;
CREATE TABLE d_app_manager (
  id           INT(11)   NOT NULL    AUTO_INCREMENT
  COMMENT 'ID:hidden',
  system_type   VARCHAR(32)           DEFAULT ''
  COMMENT '系统类型:select:[ios,android]',
  version      VARCHAR(32)           DEFAULT ''
  COMMENT '版本',
  download_url  VARCHAR(255)          DEFAULT ''
  COMMENT '下载地址:file',
  publish_time TIMESTAMP NULL        DEFAULT CURRENT_TIMESTAMP
  COMMENT '发布时间:datetime',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT 'APP版本管理';
INSERT INTO `d_function` VALUES ('31', '2', 'APP版本管理', '1', '1', NULL, '/api/core/appManager/list', '6', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '31');

