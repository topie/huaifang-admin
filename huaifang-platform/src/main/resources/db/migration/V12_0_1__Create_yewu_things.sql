DROP TABLE IF EXISTS d_advice_box;
CREATE TABLE d_advice_box (
  id              INT(11)   NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  contact_person  VARCHAR(32)             DEFAULT ''
  COMMENT '联系人',
  contact_phone   VARCHAR(32)             DEFAULT ''
  COMMENT '联系电话',
  contact_email   VARCHAR(64)             DEFAULT ''
  COMMENT '联系邮箱',
  contact_user_id INT(11)                 DEFAULT 0
  COMMENT '联系人ID',
  message_content VARCHAR(1024)           DEFAULT ''
  COMMENT '留言内容:textare',
  message_time    TIMESTAMP NULL
  COMMENT '留言时间:datetime',
  handle_person   VARCHAR(32)             DEFAULT ''
  COMMENT '处理人',
  handle_type     VARCHAR(16)             DEFAULT ''
  COMMENT '处理方式:select:[电话回访,直接回复,其它]',
  handle_desc     VARCHAR(1024)           DEFAULT ''
  COMMENT '处理描述:textare',
  handle_time     TIMESTAMP NULL
  COMMENT '处理时间:datetime',
  status          VARCHAR(16)             DEFAULT ''
  COMMENT '状态:select:[未处理,已处理]',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '意见箱';

INSERT INTO `d_function` VALUES ('20', '7', '意见箱', '1', '1', NULL, '/api/core/adviceBox/list', '10', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '20');


DROP TABLE IF EXISTS d_dispute_resolution;
CREATE TABLE d_dispute_resolution (
  id             INT(11)   NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  title          VARCHAR(255)            DEFAULT ''
  COMMENT '调解事项',
  contact_person VARCHAR(32)             DEFAULT ''
  COMMENT '调解联系人',
  contact_phone  VARCHAR(32)             DEFAULT ''
  COMMENT '调解联系人电话',
  address        VARCHAR(255)            DEFAULT ''
  COMMENT '调解地址',
  update_time    TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间:datetime',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '调解纠纷';

INSERT INTO `d_function`
VALUES ('21', '7', '纠纷调解管理', '1', '1', NULL, '/api/core/disputeResolution/list', '8', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '21');


DROP TABLE IF EXISTS d_cunwu_info;
CREATE TABLE d_cunwu_info (
  id          INT(11)   NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  title       VARCHAR(255)            DEFAULT ''
  COMMENT '栏目名称',
  content     LONGTEXT                DEFAULT NULL
  COMMENT '内容:kindEditor',
  update_time TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间:datetime',
  status      VARCHAR(16)             DEFAULT ''
  COMMENT '状态:skip',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '居务公开';

INSERT INTO `d_function` VALUES ('22', '7', '居务公开管理', '1', '1', NULL, '/api/core/cunwuInfo/list', '7', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '22');

DROP TABLE IF EXISTS d_repair_report;
CREATE TABLE d_repair_report (
  id              INT(11)   NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  contact_person  VARCHAR(32)             DEFAULT ''
  COMMENT '联系人',
  contact_phone   VARCHAR(32)             DEFAULT ''
  COMMENT '联系人电话',
  contact_user_id INT(11)                 DEFAULT 0
  COMMENT '联系人ID',
  room_number     VARCHAR(255)            DEFAULT ''
  COMMENT '房间号',
  report_time     TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '报修时间:datetime',
  report_title    VARCHAR(255)            DEFAULT ''
  COMMENT '报修事项:textarea',
  report_content  VARCHAR(1024)           DEFAULT ''
  COMMENT '报修内容:textarea',
  images          VARCHAR(2048)           DEFAULT ''
  COMMENT '图片:files',
  status          VARCHAR(16)             DEFAULT ''
  COMMENT '处理状态:select:[未反馈,待维修,已完成]',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '物业维修管理';

DROP TABLE IF EXISTS d_repair_report_process;
CREATE TABLE d_repair_report_process (
  id              INT(11)   NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  report_id       INT(11)   NOT NULL
  COMMENT '报修ID:hidden',
  contact_person  VARCHAR(32)             DEFAULT ''
  COMMENT '联系人',
  contact_phone   VARCHAR(32)             DEFAULT ''
  COMMENT '联系人电话',
  contact_user_id INT(11)                 DEFAULT 0
  COMMENT '联系人ID',
  process_time    TIMESTAMP NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '进度时间:datetime',
  process_content VARCHAR(1024)           DEFAULT ''
  COMMENT '进度内容:textarea',
  process_status  VARCHAR(64)             DEFAULT ''
  COMMENT '进度情况简介',
  status          VARCHAR(16)             DEFAULT ''
  COMMENT '状态:select:[维修中,已完成]',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '物业维修进度';

INSERT INTO `d_function` VALUES ('23', '7', '物业维修管理', '1', '1', NULL, '/api/core/repairReport/list', '3', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '23');

DROP TABLE IF EXISTS d_library_book;
CREATE TABLE d_library_book (
  id        INT(11) NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  book_name VARCHAR(64)           DEFAULT ''
  COMMENT '书名',
  author    VARCHAR(32)           DEFAULT ''
  COMMENT '作者',
  category  VARCHAR(32)           DEFAULT ''
  COMMENT '分类',
  image     VARCHAR(255)          DEFAULT ''
  COMMENT '封面:image',
  content   LONGTEXT              DEFAULT NULL
  COMMENT '简介:textarea',
  status    VARCHAR(16)           DEFAULT ''
  COMMENT '状态:select:[已借出,未借出]',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '图书馆';

INSERT INTO `d_function` VALUES ('24', '7', '图书馆管理', '1', '1', NULL, '/api/core/libraryBook/list', '6', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '24');




