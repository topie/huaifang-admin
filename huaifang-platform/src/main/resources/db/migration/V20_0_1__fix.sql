ALTER TABLE d_party_members_activity
  ADD COLUMN publish_user_id INT(11) DEFAULT 0
COMMENT '发布用户ID';

ALTER TABLE d_party_members_business
  ADD COLUMN read_count INT(11) DEFAULT 0
COMMENT '阅读数';
