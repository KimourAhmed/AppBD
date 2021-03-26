package tables;

import java.util.HashSet;
import java.util.Set;

public class Tirage extends Impression{
	String cheminAcces;
	private Set<Photo> listPhotos = new HashSet<Photo>(); //Liste des photos
	
	public Tirage(int idTir, String reference, String cheminAcces) {
		super (idTir, reference);
		setCheminAcces(cheminAcces);
	}
	
	public Tirage() {
		
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
	public void removePage(Photo photo){
		this.listPhotos.remove(photo); 
	}
	public String getCheminAcces() {
		return cheminAcces;
	}

	public void setCheminAcces(String cheminAcces) {
		this.cheminAcces = cheminAcces;
	}
		
	@Override
	public String toString() {
		String str=super.toString();
        str += "Liste des Photos : " + this.getListPhotos() + "\n";
        return str;
	}
	
}
