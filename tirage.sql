drop table Client ;
drop table FichierImage ;
drop table EstProprioDe ; 
drop table Adresse ;
drop table Impression ;


create table Client (
    adrMail varchar(100) primary key,
    nom varchar(100),
    prenom text[],
    adrPostale varchar(100),
    mdp varchar(100) REFERENCES Adresse
)

create table FichierImage (
    CheminAcces varchar(100) primary key,
    InfoPriseDeVue varchar(100),
    ResolutionImage number(3),
    EstPartage NUMBER(1),
    adrMail varchar(100) REFERENCES Clients
    
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

create table tirage(

) INHERITS (Impression)