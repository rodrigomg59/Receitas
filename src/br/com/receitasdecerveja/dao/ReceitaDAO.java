package br.com.receitasdecerveja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.receitasdecerveja.domain.Receita;
import br.com.receitasdecerveja.domain.Usuario;
import br.com.receitasdecerveja.factory.ConexaoFactory;

public class ReceitaDAO {
	public void salvar(Receita r) throws SQLException {
		StringBuilder sql = new StringBuilder();
//		sql.append(" ");
		sql.append("INSERT INTO receita");
		sql.append("(nome, estilo, alcool, ibu, descricao, data, usuario_idusuario) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, r.getNome());
		comando.setString(2, r.getEstilo());
		comando.setDouble(3, r.getAlcool());
		comando.setInt(4, r.getIbu());
		comando.setString(5, r.getDescricao());
		comando.setString(6, r.getData());
		comando.setLong(7, r.getUsuario().getIdusuario());
		
		comando.executeUpdate();
	}
	
	public ArrayList<Receita> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT r.idreceita, r.nome, r.estilo, r.alcool, r.ibu, r.descricao, r.data, u.idusuario, u.nome ");
		sql.append("FROM receita r ");
		sql.append("INNER JOIN usuario u ON u.idusuario = r.usuario_idusuario ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Receita> lista = new ArrayList<Receita>();
		
		while(resultado.next()){
			Usuario u = new Usuario();
			u.setIdusuario(resultado.getLong("u.idusuario"));
			u.setNome(resultado.getString("u.nome"));
			
			Receita r = new Receita();
			r.setIdreceita(resultado.getLong("r.idreceita"));
			r.setNome(resultado.getString("r.nome"));
			r.setEstilo(resultado.getString("r.estilo"));
			r.setAlcool(resultado.getDouble("r.alcool"));
			r.setIbu(resultado.getInt("r.ibu"));
			r.setDescricao(resultado.getString("r.descricao"));
			r.setData(resultado.getString("r.data"));
			r.setUsuario(u);
			
			lista.add(r);
		}
		return lista;
	}
	
	public void excluir(Receita r) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM receita ");
		sql.append("WHERE idreceita = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, r.getIdreceita());
		
		comando.executeUpdate();
	}
	
	public void editar(Receita r) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE receita ");
		sql.append("SET nome = ? , estilo = ? , alcool = ? , ibu = ? , descricao = ? , data = ? , usuario_idusuario = ? ");
		sql.append("WHERE idusuario = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, r.getNome());
		comando.setString(2, r.getEstilo());
		comando.setDouble(3, r.getAlcool());
		comando.setInt(4, r.getIbu());
		comando.setString(5, r.getDescricao());
		comando.setString(6, r.getData());
		comando.setLong(7, r.getUsuario().getIdusuario());
		
		comando.executeUpdate();
	}
}
