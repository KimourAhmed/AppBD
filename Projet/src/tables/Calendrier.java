package tables;

public class Calendrier {
	private int idCal;
	private String reference;
	  
	 public Calendrier(int idCal, String reference) {
			super();
			this.idCal = idCal;
			this.reference = reference;
		}
	 
	public Calendrier() {
		}

	public int getIdCal() {
		return idCal;
	}

	public void setIdCal(int idCal) {
		this.idCal = idCal;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	  
}