package ressources;

public class Album {
	private int idAlbum;
	private int idPhoto;
	private String reference ;
	private String titre;
	
	public Album(int idAlbum, int idPhoto, String reference, String titre) {
		super();
		this.idAlbum = idAlbum;
		this.idPhoto = idPhoto;
		this.reference = reference;
		this.titre = titre;
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public int getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	
}
