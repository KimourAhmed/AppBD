drop table Client ;
drop table FichierImage ;
drop table EstProprioDe ; 
drop table Adresse ;
drop table Impression ;
drop table Livraison;
drop table Commande;


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
    Foreign key adrMail varchar(100) REFERENCES Clients
    
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
    adrPointRelais varchar(100) REFERENCES Adresse ,
    adrDomicile varchar(100) REFERENCES Adresse 
)

create table Commande (
    dateCommande number(3),
    NomRue varchar(100),
    Ville varchar(100),
    CodePostal number(5)
) 

create table tirage(

) INHERITS (Impression)