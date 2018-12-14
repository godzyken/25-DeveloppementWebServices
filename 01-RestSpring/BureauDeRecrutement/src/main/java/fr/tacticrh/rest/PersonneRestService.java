/**
 * 
 */
package fr.tacticrh.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.tacticrh.exception.personne.IllegalTransactionPersonneException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.personne.RecordNotFoundPersonneException;
import fr.tacticrh.metier.personne.IPersonneMetier;
import fr.tacticrh.model.Personne;

/**
 * @author Franck Taba Taba
 * 
 * <br/><b>SERVICE REST QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Personne'.
 */
@RestController
public class PersonneRestService {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonneRestService.class);
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les traitements metier relatifs a l'entite 'Personne'.
	 */
	@Autowired
	private IPersonneMetier personneMetier;

	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter une personne dans les donnees persistantes.
	 * 
	 * @param pPersonne La personne avec laquelle l'ajout doit etre effectue.
	 * @return Personne La personne ajoutee.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne est invalide.
	 * @throws IllegalTransactionPersonneException Lancee dans le cas : L'ajout demandé est illegal.
	 * @see fr.tacticrh.metier.personne.IPersonneMetier#update(fr.tacticrh.model.Personne)
	 */
	@RequestMapping(value="/personne", method=RequestMethod.POST)
	@ResponseBody
	public Personne add(@RequestBody Personne pPersonne) throws InvalidArgumentPersonneException, IllegalTransactionPersonneException {
		
		LOGGER.info("CLASS : PersonneRestService -- METHOD : add -- BEGIN");

		Personne personneCreated = this.personneMetier.update(pPersonne);
		
		LOGGER.info("CLASS : PersonneRestService -- METHOD : add -- END");
		return personneCreated;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une personne dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant de la personne.
	 * 
	 * @param pPersonneId L'identifiant de la personne a rechercher.
	 * @return Personne La personne trouvee.
	 * @throws RecordNotFoundPersonneException Lancee dans le cas : La personne recherchee est introuvable. 
	 * @see fr.tacticrh.metier.personne.IPersonneMetier#find(java.lang.Long)
	 */
	@RequestMapping(value="/personne/id/{personneId}", method=RequestMethod.GET)
	public Personne find(@PathVariable(name="personneId", required=true) Long pPersonneId) throws RecordNotFoundPersonneException {
		
		LOGGER.info("CLASS : PersonneRestService -- METHOD : find -- BEGIN");

		Personne personneFound = this.personneMetier.find(pPersonneId);
		
		LOGGER.info("CLASS : PersonneRestService -- METHOD : find -- END");
		return personneFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de personnes dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher toutes les personnes).
	 * 
	 * @return List<Personne> La collection des personnes trouvees.
	 * @throws RecordNotFoundPersonneException Lancee dans le cas : La collection de personnes recherchee est introuvable. 
	 * @see fr.tacticrh.metier.personne.IPersonneMetier#findAll()
	 */
	@RequestMapping(value="/personne/all", method=RequestMethod.GET)
	public List<Personne> findAll() throws RecordNotFoundPersonneException {
		
		LOGGER.info("CLASS : PersonneRestService -- METHOD : findAll -- BEGIN");

		List<Personne> personnesFound = this.personneMetier.findAll();
		
		LOGGER.info("CLASS : PersonneRestService -- METHOD : findAll -- END");
		return personnesFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une personne dans les donnees persistantes.
	 * <br/>Critere de recherche : Le mail de la personne.
	 * 
	 * @param pMail Le mail de la personne a rechercher.
	 * @return Personne La personne trouvee.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : Le mail de la personne fourni est invalide.
	 * @throws IllegalTransactionPersonneException Lancee dans le cas : La transaction demandee est illegale.
	 * @throws RecordNotFoundPersonneException Lancee dans le cas : La personne recherchee est introuvable.
	 * @see fr.tacticrh.metier.personne.IPersonneMetier#findByMail(java.lang.String)
	 */
	@RequestMapping(value="/personne/mail", method=RequestMethod.GET) 
	public Personne findByMail(@RequestParam(name="personneMail", required=true) String pMail) throws InvalidArgumentPersonneException, IllegalTransactionPersonneException, RecordNotFoundPersonneException {
		
		LOGGER.info("CLASS : PersonneRestService -- METHOD : findByMail -- BEGIN");

		Personne personneFound = this.personneMetier.findByMail(pMail);
		
		LOGGER.info("CLASS : PersonneRestService -- METHOD : findByMail -- END");
		return personneFound;
	}
}
