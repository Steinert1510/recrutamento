package br.com.evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.ConexaoUtil;


public class control_Sala2 {

	public static void inserir(Sala2 sal2) {
		try {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		
		String sql  = "insert into Sala2(id,className,qtdPessoas)values (?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
	
		statement.setInt(1, sal2.getId());
		statement.setString(2, sal2.getClassName());
		statement.setInt(3, sal2.getQtdPessoas());
		
		
		statement.execute();
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static  void remover(String id) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "delete from Sala2 where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, id);
			
			statement.execute();
			statement.close();
		}catch (Exception e) {
		}
	}
	  public static  List<Sala2> listarTudo(){
		
		List<Sala2> listarSala2 = new ArrayList<Sala2>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "select * from Sala2";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				
			Sala2 sal2 = new Sala2();
			sal2.setId(resultset.getInt(1));
			sal2.setClassName(resultset.getString("Blue_Red"));
			sal2.setQtdPessoas(resultset.getInt(10));
			
			listarSala2.add(sal2);
			
		}
		connection.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return listarSala2;
	  }
	  public static void atualizar (Sala2 sal2) {
		  
		  try {
			  
			  Connection connection = ConexaoUtil.getInstance().getConnection();
			  String sql = "update Sala1 set className = ? where id =?";
			  PreparedStatement statement = connection.prepareStatement(sql);
			  
			  statement.setInt(1,sal2.getId());
			  statement.setString(2,sal2.getClassName());
			  statement.setInt(3,sal2.getQtdPessoas());

			    statement.execute();
				statement.close();		
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  
	  }
	  public static void main(String[]args) {
		  
		  Sala2 sal2 = new Sala2();
		  sal2.setId(1);
		  sal2.setClassName("Black_Orange");
		  sal2.setQtdPessoas(10);
		  
		  inserir(sal2);
		  
		  
	  }
}
	
	
	

