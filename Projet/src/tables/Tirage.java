package tables;


public class Tirage {
	int idTir;
	String reference;
	
	public Tirage(int idTir, String reference) {
		this.idTir = idTir;
		this.reference = reference;
	}

	public int getIdTir() {
		return idTir;
	}

	public void setIdTir(int idTir) {
		this.idTir = idTir;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
}