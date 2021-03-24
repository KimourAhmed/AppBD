package DAO;
	
import java.sql.*;
import tables.*;

public class ArticleDAO extends DAO<Article>{
		public ArticleDAO(Connection conn) {
				super(conn);
		}
		
		
		
		@Override
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
				ResultSet result = this.connect.createStatement().
				executeQuery("SELECT * FROM adresse WHERE idArticle = " + id);
				if(result.first())
				article = new Article(id,result.getDouble("prixImpression"),
				result.getInt("quantite"),
				result.getInt("idCommande"),
				result.getInt("idImpr")
				);
				} catch (SQLException e){
				e.printStackTrace();
				}
				return article; }
			
		 @Override
		 public Article update(Article obj) {
		// TODO Auto-generated method stub
			 try {
				this.connect.createStatement().executeUpdate(
				"UPDATE adresse SET prixImpression = '" + obj.getPrixImpression() +
				"', quantite = '"+ obj.getQuantite()+
				"', idCommande = '" +obj.getIdCommande()+
				"', idImpr = '"+obj.getIdImpr()+ "'"+
				" WHERE IdArticle = " + obj.getIdArticle()
				);
				obj = this.read(obj.getIdArticle());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return obj;
			}
			
			 @Override
			public void delete(Article obj) {;
				// TODO Auto-generated method stub
				try {
					this.connect.createStatement().executeUpdate(
					"DELETE FROM article WHERE IdArticle = " + obj.getIdArticle()
				);
				} catch (SQLException e) {
					e.printStackTrace();
			}
			}


	}
	
