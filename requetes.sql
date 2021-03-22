<!--ATTENTION IDADR ET IDCLIENT LES 2 REQUIS POUR COMMANDE OU JUSTE 1 SUFFIT ? -->

<!--INSERT INTO LesAdresses VALUES (1, 53, 'Avenue Doyen Louis Weil'       , 'Grenoble', 38000);-->
INSERT INTO LesAdresses VALUES (2, 10, 'Avenue Albert 1er de Belgique' , 'Grenoble', 38000);
INSERT INTO LesAdresses VALUES (3, 20, 'Avenue Alsace Lorraine'        , 'Grenoble', 38000);
INSERT INTO LesAdresses VALUES (4, 30, 'Avenue de Vizille'             , 'Grenoble', 38000);
INSERT INTO LesAdresses VALUES (5, 40, 'Cours Berriat'                 , 'Grenoble', 38000);

INSERT INTO LesClients VALUES (1, 'cherif.aboud@gmail.com'  , 'Sherif'       , 'Aboud'    ,  'mdptest',  1);
INSERT INTO LesClients VALUES (2, 'eddy-n@hotmail.com'      , 'Eddy'         , 'Nourin'   ,  'mdptest2', 2);
INSERT INTO LesClients VALUES (3, 'joelbeya418@gmail.com'   , 'Joel'         , 'Beya'     ,  'mdptest3', 3);
INSERT INTO LesClients VALUES (4, 'mitiaainjato@gmail.com'  , 'Mitia'        , 'Ainjato'  ,  'mdptest4', 4);
INSERT INTO LesClients VALUES (5, 'ikimour@gmail.com'       , 'Ahmed-Islam'  , 'Kimour'   ,  'mdptest5', 5);

INSERT INTO LesPhotos VALUES (1 , 'param1' );
INSERT INTO LesPhotos VALUES (2 , 'param2' );
INSERT INTO LesPhotos VALUES (3 , 'param3' );
INSERT INTO LesPhotos VALUES (4 , 'param4' );
INSERT INTO LesPhotos VALUES (5 , 'param5' );
INSERT INTO LesPhotos VALUES (6 , 'param6' );
INSERT INTO LesPhotos VALUES (7 , 'param7' );
INSERT INTO LesPhotos VALUES (8 , 'param8' );
INSERT INTO LesPhotos VALUES (9 , 'param9' );
INSERT INTO LesPhotos VALUES (10, 'param10');
INSERT INTO LesPhotos VALUES (11, 'param11');
INSERT INTO LesPhotos VALUES (12, 'param12');
INSERT INTO LesPhotos VALUES (13, 'param13');
INSERT INTO LesPhotos VALUES (14, 'param14');
INSERT INTO LesPhotos VALUES (15, 'param15');
INSERT INTO LesPhotos VALUES (16, 'param16');
INSERT INTO LesPhotos VALUES (17, 'param17');
INSERT INTO LesPhotos VALUES (18, 'param18');
INSERT INTO LesPhotos VALUES (19, 'param19');
INSERT INTO LesPhotos VALUES (20, 'param20');
INSERT INTO LesPhotos VALUES (21, 'param21');
INSERT INTO LesPhotos VALUES (22, 'param22');
INSERT INTO LesPhotos VALUES (23, 'param23');
INSERT INTO LesPhotos VALUES (24, 'param24');
INSERT INTO LesPhotos VALUES (25, 'param25');
INSERT INTO LesPhotos VALUES (30, 'param30');
INSERT INTO LesPhotos VALUES (31, 'param31');

