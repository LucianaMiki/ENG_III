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

public class EditarControle extends Controle {
	private static final long serialVersionUID = 1L;
	
	public EditarControle() {}
	
	public static List<String> Editar(HttpServletRequest request, HttpServletResponse response, String operacao) {	
		Fachada fachada = new Fachada();
		StringBuilder msg = new StringBuilder();

		Integer numSalaCerta = Integer.parseInt(operacao.substring(13));
		
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
        
        Integer IdSala = null;
        Integer CodigoJSP = null;
        String TipoJSP = null;
        Integer CapacidadeJSP = null;
        
        Integer IdSessao = null;
        Float valor_meiaJSP = null;
        Float valor_inteiraJSP = null;
        String dt_inicioJSP = null;
        String dt_fimJSP = null;
        Integer fxeJSP = null;
        
        Integer IdFilme = null;
        String TituloJSP = null;
        String EstreiaJSP = null;
        String DuracaoJSP = null;
        String DiretorJSP = null;
        String ElencoJSP = null;
        String SinopseJSP = null;
        
	    for(int i=0;i<listSala.size();i++) {
	        sala = (Sala) listSala.get(i);
	        	
	        Integer numSala = Integer.parseInt(sala.getCodigo());
	        	
	        if(numSala == numSalaCerta) {
	        	IdSala = sala.getId();
	        	CodigoJSP = numSala;
	        	TipoJSP = sala.getTipo();
	        	CapacidadeJSP = sala.getCapacidade();	
	        }	
	     }
	    
	    if(CodigoJSP != null) {
	    	for(int i=0;i<listSessao.size();i++) {
	    		sessao = (Sessao) listSessao.get(i);
	    		Integer IdSessaoIf = sessao.getSalaId();
	    		if(IdSala == IdSessaoIf) {
	    			IdSessao = sessao.getId();
	    			valor_meiaJSP = sessao.getValor_meia();
	    			valor_inteiraJSP = sessao.getValor_inteira();
	    			dt_inicioJSP = sessao.getDt_incio();
	    			dt_fimJSP = sessao.getDt_fim();
	    			fxeJSP = sessao.getFxe();
	    			IdFilme = sessao.getFilmeId();
	    		}  		
	    	}
	    }
	    
	    if(IdSessao != null) {
	    	for(int i=0;i<listFilme.size();i++) {
	    		filme = (Filme) listFilme.get(i);
	    		Integer IdFilmeIf = filme.getId();
	    		if(IdFilme == IdFilmeIf) {
	    			TituloJSP = filme.getTitulo();
	    	        EstreiaJSP = filme.getEstreia();
	    	        DuracaoJSP = filme.getDuracao();
	    	        DiretorJSP = filme.getDiretor();
	    	        ElencoJSP = filme.getElenco();
	    	        SinopseJSP = filme.getSinopse();
	    		}
	    	}
	    }
	    
	    List<String> lista = new ArrayList<String>(); 
	    lista.add(CodigoJSP.toString());
	    lista.add(TipoJSP.toString());
	    lista.add(CapacidadeJSP.toString());
	    lista.add(valor_meiaJSP.toString());
	    lista.add(valor_inteiraJSP.toString());
	    lista.add(dt_inicioJSP.toString());
	    lista.add(dt_fimJSP.toString());
	    lista.add(fxeJSP.toString());
	    lista.add(TituloJSP.toString());
	    lista.add(EstreiaJSP.toString());
	    lista.add(DuracaoJSP.toString());
	    lista.add(DiretorJSP.toString());
	    lista.add(ElencoJSP.toString());
	    lista.add(SinopseJSP.toString());

	    request.setAttribute("Codigo", lista.get(0));
	    request.setAttribute("Tipo", lista.get(1));
    	request.setAttribute("Capacidade", lista.get(2));
    	request.setAttribute("vm", lista.get(3));
    	request.setAttribute("vi", lista.get(4));
    	request.setAttribute("dti", lista.get(5));
    	request.setAttribute("dtf", lista.get(6));
    	request.setAttribute("fxe", lista.get(7));
    	request.setAttribute("Titulo", lista.get(8));
    	request.setAttribute("Estreia", lista.get(9));
    	request.setAttribute("Duracao", lista.get(10));
    	request.setAttribute("Diretor", lista.get(11));
    	request.setAttribute("Elenco", lista.get(12));
    	request.setAttribute("Sinopse", lista.get(13));
	    return lista;
	}
	
	public static String Alterar (HttpServletRequest request) {
		Fachada fachada = new Fachada();
		StringBuilder msg = new StringBuilder();
		
		Filme filme = new Filme();
		Sala sala = new Sala();
		Sessao sessao = new Sessao();
		
		EntidadeDominio entidade = sala;
		entidade = SalaVH.getEntidade(request);
		Sala salaPop = (Sala) entidade;	
		msg.append(fachada.Alterar(salaPop));
		
		Integer numSala = Integer.parseInt(salaPop.getCodigo());
		
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
        
        for(int i=0;i<listSala.size();i++) {
	        sala = (Sala) listSala.get(i);
	        
	        Integer numSalaCerta = Integer.parseInt(sala.getCodigo());
	        	
	        if(numSala == numSalaCerta) {
	        	IdSala = sala.getId();	
	        }	
	     }
        
        if(IdSala != null) {
        	salaPop.setId(IdSala);
        }
        
		entidade = sessao;
		entidade = SessaoVH.getEntidade(request);
		Sessao sessaoPop = (Sessao) entidade;
		sessaoPop.setSalaId(salaPop.getId());
	
		msg.append(fachada.Alterar(sessaoPop));
		
		Integer IdFilme = null;
		
		for(int i=0;i<listSessao.size();i++) {
	        sessao = (Sessao) listSessao.get(i);
	        
	        Integer numSalaId = sessao.getSalaId();
	        Integer numSalaIdCerto = sessaoPop.getSalaId();
	        	
	        if(numSalaId == numSalaIdCerto) {
	        	IdFilme = sessao.getFilmeId();
	        }	
	     }
		
		entidade = filme;
		entidade = FilmeVH.getEntidade(request);
		Filme filmePop = (Filme) entidade;
		filmePop.setId(IdFilme);
		msg.append(fachada.Alterar(filmePop));

		String result = msg.toString();
	
		return result;
		
	}
}
