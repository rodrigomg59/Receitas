package br.com.receitasdecerveja.test;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import br.com.receitasdecerveja.dao.UsuarioDAO;
import br.com.receitasdecerveja.domain.Usuario;

public class UsuarioDAOTeste {
	
	@Test
	@Ignore
	public void salvar() throws SQLException{
		Usuario u = new Usuario();
		u.setNome("Rodrigo Martins de Souza");
		u.setSenha("123");
		u.setUsuario("rodrigoms");
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(u);
	}
}
