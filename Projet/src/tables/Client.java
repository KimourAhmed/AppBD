package tables;

public class Client {
	int idClient;
	String adrMail;
	String name;
	String prenom;
	String mdp;
	int idAdr;
	
	public Client(int idClient, String adrMail, String name, String prenom, String mdp, int idAdr) {
		this.idClient = idClient;
		this.adrMail = adrMail;
		this.name = name;
		this.prenom = prenom;
		this.mdp = mdp;
		this.idAdr = idAdr;
	}

	public Client() {
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getAdrMail() {
		return adrMail;
	}

	public void setAdrMail(String adrMail) {
		this.adrMail = adrMail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getIdAdr() {
		return idAdr;
	}

	public void setIdAdr(int idAdr) {
		this.idAdr = idAdr;
	}
	
	
}