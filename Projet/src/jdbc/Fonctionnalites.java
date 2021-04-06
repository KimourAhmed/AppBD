package jdbc;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import dao.*;
import tables.*;

public class Fonctionnalites extends ConnexCreatClient {

	protected static void uploadImage(int idC) throws SQLException {
    	System.out.print(">> Entrez un chemin d'acces d'image: ");
    	System.out.flush();
    	String ajoutCheminAcces = LectureClavier.lireChaine();
    	System.out.print(">> Entrez une information de prise de vue: ");
    	System.out.flush();
    	String ajoutInfoPDV = LectureClavier.lireChaine();
    	System.out.print(">> Entrez la resolution de l'image: ");
    	System.out.flush();
    	int ajoutResImage = LectureClavier.lireEntier("");
    	System.out.print(">> Voulez vous le partagez:(0: Non / 1: Oui) ");
    	System.out.flush();
    	int ajoutEstPartage = LectureClavier.lireEntier("");
    	System.out.print(">> Quels paramÃ¨tres de retouches voulez-vous ajouter? ");
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
    	fichier.setConservation(10);
    	fichierImageDao.create(fichier);
	}

	protected static void supprimerImage() {
		System.out.print(">> Entrez un chemin d'acces du fichier Ã  supprimer : ");
    	System.out.flush();
    	String removeCheminAcces = LectureClavier.lireChaine();
		
    	DAO<FichierImages> fichierImageDao = new FichierImagesDAO(conn);
    	FichierImages fichier = new FichierImages();
    	fichier.setCheminAcces(removeCheminAcces);
    	((FichierImagesDAO) fichierImageDao).read(removeCheminAcces);
    	fichierImageDao.delete(fichier);
    	System.out.println("Le fichier image " + removeCheminAcces + " a Ã©tÃ© supprimÃ©.");
	}
	
