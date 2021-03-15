drop table IF EXISTS Client ;
drop table IF EXISTS FichierImage ;
drop table IF EXISTS EstProprioDe ; 
drop table IF EXISTS Adresse ;
drop table IF EXISTS Impression ;
drop table IF EXISTS Livraison;
drop table IF EXISTS Commande;

create table Adresse (
    idAdr number(4) primary key,
    NumRue number(3),
    NomRue varchar(100),
    Ville varchar(100),
    CodePostal number(5)
) 

create table Client (
    adrMail varchar(100) primary key,
    nom varchar(100),
    prenom text[],
    Foreign key adrPostale varchar(100) REFERENCES Adresse ,
    mdp varchar(100) 
)

create table FichierImage (
    CheminAcces varchar(100) primary key,
    InfoPriseDeVue varchar(100),
    ResolutionImage number(3),
    EstPartage NUMBER(1),
    Foreign key adrMail varchar(100) REFERENCES Clients (adrMail)
    
)

create table Adresse (
    NumRue number(3),
    NomRue varchar(100),
    Ville varchar(100),
    CodePostal number(5)
) 

create table Impression(
    idImp varchar(100)

)

create table Livraison (
   
)

create table Commande (
    dateCommande number(3),
    NomRue varchar(100),
    Ville varchar(100),
    CodePostal number(5)
) 

create table tirage(

) INHERITS (Impression)


				