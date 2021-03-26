package jdbc;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import dao.*;
import tables.*;
 

public class squelette_appli {
	
//	static final String CONN_URL = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";

// Ne pas oublier d'anomymiser le PASSWD avant de rendre votre travail
	
//	static final String USER = "A COMPLETER";
//	static final String PASSWD = "A COMPLETER";

	private static final String configurationFile = "src/BD.properties";
	static Connection conn; 
	
    public static void main(String args[]) {
    	
        try {
	  	    // Enregistrement du driver Oracle
	  	    System.out.print("Loading Oracle driver... "); 
	  	    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	  	    System.out.println("loaded");
	  	    
		    
	  	    // Etablissement de la connection
		    DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
	  	    System.out.print("Connecting to the database... "); 
	 	    conn = DriverManager.getConnection(dap.getDatabaseUrl(), dap.getUsername(),dap.getPassword());
	   	    System.out.println("connected");
	  	    
	  	    conn.setAutoCommit(true);
	
		    // code métier de la fonctionnalité
	  	    System.out.println("##########################");
	  	    System.out.println("# Bienvenue sur PhotoNum #");
	  	    System.out.println("##########################");
	  	    System.out.println();
	  	    
	  	    int cOuG = clientOuGestion();
	  	    switch(cOuG) {
		  	    case 1:
		  	    	int idC = interfaceClient();
		  	    	break;
		  	    case 2:
		  	    	interfaceGestion();
		  	    	break;
		  	    default:
		  	    	break;
	  	    }
	  	    
	  	    // Liberation des ressources et fermeture de la connexion...
	       	// A COMPLETER
	 		conn.close(); 
	 	    
	  	    System.out.println("bye.");
  	    
	  	  // traitement d'exception
          } catch (SQLException e) {
              System.err.println("failed");
              System.out.println("Affichage de la pile d'erreur");
  	          e.printStackTrace(System.err);
              System.out.println("Affichage du message d'erreur");
              System.out.println(e.getMessage());
              System.out.println("Affichage du code d'erreur");
  	          System.out.println(e.getErrorCode());	    

          }
     }



