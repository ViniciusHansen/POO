create table tipoAnimal(
    tipo ENUM(
        CHACHORRO int,
        GATO int,
        PASSARO int,
        ROEDOR int
    )
);

create table animais(
    id int,
    nome varchar(50),
    descricao varchar(50),
    idade int,
    tipo int,
    primary key (id),
    foreign key (tipo) references tipoAnimal
);

create sequence id_animal;

create table endereco(
    numero int,
    cep int,
    rua varchar(50),
    cidade varchar(50),
    estado varchar(50),
    pais varchar(50),
    id_pessoa int,
    primary key(cep),
    foreign key(id_pessoa)
);

create sequence id_endereco;

create table pessoa (
    id int,
    nome varchar(50),
    cpf int,
    id_animal int,
    primary key(id),
    foreign key (id_animal) references animais
);

create sequence id_pessoa;