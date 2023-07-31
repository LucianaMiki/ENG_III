package br.com.fatec.command;

import br.com.fatec.dominio.EntidadeDominio;

public class InserirCommand extends AbstractCommand {

	public String executar(EntidadeDominio entidade) {
		return fachada.Inserir(entidade);
	}
}
