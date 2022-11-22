create table cidade(
    id int,
    nome varchar(50),
    estado varchar(50),
    primary key (id)
);

create sequence id_cidade;

create table cliente(
    id int,
    cpf int,
    nome varchar(50),
    endereco varchar(100),
    telefone int,
    primary key(id)
);

create sequence id_cliente;

create table reserva(
    id int,
    data date,
    hora time,
    preco float,
    classeVoo varchar(10),
    idaEvolda boolean,
    id_ida int,
    id_origem int,
    id_destino int,
    id_cliente int,
    primary key(id),
    foreign key(id_ida) references reserva,
    foreign key(id_origem) references cidade,
    foreign key (id_destino) references cidade,
    foreign key (id_cliente) references client
);

create sequence id_reserva;

insert into
    cidade(
        select
            nextval('id_cidade'),
            'Joinville',
            'SC'
    )
insert into
    cidade(
        select
            nextval('id_cidade'),
            'Floripa',
            'SC'
    )
insert into
    cidade(
        select
            nextval('id_cidade'),
            'curitiba',
            'PR'
    )