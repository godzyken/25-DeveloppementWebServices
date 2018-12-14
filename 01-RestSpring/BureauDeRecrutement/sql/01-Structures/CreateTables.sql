#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Recrutement
#------------------------------------------------------------

CREATE TABLE Recrutement(
        id_recrutement     Varchar (25) NOT NULL ,
        Resultat_Recherche Int ,
        Ordre_Recherche    Int ,
        Date_Recrutement   Date NOT NULL ,
        Heure_Recherche    Datetime NOT NULL ,
        PRIMARY KEY (id_recrutement )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Candidat
#------------------------------------------------------------

CREATE TABLE Candidat(
        Id_candidat      Varchar (40) NOT NULL ,
        Nom              Text NOT NULL ,
        Prenom           Text NOT NULL ,
        Adresse          Varchar (80) NOT NULL ,
        Age              Int NOT NULL ,
        Telephone_Mobile Int NOT NULL ,
        Telephone_Fixe   Int ,
        Mail             Varchar (40) NOT NULL ,
        PRIMARY KEY (Id_candidat )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Management Equipe
#------------------------------------------------------------

CREATE TABLE Management_Equipe(
        id_Manag_Equip Varchar (50) NOT NULL ,
        Nombre_De_Pers Int NOT NULL ,
        Duree_Respons  Varchar (25) NOT NULL ,
        id_Exper_Manag Varchar (25) NOT NULL ,
        PRIMARY KEY (id_Manag_Equip )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Management Projet
#------------------------------------------------------------

CREATE TABLE Management_Projet(
        id_Manag_Projet Varchar (40) NOT NULL ,
        Nombre_De_Pers  Int NOT NULL ,
        Duree_Respons   Int NOT NULL ,
        id_Exper_Manag  Varchar (25) NOT NULL ,
        PRIMARY KEY (id_Manag_Projet )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Experience Management
#------------------------------------------------------------

CREATE TABLE Experience_Management(
        id_Exper_Manag Varchar (25) NOT NULL ,
        Nom_Entreprise Text NOT NULL ,
        Lieu           Text NOT NULL ,
        PRIMARY KEY (id_Exper_Manag )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Langue
#------------------------------------------------------------

CREATE TABLE Langue(
        id_Langue      Varchar (25) NOT NULL ,
        Libelle_Langue Text NOT NULL ,
        Libelle_niveau Text NOT NULL ,
        PRIMARY KEY (id_Langue )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Formation
#------------------------------------------------------------

CREATE TABLE Formation(
        id_Formation      Varchar (40) NOT NULL ,
        Libelle_Formation Varchar (80) NOT NULL ,
        Date_Formation    Date NOT NULL ,
        Lieu_Formation    Varchar (40) NOT NULL ,
        PRIMARY KEY (id_Formation )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Experience
#------------------------------------------------------------

CREATE TABLE Experience(
        id_Experience    Varchar (40) NOT NULL ,
        Debut_Exper      Varchar (40) NOT NULL ,
        Fin_Exper        Varchar (40) NOT NULL ,
        Libelle_Fonction Varchar (250) NOT NULL ,
        PRIMARY KEY (id_Experience )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Salaire
#------------------------------------------------------------

CREATE TABLE Salaire(
        id_Salaire      Varchar (40) NOT NULL ,
        Montant_Annuel  Int NOT NULL ,
        Montant_Mensuel Int NOT NULL ,
        PRIMARY KEY (id_Salaire )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Secteur
#------------------------------------------------------------

CREATE TABLE Secteur(
        id_Secteur      Varchar (40) NOT NULL ,
        Libelle_Secteur Char (180) NOT NULL ,
        PRIMARY KEY (id_Secteur )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Disponibilite
#------------------------------------------------------------

CREATE TABLE Disponibilite(
        id_Disponilite      Varchar (40) NOT NULL ,
        Libelle_Disponilite Char (40) NOT NULL ,
        PRIMARY KEY (id_Disponilite )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Lieu
#------------------------------------------------------------

CREATE TABLE Lieu(
        id_Lieu      Varchar (40) NOT NULL ,
        Libelle_Lieu Char (40) NOT NULL ,
        PRIMARY KEY (id_Lieu )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Fonction
#------------------------------------------------------------

CREATE TABLE Fonction(
        id_Fonction      Varchar (40) NOT NULL ,
        Libelle_Fonction Varchar (200) NOT NULL ,
        PRIMARY KEY (id_Fonction )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Type Contrat
#------------------------------------------------------------

CREATE TABLE Type_Contrat(
        id_Contrat           Varchar (40) NOT NULL ,
        Libelle_Type_Contrat Char (80) NOT NULL ,
        PRIMARY KEY (id_Contrat )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Nature Contrat
#------------------------------------------------------------

CREATE TABLE Nature_Contrat(
        id_Nature_Contrat      Varchar (40) NOT NULL ,
        Libelle_Nature_Contrat Char (25) NOT NULL ,
        PRIMARY KEY (id_Nature_Contrat )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Mobilite
#------------------------------------------------------------

CREATE TABLE Mobilite(
        id_Mobilite      Varchar (40) NOT NULL ,
        Libelle_Mobilite Char (25) NOT NULL ,
        PRIMARY KEY (id_Mobilite )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Parution
#------------------------------------------------------------

CREATE TABLE Parution(
        id_Parution      Varchar (25) NOT NULL ,
        Libelle_Parution Varchar (25) NOT NULL ,
        PRIMARY KEY (id_Parution )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Profil international
#------------------------------------------------------------

CREATE TABLE Profil_international(
        id_Profil_Inter      Varchar (40) NOT NULL ,
        Libelle_Profil_Inter Char (120) NOT NULL ,
        PRIMARY KEY (id_Profil_Inter )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Experience International
#------------------------------------------------------------

CREATE TABLE Experience_International(
        id_Exper_Inter  Varchar (40) NOT NULL ,
        Libelle_Exper   Varchar (25) NOT NULL ,
        id_Profil_Inter Varchar (40) NOT NULL ,
        PRIMARY KEY (id_Exper_Inter )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Rechercher_4
#------------------------------------------------------------

CREATE TABLE Rechercher_4(
        id_Secteur     Varchar (40) NOT NULL ,
        id_recrutement Varchar (25) NOT NULL ,
        id_Disponilite Varchar (40) NOT NULL ,
        id_Lieu        Varchar (40) NOT NULL ,
        id_Fonction    Varchar (40) NOT NULL ,
        PRIMARY KEY (id_Secteur ,id_recrutement ,id_Disponilite ,id_Lieu ,id_Fonction )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Rechercher_1
#------------------------------------------------------------

CREATE TABLE Rechercher_1(
        id_recrutement Varchar (25) NOT NULL ,
        Id_candidat    Varchar (40) NOT NULL ,
        PRIMARY KEY (id_recrutement ,Id_candidat )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Rechercher_2
#------------------------------------------------------------

CREATE TABLE Rechercher_2(
        id_Manag_Projet Varchar (40) NOT NULL ,
        id_Manag_Equip  Varchar (50) NOT NULL ,
        id_recrutement  Varchar (25) NOT NULL ,
        PRIMARY KEY (id_Manag_Projet ,id_Manag_Equip ,id_recrutement )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Rechercher_3
#------------------------------------------------------------

CREATE TABLE Rechercher_3(
        id_Salaire     Varchar (40) NOT NULL ,
        id_recrutement Varchar (25) NOT NULL ,
        id_Experience  Varchar (40) NOT NULL ,
        id_Formation   Varchar (40) NOT NULL ,
        id_Langue      Varchar (25) NOT NULL ,
        PRIMARY KEY (id_Salaire ,id_recrutement ,id_Experience ,id_Formation ,id_Langue )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Rechercher_5
#------------------------------------------------------------

CREATE TABLE Rechercher_5(
        id_recrutement    Varchar (25) NOT NULL ,
        id_Contrat        Varchar (40) NOT NULL ,
        id_Nature_Contrat Varchar (40) NOT NULL ,
        id_Mobilite       Varchar (40) NOT NULL ,
        id_Parution       Varchar (25) NOT NULL ,
        PRIMARY KEY (id_recrutement ,id_Contrat ,id_Nature_Contrat ,id_Mobilite ,id_Parution )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Rechercher_6
#------------------------------------------------------------

CREATE TABLE Rechercher_6(
        id_Exper_Inter Varchar (40) NOT NULL ,
        id_recrutement Varchar (25) NOT NULL ,
        PRIMARY KEY (id_Exper_Inter ,id_recrutement )
)ENGINE=InnoDB;

ALTER TABLE Management_Equipe ADD CONSTRAINT FK_Management_Equipe_id_Exper_Manag FOREIGN KEY (id_Exper_Manag) REFERENCES Experience_Management(id_Exper_Manag);
ALTER TABLE Management_Projet ADD CONSTRAINT FK_Management_Projet_id_Exper_Manag FOREIGN KEY (id_Exper_Manag) REFERENCES Experience_Management(id_Exper_Manag);
ALTER TABLE Experience_International ADD CONSTRAINT FK_Experience_International_id_Profil_Inter FOREIGN KEY (id_Profil_Inter) REFERENCES Profil_international(id_Profil_Inter);
ALTER TABLE Rechercher_4 ADD CONSTRAINT FK_Rechercher_4_id_Secteur FOREIGN KEY (id_Secteur) REFERENCES Secteur(id_Secteur);
ALTER TABLE Rechercher_4 ADD CONSTRAINT FK_Rechercher_4_id_recrutement FOREIGN KEY (id_recrutement) REFERENCES Recrutement(id_recrutement);
ALTER TABLE Rechercher_4 ADD CONSTRAINT FK_Rechercher_4_id_Disponilite FOREIGN KEY (id_Disponilite) REFERENCES Disponibilite(id_Disponilite);
ALTER TABLE Rechercher_4 ADD CONSTRAINT FK_Rechercher_4_id_Lieu FOREIGN KEY (id_Lieu) REFERENCES Lieu(id_Lieu);
ALTER TABLE Rechercher_4 ADD CONSTRAINT FK_Rechercher_4_id_Fonction FOREIGN KEY (id_Fonction) REFERENCES Fonction(id_Fonction);
ALTER TABLE Rechercher_1 ADD CONSTRAINT FK_Rechercher_1_id_recrutement FOREIGN KEY (id_recrutement) REFERENCES Recrutement(id_recrutement);
ALTER TABLE Rechercher_1 ADD CONSTRAINT FK_Rechercher_1_Id_candidat FOREIGN KEY (Id_candidat) REFERENCES Candidat(Id_candidat);
ALTER TABLE Rechercher_2 ADD CONSTRAINT FK_Rechercher_2_id_Manag_Projet FOREIGN KEY (id_Manag_Projet) REFERENCES Management_Projet(id_Manag_Projet);
ALTER TABLE Rechercher_2 ADD CONSTRAINT FK_Rechercher_2_id_Manag_Equip FOREIGN KEY (id_Manag_Equip) REFERENCES Management_Equipe(id_Manag_Equip);
ALTER TABLE Rechercher_2 ADD CONSTRAINT FK_Rechercher_2_id_recrutement FOREIGN KEY (id_recrutement) REFERENCES Recrutement(id_recrutement);
ALTER TABLE Rechercher_3 ADD CONSTRAINT FK_Rechercher_3_id_Salaire FOREIGN KEY (id_Salaire) REFERENCES Salaire(id_Salaire);
ALTER TABLE Rechercher_3 ADD CONSTRAINT FK_Rechercher_3_id_recrutement FOREIGN KEY (id_recrutement) REFERENCES Recrutement(id_recrutement);
ALTER TABLE Rechercher_3 ADD CONSTRAINT FK_Rechercher_3_id_Experience FOREIGN KEY (id_Experience) REFERENCES Experience(id_Experience);
ALTER TABLE Rechercher_3 ADD CONSTRAINT FK_Rechercher_3_id_Formation FOREIGN KEY (id_Formation) REFERENCES Formation(id_Formation);
ALTER TABLE Rechercher_3 ADD CONSTRAINT FK_Rechercher_3_id_Langue FOREIGN KEY (id_Langue) REFERENCES Langue(id_Langue);
ALTER TABLE Rechercher_5 ADD CONSTRAINT FK_Rechercher_5_id_recrutement FOREIGN KEY (id_recrutement) REFERENCES Recrutement(id_recrutement);
ALTER TABLE Rechercher_5 ADD CONSTRAINT FK_Rechercher_5_id_Contrat FOREIGN KEY (id_Contrat) REFERENCES Type_Contrat(id_Contrat);
ALTER TABLE Rechercher_5 ADD CONSTRAINT FK_Rechercher_5_id_Nature_Contrat FOREIGN KEY (id_Nature_Contrat) REFERENCES Nature_Contrat(id_Nature_Contrat);
ALTER TABLE Rechercher_5 ADD CONSTRAINT FK_Rechercher_5_id_Mobilite FOREIGN KEY (id_Mobilite) REFERENCES Mobilite(id_Mobilite);
ALTER TABLE Rechercher_5 ADD CONSTRAINT FK_Rechercher_5_id_Parution FOREIGN KEY (id_Parution) REFERENCES Parution(id_Parution);
ALTER TABLE Rechercher_6 ADD CONSTRAINT FK_Rechercher_6_id_Exper_Inter FOREIGN KEY (id_Exper_Inter) REFERENCES Experience_International(id_Exper_Inter);
ALTER TABLE Rechercher_6 ADD CONSTRAINT FK_Rechercher_6_id_recrutement FOREIGN KEY (id_recrutement) REFERENCES Recrutement(id_recrutement);
