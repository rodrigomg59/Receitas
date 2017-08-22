package br.com.receitasdecerveja.domain;

public class Nota {
	private Long idnota;
	private Long aparencia;
	private Long aroma;
	private Long sabor;
	private Long sensacao;
	private Long conjunto;
	private Receita receita;

	public Long getIdnota() {
		return idnota;
	}

	public void setIdnota(Long idnota) {
		this.idnota = idnota;
	}

	public Long getAparencia() {
		return aparencia;
	}

	public void setAparencia(Long aparencia) {
		this.aparencia = aparencia;
	}

	public Long getAroma() {
		return aroma;
	}

	public void setAroma(Long aroma) {
		this.aroma = aroma;
	}

	public Long getSabor() {
		return sabor;
	}

	public void setSabor(Long sabor) {
		this.sabor = sabor;
	}

	public Long getSensacao() {
		return sensacao;
	}

	public void setSensacao(Long sensacao) {
		this.sensacao = sensacao;
	}

	public Long getConjunto() {
		return conjunto;
	}

	public void setConjunto(Long conjunto) {
		this.conjunto = conjunto;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

}
