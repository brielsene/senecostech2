package br.com.senecostech.acao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Produto;
import br.com.senecostech.dao.ProdutoDAO;
import br.com.senecostech.util.JPAUtil;

public class EditaProduto implements Acao {
	private EntityManager em = JPAUtil.getEntityManager();
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		em.getTransaction().begin();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		BigDecimal valor = new BigDecimal(Double.valueOf(request.getParameter("valor")));
		Integer id = Integer.valueOf(request.getParameter("id"));
		Produto produto = new Produto(id, nome, descricao, valor);
		produtoDAO.editaProdutoPeloId(produto);
		em.getTransaction().commit();
		
		
		produtoDAO.editaProdutoPeloId(produto);
		return "response:controller?acao=ListaProdutos";
	}

}
