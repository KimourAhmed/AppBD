package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tables.*;

public class PromotionDAO extends DAO<Promotion>{
	public PromotionDAO(Connection conn) { 
		super(conn); 
	}
	
	public boolean create(Promotion obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesPromotions VALUES (?, ?, ?, ?)");
			ps.setInt(1, obj.getCodeProm());
			ps.setFloat(2, obj.getTaux());
			ps.setInt(3, obj.getUtilise());
			ps.setInt(4, obj.getIdCommande());
			int i = ps.executeUpdate();
			if(i == 1) {
			    return true;
			}
		} catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    return false;
	}
	
	public Promotion read(int code){
		Promotion promotion = new Promotion();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesPromotions WHERE codeProm = " + code);
		if(result.first())
			promotion = new Promotion(code, result.getFloat("taux"), result.getInt("utilise"), result.getInt("idCommande"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return promotion;  
	}

	@Override
	public boolean update(Promotion obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesPromotions SET taux=?, utilise=?, idCommande=? WHERE codeProm=?");
        	prepare.setFloat(1, obj.getTaux());
        	prepare.setInt(2, obj.getUtilise());
        	prepare.setInt(3, obj.getIdCommande());
        	prepare.setInt(4, obj.getCodeProm());
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
	public boolean delete(Promotion obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesPromotions WHERE codeProm=" + obj.getCodeProm());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}

}
