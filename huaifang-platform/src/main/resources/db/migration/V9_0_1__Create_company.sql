DROP TABLE IF EXISTS d_company_info;
CREATE TABLE d_company_info (
  id            INT(11)      NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  company_name  VARCHAR(255)               DEFAULT ''
  COMMENT '企业名称',
  company_code  VARCHAR(255)               DEFAULT ''
  COMMENT '统一社会信用代码',
  yingyezhizhao VARCHAR(255)               DEFAULT ''
  COMMENT '营业执照:image',
  company_type  VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '企业类型:select:[有限责任公司]',
  farendaibiao  VARCHAR(255)               DEFAULT ''
  COMMENT '法人代表',
  zhucezijin    VARCHAR(32)  NOT NULL      DEFAULT ''
  COMMENT '注册资金',
  reg_date      DATE         NULL          DEFAULT NULL
  COMMENT '注册时间:date',
  address       VARCHAR(255) NOT NULL      DEFAULT ''
  COMMENT '注册地址:textarea',
  gudong        VARCHAR(255) NOT NULL      DEFAULT ''
  COMMENT '股东:textarea',
  gudong_count  INT(11)                    DEFAULT 0
  COMMENT '股东人数:skip',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '企业信息';

INSERT INTO `d_function` VALUES ('14', '10', '企业信息管理', '1', '1', NULL, '/api/core/companyInfo/list', '4', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '14');



