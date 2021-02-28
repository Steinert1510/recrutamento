package br.com.proway.evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.proway.ConexaoUtil;

public class control_CoffeeClassHired {

	public static void inserir(coffeeClassHired cof2) {
		try {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		
		String sql  = "insert into coffeeClassHired(id,spaceName,qtdMaxPeaple,qtdActualPeaple)values (?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
	
		statement.setInt(1, cof2.getId());
		statement.setString(2, cof2.getSpaceName());
		statement.setInt(3, cof2.getQtdMaxPeaple());
		statement.setInt(4, cof2.getQtdActualPeaple());
		
		
		
		statement.execute();
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static  void remover(String id) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "delete from coffeeClassHired where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, id);
			
			statement.execute();
			statement.close();
		}catch (Exception e) {
		}
	}
	  public static  List<coffeeClassHired> listarTudo(){
		
		List<coffeeClassHired> listarcoffeeClassHired = new ArrayList<coffeeClassHired>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "select * from coffeeClassHired";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				
			coffeeClassHired cof2 = new coffeeClassHired();
			cof2.setId(resultset.getInt(1));
			cof2.setSpaceName(resultset.getString("Magenta_Green"));
			cof2.setQtdMaxPeaple(resultset.getInt(10));
			cof2.setQtdActualPeaple(resultset.getInt(6));
			
			listarcoffeeClassHired.add(cof2);
			
		}
		connection.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return listarcoffeeClassHired;
	  }
	  public static void atualizar (coffeeClassHired cof2) {
		  
		  try {
			  
			  Connection connection = ConexaoUtil.getInstance().getConnection();
			  String sql = "update coffeeClassHired set spaceName = ? where id =?";
			  PreparedStatement statement = connection.prepareStatement(sql);
			  
			  statement.setInt(1,cof2.getId());
			  statement.setString(2,cof2.getSpaceName());
			  statement.setInt(3,cof2.getQtdMaxPeaple());
			  statement.setInt(4,cof2.getQtdActualPeaple());

			    statement.execute();
				statement.close();		
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  
	  }
	  public static void main(String[]args) {
		  
		  coffeeClassHired cof2 = new coffeeClassHired();
		  cof2.setId(1);
		  cof2.setSpaceName("Red_Green");
		  cof2.setQtdMaxPeaple(10);
		  cof2.setQtdActualPeaple(6);
		  
		  
		  inserir(cof2);
		  
		  
	  }
}
	
	
	

