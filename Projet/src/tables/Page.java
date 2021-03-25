package tables;

import java.util.HashSet;
import java.util.Set;

public class Page {
	int idPage;
	String textDescriptif;
	String miseEnForme;
	int idImpr;
	private Set<Photo> listPhotos = new HashSet<Photo>(); //Liste des photos
	

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
	
	public Set<Photo> getListPhotos() {
		return listPhotos;
	}

	public void setListPhotos(Set<Photo> listPhotos) {
		this.listPhotos = listPhotos;
	}

	//Ajoute
	public void addPhoto(Photo photo){
			this.listPhotos.add(photo); 
	}
			
	//Retire 
	public void removePhoto(Photo photo){
		this.listPhotos.remove(photo); 
	}
	
}

