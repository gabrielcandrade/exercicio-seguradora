package br.unipe.java;

public class Sinistro {
	
	private Contrato contrato;
	private String data;
	private int porcentagemDePerca;
	
	// Constructor
	public Sinistro(Contrato contrato, String data, int porcentagemDePerca) {
		super();
		this.contrato = contrato;
		this.data = data;
		this.porcentagemDePerca = porcentagemDePerca;
	}
	
	// Getters and Setters
	public Contrato getContrato() {
		return contrato;
	}
	public String getData() {
		return data;
	}
	public int getPorcentagemDePerca() {
		return porcentagemDePerca;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setPorcentagemDePerca(int porcentagemDePerca) {
		this.porcentagemDePerca = porcentagemDePerca;
	}

}
