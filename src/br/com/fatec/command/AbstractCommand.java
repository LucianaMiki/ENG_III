package br.com.fatec.command;

public abstract class AbstractCommand implements ICommand{
	
	protected IFachada fachada = new Fachada();

}