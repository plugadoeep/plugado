INSERT INTO usuario (login, senha, ativo) VALUES ('admin', 'admin', 1);
INSERT INTO usuario (login, senha, ativo) VALUES ('arabasso', '123', 1);
INSERT INTO funcao (nome, usuario_id) VALUES ('ROLE_ADMIN', 1);
INSERT INTO funcao (nome, usuario_id) VALUES ('ROLE_USER', 2);