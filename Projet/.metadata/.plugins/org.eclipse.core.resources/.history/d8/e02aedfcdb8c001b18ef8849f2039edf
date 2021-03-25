package DAO;
import java.sql.*;
import tables.*;

public class CalendrierDAO extends DAO<Calendrier>{
	
	public CalendrierDAO(Connection conn) { 
		super(conn); 
		}
	
	public Calendrier create(Calendrier obj){
		return obj;
	}
	
	public Calendrier read(int id){
		Calendrier Calendrier = new Calendrier();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM Calendrier WHERE idAdr = " + id);
		if(result.first())
			Calendrier = new Calendrier(id,result.getInt("numRue"),
								result.getString("nomRue"),
								result.getString("ville"),
								result.getInt("codePostal")
								);         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return Calendrier;  }

	@Override
	public Calendrier update(Calendrier obj) {
		// TODO Auto-generated method stub
		try {
            
			this.connect.createStatement().executeQuery(
                    "UPDATE Calendrier SET numRue = '" + obj.getNumRue() + 
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
	public void delete(Calendrier obj) {
		// TODO Auto-generated method stub
		try {
			this.connect.createStatement().executeUpdate(
	                     "DELETE FROM Calendrier WHERE idAdr = " + obj.getIdAdr()
	                );
	    
		} catch (SQLException e) {
	        e.printStackTrace();
		}
	}
	

}