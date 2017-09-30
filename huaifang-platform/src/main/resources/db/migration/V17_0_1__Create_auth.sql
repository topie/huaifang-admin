DROP TABLE IF EXISTS d_auth_user;
CREATE TABLE d_auth_user (
  user_id         INT(11) NOT NULL   DEFAULT 0
  COMMENT '用户ID',
  person_id       INT(11)            DEFAULT 0
  COMMENT '人口ID',
  house_id        INT(11)            DEFAULT 0
  COMMENT '房屋ID',
  company_id      INT(11)            DEFAULT 0
  COMMENT '公司ID',
  party_member_id INT(11)            DEFAULT 0
  COMMENT '党员ID',
  PRIMARY KEY (user_id)
)
  DEFAULT CHARSET = utf8
  COMMENT '用户信息认证';


