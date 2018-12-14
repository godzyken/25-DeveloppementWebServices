REM **********************************************************************************************************
REM * (01.)CREER UN PROJET DE TYPE 'APPLICATION WEB' AVEC LES CARACTERISTIQUES SUIVANTES :
REM *
REM *      ->UNE ARCHITECTURE N-TIERS.
REM *      ->LE FRAMEWORK 'SPRING-BOOT'.
REM *      ->UNE COUCHE APPLICATIVE 'REST-SERVICE'. 
REM **********************************************************************************************************
mvn archetype:generate -DgroupId=afpa.banque.ws -DartifactId=BanqueRestSpringBoot -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
mvn archetype:generate -DgroupId=fr.tacticrh -DartifactId=BureauDeRecrutement -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

REM **********************************************************************************************************
REM * (02.)CREER UN PROJET DE TYPE 'APPLICATION WEB' AVEC LES CARACTERISTIQUES SUIVANTES :
REM *
REM *      ->UNE ARCHITECTURE N-TIERS.
REM *      ->LE FRAMEWORK 'SPRING-WEB'.
REM *      ->UNE COUCHE APPLICATIVE 'REST-SERVICE'. 
REM **********************************************************************************************************
mvn archetype:generate -DgroupId=afpa.banque.ws -DartifactId=BanqueRestSpringWeb -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
