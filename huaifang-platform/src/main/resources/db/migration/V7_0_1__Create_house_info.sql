CREATE TABLE d_house_info (
  id                     INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '房屋id:hidden',
  house_node_id          INT(11) NOT NULL DEFAULT 0
  COMMENT '架构id:tree',
  xq                     VARCHAR(32)      DEFAULT ''
  COMMENT '小区:hidden',
  lh                     VARCHAR(32)      DEFAULT ''
  COMMENT '楼号:hidden',
  dy                     VARCHAR(32)      DEFAULT ''
  COMMENT '单元:hidden',
  lc                     VARCHAR(32)      DEFAULT ''
  COMMENT '楼层:hidden',
  room_number            VARCHAR(32)      DEFAULT ''
  COMMENT '房间',
  address                VARCHAR(255)     DEFAULT ''
  COMMENT '房屋地址',
  house_no               VARCHAR(32)      DEFAULT ''
  COMMENT '房屋编号:hidden',
  fczh                   VARCHAR(255)     DEFAULT ''
  COMMENT '房产证号',
  house_type             VARCHAR(16)      DEFAULT ''
  COMMENT '房屋类型:select:[廉租房,存量房,回迁房,公共租赁房,商品房,别墅,经济适用住房,公寓]',
  qzf_type               VARCHAR(16)      DEFAULT ''
  COMMENT '群租房类型:select:[整租,单租]',
  jzxz                   VARCHAR(16)      DEFAULT ''
  COMMENT '建筑性质:select:[民用建筑,工业建筑,农业建筑]',
  jz_type                VARCHAR(16)      DEFAULT ''
  COMMENT '建筑类型:select:[住宅建筑,公共建筑]',
  police_station         VARCHAR(255)     DEFAULT ''
  COMMENT '所属派出所',
  police                 VARCHAR(16)      DEFAULT ''
  COMMENT '社区民警',
  owner_type             VARCHAR(16)      DEFAULT ''
  COMMENT '所有权类型:select:[个人,单位,违法建设]',
  house_has_danger       VARCHAR(4)       DEFAULT '无'
  COMMENT '有无安全隐患',
  owner_name             VARCHAR(16)      DEFAULT ''
  COMMENT '房主名称',
  owner_gender           VARCHAR(4)       DEFAULT ''
  COMMENT '房主性别:radioGroup:[男,女]',
  owner_zhenjian_type    VARCHAR(16)      DEFAULT '身份证'
  COMMENT '房主证件类型:select:[身份证,护照,港澳通行证]',
  owner_zhengjian_no     VARCHAR(255)     DEFAULT ''
  COMMENT '房主证件号码',
  owner_huji_type        VARCHAR(32)      DEFAULT ''
  COMMENT '房主户籍地',
  owner_huji_address     VARCHAR(255)     DEFAULT ''
  COMMENT '房主户籍地址',
  owner_live_address     VARCHAR(255)     DEFAULT ''
  COMMENT '房主现住地址',
  owner_phone            VARCHAR(255)     DEFAULT ''
  COMMENT '房主联系电话',
  owner_country          VARCHAR(64)      DEFAULT ''
  COMMENT '房主国籍',
  company_name           VARCHAR(255)     DEFAULT ''
  COMMENT '单位名称',
  company_address        VARCHAR(255)     DEFAULT ''
  COMMENT '单位所在地址',
  company_manager_name   VARCHAR(16)      DEFAULT ''
  COMMENT '单位负责人名称',
  company_manager_phone  VARCHAR(16)      DEFAULT ''
  COMMENT '单位负责人联系电话',
  zhongjie_name          VARCHAR(255)     DEFAULT ''
  COMMENT '中介名称',
  zhongjie_manager_name  VARCHAR(16)      DEFAULT ''
  COMMENT '中介负责人名称',
  zhongjie_manager_phone VARCHAR(16)      DEFAULT ''
  COMMENT '中介负责人联系电话',
  zhongjie_manager_id_no VARCHAR(32)      DEFAULT ''
  COMMENT '中介负责人证件号码',
  zhuanzu_name           VARCHAR(64)      DEFAULT ''
  COMMENT '转租人名称',
  zhuanzu_live_address   VARCHAR(255)     DEFAULT ''
  COMMENT '转租人现住地址',
  zhuanzu_phone          VARCHAR(16)      DEFAULT ''
  COMMENT '转租人联系电话',
  zhuanzu_id_type        VARCHAR(32)      DEFAULT ''
  COMMENT '转租人证件类型:select:[身份证,护照,港澳通行证]',
  zhuanzu_id_no          VARCHAR(32)      DEFAULT ''
  COMMENT '转租人证件号码',
  rent_type              VARCHAR(32)      DEFAULT ''
  COMMENT '出租人类型',
  rent_number            INT(11)          DEFAULT 0
  COMMENT '出租间数',
  rent_area              DECIMAL(10, 2)   DEFAULT 0
  COMMENT '出租面积(m2)',
  rent_useage            VARCHAR(64)      DEFAULT ''
  COMMENT '出租用途',
  rent_live_number       INT(11)          DEFAULT 0
  COMMENT '现住人数',
  rent_pay_type          VARCHAR(16)      DEFAULT ''
  COMMENT '租金支付方式:radioGroup:[月租,年租]',
  rent_money             DECIMAL(10, 2)   DEFAULT 0
  COMMENT '租金（元）',
  dengjibeian            VARCHAR(16)      DEFAULT ''
  COMMENT '登记备案:radioGroup:[已办,未办]',
  nashui                 VARCHAR(16)      DEFAULT ''
  COMMENT '登记备案:radioGroup:[已缴,未缴]',
  zerenbook              VARCHAR(64)      DEFAULT ''
  COMMENT '责任书:checkbox:[治安,消防,婚育]',
  hetong                 VARCHAR(8)       DEFAULT ''
  COMMENT '租赁合同:radioGroup:[有,无]',
  rent_begin             DATE    NULL     DEFAULT NULL
  COMMENT '出租起始日期',
  rent_end               DATE    NULL     DEFAULT NULL
  COMMENT '出租截止日期',
  danger_detail          VARCHAR(1024)    DEFAULT ''
  COMMENT '安全隐患描述',
  PRIMARY KEY (id)
)
  DEFAULT CHARSET = utf8
  COMMENT '房屋信息';

INSERT INTO `d_function` VALUES ('12', '10', '房屋信息管理', '1', '1', NULL, '/api/core/houseInfo/list', '2', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '12');
