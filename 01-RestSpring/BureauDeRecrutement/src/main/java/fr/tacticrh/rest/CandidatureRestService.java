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

import fr.tacticrh.exception.candidat.InvalidArgumentCandidatException;
import fr.tacticrh.exception.candidature.IllegalTransactionCandidatureException;
import fr.tacticrh.exception.candidature.InvalidArgumentCandidatureException;
import fr.tacticrh.exception.candidature.RecordNotFoundCandidatureException;
import fr.tacticrh.exception.curriculum.InvalidArgumentCurriculumException;
import fr.tacticrh.exception.motivation.InvalidArgumentMotivationException;
import fr.tacticrh.metier.candidature.ICandidatureMetier;
import fr.tacticrh.model.Candidature;
import fr.tacticrh.model.Curriculum;
import fr.tacticrh.model.Motivation;

/**
 * @author Tcharou DALGALIAN
 * 
 * <br/><b>SERVICE REST QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Candidature'.
 */
@RestController
public class CandidatureRestService {
	
	

	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CandidatureRestService.class);
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les traitements metier relatifs a l'entite 'Candidature'.
	 */
	@Autowired
	private ICandidatureMetier candidatureMetier;

	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter une candidature dans les donnees persistantes.
	 * 
	 * @param pCandidatId L'identifiant du candidat avec lequel l'ajout doit etre effectue.
	 * @param pCandidature La candidature avec lequel l'ajout doit etre effectue.
	 * @return Candidature La candidature modifiée.
	 * @throws InvalidArgumentCandidatException Lancee dans le cas : L'identifiant du candidat est invalide.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : La candidature fournie est invalide.
	 * @throws IllegalTransactionCandidatureException Lancee dans le cas : L'ajout demande est illegal.
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#add(java.lang.Long, fr.tacticrh.model.Candidature)
	 */
	@RequestMapping(value="/candidature", method=RequestMethod.POST)
	@ResponseBody
	public Candidature add (@RequestParam(value="candidatId", required=true) Long pCandidatId
							, @RequestBody Candidature pCandidature) throws InvalidArgumentCandidatException
																			, InvalidArgumentCandidatureException
																			, IllegalTransactionCandidatureException {
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : add -- BEGIN");
		
		Candidature candidatureCreated = this.candidatureMetier.add(pCandidatId, pCandidature);
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : add -- END");
		return candidatureCreated;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter un curriculum à une candidature dans les donnees persistantes.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature sur laquelle l'ajout doit etre effectue.
	 * @param pCurriculum Le curriculum avec lequel l'ajout doit etre effectue.
	 * @return Candidature La candidature modifiée.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : L'identifiant de la candidature fournie est invalide.
	 * @throws InvalidArgumentCurriculumException Lancee dans le cas : Le curriculum fourni est invalide.
	 * @throws IllegalTransactionCandidatureException Lancee dans le cas : L'ajout demande est illegal.
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#addCurriculum (java.lang.Long, fr.tacticrh.model.Curriculum)
	 */
	@RequestMapping(value="/candidature/curriculum", method=RequestMethod.POST)
	@ResponseBody
	public Candidature addCurriculum (@RequestParam(value="candidatureId", required=true) Long pCandidatureId
									, @RequestBody Curriculum pCurriculum) throws InvalidArgumentCandidatureException
																					, InvalidArgumentCurriculumException
																					, IllegalTransactionCandidatureException {
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : addCurriculum -- BEGIN");
		
		Candidature candidatureCreated = this.candidatureMetier.addCurriculum (pCandidatureId, pCurriculum);
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : addCurriculum -- END");
		return candidatureCreated;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter une motivation à une candidature dans les donnees persistantes.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature sur laquelle l'ajout doit etre effectue.
	 * @param pMotivation La motivation avec laquelle l'ajout doit etre effectue.
	 * @return Candidature La candidature modifiée.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : L'identifiant de la candidature fournie est invalide.
	 * @throws InvalidArgumentMotivationException Lancee dans le cas : La lettre de motivation fournie est invalide.
	 * @throws IllegalTransactionCandidatureException Lancee dans le cas : L'ajout demande est illegal.
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#addMotivation (java.lang.Long, fr.tacticrh.model.Motivation)
	 */
	@RequestMapping(value="/candidature/motivation", method=RequestMethod.POST)
	@ResponseBody
	public Candidature addMotivation (@RequestParam(value="candidatureId", required=true) Long pCandidatureId
									, @RequestBody Motivation pMotivation) throws InvalidArgumentCandidatureException
																					, InvalidArgumentMotivationException
																					, IllegalTransactionCandidatureException {
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : addMotivation -- BEGIN");
		
		Candidature candidatureCreated = this.candidatureMetier.addMotivation (pCandidatureId, pMotivation);
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : addMotivation -- END");
		return candidatureCreated;
	}
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une candidature dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant de la candidature.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature a rechercher.
	 * @return Candidature La candidature trouvee.
	 * @throws RecordNotFoundCandidatureException La candidature recherchee est introuvable. 
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#find(java.lang.Long)
	 */
	@RequestMapping(value="/candidature/id/{candidatureId}", method=RequestMethod.GET)
	public Candidature find (@PathVariable(name="candidatureId", required=true) Long pCandidatureId) throws RecordNotFoundCandidatureException {
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : find -- BEGIN");

		Candidature candidatureFound = this.candidatureMetier.find(pCandidatureId);
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : find -- END");
		return candidatureFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de candidatures dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher toutes les candidatures).
	 * 
	 * @return List<Candidature> La collection des candidatures trouvees.
	 * @throws RecordNotFoundCandidatureException Les candidatures recherchees sont introuvables. 
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#findAll()
	 */
	@RequestMapping(value="/candidature/all", method=RequestMethod.GET)
	public List<Candidature> findAll() throws RecordNotFoundCandidatureException {
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : findAll -- BEGIN");

		List<Candidature> candidaturesFound = this.candidatureMetier.findAll();
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : findAll -- END");
		return candidaturesFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de candidatures dans les donnees persistantes.
	 * <br/>Critere de recherche : Le mail de la personne associee a la candidature.
	 * 
	 * @param pMail Le mail de la personne associee a la candidature a rechercher.
	 * @return List<Candidature> La collection des candidatures trouvees.
	 * @throws RecordNotFoundCandidatureException La candidature recherchee est introuvable. 
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#findByPersonneMail(java.lang.String)
	 */
	@RequestMapping(value="/candidature/personne/mail", method=RequestMethod.GET)
	public List<Candidature> findByPersonneMail (@RequestParam(name="personneMail", required=true) String pMail) throws RecordNotFoundCandidatureException {
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : findByPersonneMail -- BEGIN");

		List<Candidature> candidaturesFound = this.candidatureMetier.findByPersonneMail(pMail);
		
		LOGGER.info("CLASS : CandidatureRestService -- METHOD : findByPersonneMail -- END");
		return candidaturesFound;
	}
}
