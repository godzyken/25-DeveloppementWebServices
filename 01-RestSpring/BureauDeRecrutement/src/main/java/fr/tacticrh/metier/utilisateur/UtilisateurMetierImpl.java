/**
 * 
 */
package fr.tacticrh.metier.utilisateur;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tacticrh.dao.IPersonneDao;
import fr.tacticrh.dao.IUtilisateurDao;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.exception.utilisateur.RecordNotFoundUtilisateurException;
import fr.tacticrh.model.Personne;
import fr.tacticrh.model.Utilisateur;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>CLASSE QUI IMPLEMENTE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Utilisateur'.
 */
@Transactional
@Service
public class UtilisateurMetierImpl implements IUtilisateurMetier {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurMetierImpl.class);

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Personne'.
	 */
	@Autowired
	private IPersonneDao personneDao;  

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Utilisateur'.
	 */
	@Autowired
	private IUtilisateurDao utilisateurDao;  

	
	
	
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.utilisateur.IUtilisateurMetier#add(fr.tacticrh.model.Utilisateur)
	 */
	@Override
	public Utilisateur add(Utilisateur pUtilisateur) throws InvalidArgumentPersonneException
															, InvalidArgumentUtilisateurException
															, IllegalTransactionUtilisateurException {
		
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : add -- BEGIN");
		
		/////////////////////////////////////////////////////////////////////////
		// (00.)VERIFIER LA VALIDITE DES PARAMETRES D'ENTREE :
		//
		//      ->PARAMETRE N°1 : L'UTILISATEUR FOURNI (EN TANT QU'UTILISATEUR)
		/////////////////////////////////////////////////////////////////////////
		this.checkValidityOfUtilisateur(pUtilisateur);
		
		/////////////////////////////////////////////////////////////////////////
		// (01.)EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :
		//
		//      ->OBJET RECHERCHE : LA PERSONNE
		//      ->CRITERE DE RECHERCHE : LE MAIL DE LA PERSONNE ASSOCIEE A L'UTILISATEUR FOURNI
		/////////////////////////////////////////////////////////////////////////
		Personne personneProvided = (Personne)pUtilisateur;
		String mail = personneProvided.getMail();
		Personne personneFound = this.personneDao.findByMail(mail);
		
		/////////////////////////////////////////////////////////////////////////
		// (02.)EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :
		//
		//      ->OBJET RECHERCHE : L'UTILISATEUR
		//      ->CRITERE DE RECHERCHE : L'IDENTIFIANT DE L'UTILISATEUR FOURNI
		/////////////////////////////////////////////////////////////////////////
		String identifiant = pUtilisateur.getIdentifiant();
		Utilisateur utilisateurFound = this.utilisateurDao.findByIdentifiant(identifiant);

		/////////////////////////////////////////////////////////////////////////
		// (03.)TRAITER LE CAS CI-DESSOUS :
		//
		//      ->LA PERSONNE TROUVEE : NON-NULL (ELLE EXISTE DEJA EN BDD) 
		//      ->L'UTILISATEUR TROUVE : NON-NULL (IL EXISTE DEJA EN BDD)
		//      =>CONSEQUENCE : ON REFUSE DE LES INSERER EN BDD.
		/////////////////////////////////////////////////////////////////////////
		if((personneFound != null) && (utilisateurFound != null)) {
			LOGGER.error("Objets trouves (personne et utilisateur) -- Les 2 objets existent deja");
			LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : add -- END");
			throw new IllegalTransactionUtilisateurException("Objets trouves (personne et utilisateur) -- Les 2 objets existent deja");
		}
		/////////////////////////////////////////////////////////////////////////
		// (04.)TRAITER LE CAS CI-DESSOUS :
		//
		//      ->LA PERSONNE TROUVEE : NON-NULL (ELLE EXISTE DEJA EN BDD) 
		//      ->L'UTILISATEUR TROUVE : NULL (IL N'EXISTE PAS EN BDD)
		//      =>CONSEQUENCE : ON RENVOIE UNE ERREUR INTERNE DU PROGRAMME.
		/////////////////////////////////////////////////////////////////////////
		if((personneFound != null) && (utilisateurFound == null)) {
			LOGGER.error("Objets trouves (personne et utilisateur) -- L'un des 2 objets existe, et l'autre n'existe pas");
			LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : add -- END");
			throw new IllegalTransactionUtilisateurException("Objets trouves (personne et utilisateur) -- L'un des 2 objets existe, et l'autre n'existe pas");
		}
		/////////////////////////////////////////////////////////////////////////
		// (05.)TRAITER LE CAS CI-DESSOUS :
		//
		//      ->LA PERSONNE TROUVEE : NULL (ELLE N'EXISTE PAS EN BDD) 
		//      ->L'UTILISATEUR TROUVE : NON-NULL (IL EXISTE DEJA EN BDD)
		//      =>CONSEQUENCE : ON RENVOIE UNE ERREUR INTERNE DU PROGRAMME.
		/////////////////////////////////////////////////////////////////////////
		if((personneFound == null) && (utilisateurFound != null)) {
			LOGGER.error("Objets trouves (personne et utilisateur) -- L'un des 2 objets existe, et l'autre n'existe pas");
			LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : add -- END");
			throw new IllegalTransactionUtilisateurException("Objets trouves (personne et utilisateur) -- L'un des 2 objets existe, et l'autre n'existe pas");
		}
		/////////////////////////////////////////////////////////////////////////
		// (06.)TRAITER LE CAS CI-DESSOUS :
		//
		//      ->LA PERSONNE TROUVEE : NULL (ELLE N'EXISTE PAS EN BDD) 
		//      ->L'UTILISATEUR TROUVE : NULL (IL N'EXISTE PAS EN BDD)
		//      =>CONSEQUENCE : ON INSERE EN BDD L'UTILISATEUR FOURNI.
		/////////////////////////////////////////////////////////////////////////
		pUtilisateur.setDateInscription(new Date());
		Utilisateur utilisateurCreated = this.utilisateurDao.save(pUtilisateur);
		
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : add -- END");
		return utilisateurCreated;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.utilisateur.IUtilisateurMetier#find(java.lang.Long)
	 */
	@Override
	public Utilisateur find(Long pUtilisateurId) throws RecordNotFoundUtilisateurException {
		
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : find -- BEGIN");
		
		Optional<Utilisateur> optionalFound = this.utilisateurDao.findById(pUtilisateurId);
		
		if ((optionalFound == null) || (!optionalFound.isPresent())) { 
			LOGGER.error("L'identifiant de l'utilisateur -- Introuvable");
			LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : find -- END");
			throw new RecordNotFoundUtilisateurException("L'identifiant de l'utilisateur -- Introuvable"); 
		}
		Utilisateur utilisateurFound = optionalFound.get();
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : find -- END");
		return utilisateurFound;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.utilisateur.IUtilisateurMetier#findAll()
	 */
	@Override
	public List<Utilisateur> findAll() throws RecordNotFoundUtilisateurException {
		
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : findAll -- BEGIN");
		
		List<Utilisateur> utilisateursFound = this.utilisateurDao.findAll();
		
		if ((utilisateursFound == null) || (utilisateursFound.isEmpty())) {
			LOGGER.error("Les utilisateurs -- Introuvables");
			LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : findAll -- END");
			throw new RecordNotFoundUtilisateurException("Les utilisateurs -- Introuvables"); 
		}
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : findAll -- END");
		return utilisateursFound;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.utilisateur.IUtilisateurMetier#findByPersonneMail(java.lang.String)
	 */
	@Override
	public Utilisateur findByPersonneMail(String pPersonneMail) throws InvalidArgumentPersonneException
																		, RecordNotFoundUtilisateurException
																		, IllegalTransactionUtilisateurException {
		
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : findByPersonneMail -- BEGIN");

		Utilisateur utilisateurFound = this.utilisateurDao.findByPersonneMail(pPersonneMail);
		
		if (utilisateurFound == null) {
			LOGGER.error("Le mail de la personne associee a l'utilisateur -- Introuvable");
			LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : findByPersonneMail -- END");
			throw new RecordNotFoundUtilisateurException("Le mail de la personne associee a l'utilisateur -- Introuvable"); 
		}
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : findByPersonneMail -- END");
		return utilisateurFound;
	}

	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite d'un utilisateur.
	 * 
	 * @param pUtilisateur L'utilisateur a valider.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou l'utilisateur est valide. 
	 *         <br/>FAUX : Cas ou l'utilisateur est invalide.
	 * @throws InvalidArgumentUtilisateurException Lancee dans le cas : L'utilisateur est invalide.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne est invalide.
	 */
	private boolean checkValidityOfUtilisateur(Utilisateur pUtilisateur) throws InvalidArgumentUtilisateurException
																				, InvalidArgumentPersonneException {
		
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : checkValidityOfUtilisateur -- BEGIN");

		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->L'UTILISATEUR FOURNI EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pUtilisateur == null) {
			LOGGER.error("L'utilisateur -- Valeur : null");
			LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : checkValidityOfUtilisateur -- END");
			throw new InvalidArgumentUtilisateurException("L'utilisateur -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->DANS L'UTILISATEUR FOURNI, L'ATTRIBUT 'IDENTIFIANT' EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pUtilisateur.getIdentifiant() == null) {
			LOGGER.error("L'identifiant de l'utilisateur -- Valeur : null");
			LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : checkValidityOfUtilisateur -- END");
			throw new InvalidArgumentUtilisateurException("L'identifiant de l'utilisateur -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (03.)TRAITER LE CAS SUIVANT :
		//      ->DANS L'UTILISATEUR FOURNI, L'OBJET PARENT 'PERSONNE' EST NON VALIDE.
		///////////////////////////////////////////////////////////////////////
		boolean isValid = this.checkValidityOfPersonne(pUtilisateur);
		
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : checkValidityOfUtilisateur -- END");
		return isValid;
	}
	
	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite d'une personne.
	 * 
	 * @param pPersonne La personne a valider.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou la personne est valide. 
	 *         <br/>FAUX : Cas ou la personne est invalide.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne est invalide.
	 */
	private boolean checkValidityOfPersonne(Personne pPersonne) throws InvalidArgumentPersonneException {
		
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : checkValidityOfPersonne -- BEGIN");

		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->LA PERSONNE FOURNIE EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pPersonne == null) {
			LOGGER.error("La personne -- Valeur : null");
			LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : checkValidityOfPersonne -- END");
			throw new InvalidArgumentPersonneException("La personne -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->DANS LA PERSONNE  FOURNIE, L'ATTRIBUT 'MAIL' EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pPersonne.getMail() == null) {
			LOGGER.error("Le mail de la personne -- Valeur : null");
			LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : checkValidityOfPersonne -- END");
			throw new InvalidArgumentPersonneException("Le mail de la personne -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (03.)TRAITER LE CAS SUIVANT :
		//      ->DANS LA PERSONNE FOURNIE, L'ATTRIBUT 'MAIL' EST NON NULL.
		///////////////////////////////////////////////////////////////////////
		LOGGER.info("CLASS : UtilisateurMetierImpl -- METHOD : checkValidityOfPersonne -- END");
		return true;
	}
}
