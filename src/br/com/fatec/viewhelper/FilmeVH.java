package br.com.fatec.viewhelper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Filme;

public class FilmeVH implements IViewHelper {

	public static EntidadeDominio getEntidade(HttpServletRequest request) {
		String txtTitulo = request.getParameter("titulo");
		String txtEstreia = request.getParameter("ano");
		String txtDuracao = request.getParameter("duracao");
		String txtDiretor = request.getParameter("diretor");
		String txtElenco = request.getParameter("elenco");
		String txtSinopse = request.getParameter("sinopse");
		
		Filme filme = new Filme(txtTitulo, txtEstreia, txtDuracao, txtDiretor, txtElenco, txtSinopse);
		return filme;

	}

	@Override
	public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		PrintWriter out;
		try {
			out = response.getWriter();
			if (resultado != null) {
				out.println(resultado);
			} else {
				out.println("<h1>Filme cadastrado!</h1>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
}
