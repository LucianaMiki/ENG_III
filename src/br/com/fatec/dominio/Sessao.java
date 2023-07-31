package br.com.fatec.dominio;

public class Sessao extends EntidadeDominio{
    	private float valor_meia;
        private float valor_inteira;
        private String dt_inicio;
        private String dt_fim;
        private Integer fxe;
        private Integer salaId; 
        private Integer filmeId;

    public Sessao() {}
    
    public Sessao(float valor_meia, float valor_inteira, String dt_inicio, String dt_fim, Integer fxe) {
    	this.valor_meia = valor_meia;
    	this.valor_inteira = valor_inteira;
    	this.dt_inicio = dt_inicio;
    	this.dt_fim = dt_fim;
    	this.fxe = fxe;
    }
    
    public Sessao(float valor_meia, float valor_inteira, String dt_inicio, String dt_fim, Integer fxe, Integer salaId, Integer filmeId) {
    	this.valor_meia = valor_meia;
    	this.valor_inteira = valor_inteira;
    	this.dt_inicio = dt_inicio;
    	this.dt_fim = dt_fim;
    	this.fxe = fxe;
    	this.salaId = salaId;
    	this.filmeId = filmeId;
    }
        
    public float getValor_meia() {
        return valor_meia;
    }

    public void setValor_meia(float valor_meia) {
        this.valor_meia = valor_meia;
    }

    public float getValor_inteira() {
        return valor_inteira;
    }

    public void setValor_inteira(float valor_inteira) {
        this.valor_inteira = valor_inteira;
    }

    public String getDt_incio() {
        return dt_inicio;
    }

    public void setDt_incio(String dt_incio) {
        this.dt_inicio = dt_incio;
    }

    public String getDt_fim() {
        return dt_fim;
    }

    public void setDt_fim(String dt_fim) {
        this.dt_fim = dt_fim;
    }

    public int getFxe() {
        return fxe;
    }

    public void setFxe(int fxe) {
        this.fxe = fxe;
    }

    public Integer getSalaId() {
        return salaId;
    }

    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }

    public Integer getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Integer filmeId) {
        this.filmeId = filmeId;
    }


    
}
