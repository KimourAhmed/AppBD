package tables;

public class Promotion {
	int codeProm;
    float taux;
    int utilise;
    int idCommande;
	
    public Promotion(int codeProm, float taux, int utilise, int idCommande) {
		this.codeProm = codeProm;
		this.taux = taux;
		this.utilise = utilise;
		this.idCommande = idCommande;
	}
    
    public Promotion() {};
    
    public int getCodeProm() {
		return codeProm;
	}
	
	public void setCodeProm(int codeProm) {
		this.codeProm = codeProm;
	}
	public float getTaux() {
		return taux;
	}
	public void setTaux(float taux) {
		this.taux = taux;
	}
	public int getUtilise() {
		return utilise;
	}
	public void setUtilise(int utilise) {
		this.utilise = utilise;
	}
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
    
    
}
