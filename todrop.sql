alter table LesClients drop constraint FK_AdrClient;

alter table LesFichierImages drop constraint FK_ImageClient;
alter table LesFichierImages drop constraint FK_ImagePhoto;

alter table LesCommandes drop constraint FK_CommandeAdr;
alter table LesCommandes drop constraint FK_CommandeCli;
alter table LesCommandes drop constraint FK_CommandeProm;

alter table LesArticles drop constraint FK_ArticleCom;
alter table LesArticles drop constraint FK_ArticleImpr;

alter table LesPages drop constraint FK_PagePhoto;

alter table LesAlbums drop constraint FK_AlbumPage;
alter table LesAlbums drop constraint FK_AlbumPhoto;

alter table LesTirages drop constraint FK_TiragePage;

alter table LesCalendriers drop constraint FK_CalPage;

alter table LesCadres drop constraint FK_CadrePage;


drop table LesClients;
drop table LesAdresses;
drop table LesFichierImages;
drop table LesPhotos;
drop table LesPages;
drop table LesCommandes;
drop table LesArticles;
drop table LesTirages;
drop table LesAlbums;
drop table LesCadres;
drop table LesPromotions;
drop table LesImpressions;
drop table LesSupportImpressions;
drop table LesStocks;
drop table LesCalendriers;