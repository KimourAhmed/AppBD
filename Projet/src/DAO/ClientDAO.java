package DAO;
import java.sql.*;
import tables.*;

public class ClientDAO extends DAO<Client>{
	
	public ClientDAO(Connection conn) { super(conn); }
	
	@Override
	public boolean create(Client obj) {
			try {
				PreparedStatement ps = this.connect.prepareStatement("INSERT INTO LesClients VALUES (?, ?, ?, ?, ?)");
				ps.setInt(1, obj.getIdClient());
				ps.setString(2, obj.getAdrMail());
				ps.setString(3, obj.getName());
				ps.setString(4, obj.getPrenom());
				ps.setString(5, obj.getMdp());
				ps.setInt(6, obj.getIdAdr());
				int i = ps.executeUpdate();
				if(i == 1) {
				    return true;
				}
			} catch (SQLException ex) {
		        ex.printStackTrace();
		    }
	    return false;
	}
		
	public Client read(int id) {
		Client client = new Client();
		try {
			ResultSet result = this.connect.createStatement().
			executeQuery("SELECT * FROM LesClients"
					+ "LEFT JOIN LesCommandes ON LesCommandes.idClient = LesClients.idClient"
					+ " WHERE idClient = " + id);
		if(result.first())
		client= new Client(
			id,
			result.getString("adrMail"),
			result.getString("name"),
			result.getString("prenom"),
			result.getString("mdp"),
			result.getInt("idAdr")
		);
		result.beforeFirst();
		CommandeDAO comDao = new CommandeDAO(this.connect);
		while(result.next())
			client.addCommande(comDao.read(result.getInt("idCommande")));
		} catch (SQLException e) { e.printStackTrace(); }
		return client; 
	}
	

	@Override
	public boolean update(Client obj) {
		try {
			PreparedStatement prepare = this.connect.prepareStatement("UPDATE LesClients SET adrMail=?, name=?, prenom=?, mdp=?"
        			+ "WHERE idClient=?");
        	prepare.setString(1, obj.getAdrMail());
        	prepare.setString(2, obj.getName());
        	prepare.setString(3, obj.getPrenom());
        	prepare.setString(4, obj.getMdp());
        	prepare.setInt(5, obj.getIdAdr());
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
	public boolean delete(Client obj) {
		try {
			Statement stmt = this.connect.createStatement();
			int i = stmt.executeUpdate("DELETE FROM LesClients WHERE idClient = " + obj.getIdClient());
			if(i == 1) {
	    	    return true;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
		}
		return false;
	}
}

