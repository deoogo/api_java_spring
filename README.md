# Logando no banco
psql -h localhost --port 5432 -d cliente -U postgres --password

# Criando um DB no postgres
CREATE DATABASE cliente;

# criando as tabelas e add os campos
CREATE TABLE tbl_clientes ( ID_Autor integer CONSTRAINT id PRIMARY KEY, nome varchar(30) );


