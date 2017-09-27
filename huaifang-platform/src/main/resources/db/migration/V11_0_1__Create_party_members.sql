INSERT INTO d_function VALUES ('16', '0', '党建管理', '1', '1', NULL, '#', '1', NULL, NULL);
INSERT INTO d_role_function (role_id, function_id) VALUES ('1', '16');

DROP TABLE IF EXISTS d_party_members_node;
CREATE TABLE d_party_members_node (
  id   INT(11)     NOT NULL AUTO_INCREMENT
  COMMENT '节点ID:hidden',
  pid  INT(11)     NOT NULL
  COMMENT '父节点ID:hidden',
  name VARCHAR(64) NOT NULL DEFAULT ''
  COMMENT '节点名称',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '党员树节点';

DROP TABLE IF EXISTS d_party_members_info;
CREATE TABLE d_party_members_info (
  id         INT(11)      NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  node_id    INT(11)      NOT NULL
  COMMENT '节点ID:hidden',
  node_name   VARCHAR(128)               DEFAULT ''
  COMMENT '党节点名称',
  name       VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '党员名称',
  code       VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '党员编号',
  flag       VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '党员标示:select:[入党申请人,入党积极分子,发展对象,预备党员,正式党员]',
  enter_date DATE         NULL          DEFAULT NULL
  COMMENT '入党时间:date',
  tag        VARCHAR(255) NOT NULL      DEFAULT ''
  COMMENT '党员标签:checkboxGroup:[在职党员,离退休党员,大学生党员,流动党员,下岗失业、无业、个体党员,非公党员,社区工作者党员]',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '党员信息';

INSERT INTO d_function VALUES ('17', '16', '党员管理', '1', '1', NULL, '/api/core/partyMembersInfo/list', '1', NULL, NULL);
INSERT INTO d_role_function (role_id, function_id) VALUES ('1', '17');

DROP TABLE IF EXISTS d_party_members_business;
CREATE TABLE d_party_members_business (
  id           INT(11)   NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  type         VARCHAR(16)             DEFAULT ''
  COMMENT '分类:select:[学习交流,党务公开]',
  title        VARCHAR(255)            DEFAULT ''
  COMMENT '标题:textarea',
  content      LONGTEXT  NULL
  COMMENT '内容:kindEditor',
  file         VARCHAR(255)            DEFAULT ''
  COMMENT '附件:file',
  publish_user VARCHAR(255)            DEFAULT ''
  COMMENT '发布者',
  publish_time TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '发布时间:datetime',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '党务信息';

INSERT INTO d_function
VALUES ('18', '16', '党务管理', '1', '1', NULL, '/api/core/partyMembersBusiness/list', '2', NULL, NULL);
INSERT INTO d_role_function (role_id, function_id) VALUES ('1', '18');


DROP TABLE IF EXISTS d_party_members_activity;
CREATE TABLE d_party_members_activity (
  id             INT(11)   NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  topic          VARCHAR(255)            DEFAULT ''
  COMMENT '活动主题:textarea',
  image          VARCHAR(255)            DEFAULT ''
  COMMENT '封面:image',
  address        VARCHAR(1024)           DEFAULT ''
  COMMENT '活动地址:textarea',
  begin_time     TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '开始时间:datetime',
  end_time       TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '结束时间:datetime',
  join_limit     INT(11)                 DEFAULT 0
  COMMENT '人数上限',
  activity_range VARCHAR(64)             DEFAULT ''
  COMMENT '活动范围',
  content        LONGTEXT  NULL
  COMMENT '活动内容:kindEditor',
  publish_user   VARCHAR(255)            DEFAULT ''
  COMMENT '发布者',
  publish_time   TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '发布时间:datetime',
  status         INT(11)                 DEFAULT 0
  COMMENT '状态0未上线1上线中2已结束:skip',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '党员活动信息';

INSERT INTO d_function
VALUES ('19', '16', '党活动管理', '1', '1', NULL, '/api/core/partyMembersActivity/list', '3', NULL, NULL);
INSERT INTO d_role_function (role_id, function_id) VALUES ('1', '19');
