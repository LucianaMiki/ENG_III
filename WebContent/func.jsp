<%@page import="br.com.fatec.dominio.EntidadeDominio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page isELIgnored ="false" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.fatec.dominio.Filme"%>
<%@page import="br.com.fatec.dominio.Sala"%>
<%@page import="br.com.fatec.dominio.Sessao"%>
<%@page import="br.com.fatec.dao.FilmeDAO"%>
<%@page import="br.com.fatec.dao.SalaDAO"%>
<%@page import="br.com.fatec.dao.SessaoDAO"%>
<%@page import="br.com.fatec.dao.IDAO"%>

<%
	Filme filme = new Filme();
	Sala sala = new Sala();
	Sessao sessao = new Sessao();
	
	EntidadeDominio entidadeFilme = (EntidadeDominio) filme;
	EntidadeDominio entidadeSala = (EntidadeDominio) sala;
	EntidadeDominio entidadeSessao = (EntidadeDominio) sessao;
	
	IDAO daoF = new FilmeDAO();
	IDAO daoSa = new SalaDAO();
	IDAO daoSe = new SessaoDAO();
	
	List<EntidadeDominio> listFilme = new ArrayList<EntidadeDominio>();
	List<EntidadeDominio> listSala = new ArrayList<EntidadeDominio>();
	List<EntidadeDominio> listSessao = new ArrayList<EntidadeDominio>();
	
	listFilme = daoF.Consultar(entidadeFilme);
	listSala = daoSa.Consultar(entidadeSala);
	listSessao = daoSe.Consultar(entidadeSessao);
%>

<!DOCTYPE HTML>
<html>

<head>
	<title>CINEMAX</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<meta name="description" content="Tela Gerencia">
	<meta name="author" content="Marcela Amorim">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="assets/css/funcmain.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

</head>

