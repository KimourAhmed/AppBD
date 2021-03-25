package tables;


public class Page {
	int idPage;
	String textDescriptif;
	String miseEnForme;
	int idImpr;
	
	public Page(int idPage, String textDescriptif, String miseEnForme, int idImpr) {
		this.idPage = idPage;
		this.textDescriptif = textDescriptif;
		this.miseEnForme = miseEnForme;
		this.idImpr = idImpr;
	}
	
	public Page() {
	}

	public int getIdPage() {
		return idPage;
	}

	public void setIdPage(int idPage) {
		this.idPage = idPage;
	}

	public String getTextDescriptif() {
		return textDescriptif;
	}

	public void setTextDescriptif(String textDescriptif) {
		this.textDescriptif = textDescriptif;
	}

	public String getMiseEnForme() {
		return miseEnForme;
	}

	public void setMiseEnForme(String miseEnForme) {
		this.miseEnForme = miseEnForme;
	}

	public int getIdImpr() {
		return idImpr;
	}

	public void setIdImpr(int idImpr) {
		this.idImpr = idImpr;
	}
	
	
	
	
}
