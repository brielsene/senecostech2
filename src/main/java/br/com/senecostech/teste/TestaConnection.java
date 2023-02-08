/**
 * 
 */
package br.com.senecostech.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.senecostech.model.ConnectionFactory;

/**
 * @author Gabriel
 *
 */
public class TestaConnection {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();

	}

}
