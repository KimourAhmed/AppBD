package DAO;

import java.sql.*;
import tables.*;

public class AlbumDAO extends DAO<Album>{
	
	public AlbumDAO(Connection conn) { 
		super(conn); 
		}
	
	public Album create(Album obj){ 
		return obj;
	}
	
	public Album read(int id){
		Album album = new Album();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM adresse WHERE idAlbum = " + id);
		if(result.first())
			album = new Album(id,result.getString("reference"),
								result.getString("titre"),
								result.getInt("idPhoto")
								);         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return album;  }

	@Override
	public Album update(Album obj) {
		// TODO Auto-generated method stub
		try {
            
            this .connect    
                 .createStatement().executeUpdate(
                    "UPDATE adresse SET reference = '" + obj.getReference() + 
                    					"', titre = '"+ obj.getTitre()+
                    					"', idPhoto = '" +obj.getIdPhoto()+"'"+
                    " WHERE IdAlbum = " + obj.getIdAlbum()
                 );
        
        obj = this.read(obj.getIdAlbum());
		} catch (SQLException e) {
            e.printStackTrace();
    	}
    
    return obj;
	}

	@Override
	public void delete(Album obj) {;
		// TODO Auto-generated method stub
	try {
        
        this    .connect
                .createStatement().executeUpdate(
                     "DELETE FROM album WHERE IdAlbum = " + obj.getIdAlbum()
                );
    
		} catch (SQLException e) {
			        e.printStackTrace();
		}
	}	
}