<!-- Attention si 12 pages par calendrier et 1 client commande 1 calendrier, il doit y avoir au moins 12 photos ? Or nous c'est 5 max pour l'instant -->
<!-- Des photos peuvent n appartenir a personne? -->
<!-- Photo tjrs liee a une image? -->
INSERT INTO LesFichierImages VALUES ('C:/Images/image1.png' , 'prisedevue1' , 10, 0, 1, 1 );
INSERT INTO LesFichierImages VALUES ('C:/Images/image2.png' , 'prisedevue2' , 15, 0, 1, 2 );
INSERT INTO LesFichierImages VALUES ('C:/Images/image3.png' , 'prisedevue3' , 10, 0, 1, 3 );
INSERT INTO LesFichierImages VALUES ('C:/Images/image4.png' , 'prisedevue4' , 15, 0, 1, 4 );
INSERT INTO LesFichierImages VALUES ('C:/Images/image5.png' , 'prisedevue5' , 10, 0, 1, 5 );
INSERT INTO LesFichierImages VALUES ('C:/Images/image6.png' , 'prisedevue6' , 15, 0, 2, 6 );
INSERT INTO LesFichierImages VALUES ('C:/Images/image7.png' , 'prisedevue7' , 10, 0, 2, 7 );
INSERT INTO LesFichierImages VALUES ('C:/Images/image8.png' , 'prisedevue8' , 15, 0, 2, 8 );
INSERT INTO LesFichierImages VALUES ('C:/Images/image9.png' , 'prisedevue9' , 10, 0, 2, 9 );
INSERT INTO LesFichierImages VALUES ('C:/Images/image10.png', 'prisedevue10', 15, 0, 2, 10);
INSERT INTO LesFichierImages VALUES ('C:/Images/image11.png', 'prisedevue11', 10, 0, 3, 11);
INSERT INTO LesFichierImages VALUES ('C:/Images/image12.png', 'prisedevue12', 15, 0, 3, 12);
INSERT INTO LesFichierImages VALUES ('C:/Images/image13.png', 'prisedevue13', 10, 0, 3, 13);
INSERT INTO LesFichierImages VALUES ('C:/Images/image14.png', 'prisedevue14', 15, 0, 3, 14);
INSERT INTO LesFichierImages VALUES ('C:/Images/image15.png', 'prisedevue15', 10, 0, 3, 15);
INSERT INTO LesFichierImages VALUES ('C:/Images/image16.png', 'prisedevue16', 15, 0, 4, 16);
INSERT INTO LesFichierImages VALUES ('C:/Images/image17.png', 'prisedevue17', 10, 0, 4, 17);
INSERT INTO LesFichierImages VALUES ('C:/Images/image18.png', 'prisedevue18', 15, 0, 4, 18);
INSERT INTO LesFichierImages VALUES ('C:/Images/image19.png', 'prisedevue19', 10, 0, 4, 19);
INSERT INTO LesFichierImages VALUES ('C:/Images/image20.png', 'prisedevue20', 15, 0, 4, 20);
INSERT INTO LesFichierImages VALUES ('C:/Images/image21.png', 'prisedevue21', 10, 0, 5, 21);
INSERT INTO LesFichierImages VALUES ('C:/Images/image22.png', 'prisedevue22', 15, 0, 5, 22);
INSERT INTO LesFichierImages VALUES ('C:/Images/image23.png', 'prisedevue23', 10, 0, 5, 23);
INSERT INTO LesFichierImages VALUES ('C:/Images/image24.png', 'prisedevue24', 15, 0, 5, 24);
INSERT INTO LesFichierImages VALUES ('C:/Images/image25.png', 'prisedevue25', 10, 0, 5, 25);

INSERT INTO LesPromotions VALUES (1010, 0.05, 0);
INSERT INTO LesPromotions VALUES (2010, 0.05, 0);
INSERT INTO LesPromotions VALUES (3010, 0.05, 0);
INSERT INTO LesPromotions VALUES (4010, 0.05, 0);
INSERT INTO LesPromotions VALUES (5010, 0.05, 0);
INSERT INTO LesPromotions VALUES (6010, 0.05, 0);
INSERT INTO LesPromotions VALUES (7010, 0.05, 0);
INSERT INTO LesPromotions VALUES (8010, 0.05, 0);
INSERT INTO LesPromotions VALUES (9010, 0.05, 0);
INSERT INTO LesPromotions VALUES (9020, 0.05, 0);

INSERT INTO LesCommandes VALUES (100, 2021-01-01, 50 , 'En cours', 1, 1, null);
INSERT INTO LesCommandes VALUES (110, 2021-01-02, 50 , 'En cours', 2, 2, null);
INSERT INTO LesCommandes VALUES (120, 2021-01-03, 50 , 'En cours', 3, 3, null);
INSERT INTO LesCommandes VALUES (130, 2021-01-04, 50 , 'En cours', 4, 4, null);
INSERT INTO LesCommandes VALUES (140, 2021-01-05, 50 , 'En cours', 5, 5, null);
INSERT INTO LesCommandes VALUES (150, 2021-01-06, 100, 'En cours', 5, 5, 1010);

INSERT INTO LesImpressions VALUES (1 , '10x15MAT' );
INSERT INTO LesImpressions VALUES (2 , '10x15BRIL');
INSERT INTO LesImpressions VALUES (3 , '20x15MAT' );
INSERT INTO LesImpressions VALUES (4 , '20x15BRIL');
INSERT INTO LesImpressions VALUES (5 , '30x15MAT' );
INSERT INTO LesImpressions VALUES (6 , '30x15BRIL');
INSERT INTO LesImpressions VALUES (7 , '40x15MAT' );
INSERT INTO LesImpressions VALUES (8 , '40x15BRIL');
INSERT INTO LesImpressions VALUES (9 , '30x15MAT' );
INSERT INTO LesImpressions VALUES (10, '50x15BRIL');

