package tables;


public class Cadre {
	int idCadre;
	String reference;
	public Cadre(int idCadre, String reference) {
		super();
		this.idCadre = idCadre;
		this.reference = reference;
	}
	public int getIdCadre() {
		return idCadre;
	}
	public void setIdCadre(int idCadre) {
		this.idCadre = idCadre;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
}
