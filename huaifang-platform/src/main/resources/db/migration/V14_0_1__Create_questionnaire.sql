DROP TABLE IF EXISTS d_questionnaire_info;
CREATE TABLE d_questionnaire_info (
  id       INT(11)   NOT NULL AUTO_INCREMENT
  COMMENT 'ID:hidden',
  name     VARCHAR(64)        DEFAULT ''
  COMMENT '问卷调查名称',
  detail   VARCHAR(128)       DEFAULT ''
  COMMENT '问卷调查详细',
  begin    TIMESTAMP NULL
  COMMENT '开始时间:datetime',
  end      TIMESTAMP NULL
  COMMENT '结束时间:datetime',
  add_user VARCHAR(32)        DEFAULT ''
  COMMENT '添加用户',
  add_time TIMESTAMP          DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '添加时间:datetime',
  status   VARCHAR(16)        DEFAULT '未发布'
  COMMENT '状态:select:[未发布,已发布,已回收]',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '问卷调查基本信息';

DROP TABLE IF EXISTS d_questionnaire_item;
CREATE TABLE d_questionnaire_item (
  id             INT(11) NOT NULL AUTO_INCREMENT
  COMMENT 'ID:hidden',
  info_id        INT(11)          DEFAULT 0
  COMMENT '问卷信息ID:hidden',
  question       VARCHAR(255)     DEFAULT ''
  COMMENT '问题题目',
  question_index INT(11)          DEFAULT 0
  COMMENT '序号',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '问卷调查题目信息';

DROP TABLE IF EXISTS d_questionnaire_option;
CREATE TABLE d_questionnaire_option (
  id           INT(11) NOT NULL AUTO_INCREMENT
  COMMENT 'ID:hidden',
  item_id      INT(11)          DEFAULT 0
  COMMENT '题目ID',
  option_index INT(11)          DEFAULT 1
  COMMENT '序号',
  text         VARCHAR(255)     DEFAULT ''
  COMMENT '选型内容',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '问卷调查选项信息';

DROP TABLE IF EXISTS d_questionnaire_result;
CREATE TABLE d_questionnaire_result (
  id        INT(11) NOT NULL AUTO_INCREMENT
  COMMENT 'ID:hidden',
  info_id   INT(11)          DEFAULT 0
  COMMENT '问卷ID',
  item_id   INT(11)          DEFAULT 0
  COMMENT '题目ID',
  option_id INT(11)          DEFAULT 0
  COMMENT '选项ID',
  user_id   VARCHAR(64)      DEFAULT ''
  COMMENT '用户唯一标示',
  PRIMARY KEY (id),
  UNIQUE KEY (info_id, item_id, option_id, user_id)
)
  DEFAULT CHARSET = utf8
  COMMENT '问卷调查统计信息';


INSERT INTO `d_function` VALUES ('27', '7', '问卷调查管理', '1', '1', NULL, '/api/core/questionnaireInfo/list', '9', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '27');



