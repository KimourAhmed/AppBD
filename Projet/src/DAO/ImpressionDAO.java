package DAO;
import java.sql.*;
import tables.*;

public class ImpressionDAO extends DAO<Impression>{
	
	public ImpressionDAO(Connection conn) { 
		super(conn); 
	}
	
	public boolean create(Impression obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesImpressions VALUES (?, ?)");
			ps.setInt(1, obj.getIdImpr());
			ps.setString(2, obj.getReference());
			int i = ps.executeUpdate();
			if(i == 1) {
			    return true;
			}
		} catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    return false;
	}
	
	public Impression read(int id){
		Impression impression = new Impression();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesImpressions WHERE idImpr = " + id);
		if(result.first())
			impression = new Impression(id ,result.getString("reference"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return impression;  
	}

	@Override
	public boolean update(Impression obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesImpressions SET reference=? WHERE idImpr=?");
        	prepare.setInt(1, obj.getIdImpr());
        	prepare.setString(2, obj.getReference());
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
	public boolean delete(Impression obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesImpressions WHERE idImpr=" + obj.getIdImpr());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}
}