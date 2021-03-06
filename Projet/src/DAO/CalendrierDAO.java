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
			ps.setInt(1, obj.getIdImpr());
			ps.setString(2, obj.getReference());
			int i = ps.executeUpdate();
			
			PreparedStatement ps2 = this.connect.prepareStatement("INSERT INTO LesImpressions VALUES (?, ?)");
			ps2.setInt(1, obj.getIdImpr()+3000);
			ps2.setString(2, obj.getReference());
			int j = ps2.executeUpdate();
			
			if(j == 1 && i == 1) {
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
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
			executeQuery("SELECT * FROM LesCalendriers "
					+ " JOIN LesPages ON (IdCal=IdImpr)"
					+ " WHERE idCal = " + id);
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
	public boolean delete(Calendrier obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesCalendriers WHERE idCalendrier=" + obj.getIdImpr());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}
}
