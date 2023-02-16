package br.com.senecostech.acao;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.dao.ProdutoDAO;
import br.com.senecostech.model.Produto;
import br.com.senecostech.util.JPAUtil;

public class CadastraProduto implements Acao {
	private EntityManager em = JPAUtil.getEntityManager();
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String valorString = request.getParameter("valor");
//		BigDecimal valor = BigDecimal.valueOf(Double.valueOf(request.getParameter("valor")));
		System.out.println(nome+" - "+descricao+" - "+valorString);
		if(!(nome.isEmpty()|| descricao.isEmpty() || valorString.isEmpty()) )  {
			
			Produto produto = new Produto(request.getParameter("nome"),request.getParameter("descricao") ,BigDecimal.valueOf(Double.valueOf(request.getParameter("valor"))));
			
			em.getTransaction().begin();
			ProdutoDAO produtoDAO = new ProdutoDAO(em);
			produtoDAO.cadastraProdutoNovo(produto);
			em.getTransaction().commit();
			em.close();
			return "redirect:controller?acao=ListaProdutos";
			
		}
			System.out.println("deu erro em algo");
			return "redirect:controller?acao=FormCadastraProduto" ;
		
		
		
	}

}
