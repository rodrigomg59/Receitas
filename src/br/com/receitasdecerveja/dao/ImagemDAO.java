package br.com.receitasdecerveja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.receitasdecerveja.domain.Imagem;
import br.com.receitasdecerveja.domain.Receita;
import br.com.receitasdecerveja.factory.ConexaoFactory;

public class ImagemDAO {
	public void salvar(Imagem i) throws SQLException {
		StringBuilder sql = new StringBuilder();
//		sql.append(" ");
		sql.append("INSERT INTO imagem");
		sql.append("(caminho, receita_idreceita) ");
		sql.append("VALUES (?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, i.getCaminho());
		comando.setLong(2, i.getReceita().getIdreceita());
		
		comando.executeUpdate();
	}
	
	public ArrayList<Imagem> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT i.idimagem, i.caminho, r.idreceita ");
		sql.append("FROM imagem i ");
		sql.append("INNER JOIN receita r ON r.idreceita = i.receita_idreceita ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Imagem> lista = new ArrayList<Imagem>();
		
		while(resultado.next()){
			Receita r = new Receita();
			r.setIdreceita(resultado.getLong("r.idreceita"));
			
			Imagem i = new Imagem();
			i.setIdimagem(resultado.getLong("i.idimagem"));
			i.setCaminho(resultado.getString("i.caminho"));
			i.setReceita(r);
			
			lista.add(i);
		}
		return lista;
	}
}
