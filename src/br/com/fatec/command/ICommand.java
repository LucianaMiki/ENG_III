package br.com.fatec.command;

import br.com.fatec.dominio.EntidadeDominio;

public interface ICommand {
	public Object executar(EntidadeDominio entidade);
	
}
