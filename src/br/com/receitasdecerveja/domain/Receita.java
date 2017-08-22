package br.com.receitasdecerveja.domain;

public class Receita {
	private Long idreceita;
	private String nome;
	private String estilo;
	private Double alcool;
	private int ibu;
	private String descricao;
	private String data;
	private Usuario usuario;

	public Long getIdreceita() {
		return idreceita;
	}

	public void setIdreceita(Long idreceita) {
		this.idreceita = idreceita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public Double getAlcool() {
		return alcool;
	}

	public void setAlcool(Double alcool) {
		this.alcool = alcool;
	}

	public int getIbu() {
		return ibu;
	}

	public void setIbu(int ibu) {
		this.ibu = ibu;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
