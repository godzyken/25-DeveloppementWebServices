-- -----------------------------------------------------------------------------
-- CONTRAINTES -- SUPPRESSIONS -- DEBUT
-- -----------------------------------------------------------------------------


-- -----------------------------------------------------------------------------
-- (01.)AFFICHER LA DESCRIPTION DES TABLES CONCERNEES 
-- -----------------------------------------------------------------------------
desc DROIT;
desc UTILISATEUR;


-- -----------------------------------------------------------------------------
-- (02.)SUPPRIMER LES CONTRAINTES DE CLE ETRANGERES
-- -----------------------------------------------------------------------------
alter table UTILISATEUR drop foreign key FK_ID_DROIT;


-- -----------------------------------------------------------------------------
-- (03.)SUPPRIMER LES CONTRAINTES D'AUTO-INCREMENT
-- -----------------------------------------------------------------------------
alter table DROIT modify column ID integer(11);
alter table UTILISATEUR modify column ID integer(11);


-- -----------------------------------------------------------------------------
-- (04.)SUPPRIMER LES CONTRAINTES D'UNICITE
-- -----------------------------------------------------------------------------
alter table UTILISATEUR drop index FK_ID_DROIT;
alter table UTILISATEUR drop index IDENTIFIANT;
alter table UTILISATEUR drop index ID;
alter table DROIT drop index ID;


-- -----------------------------------------------------------------------------
-- (05.)SUPPRIMER LES CONTRAINTES DE CLE PRIMAIRES
-- -----------------------------------------------------------------------------
alter table UTILISATEUR drop primary key;
alter table DROIT drop primary key;


-- -----------------------------------------------------------------------------
-- (056.)AFFICHER LA DESCRIPTION DES TABLES CONCERNEES 
-- -----------------------------------------------------------------------------
desc DROIT;
desc UTILISATEUR;


-- -----------------------------------------------------------------------------
-- CONTRAINTES -- SUPPRESSIONS -- FIN
-- -----------------------------------------------------------------------------
