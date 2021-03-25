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
 
create table LesPhotos (
    idPhoto int primary key,
    parametresRetouche varchar(50),
	idPage int,
	idTir int,
	constraint FK_PhotoPage foreign key (idPage) REFERENCES LesPages(idPage),
    constraint FK_PhotoTir  foreign key (idTir) REFERENCES LesTirages(idTir)
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
 
create table LesPromotions (
    codeProm int,
    taux float,
    utilise number(1),
    primary key (codeProm)
);
 
create table LesCommandes (
    idCommande int,
    dateCommande date,
    prix float,
    statut varchar(15),
    idAdr int,
    idClient int,
    codeProm int,
    primary key(idCommande),
    constraint LesCommandes_C1 check (statut in ('En cours', 'Pret a lenvoi', 'Envoyee')),
    constraint FK_CommandeAdr foreign key (idAdr) REFERENCES LesAdresses(idAdr),
    constraint FK_CommandeCli foreign key (idClient) REFERENCES LesClients(idClient),
    constraint FK_CommandeProm foreign key (codeProm) REFERENCES LesPromotions(codeProm)
);
 
create table LesImpressions (
    idImpr int,
    reference varchar(20),
    primary key (idImpr)
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
 
create table LesPages (
    idPage int,
    textDescriptif varchar(50),
    miseEnForme varchar(50),
    idImpr int,
    primary key(idPage),
    constraint FK_PageImpr foreign key (idImpr) REFERENCES LesImpressions(idImpr)
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
 
create table LesTirages(
    idTir int,
    reference varchar(20),
    primary key(idTir)
);
 
 
create table LesStocks (
    supportImpression varchar(10),
    quantite int,
    constraint LesStocks_C1 check (supportImpression in ('papier', 'cadre', 'calendrier', 'album')),
    primary key (supportImpression, quantite)
);

create table LesSupportImpressions (
    valeur varchar(10),
    constraint LesStocks_C1 check (valeur in ('papier', 'cadre', 'calendrier', 'album')),
    primary key (valeur)
);
