<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link rel="stylesheet" href="css/bootstrap.css" >
		<link rel="stylesheet" href="css/logup.css" >
		<link rel="stylesheet" href="css/input.css" >
		<title>.:| CADASTRO |:.</title>
	</head>
	<body>
		
		<form action="logup.jsp" method="post" class="form col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3">
			<h1>CADASTRO</h1>
			
			
			<section class="messages col-10 offset-1">
				<div class="alert  ${message.getType()} msg" role="alert" >${message.getMessage()}</div>		
			</section>
			
		
			<div class="form-group col-10 offset-1">
				<label for="nome">NOME</label>
				<input type="text" class="form-control" name="txt-nome" value="${dados.getNome()}" id="nome">
			</div>
			
			<div class="form-group col-10 offset-1">
				<label for="usernome">USERNAME</label>
				<input type="text" class="form-control" name="txt-username" value="${dados.getNomeUser()}" id="username">
			</div>
			
			<div class="form-group col-10 offset-1">
				<label for="senha">SENHA</label>
				<input type="password" class="form-control" name="txt-senha"  value="${dados.getPassUser()}" id="senha">
			</div>
			
			<div class="form-group col-10 offset-1">
				<label for="url-avatar">URL FOTO AVATAR</label>
				<input type="text" class="form-control" name="txt-url-avatar" value="${dados.getUrlAvatar()}" id="url-avatar">
			</div>
			
			<div class="col-10 offset-1" id="botoes">
				<a href="login.jsp"><button type="button" class="btn col-5 float-left">VOLTAR</button></a>
				<button type="submit" class="btn col-5 float-right">CADASTRAR</button>
			</div>
			
		</form>
		
		
		<script src="js/jquery-3.5.1js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="js/messages.js"></script>
	</body>
</html>