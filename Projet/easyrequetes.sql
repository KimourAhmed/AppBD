INSERT INTO LesAdresses VALUES (1, 53, 'Avenue Doyen Louis Weil'       , 'Grenoble', 38000);
INSERT INTO LesAdresses VALUES (2, 10, 'Avenue Albert 1er de Belgique' , 'Grenoble', 38000);

INSERT INTO LesClients VALUES (1, 'cherif@gmail.com'  , 'Sherif'       , 'Aboud'    ,  'mdp1',  1);
INSERT INTO LesClients VALUES (2, 'eddy@gmail.com'    , 'Eddy'         , 'Nourin'   ,  'mdp2', 2);

INSERT INTO LesImpressions VALUES (1000 , '10x15MAT' );
INSERT INTO LesImpressions VALUES (1001 , '10x15BRIL');
INSERT INTO LesImpressions VALUES (1002, '20x15MAT'  );
INSERT INTO LesImpressions VALUES (2000, '20x15BRIL' );
INSERT INTO LesImpressions VALUES (2001, '30x15MAT'  );
INSERT INTO LesImpressions VALUES (3000, '30x15BRIL' );
INSERT INTO LesImpressions VALUES (4000, '40x15MAT'  );
INSERT INTO LesImpressions VALUES (4001, '40x15BRIL' );
INSERT INTO LesImpressions VALUES (4002, '30x15MAT'  );

INSERT INTO LesPages VALUES (1 , 'description1' , 'mef1' , 2000 );
INSERT INTO LesPages VALUES (2 , 'description2' , 'mef2' , 2001 );

INSERT INTO LesPhotos VALUES (1, 'param10', 1);
INSERT INTO LesPhotos VALUES (2, 'param11', 1);
INSERT INTO LesPhotos VALUES (3, 'param12', 2);

INSERT INTO LesFichierImages VALUES ('C:/Images/image1.png' , 'prisedevue1' , 10, 0, 10, 1, 1);
INSERT INTO LesFichierImages VALUES ('C:/Images/image2.png' , 'prisedevue2' , 15, 0, 5 , 1, 2);
INSERT INTO LesFichierImages VALUES ('C:/Images/image3.png' , 'prisedevue3' , 15, 0, 10, 2, 3);

INSERT INTO LesTirages VALUES (1, 'CALA4BRIL', 'C:/Images/image1.png');
INSERT INTO LesTirages VALUES (2, '30x15MAT' , 'C:/Images/image2.png');

INSERT INTO LesCommandes VALUES (100, '01-01-2021', 150 , 'En cours', 1, 1);
INSERT INTO LesCommandes VALUES (101, '02-01-2021', 50 , 'En cours', 2, 2);
INSERT INTO LesCommandes VALUES (102, '03-01-2021', 50 , 'En cours', 1, 1);

INSERT INTO LesPromotions VALUES (1010, 0.05, 0, 100);

INSERT INTO LesArticles VALUES (1, 25, 2, 100, 4000);
INSERT INTO LesArticles VALUES (2, 50, 1, 100, 4001);
INSERT INTO LesArticles VALUES (3, 50, 1, 100, 4002);
INSERT INTO LesArticles VALUES (4, 25, 1, 101, 2000);
INSERT INTO LesArticles VALUES (5, 25, 1, 101, 2001);
INSERT INTO LesArticles VALUES (6, 50, 1, 102, 3000);

INSERT INTO LesStocks VALUES ('papier'	  , 40);
INSERT INTO LesStocks VALUES ('cadre'	    , 30);
INSERT INTO LesStocks VALUES ('album'	    , 20);
INSERT INTO LesStocks VALUES ('calendrier', 10);

INSERT INTO LesSupportImpressions VALUES ('papier'	  );
INSERT INTO LesSupportImpressions VALUES ('cadre'	    );
INSERT INTO LesSupportImpressions VALUES ('album'	    );
INSERT INTO LesSupportImpressions VALUES ('calendrier');
