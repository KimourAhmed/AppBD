package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tables.*;

public class StockDAO extends DAO<Stock> {
	public StockDAO(Connection conn) { 
		super(conn); 
		}
	
	public boolean create(Stock obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesStocks VALUES (?, ?)");
			ps.setInt(1, obj.getSupportImpression());
			ps.setInt(2, obj.getQuantite());
			int i = ps.executeUpdate();
			if(i == 1) {
			    return true;
			}
		} catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    return false;
	}
	
	public Stock read(int id){
		Stock stock = new Stock();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesStocks WHERE = " + id);
		if(result.first())
			page = new Page(id,result.getString("textDescriptif"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return stock;  
	}

	@Override
	public boolean update(Stock obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesStocks SET ");
        	//prepare.setString(1, obj.get());
        	prepare.setInt(2, obj.getQuantite());
        	int i = prepare.executeUpdate();
        	if(i == 1) {
        	    return true;
        	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean delete(Stock obj) {
		try {
			Statement stmt = this.connect.createStatement();
			//int i = stmt.executeUpdate("DELETE FROM LesStock WHERE " + obj.get());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}
	

	
}
