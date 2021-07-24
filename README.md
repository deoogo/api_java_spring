# Projetinho GCP



### Logando no banco
> psql -h localhost --port 5432 -d cliente -U postgres --password

### Criando um DB no postgres
> CREATE DATABASE cliente;

### Criando as tabelas e add os campos
> CREATE TABLE tbl_clientes ( ID_Cli integer CONSTRAINT id PRIMARY KEY, nome varchar(30) );



### Proximos passos
- [x] Desenvolvimento da api simples
- [x] Persistencia no banco postgres
- [x] Adicionando o projeto no docker e criando DockerFile
- [ ] Adicionando o projeto no K8S local
- [ ] Levando fase 1 do projeto para o GKE
- [ ] CI/CD com os recursos da GCP
- [ ] Desenvolvimento do Front
- [ ] Desenvolvimento da função que escreve na Fila
- [ ] Criação do Terraform infra GCP
- [ ] Teste Final 
