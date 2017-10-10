DROP TABLE IF EXISTS `d_house_node`;
CREATE TABLE `d_house_node` (
  `id`   INT(11)     NOT NULL AUTO_INCREMENT
  COMMENT '节点ID',
  `pid`  INT(11)     NOT NULL
  COMMENT '父节点ID',
  `name` VARCHAR(64) NOT NULL DEFAULT ''
  COMMENT '节点名称',
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET = utf8
  COMMENT '房屋架构';

INSERT INTO `d_function` VALUES ('10', '0', '社区管理', '1', '1', NULL, '#', '1', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '10');
INSERT INTO `d_function` VALUES ('11', '10', '房屋架构管理', '1', '1', NULL, '/api/core/houseNode/list', '6', NULL, NULL);
INSERT INTO `d_role_function` (role_id, function_id) VALUES ('1', '11');

INSERT INTO `d_house_node`
VALUES (1, 0, '槐房一区'), (2, 0, '槐房二区'), (3, 0, '虚拟小区'), (4, 1, '219号楼'), (5, 2, '119号楼'), (6, 4, '0单元'), (7, 5, '1单元'),
  (8, 6, '13层'), (9, 7, '9层');
