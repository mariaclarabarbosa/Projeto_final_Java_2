create TABLE funcionario (
codigo integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
nome varchar(50) NOT NULL,
cpf bigserial NOT NULL);

CREATE TABLE categoria (
codigo integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
nome varchar(50) NOT NULL,
descricao varchar(100));

CREATE TABLE endereco (
codigo integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
rua varchar(100) NOT NULL,
numero integer NOT NULL,
complemento varchar(100),
bairro varchar(100) NOT NULL,
cidade varchar(100) NOT NULL,
estado varchar(100) NOT NULL,
cep bigserial NOT NULL);


CREATE TABLE cliente (
codigo integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
nome varchar(50) NOT NULL,
usuario varchar(50) NOT NULL,
email varchar(50) NOT NULL,
cpf bigserial NOT NULL,
data_nascimento varchar(50),
codigo_endereco integer NOT NULL,
foreign key(codigo_endereco) references endereco(codigo));

CREATE TABLE produto (
codigo integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
nome varchar(50) NOT NULL,
descricao varchar(200),
quantidade_estoque integer NOT NULL,
data_fabricacao varchar(50) NOT NULL, 
valor_unitario integer NOT NULL,
codigo_funcionario integer NOT NULL,
codigo_categoria integer NOT NULL,
foreign key(codigo_funcionario) references funcionario(codigo),
foreign key(codigo_categoria) references categoria(codigo));


CREATE TABLE pedido (
codigo integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
data_pedido varchar(50),
valor_total integer,
codigo_cliente integer NOT NULL,
foreign key(codigo_cliente) references cliente(codigo));

CREATE TABLE produto_pedido(
codigo integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
quantidade_itens integer NOT NULL,
codigo_produto integer NOT NULL,
codigo_pedido integer NOT NULL,
foreign key(codigo_produto) references produto(codigo),
foreign key(codigo_pedido) references pedido(codigo));