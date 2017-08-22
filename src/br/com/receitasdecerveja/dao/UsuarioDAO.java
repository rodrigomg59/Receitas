package br.com.receitasdecerveja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.receitasdecerveja.domain.Usuario;
import br.com.receitasdecerveja.factory.ConexaoFactory;

public class UsuarioDAO {
	public void salvar(Usuario u) throws SQLException {
		StringBuilder sql = new StringBuilder();
//		sql.append(" ");
		sql.append("INSERT INTO usuario");
		sql.append("(usuario, senha, nome) ");
		sql.append("VALUES (?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, u.getUsuario());
		comando.setString(2, u.getSenha());
		comando.setString(3, u.getNome());
		
		comando.executeUpdate();
	}
	
	public ArrayList<Usuario> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idusuario, usuario, senha, nome ");
		sql.append("FROM usuario ");
		sql.append("ORDER BY usuario ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		while(resultado.next()){
			Usuario u = new Usuario();
			u.setIdusuario(resultado.getLong("idusuario"));
			u.setUsuario(resultado.getString("usuario"));
			u.setSenha(resultado.getString("senha"));
			u.setNome(resultado.getString("nome"));
			
			lista.add(u);
		}
		return lista;
	}
	
	public void excluir(Usuario u) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM usuario ");
		sql.append("WHERE idusuario = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1,u.getIdusuario());
		
		comando.executeUpdate();
	}
	
	public void editar(Usuario u) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE usuario ");
		sql.append("SET usuario = ? , senha = ? , nome = ? ");
		sql.append("WHERE idusuario = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, u.getUsuario());
		comando.setString(2, u.getSenha());
		comando.setString(3, u.getNome());
		
		comando.executeUpdate();
	}
	
	
}
