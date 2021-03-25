package tables;
import java.util.HashSet;
import java.util.Set;

public class Client {
	int idClient;
	String adrMail;
	String name;
	String prenom;
	String mdp;
	int idAdr;
	private Set<Commande> listCommandes = new HashSet<Commande>(); //Liste des commandes
	private Set<FichierImages> listFichierImages = new HashSet<FichierImages>(); //Liste des commandes
	
	public Client(int idClient, String adrMail, String name, String prenom, String mdp, int idAdr) {
		this.idClient = idClient;
		this.adrMail = adrMail;
		this.name = name;
		this.prenom = prenom;
		this.mdp = mdp;
		this.idAdr = idAdr;
	}

	public Client() {
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getAdrMail() {
		return adrMail;
	}

	public void setAdrMail(String adrMail) {
		this.adrMail = adrMail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getIdAdr() {
		return idAdr;
	}

	public void setIdAdr(int idAdr) {
		this.idAdr = idAdr;
	}
	
	public String toString() {
		return "Client [adresseMail=" + adrMail + ", nom=" + name + ", prenom=" + prenom + ", mot de passe=" + mdp+ "]";
	}
	
	
	public Set<FichierImages> getListFichierImages() {
		return listFichierImages;
	}

	public void setListFichierImages(Set<FichierImages> listFichierImages) {
		this.listFichierImages = listFichierImages;
	}

	public Set<Commande> getListCommandes() {
		return listCommandes;
	}

	public void setListCommandes(Set<Commande> listCommandes) {
		this.listCommandes = listCommandes;
	}
	
	//Ajoute
	public void addCommande(Commande commande){
		this.listCommandes.add(commande); 
	}
		
	//Retire 
	public void removeCommande(Commande commande){
		this.listCommandes.remove(commande); 
	}
	
	//Ajoute
	public void addFichierImage(FichierImages fichier){
		this.listFichierImages.add(fichier); 
	}
		
	//Retire 
	public void removeFichierImage(FichierImages fichier){
		this.listFichierImages.remove(fichier); 
	}

	
}
