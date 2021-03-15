drop table IF EXISTS LesClients;
drop table IF EXISTS LesFichierImages;
drop table IF EXISTS LesAdresses;
drop table IF EXISTS LesImpressions;
drop table IF EXISTS LesLivraisons;
drop table IF EXISTS LesCommandes;
drop table IF EXISTS LesPromotions;
drop table IF EXISTS LesArticles;
drop table IF EXISTS LesPages;
drop table IF EXISTS LesAlbums;
drop table IF EXISTS LesCadres;
drop table IF EXISTS LesCalendriers;
drop table IF EXISTS LesTirages;
drop table IF EXISTS LesStocks;
drop table IF EXISTS LesSupportImpressions;
drop table IF EXISTS LesStatuts;



create table LesClients (
    idClient int,
    adrMail varchar(100),
    nom varchar(100),
    prenom text[],
    mdp varchar(100),
    idAdr int,
    primary key (idClient),
    constraint FK_AdrClient foreign key (idAdr) REFERENCES LesAdresses(idAdr)
)

create table LesAdresses (
    idAdr int,
    numRue number(3),
    nomRue varchar(100),
    ville varchar(100),
    codePostal int,
    primary key (idAdr)
) 

create table LesFichierImages (
    cheminAcces varchar(100),
    infoPriseDeVue varchar(100),
    resolutionImage int,
    estPartage NUMBER(1),
    idClient int,
    idPhoto int,
    primary key (cheminAcces),
    constraint FK_ImageClient foreign key (idClient) REFERENCES LesClients(idClient),
    constraint FK_ImagePhoto foreign key (idPhoto) REFERENCES LesPhotos(idPhoto)
)

create table LesPhotos (
    idPhoto number(5) primary key,
    parametresRetouche varchar(100)
)

create table LesCommandes(
    idCommande int,
    dateCommande varchar(100),
    prix float,
    statut LesStatuts,
    primary key(idCommande),
    foreign key idAdr int REFERENCES LesAdresses(idAdr),
    foreign key idClient int REFERENCES LesClients(idClient),
    foreign key codeProm varchar(100) REFERENCES LesPromotions(codeProm)
)

create table LesPromotions(
    codeProm int primary key,
    taux float,
    utilise number(1)
)

create table LesArticles(
    idArticle int primary key,
    prixImpression float,
    quantite int,
    foreign key idCommande int REFERENCES LesCommandes(idCommande),
    foreign key idImpr int REFERENCES LesImpressions(idImpr)
)

create table LesImpressions(
    idImpr int primary key,
    reference varchar(100)

)

create table LesPages(
    idPage int primary key,
    textDescriptif varchar(100),
    miseEnForme varchar(100),
    foreign key idPhoto int REFERENCES LesPhotos(idPhoto)
    
)

create table LesAlbums(
    idAlbum int primary key,
    reference varchar(100),
    titre varchar(100),
    foreign key idPhotoCouverture int REFERENCES LesPhotos(idPhoto),
    foreign key idPage int REFERENCES LesPages(idPage)

)

create table LesCadres(
    idCadre int primary key,
    reference varchar(100),
    foreign key idPage int REFERENCES LesPages(idPage)
)

create table LesCalendriers(
    idCal int primary key,
    reference varchar(100),
    foreign key idPage int REFERENCES LesPages(idPage)
)

create table LesTirages(
    idTir int primary key,
    reference varchar(100),
    foreign key idPage int REFERENCES LesPages(idPage)
)

create table LesStocks(
    supportImpression LesSupportImpressions,
    quantite int primary key
)

CREATE TYPE LesSupportImpressions AS ENUM ("papier", "cadre", "calendrier", "album");

CREATE TYPE LesStatuts AS ENUM ("En cours", "Prêt à l'envoie", "Envoyée");
