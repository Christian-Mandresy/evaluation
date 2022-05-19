CREATE SCHEMA vehicule;

CREATE TABLE vehicule.echeance ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	nom                  varchar(46)  NOT NULL    
 ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

CREATE TABLE vehicule.roles ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	nom                  varchar(50)  NOT NULL    
 ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

CREATE TABLE vehicule.typevehicule ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	nom                  varchar(40)  NOT NULL    
 ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE vehicule.`user` ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	nom                  varchar(80)  NOT NULL    ,
	prenom               varchar(70)  NOT NULL    ,
	utilisateur          varchar(50)  NOT NULL    ,
	mdp                  varchar(128)  NOT NULL    
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

CREATE TABLE vehicule.user_roles ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	id_user              smallint  NOT NULL    ,
	id_role              smallint  NOT NULL    ,
	date_attribution     date      
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

CREATE TABLE vehicule.vehicule ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	numero               varchar(8)  NOT NULL    ,
	marque               varchar(40)      ,
	modele               varchar(40)      ,
	id_type              smallint  NOT NULL    
 ) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE vehicule.echeance_voiture ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	id_vehicule          smallint  NOT NULL    ,
	ajout                date  NOT NULL DEFAULT (curdate())   ,
	datefin              date  NOT NULL    ,
	idecheance           smallint  NOT NULL    
 ) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

CREATE TABLE vehicule.trajet ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	id_vehicule          smallint  NOT NULL    ,
	quantite_carburant   float  NOT NULL    ,
	prix_carburant       float  NOT NULL    ,
	motif                text  NOT NULL    ,
	idutilisateur        smallint  NOT NULL DEFAULT (1)   
 ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

CREATE TABLE vehicule.situation ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	id_trajet            smallint  NOT NULL    ,
	depart               boolean   DEFAULT (true)   ,
	date_heure           datetime  NOT NULL DEFAULT (current_timestamp())   ,
	lieu                 varchar(100)  NOT NULL    ,
	kilometrage          float  NOT NULL    
 ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

CREATE INDEX fk_user_roles_user ON vehicule.user_roles ( id_user );

CREATE INDEX fk_user_roles_roles ON vehicule.user_roles ( id_role );

CREATE INDEX `FKsulkay5wi8s7w80gyl3tq8yog` ON vehicule.vehicule ( id_type );

CREATE INDEX fk_echeance_vehicule ON vehicule.echeance_voiture ( id_vehicule );

CREATE INDEX fk_echeance_voiture_echeance ON vehicule.echeance_voiture ( idecheance );

CREATE INDEX fk_trajet_vehicule ON vehicule.trajet ( id_vehicule );

CREATE INDEX fk_situation_trajet ON vehicule.situation ( id_trajet );