	private static int clientOuGestion() {
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
	  	    	//interfaceClient();
	  	    	break;
	  	    case 2: 
	  	    	System.out.println("Interface Gestion");
	  	    	System.out.println("-----------------");
	  	    	//interfaceGestion();
	  	    	break;
	  	    default: 
	  	    	break;
	    }
	    return choix1;
	}

	
	private static int interfaceClient() throws SQLException {
		int choix2;
  	    int idC = 0;
  	    do {
  	    	System.out.println("1- Connexion : ");
  	  	    System.out.println("2- Nouveau client : ");
  	  	    System.out.println();
  			System.out.print("Choix : ");
  			System.out.flush();
  			choix2 = LectureClavier.lireEntier("");
  			System.out.println(">> " + choix2);
  	  	    System.out.println();
  	    } while (choix2!=1 && choix2!=2);
  	    
  	    ResultSet result;
  	    switch(choix2) {
	  	    case 1:
	  	    	do {
	  	    		//connexionClient();
		  	    	System.out.println("Vous vous connecter.");
		  	    	System.out.println(">> Entrez votre adresse mail: ");
		  	    	System.out.flush();
		  	    	String mailClient = LectureClavier.lireChaine();
		  	    	System.out.println(">> Entrez votre mot de passe: ");
		  	    	System.out.flush();
		  	    	String mdpClient = LectureClavier.lireChaine();
		  	    	
		  	    	String query = "SELECT idClient, nom FROM LesClients WHERE adrMail='" + mailClient + "'" + " AND mdp='" + mdpClient +"'";
		  	    	result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
		            executeQuery(query);
	  	    	} while(!result.first());
	  	    	
	  	    	System.out.println("Welcome back, " + result.getString("nom")); //temp
	  	    	idC = result.getInt("idClient");
	  	    	
	  	    	break;
	  	    case 2: 
	  	    	//creationClient();
	  	    	System.out.println("Vous créez un nouveau compte.");
	  	    	System.out.print(">> Veuillez entrer une adresse mail : ");
	  	    	System.out.flush();
	  	    	String newMailClient = LectureClavier.lireChaine();
	  			System.out.print(">> Veuillez entrer un nom : ");
	  			System.out.flush();
	  	    	String newNomClient = LectureClavier.lireChaine();
	  			System.out.print(">> Veuillez entrer un prénom : ");
	  			System.out.flush();
	  	    	String newPrenomClient = LectureClavier.lireChaine();
	  			System.out.print(">> Veuillez entrer un mot de passe : ");
	  			System.out.flush();
	  	    	String newMdpClient = LectureClavier.lireChaine();
	  	    	
	  			System.out.print(">> Veuillez entrer un numero d'adresse de livraison : ");		
	  			System.out.flush();
	  	    	String newNumAdresseClient = LectureClavier.lireChaine();
	  	    	
	  	    	System.out.print(">> Veuillez entrer un nom d'adresse de livraison : ");		
	  			System.out.flush();
	  	    	String newNomAdresseClient = LectureClavier.lireChaine();
	  	    	
	  	    	System.out.print(">> Veuillez entrer une ville de livraison : ");		
	  			System.out.flush();
	  	    	String newVilleClient = LectureClavier.lireChaine();
	  	    	
	  	    	System.out.print(">> Veuillez entrer un code postal de livraison : ");		
	  			System.out.flush();
	  	    	String newCodePostalClient = LectureClavier.lireChaine();
	  	    	
	  	    	
	  	    	String query = "SELECT MAX(idClient)+1 as idClient FROM LesClients";
	  	    	System.out.println("Query 1 : " + query);
	  	    	result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
	            executeQuery(query);
	  	    	result.next();
	  	    	int newIdClient = result.getInt("idClient");
	  	    	int newIdAdrClient = result.getInt("idClient");
	  	    	
	  	    	//Client nouveauClient = Client(newIdClient, newMailClient, newNomClient, newPrenomClient, newMdpClient, newIdAdrClient);
	  	    	
	  	    	String query2 = "INSERT INTO LesAdresses VALUES ("+newIdAdrClient+", "+newNumAdresseClient+", '" +newNomAdresseClient+"', '"
	  		  	    	+ newVilleClient+"', "+newCodePostalClient+")";
	  	    	
	  	    	int j = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
	  		            executeUpdate(query2);
	  		  	    	if (j==1) {
	  		  	    		System.out.println("L'adresse a été ajouté: " + newNumAdresseClient + " " + newNomAdresseClient+ " à " +
	  		  	    	newVilleClient +" " + newCodePostalClient);
	  		  	    	} else {
	  		  	    		System.out.println("Erreur.");
	  		  	    	}
	  	    	
	  	    	
	  		  	String query3 = "INSERT INTO LesClients VALUES ("+newIdClient+", '"+newMailClient+"', '" +newNomClient+"', '"
                            + newPrenomClient+"', '"+newMdpClient+"', " +newIdAdrClient +")";
	  		  	
	  	    	System.out.println("Query 3: " + query3);
	  	    	int i = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
	            executeUpdate(query3);
	  	    	if (i==1) {
	  	    		System.out.println("Bienvenue, " + newNomClient + " " + newPrenomClient);
	  	    	} else {
	  	    		System.out.println("Erreur.");
	  	    	}
	  	    	idC = newIdClient;
	  	    	break;
	  	    default: 
	  	    	break;
  	    }
  	    
  	    
  	    DAO<Client> clientDao = new ClientDAO(conn);
		Client client = clientDao.read(idC);
		System.out.println(client.getName() + " " + client.getPrenom() + " a : ");
		System.out.println("   • Les commandes : ");
		for(Commande com : client.getListCommandes()) {
			System.out.println("\t * " + com.getIdCommande());
		}
		System.out.println("   • Les fichiers images : ");
		for(FichierImages fich : client.getListFichierImages()) {
			System.out.println("\t * " + fich.getCheminAcces());
		}
	
		System.out.println(">> Vous voulez : ");
		System.out.println("   1- Upload une image (saisissez un chemin d'accès)");
		System.out.println("   2- Créer une impression ((tirage, album, calendrier, cadre)"); // /!\ a partir de fich imag telecharge ou partage
		System.out.println("   3- Supprimer une image (saisissez un chemin d'accès)"); // /!\ 	Pas possible si partagé
		System.out.println("   4- Consultation");
		System.out.println("   5- Saisir une commande");
		
		System.out.flush();
	    int choix3 = LectureClavier.lireEntier("");
	    
	    switch(choix3) {
		    case 1:
		    	uploadImage(idC);
		    	break;
		    case 2:
		    	creerImpression();
		    	break;
		    case 3:
		    	supprimerImage();
		    	break;
		    case 4:
		    	consulter();
		    	break;
		    case 5:
		    	saisirCommande();
		    	break;
		    default:
		    	break;
	    	
	    }
	    return idC;
	}

	private static void creationClient() {
		// TODO Auto-generated method stub
		
	}

	private static void connexionClient() {
		// TODO Auto-generated method stub
		
	}

	private static void interfaceGestion() {
		// TODO Auto-generated method stub
		
	}
	
	private static void saisirCommande() {
		// TODO Auto-generated method stub
		
	}


	private static void consulter() {
		// TODO Auto-generated method stub
		
	}


	private static void supprimerImage() {
		System.out.print(">>Entrez un chemin d'acces du fichier à supprimer : ");
    	System.out.flush();
    	String removeCheminAcces = LectureClavier.lireChaine();
		
    	DAO<FichierImages> fichierImageDao = new FichierImagesDAO(conn);
    	FichierImages fichier = new FichierImages();
    	fichier.setCheminAcces(removeCheminAcces);
    	((FichierImagesDAO) fichierImageDao).read(removeCheminAcces);
    	fichierImageDao.delete(fichier);
    	System.out.println("Le fichier image " + removeCheminAcces + " a été supprimé.");
	}


	private static void creerImpression() throws SQLException {
		// TODO Auto-generated method stub
		System.out.print(">>Entrez le type d'impression (1:tirage, 2:album, 3:calendrier, 4:cadre): ");
    	System.out.flush();
    	String typeImpression = LectureClavier.lireChaine();
    	
    	
    	String query = "SELECT idImpr FROM LesImpressions";
    	System.out.println("\n" + query);
    	ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
        executeQuery(query);
    	String tab[]=new String[99];
    	int i=0;
    	result.next();
    	while (result.next ()){
    		tab[i]=result.getString(1);
    		i++;
    	}
    	int maxParType=0;
    	for(int j=0; j<i; j++) {
    		if (Integer.parseInt(tab[j]) < Integer.parseInt(typeImpression)*1000+1000 && 
    				Integer.parseInt(tab[j]) >= Integer.parseInt(typeImpression)*1000){
    			if (maxParType <= Integer.parseInt(tab[j])){
    				maxParType=Integer.parseInt(tab[j]);
    			}
    		}
    	}
    	System.out.print(">>Entrez la reference de l'impression: ");
    	System.out.flush();
    	String refImpression = LectureClavier.lireChaine();
    	
    	
    	switch(typeImpression) {
		    case "1": //tirage
		    	System.out.print(">>Entrez un chemin d'acces d'une image: ");
		    	System.out.flush();
		    	String ajoutChemin = LectureClavier.lireChaine();
		    	DAO<Tirage> tirageDao = new TirageDAO(conn);
		    	Tirage tirage = new Tirage();
		    	tirage.setIdImpr(maxParType+1-(1000*Integer.parseInt(typeImpression)));
		    	tirage.setReference(refImpression);
		    	tirage.setCheminAcces(ajoutChemin);
		    	tirageDao.create(tirage);
		    	break;
		    	
		    case "2"://album
		    	System.out.print(">>Entrez le titre de l'album: ");
		    	System.out.flush();
		    	String titreAlbum = LectureClavier.lireChaine();
		    	
		    	System.out.print(">>Entrez un chemin d'acces d'image de couverture: ");
		    	System.out.flush();
		    	String ajoutCheminAccesAlb = LectureClavier.lireChaine();
		    	
		    	DAO<FichierImages> fichierImageDao = new FichierImagesDAO(conn);
		    	FichierImages fichier = ((FichierImagesDAO) fichierImageDao).read(ajoutCheminAccesAlb);
		    	int idPhoto=fichier.getIdPhoto();
		    	DAO<Album> albumDao = new AlbumDAO(conn);
		    	Album album = new Album();
		    	album.setIdImpr(maxParType+1-(1000*Integer.parseInt(typeImpression)));
		    	album.setReference(refImpression);
		    	album.setTitre(titreAlbum);
		    	album.setIdPhoto(idPhoto);
		    	
		    	
		    	Set<Page> listPagesAlb= new HashSet<Page>();
		    	Page pageAlb = new Page();
		    	String requete1 = "SELECT MAX(idPage) as idPage FROM LesPages";
	  	    	System.out.println("Query 1 : " + requete1);
	  	    	result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
	            executeQuery(requete1);
	  	    	result.next();
	  	    	int valeurPageAlb=result.getInt("IdPage");
	  	    	Set<Photo> photosAlb= new HashSet<Photo>();
		    	boolean res1=false;
		    	int nbPageAlb=1;
		    	while(!res1){
		    		System.out.print(">>Entrez un text Descriptif pour la page "+ nbPageAlb +" :");
		    		String textDescAlb = LectureClavier.lireChaine();
		    		
		    		System.out.print(">>Entrez une mise en forme pour la page "+ nbPageAlb +" :");
		    		String miseEnFormAlb = LectureClavier.lireChaine();
		    		
			    	boolean res2=false;
			    	while(!res2) {
			    		System.out.print(">>Voulez vous ajoutez une image: O/N ");
				    	System.out.flush();
				    	String reponse1 = LectureClavier.lireChaine();
				    	if (reponse1.equals("N")){
				    		res2=true;
				    	}
				    	else {
				    		System.out.print(">>Entrez un chemin d'acces d'image de couverture: ");
					    	System.out.flush();
					    	String AlbCheminAcces = LectureClavier.lireChaine();
					    	
					    	DAO<FichierImages> fichierImageDaoAlb = new FichierImagesDAO(conn);
					    	FichierImages fichierAlb = ((FichierImagesDAO) fichierImageDaoAlb).read(AlbCheminAcces);
					    	
					    	Photo photoAlb = new Photo();
					    	photoAlb.setIdPhoto(fichierAlb.getIdPhoto());
					    	photoAlb.setIdPage(valeurPageAlb+nbPageAlb);
					    	photosAlb.add(photoAlb);
				    	}
			    	}
			    	
		    		pageAlb.setIdImpr(maxParType+1-(1000*Integer.parseInt(typeImpression)));
		    		pageAlb.setIdPage(valeurPageAlb+nbPageAlb);
		    		pageAlb.setTextDescriptif(textDescAlb);
		    		pageAlb.setMiseEnForme(miseEnFormAlb);
		    		pageAlb.setListPhotos(photosAlb);
		    		listPagesAlb.add(pageAlb);
		    		System.out.print(">>Voulez vous ajoutez une page: O/N ");
			    	System.out.flush();
			    	String reponse2 = LectureClavier.lireChaine();
			    	if (reponse2.equals("N")){
			    		res1=true;
			    	}
		    	}
		    	
		    	album.setListPages(listPagesAlb);
		    	albumDao.create(album);
		    	break;
		    	
		    	
		    case "3"://calendrier
		    	DAO<Calendrier> calendrierDao = new CalendrierDAO(conn);
		    	Calendrier calendrier = new Calendrier();
		    	calendrier.setIdImpr(maxParType+1-(1000*Integer.parseInt(typeImpression)));
		    	calendrier.setReference(refImpression);
		    	Set<Page> listPages= new HashSet<Page>();
		    	Page page = new Page();
		    	
		    	
	  	    	String requete = "SELECT MAX(idPage) as idPage FROM LesPages";
	  	    	System.out.println("Query 1 : " + requete);
	  	    	result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
	            executeQuery(requete);
	  	    	result.next();
	  	    	int valeurPage=result.getInt("IdPage");
	  	    	Set<Photo> photos= new HashSet<Photo>();
		    	
		    	for(int h=1;h<=12;h++) {
		    		System.out.print(">>Entrez un text Descriptif pour la page "+ h +" :");
		    		String textDesc = LectureClavier.lireChaine();
		    		
		    		System.out.print(">>Entrez une mise en forme pour la page "+ h +" :");
		    		String miseEnForm = LectureClavier.lireChaine();
			    	
			    	boolean res=false;
			    	while(!res) {
			    		System.out.print(">>Voulez vous ajoutez une image: O/N ");
				    	System.out.flush();
				    	String reponse = LectureClavier.lireChaine();
				    	if (reponse.equals("N")){
				    		res=true;
				    	}
				    	else {
				    		System.out.print(">>Entrez un chemin d'acces d'image de couverture: ");
					    	System.out.flush();
					    	String CalendCheminAcces = LectureClavier.lireChaine();
					    	
					    	DAO<FichierImages> fichierImageDaoCal = new FichierImagesDAO(conn);
					    	FichierImages fichierCal = ((FichierImagesDAO) fichierImageDaoCal).read(CalendCheminAcces);
					    	
					    	Photo photo = new Photo();
					    	photo.setIdPhoto(fichierCal.getIdPhoto());
					    	photo.setIdPage(valeurPage+h);
					    	photos.add(photo);
				    	}
			    	}
			    	
		    		page.setIdImpr(maxParType+1-(1000*Integer.parseInt(typeImpression)));
		    		page.setIdPage(valeurPage+h);
		    		page.setTextDescriptif(textDesc);
		    		page.setMiseEnForme(miseEnForm);
		    		page.setListPhotos(photos);
		    		listPages.add(page);
		    	}
		    	calendrier.setListPages(listPages);
		    	calendrierDao.create(calendrier);
		    	break;
		    	
		    case "4"://Cadre
		    	DAO<Cadre> cadreDao = new CadreDAO(conn);
		    	Cadre cadre = new Cadre();
		    	cadre.setIdImpr(maxParType+1-(1000*Integer.parseInt(typeImpression)));
		    	cadre.setReference(refImpression);
		    	
		    	Set<Page> listPagesCadre= new HashSet<Page>();
		    	Page pageCadre = new Page();
		    	
	  	    	String requeteCadre = "SELECT MAX(idPage) as idPage FROM LesPages";
	  	    	System.out.println("Query 1 : " + requeteCadre);
	  	    	result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
	  		            executeQuery(requeteCadre);
	  		  	result.next();
	  		  	int valeurPageCadre=result.getInt("IdPage");
	  	    	
	  	    	Set<Photo> photosCadre= new HashSet<Photo>();

	  	    	System.out.print(">>Entrez un text Descriptif pour la page :");
	    		String textDescCadre = LectureClavier.lireChaine();
	    		
	    		System.out.print(">>Entrez une mise en forme pour la page :");
	    		String miseEnFormCadre = LectureClavier.lireChaine();
	    		
	    		System.out.print(">>Entrez un chemin d'acces d'image: ");
		    	System.out.flush();
		    	String CadreCheminAcces = LectureClavier.lireChaine();
		    	
		    	DAO<FichierImages> fichierImageDaoCadre = new FichierImagesDAO(conn);
		    	FichierImages fichierCadre = ((FichierImagesDAO) fichierImageDaoCadre).read(CadreCheminAcces);
		    	
		    	Photo photoCadre = new Photo();
		    	photoCadre.setIdPhoto(fichierCadre.getIdPhoto());
		    	photoCadre.setIdPage(valeurPageCadre+1);
		    	photosCadre.add(photoCadre);
		    	
		    	pageCadre.setIdImpr(maxParType+1-(1000*Integer.parseInt(typeImpression)));
	    		pageCadre.setIdPage(valeurPageCadre+1);
	    		pageCadre.setTextDescriptif(textDescCadre);
	    		pageCadre.setMiseEnForme(miseEnFormCadre);
	    		pageCadre.setListPhotos(photosCadre);
	    		listPagesCadre.add(pageCadre);
	  	    	cadre.setListPages(listPagesCadre);
		    	cadreDao.create(cadre);
		    	break;
		    	
		    default:
		    	break;
    	
    		}
    	
	}


	private static void uploadImage(int idC) throws SQLException {
    	System.out.print(">>Entrez un chemin d'acces d'image: ");
    	System.out.flush();
    	String ajoutCheminAcces = LectureClavier.lireChaine();
    	System.out.print(">>Entrez une information de prise de vue: ");
    	System.out.flush();
    	String ajoutInfoPDV = LectureClavier.lireChaine();
    	System.out.print(">>Entrez la resolution de l'image: ");
    	System.out.flush();
    	int ajoutResImage = LectureClavier.lireEntier("");
    	System.out.print(">>Voulez vous le partagez:(0: Non / 1: Oui) ");
    	System.out.flush();
    	int ajoutEstPartage = LectureClavier.lireEntier("");
    	System.out.print(">>Quels paramètres de retouches voulez-vous ajouter? ");
    	System.out.flush();
    	String ajouteParamRetouches = LectureClavier.lireChaine();
    	
    	String query4 = "SELECT MAX(idPhoto)+1 as idPhoto FROM LesFichierImages";
    	System.out.println("\n" + query4);
    	ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
        executeQuery(query4);
    	result.next();
    	
    	DAO<Photo> photoDao = new PhotoDAO(conn);
    	Photo photo = new Photo();
    	photo.setIdPhoto(result.getInt("idPhoto"));
    	photo.setParametresRetouche(ajouteParamRetouches);
    	photo.setIdPage(-1);
    	photoDao.create(photo);
		
    	DAO<FichierImages> fichierImageDao = new FichierImagesDAO(conn);
    	FichierImages fichier = new FichierImages();
    	fichier.setCheminAcces(ajoutCheminAcces);
    	fichier.setInfoPriseDeVue(ajoutInfoPDV);
    	fichier.setResolutionImage(ajoutResImage);
    	fichier.setestPartage(ajoutEstPartage);
    	fichier.setIdClient(idC);
    	fichier.setIdPhoto(result.getInt("idPhoto"));
    	fichierImageDao.create(fichier);
	}
	
}