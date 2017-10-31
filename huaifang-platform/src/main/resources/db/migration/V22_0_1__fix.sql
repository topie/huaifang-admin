ALTER TABLE d_app_message
  ADD COLUMN from_user_name VARCHAR(64) DEFAULT ''
COMMENT '用户昵称';

ALTER TABLE d_app_manager
  ADD COLUMN current INT(11) DEFAULT 0
COMMENT '是否当前版本';

ALTER TABLE d_app_manager
  ADD COLUMN force_update INT(11) DEFAULT 0
COMMENT '是否强制更新';
