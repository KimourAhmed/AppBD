package dao;

import java.sql.*;
import tables.*;

public class PageDAO extends DAO<Page>{
	
	public PageDAO(Connection conn) { 
		super(conn); 
		}
	
	public boolean create(Page obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesPages VALUES (?, ?, ?, ?)");
			ps.setInt(1, obj.getIdPage());
			ps.setString(2, obj.getTextDescriptif());
			ps.setString(3, obj.getMiseEnForme());
			ps.setInt(4, obj.getIdImpr());
			int i = ps.executeUpdate();
			if(i == 1) {
			    return true;
			}
		} catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    return false;
	}
	
	public Page read(int id){
		Page page = new Page();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesPages " + "LEFT JOIN LesPhotos ON LesPhotos.idPage= LesPages.idPage" + "WHERE idPage = " + id);
		if(result.first())
			page = new Page(id,
								result.getString("textDescriptif"),
								result.getString("miseEnForme"),
								result.getInt("idImpr")
								);         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return page;  }

	@Override
	public boolean update(Page obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesPages SET textDescriptif=?, miseEnForme=?, idImpr=?"
					+ "WHERE idPage=?");
        	prepare.setString(1, obj.getTextDescriptif());
        	prepare.setString(2, obj.getMiseEnForme());
        	prepare.setInt(3, obj.getIdImpr());
        	prepare.setInt(4, obj.getIdPage());
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
	public boolean delete(Page obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesPages WHERE idPage = " + obj.getIdPage());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}
	

}
