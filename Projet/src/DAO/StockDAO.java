package dao;

public class StockDAO {
	SupportImpressionDAO supportImpression;
	int quantite;
	public StockDAO(SupportImpressionDAO supportImpression, int quantite) {
		this.supportImpression = supportImpression;
		this.quantite = quantite;
	}
	public SupportImpressionDAO getSupportImpression() {
		return supportImpression;
	}
	public void setSupportImpression(SupportImpressionDAO supportImpression) {
		this.supportImpression = supportImpression;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
