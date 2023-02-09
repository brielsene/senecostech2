package br.com.senecostech.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
	private Connection conn;
	private String sql;
	private List<Produto>listaDeProdutos = new ArrayList<>();
	
	
	public ProdutoDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public List<Produto>listaProdutos () throws SQLException{
	
		
		sql = "SELECT * FROM PRODUTO";
		try(PreparedStatement stm = conn.prepareStatement(sql)){
			stm.execute();
			try(ResultSet rs = stm.getResultSet()){
				while(rs.next()) {
					Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
					listaDeProdutos.add(produto);
				}
			}
			
		}
		return listaDeProdutos;
	}
	
	public Produto listaProdutoPeloId (Integer id) throws SQLException {
		sql = "SELECT NOME, DESCRICAO, VALOR FROM PRODUTO WHERE ID = ?";
		Produto produto = null;
		try(PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setInt(1, id);
			stm.execute();
			try(ResultSet rs = stm.getResultSet()){
				while(rs.next()) {
					 produto = new Produto(rs.getString(1), rs.getString(2), rs.getBigDecimal(3));
				}
			}
		}return produto;
	}
	
	public void editaProdutoPeloId(Produto produto)throws SQLException {
		sql = "UPDATE PRODUTO SET NOME = ?, DESCRICAO = ?, VALOR = ? WHERE ID = ?";
		try(PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setString(1,produto.getNome() );
			stm.setString(2, produto.getDescricao());
			stm.setBigDecimal(3, produto.getValor());
			stm.setInt(4, produto.getId());
			stm.execute();
			
			int i = stm.getUpdateCount();
			if(i == 1) {
				System.out.println("Edição alterada com sucesso");
			}
			
		}
	}
	
	public void removeProdutoPelod(Integer id)throws SQLException{
		sql = "DELETE FROM PRODUTO WHERE ID = ?";
		try(PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setInt(1, id);
			stm.execute();
			int linhasAlteradas = stm.getUpdateCount();
			if(linhasAlteradas != 0) {
				System.out.println("Produto com id: "+id+", Removido com sucesso");
			}
		}
	}
	
	public void adicionaNovoProduto(Produto produto)throws SQLException {
		sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, VALOR)VALUES(?, ?, ?)";
		try(PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.setBigDecimal(3, produto.getValor());
			stm.execute();
			int linhasAlteradas = stm.getUpdateCount();
			if(linhasAlteradas != 0) {
				System.out.println(produto.getNome()+", Adicionado com sucesso");
				
			}
			
		}
	}
	
	

}