<body class="is-preload">
	<!--Menu-->

	<nav class="navbar navbar-inverse">
		<a href="login.html">Logout</a>
		<div class="animation start-home"></div>
	</nav>

	<!-- Main -->
	<div id="main">

		<header class="major container medium">
			<h2>Essa área está reservada apenas a funcionários com permissão de acesso</h2>
			<p>Cadastre uma nova informaçãoo pelo botão principal ou veja mais opções direcionadas</p>
		</header>
		<div class="box alt container">
			<ul class="actions special">
				<li><input type="submit" value="Cadastrar Novo Agendamento" id="btnadd" onClick="window.location.href='formadd.jsp'"/></li>
			</ul><br>
			<form method="get" action="Salvar">
				<section class="feature left">
					<div class="content">
						<h3>Sala 01</h3>
						<%
							Integer aux = null;
							Filme filme1 = (Filme) entidadeFilme;
							Sala sala1 = (Sala) entidadeSala;
							Sessao sessao1 = (Sessao) entidadeSessao;
							for(int i = 0; i<listSala.size(); i++){
								sala = (Sala) listSala.get(i);
								Integer numSala = Integer.parseInt(sala.getCodigo());
								if(numSala == 1) {
									aux = sala.getId();
									sala1 = sala;
								}
							}
							if(aux == null){
								out.print("<p>Título do filme: Nada cadastrado" 
										+ "<br>Faixa etária: Nada cadastrado" 
										+ "<br>Duração: Nada cadastrado" 
										+ "<br>Horário: Nada cadastrado");
							}else{
							for(int i = 0; i<listSessao.size(); i++){
								sessao = (Sessao) listSessao.get(i);
								Integer numSala = (sessao.getSalaId());
								if(numSala == aux) {
									sessao1 = sessao;
								}
							}
							for(int i = 0; i<listFilme.size(); i++){
								filme = (Filme) listFilme.get(i);
								Integer numFilme = (sessao1.getFilmeId());
								if(numFilme == filme.getId()) {
									filme1 = filme;
								}
							}
							
							Integer fxeInt = sessao1.getFxe();
							String fxeString = null;;
							if(fxeInt == 1) fxeString = "L";
							if(fxeInt == 2) fxeString = "10";
							if(fxeInt == 3) fxeString = "12";
							if(fxeInt == 4) fxeString = "16";
							if(fxeInt == 5) fxeString = "18";

							out.print("<p>Título do filme: " 
								+ filme1.getTitulo() 
								+ "<br>Faixa etária: " 
								+ fxeString 
								+ "<br>Duração: " 
								+ filme1.getDiretor()
								+ "<br>Horário: 19:00");
							}
						%>
						<ul class="actions special">
							<li><input type="submit" name="operacao" value="Editar Sala 01"/></li>
							<li><input type="submit" name="operacao" value="Excluir Sala 01" data-toggle="modal" data-target="#myModal" /></li>
						</ul>
					</div>
				</section>
				<section class="feature right">
					<div class="content">
						<h3>Sala 02</h3>
						<%
							Integer aux2 = null;
							Filme filme2 = (Filme) entidadeFilme;
							Sala sala2 = (Sala) entidadeSala;
							Sessao sessao2 = (Sessao) entidadeSessao;
							for(int i = 0; i<listSala.size(); i++){
								sala = (Sala) listSala.get(i);
								Integer numSala = Integer.parseInt(sala.getCodigo());
								if(numSala == 2) {
									aux2 = sala.getId();
									sala2 = sala;
								}
							}
							if(aux2 == null){
								out.print("<p>Título do filme: Nada cadastrado" 
										+ "<br>Faixa etária: Nada cadastrado" 
										+ "<br>Duração: Nada cadastrado" 
										+ "<br>Horário: Nada cadastrado");
							}else{
							for(int i = 0; i<listSessao.size(); i++){
								sessao = (Sessao) listSessao.get(i);
								Integer numSala = (sessao.getSalaId());
								if(numSala == aux2) {
									sessao2 = sessao;
								}
							}
							for(int i = 0; i<listFilme.size(); i++){
								filme = (Filme) listFilme.get(i);
								Integer numFilme = (sessao2.getFilmeId());
								if(numFilme == filme.getId()) {
									filme2 = filme;
								}
							}
							
							Integer fxeInt2 = sessao1.getFxe();
							String fxeString2 = null;;
							if(fxeInt2 == 1) fxeString2 = "L";
							if(fxeInt2 == 2) fxeString2 = "10";
							if(fxeInt2 == 3) fxeString2 = "12";
							if(fxeInt2 == 4) fxeString2 = "16";
							if(fxeInt2 == 5) fxeString2 = "18";

							out.print("<p>Título do filme: " 
								+ filme2.getTitulo() 
								+ "<br>Faixa etária: " 
								+ fxeString2
								+ "<br>Duração: " 
								+ filme2.getDiretor()
								+ "<br>Horário: 19:00");
							}
						%>
						<ul class="actions special">
							<li><input type="submit" name="operacao" value="Editar Sala 02"/></li>
							<li><input type="submit" name="operacao" value="Excluir Sala 02" data-toggle="modal" data-target="#myModal" /></li>
						</ul>
					</div>
				</section>
				<section class="feature left">
					<div class="content">
						<h3>Sala 03</h3>
						<%
							Integer aux3 = null;
							Filme filme3 = (Filme) entidadeFilme;
							Sala sala3 = (Sala) entidadeSala;
							Sessao sessao3 = (Sessao) entidadeSessao;
							for(int i = 0; i<listSala.size(); i++){
								sala = (Sala) listSala.get(i);
								Integer numSala = Integer.parseInt(sala.getCodigo());
								if(numSala == 3) {
									aux3 = sala.getId();
									sala3 = sala;
								}
							}
							if(aux3 == null){
								out.print("<p>Título do filme: Nada cadastrado" 
										+ "<br>Faixa etária: Nada cadastrado" 
										+ "<br>Duração: Nada cadastrado" 
										+ "<br>Horário: Nada cadastrado");
							}else{
							for(int i = 0; i<listSessao.size(); i++){
								sessao = (Sessao) listSessao.get(i);
								Integer numSala = (sessao.getSalaId());
								if(numSala == aux3) {
									sessao3 = sessao;
								}
							}
							for(int i = 0; i<listFilme.size(); i++){
								filme = (Filme) listFilme.get(i);
								Integer numFilme = (sessao3.getFilmeId());
								if(numFilme == filme.getId()) {
									filme3 = filme;
								}
							}
							
							Integer fxeInt3 = sessao1.getFxe();
							String fxeString3 = null;;
							if(fxeInt3 == 1) fxeString3 = "L";
							if(fxeInt3 == 2) fxeString3 = "10";
							if(fxeInt3 == 3) fxeString3 = "12";
							if(fxeInt3 == 4) fxeString3 = "16";
							if(fxeInt3 == 5) fxeString3 = "18";

							out.print("<p>Título do filme: " 
								+ filme3.getTitulo() 
								+ "<br>Faixa etária: " 
								+ fxeString3
								+ "<br>Duração: " 
								+ filme3.getDiretor()
								+ "<br>Horário: 19:00");
							}
						%>
						<ul class="actions special">
							<li><input type="submit" name="operacao" value="Editar Sala 03"/></li>
							<li><input type="submit" name="operacao" value="Excluir Sala 03" data-toggle="modal" data-target="#myModal" /></li>
						</ul>
					</div>
				</section>
				<section class="feature right">
					<div class="content">
						<h3>Sala 04</h3>
						<%
							Integer aux4 = null;
							Filme filme4 = (Filme) entidadeFilme;
							Sala sala4 = (Sala) entidadeSala;
							Sessao sessao4 = (Sessao) entidadeSessao;
							for(int i = 0; i<listSala.size(); i++){
								sala = (Sala) listSala.get(i);
								Integer numSala = Integer.parseInt(sala.getCodigo());
								if(numSala == 4) {
									aux4 = sala.getId();
									sala4 = sala;
								}
							}
							if(aux4 == null){
								out.print("<p>Título do filme: Nada cadastrado" 
										+ "<br>Faixa etária: Nada cadastrado" 
										+ "<br>Duração: Nada cadastrado" 
										+ "<br>Horário: Nada cadastrado");
							}else{
							
								for(int i = 0; i<listSessao.size(); i++){
									sessao = (Sessao) listSessao.get(i);
									Integer numSala = (sessao.getSalaId());
									if(numSala == aux4) {
										sessao4 = sessao;
									}
								}
								for(int i = 0; i<listFilme.size(); i++){
									filme = (Filme) listFilme.get(i);
									Integer numFilme = (sessao4.getFilmeId());
									if(numFilme == filme.getId()) {
										filme4 = filme;
									}
								}
								
								Integer fxeInt4 = sessao1.getFxe();
								String fxeString4 = null;
								if(fxeInt4 == 1) fxeString4 = "L";
								if(fxeInt4 == 2) fxeString4 = "10";
								if(fxeInt4 == 3) fxeString4 = "12";
								if(fxeInt4 == 4) fxeString4 = "16";
								if(fxeInt4 == 5) fxeString4 = "18";
	
								out.print("<p>Título do filme: " 
									+ filme4.getTitulo() 
									+ "<br>Faixa etária: " 
									+ fxeString4
									+ "<br>Duração: " 
									+ filme4.getDiretor()
									+ "<br>Horário: 19:00");
							}
						%>
						<ul class="actions special">
							<li><input type="submit" name="operacao" value="Editar Sala 04"/></li>
							<li><input type="submit" name="operacao" value="Excluir Sala 04" data-toggle="modal" data-target="#myModal" /></li>
						</ul>
					</div>
				</section>
				<section class="feature left">
					<div class="content">
						<h3>Sala 05</h3>
						<%
							Integer aux5 = null;
							Filme filme5 = (Filme) entidadeFilme;
							Sala sala5 = (Sala) entidadeSala;
							Sessao sessao5 = (Sessao) entidadeSessao;
							for(int i = 0; i<listSala.size(); i++){
								sala = (Sala) listSala.get(i);
								Integer numSala = Integer.parseInt(sala.getCodigo());
								if(numSala == 5) {
									aux5 = sala.getId();
									sala5 = sala;
								}
							}
							if(aux5 == null){
								out.print("<p>Título do filme: Nada cadastrado" 
										+ "<br>Faixa etária: Nada cadastrado" 
										+ "<br>Duração: Nada cadastrado" 
										+ "<br>Horário: Nada cadastrado");
							}else{
							for(int i = 0; i<listSessao.size(); i++){
								sessao = (Sessao) listSessao.get(i);
								Integer numSala = (sessao.getSalaId());
								if(numSala == aux5) {
									sessao5 = sessao;
								}
							}
							for(int i = 0; i<listFilme.size(); i++){
								filme = (Filme) listFilme.get(i);
								Integer numFilme = (sessao5.getFilmeId());
								if(numFilme == filme.getId()) {
									filme5 = filme;
								}
							}
							
							Integer fxeInt5 = sessao1.getFxe();
							String fxeString5 = null;;
							if(fxeInt5 == 1) fxeString5 = "L";
							if(fxeInt5 == 2) fxeString5 = "10";
							if(fxeInt5 == 3) fxeString5 = "12";
							if(fxeInt5 == 4) fxeString5 = "16";
							if(fxeInt5 == 5) fxeString5 = "18";

							out.print("<p>Título do filme: " 
								+ filme5.getTitulo() 
								+ "<br>Faixa etária: " 
								+ fxeString5
								+ "<br>Duração: " 
								+ filme5.getDiretor()
								+ "<br>Horário: 19:00");
							}
						%>
						<ul class="actions special">
							<li><input type="submit" name="operacao" value="Editar Sala 05"/></li>
							<li><input type="submit" name="operacao" value="Excluir Sala 05" data-toggle="modal" data-target="#myModal" /></li>
						</ul>
					</div>
				</section>
				<section class="feature right">
					<div class="content">
						<h3>Sala 06</h3>
						<%
							Integer aux6 = null;
							Filme filme6 = (Filme) entidadeFilme;
							Sala sala6 = (Sala) entidadeSala;
							Sessao sessao6 = (Sessao) entidadeSessao;
							for(int i = 0; i<listSala.size(); i++){
								sala = (Sala) listSala.get(i);
								Integer numSala = Integer.parseInt(sala.getCodigo());
								if(numSala == 6) {
									aux6 = sala.getId();
									sala6 = sala;
								}
							}
							if(aux6 == null){
								out.print("<p>Título do filme: Nada cadastrado" 
										+ "<br>Faixa etária: Nada cadastrado" 
										+ "<br>Duração: Nada cadastrado" 
										+ "<br>Horário: Nada cadastrado");
							}else{
							for(int i = 0; i<listSessao.size(); i++){
								sessao = (Sessao) listSessao.get(i);
								Integer numSala = (sessao.getSalaId());
								if(numSala == aux6) {
									sessao6 = sessao;
								}
							}
							for(int i = 0; i<listFilme.size(); i++){
								filme = (Filme) listFilme.get(i);
								Integer numFilme = (sessao6.getFilmeId());
								if(numFilme == filme.getId()) {
									filme6 = filme;
								}
							}
							
							Integer fxeInt6 = sessao1.getFxe();
							String fxeString6 = null;;
							if(fxeInt6 == 1) fxeString6 = "L";
							if(fxeInt6 == 2) fxeString6 = "10";
							if(fxeInt6 == 3) fxeString6 = "12";
							if(fxeInt6 == 4) fxeString6 = "16";
							if(fxeInt6 == 5) fxeString6 = "18";

							out.print("<p>Título do filme: " 
								+ filme6.getTitulo() 
								+ "<br>Faixa etária: " 
								+ fxeString6
								+ "<br>Duração: " 
								+ filme6.getDiretor()
								+ "<br>Horário: 19:00");
							}
						%>
						<ul class="actions special">
							<li><input type="submit" name="operacao" value="Editar Sala 06"/></li>
							<li><input type="submit" name="operacao" value="Excluir Sala 06" data-toggle="modal" data-target="#myModal" /></li>
						</ul>
					</div>
				</section>
			</form>
			<!--Modal
			<div class="container">

				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Confirmar ExclusÃ£o</h4>
							</div>
							<div class="modal-body">
								<p>Ao excluir um item da agenda o mesmo nÃ£o pode ser recuperado, deseja continar?</p>
							</div>
							<div class="modal-footer">
								<input type="submit" mx-2 value="Cancelar" data-dismiss="modal" />
								<input type="submit" value="Confirmar" data-dismiss="modal" />
							</div>
						</div>
					</div>
				</div>
			</div>-->
			
		</div>

	</div>

	<!-- Footer -->
	<div id="footer">
		<div class="container medium" id="contato">
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
	<script src="assets/js/modal.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</body>

</html>