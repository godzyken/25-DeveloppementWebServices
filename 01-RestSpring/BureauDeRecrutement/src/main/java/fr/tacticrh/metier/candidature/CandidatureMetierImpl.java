/**
 * 
 */
package fr.tacticrh.metier.candidature;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tacticrh.dao.ICandidatDao;
import fr.tacticrh.dao.ICandidatureDao;
import fr.tacticrh.dao.ICurriculumDao;
import fr.tacticrh.dao.IMotivationDao;
import fr.tacticrh.exception.candidat.InvalidArgumentCandidatException;
import fr.tacticrh.exception.candidature.IllegalTransactionCandidatureException;
import fr.tacticrh.exception.candidature.InvalidArgumentCandidatureException;
import fr.tacticrh.exception.candidature.RecordNotFoundCandidatureException;
import fr.tacticrh.exception.curriculum.InvalidArgumentCurriculumException;
import fr.tacticrh.exception.motivation.InvalidArgumentMotivationException;
import fr.tacticrh.model.Candidat;
import fr.tacticrh.model.Candidature;
import fr.tacticrh.model.Curriculum;
import fr.tacticrh.model.Motivation;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>CLASSE QUI IMPLEMENTE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Candidature'.
 */
@Transactional
@Service
public class CandidatureMetierImpl implements ICandidatureMetier {
	
	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CandidatureMetierImpl.class);

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Candidat'.
	 */
	@Autowired
	private ICandidatDao candidatDao;  

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Candidature'.
	 */
	@Autowired
	private ICandidatureDao candidatureDao;  
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Curriculum'.
	 */
	@Autowired
	private ICurriculumDao curriculumDao;  
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Motivation'.
	 */
	@Autowired
	private IMotivationDao motivationDao;  

	

	
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#add(java.lang.Long, fr.tacticrh.model.Candidature)
	 */
	@Override
	public Candidature add (Long pCandidatId, Candidature pCandidature) throws InvalidArgumentCandidatException
																				, InvalidArgumentCandidatureException
																				, IllegalTransactionCandidatureException {
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : add -- BEGIN");
		
		/////////////////////////////////////////////////////////////////////////
		// (00.)VERIFIER LA VALIDITE DES PARAMETRES D'ENTREE
		//
		//      ->PARAMETRE N°1 : L'IDENTIFIANT DU CANDIDAT
		//      ->PARAMETRE N°2 : LA CANDIDATURE
		/////////////////////////////////////////////////////////////////////////
		this.checkValidityOfCandidatId  (pCandidatId);
		this.checkValidityOfCandidature (pCandidature);
		
		/////////////////////////////////////////////////////////////////////////
		// (01.)EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :
		//
		//      ->OBJET RECHERCHE : LE CANDIDAT
		//      ->CRITERE DE RECHERCHE : L'IDENTIFIANT DU CANDIDAT FOURNI
		/////////////////////////////////////////////////////////////////////////
		Optional<Candidat> optionalFound = this.candidatDao.findById(pCandidatId);
		
		/////////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS CI-DESSOUS :
		//
		//      ->LE CANDIDAT TROUVE CI-DESSUS EST : 'NULL' (IL N'EXISTE PAS EN BDD).
		//      =>CONSEQUENCE : ON REFUSE D'INSERER LA CANDIDATURE EN BDD.
		/////////////////////////////////////////////////////////////////////////
		if ((optionalFound == null) || (!optionalFound.isPresent())) {
			LOGGER.error("L'identifiant du candidat -- Introuvable");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : add -- END");
			throw new IllegalTransactionCandidatureException("L'identifiant du candidat -- Introuvable");
		}
		Candidat candidatFound = optionalFound.get();
		/////////////////////////////////////////////////////////////////////////
		// (03.)DANS L'OBJET 'CANDIDATURE', ALIMENTER LES ATTRIBUTS CI-DESSOUS :
		//
		//      ->L'ATTRIBUT 'CANDIDAT' (AVEC LE CANDIDAT RESULTANT DE LA RECHERCHE PRECEDENTE).
		/////////////////////////////////////////////////////////////////////////
		pCandidature.setCandidat  (candidatFound);
		pCandidature.setDateDepot (new Date()   );
		
		/////////////////////////////////////////////////////////////////////////
		// (04.)EFFECTUER LES OPERATIONS CI-DESSOUS :
		//
		//      ->INSERER LA CANDIDATURE EN BDD.
		/////////////////////////////////////////////////////////////////////////
		Candidature candidatureCreated = this.candidatureDao.save(pCandidature);
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : add -- END");
		return candidatureCreated;
	}
	
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#add(java.lang.Long, fr.tacticrh.model.Curriculum)
	 */
	@Override
	public Candidature addCurriculum (Long pCandidatureId, Curriculum pCurriculum) throws InvalidArgumentCandidatureException
																						, InvalidArgumentCurriculumException
																						, IllegalTransactionCandidatureException {
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : addCurriculum -- BEGIN");
		
		/////////////////////////////////////////////////////////////////////////
		// (00.)VERIFIER LA VALIDITE DES PARAMETRES D'ENTREE
		//
		//      ->PARAMETRE N°1 : L'IDENTIFIANT DE LA CANDIDATURE
		//      ->PARAMETRE N°2 : LE CURRICULUM
		/////////////////////////////////////////////////////////////////////////
		this.checkValidityOfCandidatureId (pCandidatureId);
		this.checkValidityOfCurriculum (pCurriculum);
		
		/////////////////////////////////////////////////////////////////////////
		// (01.)EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :
		//
		//      ->OBJET RECHERCHE : LA CANDIDATURE
		//      ->CRITERE DE RECHERCHE : L'IDENTIFIANT DE LA CANDIDATURE FOURNIE
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
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : addCurriculum -- END");
			throw new IllegalTransactionCandidatureException("L'identifiant de la candidature -- Introuvable");
		}
		Candidature candidatureFound = optionalFound.get();
		/////////////////////////////////////////////////////////////////////////
		// (03.)INSERER LES OBJETS CI-DESSOUS EN BDD :
		//
		//      ->LE CURRICULUM.
		/////////////////////////////////////////////////////////////////////////
		Curriculum curriculumCreated = curriculumDao.save(pCurriculum);
		
		/////////////////////////////////////////////////////////////////////////
		// (04.)DANS L'OBJET TROUVE 'CANDIDATURE', ALIMENTER LES ATTRIBUTS CI-DESSOUS :
		//
		//      ->L'ATTRIBUT 'CURRICULUM' (AVEC LE CURRICULUM RESULTANT DE L'INSERTION PRECEDENTE).
		/////////////////////////////////////////////////////////////////////////
		candidatureFound.setCurriculum (curriculumCreated);
		
		/////////////////////////////////////////////////////////////////////////
		// (05.)EFFECTUER LES OPERATIONS CI-DESSOUS :
		//
		//      ->INSERER LA CANDIDATURE EN BDD.
		/////////////////////////////////////////////////////////////////////////
		Candidature candidatureUpdated = this.candidatureDao.save(candidatureFound);
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : addCurriculum -- END");
		return candidatureUpdated;	
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#add(java.lang.Long, fr.tacticrh.model.Motivation)
	 */
	@Override
	public Candidature addMotivation (Long pCandidatureId, Motivation pMotivation) throws InvalidArgumentCandidatureException
																						, InvalidArgumentMotivationException
																						, IllegalTransactionCandidatureException {
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : addMotivation -- BEGIN");
		
		/////////////////////////////////////////////////////////////////////////
		// (00.)VERIFIER LA VALIDITE DES PARAMETRES D'ENTREE
		//
		//      ->PARAMETRE N°1 : L'IDENTIFIANT DE LA CANDIDATURE
		//      ->PARAMETRE N°2 : LA MOTIVATION
		/////////////////////////////////////////////////////////////////////////
		this.checkValidityOfCandidatureId (pCandidatureId);
		this.checkValidityOfMotivation (pMotivation);
		
		/////////////////////////////////////////////////////////////////////////
		// (01.)EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :
		//
		//      ->OBJET RECHERCHE : LA CANDIDATURE
		//      ->CRITERE DE RECHERCHE : L'IDENTIFIANT DE LA CANDIDATURE FOURNIE
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
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : addMotivation -- END");
			throw new IllegalTransactionCandidatureException("L'identifiant de la candidature -- Introuvable");
		}
		Candidature candidatureFound = optionalFound.get();
		/////////////////////////////////////////////////////////////////////////
		// (03.)INSERER LES OBJETS CI-DESSOUS EN BDD :
		//
		//      ->LA MOTIVATION.
		/////////////////////////////////////////////////////////////////////////
		Motivation motivationCreated = motivationDao.save(pMotivation);
		
		/////////////////////////////////////////////////////////////////////////
		// (04.)DANS L'OBJET TROUVE 'CANDIDATURE', ALIMENTER LES ATTRIBUTS CI-DESSOUS :
		//
		//      ->L'ATTRIBUT 'MOTIVATION' (AVEC LA MOTIVATION RESULTANT DE L'INSERTION PRECEDENTE).
		/////////////////////////////////////////////////////////////////////////
		candidatureFound.setMotivation (motivationCreated);
		
		/////////////////////////////////////////////////////////////////////////
		// (05.)EFFECTUER LES OPERATIONS CI-DESSOUS :
		//
		//      ->INSERER LA CANDIDATURE EN BDD.
		/////////////////////////////////////////////////////////////////////////
		Candidature candidatureUpdated = this.candidatureDao.save(candidatureFound);
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : addMotivation -- END");
		return candidatureUpdated;	
	}	
	
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#find(java.lang.Long)
	 */
	@Override
	public Candidature find (Long pCandidatureId) throws RecordNotFoundCandidatureException {
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : find -- BEGIN");
		
		Optional<Candidature> optionalFound = this.candidatureDao.findById(pCandidatureId);
		
		if ((optionalFound == null) || (!optionalFound.isPresent())) { 
			LOGGER.error("L'identifiant de la candidature -- Introuvable");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : find -- END");
			throw new RecordNotFoundCandidatureException("L'identifiant de la candidature -- Introuvable"); 
		}
		Candidature candidatureFound = optionalFound.get();
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : find -- END");
		return candidatureFound;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#findAll()
	 */
	@Override
	public List<Candidature> findAll () throws RecordNotFoundCandidatureException {
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : findAll -- BEGIN");
		
		List<Candidature> candidaturesFound = this.candidatureDao.findAll();
		
		if ((candidaturesFound == null) || (candidaturesFound.isEmpty())) {
			LOGGER.error("Les candidatures -- Introuvables");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : findAll -- END");
			throw new RecordNotFoundCandidatureException("Les candidatures -- Introuvables"); 
		}
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : findAll -- END");
		return candidaturesFound;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.candidature.ICandidatureMetier#findByPersonneMail(java.lang.String)
	 */
	@Override
	public List<Candidature> findByPersonneMail (String pPersonneMail) throws RecordNotFoundCandidatureException {
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : findByPersonneMail -- BEGIN");
		
		List<Candidature> candidaturesFound = this.candidatureDao.findByPersonneMail(pPersonneMail);
		
		if ((candidaturesFound == null) || (candidaturesFound.isEmpty())) {
			LOGGER.error("Les candidatures associées au mail -- Introuvables");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : findByPersonneMail -- END");
			throw new RecordNotFoundCandidatureException("Les candidatures associées au mail -- Introuvables"); 
		}
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : findByPersonneMail -- END");
		return candidaturesFound;
	}
	
	
	

	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite de l'identifiant du candidat.
	 * 
	 * @param pCandidatId L'identifiant du candidat.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou l'identifiant du candidat est valide. 
	 *         <br/>FAUX : Cas ou l'identifiant du candidat est invalide.
	 * @throws InvalidArgumentCandidatException Lancee dans le cas : L'identifiant du candidat est invalide.
	 */
	private boolean checkValidityOfCandidatId (Long pCandidatId) throws InvalidArgumentCandidatException {
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCandidatId -- BEGIN");
		
		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->L'IDENTIFIANT DU CANDIDAT FOURNI EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pCandidatId == null) {
			LOGGER.error("L'identifiant du candidat -- Valeur : null");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCandidatId -- END");
			throw new InvalidArgumentCandidatException("L'identifiant du candidat -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS SUIVANT :
		//      ->L'IDENTIFIANT DU CANDIDAT FOURNI EST NON NULL.
		///////////////////////////////////////////////////////////////////////
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCandidatId -- END");
		return true;
	}	

	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite de l'identifiant de la candidature.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou l'identifiant de la candidature est valide. 
	 *         <br/>FAUX : Cas ou l'identifiant de la candidature est invalide.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : L'identifiant de la candidature est invalide.
	 */
	private boolean checkValidityOfCandidatureId (Long pCandidatureId) throws InvalidArgumentCandidatureException {
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCandidatureId -- BEGIN");
		
		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->L'IDENTIFIANT DE LA CANDIDATURE FOURNI EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pCandidatureId == null) {
			LOGGER.error("L'identifiant de la candidature -- Valeur : null");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCandidatureId -- END");
			throw new InvalidArgumentCandidatureException("L'identifiant de la candidature -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS SUIVANT :
		//      ->L'IDENTIFIANT DE LA CANDIDATURE FOURNI EST NON NULL.
		///////////////////////////////////////////////////////////////////////
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCandidatureId -- END");
		return true;
	}	
	
	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite d'une candidature.
	 * 
	 * @param pCandidature La candidature a valider.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou la candidature est valide. 
	 *         <br/>FAUX : Cas ou la candidature est invalide.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : La candidature est invalide.
	 */
	private boolean checkValidityOfCandidature (Candidature pCandidature) throws InvalidArgumentCandidatureException {
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCandidature -- BEGIN");
		
		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->LA CANDIDATURE FOURNIE EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pCandidature == null) {
			LOGGER.error("La candidature -- Valeur : null");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCandidature -- END");
			throw new InvalidArgumentCandidatureException("->La candidature -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS SUIVANT :
		//      ->LA CANDIDATURE FOURNIE EST NON NULL.
		///////////////////////////////////////////////////////////////////////
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCandidature -- END");
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
	private boolean checkValidityOfCurriculum (Curriculum pCurriculum) throws InvalidArgumentCurriculumException {
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCurriculum -- BEGIN");
		
		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->LE CURRICULUM FOURNI EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pCurriculum == null) {
			LOGGER.error("Le curriculum -- Valeur : null");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCurriculum -- END");
			throw new InvalidArgumentCurriculumException("Le curriculum -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->DANS LE CURRICULUM FOURNI, L'ATTRIBUT 'FICHIER' EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pCurriculum.getFichier() == null) {
			LOGGER.error("Le fichier du curriculum -- Valeur : null");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCurriculum -- END");
			throw new InvalidArgumentCurriculumException("Le fichier du curriculum -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (03.)TRAITER LE CAS SUIVANT :
		//      ->DANS LE CURRICULUM FOURNI, L'ATTRIBUT 'FICHIER' EST NON NULL.
		///////////////////////////////////////////////////////////////////////
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfCurriculum -- END");
		return true;
	}	
	
	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite d'une motivation.
	 * 
	 * @param pMotivation La motivation a valider.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou la motivation est valide. 
	 *         <br/>FAUX : Cas ou la motivation est invalide.
	 * @throws InvalidArgumentMotivationException Lancee dans le cas : La motivation est invalide.
	 */
	private boolean checkValidityOfMotivation (Motivation pMotivation) throws InvalidArgumentMotivationException {
		
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfMotivation -- BEGIN");
		
		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->LA MOTIVATION FOURNIE EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pMotivation == null) {
			LOGGER.error("La motivation -- Valeur : null");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfMotivation -- END");
			throw new InvalidArgumentMotivationException("La motivation -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->DANS LA MOTIVATION FOURNIE, L'ATTRIBUT 'FICHIER' EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pMotivation.getFichier() == null) {
			LOGGER.error("Le fichier de la motivation -- Valeur : null");
			LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfMotivation -- END");
			throw new InvalidArgumentMotivationException("Le fichier de la motivation -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (03.)TRAITER LE CAS SUIVANT :
		//      ->DANS LA MOTIVATION FOURNIE, L'ATTRIBUT 'FICHIER' EST NON NULL.
		///////////////////////////////////////////////////////////////////////
		LOGGER.info("CLASS : CandidatureMetierImpl -- METHOD : checkValidityOfMotivation -- END");
		return true;
	}
}
