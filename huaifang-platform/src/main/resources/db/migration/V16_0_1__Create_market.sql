DROP TABLE IF EXISTS d_market_line;
CREATE TABLE d_market_line (
  id            INT(11)   NOT NULL   AUTO_INCREMENT,
  type          SMALLINT  NOT NULL   DEFAULT 0
  COMMENT '类型0跳蚤市场1车位共享',
  add_user_id   INT(11)   NOT NULL   DEFAULT 0
  COMMENT '添加用户ID',
  add_user_name VARCHAR(32)          DEFAULT ''
  COMMENT '添加用户',
  head_image    VARCHAR(255)         DEFAULT ''
  COMMENT '用户头像',
  contact_phone VARCHAR(32)          DEFAULT ''
  COMMENT '联系电话',
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
  i_count       INT(11)              DEFAULT 0
  COMMENT '感兴趣人数',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '社区集市';


