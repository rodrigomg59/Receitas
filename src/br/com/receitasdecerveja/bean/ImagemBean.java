package br.com.receitasdecerveja.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.receitasdecerveja.dao.ImagemDAO;
import br.com.receitasdecerveja.domain.Imagem;
import br.com.receitasdecerveja.util.JSFUtil;

@ManagedBean(name = "MBImagem")
@ViewScoped
public class ImagemBean {
	private Imagem imagem;
	private ArrayList<Imagem> itens;
	private ArrayList<Imagem> itensFiltrados;
	public Imagem getImagem() {
		return imagem;
	}
	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	public ArrayList<Imagem> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Imagem> itens) {
		this.itens = itens;
	}
	public ArrayList<Imagem> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Imagem> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			ImagemDAO dao = new ImagemDAO();
			itens = dao.listar();			
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
}
