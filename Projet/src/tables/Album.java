package tables;

import java.util.HashSet;
import java.util.Set;

public class Album extends Impression{
	String titre;
	int idPhoto;
	private Set<Page> listPages = new HashSet<Page>(); //Liste des pages
	
	public Album(int idAlbum, String reference, String titre, int idPhoto) {
		super(idAlbum, reference);
		setTitre( titre);
		setIdPhoto(idPhoto);
	}
	
	public Album() {
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


	public Set<Page> getListPages() {
		return listPages;
	}

	public void setListPages(Set<Page> listPages) {
		this.listPages = listPages;
	}
	
	//Ajoute
		public void addPage(Page page){
			this.listPages.add(page); 
		}
			
		//Retire 
		public void removePage(Page page){
			this.listPages.remove(page); 
		}
	
		
	
	@Override
	public String toString() {
		String str=super.toString();
		str += "Titre : " + this.getTitre() + "\n";
        str += "IdPhoto : " + this.getIdPhoto() + "\n";
        str += "Liste des Pages : " + this.getListPages() + "\n";
        return str;
	}

}
