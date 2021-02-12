<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link rel="stylesheet" href="css/bootstrap.css" >
		<link rel="stylesheet" href="css/index.css" >
		<title>.:| HOME |:.</title>
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark-nav">
				<a class="navbar-brand" href="index.jsp">
					<!-- https://getbootstrap.com//docs/4.0/assets/brand/bootstrap-solid.svg -->
	    			<img src="${currentUser.getUrlAvatar()}" width="30" height="30" class="d-inline-block align-top" alt="">
	    			${ currentUser.getNomeUser()}
	  			</a>
	  			
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav justify-content-end">
						<li class="nav-item active">
							<a class="nav-link" href="index.jsp">
								HOME<span class="sr-only">(current)</span>
							</a>
						</li>
						
						
						<li class="nav-item">
							<a class="nav-link" href="logout">
								LOGOUT
							</a>
						</li>
				
					</ul>
				</div>
			</nav>
		</header>
		<main id="conteudo">
			<div class="col-12 data">
				<div class="avatar offset-3  offset-md-1 offset-lg-1">
					<img alt="user-avatar" class="img-thumbnail rounded rounded-circle" src="${currentUser.getUrlAvatar()}">
					<h3>${currentUser.getNomeUser()}</h3>
				</div>
			</div>
			
			<div class="info col-sm-10 offset-sm-1 ">
				<table class="table table-dark table-bordered">
					<thead>
						<tr>
							<td colspan="2" style="text-align:center;">DADOS</td>
						</tr>
					</thead>
					<tbody>	
						<tr>
							<td>ID</td>
							<td>${currentUser.getId()}</td>
						</tr>
						
						<tr>
							<td>NOME</td>
							<td>${currentUser.getNome()}</td>
						</tr>
						
						<tr>
							<td>USERNAME</td>
							<td>${currentUser.getNomeUser()}</td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</main>	
		
		<script src="js/jquery-3.5.1.js"></script>
		<script src="js/bootstrap.js"></script>
	</body>
</html>