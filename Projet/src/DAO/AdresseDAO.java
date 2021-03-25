package DAO;

import java.sql.*;
import tables.*;

public class AdresseDAO extends DAO<Adresse>{
	
	public AdresseDAO(Connection conn) { 
		super(conn); 
	}
	
	@Override
	public boolean create(Adresse obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesAdresses VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, obj.getIdAdr());
			ps.setInt(2, obj.getNumRue());
			ps.setString(3, obj.getNomRue());
			ps.setString(4, obj.getVille());
			ps.setInt(5, obj.getCodePostal());
			int i = ps.executeUpdate();
			if(i == 1) {
			    return true;
			}
		} catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    return false;
	}
	
	@Override
	public Adresse read(int id){
		Adresse adresse = new Adresse();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM adresse WHERE idAdr = " + id);
		if(result.first())
			adresse = new Adresse(id,result.getInt("numRue"),
								result.getString("nomRue"),
								result.getString("ville"),
								result.getInt("codePostal")
								);         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return adresse;
	}

	@Override
	public boolean update(Adresse obj) {
        try {
        	PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesAdresses SET numRue=?, nomRue=?, ville=?, codePostal=?"
        			+ "WHERE idAdr=?");
        	prepare.setInt(1, obj.getNumRue());
        	prepare.setString(2, obj.getNomRue());
        	prepare.setString(3, obj.getVille());
        	prepare.setInt(4, obj.getCodePostal());
        	prepare.setInt(5, obj.getIdAdr());
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
	public boolean delete(Adresse obj) {
	    try {
	    	Statement stmt = this.connect.createStatement();
	        int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + obj.getIdAdr());
	        if(i == 1) {
	    	    return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
}
