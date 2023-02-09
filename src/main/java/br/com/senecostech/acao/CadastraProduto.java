package br.com.senecostech.acao;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Produto;
import br.com.senecostech.model.ProdutoDAO;

public class CadastraProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String valorString = request.getParameter("valor");
//		BigDecimal valor = BigDecimal.valueOf(Double.valueOf(request.getParameter("valor")));
		System.out.println(nome+" - "+descricao+" - "+valorString);
		if(!(nome.isEmpty()|| descricao.isEmpty() || valorString.isEmpty()) )  {
			
			Produto produto = new Produto(request.getParameter("nome"),request.getParameter("descricao") ,BigDecimal.valueOf(Double.valueOf(request.getParameter("valor"))));
			
			try {
				ProdutoDAO produtoDAO = new ProdutoDAO(new ConnectionFactory().getConnection());
				produtoDAO.adicionaNovoProduto(produto);
				return "redirect:controller?acao=ListaProdutos";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
			System.out.println("deu erro em algo");
			return "redirect:controller?acao=FormCadastraProduto" ;
		
		
		
	}

}
