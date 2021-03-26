package tables;


public class FichierImages {
	private String cheminAcces ;
	private String infoPriseDeVue;
	private int resolutionImage;
	private int estPartage;
	private int idClient;
	private int idPhoto;
	
	public FichierImages(String cheminAcces, String infoPriseDeVue, int resolutionImage, int estPartage,
			int idClient, int idPhoto) {
		this.cheminAcces = cheminAcces;
		this.infoPriseDeVue = infoPriseDeVue;
		this.resolutionImage = resolutionImage;
		this.estPartage = estPartage;
		this.idClient = idClient;
		this.idPhoto = idPhoto;
	}

	public FichierImages() {
		
	}
	
	public String getCheminAcces() {
		return cheminAcces;
	}

	public void setCheminAcces(String cheminAcces) {
		this.cheminAcces = cheminAcces;
	}

	public String getInfoPriseDeVue() {
		return infoPriseDeVue;
	}

	public void setInfoPriseDeVue(String infoPriseDeVue) {
		this.infoPriseDeVue = infoPriseDeVue;
	}

	public int getResolutionImage() {
		return resolutionImage;
	}

	public void setResolutionImage(int resolutionImage) {
		this.resolutionImage = resolutionImage;
	}

	public int getEstPartage() {
		return estPartage;
	}

	public void setestPartage(int estPartage) {
		this.estPartage = estPartage;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}
	
	public String toString() {
		String str = "Chemin Access : " + this.getCheminAcces() + "\n";
        str += "Info prise de vue : " + this.getInfoPriseDeVue() + "\n";
        str += "Resolution Image : " + this.getResolutionImage() + "\n";
        str += "Est Partagé : " + this.getEstPartage() + "\n";
        str += "ID client : " + this.getIdClient() + "\n";
        str += "ID Photo : " + this.getIdPhoto() + "\n";
        return str;
	}
}
