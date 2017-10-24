DROP TABLE IF EXISTS d_around_activity;
CREATE TABLE d_around_activity (
  id              INT(11)   NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  title           VARCHAR(255)            DEFAULT ''
  COMMENT '活动主题:textarea',
  type            VARCHAR(255)            DEFAULT ''
  COMMENT '活动类型:select:[社团活动,商业推广,亲子活动,自发活动]',
  begin_time      TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '开始时间:datetime',
  end_time        TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '结束时间:datetime',
  limit_time      TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '报名截止日期:datetime',
  create_time     TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间:skip',
  join_limit      INT(11)                 DEFAULT 0
  COMMENT '人数上限:text',
  address         VARCHAR(1024)           DEFAULT ''
  COMMENT '活动地址:textarea',
  content         LONGTEXT  NULL
  COMMENT '活动内容:kindEditor',
  image           VARCHAR(255)            DEFAULT ''
  COMMENT '封面:image',
  publish_user_id INT(11)                 DEFAULT 0
  COMMENT '发布用户ID',
  publish_user    VARCHAR(255)            DEFAULT ''
  COMMENT '发布者:text',
  publish_time    TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '发布时间:datetime',
  status          VARCHAR(32)             DEFAULT 0
  COMMENT '状态:select:[未开始,已开始,已结束]',
  read_count      INT(11)                 DEFAULT 0
  COMMENT '阅读数',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '发现活动信息';


DROP TABLE IF EXISTS d_around_activity_join;
CREATE TABLE d_around_activity_join (
  activity_id INT(11) NOT NULL  DEFAULT 0
  COMMENT '活动ID',
  user_id     INT(11) NOT NULL  DEFAULT 0
  COMMENT '用户ID',
  PRIMARY KEY (activity_id, user_id)
)
  DEFAULT CHARSET = utf8
  COMMENT '发现活动参加信息';

INSERT INTO `d_function` VALUES ('33', '7', '发现活动管理', '1', '1', NULL, '/api/core/aroundActivity/list', '8', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '33');

