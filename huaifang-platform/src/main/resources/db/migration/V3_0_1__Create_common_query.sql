DROP TABLE IF EXISTS `d_common_query`;
CREATE TABLE `d_common_query` (
  `id`             INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT 'sqlId',
  `query_name`     VARCHAR(128) NULL     DEFAULT '查询名称',
  `table_alias`    VARCHAR(128) NOT NULL DEFAULT ''
  COMMENT '表别名',
  `select_query`   VARCHAR(255) NOT NULL DEFAULT ''
  COMMENT '选择',
  `export_query`   VARCHAR(255) NOT NULL DEFAULT ''
  COMMENT '导出',
  `where_query`    VARCHAR(255)          DEFAULT ''
  COMMENT '参数',
  `order_query`    VARCHAR(128)          DEFAULT ''
  COMMENT '排序',
  `script_content` TEXT         NULL
  COMMENT 'javascript脚本',
  `html_content`   TEXT         NULL
  COMMENT 'html脚本',
  PRIMARY KEY (`id`),
  UNIQUE KEY (table_alias)
)
  DEFAULT CHARSET = utf8
  COMMENT '通用执行sql';


ALTER TABLE d_common_query
  ADD COLUMN `group_query` VARCHAR(64) NULL  DEFAULT ''
COMMENT 'group语句'
  AFTER where_query;
