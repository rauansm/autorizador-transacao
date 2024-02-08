create table cliente (
id_cliente varchar(36) not null,
nome varchar(80) not null,
email varchar(150) not null,
sexo varchar(20) not null,
data_cadastro datetime not null,
primary key (id_cliente)
) engine=InnoDB;


alter table cliente
add constraint unique_email unique (email);
