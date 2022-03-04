INSERT INTO marcas(marca) VALUES('Volkswagen');
INSERT INTO marcas(marca) VALUES('Mercedes');
INSERT INTO marcas(marca) VALUES('Seat');
INSERT INTO marcas(marca) VALUES('Audi');

INSERT INTO modelos(modelo) VALUES('Deportivo');
INSERT INTO modelos(modelo) VALUES('Familiar');
INSERT INTO modelos(modelo) VALUES('Furgoneta');
INSERT INTO modelos(modelo) VALUES('Biplaza');

INSERT INTO coches(marca_id, modelo_id, color, matricula, cilindrada, velocidad) VALUES(1, 1, 'Gris', '6789ABC', 2000, 260);
INSERT INTO coches(marca_id, modelo_id, color, matricula, cilindrada, velocidad) VALUES(2, 1, 'Negro', '5349KJG', 2500, 260);
INSERT INTO coches(marca_id, modelo_id, color, matricula, cilindrada, velocidad) VALUES(3, 2, 'Amarillo', '3458GFC', 1500, 220);
INSERT INTO coches(marca_id, modelo_id, color, matricula, cilindrada, velocidad) VALUES(1, 4, 'Rojo', '4398KJI', 3000, 300);

INSERT INTO usuarios(username, password, enabled) VALUES('psariego', '$2a$10$bcX/BZ9pF55R0YYzp4Mr8OlMTQiVWHnrCS.B7bCEE8WqtIRiEk2eq', 1);
INSERT INTO usuarios(username, password, enabled) VALUES('admin', '$2a$10$xtAK4b1Iuu/1y0Fh5O7/huVql.sUR4Q1elRIK9aAaKfF0As6hkqUG', 1);

INSERT INTO roles(nombre) VALUES('ROLE_USER');
INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');

INSERT INTO usuarios_roles(usuario_id, role_id) VALUES(1,1);
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES(2,2);
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES(2,1);