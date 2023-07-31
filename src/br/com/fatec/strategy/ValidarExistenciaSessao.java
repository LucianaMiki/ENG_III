package br.com.fatec.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.dao.IDAO;
import br.com.fatec.dao.SessaoDAO;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Filme;
import br.com.fatec.dominio.Sala;
import br.com.fatec.dominio.Sessao;

public class ValidarExistenciaSessao implements IStrategy {

    public String processar(EntidadeDominio entidade) {

        Sessao sessoes = new Sessao();
    	Sessao sessao = (Sessao) entidade;
        IDAO dao = new SessaoDAO();
        
        List<EntidadeDominio> list = new ArrayList<EntidadeDominio>();
        list = dao.Consultar(sessao);
        
        //System.out.println(list.get(1));
        
        //sessao = (Sessao) list.get(1);
        
        Float valor_meia = sessao.getValor_meia();
        Float valor_inteira = sessao.getValor_inteira();
        String dt_inicio = sessao.getDt_incio();
        String dt_fim = sessao.getDt_fim();
        Integer fxe = sessao.getFxe();
        Integer sala = sessao.getSalaId(); 
        Integer filme = sessao.getFilmeId();
        
        for(int i=0;i<list.size();i++) {
        	sessoes = (Sessao) list.get(i);
        	if(valor_meia == sessoes.getValor_meia() 
        			&& valor_inteira == sessoes.getValor_inteira()
        			&& dt_inicio == sessoes.getDt_incio()
        			&& dt_fim == sessoes.getDt_fim()
        			&& fxe == sessoes.getFxe()
        			&& sala == sessoes.getSalaId()
        			&& filme == sessoes.getFilmeId()) {
        		return "Sessao ja cadastrada!";
        	}    
        }
        return null;
    }

}
