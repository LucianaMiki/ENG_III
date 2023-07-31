package br.com.fatec.viewhelper;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.dominio.EntidadeDominio;

public interface IViewHelper {
	
	public static EntidadeDominio getEntidade(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setView(Object resultado,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException;

}