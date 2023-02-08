package br.com.senecostech.acao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Produto;
import br.com.senecostech.model.ProdutoDAO;

public class ListaProdutos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		ProdutoDAO produtoDAO;
		try {

			produtoDAO = new ProdutoDAO(new ConnectionFactory().getConnection());
			List<Produto> listaDeProduto = produtoDAO.listaProdutos();
			listaDeProduto.forEach(System.out::println);
			request.setAttribute("listaProdutos", listaDeProduto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "forward:listaProdutos.jsp";
	}

}
