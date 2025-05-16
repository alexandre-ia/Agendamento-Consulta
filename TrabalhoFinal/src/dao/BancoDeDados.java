package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
	
	 private static final String URL = "jdbc:postgresql://localhost:5432/AtvPOO";
	 private static final String USER = "postgres";
	 private static final String PASS = "1234";
	 
	 
	// Método estático para obter conexão
	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASS);
	    }

	    // Método para fechar conexão (opcional, mas recomendado)
	    public static void fecharConnection(Connection conn) {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                System.err.println("Erro ao fechar conexão: " + e.getMessage());
	            }
	        }
	    }
	 

}