INSERT INTO LesArticles VALUES (1, 15, 2, 100, 1);
INSERT INTO LesArticles VALUES (2, 20, 1, 100, 2);
INSERT INTO LesArticles VALUES (3, 50, 1, 110, 3);
INSERT INTO LesArticles VALUES (4, 25, 2, 120, 4);
INSERT INTO LesArticles VALUES (5, 50, 1, 130, 5);
INSERT INTO LesArticles VALUES (6, 50, 1, 140, 6);
INSERT INTO LesArticles VALUES (7, 25, 4, 150, 7);

INSERT INTO LesPages VALUES (1 , 'description1' , 'mef1' , 1 );
INSERT INTO LesPages VALUES (2 , 'description2' , 'mef2' , 2 );
INSERT INTO LesPages VALUES (3 , 'description3' , 'mef3' , 3 );
INSERT INTO LesPages VALUES (4 , 'description4' , 'mef4' , 4 );
INSERT INTO LesPages VALUES (5 , 'description5' , 'mef5' , 5 );
INSERT INTO LesPages VALUES (6 , 'description6' , 'mef6' , 6 );
INSERT INTO LesPages VALUES (7 , 'description7' , 'mef7' , 7 );
INSERT INTO LesPages VALUES (8 , 'description8' , 'mef8' , 8 );
INSERT INTO LesPages VALUES (9 , 'description9' , 'mef9' , 9 );
INSERT INTO LesPages VALUES (10, 'description10', 'mef10', 10);
INSERT INTO LesPages VALUES (11, 'description11', 'mef11', 11);
INSERT INTO LesPages VALUES (12, 'description12', 'mef12', 12); <!-- 12 pages pour 1 calendrier -->
INSERT INTO LesPages VALUES (13, 'description13', 'mef13', 13);
INSERT INTO LesPages VALUES (14, 'description14', 'mef14', 14);
INSERT INTO LesPages VALUES (15, 'description15', 'mef15', 15);
INSERT INTO LesPages VALUES (16, 'description16', 'mef16', 16);
INSERT INTO LesPages VALUES (17, 'description17', 'mef17', 17);
INSERT INTO LesPages VALUES (18, 'description18', 'mef18', 18);
INSERT INTO LesPages VALUES (19, 'description19', 'mef19', 19);
INSERT INTO LesPages VALUES (20, 'description20', 'mef20', 20);
INSERT INTO LesPages VALUES (21, 'description21', 'mef21', 21);

<!-- on ne peut pas plusieurs page pour 1 album ici car unique constraint -->
<!-- de meme pour calendrier etc -->
INSERT INTO LesAlbums VALUES (1, '10x15MAT' , 'titre1', 30, 1);
INSERT INTO LesAlbums VALUES (2, '10x15BRIL', 'titre2', 31, 2);

INSERT INTO LesCadres VALUES (1, 'CALA4BRIL', 3);
INSERT INTO LesCadres VALUES (2, '20x15BRIL', 4);

INSERT INTO LesCalendriers VALUES (1, 'CALA4BRIL', 5);

INSERT INTO LesTirages VALUES (1, 'CALA4BRIL', 6);
INSERT INTO LesTirages VALUES (2, '30x15MAT' , 7);

INSERT INTO LesStocks VALUES ('papier'	  , 40);
INSERT INTO LesStocks VALUES ('cadre'	    , 30);
INSERT INTO LesStocks VALUES ('album'	    , 20);
INSERT INTO LesStocks VALUES ('calendrier', 10);

INSERT INTO LesSupportImpressions VALUES ('papier'	  );
INSERT INTO LesSupportImpressions VALUES ('cadre'	    );
INSERT INTO LesSupportImpressions VALUES ('album'	    );
INSERT INTO LesSupportImpressions VALUES ('calendrier');


SELECT * FROM LesAdresses;
SELECT * FROM LesClients;
SELECT * FROM LesPhotos;
SELECT * FROM LesFichierImages;
SELECT * FROM LesPromotions;
SELECT * FROM LesCommandes;
SELECT * FROM LesImpressions;
SELECT * FROM LesArticles;
SELECT * FROM LesPages;
SELECT * FROM LesAlbums;
SELECT * FROM LesCadres;
SELECT * FROM LesCalendriers;
SELECT * FROM LesTirages;
SELECT * FROM LesStocks;
SELECT * FROM LesSupportImpressions;

