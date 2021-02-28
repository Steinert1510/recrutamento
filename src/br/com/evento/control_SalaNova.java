package br.com.evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.ConexaoUtil;

public class control_SalaNova {

	public static void inserir(SalaNova salAdc) {
		try {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		
		String sql  = "insert into SalaNova(id,className,qtdPessoas)values (?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
	
		statement.setInt(1, salAdc.getId());
		statement.setString(2, salAdc.getClassName());
		statement.setInt(3, salAdc.getQtdPessoas());
		
		
		
		
		statement.execute();
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static  void remover(String id) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "delete from SalaNova where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, id);
			
			statement.execute();
			statement.close();
		}catch (Exception e) {
		}
	}
	  public static  List<SalaNova> listarTudo(){
		
		List<SalaNova> listarSalaNova = new ArrayList<SalaNova>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "select * from SalaNova";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				
			SalaNova salAdc = new SalaNova();
			salAdc.setId(resultset.getInt(1));
			salAdc.setClassName(resultset.getString("Grey_Blue"));
			salAdc.setQtdPessoas(resultset.getInt(10));
			
			
			listarSalaNova.add(salAdc);
			
		}
		connection.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return listarSalaNova;
	  }
	  public static void atualizar (SalaNova salAdc) {
		  
		  try {
			  
			  Connection connection = ConexaoUtil.getInstance().getConnection();
			  String sql = "update SalaNova set className = ? where id =?";
			  PreparedStatement statement = connection.prepareStatement(sql);
			  
			  statement.setInt(1,salAdc.getId());
			  statement.setString(2,salAdc.getClassName());
			  statement.setInt(3,salAdc.getQtdPessoas());
			  

			    statement.execute();
				statement.close();		
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  
	  }
	  public static void main(String[]args) {
		  
		  SalaNova salAdc = new SalaNova();
		  salAdc.setId(1);
		  salAdc.setClassName("Red_Green");
		  salAdc.setQtdPessoas(10);
		  
		  
		  
		  inserir(salAdc);
		  
		  
	  }
}
	
	
	

