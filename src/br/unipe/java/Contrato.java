package br.unipe.java;

public class Contrato {
	
	private String nome;
	private String validade;
	private boolean residencial;
	private boolean empresarial;
	
	public Contrato(String nome, String validade, boolean residencial, boolean empresarial) {
		super();
		this.nome = nome;
		this.validade = validade;
		this.residencial = residencial;
		this.empresarial = empresarial;
	}
	
	// Getters and Setters
	public String getNome() {
		return nome;
	}
	public String getValidade() {
		return validade;
	}
	public boolean isResidencial() {
		return residencial;
	}
	public boolean isEmpresarial() {
		return empresarial;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public void setResidencial(boolean residencial) {
		this.residencial = residencial;
		// The contract can't be both
		this.empresarial = (residencial == true) ? false : true;
	}
	public void setEmpresarial(boolean empresarial) {
		this.empresarial = empresarial;
		// The contract can't be both
		this.residencial = (empresarial == true) ? false : true;
	}
}
