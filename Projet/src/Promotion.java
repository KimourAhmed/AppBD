public class Promotion {
	int codeProm;
    float taux;
    boolean utilise;
	
    public Promotion(int codeProm, float taux, boolean utilise) {
		this.codeProm = codeProm;
		this.taux = taux;
		this.utilise = utilise;
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
	public boolean isUtilise() {
		return utilise;
	}
	public void setUtilise(boolean utilise) {
		this.utilise = utilise;
	}
    
    
}
