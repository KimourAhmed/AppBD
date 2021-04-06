package tables;

import java.util.HashSet;
import java.util.Set;

public class Commande {
    int idCommande;
    String dateCommande;
    float prix;
    String statut;
    int idAdr;
    int idClient;
    private Set<Article> listArticles = new HashSet<Article>(); //Liste des Articles
    
	public Commande(int idCommande, String dateCommande, float prix, String statut, int idAdr, int idClient) {
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.prix = prix;
		this.statut = statut;
		this.idAdr = idAdr;
		this.idClient = idClient;
	}

	public Commande() {};
	
	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getIdAdr() {
		return idAdr;
	}

	public void setIdAdr(int idAdr) {
		this.idAdr = idAdr;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public Set<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(Set<Article> listArticles) {
		this.listArticles = listArticles;
	}

	//Ajoute un article
	public void addArticle(Article article){
		this.listArticles.add(article); 
	}
		
	//Retire un article
	public void removeArticle(Article article){
		this.listArticles.remove(article); 
	}


	@Override
	public String toString() {
		String str = "ID : " + this.getIdCommande() + "\n";
        str += "Date commande : " + this.getDateCommande() + "\n";
        str += "Prix : " + this.getPrix() + "\n";
        str += "Statut : " + this.getStatut() + "\n";
        str += "ID Adresse : " + this.getIdAdr() + "\n";
        str += "ID Client : " + this.getIdClient() + "\n";
        str += "Articles : " + this.getListArticles() + "\n";
        return str;
	}    
}

