package br.com.senecostech.acao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.dao.ProdutoDAO;
import br.com.senecostech.util.JPAUtil;

public class RemoveProduto implements Acao {
	private EntityManager em = JPAUtil.getEntityManager();
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		em.getTransaction().begin();
		produtoDAO.removeProdutoPeloId(Integer.valueOf(request.getParameter("id")));
		System.out.println(Integer.valueOf(request.getParameter("id")));
		em.getTransaction().commit();
		em.close();
		return "redirect:controller?acao=ListaProdutos";
	}

}
