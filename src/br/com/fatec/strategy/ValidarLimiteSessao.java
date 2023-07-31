package br.com.fatec.strategy;

import br.com.fatec.dao.IDAO;
import br.com.fatec.dao.SessaoDAO;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Sessao;

public class ValidarLimiteSessao implements IStrategy {

    public String processar(EntidadeDominio entidade) {

        Sessao sessao = (Sessao) entidade;
        IDAO dao = new SessaoDAO();

        if (dao.Consultar(sessao).size() >= 7) {
            return "Limite de Sessao ja atingido!";
        }

        return null;
    }

}