package jdbc;
import java.sql.*;
import dao.*;
import tables.*;

public class ConnexCreatClient extends squelette_appli {

	protected static int creationClient() throws SQLException {
    	//creationClient();
    	System.out.println("Vous créez un nouveau compte.");
    	System.out.print(">> Veuillez entrer une adresse mail : ");
    	System.out.flush();
    	String newMailClient = LectureClavier.lireChaine();
		System.out.print(">> Veuillez entrer un nom : ");
		System.out.flush();
    	String newNomClient = LectureClavier.lireChaine();
		System.out.print(">> Veuillez entrer un prénom : ");
		System.out.flush();
    	String newPrenomClient = LectureClavier.lireChaine();
		System.out.print(">> Veuillez entrer un mot de passe : ");
		System.out.flush();
    	String newMdpClient = LectureClavier.lireChaine();
    	
		//System.out.print(">> Veuillez entrer un numero d'adresse de livraison : ");		
		System.out.flush();
    	int newNumAdresseClient = LectureClavier.lireEntier(">> Veuillez entrer un numero d'adresse de livraison : ");
    	
    	System.out.print(">> Veuillez entrer un nom d'adresse de livraison : ");		
		System.out.flush();
    	String newNomAdresseClient = LectureClavier.lireChaine();
    	
    	System.out.print(">> Veuillez entrer une ville de livraison : ");		
		System.out.flush();
    	String newVilleClient = LectureClavier.lireChaine();
    	
    	//System.out.print(">> Veuillez entrer un code postal de livraison : ");		
		System.out.flush();
    	int newCodePostalClient = LectureClavier.lireEntier(">> Veuillez entrer un code postal de livraison : ");
    	
    	String query = "SELECT MAX(idClient)+1 as idClient FROM LesClients";
    	System.out.println("Query 1 : " + query);
    	ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
    executeQuery(query);
    	result.next();
    	int newIdClient = result.getInt("idClient");
    	int newIdAdrClient = result.getInt("idClient");
    	
    	DAO<Adresse> adresseDao = new AdresseDAO(conn);
    	Adresse adresse = new Adresse();
    	adresse.setIdAdr(newIdAdrClient);
    	adresse.setNumRue(newNumAdresseClient);
    	adresse.setNomRue(newNomAdresseClient);
    	adresse.setVille(newVilleClient);
    	adresse.setCodePostal(newCodePostalClient);
    	adresseDao.create(adresse);
    	
    	System.out.println("L'adresse a été ajouté: " + newNumAdresseClient + " " + newNomAdresseClient+ " à " +
    	newVilleClient +" " + newCodePostalClient);
    	
    	DAO<Client> clientDao = new ClientDAO(conn);
    	Client client = new Client();
    	client.setIdClient(newIdClient);
    	client.setAdrMail(newMailClient);
    	client.setNom(newNomClient);
    	client.setPrenom(newPrenomClient);
    	client.setMdp(newMdpClient);
    	client.setIdAdr(newIdAdrClient);
    	clientDao.create(client);
    	idC = newIdClient;
    	return idC;
	}

	protected static int connexionClient() throws SQLException {
		ResultSet result;
		do {
  	    	System.out.println("Vous vous connecter.");
  	    	System.out.println(">> Entrez votre adresse mail: ");
  	    	System.out.flush();
  	    	String mailClient = LectureClavier.lireChaine();
  	    	System.out.println(">> Entrez votre mot de passe: ");
  	    	System.out.flush();
  	    	String mdpClient = LectureClavier.lireChaine();
  	    	
  	    	String query = "SELECT idClient, nom FROM LesClients WHERE adrMail='" + mailClient + "'" + " AND mdp='" + mdpClient +"'";
  	    	result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
            executeQuery(query);
	    	} while(!result.first());
	    	
	    	System.out.println("\nWelcome back, " + result.getString("nom")); //temp
	    	idC = result.getInt("idClient");
	    	return idC;
	}
}
