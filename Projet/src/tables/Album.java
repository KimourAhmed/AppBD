package tables;


public class Album extends Impression{
	String titre;
	int idPhoto;
	
	public Album(int idAlbum, String reference, String titre, int idPhoto) {
		super(idAlbum, reference);
		setTitre( titre);
		setIdPhoto(idPhoto);
	}
	
	public Album() {
	}
	

	public int getIdAlbum() {
		return idImpr;
	}
	
	public void setIdAlbum(int idAlbum) {
		this.idImpr = idAlbum;
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
	
	public int getIdPhoto() {
		return idPhoto;
	}
	
	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}

	
	
}
