package br.com.evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.ConexaoUtil;


public class control_CafeAdc {

	public static void inserir(CafeAdc cofAdc) {
		try {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		
		String sql  = "insert into CafeAdc(id,spaceName,qtdMaxPeaple,qtdActualPeaple)values (?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
	
		statement.setInt(1, cofAdc.getId());
		statement.setString(2, cofAdc.getSpaceName());
		statement.setInt(3, cofAdc.getQtdMaxPeaple());
		statement.setInt(4, cofAdc.getQtdActualPeaple());
		
		
		
		statement.execute();
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static  void remover(String id) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "delete from CafeAdc where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, id);
			
			statement.execute();
			statement.close();
		}catch (Exception e) {
		}
	}
	  public static  List<CafeAdc> listarTudo(){
		
		List<CafeAdc> listarCafeAdc = new ArrayList<CafeAdc>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "select * from CafeAdc";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				
			CafeAdc cofAdc = new CafeAdc();
			cofAdc.setId(resultset.getInt(1));
			cofAdc.setSpaceName(resultset.getString("Champions"));
			cofAdc.setQtdMaxPeaple(resultset.getInt(10));
			cofAdc.setQtdActualPeaple(resultset.getInt(6));
			
			listarCafeAdc.add(cofAdc);
			
		}
		connection.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return listarCafeAdc;
	  }
	  public static void atualizar (CafeAdc cofAdc) {
		  
		  try {
			  
			  Connection connection = ConexaoUtil.getInstance().getConnection();
			  String sql = "update CafeAdc set spaceName = ? where id =?";
			  PreparedStatement statement = connection.prepareStatement(sql);
			  
			  statement.setInt(1,cofAdc.getId());
			  statement.setString(2,cofAdc.getSpaceName());
			  statement.setInt(3,cofAdc.getQtdMaxPeaple());
			  statement.setInt(4,cofAdc.getQtdActualPeaple());

			    statement.execute();
				statement.close();		
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  
	  }
	  public static void main(String[]args) {
		  
		  CafeAdc cofAdc = new CafeAdc();
		  cofAdc.setId(1);
		  cofAdc.setSpaceName("Champion");
		  cofAdc.setQtdMaxPeaple(10);
		  cofAdc.setQtdActualPeaple(6);
		  
		  
		  inserir(cofAdc);
		  
		  
	  }
}
	
	
	

