package br.com.fatec.strategy;

import br.com.fatec.dao.FilmeDAO;
import br.com.fatec.dao.IDAO;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Filme;

public class ValidarLimiteFilme implements IStrategy {

    public String processar(EntidadeDominio entidade) {

        Filme filme = (Filme) entidade;
        IDAO dao = new FilmeDAO();
        
        if (dao.Consultar(filme).size() >= 7) {
            return "Numero limite de filmes cadastrados alcancado!";
        }

        return null;
    }

}
