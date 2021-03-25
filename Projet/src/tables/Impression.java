package tables;

public abstract class Impression {
	public int idImpr;
	public String reference;
	
	public Impression(int idImpr, String reference) {
		this.idImpr = idImpr;
		this.reference = reference;
	}
	
	public Impression() {
	}
	
	public int getIdImpr() {
		return idImpr;
	}
	public void setIdImpr(int idImpr) {
		this.idImpr = idImpr;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
}
