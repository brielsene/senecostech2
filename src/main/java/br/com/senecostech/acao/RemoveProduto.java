package br.com.senecostech.acao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.ProdutoDAO;

public class RemoveProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO(new ConnectionFactory().getConnection());
			produtoDAO.removeProdutoPelod(Integer.valueOf(request.getParameter("id")));
			System.out.println(Integer.valueOf(request.getParameter("id")));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:controller?acao=ListaProdutos";
	}

}
