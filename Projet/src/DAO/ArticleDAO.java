package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tables.*;

public class ArticleDAO extends DAO<Article>{
	
	public ArticleDAO(Connection conn) { 
		super(conn); 
	}
	
	public boolean create(Article obj){ 
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesArticles VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, obj.getIdArticle());
			ps.setDouble(2, obj.getPrixImpression());
			ps.setInt(3, obj.getQuantite());
			ps.setInt(4, obj.getIdCommande());
			ps.setInt(5, obj.getIdImpr());
			int i = ps.executeUpdate();
			if(i == 1) {
			    return true;
			}
		} catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    return false;
	}
	
	public Article read(int id){
		Article article = new Article();      
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE).
			executeQuery("SELECT * FROM LesArticles WHERE idArticle = " + id);
		if(result.first())
			article = new Article(id, result.getDouble("prixImpression"), result.getInt("quantite"),result.getInt("idCommande"), result.getInt("idImpr"));         
			} catch (SQLException e){
				e.printStackTrace(); 
			}
		return article;  
	}

	@Override
	public boolean update(Article obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesArticles SET prixImpression=?, quantite=?, idCommande=?, idImpr=?"
        			+ "WHERE idArticle=?");
        	prepare.setDouble(1, obj.getPrixImpression());
        	prepare.setInt(2, obj.getQuantite());
        	prepare.setInt(3, obj.getIdCommande());
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
	public boolean delete(Article obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesArticles WHERE idArticle=" + obj.getIdArticle());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}

}
