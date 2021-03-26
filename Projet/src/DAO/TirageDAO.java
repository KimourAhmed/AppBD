package dao;
import java.sql.*;
import tables.*;

public class TirageDAO extends DAO<Tirage>{
	
	public TirageDAO(Connection conn) { 
		super(conn); 
	}
	
	public boolean create(Tirage obj){ 
		try {
			PreparedStatement ps1 = this.connect.prepareStatement("INSERT INTO LesTirages VALUES (?, ?, ?)");
			ps1.setInt(1, obj.getIdImpr());
			ps1.setString(2, obj.getReference());
			ps1.setString(3, obj.getCheminAcces());
			int i = ps1.executeUpdate();
			
			PreparedStatement ps2 = this.connect.prepareStatement("INSERT INTO LesImpressions VALUES (?, ?)");
			ps2.setInt(1, obj.getIdImpr()+1000);
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
	
	public Tirage read(int id){
		Tirage tirage = new Tirage();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesTirages WHERE idTir = " + id);
		if(result.first())
			tirage = new Tirage(id ,result.getString("reference"), result.getString("cheminAcces"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return tirage;  
	}

	@Override
	public boolean update(Tirage obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesTirages SET reference=?, cheminAcces=? WHERE idTir=?");
        	prepare.setInt(1, obj.getIdImpr());
        	prepare.setString(2, obj.getReference());
        	prepare.setString(3, obj.getCheminAcces());
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
	public boolean delete(Tirage obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesTirages WHERE idCadre=" + obj.getIdImpr());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}

}