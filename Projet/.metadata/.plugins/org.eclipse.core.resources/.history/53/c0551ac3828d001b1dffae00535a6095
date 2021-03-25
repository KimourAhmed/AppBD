package dao;
import java.sql.*;
import tables.*;

public class TirageDAO extends DAO<Tirage>{
	
	public TirageDAO(Connection conn) { 
		super(conn); 
	}
	
	public boolean create(Tirage obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesTirages VALUES (?, ?)");
			ps.setInt(1, obj.getIdTir());
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
	
	public Tirage read(int id){
		Tirage tirage = new Tirage();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesTirages WHERE idTir = " + id);
		if(result.first())
			tirage = new Tirage(id ,result.getString("reference"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return tirage;  
	}

	@Override
	public boolean update(Tirage obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesTirages SET reference=? WHERE idTir=?");
        	prepare.setInt(1, obj.getIdTir());
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
	public boolean delete(Tirage obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesTirages WHERE idCadre=" + obj.getIdTir());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}
}