	protected static void consulter(int idC) throws SQLException {
		/* DiffÃ©rentes fonctions de consultation : dÃ©tails de la commande d'un client avec son statut, 
		 * les informations d'un compte client avec sa liste de codes promo encore valables, liste des 
		 * impressions d'un client avec possibilitÃ© de dÃ©tailler le contenu, la liste des images partagÃ©es. */
		DAO<Client> clientDao = new ClientDAO(conn);
		Client client = clientDao.read(idC);
		//System.out.println(client.getNom() + " " + client.getPrenom() + " a : ");
		
		System.out.println("\n### Menu Consultation ###");
		System.out.println(">> Vous voulez consulter : ");
		System.out.println("   1- Les dÃ©tails de vos commandes");
		System.out.println("   2- Vos codes promos disponibles");
		System.out.println("   3- Vos images");
		System.out.println("   4- Vos impressions");
		System.out.println("   5- La liste des images partagées\n");
		int choix = LectureClavier.lireEntier("Choix : ");
		
		switch(choix) {
			case 1: 
				ResultSet result;
				int code;
				System.out.println("   â€¢ Les commandes : ");
				for(Commande com : client.getListCommandes()) { 
					result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
				    executeQuery("SELECT * FROM LesCommandes WHERE idCommande="+com.getIdCommande());
				    result.next();
					System.out.println("\t * Commande: " + com.getIdCommande() + " || Statut: " + com.getStatut()); 
				}
				break;
			case 2: 
				ArrayList<Integer> codesPromos = new ArrayList<>();
				for(Commande com : client.getListCommandes()) { 
					result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
				    executeQuery("SELECT codeProm FROM LesCommandes NATURAL LEFT JOIN LesPromotions WHERE idCommande="+com.getIdCommande());
				    result.next();
				    code = result.getInt("codeProm");
				    codesPromos.add(code);
				    System.out.println("   â€¢ Les codes promos : ");
					if (code != 0) {
				    System.out.println("\t * Commande: " + com.getIdCommande() + " || Statut: " + com.getStatut() + 
							" || Code Promo: " + code); 
					} else {
						System.out.println("\t * Commande: " + com.getIdCommande() + " || Statut: " + com.getStatut() + 
								" || Pas de code disponible pour cette commande."); 
					}
				}
				break;
			case 3: 
				System.out.println("   â€¢ Les Images : ");
                String rep1 = "SELECT cheminAcces FROM LesFichierImages NATURAL JOIN LesClients WHERE idClient="+idC;
                  result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
                executeQuery(rep1);
                  
                String tab[]=new String[99];
                  int i=0;
                  result.next();
                  while (result.next()){
                      tab[i]=result.getString(1);
                      i++;
                  }
                  DAO<FichierImages> fichierImageDao = new FichierImagesDAO(conn);
                  for(int j=0;j<i;j++) {
                      System.out.println("       - Pour le fichier: : "+ tab[j]);
                      FichierImages fichier = ((FichierImagesDAO) fichierImageDao).read(tab[j]);
                      System.out.println("              * Info prise de vue: "+ fichier.getInfoPriseDeVue());
                      System.out.println("              * Resolution: "+ fichier.getResolutionImage());
                      System.out.println("              * EstPartage: "+ fichier.getEstPartage());
                      System.out.println("              * Conservation (jours): "+ fichier.getConservation());
                      System.out.println();
                  }
                break;
			case 4: 
				System.out.println("   â€¢ Les Impressions : ");
                String res = "SELECT IDIMPR, REFERENCE FROM LesImpressions NATURAL LEFT JOIN LesArticles NATURAL LEFT JOIN LesCommandes "
                		+ "WHERE IDCLIENT=" + idC;
                  result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
                executeQuery(res);
                  while (result.next())
                System.out.println("\t * " + result.getString("idImpr") + " " + result.getString("reference"));
				break;
			case 5: 
				System.out.println("   â€¢ Les fichiers images : ");
                String rep = "SELECT cheminAcces FROM LesFichierImages WHERE estPartage=1";
                  result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
                executeQuery(rep);
                  if (result.next())
                System.out.println("\t * " + result.getString("cheminAcces"));
				break;
		}
		System.out.println();
	}
	
