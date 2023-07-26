create table administrators(
    id bigint not null auto_increment,
    name varchar(100) not null,
    username varchar(100) not null,
    password varchar(250) not null,
    issuperadmin bit not null,

    primary key(id)
);