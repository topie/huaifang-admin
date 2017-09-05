DROP TABLE IF EXISTS d_asset_info;
CREATE TABLE d_asset_info (
  id                 INT(11)      NOT NULL      AUTO_INCREMENT
  COMMENT 'ID:hidden',
  asset_no           VARCHAR(255)               DEFAULT ''
  COMMENT '资产编号',
  asset_type         VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '资产类型:select:[打印机,个人电脑,其他]',
  asset_name         VARCHAR(255)               DEFAULT ''
  COMMENT '资产名称',
  guigexinghao       VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '规格型号',
  brand              VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '品牌',
  yuanzhi            VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '原值',
  canzhi             VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '残值',
  jiazhi             VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '价值',
  get_way            VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '取得方式:select:[自购,政府采购]',
  get_date           DATE         NULL          DEFAULT NULL
  COMMENT '获得日期:date',
  use_situation      VARCHAR(16)  NOT NULL      DEFAULT ''
  COMMENT '使用状况:select:[在用,不在用]',
  caiwuruzhang_date  DATE         NULL          DEFAULT NULL
  COMMENT '财务入账日期:date',
  use_type           VARCHAR(16)  NOT NULL      DEFAULT ''
  COMMENT '使用方式:select:[自用,公用]',
  use_person         VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '使用人',
  use_department     VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '使用部门',
  manager_department VARCHAR(64)  NOT NULL      DEFAULT ''
  COMMENT '管理部门',
  memo               VARCHAR(255) NOT NULL      DEFAULT ''
  COMMENT '备注:textarea',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '资产信息';

INSERT INTO `d_function` VALUES ('15', '7', '资产信息管理', '1', '1', NULL, '/api/core/assetInfo/list', '4', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '15');



