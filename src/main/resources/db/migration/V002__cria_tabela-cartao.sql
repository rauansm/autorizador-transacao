create table cartao (
 numero_cartao varchar(20) not null,
 saldo decimal (10,2),
 data_criacao datetime not null,
 senha varchar (4) not null,
 cliente_id varchar (36) not null,
 primary key (numero_cartao)
 ) engine=InnoDB;

 alter table cartao
 add constraint fk_cartao_cliente
 foreign key (cliente_id) references cliente (id_cliente);