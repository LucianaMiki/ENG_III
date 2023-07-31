<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<meta name="description" content="Tela Cadastro">
	<meta name="author" content="Marcela Amorim">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>CINEMAX</title>
	<link rel="stylesheet" href="assets/css/formaddmain.css" />
	<link rel="stylesheet" href="assets/css/comboBox.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
</head>

<body class="is-preload">
	<!-- Breadcrumb -->
	<ul class="breadcrumb">
		<li><a href="func.jsp">LISTAGEM</a></li>
		<li>NOVO</li>
	</ul>

	<!-- Main -->
	<div id="main">
		<header class="major container medium">
		<div class="tooltip"><h2>Cadastro de Agendamento</h2>
			<span class="tooltiptext">Ao clicar em cadastrar os dados só são excluídos de forma direcionada</span>
			  </div>
		</header>
	</div>

	<!-- Footer -->
	<div id="footer">
		<div class="container medium" id="contato">
			<header class="major last">
				<form method="get" action="Salvar">
					<label align="left">Sala</label>	<br>
					<div class="row">
						<div class="col-6 col-12-mobilep">
							<div>Código da sala</div>
							<select required="" id="txtCodigo" name='txtCodigo'>
								<option value="">Selecione o codigo da sala</option>
								<option value="1">Sala 01</option>
								<option value="2">Sala 02</option>
								<option value="3">Sala 03</option>
								<option value="4">Sala 04</option>
								<option value="5">Sala 05</option>
								<option value="6">Sala 06</option>
							 </select>
						</div>
						<div class="col-6 col-12-mobilep">
							<div>Tipo da sala</div>
							<select name='tipo' required="" id="tipo">
								<option value="">Selecione o tipo da sala</option>
								<option value="1">comum</option>
								<option value="2">VIP</option>
						 </select>
							</div>
						<div class="col-12">
							<div>Capacidade da sala (Digite 1 para capacidade total 25)</div>
							<input type="text" name="capacidade" required="" placeholder="Digite a capacidade da sala" />
						</div>
						</select>
						<label>SessÃ£o</label><br>
						<div class="col-12">
							<div>Faixa etária</div>
							<select name="faixaE" required="">
								<option value="">Selecione a faixa etária da sessão</option>
								<option value="1">L</option>
								<option value="2">10</option>
								<option value="3">12</option>
								<option value="4">16</option>
								<option value="5">18</option>
							 </select>
						</div>
						<div class="col-6 col-12-mobilep">
							<div>Valor da meia entrada</div>
							<input type="text" name="valorM" placeholder="Digite o valor da entrada meia" />
						</div>
						<div class="col-6 col-12-mobilep">
							<div>Valor da entrada inteira</div>
							<input type="text" name="valorI" required="" placeholder="Digite o valor da entrada inteira" />
						</div>
						<div class="col-12">
							<div>Data inicial da exibição</div>
							<input placeholder="Selecione data inicial de exibicao" type="date" required="required"  maxlength="10" name="dtI" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2020-01-01" max="2021-06-01" >
						</div>
						<div class="col-12">
							<div>Data final da exibição</div>
							<input placeholder="Selecione data final de exibicao" type="date" required="required"  maxlength="10" name="dtS" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2020-01-01" max="2021-06-01" >
						</div>
						<label>Filme</label><br>
						<div class="col-12">
							<div>Título do filme</div>
							<input type="text" name="titulo" placeholder="Digite o título do filme"required="">
						</div>
						<div class="col-6 col-12-mobilep">
							<div>Ano de estreia</div>
							<input type="text" name="ano" placeholder="Digite o ano de estreia" required=""/>
						</div>
						<div class="col-6 col-12-mobilep">
							<div>Diretor</div>
							<input type="text" name="duracao" placeholder="Digite o diretor do filme" required=""/>
						</div>
						<div class="col-12">
							<div>Duração</div>
							<input type="text" name="diretor" placeholder="Digite a duração do filme" required=""/>
						</div>
						<div class="col-12">
							<div>Elenco principal</div>
							<textarea name="elenco" placeholder="Digite o elenco principal do filme" required=""></textarea>
						</div>
						<div class="col-12">
							<div>Sinopse</div>
							<textarea name="sinopse" placeholder="Digite a sinopse do filme em cartaz" required=""></textarea>
						</div>						
			
						<div class="col-12">
							<ul class="actions special">
									
								<li><input type="submit" value="CADASTRAR" id="operacao" name="operacao"/></li>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	

</body>

</html>