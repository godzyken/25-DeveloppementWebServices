/**
 * 
 */
package fr.tacticrh.metier.personne;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tacticrh.dao.IPersonneDao;
import fr.tacticrh.exception.personne.IllegalTransactionPersonneException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.personne.RecordNotFoundPersonneException;
import fr.tacticrh.model.Personne;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>CLASSE QUI IMPLEMENTE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Candidature'.
 */
@Transactional
@Service
public class PersonneMetierImpl implements IPersonneMetier {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonneMetierImpl.class);

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites de persistance relatives a l'entite 'Personne'.
	 */
	@Autowired
	private IPersonneDao personneDao;  




	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.personne.IPersonneMetier#update(fr.tacticrh.model.Personne)
	 */
	@Override
	public Personne update(Personne pPersonne) throws InvalidArgumentPersonneException, IllegalTransactionPersonneException {

		LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : update -- BEGIN");
		
		/////////////////////////////////////////////////////////////////////////
		// (00.)VERIFIER LA VALIDITE DES PARAMETRES D'ENTREE :
		//
		//      ->PARAMETRE N°1 : LA PERSONNE
		/////////////////////////////////////////////////////////////////////////
		this.checkValidityOfPersonne(pPersonne);
		
		/////////////////////////////////////////////////////////////////////////
		// (01.)EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :
		//
		//      ->OBJET RECHERCHE : LA PERSONNE
		//      ->CRITERE DE RECHERCHE : LE MAIL DE LA PERSONNE FOURNIE
		/////////////////////////////////////////////////////////////////////////
		String pMail = pPersonne.getMail();
		Personne personneFound = this.personneDao.findByMail(pMail);
		
		/////////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS CI-DESSOUS :
		//
		//      ->LA PERSONNE TROUVEE CI-DESSUS EST : 'NULL' (ELLE N'EXISTE PAS EN BDD).
		//      =>CONSEQUENCE : ON REFUSE DE LA MODIFIER EN BDD.
		/////////////////////////////////////////////////////////////////////////
		if (personneFound == null) {
			LOGGER.error("La personne -- Introuvable");
			LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : update -- END");
			throw new IllegalTransactionPersonneException("La personne -- Introuvable");
		}
		/////////////////////////////////////////////////////////////////////////
		// (03.)TRAITER LE CAS CI-DESSOUS :
		//
		//      ->LA PERSONNE TROUVEE CI-DESSUS EST : DIFFERENTE DE 'NULL' (ELLE EXISTE DEJA EN BDD).
		//      =>CONSEQUENCE : ON MODIFIE L'OBJET EN BDD (SAUF LES ATTRIBUTS 'ID' ET 'MAIL').
		/////////////////////////////////////////////////////////////////////////
		personneFound.setCivilite  (pPersonne.getCivilite  ());
		personneFound.setNom       (pPersonne.getNom       ());
		personneFound.setPrenom    (pPersonne.getPrenom    ());
		personneFound.setAge       (pPersonne.getAge       ());
		personneFound.setTelephone (pPersonne.getTelephone ());
		Personne personneCreated = this.personneDao.save(personneFound);
		
		LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : update -- END");
		return personneCreated;
	}
	
	/* (non-Javadoc)
	 * @see fr.tacticrh.metier.personne.IPersonneMetier#find(java.lang.Long)
	 */
	@Override
	public Personne find(Long pPersonneId) throws RecordNotFoundPersonneException {
		
		LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : find -- BEGIN");
		
		Optional<Personne> optionalFound = this.personneDao.findById(pPersonneId);
		
		if ((optionalFound == null) || (!optionalFound.isPresent())) { 
			LOGGER.error("L'identifiant de la personne -- Introuvable");
			LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : find -- END");
			throw new RecordNotFoundPersonneException("L'identifiant de la personne -- Introuvable"); 
		}
		Personne personneFound = optionalFound.get();
		LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : find -- END");
		return personneFound;
	}

	@Override
	public List<Personne> findAll() throws RecordNotFoundPersonneException {
		
		LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : findAll -- BEGIN");
		
		List<Personne> personnesFound = this.personneDao.findAll();
		
		if ((personnesFound == null) || (personnesFound.isEmpty())) {
			LOGGER.error("Les personnes -- Introuvables");
			LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : findAll -- END");
			throw new RecordNotFoundPersonneException("Les personnes -- Introuvables"); 
		}
		LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : findAll -- END");
		return personnesFound;
	}

	@Override
	public Personne findByMail(String pMail) throws InvalidArgumentPersonneException, IllegalTransactionPersonneException, RecordNotFoundPersonneException {
		
		LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : findByMail -- BEGIN");

		Personne personneFound = this.personneDao.findByMail(pMail);
		
		if (personneFound == null) {
			LOGGER.error("Le mail de la personne -- Introuvable");
			LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : findByMail -- END");
			throw new RecordNotFoundPersonneException("Le mail de la personne -- Introuvable"); 
		}
		LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : findByMail -- END");
		return personneFound;
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
		
		LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : checkValidityOfPersonne -- BEGIN");

		///////////////////////////////////////////////////////////////////////
		// (01.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->LA PERSONNE FOURNIE EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pPersonne == null) {
			LOGGER.error("La personne -- Valeur : null");
			LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : checkValidityOfPersonne -- END");
			throw new InvalidArgumentPersonneException("->La personne -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (02.)TRAITER LE CAS D'ERREUR SUIVANT :
		//      ->DANS LA PERSONNE  FOURNIE, L'ATTRIBUT 'MAIL' EST NULL.
		///////////////////////////////////////////////////////////////////////
		if (pPersonne.getMail() == null) {
			LOGGER.error("Le mail de la personne -- Valeur : null");
			LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : checkValidityOfPersonne -- END");
			throw new InvalidArgumentPersonneException("->Le mail de la personne -- Valeur : null");
		}
		///////////////////////////////////////////////////////////////////////
		// (03.)TRAITER LE CAS SUIVANT :
		//      ->DANS LA PERSONNE FOURNIE, L'ATTRIBUT 'MAIL' EST NON NULL.
		///////////////////////////////////////////////////////////////////////
		LOGGER.info("CLASS : PersonneMetierImpl -- METHOD : checkValidityOfPersonne -- END");
		return true;
	}
}
