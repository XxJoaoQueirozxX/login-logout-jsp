# Sistema de Cadastro/Login/Logout de usuários utilizando Sessões
Sistema simples de cadastro e login de usuários utilizando sessão implementado na linguagem Java com JSP, Servlet e banco de dados Oracle com JDBC 

## Preview

#### Cadastro
![cadastro](https://github.com/XxJoaoQueirozxX/login-logout-jsp/raw/master/print/cadastro.jpg)

#### Login
![login](https://github.com/XxJoaoQueirozxX/login-logout-jsp/raw/master/print/tela-login.png)


#### Mensagens de validação
![validacao-login](https://github.com/XxJoaoQueirozxX/login-logout-jsp/raw/master/print/tela-login-validacao.png)

#### Página HOME (Renderezição dos dados do usuário)
![home](https://github.com/XxJoaoQueirozxX/login-logout-jsp/raw/master/print/home.png)



## Banco de Dados
**OBS**: Para efetuar a conexão com o banco de dados é necessário preencher os dados de conexão na classe ConnectionFactory localizada em **src/br/com/fiap/connection/ConnectionFactory.java**
você deve alterar os seguintes campos:
- dbURL: endereço do seu banco de dados(_exemplo: jdbc:oracle:thin:@localhost:1521:orcl_)
- user: Seu usuario no banco de dados
- pwd: A senha do seu usuário no banco 

Esse dados devem ser alterados no método abaixo:
![conexao](https://github.com/XxJoaoQueirozxX/login-logout-jsp/raw/master/print/conexao.png)

### Script SQL para criação das tabela e sequence (Oracle DB)
script sql para a criação da tabela de usuário no banco de dados e a sequence relativa a seu id

    CREATE TABLE TBL_LOGIN(
        id_user number(10) not null,
        nome varchar(100) not null,
        nm_user varchar2(300) not null,
        pass_user varchar2(300) not null,
        url_avatar varchar2(1000) not null,
        CONSTRAINT login_pk PRIMARY KEY (id_user)
    );
    create sequence seq_login
    minvalue 1
    maxvalue 99999999999
    start with 1
    increment by 1
    nocache
    cycle;
