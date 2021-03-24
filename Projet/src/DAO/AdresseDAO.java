package DAO;

import java.sql.*;
import tables.*;

public class AdresseDAO extends DAO<Adresse>{
	
	public AdresseDAO(Connection conn) { 
		super(conn); 
		}
	
	public Adresse create(Adresse obj){
		return obj;
	}
	
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
		return adresse;  }

	@Override
	public Adresse update(Adresse obj) {
		// TODO Auto-generated method stub
		try {
            
			this.connect.createStatement().executeQuery(
                    "UPDATE adresse SET numRue = '" + obj.getNumRue() + 
                    					"', nomRue = '"+ obj.getNomRue()+
                    					"', ville = '" +obj.getVille()+
                    					"', codePostal = '"+obj.getCodePostal()+ "'"+
                    " WHERE idAdr = " + obj.getIdAdr()
                 );
        
        obj = this.read(obj.getIdAdr());
		} catch (SQLException e) {
            e.printStackTrace();
    	}
    
    return obj;
	}

	@Override
	public void delete(Adresse obj) {
		// TODO Auto-generated method stub
		try {
			this.connect.createStatement().executeUpdate(
	                     "DELETE FROM adresse WHERE idAdr = " + obj.getIdAdr()
	                );
	    
		} catch (SQLException e) {
	        e.printStackTrace();
		}
	}
	

}