package br.com.fatec.command;

import br.com.fatec.dominio.EntidadeDominio;

public interface IFachada {
	public String Inserir(EntidadeDominio entidade);
	public String Alterar(EntidadeDominio entidade);
	public String Excluir(EntidadeDominio entidade);
	public String Consultar(EntidadeDominio entidade);

}
