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

import fr.tacticrh.exception.administrateur.IllegalTransactionAdministrateurException;
import fr.tacticrh.exception.administrateur.InvalidArgumentAdministrateurException;
import fr.tacticrh.exception.administrateur.RecordNotFoundAdministrateurException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.metier.administrateur.IAdministrateurMetier;
import fr.tacticrh.model.Administrateur;

/**
 * @author Franck Taba Taba
 * 
 * <br/><b>SERVICE REST QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Administrateur'.
 */
@RestController
public class AdministrateurRestService {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministrateurRestService.class);
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les traitements metier relatifs a l'entite 'Administrateur'.
	 */
	@Autowired
	private IAdministrateurMetier administrateurMetier;
	

	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter un administrateur dans les donnees persistantes.
	 * 
	 * @param pAdministrateur L'administrateur avec lequel l'ajout doit etre effectue.
	 * @return Administrateur L'administrateur ajoute.
	 * @throws InvalidArgumentAdministrateurException Lancee dans le cas : L'administrateur est invalide.
	 * @throws InvalidArgumentUtilisateurException Lancee dans le cas : L'utilisateur associe a l'administrateur fourni est invalide.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne associee a l'administrateur fourni est invalide.
	 * @throws IllegalTransactionUtilisateurException Lancee dans le cas : L'ajout demandé est illegal.
	 * @see fr.tacticrh.metier.administrateur.IAdministrateurMetier#add(fr.tacticrh.model.Candidat)
	 */
	@RequestMapping(value="/administrateur", method=RequestMethod.POST)
	@ResponseBody
	public Administrateur add(@RequestBody Administrateur pAdministrateur) throws InvalidArgumentAdministrateurException
																				, InvalidArgumentUtilisateurException
																				, InvalidArgumentPersonneException
																				, IllegalTransactionUtilisateurException {
		
		LOGGER.info("CLASS : AdministrateurRestService -- METHOD : add -- BEGIN");
		
		Administrateur administrateurCreated = this.administrateurMetier.add(pAdministrateur);
		
		LOGGER.info("CLASS : AdministrateurRestService -- METHOD : add -- END");
		return administrateurCreated;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un administrateur dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant de l'administrateur.
	 * 
	 * @param pAdministrateurId L'identifiant de l'administrateur a rechercher.
	 * @return Administrateur L'administrateur trouve.
	 * @throws RecordNotFoundAdministrateurException Lancee dans le cas : L'administrateur recherche est introuvable. 
	 * @see fr.tacticrh.metier.administrateur.IAdministrateurMetier#find(java.lang.Long)
	 */
	@RequestMapping(value="/administrateur/id/{administrateurId}", method=RequestMethod.GET)
	public Administrateur find(@PathVariable(name="administrateurId", required=true) Long pAdministrateurId) throws RecordNotFoundAdministrateurException {
		
		LOGGER.info("CLASS : AdministrateurRestService -- METHOD : find -- BEGIN");

		Administrateur administrateurFound = this.administrateurMetier.find(pAdministrateurId);
		
		LOGGER.info("CLASS : AdministrateurRestService -- METHOD : find -- END");
		return administrateurFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection d'administrateurs dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher tous les administrateurs).
	 * 
	 * @return List<Administrateur> La collection des administrateurs trouves.
	 * @throws RecordNotFoundAdministrateurException Lancee dans le cas : La collection des administrateurs recherchee est introuvable. 
	 * @see fr.tacticrh.metier.administrateur.IAdministrateurMetier#findAll()
	 */
	@RequestMapping(value="/administrateur/all", method=RequestMethod.GET)
	public List<Administrateur> findAll() throws RecordNotFoundAdministrateurException {
		
		LOGGER.info("CLASS : AdministrateurRestService -- METHOD : findAll -- BEGIN");

		List<Administrateur> administrateursFound = this.administrateurMetier.findAll();
		
		LOGGER.info("CLASS : AdministrateurRestService -- METHOD : findAll -- END");
		return administrateursFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un administrateur dans les donnees persistantes.
	 * <br/>Critere de recherche : Le mail de la personne associee a l'administrateur.
	 * 
	 * @param pPersonneMail Le mail de la personne associee a l'administrateur.
	 * @return Administrateur L'administrateur trouve.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : Le mail de la personne fourni est invalide.
	 * @throws RecordNotFoundAdministrateurException Lancee dans le cas : L'administrateur est introuvable.
	 * @throws IllegalTransactionAdministrateurException Lancee dans le cas : La transaction demandee est illegale.
	 * @see fr.tacticrh.metier.administrateur.IAdministrateurMetier#findByPersonneMail(java.lang.String)
	 */
	@RequestMapping(value="/administrateur/mail", method=RequestMethod.GET) 
	public Administrateur findByMail(@RequestParam(name="personneMail", required=true) String pPersonneMail) throws InvalidArgumentPersonneException
																													, RecordNotFoundAdministrateurException
																													, IllegalTransactionAdministrateurException {
		
		LOGGER.info("CLASS : AdministrateurRestService -- METHOD : findByMail -- BEGIN");

		Administrateur administrateurFound = this.administrateurMetier.findByPersonneMail(pPersonneMail);
		
		LOGGER.info("CLASS : AdministrateurRestService -- METHOD : findByMail -- END");
		return administrateurFound;
	}
}
