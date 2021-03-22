import java.sql.*;
import java.util.*;


public class Client {
		
		private String adrMail;
	    private String nom;
	    private String prenom;
	    private String password;
	    private Adresse adrpostal;
	    
	    
		
	    public Client(String adresseMail, String nom, String prenom, String password, Adresse adrpostal) {
	    	
			this.adrMail = adresseMail;
			this.nom = nom;
			this.prenom = prenom;
			this.password = password;
			this.adrpostal = adrpostal;
			
		}


		public String getAdresseMail() {
			return adrMail;
		}

		public String getNom() {
			return nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public String getPassword() {
			return password;
		}

		public Adresse getadrpostal() {
			return adrpostal;
			
		}
		
		public Adresse getAdresse() {
			return adrpostal;
		}
			
		
		public void setNom(String nom) {
			this.nom = nom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		
	
		public void setPassword(String password) {
			this.password = password;
		}
		
		public void setadrpostal(Adresse adressepostale) {
			this.adrpostal =  adressepostale;			
		}
		

		public String toString() {
			return "Client [adresseMail=" + adrMail + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password+ "]";
		}		
	          }	     
		


