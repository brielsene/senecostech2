package br.com.senecostech.acao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Produto;
import br.com.senecostech.model.ProdutoDAO;

public class MostraProdutos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO(new ConnectionFactory().getConnection());
			Produto produto = produtoDAO.listaProdutoPeloId(id);
			produto.setId(id);
			System.out.println(produto);
			request.setAttribute("produto", produto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:formEditaProduto.jsp";
	}

}
