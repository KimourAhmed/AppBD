package tables;

public class Commande {
	int idCommande;
    String dateCommande;
    float prix;
    String statut;
    int idAdr;
    int idClient;
    int codeProm;
    
	public Commande(int idCommande, String dateCommande, float prix, String statut, int idAdr, int idClient,
			int codeProm) {
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.prix = prix;
		this.statut = statut;
		this.idAdr = idAdr;
		this.idClient = idClient;
		this.codeProm = codeProm;
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

	public int getCodeProm() {
		return codeProm;
	}

	public void setCodeProm(int codeProm) {
		this.codeProm = codeProm;
	}
    
	
    
}