package br.com.senecostech.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

	private Connection conn;
	private String sql;

	public UsuarioDAO(Connection conn) {
		this.conn = conn;

	}

	public Usuario verificiaLogin(Usuario usuario) throws SQLException {
		sql = "SELECT LOGIN, SENHA FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getSenha());
			
			stm.execute();
			
			try(ResultSet rs = stm.getResultSet()){
				while(rs.next()) {
					Usuario u1 = new Usuario(rs.getString(1),rs.getString(2));
					if(!(u1.getLogin().isEmpty() & u1.getSenha().isEmpty())) {
						System.out.println(u1.getLogin() +u1.getSenha());

						return u1;
					}
				}
			}
		}
		
		return null;

	}

}
