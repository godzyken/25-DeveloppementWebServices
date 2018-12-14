package fr.tacticrh.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import fr.tacticrh.MainApplication;

/**
 * @author franck Taba Taba
 *
 * <b>CLASSE QUI IMPLEMENTE L'INITIALISATION DE LA SERVLET PRINCIPALE DE L'APPLICATION.</b>
 */
public class ServletInitializer extends SpringBootServletInitializer {

	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ServletInitializer.class);

	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder pApplication) {
		
		LOGGER.info("CLASS : ServletInitializer -- METHOD : configure -- BEGIN");
		LOGGER.info("CLASS : ServletInitializer -- METHOD : configure -- END");
		return pApplication.sources(MainApplication.class);
	}
}
