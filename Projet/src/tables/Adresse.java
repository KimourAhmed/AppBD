package tables;
public class Adresse {
	private int idAdr; // Id
	private int numRue; //
	private String nomRue = ""; //
	private String ville = ""; //
	private int codePostal; //
	
	public Adresse(int idAdr, int numRue, String nomRue, String ville, int codePostal) {
		this.idAdr = idAdr;
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	
	public Adresse(){};
	
	public int getIdAdr() { return idAdr; }
	
	public void setIdAdr(int idAdr) { this.idAdr = idAdr; }
	
	public int getNumRue() { return numRue; }
	
	public void setNumRue(int numRue) { this.numRue = numRue; }
	
	public String getNomRue() { return nomRue; }
	
	public void setNomRue(String nomRue) { this.nomRue = nomRue; }
	
	public String getVille() { return ville; }
	
	public void setVille(String ville) { this.ville = ville; }
	
	public int getCodePostal() { return codePostal; }
	
	public void setCodePostal(int codePostal) { this.codePostal = codePostal; }
	
}
