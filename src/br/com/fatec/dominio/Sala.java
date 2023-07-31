package br.com.fatec.dominio;

public class Sala extends EntidadeDominio{

    private String Codigo;
    private String Tipo;
    private Integer Capacidade;

    public Sala() {
		super();
	}

    public Sala(String Codigo, String Tipo, Integer Capacidade){
        super();
        this.Codigo = Codigo;
        this.Tipo = Tipo;
        this.Capacidade = Capacidade;
    }

    public String getCodigo(){
        return Codigo;
    }
    
    public void setCodigo(String Codigo){
        this.Codigo = Codigo;
    }

    public String getTipo(){
        return Tipo;
    }

    public void setTipo(String Tipo){
        this.Tipo = Tipo;
    }

    public Integer getCapacidade(){
        return Capacidade;
    }
    
    public void setCapacidade(Integer Capacidade){
        this.Capacidade = Capacidade;
    }

}