package br.com.fatec.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fatec.command.AlterarCommand;
import br.com.fatec.command.ExcluirCommand;
import br.com.fatec.command.Fachada;
import br.com.fatec.command.ICommand;
import br.com.fatec.command.InserirCommand;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Filme;
import br.com.fatec.dominio.Sala;
import br.com.fatec.dominio.Sessao;
import br.com.fatec.viewhelper.IViewHelper;
import br.com.fatec.viewhelper.FilmeVH;
import br.com.fatec.viewhelper.SalaVH;
import br.com.fatec.viewhelper.SessaoVH;

public class InserirControle extends Controle {
	private static final long serialVersionUID = 1L;
	
	public InserirControle() {}
	
	public static String Inserir(HttpServletRequest request) {
		Fachada fachada = new Fachada();
		StringBuilder msg = new StringBuilder();
		
		Filme filme = new Filme();
		EntidadeDominio entidade = filme;
		entidade = FilmeVH.getEntidade(request);
		Filme filmePop = (Filme) entidade;
		msg.append(fachada.Inserir(filmePop));
		
		
		Sala sala = new Sala();
		entidade = sala;
		entidade = SalaVH.getEntidade(request);
		Sala salaPop = (Sala) entidade;
		msg.append(fachada.Inserir(salaPop));
		
		Sessao sessao = new Sessao();
		entidade = sessao;
		entidade = SessaoVH.getEntidade(request);
		Sessao sessaoPop = (Sessao) entidade;
		sessaoPop.setSalaId(salaPop.getId());
		sessaoPop.setFilmeId(filmePop.getId());
	
		msg.append(fachada.Inserir(sessaoPop));

		
		String result = msg.toString();
		
		return result;
		
	}
}