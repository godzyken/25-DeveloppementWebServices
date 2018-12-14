/**
 * 
 */
package fr.tacticrh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @author 1603599
 *
 * <b>CLASSE QUI IMPLEMENTE LA NAVIGATION ET LE CONTROLE RELATIFS A LA SECTION 'PERSONNE'.</b>
 */
@Controller
@RequestMapping(value="/personne")
public class PersonneController {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonneController.class);
	
	
	
	
	@RequestMapping(value="/entrer")
	public String entrer () {
		
		LOGGER.info("CLASS : PersonneController -- METHOD : entrer -- BEGIN");
		LOGGER.info("CLASS : PersonneController -- METHOD : entrer -- END");
		return "personneView";
	}
	
	@RequestMapping(value="/gererPersonnes")
	public String gererPersonnes () {
		
		LOGGER.info("CLASS : PersonneController -- METHOD : gererPersonnes -- BEGIN");
		LOGGER.info("CLASS : PersonneController -- METHOD : gererPersonnes -- END");
		return "personneView";
	}	
}
