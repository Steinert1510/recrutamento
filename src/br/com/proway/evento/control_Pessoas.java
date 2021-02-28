package br.com.proway.evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.proway.ConexaoUtil;


public class control_Pessoas {
	
	public static void inserir(Pessoas pessoas) {
		try {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		
		String sql  = "insert into Pessoas(id,firstName,lastName)values (?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
	
		statement.setInt(1, pessoas.getId());
		statement.setString(2, pessoas.getFirstName());
		statement.setString(3, pessoas.getLastName());
		
		
		statement.execute();
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static  void remover(String lastName) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "delete from pessoas where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, lastName);
			
			statement.execute();
			statement.close();
		}catch (Exception e) {
		}
	}
	  public static  List<Pessoas> listarTodos(){
		
		List<Pessoas> listarPessoas = new ArrayList<Pessoas>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "select * from pessoas";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				
			Pessoas pessoas = new Pessoas();
			pessoas.setId(resultset.getInt(1));
			pessoas.setFirstName(resultset.getString("firstName"));
			pessoas.setLastName(resultset.getString("lastName"));
			
			listarPessoas.add(pessoas);
			
		}
		connection.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return listarPessoas;
	  }
	  public static void atualizar (Pessoas pessoas) {
		  
		  try {
			  
			  Connection connection = ConexaoUtil.getInstance().getConnection();
			  String sql = "update pessoas set firstName = ? where firstName =?";
			  PreparedStatement statement = connection.prepareStatement(sql);
			  
			  statement.setInt(1,pessoas.getId());
			  statement.setString(2,pessoas.getFirstName());
			  statement.setString(3,pessoas.getLastName());

			    statement.execute();
				statement.close();		
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  
	  }
	  public static void main(String[]args) {
		  
		  Pessoas pessoas = new Pessoas();
		  pessoas.setId(1);
		  pessoas.setFirstName("Artur");
		  pessoas.setLastName("Pessoa");
		  
		  inserir(pessoas);
		  
	  }
}