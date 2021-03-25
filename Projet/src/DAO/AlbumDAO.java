package dao;
import java.sql.*;
import tables.*;

public class AlbumDAO extends DAO<Album>{
	
	public AlbumDAO(Connection conn) { 
		super(conn); 
	}
	
	public boolean create(Album obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesAlbums VALUES (?, ?)");
			ps.setInt(1, obj.getIdImpr());
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
	
	public Album read(int id){
		Album album = new Album();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesAlbums WHERE idAlbum = " + id);
		if(result.first())
			album = new Album(id ,result.getString("reference"), result.getString("titre"), result.getInt("idPhoto"));    
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return album;  
	}

	@Override
	public boolean update(Album obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesAlbums SET reference=?, titre=?, idPhoto=? WHERE idAlbum=?");
        	prepare.setString(1, obj.getReference());
        	prepare.setString(2, obj.getTitre());
        	prepare.setInt(3, obj.getIdPhoto());
        	prepare.setInt(4, obj.getIdImpr());
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
	public boolean delete(Album obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesAlbums WHERE idAlbum=" + obj.getIdImpr());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}
}