package br.com.senecostech.acao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Produto;
import br.com.senecostech.dao.ProdutoDAO;
import br.com.senecostech.util.JPAUtil;

public class MostraProdutos implements Acao {
	private EntityManager em = JPAUtil.getEntityManager();
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		em.getTransaction().begin();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		Produto produto = produtoDAO.listaProdutoPeloId(id);
		
		request.setAttribute("produto", produto);
		return "forward:formEditaProduto.jsp";
	}

}
