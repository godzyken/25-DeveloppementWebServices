/**
 * 
 */
package fr.tacticrh.metier.candidat;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tacticrh.dao.ICandidatDao;
import fr.tacticrh.exception.candidat.IllegalTransactionCandidatException;
import fr.tacticrh.exception.candidat.InvalidArgumentCandidatException;
import fr.tacticrh.exception.candidat.RecordNotFoundCandidatException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.metier.utilisateur.IUtilisateurMetier;
import fr.tacticrh.model.Candidat;
import fr.tacticrh.model.Utilisateur;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>CLASSE QUI IMPLEMENTE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Candidat'.
 */
@Transactional
@Service
public class CandidatMetierImpl implements ICandidatMetier {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CandidatMetierImpl.class);

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Candidat'.
	 */
	@Autowired
	private ICandidatDao candidatDao;  
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les traitements metier relatifs a l'entite 'Utilisateur'.
	 */
	@Autowired
	private IUtilisateurMetier utilisateurMetier;  

	
	
	
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.candidat.ICandidatMetier#add(fr.tacticrh.model.Candidat)
	 */
	@Override
	public Candidat add(Candidat pCandidat) throws InvalidArgumentCandidatException
													, InvalidArgumentUtilisateurException
													, InvalidArgumentPersonneException
													, IllegalTransactionUtilisateurException {
		
		LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : add -- BEGIN");
		
		/////////////////////////////////////////////////////////////////////////
		// (00.)VERIFIER LA VALIDITE DES PARAMETRES D'ENTREE :
		//
		//      ->PARAMETRE N°1 : LE CANDIDAT FOURNI.
		/////////////////////////////////////////////////////////////////////////
		checkValidityOfCandidat(pCandidat);
		
		/////////////////////////////////////////////////////////////////////////
		// (01.)CONSTRUIRE UN OBJET 'CANDIDAT' DE LA MANIERE SUIVANTE :
		//
		//      ->ATTRIBUT 'IDENTIFIANT' : ALIMENTE AVEC L'ATTRIBUT 'MAIL' DU CANDIDAT FOURNI.
		//      ->ATTRIBUT 'ROLE'        : ALIMENTE AVEC LE ROLE 'CANDIDAT'.
		/////////////////////////////////////////////////////////////////////////
		Candidat candidatProvided = new Candidat(pCandidat);

		/////////////////////////////////////////////////////////////////////////
		// (02.)EFFECTUER LE TRAITEMENT METIER CI-DESSOUS :
		//
		//      ->TRAITEMENT METIER : INSCRIRE UN CANDIDAT
		//      ->CANDIDAT UTILISE : LE CANDIDAT FOURNI
		/////////////////////////////////////////////////////////////////////////
		Utilisateur utilisateurCreated = utilisateurMetier.add(candidatProvided);
		Candidat candidatCreated = (Candidat)utilisateurCreated;
		
		LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : add -- END");
		return candidatCreated;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.candidat.ICandidatMetier#find(java.lang.Long)
	 */
	@Override
	public Candidat find(Long pCandidatId) throws RecordNotFoundCandidatException {
		
		LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : find -- BEGIN");
		
		Optional<Candidat> optionalFound = this.candidatDao.findById(pCandidatId);
		
		if ((optionalFound == null) || (!optionalFound.isPresent())) { 
			LOGGER.error("L'identifiant du candidat -- Introuvable");
			LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : find -- END");
			throw new RecordNotFoundCandidatException("L'identifiant du candidat -- Introuvable"); 
		}
		Candidat candidatFound = optionalFound.get();
		LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : find -- END");
		return candidatFound;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.candidat.ICandidatMetier#findAll()
	 */
	@Override
	public List<Candidat> findAll() throws RecordNotFoundCandidatException {

		LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : findAll -- BEGIN");
		
		List<Candidat> candidatsFound = this.candidatDao.findAll();
		
		if ((candidatsFound == null) || (candidatsFound.isEmpty())) {
			LOGGER.error("Les candidats -- Introuvables");
			LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : findAll -- END");
			throw new RecordNotFoundCandidatException("Les candidats -- Introuvables"); 
		}
		LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : findAll -- END");
		return candidatsFound;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.candidat.ICandidatMetier#findByMail(java.lang.String)
	 */
	@Override
	public Candidat findByPersonneMail(String pPersonneMail) throws InvalidArgumentPersonneException
																	, RecordNotFoundCandidatException
																	, IllegalTransactionCandidatException {
		
		LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : findByPersonneMail -- BEGIN");

		Candidat candidatFound = this.candidatDao.findByPersonneMail(pPersonneMail);
		
		if (candidatFound == null) {
			LOGGER.error("Le mail du candidat -- Introuvable");
			LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : findByPersonneMail -- END");
			throw new RecordNotFoundCandidatException("Le mail du candidat -- Introuvable"); 
		}
		LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : findByPersonneMail -- END");
		return candidatFound;
	}
	
	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite d'un candidat.
	 * 
	 * @param pCandidat Le candidat a valider.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou le candidat est valide. 
	 *         <br/>FAUX : Cas ou le candidat est invalide.
	 * @throws InvalidArgumentCandidatException Lancee dans le cas : Le candidat est invalide.
	 */
	private boolean checkValidityOfCandidat(Candidat pCandidat) throws InvalidArgumentCandidatException {
		
		LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : checkValidityOfCandidat -- BEGIN");

		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->LE CANDIDAT FOURNI EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pCandidat == null) {
			LOGGER.error("Le candidat -- Valeur : null");
			LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : checkValidityOfCandidat -- END");
			throw new InvalidArgumentCandidatException("Le candidat -- Valeur : null");
		}
		LOGGER.info("CLASS : CandidatMetierImpl -- METHOD : checkValidityOfCandidat -- END");
		return true;
	}
}
