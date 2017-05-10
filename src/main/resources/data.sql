INSERT INTO usuario (login, senha, ativo) VALUES ('admin', 'admin', 1);
INSERT INTO usuario (login, senha, ativo) VALUES ('arabasso', '123', 1);
INSERT INTO aluno (nome, curso, semestre, usuario_id) VALUES ('Raphael Basso', 'Ciência da Computação', '7º Semestre', 2);
INSERT INTO grupo_estudo (nome, curso, coordenador, materia, professor) VALUES ('Amigos', 'Ciência da Computação', 'Clerivaldo Roccia', 'Engenharia de Software II', 'Luis Camolesi');
INSERT INTO funcao (nome, usuario_id) VALUES ('ROLE_ADMIN', 1);
INSERT INTO funcao (nome, usuario_id) VALUES ('ROLE_USER', 2);
