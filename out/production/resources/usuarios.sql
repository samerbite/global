create table usuarios

(

    id interger not null,

    name varchar(255) not null,

    email varchar(255) not null,

    password varchar(255) not null,

    phones varchar (255) not null,

    creacion timestamp ,

    modificado timestamp ,

    activo varchar (255) not null,

primary key(id)

);