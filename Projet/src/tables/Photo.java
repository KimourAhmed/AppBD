package tables;
public class Photo {
	int idPhoto;
	String parametresRetouche;
	int idPage;
	
	
	public Photo(int idPhoto, String parametresRetouche, int idPage) {
		this.idPhoto = idPhoto;
		this.parametresRetouche = parametresRetouche;
		this.idPage = idPage;
	}
	
	public Photo() {
		
	}
	
	public int getIdPhoto() {
		return idPhoto;
	}
	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}
	public String getParametresRetouche() {
		return parametresRetouche;
	}
	public void setParametresRetouche(String parametresRetouche) {
		this.parametresRetouche = parametresRetouche;
	}
	public int getIdPage() {
		return idPage;
	}
	public void setIdPage(int idPage) {
		this.idPage = idPage;
	}
	
	
}