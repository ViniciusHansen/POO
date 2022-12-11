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
    primary key (FilmeID)
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
    primary key (SerieID)
);
create sequence SerieID;


create table Episodio(
    EpisodioID int,
    nome_serie varchar(32),
    numero_episodio int,
    duracao int,
    descricao varchar(100),
    primary key (EpisodioID)
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


create table Filme_Usuario(
    FilmeID int references Filme (FilmeID) ON DELETE CASCADE,
    UsuarioID int references Usuario (UsuarioID) ON DELETE CASCADE,
    CONSTRAINT Filme_Usuario_PK primary key (FilmeID, UsuarioID)
);

create table Episodio_Serie(
    EpisodioID int references Episodio (EpisodioID) ON DELETE CASCADE,
    SerieID int references Serie (SerieID) ON DELETE CASCADE,
    CONSTRAINT Episodio_Serie_PK primary key (EpisodioID, SerieID)
);

create table Serie_Usuario(
    SerieID int references Serie (SerieID) ON DELETE CASCADE,
    UsuarioID int references Usuario (UsuarioID) ON DELETE CASCADE,
    CONSTRAINT Serie_Usuario_PK primary key (SerieID, UsuarioID)
);

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