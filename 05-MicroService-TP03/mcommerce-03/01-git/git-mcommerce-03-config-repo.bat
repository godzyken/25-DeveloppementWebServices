##############################################################################
# (01.)INITIALISER UN REPOSITORY LOCAL :
#      -->REPOSITORY A INITIALISER : LE REPERTOIRE COURANT.
##############################################################################
git init

##############################################################################
# (02.)AFFICHER LE CONTENU D'UN REPOSITORY LOCAL :
#      -->CONTENU A AFFICHER : TOUTES LES BRANCHES DU REPOSITORY LOCAL COURANT.
##############################################################################
git branch

##############################################################################
# (03.)AJOUTER DES ELEMENTS DANS LE PROCHAIN COMMIT :
#      -->ELEMENTS A AJOUTER : UN FICHIER / REPERTOIRE DU REPERTOIRE COURANT.
##############################################################################
git add [NOM DU FICHIER   ]
git add [NOM DU REPERTOIRE]

##############################################################################
# (04.)RETIRER DES ELEMENTS DU PROCHAIN COMMIT :
#      -->ELEMENTS A RETIRER : UN FICHIER / REPERTOIRE DU REPERTOIRE COURANT.
##############################################################################
git rm  [NOM DU FICHIER   ]
git rm  [NOM DU REPERTOIRE]

##############################################################################
# (05.)LANCER LE PROCHAIN COMMIT VERS UN REPOSITORY LOCAL :
#      -->REPOSITORY LOCAL DESTINATAIRE : LE REPOSITORY LOCAL COURANT.
##############################################################################
git commit -m "Premier commit"

##############################################################################
# (06.)ENREGISTRER UN REPOSITORY DISTANT COMME "CIBLE" D'UN REPOSITORY LOCAL :
#      -->REPOSITORY DISTANT A ENREGISTRER         : LE REPOSITORY DISTANT FOURNI.
#      -->REPOSITORY LOCAL DANS LEQUEL ENREGISTRER : LE REPOSITORY LOCAL COURANT.
##############################################################################
git remote add distant https://github.com/chat-roux/mcommerce-config-repo.git
git remote add distant git@github.com:chat-roux/mcommerce-config-repo.git

##############################################################################
# (07.)DESENREGISTRER UN REPOSITORY DISTANT COMME "CIBLE" D'UN REPOSITORY LOCAL :
#      -->REPOSITORY DISTANT A DESENREGISTRER         : LE REPOSITORY DISTANT FOURNI.
#      -->REPOSITORY LOCAL DANS LEQUEL DESENREGISTRER : LE REPOSITORY LOCAL COURANT.
##############################################################################
git remote rm distant

##############################################################################
# (08.)TRANSFERER LE CONTENU DU REPOSITORY DISTANT DANS LE REPOSITORY LOCAL :
#      -->ORIGINE DU TRANSFERT     : LA "CIBLE" PRE-ENREGISTREE (REPOSITORY DISTANT).
#      -->DESTINATION DU TRANSFERT : LE REPERTOIRE COURANT (REPOSITORY LOCAL COURANT).
#      -->TYPE DE TRANSFERT : TRANSFERT SANS ECRASEMENT.
##############################################################################
git fetch

##############################################################################
# (09.)TRANSFERER LE CONTENU DU REPOSITORY LOCAL DANS LE REPOSITORY DISTANT :
#      -->ORIGINE DU TRANSFERT     : LE REPERTOIRE COURANT (REPOSITORY LOCAL COURANT).
#      -->DESTINATION DU TRANSFERT : LA "CIBLE" PRE-ENREGISTREE (REPOSITORY DISTANT).
#      -->TYPE DE TRANSFERT : TRANSFERT AVEC ECRASEMENT.
##############################################################################
git push -u distant master
