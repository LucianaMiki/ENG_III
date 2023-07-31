<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>

<!DOCTYPE HTML>
<html>

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<meta name="description" content="Tela Editar">
	<meta name="author" content="Marcela Amorim">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>CINEMAX</title>
	<link rel="stylesheet" href="assets/css/formaddmain.css" />
	<link rel="stylesheet" href="assets/css/formed.css" />
	<link rel="stylesheet" href="assets/css/comboBox.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
</head>

<body class="is-preload">
	<!-- Breadcrumb -->
	<ul class="breadcrumb">
		<li><a href="func.jsp">LISTAGEM</a></li>
		<li>EDITAR</li>
	</ul>

	<!-- Main -->
	<div id="main">
		<header class="major container medium">
			<div class="tooltip"><h2>Alteração de Agendamento</h2>
			<span class="tooltiptext">Ao alterar os dados anteriores não é possível recuperá-los pelo botão de redefinição, mas apenas antes da confirmação</span>
			  </div>
		</header>
	</div>

	<!-- Footer -->
	<div id="footer">
		<div class="container medium" id="contato">
			<header class="major last">
				<form method="get" action="Salvar" >
					<label align ="left">Sala</label>	<br>
					<div class="row">
						<div class="col-6 col-12-mobilep">
							<div>Código da sala</div>
							<select required="" id="txtCodigo" name='txtCodigo'>
								<option value="<%=request.getAttribute("Codigo")%>"><%=request.getAttribute("Codigo")%></option>
							 </select>
						</div>
						<div class="col-6 col-12-mobilep">
							<div>Tipo da sala</div>
							<select name='tipo' required="" id="tipo">
								<option value=""><%=request.getAttribute("Tipo")%></option>
								<option value="1">comum</option>
								<option value="2">VIP</option>
						 </select>
							</div>
						<div class="col-12">
							<div>Capacidade da sala (Digite 1 para capacidade total 25)</div>
							<input type="text" name="capacidade" required="" placeholder="<%=request.getAttribute("Capacidade")%>" />
						</div>
						</select>
						<label>SessÃ£o</label><br>
						<div class="col-12">
							<div>Faixa etária</div>
							<select name="faixaE" required="">
								<option value=""><%=request.getAttribute("fxe")%></option>
								<option value="1">L</option>
								<option value="2">10</option>
								<option value="3">12</option>
								<option value="4">16</option>
								<option value="5">18</option>
							 </select>
						</div>
						<div class="col-6 col-12-mobilep">
							<div>Valor da meia entrada</div>
							<input type="text" name="valorM" placeholder="<%=request.getAttribute("vm")%>" />
						</div>
						<div class="col-6 col-12-mobilep">
							<div>Valor da entrada inteira</div>
							<input type="text" name="valorI" required="" placeholder="<%=request.getAttribute("vi")%>" />
						</div>
						<div class="col-12">
							<div>Data inicial da exibição</div>
							<input placeholder="<%=request.getAttribute("dti")%>" type="date" required="required"  maxlength="10" name="dtI" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2020-01-01" max="2021-06-01" >
						</div>
						<div class="col-12">
							<div>Data final da exibição</div>
							<input placeholder="<%=request.getAttribute("dtf")%>" type="date" required="required"  maxlength="10" name="dtS" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2020-01-01" max="2021-06-01" >
						</div>
						<label>Filme</label><br>
						<div class="col-12">
							<div>Título do filme</div>
							<input type="text" name="titulo" placeholder="<%=request.getAttribute("Titulo")%>"required="">
						</div>
						<div class="col-6 col-12-mobilep">
							<div>Ano de estreia</div>
							<input type="text" name="ano" placeholder="<%=request.getAttribute("Estreia")%>" required=""/>
						</div>
						<div class="col-6 col-12-mobilep">
							<div>Diretor</div>
							<input type="text" name="duracao" placeholder="<%=request.getAttribute("Duracao")%>" required=""/>
						</div>
						<div class="col-12">
							<div>Duração</div>
							<input type="text" name="diretor" placeholder="<%=request.getAttribute("Diretor")%>" required=""/>
						</div>
						<div class="col-12">
							<div>Elenco principal</div>
							<textarea name="elenco" placeholder="<%=request.getAttribute("Elenco")%>" required=""></textarea>
						</div>
						<div class="col-12">
							<div>Sinopse</div>
							<textarea name="sinopse" placeholder="<%=request.getAttribute("Sinopse")%>" required=""></textarea>
						</div>	
					
						<div class="col-12">
							<ul class="actions special">
								<li><input type="submit" id="operacao" name="operacao" value="EDITAR" /></li>
								<li><input type="reset" value="REDEFINIR"/></li>
							</ul>
						</div>
					</div>
				</form>
			</header>
			

			<ul class="copyright">
				<li>&copy; Todos os direitos reservados</li>
				<li>CineMax</li>
			</ul>

		</div>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/comboBox.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</body>

</html>