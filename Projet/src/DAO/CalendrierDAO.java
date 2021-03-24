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
			executeQuery("SELECT * FROM Calendrier WHERE idCal = " + id);
		if(result.first())
			Calendrier = new Calendrier(id,
								result.getString("refernce"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return Calendrier;  }

	@Override
	public Calendrier update(Calendrier obj) {
		// TODO Auto-generated method stub
		try {
            
			this.connect.createStatement().executeQuery(
                    "UPDATE Calendrier SET reference= '" + obj.getReference() +"'"+
                    " WHERE idAdr = " + obj.getIdCal()
                 );
        
        obj = this.read(obj.getIdCal());
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
	                     "DELETE FROM Calendrier WHERE idAdr = " + obj.getIdCal()
	                );
	    
		} catch (SQLException e) {
	        e.printStackTrace();
		}
	}
	

}