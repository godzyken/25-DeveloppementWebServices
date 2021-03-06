package fr.tacticrh.utilisateur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties
@SpringBootApplication
public class UtilisateurServerApplication {
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
	 * <br/>
	 * Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurServerApplication.class);

	
	/**
	 * <b>METHODE D'ENTREE DE L'APPLICATION</b><br/>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		LOGGER.info("CLASS : UtilisateurServerApplication -- METHOD : main -- BEGIN");
		
		SpringApplication.run(UtilisateurServerApplication.class, args);
		
		LOGGER.info("CLASS : UtilisateurServerApplication -- METHOD : main -- END");
	}
}
