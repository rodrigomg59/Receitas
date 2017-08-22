package br.com.receitasdecerveja.domain;

public class Imagem {
	private Long idimagem;
	private String caminho;
	private Receita receita;
	public Long getIdimagem() {
		return idimagem;
	}
	public void setIdimagem(Long idimagem) {
		this.idimagem = idimagem;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	
	
}
