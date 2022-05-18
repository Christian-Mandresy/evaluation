CREATE SCHEMA vehicule;

CREATE TABLE roles ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	nom                  varchar(50)  NOT NULL    
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE typevehicule ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	nom                  varchar(40)  NOT NULL    
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user` ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	nom                  varchar(80)  NOT NULL    ,
	prenom               varchar(70)  NOT NULL    ,
	utilisateur          varchar(50)  NOT NULL    ,
	mdp                  varchar(128)  NOT NULL    
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_roles ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	id_user              smallint  NOT NULL    ,
	id_role              smallint  NOT NULL    ,
	date_attribution     date   DEFAULT (curdate())   
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE vehicule ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	numero               varchar(8)  NOT NULL    ,
	marque               varchar(40)      ,
	modele               varchar(40)      ,
	id_type              smallint  NOT NULL    
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE echeance ( 
	id                   smallint  NOT NULL    PRIMARY KEY,
	id_vehicule          smallint  NOT NULL    ,
	jour_restant         int  NOT NULL    ,
	date_jour            date  NOT NULL DEFAULT (curdate())   
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE trajet ( 
	id                   smallint  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	id_vehicule          smallint  NOT NULL    ,
	quantite_carburant   float  NOT NULL    ,
	prix_carburant       float  NOT NULL    ,
	motif                text  NOT NULL    
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE situation ( 
	id                   smallint  NOT NULL    PRIMARY KEY,
	id_trajet            smallint  NOT NULL    ,
	depart               boolean   DEFAULT (true)   ,
	date_heure           datetime  NOT NULL DEFAULT (current_timestamp())   ,
	lieu                 varchar(100)  NOT NULL    ,
	kilometrage          float  NOT NULL    
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX fk_user_roles_user ON user_roles ( id_user );

CREATE INDEX fk_user_roles_roles ON user_roles ( id_role );

CREATE INDEX fk_echeance_vehicule ON echeance ( id_vehicule );

CREATE INDEX fk_trajet_vehicule ON trajet ( id_vehicule );

CREATE INDEX fk_situation_trajet ON situation ( id_trajet );

ALTER TABLE echeance ADD CONSTRAINT fk_echeance_vehicule FOREIGN KEY ( id_vehicule ) REFERENCES vehicule( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE situation ADD CONSTRAINT fk_situation_trajet FOREIGN KEY ( id_trajet ) REFERENCES trajet( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE trajet ADD CONSTRAINT fk_trajet_vehicule FOREIGN KEY ( id_vehicule ) REFERENCES vehicule( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE user_roles ADD CONSTRAINT fk_user_roles_roles FOREIGN KEY ( id_role ) REFERENCES roles( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE user_roles ADD CONSTRAINT fk_user_roles_user FOREIGN KEY ( id_user ) REFERENCES `user`( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE vehicule ADD CONSTRAINT fk_vehicule_type_vehicule FOREIGN KEY ( id ) REFERENCES typevehicule( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

INSERT INTO roles( id, nom ) VALUES ( 1, 'ROLE_ADMIN');
INSERT INTO roles( id, nom ) VALUES ( 2, 'ROLE_USER');
INSERT INTO typevehicule( id, nom ) VALUES ( 1, 'légère');
INSERT INTO typevehicule( id, nom ) VALUES ( 2, 'SUV');
INSERT INTO typevehicule( id, nom ) VALUES ( 3, 'Utilitaire');
INSERT INTO typevehicule( id, nom ) VALUES ( 4, 'Camion');
INSERT INTO `user`( id, nom, prenom, utilisateur, mdp ) VALUES ( 1, 'rakoto', 'nandrasana', 'user1', 'mdp123');
INSERT INTO user_roles( id, id_user, id_role, date_attribution ) VALUES ( 1, 1, 1, '2022-05-18');