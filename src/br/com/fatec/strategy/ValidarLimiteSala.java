package br.com.fatec.strategy;

import br.com.fatec.dao.IDAO;
import br.com.fatec.dao.SalaDAO;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Sala;

public class ValidarLimiteSala implements IStrategy{
    public String processar(EntidadeDominio entidade) {

        Sala sala = (Sala) entidade;
	IDAO dao = new SalaDAO();
	if(dao.Consultar(sala).size() >= 7) {
	return "Limite de Sala ja atingido!";
	}
	return null;
    }
}
