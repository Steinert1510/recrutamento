package br.com.desafio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {
	
	private static ConexaoUtil conexaoUtil;
	
	public static ConexaoUtil getInstance() {
		if (conexaoUtil == null) {
			conexaoUtil= new ConexaoUtil();
		}
		return conexaoUtil;
		
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/selecao?useTimezone=true&serverTimezone=America/Sao_Paulo","root","");
	}
	
	public static void main(String[] args) {
		try {
		System.out.println(getInstance().getConnection());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
	 
	