package br.com.fatec.viewhelper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fatec.dominio.Sala;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Filme;
import br.com.fatec.dominio.Sessao;


public class SessaoVH implements IViewHelper {

	public static EntidadeDominio getEntidade(HttpServletRequest request) {
		float txtValorM = Float.parseFloat(request.getParameter("valorM"));
		float txtValorI = Float.parseFloat(request.getParameter("valorI"));
		String txtDtI = request.getParameter("dtI");
		String txtDtS = request.getParameter("dtS");
		Integer txtFxe = Integer.parseInt(request.getParameter("faixaE"));
		
		Sessao sessao = new Sessao(txtValorM, txtValorI, txtDtI, txtDtS, txtFxe);
		return sessao;
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
				out.println("<h1>Sessao cadastrada!</h1>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
}
