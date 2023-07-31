package br.com.fatec.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
import br.com.fatec.dao.FilmeDAO;
import br.com.fatec.dao.IDAO;
import br.com.fatec.dao.SalaDAO;
import br.com.fatec.dao.SessaoDAO;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Filme;
import br.com.fatec.dominio.Sala;
import br.com.fatec.dominio.Sessao;
import br.com.fatec.viewhelper.IViewHelper;
import br.com.fatec.viewhelper.FilmeVH;
import br.com.fatec.viewhelper.SalaVH;
import br.com.fatec.viewhelper.SessaoVH;

public class ExcluirControle extends Controle {
	private static final long serialVersionUID = 1L;
	
	public ExcluirControle() {}

	public static String Excluir(HttpServletRequest request, String operacao) {
		// TODO Auto-generated method stub
		Fachada fachada = new Fachada();
		StringBuilder msg = new StringBuilder();
		
		Filme filme = new Filme();
		Sala sala = new Sala();
		Sessao sessao = new Sessao();
		
		Integer numSalaCerta = Integer.parseInt(operacao.substring(13));
		
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
		
        Integer IdSala = null;
        Integer CodigoSala = null;
        
        for(int i=0;i<listSala.size();i++) {
	        sala = (Sala) listSala.get(i);
	        
	        Integer numSala = Integer.parseInt(sala.getCodigo());
	        	
	        if(numSala == numSalaCerta) {
	        	IdSala = sala.getId();
	        	CodigoSala = Integer.parseInt(sala.getCodigo());
	        }	
	     }
        
        Sala salaPop = (Sala) entidadeSala;
        if(IdSala != null) {
        	salaPop.setCodigo(CodigoSala.toString());
        	salaPop.setId(IdSala);
        	msg.append(fachada.Excluir(salaPop));
        }else if(IdSala == null) {
        	msg.append("Esta sala ja esta vazia!");
        }
        
        
		
		Integer IdFilmeCerto = null;
		Integer IdSessaoSala = null;
		
		for(int i=0;i<listSessao.size();i++) {
	        sessao = (Sessao) listSessao.get(i);
	        
	        Integer numSalaId = sessao.getSalaId();
	        Integer numSalaIdCerto = salaPop.getId();
	        	
	        if(numSalaId == numSalaIdCerto) {
	        	IdSessaoSala = sessao.getSalaId();
	        	IdFilmeCerto = sessao.getFilmeId();
	        }	
	     }
		
		Sessao sessaoPop = (Sessao) entidadeSessao;
		if(IdSessaoSala != null) {
			sessaoPop.setSalaId(IdSessaoSala);
			msg.append(fachada.Excluir(sessaoPop));
		}
		
		
		
		Filme filmePop = (Filme) entidadeFilme;
		if(IdFilmeCerto != null) {
			filmePop.setId(IdFilmeCerto);
			msg.append(fachada.Excluir(filmePop));
		}
		
		
		String result = msg.toString();
		
		return result;
	
	}
}