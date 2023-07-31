package br.com.fatec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	
	public static void main(String args[]) {
		try {
			if(getConnectionPostgres() !=null)
				System.out.println("CONECTADO!!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static Connection getConnectionPostgres() throws ClassNotFoundException, SQLException {
		driver = "org.postgresql.Driver";
		url = "jdbc:postgresql://localhost:5432/esIII";
		user = "postgres";
		password = "12e45";
		Class.forName(driver);
		Connection conexao = DriverManager.getConnection(url, user, password);
		return conexao;
	}

}
