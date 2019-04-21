package br.unipe.java;

public class Cliente {
	
	private String nome;
	private int idade;
	private boolean pessoaFisica;
	private boolean pessoaJuridica;
	
	// Constructor
	public Cliente(String nome, int idade, boolean pessoaFisica, boolean pessoaJuridica) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.pessoaFisica = pessoaFisica;
		this.pessoaJuridica = pessoaJuridica;
	}
	
	// Getters and Setters
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	public boolean isPessoaFisica() {
		return pessoaFisica;
	}
	public boolean isPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setPessoaFisica(boolean pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
		// The client can't be both
		this.pessoaJuridica = (pessoaFisica == true) ? false : true;
	}
	public void setPessoaJuridica(boolean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
		// The client can't be both
		this.pessoaFisica = (pessoaJuridica == true) ? false : true;
	}
}
