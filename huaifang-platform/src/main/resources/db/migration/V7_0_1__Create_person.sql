DROP TABLE IF EXISTS d_person_info_base;
CREATE TABLE d_person_info_base (
  id               INT(11)       NOT NULL AUTO_INCREMENT
  COMMENT 'ID',
  name             VARCHAR(64)   NOT NULL DEFAULT ''
  COMMENT '姓名',
  gender           VARCHAR(8)    NOT NULL DEFAULT ''
  COMMENT '性别',
  birth            TIMESTAMP     NULL     DEFAULT NULL
  COMMENT '出生年月',
  identify_number  VARCHAR(32)   NOT NULL DEFAULT ''
  COMMENT '身份证号',
  nation           VARCHAR(32)   NOT NULL DEFAULT ''
  COMMENT '民族',
  political_status VARCHAR(32)   NOT NULL DEFAULT ''
  COMMENT '政治面貌',
  census_type      VARCHAR(32)   NOT NULL DEFAULT ''
  COMMENT '户籍类别',
  census_address   VARCHAR(255)  NOT NULL DEFAULT ''
  COMMENT '户籍地址',
  born_place       VARCHAR(16)   NOT NULL DEFAULT ''
  COMMENT '出生地',
  residence_place  VARCHAR(1024) NOT NULL DEFAULT ''
  COMMENT '居住地',
  marriage_status  VARCHAR(8)    NOT NULL DEFAULT ''
  COMMENT '婚姻状况',
  contact          VARCHAR(32)   NOT NULL DEFAULT ''
  COMMENT '联系电话',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '人口信息-基本';

DROP TABLE IF EXISTS d_person_info_family;
CREATE TABLE d_person_info_family (
  id                          INT(11)     NOT NULL  AUTO_INCREMENT
  COMMENT 'ID',
  is_family_in                VARCHAR(4)  NOT NULL  DEFAULT '否'
  COMMENT '家庭流入',
  family_in_num               SMALLINT    NOT NULL  DEFAULT 0
  COMMENT '人',
  family_in_lt_sixteen_male   SMALLINT    NOT NULL  DEFAULT 0
  COMMENT '男',
  family_in_lt_sixteen_female SMALLINT    NOT NULL  DEFAULT 0
  COMMENT '女',
  is_household                VARCHAR(4)  NOT NULL  DEFAULT '否'
  COMMENT '户主',
  household_name              VARCHAR(32) NOT NULL  DEFAULT ''
  COMMENT '户主名称',
  household_relate            VARCHAR(32) NOT NULL  DEFAULT ''
  COMMENT '与户主关系',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '人口信息-家庭';


DROP TABLE IF EXISTS d_person_info_residence;
CREATE TABLE d_person_info_residence (
  id                   INT(11)      NOT NULL  AUTO_INCREMENT
  COMMENT 'ID',
  leave_hometown_date  TIMESTAMP    NULL      DEFAULT NULL
  COMMENT '离开原籍日期',
  enter_beijing_date   TIMESTAMP    NULL      DEFAULT NULL
  COMMENT '来京日期',
  enter_residence_date TIMESTAMP    NULL      DEFAULT NULL
  COMMENT '来居住地日期',
  enter_beijing_resion VARCHAR(255) NOT NULL  DEFAULT ''
  COMMENT '来京原因',
  residence_type       VARCHAR(32)  NOT NULL  DEFAULT ''
  COMMENT '居住类型',
  police_station       VARCHAR(128) NOT NULL  DEFAULT ''
  COMMENT '所属派出所',
  police               VARCHAR(32)  NOT NULL  DEFAULT ''
  COMMENT '民警',
  household_name       VARCHAR(32)  NOT NULL  DEFAULT ''
  COMMENT '房东名称',
  household_phone      VARCHAR(32)  NOT NULL  DEFAULT ''
  COMMENT '房东电话',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '人口信息-居住';


DROP TABLE IF EXISTS d_person_info_work;
CREATE TABLE d_person_info_work (
  id              INT(11)      NOT NULL  AUTO_INCREMENT
  COMMENT 'ID',
  situation       VARCHAR(64)  NOT NULL  DEFAULT ''
  COMMENT '目前状况',
  firm_or_school  VARCHAR(128) NOT NULL  DEFAULT ''
  COMMENT '就业单位/学校',
  firm_address    VARCHAR(255) NOT NULL  DEFAULT ''
  COMMENT '单位地址',
  firm_industry   VARCHAR(64)  NOT NULL  DEFAULT '单位所属行业',
  main_job        VARCHAR(128) NOT NULL  DEFAULT ''
  COMMENT '主要从事工作',
  profession      VARCHAR(32)  NOT NULL  DEFAULT ''
  COMMENT '职业',
  social_security VARCHAR(32)  NOT NULL  DEFAULT '社保',
  contract        VARCHAR(8)   NOT NULL  DEFAULT '是否签订劳动合同',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '人口信息-就业';


