/**
 * 
 */
package fr.tacticrh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tcharou Dalgalian
 *
 * <b>CLASSE QUI IMPLEMENTE LA NAVIGATION ET LE CONTROLE RELATIFS A LA SECURITE DE L'APPLICATION.</b>
 */
@Controller
public class SecuriteController {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SecuriteController.class);
	
	
	
	
	/**
	@RequestMapping(value="/")
	public String home () {
		
		LOGGER.info("CLASS : SecuriteController -- METHOD : home -- BEGIN");
		LOGGER.info("CLASS : SecuriteController -- METHOD : home -- END");
		return "redirect:/identifier";
	}*/

	@RequestMapping(value="/entrer")
	public String entrer () {
		
		LOGGER.info("CLASS : SecuriteController -- METHOD : entrer -- BEGIN");
		LOGGER.info("CLASS : SecuriteController -- METHOD : entrer -- END");
		return "redirect:/identifier";
	}
	
	@RequestMapping(value="/identifier")
	public String identifier () {
		
		LOGGER.info("CLASS : SecuriteController -- METHOD : identifier -- BEGIN");
		LOGGER.info("CLASS : SecuriteController -- METHOD : identifier -- END");
		return "identifierView";
	}

	@RequestMapping(value="/refuserAcces")
	public String refuserAcces () {
		
		LOGGER.info("CLASS : SecuriteController -- METHOD : refuserAcces -- BEGIN");
		LOGGER.info("CLASS : SecuriteController -- METHOD : refuserAcces -- END");
		return "redirect:/refuserAcces";
	}
}
