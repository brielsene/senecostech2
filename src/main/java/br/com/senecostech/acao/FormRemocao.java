package br.com.senecostech.acao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Produto;
import br.com.senecostech.model.ProdutoDAO;

public class FormRemocao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO(new ConnectionFactory().getConnection());
			Produto produto = produtoDAO.listaProdutoPeloId(Integer.valueOf(request.getParameter("id")));
			produto.setId(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("produto", produto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:formRemoveProduto.jsp";
	}

}
