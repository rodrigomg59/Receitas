package br.com.receitasdecerveja.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.receitasdecerveja.dao.ImagemDAO;
import br.com.receitasdecerveja.domain.Imagem;
import br.com.receitasdecerveja.domain.Receita;

public class ImagemDAOTeste {

	@Test
	@Ignore
	public void salvar() throws SQLException{
		Receita r = new Receita();
		r.setIdreceita(1L);
		
		Imagem i = new Imagem();
		i.setCaminho("lupúlo.png");
		i.setReceita(r);

		ImagemDAO dao = new ImagemDAO();
		dao.salvar(i);
	}
	
	@Test
	public void listar()throws SQLException {
		ImagemDAO dao = new ImagemDAO(); 
		
		ArrayList<Imagem> lista = dao.listar();
		
		for(Imagem i : lista){
			System.out.println("Código da imagem: " + i.getIdimagem());
			System.out.println("Caminho da imagem: " + i.getCaminho());
			System.out.println("Id da receita: " + i.getReceita());
			System.out.println();
		}
	}
}
