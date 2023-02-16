package br.com.senecostech.acao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Produto;
import br.com.senecostech.dao.ProdutoDAO;
import br.com.senecostech.model.Testinho;
import br.com.senecostech.util.JPAUtil;

public class ListaProdutos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		ProdutoDAO produtoDAO = new ProdutoDAO(JPAUtil.getEntityManager());
		List<Produto> listaDeProduto = produtoDAO.getProdutos();
		
		request.setAttribute("listaProdutos", listaDeProduto);

		return "forward:listaProdutos.jsp";
	}

}
