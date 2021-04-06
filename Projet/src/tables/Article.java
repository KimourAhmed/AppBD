package tables;


public class Article {
	private int idArticle;
	private double prixImpression;
	private int quantite;
	private int idCommande;
	private int idImpr;
	
	public Article(int idArticle, double prixImpression, int quantite, int idCommande, int idImpr) {
		this.idArticle = idArticle;
		this.prixImpression = prixImpression;
		this.quantite = quantite;
		this.idCommande = idCommande;
		this.idImpr = idImpr;
	}
	
	public Article() {
		
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public double getPrixImpression() {
		return prixImpression;
	}

	public void setPrixImpression(double prixImpression) {
		this.prixImpression = prixImpression;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdImpr() {
		return idImpr;
	}

	public void setIdImpr(int idImpr) {
		this.idImpr = idImpr;
	}
	
	public String toString() {
		String str = "ID : " + this.getIdArticle() + "\n";
        str += "Prix : " + this.getPrixImpression() + "\n";
        str += "Quantité : " + this.getQuantite() + "\n";
        str += "ID Commande : " + this.getIdCommande() + "\n";
        str += "ID Impression : " + this.getIdImpr() + "\n";
        return str;
	}
	
	
}
