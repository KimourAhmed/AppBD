package tables;

import java.util.HashSet;
import java.util.Set;

public class Calendrier extends Impression {
	  private Set<Page> listPages = new HashSet<Page>(12); //Liste des pages
	  
	 public Calendrier(int idCal, String reference) {
			super(idCal, reference);
		}
	 
	public Calendrier() {
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
        str += "Liste des Pages : " + this.getListPages() + "\n";
        return str;
	}
	
}



