package br.com.evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.ConexaoUtil;


public class control_Sala1 {

	public static void inserir(Sala1 sal1) {
		try {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		
		String sql  = "insert into Sala1(id,className,qtdPessoas)values (?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
	
		statement.setInt(1, sal1.getId());
		statement.setString(2, sal1.getClassName());
		statement.setInt(3, sal1.getQtdPessoas());
		
		
		statement.execute();
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static  void remover(String id) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "delete from Sala1 where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, id);
			
			statement.execute();
			statement.close();
		}catch (Exception e) {
		}
	}
	  public static  List<Sala1> listarTudo(){
		
		List<Sala1> listarSala1 = new ArrayList<Sala1>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "select * from Sala1";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				
			Sala1 sal1 = new Sala1();
			sal1.setId(resultset.getInt(1));
			sal1.setClassName(resultset.getString("Blue_Red"));
			sal1.setQtdPessoas(resultset.getInt(10));
			
			listarSala1.add(sal1);
			
		}
		connection.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return listarSala1;
	  }
	  public static void atualizar (Sala1 sal1) {
		  
		  try {
			  
			  Connection connection = ConexaoUtil.getInstance().getConnection();
			  String sql = "update Sala1 set className = ? where id =?";
			  PreparedStatement statement = connection.prepareStatement(sql);
			  
			  statement.setInt(1,sal1.getId());
			  statement.setString(2,sal1.getClassName());
			  statement.setInt(3,sal1.getQtdPessoas());

			    statement.execute();
				statement.close();		
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  
	  }
	  public static void main(String[]args) {
		  
		  Sala1 sal1 = new Sala1();
		  sal1.setId(1);
		  sal1.setClassName("Blue_Red");
		  sal1.setQtdPessoas(10);
		  
		  inserir(sal1);
		  
	  }
}