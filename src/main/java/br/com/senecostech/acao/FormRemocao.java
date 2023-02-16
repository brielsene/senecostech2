package br.com.senecostech.acao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Produto;
import br.com.senecostech.dao.ProdutoDAO;
import br.com.senecostech.util.JPAUtil;

public class FormRemocao implements Acao {
	private EntityManager em = JPAUtil.getEntityManager();
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		Produto produto = produtoDAO.listaProdutoPeloId(Integer.valueOf(request.getParameter("id")));
		produto.setId(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("produto", produto);
		return "forward:formRemoveProduto.jsp";
	}

}
