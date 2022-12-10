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
    capa bytea,
    primary key (id)
);
create sequence Filme;


create table Serie(
    id int,
    ano int,
    temporada int,
    episodios 
    titulo varchar(32),
    genero varchar(32),
    descricao varchar(32),
    capa bytea,
    primary key (id)
);
create sequence Serie;

create table Episodio(
    id int,
    duracao int,
    descricao varchar(100),
    primary key (id)
)

create table episodios(
    Episodio_id int,
)