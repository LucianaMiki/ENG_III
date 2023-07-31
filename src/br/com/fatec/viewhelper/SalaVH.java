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

public class SalaVH implements IViewHelper {

	public static EntidadeDominio getEntidade(HttpServletRequest request) {
		String txtCodigo = request.getParameter("txtCodigo");
		String txtTipo = request.getParameter("tipo");
		Integer txtCapacidade = Integer.parseInt(request.getParameter("capacidade"));
		
		Sala sala = new Sala(txtCodigo, txtTipo, txtCapacidade);
		return sala;
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
				out.println("<h1>Sala cadastrada!</h1>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
}
