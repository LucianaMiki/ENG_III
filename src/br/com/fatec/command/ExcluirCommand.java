package br.com.fatec.command;

import br.com.fatec.dominio.EntidadeDominio;

public class ExcluirCommand extends AbstractCommand {

	@Override
	public Object executar(EntidadeDominio entidade) {
		return fachada.Excluir(entidade);
	}

}
