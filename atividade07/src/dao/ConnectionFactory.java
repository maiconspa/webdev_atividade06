package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obtem conexao com o banco de dados
	public static Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/paises?useTimezone=true&serverTimezone=America/Sao_Paulo",
			"master",
			"*Quiki18@"
		);
	}
}
