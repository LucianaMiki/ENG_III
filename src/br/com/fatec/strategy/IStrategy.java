package br.com.fatec.strategy;

import br.com.fatec.dominio.EntidadeDominio;

public interface IStrategy {
	public String processar(EntidadeDominio entidade);
}