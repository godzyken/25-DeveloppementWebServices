-- -----------------------------------------------------------------------------
-- CONTRAINTES -- CREATIONS -- DEBUT
-- -----------------------------------------------------------------------------


-- -----------------------------------------------------------------------------
-- (01.)AFFICHER LA DESCRIPTION DES TABLES CONCERNEES 
-- -----------------------------------------------------------------------------
desc PERSONNE;
desc CANDIDAT;


-- -----------------------------------------------------------------------------
-- (02.)CREER LES CONTRAINTES DE CLE PRIMAIRES
-- -----------------------------------------------------------------------------
alter table PERSONNE add constraint PK_PERSONNE primary key(ID);
alter table CANDIDAT add constraint PK_CANDIDAT primary key(ID);


-- -----------------------------------------------------------------------------
-- (03.)CREER LES CONTRAINTES D'UNICITE ET D'AUTO-INCREMENT
-- -----------------------------------------------------------------------------
alter table PERSONNE modify column ID numeric UNIQUE AUTO_INCREMENT;
alter table CANDIDAT modify column ID numeric UNIQUE AUTO_INCREMENT;

alter table PERSONNE modify column MAIL varchar(35) UNIQUE;


-- -----------------------------------------------------------------------------
-- (04.)CREER LES CONTRAINTES DE CLE ETRANGERES
-- -----------------------------------------------------------------------------
alter table PERSONNE add constraint FK_ID_CANDIDAT foreign key(ID_CANDIDAT) references CANDIDAT(ID);


-- -----------------------------------------------------------------------------
-- (05.)AFFICHER LA DESCRIPTION DES TABLES CONCERNEES 
-- -----------------------------------------------------------------------------
desc PERSONNE;
desc CANDIDAT;


-- -----------------------------------------------------------------------------
-- CONTRAINTES -- CREATIONS -- FIN
-- -----------------------------------------------------------------------------
