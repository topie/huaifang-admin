DROP TABLE IF EXISTS d_person_info;
CREATE TABLE d_person_info (
  p_id              INT(11)     NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  p_person_type     VARCHAR(8)                DEFAULT ''
  COMMENT '人口身份:select:[租户,住户]',
  p_house_node_id   INT(11)                   DEFAULT 0
  COMMENT '绑定架构id:hidden',
  p_house_info      VARCHAR(255)              DEFAULT ''
  COMMENT '绑定房屋信息:hidden',
  p_name            VARCHAR(64) NOT NULL      DEFAULT ''
  COMMENT '姓名',
  p_birth           DATE        NULL          DEFAULT NULL
  COMMENT '出生年月:date',
  p_identify_number VARCHAR(32) NOT NULL      DEFAULT ''
  COMMENT '身份证号',
  p_import_time     TIMESTAMP   NOT NULL      DEFAULT CURRENT_TIMESTAMP
  COMMENT '入库时间:datetime',
  PRIMARY KEY (p_id)
)
  DEFAULT CHARSET = utf8
  COMMENT '人口信息';

INSERT INTO `d_function` VALUES ('13', '10', '人口信息管理', '1', '1', NULL, '/api/core/personInfo/list', '3', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '13');

DROP TABLE IF EXISTS d_person_info_rent;
CREATE TABLE d_person_info_rent (
  r_id                          INT(11)       NOT NULL  AUTO_INCREMENT
  COMMENT 'ID:hidden',
  r_person_id                   INT(11)       NOT NULL  DEFAULT 0
  COMMENT '人口ID:hidden',
  r_name                        VARCHAR(64)   NOT NULL  DEFAULT ''
  COMMENT '姓名',
  r_gender                      VARCHAR(8)    NOT NULL  DEFAULT ''
  COMMENT '性别:radioGroup:[男,女]',
  r_birth                       DATE          NULL      DEFAULT NULL
  COMMENT '出生年月:date',
  r_identify_number             VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '身份证号',
  r_nation                      VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '民族',
  r_political_status            VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '政治面貌',
  r_census_type                 VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '户籍类别',
  r_census_address              VARCHAR(255)  NOT NULL  DEFAULT ''
  COMMENT '户籍地址',
  r_born_place                  VARCHAR(16)   NOT NULL  DEFAULT ''
  COMMENT '出生地',
  r_residence_place             VARCHAR(1024) NOT NULL  DEFAULT ''
  COMMENT '居住地',
  r_marriage_status             VARCHAR(8)    NOT NULL  DEFAULT ''
  COMMENT '婚姻状况',
  r_contact                     VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '联系电话',
  r_is_family_in                VARCHAR(4)    NOT NULL  DEFAULT '否'
  COMMENT '是否家庭流入:radioGroup:[是,否]',
  r_family_in_num               SMALLINT      NOT NULL  DEFAULT 0
  COMMENT '流入人数',
  r_family_in_lt_sixteen_male   SMALLINT      NOT NULL  DEFAULT 0
  COMMENT '16岁以下男性人数',
  r_family_in_lt_sixteen_female SMALLINT      NOT NULL  DEFAULT 0
  COMMENT '16岁以下女性人数',
  r_is_owner                    VARCHAR(4)    NOT NULL  DEFAULT '否'
  COMMENT '是否户主:radioGroup:[是,否]',
  r_owner_name                  VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '户主名称',
  r_owner_relate                VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '与户主关系',
  r_leave_hometown_date         DATE          NULL      DEFAULT NULL
  COMMENT '离开原籍日期:date',
  r_enter_beijing_date          DATE          NULL      DEFAULT NULL
  COMMENT '来京日期:date',
  r_enter_residence_date        DATE          NULL      DEFAULT NULL
  COMMENT '来居住地日期:date',
  r_enter_beijing_resion        VARCHAR(255)  NOT NULL  DEFAULT ''
  COMMENT '来京原因',
  r_residence_type              VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '居住类型',
  r_police_station              VARCHAR(128)  NOT NULL  DEFAULT ''
  COMMENT '所属派出所',
  r_police                      VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '民警',
  r_household_name              VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '房东名称',
  r_household_phone             VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '房东电话',
  r_situation                   VARCHAR(64)   NOT NULL  DEFAULT ''
  COMMENT '目前状况',
  r_firm_or_school              VARCHAR(128)  NOT NULL  DEFAULT ''
  COMMENT '就业单位/学校',
  r_firm_address                VARCHAR(255)  NOT NULL  DEFAULT ''
  COMMENT '单位地址',
  r_firm_industry               VARCHAR(64)   NOT NULL  DEFAULT ''
  COMMENT '单位所属行业:select:',
  r_main_job                    VARCHAR(128)  NOT NULL  DEFAULT ''
  COMMENT '主要从事工作',
  r_profession                  VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '职业',
  r_social_security             VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '社保:radioGroup:[无,工伤,医疗,失业,养老,生育]',
  r_has_contract                VARCHAR(8)    NOT NULL  DEFAULT ''
  COMMENT '是否签订劳动合同:radioGroup:[无,有]',
  PRIMARY KEY (r_id)
)
  DEFAULT CHARSET = utf8
  COMMENT '人口信息-租户';


