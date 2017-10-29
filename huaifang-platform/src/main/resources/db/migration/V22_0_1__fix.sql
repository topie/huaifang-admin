ALTER TABLE d_app_message
  ADD COLUMN from_user_name VARCHAR(64) DEFAULT ''
COMMENT '用户昵称';
