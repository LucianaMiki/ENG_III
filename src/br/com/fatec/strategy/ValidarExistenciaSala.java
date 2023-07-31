package br.com.fatec.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.dao.IDAO;
import br.com.fatec.dao.SalaDAO;
import br.com.fatec.dao.SessaoDAO;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Sala;
import br.com.fatec.dominio.Sessao;

public class ValidarExistenciaSala implements IStrategy {
	
	public String processar(EntidadeDominio entidade) {
	Sala salas = new Sala();
	Sala sala = (Sala) entidade;
    IDAO dao = new SalaDAO();
    
    List<EntidadeDominio> list = new ArrayList<EntidadeDominio>();
    list = dao.Consultar(sala);
    //System.out.println(list.get(1));
    
    //sessao = (Sessao) list.get(1);
    
    String Codigo = sala.getCodigo();
    String Tipo = sala.getTipo();
    Integer Capacidade = sala.getCapacidade();
    
    for(int i=0;i<list.size();i++) {
    	salas = (Sala) list.get(i);
    	if(Codigo == salas.getCodigo()) {
    		return "Esta sala ja esta ocupada, por favor escolha outra!";
    	}
    	if(Codigo == salas.getCodigo() && Tipo == salas.getTipo() && Capacidade == sala.getCapacidade()) {
    		return "Sala ja cadastrada!";
    	}    
    }
		return null;
	}

}
