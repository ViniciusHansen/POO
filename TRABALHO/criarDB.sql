create table Usuario(
    id int,
    dataNascimento varchar(12),
    nome varchar(20),
    senha varchar(20),
    primary key (id)
);
create sequence Usuario;

create table Filme(
    id int,
    ano int,
    duracao int,
    titulo varchar(32),
    genero varchar(32),
    descricao varchar(32),
    capa byte[],
    primary key (id)
)