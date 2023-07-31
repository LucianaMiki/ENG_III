package br.com.fatec.dominio;

import java.sql.Time;

public class Filme extends EntidadeDominio {

    private String Titulo;
    private String Estreia;
    private String Duracao;
    private String Diretor;
    private String Elenco;
    private String Sinopse;
    
    public Filme(){}
    
    public Filme(String Titulo, String Estreia, String Duracao, String Diretor, String Elenco, String Sinopse){
    	this.Titulo = Titulo;
    	this.Estreia = Estreia;
    	this.Duracao = Duracao;
    	this.Diretor = Diretor;
    	this.Elenco = Elenco;
    	this.Sinopse = Sinopse;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getEstreia() {
        return Estreia;
    }

    public void setEstreia(String Estreia) {
        this.Estreia = Estreia;
    }

    public String getDuracao() {
        return Duracao;
    }

    public void setDuracao(String Duracao) {
        this.Duracao = Duracao;
    }

    public String getDiretor() {
        return Diretor;
    }

    public void setDiretor(String Diretor) {
        this.Diretor = Diretor;
    }

    public String getElenco() {
        return Elenco;
    }

    public void setElenco(String Elenco) {
        this.Elenco = Elenco;
    }

    public String getSinopse() {
        return Sinopse;
    }

    public void setSinopse(String Sinopse) {
        this.Sinopse = Sinopse;
    }

}