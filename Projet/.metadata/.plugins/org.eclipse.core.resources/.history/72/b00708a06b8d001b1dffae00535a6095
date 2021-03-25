package DAO;
import java.sql.*;
import tables.*;

public class CadreDAO extends DAO<Cadre>{
	
	public CadreDAO(Connection conn) { 
		super(conn); 
	}
	
	public boolean create(Cadre obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesCadres VALUES (?, ?)");
			ps.setInt(1, obj.getIdCadre());
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
	
	public Cadre read(int id){
		Cadre cadre = new Cadre();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesCadres WHERE idCadre = " + id);
		if(result.first())
			cadre = new Cadre(id ,result.getString("reference"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return cadre;  
	}

	@Override
	public boolean update(Cadre obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesCadres SET reference=? WHERE idCadre=?");
        	prepare.setInt(1, obj.getIdCadre());
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
	public boolean delete(Cadre obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesCadres WHERE idCadre=" + obj.getIdCadre());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}
}