# sintad-v1

ejecutar el siguiente script en la base de datos 


DROP TABLE IF EXISTS `tb_rol`;
CREATE TABLE `tb_rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rolname` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

INSERT INTO `tb_rol` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `tb_rol` VALUES ('2', 'ROLE_USER');

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=UTF8MB4;

DROP TABLE IF EXISTS `usuario_rol`;
CREATE TABLE `usuario_rol` (
  `user_id` int NOT NULL,
  `rol_id` int NOT NULL,
  PRIMARY KEY (`user_id`, `rol_id`),
  FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`),
  FOREIGN KEY (`rol_id`) REFERENCES `tb_rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

crear usuario admin por postman
