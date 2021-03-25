package DAO;
import java.sql.*;
import tables.*;

public class FichierImagesDAO extends DAO<FichierImages>{
	
	public FichierImagesDAO(Connection conn) { 
		super(conn); 
		}
	
	public boolean create(FichierImages obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesFichierImages VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, obj.getCheminAcces());
			ps.setString(2, obj.getInfoPriseDeVue());
			ps.setInt(3, obj.getResolutionImage());
			ps.setBoolean(4, obj.isEstParatge());
			ps.setInt(5, obj.getIdClient());
			ps.setInt(6, obj.getIdPhoto());
			int i = ps.executeUpdate();
			if(i == 1) {
			    return true;
			}
		} catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    return false;
	}
	
	public FichierImages read(String chemin){
		FichierImages fichierImage = new FichierImages();      
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesFichierImages WHERE cheminAcces = " + chemin);
		if(result.first())
			fichierImage = new FichierImages(chemin, result.getString("infoPriseDeVue"), result.getInt("resolutionImage"), 
					 result.getBoolean("estPartage"),  result.getInt("idClient"),  result.getInt("idPhoto"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return fichierImage;  
	}
	

	@Override
	public boolean update(FichierImages obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesFichierImages SET infoPriseDeVue=?, resolutionImage=?,"
					+ "estPartage=?, idClient=? idPhoto=? WHERE cheminAcces=?");
        	prepare.setString(1, obj.getInfoPriseDeVue());
        	prepare.setInt(2, obj.getResolutionImage());
        	prepare.setBoolean(3, obj.isEstParatge());
        	prepare.setInt(4, obj.getIdClient());
        	prepare.setInt(5, obj.getIdPhoto());
        	prepare.setString(6, obj.getCheminAcces());
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
	public boolean delete(FichierImages obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesFichierImages WHERE cheminAcces=" + obj.getCheminAcces());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}

	@Override
	public FichierImages read(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}