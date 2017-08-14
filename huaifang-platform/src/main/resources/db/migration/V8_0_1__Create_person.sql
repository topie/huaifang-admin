DROP TABLE IF EXISTS d_person_info;
CREATE TABLE d_person_info (
  id              INT(11)     NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  person_id       VARCHAR(32) NOT NULL      DEFAULT ''
  COMMENT '人口ID:skip',
  person_type     VARCHAR(8)                DEFAULT ''
  COMMENT '人口身份:select:[租户,住户]',
  house_node_id   INT(11)                   DEFAULT 0
  COMMENT '绑定架构id:hidden',
  house_info      VARCHAR(255)              DEFAULT ''
  COMMENT '绑定房屋信息:skip',
  name            VARCHAR(64) NOT NULL      DEFAULT ''
  COMMENT '姓名',
  birth           DATE        NULL          DEFAULT NULL
  COMMENT '出生年月:date',
  identify_number VARCHAR(32) NOT NULL      DEFAULT ''
  COMMENT '身份证号',
  import_time     TIMESTAMP   NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '入库时间:datetime',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '人口信息';

INSERT INTO `d_function` VALUES ('12', '7', '人口信息管理', '1', '1', NULL, '/api/core/personInfo/list', '8', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '12');

DROP TABLE IF EXISTS d_person_info_rent;
CREATE TABLE d_person_info_rent (
  id                          INT(11)       NOT NULL  AUTO_INCREMENT
  COMMENT 'ID:hidden',
  person_id                   VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '人口ID:hidden',
  name                        VARCHAR(64)   NOT NULL  DEFAULT ''
  COMMENT '姓名',
  gender                      VARCHAR(8)    NOT NULL  DEFAULT ''
  COMMENT '性别:radioGroup:[男,女]',
  birth                       DATE          NULL      DEFAULT NULL
  COMMENT '出生年月:date',
  identify_number             VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '身份证号',
  nation                      VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '民族',
  political_status            VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '政治面貌',
  census_type                 VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '户籍类别',
  census_address              VARCHAR(255)  NOT NULL  DEFAULT ''
  COMMENT '户籍地址',
  born_place                  VARCHAR(16)   NOT NULL  DEFAULT ''
  COMMENT '出生地',
  residence_place             VARCHAR(1024) NOT NULL  DEFAULT ''
  COMMENT '居住地',
  marriage_status             VARCHAR(8)    NOT NULL  DEFAULT ''
  COMMENT '婚姻状况',
  contact                     VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '联系电话',
  is_family_in                VARCHAR(4)    NOT NULL  DEFAULT '否'
  COMMENT '是否家庭流入:radioGroup:[是,否]',
  family_in_num               SMALLINT      NOT NULL  DEFAULT 0
  COMMENT '流入人数',
  family_in_lt_sixteen_male   SMALLINT      NOT NULL  DEFAULT 0
  COMMENT '16岁以下男性人数',
  family_in_lt_sixteen_female SMALLINT      NOT NULL  DEFAULT 0
  COMMENT '16岁以下女性人数',
  is_owner                    VARCHAR(4)    NOT NULL  DEFAULT '否'
  COMMENT '是否户主:radioGroup:[是,否]',
  owner_name                  VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '户主名称',
  owner_relate                VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '与户主关系',
  leave_hometown_date         DATE          NULL      DEFAULT NULL
  COMMENT '离开原籍日期:date',
  enter_beijing_date          DATE          NULL      DEFAULT NULL
  COMMENT '来京日期:date',
  enter_residence_date        DATE          NULL      DEFAULT NULL
  COMMENT '来居住地日期:date',
  enter_beijing_resion        VARCHAR(255)  NOT NULL  DEFAULT ''
  COMMENT '来京原因',
  residence_type              VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '居住类型',
  police_station              VARCHAR(128)  NOT NULL  DEFAULT ''
  COMMENT '所属派出所',
  police                      VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '民警',
  household_name              VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '房东名称',
  household_phone             VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '房东电话',
  situation                   VARCHAR(64)   NOT NULL  DEFAULT ''
  COMMENT '目前状况',
  firm_or_school              VARCHAR(128)  NOT NULL  DEFAULT ''
  COMMENT '就业单位/学校',
  firm_address                VARCHAR(255)  NOT NULL  DEFAULT ''
  COMMENT '单位地址',
  firm_industry               VARCHAR(64)   NOT NULL  DEFAULT '单位所属行业',
  main_job                    VARCHAR(128)  NOT NULL  DEFAULT ''
  COMMENT '主要从事工作',
  profession                  VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '职业',
  social_security             VARCHAR(32)   NOT NULL  DEFAULT '社保',
  has_contract                VARCHAR(8)    NOT NULL  DEFAULT '是否签订劳动合同',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '人口信息-租户';


DROP TABLE IF EXISTS d_person_info_live;
CREATE TABLE d_person_info_live (
  id                 INT(11)       NOT NULL  AUTO_INCREMENT
  COMMENT 'ID:hidden',
  person_id          VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '人口ID:hidden',
  name               VARCHAR(64)   NOT NULL  DEFAULT ''
  COMMENT '姓名',
  gender             VARCHAR(8)    NOT NULL  DEFAULT ''
  COMMENT '性别:radioGroup:[男,女]',
  birth              DATE          NULL      DEFAULT NULL
  COMMENT '出生年月:date',
  identify_number    VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '身份证号',
  nation             VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '民族',
  political_status   VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '政治面貌',
  census_type        VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '户籍类别',
  census_address     VARCHAR(255)  NOT NULL  DEFAULT ''
  COMMENT '户籍地址',
  born_place         VARCHAR(16)   NOT NULL  DEFAULT ''
  COMMENT '出生地',
  residence_place    VARCHAR(1024) NOT NULL  DEFAULT ''
  COMMENT '居住地',
  marriage_status    VARCHAR(8)    NOT NULL  DEFAULT ''
  COMMENT '婚姻状况',
  contact            VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '联系电话',
  is_owner           VARCHAR(4)    NOT NULL  DEFAULT '否'
  COMMENT '是否户主:radioGroup:[是,否]',
  owner_relate       VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '与户主关系',
  company_huaifang   VARCHAR(128)  NOT NULL  DEFAULT ''
  COMMENT '槐房工作单位',
  company_other      VARCHAR(128)  NOT NULL  DEFAULT ''
  COMMENT '其它工作单位',
  job_position       VARCHAR(255)  NOT NULL  DEFAULT ''
  COMMENT '职位',
  is_huaifang_pepole VARCHAR(4)              DEFAULT ''
  COMMENT '是否槐房村民:radioGroup:[是,否]',
  rksx               VARCHAR(16)             DEFAULT ''
  COMMENT '人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]',
  is_canji           VARCHAR(16)             DEFAULT ''
  COMMENT '是否残疾人员:select:[正常,是]',
  is_dead            VARCHAR(4)              DEFAULT ''
  COMMENT '是否死亡人员:select:[否,是]',
  dead_date          DATE          NULL
  COMMENT '死亡日期:date',
  memo               VARCHAR(1024)           DEFAULT ''
  COMMENT '备注:textarea',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '人口信息-租户';