DROP TABLE IF EXISTS d_person_info_live;
CREATE TABLE d_person_info_live (
  l_id                 INT(11)       NOT NULL  AUTO_INCREMENT
  COMMENT 'ID:hidden',
  l_person_id          INT(11)       NOT NULL  DEFAULT 0
  COMMENT '人口ID:hidden',
  l_name               VARCHAR(64)   NOT NULL  DEFAULT ''
  COMMENT '姓名',
  l_gender             VARCHAR(8)    NOT NULL  DEFAULT ''
  COMMENT '性别:radioGroup:[男,女]',
  l_birth              DATE          NULL      DEFAULT NULL
  COMMENT '出生年月:date',
  l_identify_number    VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '身份证号',
  l_nation             VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '民族',
  l_political_status   VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '政治面貌',
  l_census_type        VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '户籍类别',
  l_census_address     VARCHAR(255)  NOT NULL  DEFAULT ''
  COMMENT '户籍地址',
  l_born_place         VARCHAR(16)   NOT NULL  DEFAULT ''
  COMMENT '出生地',
  l_residence_place    VARCHAR(1024) NOT NULL  DEFAULT ''
  COMMENT '居住地',
  l_marriage_status    VARCHAR(8)    NOT NULL  DEFAULT ''
  COMMENT '婚姻状况',
  l_contact            VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '联系电话',
  l_is_owner           VARCHAR(4)    NOT NULL  DEFAULT '否'
  COMMENT '是否户主:radioGroup:[是,否]',
  l_owner_relate       VARCHAR(32)   NOT NULL  DEFAULT ''
  COMMENT '与户主关系',
  l_company_huaifang   VARCHAR(128)  NOT NULL  DEFAULT ''
  COMMENT '槐房工作单位',
  l_company_other      VARCHAR(128)  NOT NULL  DEFAULT ''
  COMMENT '其它工作单位',
  l_job_position       VARCHAR(255)  NOT NULL  DEFAULT ''
  COMMENT '职位',
  l_is_huaifang_pepole VARCHAR(4)              DEFAULT ''
  COMMENT '是否槐房村民:radioGroup:[是,否]',
  l_rksx               VARCHAR(16)             DEFAULT ''
  COMMENT '人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]',
  l_is_canji           VARCHAR(16)             DEFAULT ''
  COMMENT '是否残疾人员:select:[正常,是]',
  l_is_dead            VARCHAR(4)              DEFAULT ''
  COMMENT '是否死亡人员:select:[否,是]',
  l_dead_date          DATE          NULL
  COMMENT '死亡日期:date',
  l_memo               VARCHAR(1024)           DEFAULT ''
  COMMENT '备注:textarea',
  PRIMARY KEY (l_id)
)
  DEFAULT CHARSET = utf8
  COMMENT '人口信息-住户';


