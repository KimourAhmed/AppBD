package jdbc;
import java.sql.*;

public class Menu {
	protected static void clientOuGestion() throws SQLException {
		int choix1;
	    do {
	    	System.out.println("1- Interface Client");
	  	    System.out.println("2- Interface Gestion");
	  	    System.out.println();
			System.out.print("Choix : ");
			System.out.flush();
			choix1 = LectureClavier.lireEntier("");
			System.out.println(">> " + choix1);
	  	    System.out.println();
	    } while (choix1!=1 && choix1!=2);
	    
	    switch(choix1) {
	  	    case 1:
	  	    	System.out.println("Interface Client");
	  	    	System.out.println("----------------");
	  	    	interfaceClient();
	  	    	break;
	  	    case 2: 
	  	    	System.out.println("Interface Gestion");
	  	    	System.out.println("-----------------");
	  	    	interfaceGestion();
	  	    	break;
	  	    default: 
	  	    	break;
	    }
	}

	private static void interfaceClient() throws SQLException {
		int choix2;
  	    int idC = 0;
  	    do {
  	    	System.out.println("1- Connexion : ");
  	  	    System.out.println("2- Nouveau client : ");
  	  	    System.out.println();
  			//System.out.print("Choix : ");
  			System.out.flush();
  			choix2 = LectureClavier.lireEntier("Choix : ");
  			System.out.println(">> " + choix2);
  	  	    System.out.println();
  	    } while (choix2!=1 && choix2!=2);
  	    
  	    switch(choix2) {
	  	    case 1:
	  	    	idC = ConnexCreatClient.connexionClient();
	  	    	break;
	  	    case 2: 
	  	    	idC = ConnexCreatClient.creationClient();
	  	    	break;
	  	    default: 
	  	    	break;
  	    }

		int choix3=0;
		do {
			System.out.println("\n#### MENU PRINCIPAL #####");
			System.out.println(">> Vous voulez : ");
			System.out.println("   1- Upload une image (saisissez un chemin d'accès)");
			System.out.println("   2- Créer une impression (tirage, album, calendrier, cadre)"); // /!\ a partir de fich imag telecharge ou partage
			System.out.println("   3- Supprimer une image (saisissez un chemin d'accès)"); // /!\ 	Pas possible si partagé
			System.out.println("   4- Consulter");
			System.out.println("   5- Saisir une commande");
			System.out.println("   6- Quitter\n");
			
			System.out.flush();
		    choix3 = LectureClavier.lireEntier("Votre choix : ");
		    
		    switch(choix3) {
			    case 1:
			    	Fonctionnalites.uploadImage(idC);
			    	break;
			    case 2:
			    	Fonctionnalites.creerImpression();
			    	break;
			    case 3:
			    	Fonctionnalites.supprimerImage();
			    	break;
			    case 4:
			    	Fonctionnalites.consulter(idC);
			    	break;
			    case 5:
			    	Fonctionnalites.saisirCommande();
			    	break;
			    default:
			    	System.out.println("Déconnexion. Aurevoir.");
			    	break;
		    }
		} while(choix3!=6);
	}
	
	protected static void interfaceGestion() throws SQLException {
		Fonctionnalites.updateState();
	}
}
