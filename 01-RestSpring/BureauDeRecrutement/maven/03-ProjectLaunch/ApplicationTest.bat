
REM ****************************************************************************
REM * DEMARRER LA JVM (JAVA VIRTUAL MACHINE) EN LUI FOURNISSANT LES ARGUMENTS SUIVANTS :
REM *
REM * ->L'EMPLACEMENT ET LE NOM DU FICHIER EXECUTABLE DU PROJET.
REM * ->LE NOM DE LA CLASSE PRINCIPALE DES TESTS DU PROJET (CLASSE DE TEST QUI CONTIENT LA FONCTION 'main').
REM ****************************************************************************
java -verbose -classpath ./target/test-classes fr.tacticrh.ApplicationTest>.\log\ApplicationTest\ApplicationTest--%date:~6,4%.%date:~3,2%.%date:~0,2%--%time:~0,2%.%time:~3,2%.%time:~6,2%.log
java -verbose -classpath ./target/test-classes fr.tacticrh.ApplicationTest>.\log\ApplicationTest\ApplicationTest--%date:~6,4%.%date:~3,2%.%date:~0,2%--0%time:~1,1%.%time:~3,2%.%time:~6,2%.log

java -verbose fr.tacticrh.ApplicationTest>.\log\ApplicationTest\ApplicationTest--%date:~6,4%.%date:~3,2%.%date:~0,2%--0%time:~1,1%.%time:~3,2%.%time:~6,2%.log
java -verbose fr.tacticrh.ApplicationTest

java -verbose -classpath ./target/BureauDeRecrutement.war;./target/test-classes fr.tacticrh.ApplicationTest>.\log\ApplicationTest\ApplicationTest--%date:~6,4%.%date:~3,2%.%date:~0,2%--%time:~0,2%.%time:~3,2%.%time:~6,2%.log
java -verbose -classpath ./target/BureauDeRecrutement.war;./target/test-classes fr.tacticrh.ApplicationTest>.\log\ApplicationTest\ApplicationTest--%date:~6,4%.%date:~3,2%.%date:~0,2%--0%time:~1,1%.%time:~3,2%.%time:~6,2%.log
