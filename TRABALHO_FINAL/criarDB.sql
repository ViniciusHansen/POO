create table Usuario(
    UsuarioID int,
    dataNascimento varchar(12),
    nome varchar(20),
    senha varchar(20),
    primary key (UsuarioID)
);
create sequence UsuarioID;


create table Filme(
    FilmeID int,
    ano int,
    duracao int,
    titulo varchar(32),
    genero varchar(32),
    descricao varchar(100),
    capa bytea,
    primary key (FilmeID),
    UsuarioID int references Usuario (UsuarioID) ON DELETE CASCADE
);
create sequence FilmeID;


create table Serie(
    SerieID int,
    ano int,
    temporada int,
    titulo varchar(32),
    genero varchar(32),
    descricao varchar(100),
    capa bytea,
    primary key (SerieID),
    UsuarioID int references Usuario (UsuarioID) ON DELETE CASCADE
);
create sequence SerieID;


create table Episodio(
    EpisodioID int,
    numero_episodio int,
    duracao int,
    descricao varchar(100),
    primary key (EpisodioID),
    SerieID int references Serie (SerieID) ON DELETE CASCADE
);
create sequence EpisodioID;


create table Ator(
    AtorID int,
    nome varchar(32),
    dataNascimento varchar(32),
    sexo varchar(32),
    primary key (AtorID)
);
create sequence AtorID;


create table Ator_Filme(
    AtorID int references Ator (AtorID) ON DELETE CASCADE,
    FilmeId int references Filme (FilmeID) ON DELETE CASCADE,
    ElencoPrimario boolean,
    ElencoSecundario boolean,
    CONSTRAINT Ator_Filme_PK primary key (AtorID, FilmeID)
);

create table Ator_Serie(
    AtorID int references Ator (AtorID) ON DELETE CASCADE,
    SerieId int references Serie (SerieID) ON DELETE CASCADE,
    ElencoPrimario boolean,
    ElencoSecundario boolean,
    CONSTRAINT Ator_Serie_PK primary key (AtorID, SerieID)
);