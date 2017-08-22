package br.com.receitasdecerveja.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.receitasdecerveja.dao.UsuarioDAO;
import br.com.receitasdecerveja.domain.Usuario;
import br.com.receitasdecerveja.util.JSFUtil;


@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {
	private Usuario usuario;
	private ArrayList<Usuario> itens;
	private ArrayList<Usuario> itensFiltrados;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ArrayList<Usuario> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Usuario> itens) {
		this.itens = itens;
	}
	public ArrayList<Usuario> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Usuario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			itens = dao.listar();			
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararNovo(){
		usuario = new Usuario();
	}
	
	public void novo() {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuario);
			
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Usuário salvo com sucesso.");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void excluir(){
		try{
			UsuarioDAO dao = new UsuarioDAO();
			dao.excluir(usuario);
			
			itens = dao.listar();	
			
			JSFUtil.adicionarMensagemSucesso("Usuário removido com sucesso.");
		}catch(SQLException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			UsuarioDAO dao = new UsuarioDAO();
			dao.editar(usuario);
		
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Usuário editado com sucesso.");
		}catch(SQLException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
}
