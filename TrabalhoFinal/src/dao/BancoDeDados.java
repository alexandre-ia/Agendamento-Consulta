package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BancoDeDados {
	private static BancoDeDados instance;
	private Connection connection;
	
	 private static final String URL = "jdbc:postgresql://localhost:5432/Consultorio";
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
	    
	    public static void fecharConnection(Connection conn, PreparedStatement stmt) {
	       
	    	fecharConnection(conn);
	            try {
	            	if(stmt != null)
	            		stmt.close();
	               
	            } catch (SQLException e) {
	                System.err.println("Erro ao fechar conexão: " + e.getMessage());
	            }
	        }
	    
	    
	    public static void fecharConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
		       
	    	fecharConnection(conn, stmt);
	            try {
	            	if(rs != null)
	            		rs.close();
	               
	            } catch (SQLException e) {
	                System.err.println("Erro ao fechar conexão: " + e.getMessage());
	            }
	        }
	 

}
