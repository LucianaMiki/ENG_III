package br.com.fatec.dao;

import java.util.List;

import br.com.fatec.dominio.EntidadeDominio;

public interface IDAO {
	public void Inserir(EntidadeDominio entidade);
	public void Alterar(EntidadeDominio entidade);
	public void excluir(EntidadeDominio entidade);
	public List<EntidadeDominio> Consultar(EntidadeDominio entidade);
}