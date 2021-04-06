package dao;
import java.sql.*;
import tables.*;

public class PhotoDAO extends DAO<Photo>{
	
	public PhotoDAO(Connection conn) { 
		super(conn); 
	}
	
	public boolean create(Photo obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesPhotos VALUES (?, ?, ?)");
			ps.setInt(1, obj.getIdPhoto());
			ps.setString(2, obj.getParametresRetouche());
			if (obj.getIdPage() < 0) {
				ps.setString(3, null);
			} else {
				ps.setInt(3, obj.getIdPage());
			}
			
			int i = ps.executeUpdate();
			if(i == 1) {
				System.out.println("INSERT INTO LesPhotos VALUES (" + obj.getIdPhoto() +", '" + obj.getParametresRetouche() + "', "
						+ obj.getIdPage() + ")");
			    return true;
			}
		} catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    return false;
	}
	
	public Photo read(int id){
		Photo photo = new Photo();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesPhotos WHERE idPhoto = " + id);
		if(result.first())
			photo = new Photo(id,result.getString("parametresRetouche"),
					result.getInt("idPage"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return photo;  
	}

	@Override
	public boolean update(Photo obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesPhotos SET parametresRetouche=?, idPage=?"
        			+ "WHERE idPhoto=?");
        	prepare.setString(1, obj.getParametresRetouche());
        	prepare.setInt(2, obj.getIdPage());
        	if (obj.getIdPage() < 0) {
				prepare.setString(3, null);
			} else {
				prepare.setInt(3, obj.getIdPage());
			}
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
	public boolean delete(Photo obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesPhotos WHERE idPhoto=" + obj.getIdPhoto());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}

}