	protected static void creerImpression() throws SQLException {
		// TODO Auto-generated method stub
		System.out.print(">> Entrez le type d'impression (1: Tirage, 2: Album, 3: Calendrier, 4: Cadre): ");
    	System.out.flush();
    	String typeImpression = LectureClavier.lireChaine();
    	
    	String query = "SELECT idImpr FROM LesImpressions";
    	System.out.println("\n" + query);
    	ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
        executeQuery(query);
    	String tab[]=new String[99];
    	int i=0;
    	result.next();
    	while (result.next()){
    		tab[i]=result.getString(1);
    		i++;
    	}
    	int maxParType=0;
    	/* On va chercher dans la table tab la valeur la plus grande par type
    	 * Ex: Si on a choisi tirage on va chercher la valeur la plus grande entre 1000 et 1999
    	 * Ex: Si on a choisi Calendrier on va chercher*/
    	for(int j=0; j<i; j++) {
    		if (Integer.parseInt(tab[j]) < Integer.parseInt(typeImpression)*1000+1000 && 
    				Integer.parseInt(tab[j]) >= Integer.parseInt(typeImpression)*1000){
    			if (maxParType <= Integer.parseInt(tab[j])){
    				maxParType=Integer.parseInt(tab[j]);
    			}
    		}
    	}
    	System.out.print(">> Entrez la reference de l'impression: ");
    	System.out.flush();
    	String refImpression = LectureClavier.lireChaine();
    	
    	System.out.print(">> Tapez 0 ou 1. Voulez-vous utiliser des fichiers images tÃ©lÃ©chargÃ©s (0)"
    			+ "ou bien Ã  partir des fichiers images partagÃ©s par d'autres utilisateurs (1)? ");
    	System.out.flush();
    	String ChoixT = LectureClavier.lireChaine();
    	if (ChoixT=="1") {
    		String re1 = "SELECT cheminAcces FROM LesFichierImages WHERE estPartage=1";
  	    	System.out.println("Query 1 : " + re1);
  	    	result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
            executeQuery(re1);
  	    	result.next();
  	    	System.out.println("Voici les choix disponnibles : " + result.getString("cheminAcces"));
    	}
    	
    	switch(typeImpression) {
		    case "1": //tirage
		    	System.out.print(">> Entrez un chemin d'acces d'une image: ");
		    	System.out.flush();
		    	String ajoutChemin = LectureClavier.lireChaine();
		    	DAO<Tirage> tirageDao = new TirageDAO(conn);
		    	Tirage tirage = new Tirage();
		    	tirage.setIdImpr(maxParType);
		    	tirage.setReference(refImpression);
		    	tirage.setCheminAcces(ajoutChemin);
		    	tirageDao.create(tirage);
		    	break;  		
		    		
		    case "2"://album
		    	System.out.print(">> Entrez le titre de l'album: ");
		    	System.out.flush();
		    	String titreAlbum = LectureClavier.lireChaine();
		    	
		    	System.out.print(">> Entrez un chemin d'acces d'image de couverture: ");
		    	System.out.flush();
		    	String ajoutCheminAccesAlb = LectureClavier.lireChaine();
		    	
		    	DAO<FichierImages> fichierImageDao = new FichierImagesDAO(conn);
		    	FichierImages fichier = ((FichierImagesDAO) fichierImageDao).read(ajoutCheminAccesAlb);
		    	int idPhoto=fichier.getIdPhoto();
		    	DAO<Album> albumDao = new AlbumDAO(conn);
		    	Album album = new Album();
		    	album.setIdImpr(maxParType+1-(1000*Integer.parseInt(typeImpression))); /* L'idAlbum prend la valeur v= idImpr - 2000 avec 2000 = TypeImpression(2) * 1000.*/
		    	album.setReference(refImpression);
		    	album.setTitre(titreAlbum);
		    	album.setIdPhoto(idPhoto);
		    	
		    	/* On cree une liste de page dans lequelle on demande
		    	 * a l'utilisateur d'entrer des nouvelles pages autant qu'il en a envie
		    	 * avec un text descriptif, une mise en forme et une liste de photos pour chaque page.
				 */
		    	Set<Page> listPagesAlb= new HashSet<Page>();
		    	Page pageAlb = new Page();
		    	String requete1 = "SELECT MAX(idPage) as idPage FROM LesPages";
	  	    	System.out.println("Query 1 : " + requete1);
	  	    	result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
	            executeQuery(requete1);
	  	    	result.next();
	  	    	int valeurPageAlb=result.getInt("IdPage");
	  	    	Set<Photo> photosAlb= new HashSet<Photo>(); //On cree une liste de photo que l'on va mettre dans une page de l'album.
	  	    	DAO<Page> pageDaoAlb = new PageDAO(conn);
	  	    	
		    	boolean res1=false;
		    	int nbPageAlb=1;
		    	while(!res1){
		    		System.out.print(">> Entrez un text Descriptif pour la page "+ nbPageAlb +" :");
		    		String textDescAlb = LectureClavier.lireChaine();
		    		
		    		System.out.print(">> Entrez une mise en forme pour la page "+ nbPageAlb +" :");
		    		String miseEnFormAlb = LectureClavier.lireChaine();
		    		
			    	boolean res2=false;
			    	while(!res2) {
			    		System.out.print(">> Voulez-vous ajouter une image: O/N ");
				    	System.out.flush();
				    	String reponse1 = LectureClavier.lireChaine();
				    	if (reponse1.equals("N")){
				    		res2=true;
				    	}
				    	else {
				    		System.out.print(">> Entrez un chemin d'acces d'image: ");
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
			    	
		    		pageAlb.setIdImpr(maxParType);
		    		pageAlb.setIdPage(valeurPageAlb+nbPageAlb);
		    		pageAlb.setTextDescriptif(textDescAlb);
		    		pageAlb.setMiseEnForme(miseEnFormAlb);
		    		pageAlb.setListPhotos(photosAlb);
		    		
		    		pageDaoAlb.create(pageAlb);
		    		listPagesAlb.add(pageAlb);
		    		System.out.print(">> Voulez-vous ajouter une page: O/N ");
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
		    	/* On cree une liste de 12 page dans lequelle on demande
		    	 * a l'utilisateur d'entrer des nouvelles pages jusqu'a atteindre 
		    	 * avec un text descriptif, une mise en forme et une liste de photos pour chaque 
		    	 */
		    	Page page = new Page();
		    	
	  	    	String requete = "SELECT MAX(idPage) as idPage FROM LesPages";
	  	    	System.out.println("Query 1 : " + requete);
	  	    	result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
	            executeQuery(requete);
	  	    	result.next();
	  	    	int valeurPage=result.getInt("IdPage");
	  	    	Set<Photo> photos= new HashSet<Photo>();
	  	    	DAO<Page> pageDaoCal = new PageDAO(conn);
		    	
		    	for(int h=1;h<=12;h++) {
		    		System.out.print(">> Entrez un text Descriptif pour la page "+ h +" :");
		    		String textDesc = LectureClavier.lireChaine();
		    		
		    		System.out.print(">> Entrez une mise en forme pour la page "+ h +" :");
		    		String miseEnForm = LectureClavier.lireChaine();
			    	
			    	boolean res=false;
			    	while(!res) {
			    		System.out.print(">> Voulez-vous ajouter une image: O/N ");
				    	System.out.flush();
				    	String reponse = LectureClavier.lireChaine();
				    	if (reponse.equals("N")){
				    		res=true;
				    	}
				    	else {
				    		System.out.print(">> Entrez un chemin d'acces d'image: ");
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
			    	
		    		page.setIdImpr(maxParType);
		    		page.setIdPage(valeurPage+h);
		    		page.setTextDescriptif(textDesc);
		    		page.setMiseEnForme(miseEnForm);
		    		page.setListPhotos(photos);
		    		pageDaoCal.create(page);
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

	  	    	System.out.print(">> Entrez un text Descriptif pour la page :");
	    		String textDescCadre = LectureClavier.lireChaine();
	    		
	    		System.out.print(">> Entrez une mise en forme pour la page :");
	    		String miseEnFormCadre = LectureClavier.lireChaine();
	    		
	    		System.out.print(">> Entrez un chemin d'acces d'image: ");
		    	System.out.flush();
		    	String CadreCheminAcces = LectureClavier.lireChaine();
		    	
		    	DAO<FichierImages> fichierImageDaoCadre = new FichierImagesDAO(conn);
		    	FichierImages fichierCadre = ((FichierImagesDAO) fichierImageDaoCadre).read(CadreCheminAcces);
		    	
		    	Photo photoCadre = new Photo();
		    	photoCadre.setIdPhoto(fichierCadre.getIdPhoto());
		    	photoCadre.setIdPage(valeurPageCadre+1);
		    	photosCadre.add(photoCadre);
		    	
		    	pageCadre.setIdImpr(maxParType);
	    		pageCadre.setIdPage(valeurPageCadre+1);
	    		pageCadre.setTextDescriptif(textDescCadre);
	    		pageCadre.setMiseEnForme(miseEnFormCadre);
	    		pageCadre.setListPhotos(photosCadre);
	    		
	    		DAO<Page> pageDaoCadre = new PageDAO(conn);
	    		pageDaoCadre.create(pageCadre);
	    		
	    		listPagesCadre.add(pageCadre);
	  	    	cadre.setListPages(listPagesCadre);
		    	cadreDao.create(cadre);
		    	break;
		    	
		    default:
		    	break;
    		}
	}
	
	/* Fonction pour mettre Ã  jour l'Ã©tat de la commande  : 
     * Changement de l'Ã©tat d'une commande : "PrÃªt Ã  l'envoi", "EnvoyÃ©e". 
     * Une facture est gÃ©nÃ©rÃ©e lors du passage d'une commande Ã  l'Ã©tat "EnvoyÃ©e".
     */
    protected static void updateState() throws SQLException {
		String query = "SELECT * FROM LesCommandes";
		ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE). executeQuery(query);
		ResultSetMetaData rsmd = result.getMetaData();
		int nbCols = rsmd.getColumnCount();
		while(result.next()) {
			for (int i=1; i<=nbCols; i++) {
				System.out.print(result.getString(i) + " | ");	
			}
			System.out.println();
		}
    	
    	System.out.flush();        
        int idCommande = LectureClavier.lireEntier(">> NumÃ©ro de commande Ã  modifier : ");    
        CommandeDAO commandeDao = new CommandeDAO(conn);
        Commande commande = commandeDao.read(idCommande);	

        System.out.flush();
        int stat= LectureClavier.lireEntier(">> Nouveau statut de la commande (1: PrÃªt Ã  l'envoi || 2: EnvoyÃ©e)? ");
        String statut;
        switch (stat) {
            case 1 :
                statut = "Pret a lenvoi";
                commande.setStatut(statut);
                break;
                
            case 2 :
                statut = "Envoyee";
                commande.setStatut(statut);
                String facture = generationFacture(commande);
                System.out.println(facture);
                break;
        }    
        commandeDao.update(commande);
    } 
    
     /* Fonction qui genÃ¨re une facture pour la commande si son statut passe Ã  "EnvoyÃ©e"*/ 
    protected static String generationFacture(Commande commande) {
        String facture = "\n*********** FACTURE ***********";
        facture += "\n* NumÃ©ro de la commande : "+ commande.getIdCommande();
        
        ClientDAO clientDao = new ClientDAO(conn);
        Client client = clientDao.read(commande.getIdClient());
            
        facture += "\n* Nom client : "+ client.getNom() ;
        facture += "\n* PrÃ©nom client : "+ client.getPrenom() ;
        
        //On a supposÃ© que l'adresse du client est l'adresse de livraison 
        int idadr = client.getIdAdr();
        AdresseDAO adresseDao = new AdresseDAO(conn);
        Adresse adresse = adresseDao.read(idadr);
        facture += "\n* Adresse de livraison : ";
        facture += adresse.getNumRue() ;
        facture += " ";
        facture += adresse.getNomRue();
        facture += " ";
        facture += adresse.getVille();
        facture += " ";
        facture += adresse.getCodePostal() ;
        facture += " ";
        // prix initial de la commande avant code promo 
        float prix = commande.getPrix();
        facture += "\n* Prix initial : ";
        facture += prix;
        facture += "\n";
        
        return facture;
    } 
    
	static void saisirCommande() throws SQLException {
        // TODO Auto-generated method stub
        System.out.print(">> Vous entrez une nouvelle commande: ");
        System.out.flush();

        String ry = "SELECT MAX(idCommande)+1 as idCommande FROM LesCommandes";
        ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
        executeQuery(ry);
        result.next();
        int valeurCommande=result.getInt("idCommande");

        DAO<Commande> commandeDao = new CommandeDAO(conn);
        Commande commande = new Commande();
        
        commande.setPrix(0);
        DAO<Article> articleDao = new ArticleDAO(conn);
        Set<Article> listArticles= new HashSet<Article>();
        commande.setIdClient(idC);
        commande.setListArticles(listArticles);
        commande.setDateCommande(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString());
        commande.setStatut("En cours");
        
        String cryf = "SELECT idAdr FROM LesAdresses NATURAL JOIN LesClients WHERE idClient="+idC;
        ResultSet cresuf = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
        executeQuery(cryf);
        cresuf.next();
        commande.setIdCommande(valeurCommande);
        commande.setIdAdr(Integer.parseInt(cresuf.getString("idAdr")));
        commandeDao.create(commande);



        boolean resu=false;
        while(!resu) {
        	Article article=new Article();
        	String quantite=null;
        	int valeurArticle=0;
        	System.out.print(">> Quel type d'article voulez vous (1: Tirage, 2: Album, 3: Calendrier, 4: Cadre): ");
        	System.out.flush();
        	String typeArticle = LectureClavier.lireChaine();
        	boolean test=false;
        	
        	switch(typeArticle) {
		        	case "1":
		        		String ryl = "SELECT idTir FROM LesTirages";
		    	        ResultSet resu1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
		    	        executeQuery(ryl);
		    	        ArrayList<String> tab1 = new ArrayList<>();
		    	    	while (resu1.next()){
		    	    		tab1.add(resu1.getString(1));
		    	    	}
		    	    	System.out.println("Voici les choix pour les Tirages: ");
		    	    	DAO<Tirage> fichierTirDao = new TirageDAO(conn);
		    	    	for(int j1=0;j1<tab1.size();j1++) {
		    	    		Tirage tir =  fichierTirDao.read(Integer.parseInt(tab1.get(j1)));
					    	System.out.println("       -" + tir.getReference() +" avec indice "+j1);
		    	    	}
		    	    	if(tab1.size()!=0) {
			    	    	System.out.println("Quel article voulez vous? (entre l'indice)");
				        	System.out.flush();
				        	String indiceArticle1 = LectureClavier.lireChaine();
				        	article.setIdImpr(Integer.parseInt(tab1.get(Integer.parseInt(indiceArticle1)))+1000);
				        	article.setPrixImpression(15);
				        	System.out.println("En combien de quantite le voulez vous: ");
				        	System.out.flush();
				        	quantite = LectureClavier.lireChaine();
				        	test=true;
		    	    	}
		        		break;
		        	case "2":
		        		String ry2 = "SELECT idAlbum FROM LesAlbums";
		    	        ResultSet resu2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
		    	        executeQuery(ry2);
		    	        ArrayList<String> tab2 = new ArrayList<>();
		    	    	while (resu2.next()){
		    	    		tab2.add(resu2.getString(1));
		    	    	}
		    	    	System.out.println("Voici les choix pour les albums: ");
		    	    	DAO<Album> fichierAlbDao = new AlbumDAO(conn);
		    	    	for(int j2=0;j2<tab2.size();j2++) {
					    	Album alb = ((AlbumDAO) fichierAlbDao).read( Integer.parseInt(tab2.get(j2)));
					    	System.out.println("       -" + alb.getReference() +" avec indice "+j2);
		    	    	}
			        	if(tab2.size()!=0) {
			    	    	System.out.println("Quel article voulez vous? (entre l'indice)");
				        	System.out.flush();
				        	String indiceArticle2 = LectureClavier.lireChaine();
				        	article.setIdImpr(Integer.parseInt(tab2.get(Integer.parseInt(indiceArticle2)))+2000);
				        	article.setPrixImpression(20);
				        	System.out.println("En combien de quantite le voulez vous: ");
				        	System.out.flush();
				        	quantite = LectureClavier.lireChaine();
				        	test=true;
			        	}
		    	    	
		        		break;
		        	case "3":
		        		String ry3 = "SELECT idCal FROM LesCalendriers";
		    	        ResultSet resu3 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
		    	        executeQuery(ry3);
		    	        ArrayList<String> tab3 = new ArrayList<>();
		    	    	while (resu3.next()){
		    	    		tab3.add(resu3.getString(1));
		    	    	}
		    	    	System.out.println("Voici les choix pour les calendriers: ");
		    	    	DAO<Calendrier> fichierCalDao = new CalendrierDAO(conn);
		    	    	for(int j3=0;j3<tab3.size();j3++) {
					    	Calendrier cal = ((CalendrierDAO) fichierCalDao).read( Integer.parseInt(tab3.get(j3)));
					    	System.out.println("       -" + cal.getReference() +" avec indice "+j3);
		    	    	}
		    	    	
		    	    	if(tab3.size()!=0) {
			    	    	System.out.println("Quel article voulez vous? (entre l'indice)");
				        	System.out.flush();
				        	String indiceArticle3 = LectureClavier.lireChaine();
					        article.setIdImpr(Integer.parseInt(tab3.get(Integer.parseInt(indiceArticle3))+3000));
				        	article.setPrixImpression(25);
				        	System.out.println("En combien de quantite le voulez vous: ");
				        	System.out.flush();
				        	quantite = LectureClavier.lireChaine();
				        	test=true;
			        	}
		        		break;
		        	case "4":
		        		String ry4 = "SELECT idCadre FROM LesCadres";
		    	        ResultSet resu4 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
		    	        executeQuery(ry4);
		    	        ArrayList<String> tab4 = new ArrayList<>();
		    	    	while (resu4.next()){
		    	    		tab4.add(resu4.getString(1));
		    	    	}
		    	    	System.out.println("Voici les choix pour cadre: ");
		    	    	DAO<Cadre> fichierCadreDao = new CadreDAO(conn);
		    	    	for(int j4=0;j4<tab4.size();j4++) {
					    	Cadre cadre = ((CadreDAO) fichierCadreDao).read(Integer.parseInt(tab4.get(j4)));
					    	System.out.println("       -" + cadre.getReference() +" avec indice "+j4);
		    	    	}
		    	    	
		    	    	if(tab4.size()!=0) {
			    	    	System.out.println("Quel article voulez vous? (entrer l'indice):");
				        	System.out.flush();
				        	String indiceArticle4 = LectureClavier.lireChaine();
				            article.setIdImpr(Integer.parseInt(tab4.get(Integer.parseInt(indiceArticle4))+4000));		
				            article.setPrixImpression(30);
				            System.out.println("En combien de quantite le voulez vous: ");
				        	System.out.flush();
				        	quantite = LectureClavier.lireChaine();
				        	test=true;
		    	    	}
		    	    	
		        		break;
		        	}
        	if(test) {
	        	String ryf = "SELECT MAX(idArticle)+1 as idArticle FROM LesArticles";
		        ResultSet resultf = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).
		        executeQuery(ryf);
		        resultf.next();
		        valeurArticle=resultf.getInt("idArticle");
		        article.setIdArticle(valeurArticle);  	
	        	article.setQuantite(Integer.parseInt(quantite));
	        	article.setIdCommande(valeurCommande);
	        	articleDao.create(article);
	        	listArticles.add(article);
        	}
        	
        	float prix=(float) (commande.getPrix()+article.getPrixImpression()*article.getQuantite());
        	commande.setPrix(prix);
        	commande.setIdCommande(valeurCommande);
        	
        	System.out.println("Voulez vous prendre un autre article? O/N: ");
        	System.out.flush();
        	String repo = LectureClavier.lireChaine();
        	if (repo.equals("N")){
        		resu=true;
	    	}
        }

        commandeDao.update(commande);
        System.out.println("\n>> Vous avez commandé les articles: ");
        for(Article art : listArticles) {
        	System.out.println("L'article: " + art.getIdArticle() + " en "+ art.getQuantite()+ " fois.\nPrix total: " + art.getPrixImpression()*art.getQuantite());
        }
        
        System.out.println("\n>> Le prix total de la commande est: "+ commande.getPrix());

    }
}
