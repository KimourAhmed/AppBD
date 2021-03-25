package tables;

public class FichierImages {
	private String cheminAcces ;
	private String infoPriseDeVue;
	private int resolutionImage;
	private boolean estParatge;
	private int idClient;
	private int idPhoto;
	
	public FichierImages(String cheminAcces, String infoPriseDeVue, int resolutionImage, boolean estParatge,
			int idClient, int idPhoto) {
		super();
		this.cheminAcces = cheminAcces;
		this.infoPriseDeVue = infoPriseDeVue;
		this.resolutionImage = resolutionImage;
		this.estParatge = estParatge;
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

	public boolean isEstParatge() {
		return estParatge;
	}

	public void setEstParatge(boolean estParatge) {
		this.estParatge = estParatge;
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
	
	
}
