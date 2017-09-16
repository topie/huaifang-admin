DROP TABLE IF EXISTS d_app_user;
CREATE TABLE d_app_user (
  id              INT(11)   NOT NULL   AUTO_INCREMENT,
  platform_id     INT(11)   NOT NULL   DEFAULT 0
  COMMENT '平台ID',
  nickname        VARCHAR(64)          DEFAULT ''
  COMMENT '昵称',
  realname        VARCHAR(64)          DEFAULT ''
  COMMENT '姓名',
  head_image      VARCHAR(255)         DEFAULT ''
  COMMENT '头像',
  mobile_phone    VARCHAR(32)          DEFAULT ''
  COMMENT '手机',
  identity_number VARCHAR(64)          DEFAULT ''
  COMMENT '身份证号',
  reg_time        TIMESTAMP NULL       DEFAULT CURRENT_TIMESTAMP
  COMMENT '注册时间',
  add_time        TIMESTAMP NULL       DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  status          SMALLINT             DEFAULT 0
  COMMENT '审核状态0未认证1待审核2审核通过3审核不通过',
  login_status    TINYINT              DEFAULT 0
  COMMENT '登录状态0锁定1激活',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT 'APP用户信息';


DROP TABLE IF EXISTS d_app_user_friend;
CREATE TABLE d_app_user_friend (
  user_id   INT(11) NOT NULL DEFAULT 0
  COMMENT '用户ID',
  friend_id INT(11) NOT NULL DEFAULT 0
  COMMENT '朋友ID',
  PRIMARY KEY (user_id, friend_id)
)
  DEFAULT CHARSET = utf8
  COMMENT '好友信息关联';

DROP TABLE IF EXISTS d_app_user_message;
CREATE TABLE d_app_user_message (
  id           INT(11)   NOT NULL   AUTO_INCREMENT,
  from_user_id INT(11)   NOT NULL   DEFAULT 0
  COMMENT '发送用户ID',
  to_user_id   INT(11)   NOT NULL   DEFAULT 0
  COMMENT '接收用户ID',
  send_time    TIMESTAMP NULL       DEFAULT CURRENT_TIMESTAMP
  COMMENT '发送时间',
  content      VARCHAR(255)         DEFAULT ''
  COMMENT '发送内容',
  is_read      TINYINT              DEFAULT 0
  COMMENT '是否已读0未读1已读',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '好友信息';


DROP TABLE IF EXISTS d_app_time_line;
CREATE TABLE d_app_time_line (
  id            INT(11)   NOT NULL   AUTO_INCREMENT,
  add_user_id   INT(11)   NOT NULL   DEFAULT 0
  COMMENT '添加用户ID',
  add_user_name VARCHAR(32)          DEFAULT ''
  COMMENT '添加用户',
  add_time      TIMESTAMP NULL       DEFAULT CURRENT_TIMESTAMP
  COMMENT '添加时间',
  publish_time  TIMESTAMP NULL       DEFAULT CURRENT_TIMESTAMP
  COMMENT '发布时间',
  content       VARCHAR(255)         DEFAULT ''
  COMMENT '发送内容',
  images        VARCHAR(2048)        DEFAULT ''
  COMMENT '图片',
  status        SMALLINT             DEFAULT 0
  COMMENT '状态0:草稿1：发布',
  is_delete     TINYINT              DEFAULT 0
  COMMENT '是否删除0否1是',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '邻里圈';

DROP TABLE IF EXISTS d_app_time_line_comment;
CREATE TABLE d_app_time_line_comment (
  id            INT(11)   NOT NULL   AUTO_INCREMENT,
  line_id       INT(11)   NOT NULL   DEFAULT 0
  COMMENT '圈ID',
  re_comment_id INT(11)              DEFAULT 0
  COMMENT '回复评论ID',
  user_id       INT(11)   NOT NULL   DEFAULT 0
  COMMENT '评论用户ID',
  user_name     VARCHAR(32)          DEFAULT ''
  COMMENT '添加用户',
  comment_time  TIMESTAMP NULL       DEFAULT CURRENT_TIMESTAMP
  COMMENT '评论时间',
  content       VARCHAR(255)         DEFAULT ''
  COMMENT '评论内容',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '邻里圈评论';

DROP TABLE IF EXISTS d_app_time_line_like;
CREATE TABLE d_app_time_line_like (
  id        INT(11)   NOT NULL   AUTO_INCREMENT,
  line_id   INT(11)   NOT NULL   DEFAULT 0
  COMMENT '圈ID',
  user_id   INT(11)   NOT NULL   DEFAULT 0
  COMMENT '点赞用户ID',
  user_name VARCHAR(32)          DEFAULT ''
  COMMENT '点赞用户',
  like_time TIMESTAMP NULL       DEFAULT CURRENT_TIMESTAMP
  COMMENT '评论时间',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '邻里圈点赞';

