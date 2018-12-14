package fr.tacticrh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/**
 * <b>CLASSE QUI IMPLEMENTE LA METHODE D'ENTREE DE L'APPLICATION</b>
 * 
 * @author Franck
 */
@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);

	
	
	/**
	 * <b>METHODE D'ENTREE DE L'APPLICATION</b>
	 * @param args
	 */
	public static void main(String[] args) {
		
		LOGGER.info("CLASS : MainApplication -- METHOD : main -- BEGIN");
		
		////////////////////////////////////////////////////////////////////////
		// (01.)RECUPERER LE CONTEXTE DE L'APPLICATION.
		////////////////////////////////////////////////////////////////////////
		ApplicationContext applicationContext = SpringApplication.run(MainApplication.class, args);
		
		////////////////////////////////////////////////////////////////////////
		// (02.)RECUPERER LES BEANS DANS LE CONTEXTE DE L'APPLICATION.
		////////////////////////////////////////////////////////////////////////
		afficherBeans(applicationContext);
		
		LOGGER.info("CLASS : MainApplication -- METHOD : main -- END");
	}
	
	/**
	 * <b>METHODE PRINCIPALE DE L'APPLICATION</b>
	 * @param args
	 */
	@Override
	public void run(String... arg0) throws Exception {
		
		LOGGER.info("CLASS : MainApplication -- METHOD : run -- BEGIN");
		
		// -- INSERT USER-CODE HERE !!! -- 
		
		LOGGER.info("CLASS : MainApplication -- METHOD : run -- END");
	}
	
	
	
	/**
	 * <b>AFFICHER LA LISTE DES BEANS DU CONTEXTE DE L'APPLICATION.</b>
	 * 
	 * @param pApplicationContext Le contexte de l'application.
	 */
	private static void afficherBeans(ApplicationContext pApplicationContext) {
		
		LOGGER.info("CLASS : MainApplication -- METHOD : afficherBeans -- BEGIN");
		
		String[] beanNames = pApplicationContext.getBeanDefinitionNames();
		
		LOGGER.info("+-------------------------------------------------------------------------------+");
		LOGGER.info("| APPLICATION-CONTEXT : BEANS LIST                                              |");
		LOGGER.info("+-------------------------------------------------------------------------------+");
		for(String beanName : beanNames) {
			LOGGER.info("| beanName : [" + beanName + "]");
		}
		LOGGER.info("+-------------------------------------------------------------------------------+");
		
		LOGGER.info("CLASS : MainApplication -- METHOD : afficherBeans -- END");
	}
}
