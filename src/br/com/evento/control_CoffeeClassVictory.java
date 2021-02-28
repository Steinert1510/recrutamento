package br.com.evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.ConexaoUtil;

public class control_CoffeeClassVictory {
	
	public static void inserir(coffeeClassVictory cof1) {
		try {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		
		String sql  = "insert into coffeeClassVictory(id,spaceName,qtdMaxPeaple,qtdActualPeaple)values (?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
	
		statement.setInt(1, cof1.getId());
		statement.setString(2, cof1.getSpaceName());
		statement.setInt(3, cof1.getQtdMaxPeaple());
		statement.setInt(4, cof1.getQtdActualPeaple());
		
		
		
		statement.execute();
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static  void remover(String id) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "delete from coffeeClassVictory where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, id);
			
			statement.execute();
			statement.close();
		}catch (Exception e) {
		}
	}
	  public static  List<coffeeClassVictory> listarTudo(){
		
		List<coffeeClassVictory> listarcoffeeClassVictory = new ArrayList<coffeeClassVictory>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "select * from coffeeClassVictory";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				
			coffeeClassVictory cof1 = new coffeeClassVictory();
			cof1.setId(resultset.getInt(1));
			cof1.setSpaceName(resultset.getString("Yellow_Red"));
			cof1.setQtdMaxPeaple(resultset.getInt(10));
			cof1.setQtdActualPeaple(resultset.getInt(5));
			
			listarcoffeeClassVictory.add(cof1);
			
		}
		connection.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return listarcoffeeClassVictory;
	  }
	  public static void atualizar (coffeeClassVictory cof1) {
		  
		  try {
			  
			  Connection connection = ConexaoUtil.getInstance().getConnection();
			  String sql = "update coffeeClassVictory set spaceName = ? where id =?";
			  PreparedStatement statement = connection.prepareStatement(sql);
			  
			  statement.setInt(1,cof1.getId());
			  statement.setString(2,cof1.getSpaceName());
			  statement.setInt(3,cof1.getQtdMaxPeaple());
			  statement.setInt(4,cof1.getQtdActualPeaple());

			    statement.execute();
				statement.close();		
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  
	  }
	  public static void main(String[]args) {
		  
		  coffeeClassVictory cof1 = new coffeeClassVictory();
		  cof1.setId(1);
		  cof1.setSpaceName("Yellow_Red");
		  cof1.setQtdMaxPeaple(10);
		  cof1.setQtdActualPeaple(5);
		  
		  
		  inserir(cof1);
		  
		  
	  }
}
	
	
	

