package br.com.senecostech.model;

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
	
	

}
