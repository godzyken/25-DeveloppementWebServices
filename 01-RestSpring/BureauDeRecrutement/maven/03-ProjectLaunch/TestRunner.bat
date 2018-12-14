
REM ****************************************************************************
REM * DEMARRER LA JVM (JAVA VIRTUAL MACHINE) EN LUI FOURNISSANT LES ARGUMENTS SUIVANTS :
REM *
REM * ->L'EMPLACEMENT ET LE NOM DU FICHIER EXECUTABLE DU PROJET.
REM * ->LE NOM DE LA CLASSE DE LANCEMENT DES TESTS DU PROJET (CLASSE QUI CONTIENT UNE FONCTION 'main').
REM ****************************************************************************
java -verbose -classpath C:\Users\AA\.m2\repository;./target/BureauDeRecrutement.war;./target/test-classes fr.tacticrh.TestRunner>.\log\TestRunner\TestRunner--%date:~6,4%.%date:~3,2%.%date:~0,2%--%time:~0,2%.%time:~3,2%.%time:~6,2%.log
java -verbose -classpath C:\Users\AA\.m2\repository;./target/BureauDeRecrutement.war;./target/test-classes fr.tacticrh.TestRunner>.\log\TestRunner\TestRunner--%date:~6,4%.%date:~3,2%.%date:~0,2%--0%time:~1,1%.%time:~3,2%.%time:~6,2%.log

java -verbose fr.tacticrh.TestRunner>.\log\TestRunner\TestRunner--%date:~6,4%.%date:~3,2%.%date:~0,2%--0%time:~1,1%.%time:~3,2%.%time:~6,2%.log
java -verbose fr.tacticrh.TestRunner
