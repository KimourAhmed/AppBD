package dao;
import java.sql.*;
import tables.*;

public class CommandeDAO extends DAO<Commande> {
	
	public CommandeDAO(Connection conn) { 
		super(conn); 
		}
	
	@Override
	public boolean create(Commande obj) {
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesCommandes VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, obj.getIdCommande());
			ps.setString(2, obj.getDateCommande());
			ps.setFloat(3, obj.getPrix());
			ps.setString(4, obj.getStatut());
			ps.setInt(5, obj.getIdAdr());
			ps.setInt(6, obj.getIdClient());
			int i = ps.executeUpdate();
			if(i == 1) {
			    return true;
			}
		} catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    return false;
}
	
	public Commande read(int id){
		Commande commande = new Commande();      
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE).
			executeQuery("SELECT * FROM LesCommandes"
					+ " NATURAL LEFT JOIN LesArticles WHERE idCommande="+id);
		if(result.first()) {
			commande = new Commande(id,result.getString("dateCommande"),
								result.getFloat("prix"),
								result.getString("Statut"),
								result.getInt("idAdr"),
								result.getInt("idClient")
								);   
			result.beforeFirst();
	        ArticleDAO articleDao = new ArticleDAO(this.connect);
	        while(result.next())
	            commande.addArticle(articleDao.read(result.getInt("idArticle")));
	        }
		} catch (SQLException e){
			e.printStackTrace(); 
		}
		return commande;  
	}
	
	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesCommandes SET dateCommande=?, "
					+ "prix=?, statut=?, idAdr=?, idClient=?"
					+ "WHERE idCommande=?");
        	prepare.setString(1, obj.getDateCommande());
        	prepare.setFloat(2, obj.getPrix());
        	prepare.setString(3, obj.getStatut());
        	prepare.setInt(4, obj.getIdAdr());
        	prepare.setInt(5, obj.getIdClient());
        	prepare.setInt(6, obj.getIdCommande());
        	System.out.println("UPDATE LesCommandes SET dateCommande=" + obj.getDateCommande().toString() + ", prix=" + obj.getPrix() +
    				", statut=" + obj.getStatut() + ", idAdr=" + obj.getIdAdr() + ", idClient=" + obj.getIdClient() + 
    				" WHERE idCommande=" + obj.getIdCommande());
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
	public boolean delete(Commande obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesCommandes WHERE idCommande = " + obj.getIdCommande());
			if(i == 1) {
	    	    return true;
	        } 
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}

}
