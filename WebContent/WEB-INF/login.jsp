<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link rel="stylesheet" href="css/bootstrap.css" >
		<link rel="stylesheet" href="css/login.css" >
		<link rel="stylesheet" href="css/input.css" >
		
		<title>.:| LOGIN |:.</title>
	</head>
	<body>
		
		<div class="formulario col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-5  col-lg-4 offset-lg-7">
			<h1>LOGIN</h1>
			
			<form method="POST" class="form col-12" action="login.jsp">
				<section class="messages col-10 offset-1">
					<div class="alert  ${message.getType()} msg" role="alert">${message.getMessage()}</div>			
				</section>
			
				<div class="input-group flex-nowrap col-10 offset-1">
					<div class="input-group-prepend">
						<span class="input-group-text" id="addon-wrapping"> <svg
								width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-person"
								fill="currentColor" xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd"
									d="M10 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z" />
							</svg>
						</span>
					</div>
					<input type="text" name="txt-user" class="form-control" id="email" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping" value="${dados.getNomeUser()}">
				</div>
	
				<div class="input-group flex-nowrap col-10 offset-1">
					<div class="input-group-prepend">
						<span class="input-group-text" id="addon-wrapping"> 
						<svg
								width="1.5em" height="1.5em" viewBox="0 0 16 16 " class="bi bi-key"
								fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  							<path fill-rule="evenodd"
									d="M0 8a4 4 0 0 1 7.465-2H14a.5.5 0 0 1 .354.146l1.5 1.5a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0L13 9.207l-.646.647a.5.5 0 0 1-.708 0L11 9.207l-.646.647a.5.5 0 0 1-.708 0L9 9.207l-.646.647A.5.5 0 0 1 8 10h-.535A4 4 0 0 1 0 8zm4-3a3 3 0 1 0 2.712 4.285A.5.5 0 0 1 7.163 9h.63l.853-.854a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.793-.793-1-1h-6.63a.5.5 0 0 1-.451-.285A3 3 0 0 0 4 5z" />
	  							<path d="M4 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0z" />
							</svg>
						</span>
					</div>
					<input type="password" name="txt-senha" class="form-control" id='senha-field' placeholder="Password" aria-label="Password" aria-describedby="addon-wrapping" value="${dados.getPassUser()}">
				</div>
				
				<div id="botoes" class="col-10 offset-1">
					<button type="submit" id="login" class="btn col-5 float-left">LOG IN</button>
					<a href="logup.jsp"><button id="logup" type="button" class="btn col-5 float-right">LOG UP</button></a>
				</div>
			</form>
		</div>
	
	
		<script src="js/jquery-3.5.1js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="js/messages.js"></script>

	</body>
</html>