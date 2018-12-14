/**
 * 
 */
package fr.tacticrh.metier.curriculum;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tacticrh.dao.ICandidatureDao;
import fr.tacticrh.dao.ICurriculumDao;
import fr.tacticrh.exception.candidature.IllegalTransactionCandidatureException;
import fr.tacticrh.exception.candidature.InvalidArgumentCandidatureException;
import fr.tacticrh.exception.curriculum.IllegalTransactionCurriculumException;
import fr.tacticrh.exception.curriculum.InvalidArgumentCurriculumException;
import fr.tacticrh.exception.curriculum.RecordNotFoundCurriculumException;
import fr.tacticrh.model.Candidature;
import fr.tacticrh.model.Curriculum;

/**
 * @author Tcharou Dalgalian
 *
 * <br/><b>CLASSE QUI IMPLEMENTE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Curriculum'.
 */
@Transactional
@Service
public class CurriculumMetierImpl implements ICurriculumMetier {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CurriculumMetierImpl.class);

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Curriculum'.
	 */
	@Autowired
	private ICurriculumDao curriculumDao;

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Candidature'.
	 */
	@Autowired
	private ICandidatureDao candidatureDao;

	
	
	
	
	@Override
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.curriculum.ICurriculumMetier#addUpdate(java.lang.Long, fr.tacticrh.model.Curriculum)
	 */
	public Curriculum addUpdate(Long pCandidatureId, Curriculum pCurriculum) throws InvalidArgumentCurriculumException, IllegalTransactionCurriculumException, InvalidArgumentCandidatureException, IllegalTransactionCandidatureException {
		
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : addUpdate -- BEGIN");
		
		/////////////////////////////////////////////////////////////////////////
		// (00.)VERIFIER LA VALIDITE DES PARAMETRES D'ENTREE
		//
		//      ->PARAMETRE N°1 : L'IDENTIFIANT DE LA CANDIDATURE
		//      ->PARAMETRE N°2 : LE CURRICULUM
		/////////////////////////////////////////////////////////////////////////
		this.checkValidityOfCandidatureId(pCandidatureId);
		this.checkValidityOfCurriculum(pCurriculum);
		
		/////////////////////////////////////////////////////////////////////////
		// (01.)EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :
		//
		//      ->OBJET RECHERCHE : LA CANDIDATURE
		//      ->CRITERE DE RECHERCHE : L'IDENTIFIANT DE LA CANDIDATURE FOURNI
		/////////////////////////////////////////////////////////////////////////
		Optional<Candidature> optionalFound = this.candidatureDao.findById(pCandidatureId);	
		
		/////////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS CI-DESSOUS :
		//
		//      ->LA CANDIDATURE TROUVEE CI-DESSUS EST : 'NULL' (ELLE N'EXISTE PAS EN BDD).
		//      =>CONSEQUENCE : ON REFUSE D'AJOUTER LE CURRICULUM A LA CANDIDATURE EN BDD.
		/////////////////////////////////////////////////////////////////////////
		if ((optionalFound == null) || (!optionalFound.isPresent())) {
			LOGGER.error("L'identifiant de la candidature -- Introuvable");
			LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : addUpdate -- END");
			throw new IllegalTransactionCurriculumException("L'identifiant de la candidature -- Introuvable");
			
		} 
		Candidature candidatureFound = optionalFound.get();
		/////////////////////////////////////////////////////////////////////////
		// (03.)INSERER LES OBJETS CI-DESSOUS EN BDD :
		//
		//      ->LE CURRICULUM.
		/////////////////////////////////////////////////////////////////////////
		Curriculum curriculumCreated = this.curriculumDao.save(pCurriculum);

		/////////////////////////////////////////////////////////////////////////
		// (04.)DANS L'OBJET TROUVE 'CANDIDATURE', ALIMENTER LES ATTRIBUTS CI-DESSOUS :
		//
		//      ->L'ATTRIBUT 'CURRICULUM' (AVEC LE CURRICULUM RESULTANT DE L'INSERTION PRECEDENTE).
		/////////////////////////////////////////////////////////////////////////
		candidatureFound.setCurriculum(curriculumCreated);
		
		/////////////////////////////////////////////////////////////////////////
		// (05.)EFFECTUER L'OPERATION D'INSERTION CI-DESSOUS :
		//
		//      ->OBJET INSERE : LA CANDIDATURE
		/////////////////////////////////////////////////////////////////////////
		Candidature candidatureCreated = this.candidatureDao.save(candidatureFound);	
		
		/////////////////////////////////////////////////////////////////////////
		// (06.)EFFECTUER L'OPERATION D'EXTRACTION CI-DESSOUS :
		//
		//      ->OBJET CONCERNE : LA CANDIDATURE
		//      ->ATTRIBUT A EXTRAIRE : LE CURRICULUM
		/////////////////////////////////////////////////////////////////////////
		Curriculum curriculumLinked = candidatureCreated.getCurriculum();

		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : addUpdate -- END");
		return curriculumLinked;
	}

	@Override
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.curriculum.ICurriculumMetier#find(java.lang.Long)
	 */
	public Curriculum find(Long pCurriculumId) throws RecordNotFoundCurriculumException {
		
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : find -- BEGIN");
		
		Optional<Curriculum> optionalFound = this.curriculumDao.findById(pCurriculumId);
		
		if ((optionalFound == null) || (!optionalFound.isPresent())) { 
			LOGGER.error("L'identifiant du curriculum -- Introuvable");
			LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : find -- END");
			throw new RecordNotFoundCurriculumException("L'identifiant du curriculum -- Introuvable"); 
		}
		Curriculum curriculumFound = optionalFound.get();
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : find -- END");
		return curriculumFound;
	}

	@Override
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.curriculum.ICurriculumMetier#findAll()
	 */
	public List<Curriculum> findAll() throws RecordNotFoundCurriculumException {
		
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : findAll -- BEGIN");

		List<Curriculum> curriculumsFound = this.curriculumDao.findAll();
		
		if ((curriculumsFound == null) || (curriculumsFound.isEmpty())) {
			LOGGER.error("Les curriculums -- Introuvables");
			LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : findAll -- END");
			throw new RecordNotFoundCurriculumException("Les curriculums -- Introuvables"); 
		}
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : findAll -- END");
		return curriculumsFound;
	}	
	
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.curriculum.ICurriculumMetier#findByCandidatureId(java.lang.Long)
	 */
	@Override
	public Curriculum findByCandidatureId(Long pCandidatureId) throws InvalidArgumentCandidatureException, IllegalTransactionCurriculumException {
		
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : findByCandidatureId -- BEGIN");
		
		/////////////////////////////////////////////////////////////////////////
		// (00.)VERIFIER LA VALIDITE DES PARAMETRES D'ENTREE :
		//
		//      ->PARAMETRE N°1 : L'IDENTIFIANT DE LA CANDIDATURE
		/////////////////////////////////////////////////////////////////////////
		this.checkValidityOfCandidatureId(pCandidatureId);
		
		/////////////////////////////////////////////////////////////////////////
		// (01.)EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :
		//
		//      ->OBJET RECHERCHE : LE CURRICULUM
		//      ->CRITERE DE RECHERCHE : L'IDENTIFIANT DE LA CANDIDATURE FOURNIE
		/////////////////////////////////////////////////////////////////////////
		Curriculum curriculumFound = this.curriculumDao.findByCandidatureId(pCandidatureId);
		
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : findByCandidatureId -- END");
		return curriculumFound;
	}
	
	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite d'un identifiant de candidature.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature a valider.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou l'identifiant de la candidature est valide. 
	 *         <br/>FAUX : Cas ou l'identifiant de la candidature est invalide.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : L'identifiant de la candidature est invalide.
	 */
	private boolean checkValidityOfCandidatureId(Long pCandidatureId) throws InvalidArgumentCandidatureException {
		
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : checkValidityOfCandidatureId -- BEGIN");

		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->L'IDENTIFIANT DE LA CANDIDATURE FOURNI EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pCandidatureId == null) {
			LOGGER.error("L'identifiant de la candidature -- Valeur : null");
			LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : checkValidityOfCandidatureId -- END");
			throw new InvalidArgumentCandidatureException("->L'identifiant de la candidature -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS SUIVANT :
		//      ->L'IDENTIFIANT DE LA CANDIDATURE FOURNI EST NON NULL.
		///////////////////////////////////////////////////////////////////////
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : checkValidityOfCandidatureId -- END");
		return true;
	}

	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite d'un curriculum.
	 * 
	 * @param pCurriculum Le curriculum a valider.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou le curriculum est valide. 
	 *         <br/>FAUX : Cas ou le curriculum est invalide.
	 * @throws InvalidArgumentCurriculumException Lancee dans le cas : Le curriculum est invalide.
	 */
	private boolean checkValidityOfCurriculum(Curriculum pCurriculum) throws InvalidArgumentCurriculumException {
		
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : checkValidityOfCurriculum -- BEGIN");
		
		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->LE CURRICULUM FOURNI EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pCurriculum == null) {
			LOGGER.error("Le curriculum -- Valeur : null");
			LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : checkValidityOfCurriculum -- END");
			throw new InvalidArgumentCurriculumException("->Le curriculum -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS SUIVANT :
		//      ->LE CURRICULUM FOURNI EST NON NULL.
		///////////////////////////////////////////////////////////////////////
		LOGGER.info("CLASS : CurriculumMetierImpl -- METHOD : checkValidityOfCurriculum -- END");
		return true;
	}	
}
