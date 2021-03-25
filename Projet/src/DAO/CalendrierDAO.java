package dao;
import java.sql.*;
import tables.*;

public class CalendrierDAO extends DAO<Calendrier>{
	
	public CalendrierDAO(Connection conn) { 
		super(conn); 
	}
	
	public boolean create(Calendrier obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesCalendriers VALUES (?, ?)");
			ps.setInt(1, obj.getIdCal());
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
	
	public Calendrier read(int id){
		Calendrier calendrier = new Calendrier();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesCalendriers WHERE idCalendrier = " + id);
		if(result.first())
			calendrier = new Calendrier(id ,result.getString("reference"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return calendrier;  
	}

	@Override
	public boolean update(Calendrier obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesCalendriers SET reference=? WHERE idCal=?");
        	prepare.setInt(1, obj.getIdCal());
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
	public boolean delete(Calendrier obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesCalendriers WHERE idCalendrier=" + obj.getIdCal());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}
}