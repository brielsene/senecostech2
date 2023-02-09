package br.com.senecostech.acao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Produto;
import br.com.senecostech.model.ProdutoDAO;

public class EditaProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO(new ConnectionFactory().getConnection());
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			BigDecimal valor = new BigDecimal(Double.valueOf(request.getParameter("valor")));
			Integer id = Integer.valueOf(request.getParameter("id"));
			Produto produto = new Produto(id, nome, descricao, valor);
			
			System.out.println(nome+" - "+descricao+" - "+valor+" - "+id);
			produtoDAO.editaProdutoPeloId(produto);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "response:controller?acao=ListaProdutos";
	}

}
