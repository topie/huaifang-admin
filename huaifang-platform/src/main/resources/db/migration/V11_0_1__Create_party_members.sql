INSERT INTO `d_function` VALUES ('16', '0', '党员管理', '1', '1', NULL, '#', '1', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '16');

DROP TABLE IF EXISTS `d_party_members_node`;
CREATE TABLE `d_party_members_node` (
  `id`   INT(11)     NOT NULL AUTO_INCREMENT
  COMMENT '节点ID',
  `pid`  INT(11)     NOT NULL
  COMMENT '父节点ID',
  `name` VARCHAR(64) NOT NULL DEFAULT ''
  COMMENT '节点名称',
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET = utf8
  COMMENT '党员树节点';



