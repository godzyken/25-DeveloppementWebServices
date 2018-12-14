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

import fr.tacticrh.exception.manager.IllegalTransactionManagerException;
import fr.tacticrh.exception.manager.InvalidArgumentManagerException;
import fr.tacticrh.exception.manager.RecordNotFoundManagerException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.metier.manager.IManagerMetier;
import fr.tacticrh.model.Manager;

/**
 * @author Franck Taba Taba
 * 
 * <br/><b>SERVICE REST QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Manager'.
 */
@RestController
public class ManagerRestService {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerRestService.class);
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les traitements metier relatifs a l'entite 'Manager'.
	 */
	@Autowired
	private IManagerMetier managerMetier;
	
	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter un manager dans les donnees persistantes.
	 * 
	 * @param pManager Le manager avec lequel l'ajout doit etre effectue.
	 * @return Manager Le manager ajoute.
	 * @throws InvalidArgumentManagerException Lancee dans le cas : Le manager est invalide.
	 * @throws InvalidArgumentUtilisateurException Lancee dans le cas : L'utilisateur associe au manager fourni est invalide.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne associee au manager fourni est invalide.
	 * @throws IllegalTransactionUtilisateurException Lancee dans le cas : L'ajout demandé est illegal.
	 * @see fr.tacticrh.metier.manager.IManagerMetier#add(fr.tacticrh.model.Candidat)
	 */
	@RequestMapping(value="/manager", method=RequestMethod.POST)
	@ResponseBody
	public Manager add(@RequestBody Manager pManager) throws InvalidArgumentManagerException
																, InvalidArgumentUtilisateurException
																, InvalidArgumentPersonneException
																, IllegalTransactionUtilisateurException {
		
		LOGGER.info("CLASS : ManagerRestService -- METHOD : add -- BEGIN");

		Manager managerCreated = this.managerMetier.add(pManager);
		
		LOGGER.info("CLASS : ManagerRestService -- METHOD : add -- END");
		return managerCreated;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un manager dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant du manager.
	 * 
	 * @param pManagerId L'identifiant du manager a rechercher.
	 * @return Manager Le manager trouve.
	 * @throws RecordNotFoundManagerException Lancee dans le cas : Le manager recherche est introuvable. 
	 * @see fr.tacticrh.metier.manager.IManagerMetier#find(java.lang.Long)
	 */
	@RequestMapping(value="/manager/id/{managerId}", method=RequestMethod.GET)
	public Manager find(@PathVariable(name="managerId", required=true) Long pManagerId) throws RecordNotFoundManagerException {
		
		LOGGER.info("CLASS : ManagerRestService -- METHOD : find -- BEGIN");

		Manager managerFound = this.managerMetier.find(pManagerId);
		
		LOGGER.info("CLASS : ManagerRestService -- METHOD : find -- END");
		return managerFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de managers dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher tous les managers).
	 * 
	 * @return List<Manager> La collection des managers trouves.
	 * @throws RecordNotFoundManagerException Lancee dans le cas : La collection des managers recherchee est introuvable. 
	 * @see fr.tacticrh.metier.manager.IManagerMetier#findAll()
	 */
	@RequestMapping(value="/manager/all", method=RequestMethod.GET)
	public List<Manager> findAll() throws RecordNotFoundManagerException {
		
		LOGGER.info("CLASS : ManagerRestService -- METHOD : findAll -- BEGIN");

		List<Manager> managersFound = this.managerMetier.findAll();
		
		LOGGER.info("CLASS : ManagerRestService -- METHOD : findAll -- END");
		return managersFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un manager dans les donnees persistantes.
	 * <br/>Critere de recherche : Le mail de la personne associee au manager.
	 * 
	 * @param pPersonneMail Le mail de la personne associee au manager.
	 * @return Manager Le manager trouve.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : Le mail de la personne fourni est invalide.
	 * @throws RecordNotFoundManagerException Lancee dans le cas : Le manager est introuvable.
	 * @throws IllegalTransactionManagerException Lancee dans le cas : La transaction demandee est illegale.
	 * @see fr.tacticrh.metier.manager.IManagerMetier#findByPersonneMail(java.lang.String)
	 */
	@RequestMapping(value="/manager/mail", method=RequestMethod.GET) 
	public Manager findByMail(@RequestParam(name="personneMail", required=true) String pPersonneMail) throws InvalidArgumentPersonneException
																											, RecordNotFoundManagerException
																											, IllegalTransactionManagerException {
		
		LOGGER.info("CLASS : ManagerRestService -- METHOD : findByMail -- BEGIN");

		Manager managerFound = this.managerMetier.findByPersonneMail(pPersonneMail);
		
		LOGGER.info("CLASS : ManagerRestService -- METHOD : findByMail -- END");
		return managerFound;
	}
}
