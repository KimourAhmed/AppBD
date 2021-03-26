package tables;

import java.util.HashSet;
import java.util.Set;

public class Cadre extends Impression {
	private Set<Page> listPages = new HashSet<Page>(1); //Liste des pages
	
	public Cadre(int idCadre, String reference) {	
		super(idCadre, reference);
	}
	
	public Cadre() {
	}
	
	public Set<Page> getListPages() {
		return listPages;
	}

	public void setListPages(Set<Page> listPages) {
		this.listPages = listPages;
	}
	
	
}
