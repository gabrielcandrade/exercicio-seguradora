package br.unipe.java;

public class Seguradora {
	
	private Cliente cliente;
	private Contrato contrato;
	private String endereco;
	private float valorDoImovel;
	private boolean zonaUrbana;
	private boolean zonaSubUrbana;
	private boolean zonaRural;
	private boolean tipoApartamento;
	private boolean tipoCasa;
	private int numeroDeFuncionarios;
	private int numeroDeVisitasDiarias;
	private boolean ramoComercio;
	private boolean ramoIndustria;
	private boolean ramoAgropecuaria;
	
	// Constructors
	
	// Residential contract insurer
	public Seguradora(Cliente cliente, Contrato contrato, String endereco, float valorDoImovel, boolean zonaUrbana,
			boolean zonaSubUrbana, boolean zonaRural, boolean tipoApartamento, boolean tipoCasa) {
		super();
		this.cliente = cliente;
		this.contrato = contrato;
		this.endereco = endereco;
		this.valorDoImovel = valorDoImovel;
		this.zonaUrbana = zonaUrbana;
		this.zonaSubUrbana = zonaSubUrbana;
		this.zonaRural = zonaRural;
		this.tipoApartamento = tipoApartamento;
		this.tipoCasa = tipoCasa;
	}

	// Business contract insurer
	public Seguradora(Cliente cliente, Contrato contrato, float valorDoImovel, int numeroDeFuncionarios,
			int numeroDeVisitasDiarias, boolean ramoComercio, boolean ramoIndustria, boolean ramoAgropecuaria) {
		super();
		this.cliente = cliente;
		this.contrato = contrato;
		this.valorDoImovel = valorDoImovel;
		this.numeroDeFuncionarios = numeroDeFuncionarios;
		this.numeroDeVisitasDiarias = numeroDeVisitasDiarias;
		this.ramoComercio = ramoComercio;
		this.ramoIndustria = ramoIndustria;
		this.ramoAgropecuaria = ramoAgropecuaria;
	}

	// Getters and Setters
	public Cliente getCliente() {
		return cliente;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public String getEndereco() {
		return endereco;
	}

	public float getValorDoImovel() {
		return valorDoImovel;
	}

	public boolean isZonaUrbana() {
		return zonaUrbana;
	}

	public boolean isZonaSubUrbana() {
		return zonaSubUrbana;
	}

	public boolean isZonaRural() {
		return zonaRural;
	}

	public boolean isTipoApartamento() {
		return tipoApartamento;
	}

	public boolean isTipoCasa() {
		return tipoCasa;
	}

	public int getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public int getNumeroDeVisitasDiarias() {
		return numeroDeVisitasDiarias;
	}

	public boolean isRamoComercio() {
		return ramoComercio;
	}

	public boolean isRamoIndustria() {
		return ramoIndustria;
	}

	public boolean isRamoAgropecuaria() {
		return ramoAgropecuaria;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setValorDoImovel(float valorDoImovel) {
		this.valorDoImovel = valorDoImovel;
	}

	public void setZonaUrbana(boolean zonaUrbana) {
		this.zonaUrbana = zonaUrbana;
		// The zone can't be the others one.
		this.zonaSubUrbana = (zonaUrbana == true) ? false : null;
		this.zonaRural = (zonaUrbana == true) ? false : null;
	}

	public void setZonaSubUrbana(boolean zonaSubUrbana) {
		this.zonaSubUrbana = zonaSubUrbana;
		// The zone can't be the others one.
		this.zonaUrbana = (zonaSubUrbana == true) ? false : null;
		this.zonaRural = (zonaSubUrbana == true) ? false : null;
	}

	public void setZonaRural(boolean zonaRural) {
		this.zonaRural = zonaRural;
		// The zone can't be the others one.
		this.zonaUrbana = (zonaRural == true) ? false : null;
		this.zonaSubUrbana = (zonaRural == true) ? false : null;
	}

	public void setTipoApartamento(boolean tipoApartamento) {
		this.tipoApartamento = tipoApartamento;
		this.tipoCasa = (tipoApartamento == true) ? false : true;
	}

	public void setTipoCasa(boolean tipoCasa) {
		this.tipoCasa = tipoCasa;
		this.tipoApartamento = (tipoCasa == true) ? false : true;
	}

	public void setNumeroDeFuncionarios(int numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public void setNumeroDeVisitasDiarias(int numeroDeVisitasDiarias) {
		this.numeroDeVisitasDiarias = numeroDeVisitasDiarias;
	}

	public void setRamoComercio(boolean ramoComercio) {
		this.ramoComercio = ramoComercio;
		// The branch can't be the others one.
		this.ramoIndustria = (ramoComercio == true) ? false : null;
		this.ramoAgropecuaria = (ramoComercio == true) ? false : null;
	}

	public void setRamoIndustria(boolean ramoIndustria) {
		this.ramoIndustria = ramoIndustria;
		// The branch can't be the others one.
		this.ramoComercio = (ramoIndustria == true) ? false : null;
		this.ramoAgropecuaria = (ramoIndustria == true) ? false : null;
	}

	public void setRamoAgropecuaria(boolean ramoAgropecuaria) {
		this.ramoAgropecuaria = ramoAgropecuaria;
		// The branch can't be the others one.
		this.ramoComercio = (ramoAgropecuaria == true) ? false : null;
		this.ramoIndustria = (ramoAgropecuaria == true) ? false : null;
	}
	
	public float calcularSeguroResidencial(Contrato contrado) {
		if (contrado.isResidencial() == true){
			float resultado = 0.02f;
			if (isZonaUrbana() == true) {
				resultado += 0.01f; 
			}
			else if (isZonaSubUrbana() == true || isTipoCasa() == true) {
				resultado += 0.005f;
			}
			return resultado * getValorDoImovel();
		}
		else {
			System.out.println("ERRO DE SISTEMA: Cálculo de seguro residencial para contrato de seguro empresarial.");
		}
		return 0f;
	}
	
	public float calcularSeguroEmpresarial(Contrato contrato) {
		if (contrato.isEmpresarial() == true) {
			float resultado = 0.04f;
			int porcentualCalculoFuncionario = (int)(numeroDeFuncionarios / 10);
			resultado += porcentualCalculoFuncionario * 0.002f;
			int qntdVisitasDiarias = (int)(numeroDeVisitasDiarias / 200);
			resultado += qntdVisitasDiarias * 0.003f;
			if (isRamoIndustria() == true) {
				resultado += 0.01f;
			}
			if (isRamoComercio() == true) {
				resultado += 0.005f;
			}
			return resultado * getValorDoImovel();
		}
		else {
			System.out.println("ERRO DE SISTEMA: Cálculo de seguro empresarial para contrato de seguro residencial.");
		}
		return 0f;
	}
}