ALTER TABLE vehicule.echeance_voiture ADD CONSTRAINT fk_echeance_vehicule FOREIGN KEY ( id_vehicule ) REFERENCES vehicule.vehicule( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE vehicule.echeance_voiture ADD CONSTRAINT fk_echeance_voiture_echeance FOREIGN KEY ( idecheance ) REFERENCES vehicule.echeance( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE vehicule.situation ADD CONSTRAINT fk_situation_trajet FOREIGN KEY ( id_trajet ) REFERENCES vehicule.trajet( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE vehicule.trajet ADD CONSTRAINT fk_trajet_vehicule FOREIGN KEY ( id_vehicule ) REFERENCES vehicule.vehicule( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE vehicule.user_roles ADD CONSTRAINT `FK1v995xldvmr6w96c5feofx1gf` FOREIGN KEY ( id_role ) REFERENCES vehicule.roles( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE vehicule.user_roles ADD CONSTRAINT `FKebmg5mnn5dk5hdsra6mt54fmv` FOREIGN KEY ( id_user ) REFERENCES vehicule.`user`( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE vehicule.user_roles ADD CONSTRAINT fk_user_roles_roles FOREIGN KEY ( id_role ) REFERENCES vehicule.roles( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE vehicule.user_roles ADD CONSTRAINT fk_user_roles_user FOREIGN KEY ( id_user ) REFERENCES vehicule.`user`( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE vehicule.vehicule ADD CONSTRAINT `FKsulkay5wi8s7w80gyl3tq8yog` FOREIGN KEY ( id_type ) REFERENCES vehicule.typevehicule( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

INSERT INTO vehicule.echeance( id, nom ) VALUES ( 1, 'Assurance');
INSERT INTO vehicule.echeance( id, nom ) VALUES ( 2, 'Visite technique');
INSERT INTO vehicule.roles( id, nom ) VALUES ( 1, 'ROLE_ADMIN');
INSERT INTO vehicule.roles( id, nom ) VALUES ( 2, 'ROLE_USER');
INSERT INTO vehicule.typevehicule( id, nom ) VALUES ( 1, 'l?g?re');
INSERT INTO vehicule.typevehicule( id, nom ) VALUES ( 2, 'SUV');
INSERT INTO vehicule.typevehicule( id, nom ) VALUES ( 3, 'Utilitaire');
INSERT INTO vehicule.typevehicule( id, nom ) VALUES ( 4, 'Camion');
INSERT INTO vehicule.`user`( id, nom, prenom, utilisateur, mdp ) VALUES ( 1, 'rakoto', 'nandrasana', 'user1', 'mdp123');
INSERT INTO vehicule.user_roles( id, id_user, id_role, date_attribution ) VALUES ( 1, 1, 1, '2022-05-18');
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 1, 'W8R 2U1', 'Ford', 'model2', 3);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 2, 'G4J 7X8', 'Vauxhall', 'model2', 1);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 3, 'E7E 7P6', 'Buick', 'model3', 3);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 4, 'O5J 5J5', 'Maruti Suzuki', 'model', 3);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 5, 'V2L 8W6', 'JLR', 'model', 4);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 6, 'G5R 5G4', 'Acura', 'model1', 4);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 7, 'Q4E 9N1', 'Citroën', 'model2', 2);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 8, 'Q6T 6G2', 'General Motors', 'model', 4);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 9, 'Q4R 4M0', 'Mahindra and Mahindra', 'model', 2);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 10, 'C6D 5J2', 'Toyota', 'model2', 1);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 11, 'M6F 7U5', 'Dodge', 'model', 3);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 12, 'N9G 4Q3', 'Skoda', 'model3', 3);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 13, 'U6U 3V5', 'Volkswagen', 'model', 3);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 14, 'Y1J 7Y5', 'Buick', 'model1', 2);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 15, 'M5H 9W6', 'Mitsubishi Motors', 'model3', 2);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 16, 'H4V 5N4', 'Renault', 'model1', 3);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 17, 'U2N 3Y3', 'RAM Trucks', 'model1', 1);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 18, 'V7N 5Y4', 'Lexus', 'model2', 2);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 19, 'V0F 5M2', 'Acura', 'model', 1);
INSERT INTO vehicule.vehicule( id, numero, marque, modele, id_type ) VALUES ( 20, 'S8W 3K9', 'MINI', 'model', 4);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 1, 2, '2022-05-19', '2022-07-22', 1);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 2, 3, '2022-05-19', '2022-07-22', 1);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 3, 5, '2022-05-19', '2022-07-22', 1);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 4, 6, '2022-05-01', '2022-05-26', 1);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 5, 7, '2022-05-01', '2022-05-31', 1);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 7, 8, '2022-05-01', '2022-05-22', 1);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 8, 9, '2022-05-01', '2022-06-16', 1);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 9, 10, '2022-05-01', '2022-05-19', 1);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 10, 1, '2022-05-01', '2022-07-19', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 11, 2, '2022-01-14', '2022-05-23', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 12, 3, '2022-01-14', '2022-05-26', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 13, 4, '2022-02-12', '2022-06-01', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 14, 5, '2022-02-12', '2022-06-01', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 15, 6, '2022-03-12', '2022-07-01', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 16, 7, '2022-02-12', '2022-05-18', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 17, 8, '2022-02-12', '2022-05-19', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 18, 8, '2022-05-12', '2022-08-19', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 19, 10, '2022-05-12', '2022-08-19', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 20, 9, '2022-04-12', '2022-09-19', 2);
INSERT INTO vehicule.echeance_voiture( id, id_vehicule, ajout, datefin, idecheance ) VALUES ( 21, 10, '2022-04-12', '2022-09-19', 2);
INSERT INTO vehicule.trajet( id, id_vehicule, quantite_carburant, prix_carburant, motif, idutilisateur ) VALUES ( 1, 1, 12.43, 3450.0, ' voyage d ''affaire', 1);
INSERT INTO vehicule.trajet( id, id_vehicule, quantite_carburant, prix_carburant, motif, idutilisateur ) VALUES ( 2, 2, 19.0, 5.0, ' vacance', 1);
INSERT INTO vehicule.trajet( id, id_vehicule, quantite_carburant, prix_carburant, motif, idutilisateur ) VALUES ( 3, 3, 11.0, 5.0, ' tourisme', 1);
INSERT INTO vehicule.trajet( id, id_vehicule, quantite_carburant, prix_carburant, motif, idutilisateur ) VALUES ( 4, 4, 22.6, 5000.0, ' tourisme', 1);
INSERT INTO vehicule.trajet( id, id_vehicule, quantite_carburant, prix_carburant, motif, idutilisateur ) VALUES ( 5, 5, 12.0, 4500.0, ' transport de marchandise', 1);
INSERT INTO vehicule.situation( id, id_trajet, depart, date_heure, lieu, kilometrage ) VALUES ( 1, 1, 1, '2022-05-10 11.15.12 AM', 'Tana', 3800.0);
INSERT INTO vehicule.situation( id, id_trajet, depart, date_heure, lieu, kilometrage ) VALUES ( 2, 1, 0, '2022-05-10 02.15.12 PM', 'Antsirabe', 4100.0);
INSERT INTO vehicule.situation( id, id_trajet, depart, date_heure, lieu, kilometrage ) VALUES ( 3, 2, 1, '2022-05-19 12.15.12 PM', 'Mahajanga', 180.0);
INSERT INTO vehicule.situation( id, id_trajet, depart, date_heure, lieu, kilometrage ) VALUES ( 4, 3, 1, '2022-05-19 12.15.12 PM', 'Toamasina', 490.0);
INSERT INTO vehicule.situation( id, id_trajet, depart, date_heure, lieu, kilometrage ) VALUES ( 5, 4, 1, '2022-05-09 12.15.12 PM', 'Toamasina', 1200.0);
INSERT INTO vehicule.situation( id, id_trajet, depart, date_heure, lieu, kilometrage ) VALUES ( 6, 4, 0, '2022-05-09 08.15.12 PM', 'Antananarivo', 1200.0);
INSERT INTO vehicule.situation( id, id_trajet, depart, date_heure, lieu, kilometrage ) VALUES ( 7, 5, 1, '2022-05-09 08.15.12 PM', 'Antananarivo', 2000.0);
INSERT INTO vehicule.situation( id, id_trajet, depart, date_heure, lieu, kilometrage ) VALUES ( 8, 5, 1, '2022-05-10 04.15.12 AM', 'Toamasina', 2800.0);