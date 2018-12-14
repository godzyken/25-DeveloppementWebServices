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

import fr.tacticrh.exception.candidature.IllegalTransactionCandidatureException;
import fr.tacticrh.exception.candidature.InvalidArgumentCandidatureException;
import fr.tacticrh.exception.curriculum.IllegalTransactionCurriculumException;
import fr.tacticrh.exception.curriculum.InvalidArgumentCurriculumException;
import fr.tacticrh.exception.curriculum.RecordNotFoundCurriculumException;
import fr.tacticrh.metier.curriculum.ICurriculumMetier;
import fr.tacticrh.model.Curriculum;

/**
 * @author Tcharou DALGALIAN
 * 
 * <br/><b>SERVICE REST QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Curriculum'.
 */
@RestController
public class CurriculumRestService {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CurriculumRestService.class);
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les traitements metier relatifs a l'entite 'Curriculum'.
	 */
	@Autowired
	private ICurriculumMetier curriculumMetier;
	
	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter un curriculum dans les donnees persistantes.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature avec laquelle l'ajout doit etre effectue.
	 * @param pCurriculum Le curriculum avec lequel l'ajout doit etre effectue.
	 * @return Curriculum Le curriculum ajoute.
	 * @throws InvalidArgumentCurriculumException Lancee dans le cas : Le curriculum est invalide.
	 * @throws IllegalTransactionCurriculumException Lancee dans le cas : L'ajout demandé est illegal.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : L'identifiant de la candidature fourni est invalide.
	 * @throws IllegalTransactionCandidatureException Lancee dans le cas : L'ajout demandé est illegal.
	 * @see fr.tacticrh.metier.curriculum.ICurriculumMetier#addUpdate(java.lang.Long, fr.tacticrh.model.Curriculum)
	 */
	@RequestMapping(value="/curriculum", method=RequestMethod.POST)
	@ResponseBody
	public Curriculum add(@RequestParam(value="candidatureId", required=true) Long pCandidatureId, @RequestBody Curriculum pCurriculum) throws InvalidArgumentCurriculumException, IllegalTransactionCurriculumException, InvalidArgumentCandidatureException, IllegalTransactionCandidatureException {
		
		LOGGER.info("CLASS : CurriculumRestService -- METHOD : add -- BEGIN");

		Curriculum curriculumCreated = this.curriculumMetier.addUpdate(pCandidatureId, pCurriculum);
		
		LOGGER.info("CLASS : CurriculumRestService -- METHOD : add -- END");
		return curriculumCreated;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un curriculum dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant du curriculum.
	 * 
	 * @param pCurriculumId L'identifiant du curriculum a rechercher.
	 * @return Curriculum Le curriculum trouve.
	 * @throws RecordNotFoundCurriculumException Exception lancee dans le cas : Le curriculum recherche est introuvable. 
	 * @see fr.tacticrh.metier.curriculum.ICurriculumMetier#find(java.lang.Long)
	 */
	@RequestMapping(value="/curriculum/id/{curriculumId}", method=RequestMethod.GET)
	public Curriculum find(@PathVariable(name="curriculumId", required=true) Long pCurriculumId) throws RecordNotFoundCurriculumException {
		
		LOGGER.info("CLASS : CurriculumRestService -- METHOD : find -- BEGIN");

		Curriculum curriculumFound = this.curriculumMetier.find(pCurriculumId);
		
		LOGGER.info("CLASS : CurriculumRestService -- METHOD : find -- END");
		return curriculumFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de curriculums dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher tous les curriculums).
	 * 
	 * @return List<Curriculum> La collection des curriculums trouves.
	 * @throws RecordNotFoundCurriculumException Exception lancee dans le cas : La collection de curriculums recherchee est introuvable. 
	 * @see fr.tacticrh.metier.curriculum.ICurriculumMetier#findAll()
	 */
	@RequestMapping(value="/curriculum/all", method=RequestMethod.GET)
	public List<Curriculum> findAll() throws RecordNotFoundCurriculumException {
		
		LOGGER.info("CLASS : CurriculumRestService -- METHOD : findAll -- BEGIN");

		List<Curriculum> curriculumsFound = this.curriculumMetier.findAll();
		
		LOGGER.info("CLASS : CurriculumRestService -- METHOD : findAll -- END");
		return curriculumsFound;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de curriculums dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant de la candidature associee au curriculum.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature associee au curriculum a rechercher.
	 * @return Curriculum Le curriculum trouve.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : L'identifiant de candidature fourni est invalide.
	 * @throws IllegalTransactionCurriculumException Lancee dans le cas : La transaction demandee est illegale.
	 * @see fr.tacticrh.metier.curriculum.ICurriculumMetier#findByCandidatureId(java.lang.Long)
	 */
	@RequestMapping(value="/curriculum/candidature/id/{candidatureId}", method=RequestMethod.GET)
	public Curriculum findByCandidatureId(@PathVariable(name="candidatureId", required=true) Long pCandidatureId) throws InvalidArgumentCandidatureException, IllegalTransactionCurriculumException {
		
		LOGGER.info("CLASS : CurriculumRestService -- METHOD : findByCandidatureId -- BEGIN");

		Curriculum curriculumFound = this.curriculumMetier.findByCandidatureId(pCandidatureId);
		
		LOGGER.info("CLASS : CurriculumRestService -- METHOD : findByCandidatureId -- END");
		return curriculumFound;
	}
}
