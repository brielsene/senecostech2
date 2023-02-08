package br.com.senecostech.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dataSource;
	
	public ConnectionFactory() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComboPooledDataSource cp = new ComboPooledDataSource();
		cp.setJdbcUrl("jdbc:mysql://localhost/senecostech?useTimezone=true&serverTimezone=UTC");
		cp.setUser("root");
		cp.setPassword("root");
		cp.setMaxPoolSize(60);
		this.dataSource = cp;
	}
	
	public Connection getConnection()throws SQLException{
		
		return this.dataSource.getConnection();
	}
	
	

}
