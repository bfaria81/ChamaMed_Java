# ChamaMed_Java
Aplicativo de chamadas para projeto integrador 

Criação do Banco

CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
	nome varchar(255) not null,
	matricula integer not null,
	cargo integer not null,
	senha varchar(255) not null,
    ativo bool default true,
	foreign key (cargo) references cargo(id)
);


CREATE TABLE cargo(
id SERIAL PRIMARY KEY, nome varchar(255)
)
insert into cargo(nome)
values('Gestor(a)'),
('Médico(a)'),
('Residente'),
('Enfermeiro(a)-Chefe'),
('Enfermeiro(a)')


CREATE TABLE interruptor (
    id SERIAL PRIMARY KEY,
	interruptor varchar(255) not null,
    estado bool default true,
	setor varchar(255) not null
);

CREATE TABLE registro (
    id SERIAL PRIMARY KEY,
    acao VARCHAR(255) ,
	nome varchar(255) ,
    data_hora TIMESTAMP 
);
