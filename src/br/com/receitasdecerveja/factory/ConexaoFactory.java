package br.com.receitasdecerveja.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "gesconfig";
	private static final String URL = "jdbc:mysql://10.51.201.91:3306/receitas";
	
	public static Connection conectar() throws SQLException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
//	public static void main(String[] args) {
//		try{
//			Connection conexao  = ConexaoFactory.conectar();
//			System.out.println("Conexao realizada com sucesso!");
//		}catch(SQLException ex){
//			ex.printStackTrace();
//			System.out.println("N�o foi possivel realizar a conex�o!");
//		}
//	}
}
