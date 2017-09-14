DROP TABLE IF EXISTS d_action_guide_cat;
CREATE TABLE d_action_guide_cat (
  id             INT(11) NOT NULL AUTO_INCREMENT
  COMMENT 'ID:hidden',
  name           VARCHAR(64)      DEFAULT ''
  COMMENT '栏目名称',
  title          VARCHAR(64)      DEFAULT ''
  COMMENT '办事事项',
  address        VARCHAR(255)     DEFAULT ''
  COMMENT '地址:textarea',
  contact_person VARCHAR(32)      DEFAULT ''
  COMMENT '联系人员',
  phone          VARCHAR(32)      DEFAULT ''
  COMMENT '联系号码',
  note           VARCHAR(1024)    DEFAULT ''
  COMMENT '备注',
  status         VARCHAR(16)      DEFAULT '未上线'
  COMMENT '状态:select:[未上线,已上线]',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '办事指南预约信息';

INSERT INTO `d_function` VALUES ('25', '7', '办事预约管理', '1', '1', NULL, '/api/core/actionGuideCat/list', '2', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '25');

DROP TABLE IF EXISTS d_action_guide;
CREATE TABLE d_action_guide (
  id               INT(11)   NOT NULL AUTO_INCREMENT
  COMMENT 'ID:hidden',
  cat_id           VARCHAR(64)        DEFAULT ''
  COMMENT '栏目:select:[]',
  title            VARCHAR(255)       DEFAULT ''
  COMMENT '办事指南标题',
  image            VARCHAR(255)       DEFAULT ''
  COMMENT '封面:image',
  action_condition VARCHAR(255)       DEFAULT ''
  COMMENT '办事条件:textarea',
  action_material  VARCHAR(255)       DEFAULT ''
  COMMENT '办事材料:textarea',
  action_address   VARCHAR(255)       DEFAULT ''
  COMMENT '办事地址:textarea',
  action_flow      VARCHAR(255)       DEFAULT ''
  COMMENT '流程:textarea',
  action_begin     TIMESTAMP NULL
  COMMENT '开始时间:datetime',
  action_end       TIMESTAMP NULL
  COMMENT '结束时间:datetime',
  action_fee       VARCHAR(255)       DEFAULT ''
  COMMENT '办事费用:textarea',
  action_yiju      VARCHAR(255)       DEFAULT ''
  COMMENT '办事依据:textarea',
  action_note      VARCHAR(255)       DEFAULT ''
  COMMENT '办事备注:textarea',
  file             VARCHAR(255)       DEFAULT ''
  COMMENT '附件:file',
  publish_user     VARCHAR(32)        DEFAULT ''
  COMMENT '发布者',
  publish_time     TIMESTAMP NULL
  COMMENT '发布时间:datetime',
  read_count       INT(11)            DEFAULT 0
  COMMENT '阅读数:skip',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '办事指南预约';


DROP TABLE IF EXISTS d_wuye_fee;
CREATE TABLE d_wuye_fee (
  id           INT(11)   NOT NULL AUTO_INCREMENT
  COMMENT 'ID:hidden',
  account_date VARCHAR(16)        DEFAULT ''
  COMMENT '账期',
  account      VARCHAR(64)        DEFAULT ''
  COMMENT '账号',
  room_number  VARCHAR(255)       DEFAULT ''
  COMMENT '缴费房间',
  status       VARCHAR(16)        DEFAULT '未缴费'
  COMMENT '缴费状态:select:[未缴费,已缴费]',
  pay_time     TIMESTAMP NULL
  COMMENT '缴费时间:datetime',
  pay_user     VARCHAR(32)        DEFAULT ''
  COMMENT '缴费人',
  action_user  VARCHAR(32)        DEFAULT ''
  COMMENT '收费人',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '物业费管理';

INSERT INTO `d_function` VALUES ('26', '7', '物业费管理', '1', '1', NULL, '/api/core/wuyeFee/list', '4', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '26');

