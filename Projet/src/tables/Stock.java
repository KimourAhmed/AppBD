package tables;


public class Stock {
	SupportImpression supportImpression;
	int quantite;
	public Stock(SupportImpression supportImpression, int quantite) {
		this.supportImpression = supportImpression;
		this.quantite = quantite;
	}
	public SupportImpression getSupportImpression() {
		return supportImpression;
	}
	public void setSupportImpression(SupportImpression supportImpression) {
		this.supportImpression = supportImpression;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
