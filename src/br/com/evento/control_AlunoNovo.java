package br.com.evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.ConexaoUtil;

public class control_AlunoNovo {

	public static void inserir(AlunoNovo novo) {
		try {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		
		String sql  = "insert into AlunoNovo(id,firstName,lastName)values (?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
	
		statement.setInt(1, novo.getId());
		statement.setString(2, novo.getFirstName());
		statement.setString(3, novo.getLastName());
		
		
		statement.execute();
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static  void remover(String lastName) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "delete from AlunoNovo where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, lastName);
			
			statement.execute();
			statement.close();
		}catch (Exception e) {
		}
	}
	  public static  List<AlunoNovo> listarTodos(){
		
		List<AlunoNovo> listarAlunoNovo = new ArrayList<AlunoNovo>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "select * from AlunoNovo";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				
			AlunoNovo novo = new AlunoNovo();
			novo.setId(resultset.getInt(1));
			novo.setFirstName(resultset.getString("firstName"));
			novo.setLastName(resultset.getString("lastName"));
			
			listarAlunoNovo.add(novo);
			
		}
		connection.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return listarAlunoNovo;
	  }
	  public static void atualizar (AlunoNovo novo) {
		  
		  try {
			  
			  Connection connection = ConexaoUtil.getInstance().getConnection();
			  String sql = "update AlunoNovo set firstName = ? where firstName =?";
			  PreparedStatement statement = connection.prepareStatement(sql);
			  
			  statement.setInt(1,novo.getId());
			  statement.setString(2,novo.getFirstName());
			  statement.setString(3,novo.getLastName());

			    statement.execute();
				statement.close();		
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  
	  }
	  public static void main(String[]args) {
		  
		  AlunoNovo novo = new AlunoNovo();
		  novo.setId(1);
		  novo.setFirstName("Camprestini");
		  novo.setLastName("Joanes");
		  
		  inserir(novo);
		  
		  
	  }
}