/**
 * 
 */
package fr.tacticrh.metier.administrateur;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tacticrh.dao.IAdministrateurDao;
import fr.tacticrh.exception.administrateur.IllegalTransactionAdministrateurException;
import fr.tacticrh.exception.administrateur.InvalidArgumentAdministrateurException;
import fr.tacticrh.exception.administrateur.RecordNotFoundAdministrateurException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.metier.utilisateur.IUtilisateurMetier;
import fr.tacticrh.model.Administrateur;
import fr.tacticrh.model.Utilisateur;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>CLASSE QUI IMPLEMENTE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Administrateur'.
 */
@Transactional
@Service
public class AdministrateurMetierImpl implements IAdministrateurMetier {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministrateurMetierImpl.class);

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Manager'.
	 */
	@Autowired
	private IAdministrateurDao administrateurDao;  
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les traitements metier relatifs a l'entite 'Utilisateur'.
	 */
	@Autowired
	private IUtilisateurMetier utilisateurMetier;  
	
	
	
	
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.administrateur.IAdministrateurMetier#add(fr.tacticrh.model.Administrateur)
	 */
	@Override
	public Administrateur add(Administrateur pAdministrateur) throws InvalidArgumentAdministrateurException
																	, InvalidArgumentUtilisateurException
																	, InvalidArgumentPersonneException
																	, IllegalTransactionUtilisateurException {
		
		LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : add -- BEGIN");
		
		/////////////////////////////////////////////////////////////////////////
		// (00.)VERIFIER LA VALIDITE DES PARAMETRES D'ENTREE :
		//
		//      ->PARAMETRE N°1 : L'ADMINISTRATEUR FOURNI.
		/////////////////////////////////////////////////////////////////////////
		checkValidityOfAdministrateur(pAdministrateur);
		
		/////////////////////////////////////////////////////////////////////////
		// (01.)CONSTRUIRE UN OBJET 'ADMINISTRATEUR' DE LA MANIERE SUIVANTE :
		//
		//      ->ATTRIBUT 'IDENTIFIANT' : ALIMENTE AVEC L'ATTRIBUT 'MAIL' DE L'ADMINISTRATEUR FOURNI.
		//      ->ATTRIBUT 'ROLE'        : ALIMENTE AVEC LE ROLE 'ADMINISTRATEUR'.
		/////////////////////////////////////////////////////////////////////////
		Administrateur administrateurProvided = new Administrateur(pAdministrateur);
		
		/////////////////////////////////////////////////////////////////////////
		// (02.)EFFECTUER LE TRAITEMENT METIER CI-DESSOUS :
		//
		//      ->TRAITEMENT METIER : INSCRIRE UN ADMINISTRATEUR
		//      ->ADMINISTRATEUR UTILISE : L'ADMINISTRATEUR FOURNI
		/////////////////////////////////////////////////////////////////////////
		Utilisateur utilisateurCreated = utilisateurMetier.add(administrateurProvided);
		Administrateur administrateurCreated = (Administrateur)utilisateurCreated;
		
		LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : add -- END");
		return administrateurCreated;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.administrateur.IAdministrateurMetier#find(java.lang.Long)
	 */
	@Override
	public Administrateur find(Long pAdministrateurId) throws RecordNotFoundAdministrateurException {
		
		LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : find -- BEGIN");
		
		Optional<Administrateur> optionalFound = this.administrateurDao.findById(pAdministrateurId);
		
		if ((optionalFound == null) || (!optionalFound.isPresent())) { 
			LOGGER.error("L'identifiant de l'administrateur -- Introuvable");
			LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : find -- END");
			throw new RecordNotFoundAdministrateurException("L'identifiant de l'administrateur -- Introuvable"); 
		}
		Administrateur administrateurFound = optionalFound.get();
		LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : find -- END");
		return administrateurFound;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.administrateur.IAdministrateurMetier#findAll()
	 */
	@Override
	public List<Administrateur> findAll() throws RecordNotFoundAdministrateurException {
		
		LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : findAll -- BEGIN");
		
		List<Administrateur> administrateursFound = this.administrateurDao.findAll();
		
		if ((administrateursFound == null) || (administrateursFound.isEmpty())) {
			LOGGER.error("Les administrateurs -- Introuvables");
			LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : findAll -- END");
			throw new RecordNotFoundAdministrateurException("Les administrateurs -- Introuvables"); 
		}
		LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : findAll -- END");
		return administrateursFound;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.administrateur.IAdministrateurMetier#findByPersonneMail(java.lang.String)
	 */
	@Override
	public Administrateur findByPersonneMail(String pPersonneMail) throws InvalidArgumentPersonneException
																			, RecordNotFoundAdministrateurException
																			, IllegalTransactionAdministrateurException {
		
		LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : findByPersonneMail -- BEGIN");

		Administrateur administrateurFound = this.administrateurDao.findByPersonneMail(pPersonneMail);
		
		if (administrateurFound == null) {
			LOGGER.error("Le mail de l'administrateur -- Introuvable");
			LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : findByPersonneMail -- END");
			throw new RecordNotFoundAdministrateurException("Le mail de l'administrateur -- Introuvable"); 
		}
		LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : findByPersonneMail -- END");
		return administrateurFound;
	}
	
	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite d'un administrateur.
	 * 
	 * @param pAdministrateur L'administrateur a valider.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou l'administrateur est valide. 
	 *         <br/>FAUX : Cas ou l'administrateur est invalide.
	 * @throws InvalidArgumentAdministrateurException Lancee dans le cas : L'administrateur est invalide.
	 */
	private boolean checkValidityOfAdministrateur(Administrateur pAdministrateur) throws InvalidArgumentAdministrateurException {
		
		LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : checkValidityOfAdministrateur -- BEGIN");

		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->L'ADMINISTRATEUR FOURNI EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pAdministrateur == null) {
			LOGGER.error("L'administrateur -- Valeur : null");
			LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : checkValidityOfManager -- END");
			throw new InvalidArgumentAdministrateurException("L'administrateur -- Valeur : null");
		}
		LOGGER.info("CLASS : AdministrateurMetierImpl -- METHOD : checkValidityOfAdministrateur -- END");
		return true;
	}
}
