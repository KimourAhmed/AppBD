create table LesAdresses (
    idAdr int,
    numRue number(3),
    nomRue varchar(50),
    ville varchar(15),
    codePostal int,
    primary key (idAdr)
);
 
create table LesClients (
    idClient int,
    adrMail varchar(50),
    nom varchar(15),
    prenom varchar(15),
    mdp varchar(15),
    idAdr int,
    primary key (idClient),
    constraint FK_AdrClient foreign key (idAdr) REFERENCES LesAdresses(idAdr)
);
 
create table LesImpressions (
    idImpr int,
    reference varchar(20),
    primary key (idImpr)
);
 
create table LesPages (
    idPage int,
    textDescriptif varchar(50),
    miseEnForme varchar(50),
    idImpr int,
    primary key(idPage),
    constraint FK_PageImpr foreign key (idImpr) REFERENCES LesImpressions(idImpr)
);
 
create table LesPhotos (
    idPhoto int primary key,
    parametresRetouche varchar(50),
  	idPage int,
  	constraint FK_PhotoPage foreign key (idPage) REFERENCES LesPages(idPage)
);
 
create table LesFichierImages (
    cheminAcces varchar(50),
    infoPriseDeVue varchar(50),
    resolutionImage int,
    estPartage NUMBER(1),
    idClient int,
    idPhoto int,
    primary key (cheminAcces),
    constraint FK_ImageClient foreign key (idClient) REFERENCES LesClients(idClient),
    constraint FK_ImagePhoto foreign key (idPhoto) REFERENCES LesPhotos(idPhoto)
);

create table LesTirages(
    idTir int,
    reference varchar(20),
    cheminAcces varchar(50),
    primary key(idTir),
    constraint FK_TirImage foreign key (cheminAcces) REFERENCES LesFichierImages(cheminAcces)
);
 
create table LesCommandes (
    idCommande int,
    dateCommande date,
    prix float,
    statut varchar(15),
    idAdr int,
    idClient int,
    primary key(idCommande),
    constraint LesCommandes_C1 check (statut in ('En cours', 'Pret a lenvoi', 'Envoyee')),
    constraint FK_CommandeAdr foreign key (idAdr) REFERENCES LesAdresses(idAdr),
    constraint FK_CommandeCli foreign key (idClient) REFERENCES LesClients(idClient)
);
 
create table LesPromotions (
    codeProm int,
    taux float,
    utilise number(1),
    idCommande int,
    primary key (codeProm),
    constraint FK_PromCommande foreign key (idCommande) REFERENCES LesCommandes(idCommande)
);

create table LesArticles (
    idArticle int,
    prixImpression float,
    quantite int,
    idCommande int,
    idImpr int,
    primary key(idArticle),
    constraint FK_ArticleCom foreign key (idCommande) REFERENCES LesCommandes(idCommande),
    constraint FK_ArticleImpr foreign key (idImpr) REFERENCES LesImpressions(idImpr)
);

create table LesAlbums (
    idAlbum int,
    reference varchar(20),
    titre varchar(50),
    idPhoto int,
    primary key(idAlbum),
    constraint FK_AlbumPhoto foreign key (idPhoto) REFERENCES LesPhotos(idPhoto)
);
 
create table LesCadres(
    idCadre int,
    reference varchar(20),
    primary key (idCadre)
);
 
create table LesCalendriers(
    idCal int,
    reference varchar(20),
    primary key (idCal)
);
 
create table LesStocks (
    supportImpression varchar(10),
    quantite int,
    constraint LesStocks_C1 check (supportImpression in ('papier', 'cadre', 'calendrier', 'album')),
    primary key (supportImpression, quantite)
);

create table LesSupportImpressions (
    valeur varchar(10),
    constraint LesSupportImpressions_C1 check (valeur in ('papier', 'cadre', 'calendrier', 'album')),
    primary key (valeur)
);
