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

import fr.tacticrh.exception.candidat.IllegalTransactionCandidatException;
import fr.tacticrh.exception.candidat.InvalidArgumentCandidatException;
import fr.tacticrh.exception.candidat.RecordNotFoundCandidatException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.metier.candidat.ICandidatMetier;
import fr.tacticrh.model.Candidat;

/**
 * @author Franck Taba Taba
 * 
 * <br/><b>SERVICE REST QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Candidat'.
 */
@RestController
public class CandidatRestService {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CandidatRestService.class);
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les traitements metier relatifs a l'entite 'Candidat'.
	 */
	@Autowired
	private ICandidatMetier candidatMetier;
	
	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter un candidat dans les donnees persistantes.
	 * 
	 * @param pCandidat Le candidat avec lequel l'ajout doit etre effectue.
	 * @return Candidat Le candidat ajoute.
	 * @throws InvalidArgumentCandidatException Lancee dans le cas : Le candidat est invalide.
	 * @throws InvalidArgumentUtilisateurException Lancee dans le cas : L'utilisateur associe au candidat fourni est invalide.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne associee au candidat fourni est invalide.
	 * @throws IllegalTransactionUtilisateurException Lancee dans le cas : L'ajout demandé est illegal.
	 * @see fr.tacticrh.metier.candidat.ICandidatMetier#add(fr.tacticrh.model.Candidat)
	 */
	@RequestMapping(value="/candidat", method=RequestMethod.POST)
	@ResponseBody
	public Candidat add(@RequestBody Candidat pCandidat) throws InvalidArgumentCandidatException
																, InvalidArgumentUtilisateurException
																, InvalidArgumentPersonneException
																, IllegalTransactionUtilisateurException {
		
		LOGGER.info("CLASS : CandidatRestService -- METHOD : add -- BEGIN");
		
		Candidat candidatCreated = this.candidatMetier.add(pCandidat);
		
		LOGGER.info("CLASS : CandidatRestService -- METHOD : add -- END");
		return candidatCreated;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un candidat dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant du candidat.
	 * 
	 * @param pCandidatId L'identifiant du candidat a rechercher.
	 * @return Candidat Le candidat trouve.
	 * @throws RecordNotFoundCandidatException Lancee dans le cas : Le candidat recherche est introuvable. 
	 * @see fr.tacticrh.metier.candidat.ICandidatMetier#find(java.lang.Long)
	 */
	@RequestMapping(value="/candidat/id/{candidatId}", method=RequestMethod.GET)
	public Candidat find(@PathVariable(name="candidatId", required=true) Long pCandidatId) throws RecordNotFoundCandidatException {
		
		LOGGER.info("CLASS : CandidatRestService -- METHOD : find -- BEGIN");

		Candidat candidatFound = this.candidatMetier.find(pCandidatId);
		
		LOGGER.info("CLASS : CandidatRestService -- METHOD : find -- END");
		return candidatFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de candidats dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher tous les candidats).
	 * 
	 * @return List<Candidat> La collection des candidats trouves.
	 * @throws RecordNotFoundCandidatException Lancee dans le cas : La collection des candidats recherchee est introuvable. 
	 * @see fr.tacticrh.metier.candidat.ICandidatMetier#findAll()
	 */
	@RequestMapping(value="/candidat/all", method=RequestMethod.GET)
	public List<Candidat> findAll() throws RecordNotFoundCandidatException {
		
		LOGGER.info("CLASS : CandidatRestService -- METHOD : findAll -- BEGIN");

		List<Candidat> candidatsFound = this.candidatMetier.findAll();
		
		LOGGER.info("CLASS : CandidatRestService -- METHOD : findAll -- END");
		return candidatsFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un candidat dans les donnees persistantes.
	 * <br/>Critere de recherche : Le mail de la personne associee au candidat.
	 * 
	 * @param pPersonneMail Le mail de la personne associee au candidat.
	 * @return Candidat Le candidat trouve.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : Le mail de la personne fourni est invalide.
	 * @throws RecordNotFoundCandidatException Lancee dans le cas : Le candidat est introuvable.
	 * @throws IllegalTransactionCandidatException Lancee dans le cas : La transaction demandee est illegale.
	 * @see fr.tacticrh.metier.candidat.ICandidatMetier#findByPersonneMail(java.lang.String)
	 */
	@RequestMapping(value="/candidat/mail", method=RequestMethod.GET) 
	public Candidat findByMail(@RequestParam(name="personneMail", required=true) String pPersonneMail) throws InvalidArgumentPersonneException
																											, RecordNotFoundCandidatException
																											, IllegalTransactionCandidatException {
		
		LOGGER.info("CLASS : CandidatRestService -- METHOD : findByMail -- BEGIN");

		Candidat candidatFound = this.candidatMetier.findByPersonneMail(pPersonneMail);
		
		LOGGER.info("CLASS : CandidatRestService -- METHOD : findByMail -- END");
		return candidatFound;
	}
}
