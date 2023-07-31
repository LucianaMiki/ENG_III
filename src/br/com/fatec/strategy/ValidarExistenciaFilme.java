package br.com.fatec.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.dao.FilmeDAO;
import br.com.fatec.dao.IDAO;
import br.com.fatec.dao.SessaoDAO;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Filme;
import br.com.fatec.dominio.Sessao;

public class ValidarExistenciaFilme implements IStrategy {

    public String processar(EntidadeDominio entidade) {
    	if(entidade instanceof Filme) {
	    	Filme filmes = new Filme();
	    	Filme filme = (Filme) entidade;
	        IDAO dao = new FilmeDAO();
	        
	        List<EntidadeDominio> list = new ArrayList<EntidadeDominio>();
	        list = dao.Consultar(filme);
	        
	        //System.out.println(list.get(1));
	        
	        //sessao = (Sessao) list.get(1);
	        
	        String Titulo = filme.getTitulo();
	        String Estreia = filme.getEstreia();
	        String Duracao = filme.getDuracao();
	        String Diretor = filme.getDiretor();
	        String Elenco = filme.getElenco();
	        String Sinopse = filme.getSinopse();
	        
	        for(int i=0;i<list.size();i++) {
	        	filmes = (Filme) list.get(i);
	        	if(Titulo == filmes.getTitulo()
	        			&& Estreia == filmes.getEstreia()
	        			&& Duracao == filmes.getDuracao()
	        			&& Diretor == filmes.getDiretor()
	        			&& Elenco == filmes.getElenco()
	        			&& Sinopse == filmes.getSinopse()) {
	        		return "Filme ja cadastrado!";
	        	}    
	        }
    	}
	        
	 return null;
    	
    }

}
