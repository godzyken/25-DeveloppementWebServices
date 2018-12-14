/**
 * 
 */
package fr.tacticrh.metier.manager;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tacticrh.dao.IManagerDao;
import fr.tacticrh.exception.manager.IllegalTransactionManagerException;
import fr.tacticrh.exception.manager.InvalidArgumentManagerException;
import fr.tacticrh.exception.manager.RecordNotFoundManagerException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.metier.utilisateur.IUtilisateurMetier;
import fr.tacticrh.model.Manager;
import fr.tacticrh.model.Utilisateur;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>CLASSE QUI IMPLEMENTE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Manager'.
 */
@Transactional
@Service
public class ManagerMetierImpl implements IManagerMetier {

	
	

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerMetierImpl.class);

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Manager'.
	 */
	@Autowired
	private IManagerDao managerDao;  
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les traitements metier relatifs a l'entite 'Utilisateur'.
	 */
	@Autowired
	private IUtilisateurMetier utilisateurMetier;  
	
	
	
	
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.manager.IManagerMetier#add(fr.tacticrh.model.Manager)
	 */
	@Override
	public Manager add(Manager pManager) throws InvalidArgumentManagerException
												, InvalidArgumentUtilisateurException
												, InvalidArgumentPersonneException
												, IllegalTransactionUtilisateurException {
		
		LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : add -- BEGIN");
		
		/////////////////////////////////////////////////////////////////////////
		// (00.)VERIFIER LA VALIDITE DES PARAMETRES D'ENTREE :
		//
		//      ->PARAMETRE N°1 : LE MANAGER FOURNI.
		/////////////////////////////////////////////////////////////////////////
		checkValidityOfManager(pManager);
		
		/////////////////////////////////////////////////////////////////////////
		// (01.)CONSTRUIRE UN OBJET 'MANAGER' DE LA MANIERE SUIVANTE :
		//
		//      ->ATTRIBUT 'IDENTIFIANT' : ALIMENTE AVEC L'ATTRIBUT 'MAIL' DU MANAGER FOURNI.
		//      ->ATTRIBUT 'ROLE'        : ALIMENTE AVEC LE ROLE 'MANAGER'.
		/////////////////////////////////////////////////////////////////////////
		Manager managerProvided = new Manager(pManager);
		
		/////////////////////////////////////////////////////////////////////////
		// (02.)EFFECTUER LE TRAITEMENT METIER CI-DESSOUS :
		//
		//      ->TRAITEMENT METIER : INSCRIRE UN MANAGER
		//      ->MANAGER UTILISE : LE MANAGER FOURNI
		/////////////////////////////////////////////////////////////////////////
		Utilisateur utilisateurCreated = utilisateurMetier.add(managerProvided);
		Manager managerCreated = (Manager)utilisateurCreated;
		
		LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : add -- END");
		return managerCreated;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.manager.IManagerMetier#find(java.lang.Long)
	 */
	@Override
	public Manager find(Long pManagerId) throws RecordNotFoundManagerException {
		
		LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : find -- BEGIN");
		
		Optional<Manager> optionalFound = this.managerDao.findById(pManagerId);
		
		if ((optionalFound == null) || (!optionalFound.isPresent())) { 
			LOGGER.error("L'identifiant du manager -- Introuvable");
			LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : find -- END");
			throw new RecordNotFoundManagerException("L'identifiant du manager -- Introuvable"); 
		}
		Manager managerFound = optionalFound.get();
		LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : find -- END");
		return managerFound;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.manager.IManagerMetier#findAll()
	 */
	@Override
	public List<Manager> findAll() throws RecordNotFoundManagerException {
		
		LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : findAll -- BEGIN");
		
		List<Manager> managersFound = this.managerDao.findAll();
		
		if ((managersFound == null) || (managersFound.isEmpty())) {
			LOGGER.error("Les managers -- Introuvables");
			LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : findAll -- END");
			throw new RecordNotFoundManagerException("Les managers -- Introuvables"); 
		}
		LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : findAll -- END");
		return managersFound;
	}

	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.manager.IManagerMetier#findByPersonneMail(java.lang.String)
	 */
	@Override
	public Manager findByPersonneMail(String pPersonneMail) throws InvalidArgumentPersonneException
																, RecordNotFoundManagerException
																, IllegalTransactionManagerException {
		LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : findByPersonneMail -- BEGIN");

		Manager managerFound = this.managerDao.findByPersonneMail(pPersonneMail);
		
		if (managerFound == null) {
			LOGGER.error("Le mail du manager -- Introuvable");
			LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : findByPersonneMail -- END");
			throw new RecordNotFoundManagerException("Le mail du manager -- Introuvable"); 
		}
		LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : findByPersonneMail -- END");
		return managerFound;
	}
	
	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LA VERIFICATION SUIVANTE :</b>
	 * <br/>Verifier la validite d'un manager.
	 * 
	 * @param pManager Le manager a valider.
	 * @return boolean 
	 *         <br/>VRAI : Cas ou le manager est valide. 
	 *         <br/>FAUX : Cas ou le manager est invalide.
	 * @throws InvalidArgumentManagerException Lancee dans le cas : Le manager est invalide.
	 */
	private boolean checkValidityOfManager(Manager pManager) throws InvalidArgumentManagerException {
		
		LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : checkValidityOfManager -- BEGIN");

		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->LE MANAGER FOURNI EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pManager == null) {
			LOGGER.error("Le manager -- Valeur : null");
			LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : checkValidityOfManager -- END");
			throw new InvalidArgumentManagerException("Le manager -- Valeur : null");
		}
		LOGGER.info("CLASS : ManagerMetierImpl -- METHOD : checkValidityOfManager -- END");
		return true;
	}
}
