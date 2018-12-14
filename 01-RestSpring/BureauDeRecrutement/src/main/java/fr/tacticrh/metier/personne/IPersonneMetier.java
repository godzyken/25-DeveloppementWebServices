/**
 * 
 */
package fr.tacticrh.metier.personne;

import java.util.List;

import fr.tacticrh.exception.personne.IllegalTransactionPersonneException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.personne.RecordNotFoundPersonneException;
import fr.tacticrh.model.Personne;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Personne'.
 */
public interface IPersonneMetier {

	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Modifier une personne dans les donnees persistantes.
	 * 
	 * @param pPersonne La personne avec laquelle la transaction doit être effectuee.
	 * @return Personne La personne utilisee.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne fournie est invalide.
	 * @throws IllegalTransactionPersonneException Lancee dans le cas : La transaction demandée est illegale.
	 */
	public Personne update(Personne pPersonne) throws InvalidArgumentPersonneException, IllegalTransactionPersonneException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une personne dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant de la personne.
	 * 
	 * @param pPersonneId L'identifiant de la personne a rechercher.
	 * @return Personne La personne trouvee.
	 * @throws RecordNotFoundPersonneException Exception lancee dans le cas : La personne recherchee est introuvable. 
	 */
	public Personne find(Long pPersonneId) throws RecordNotFoundPersonneException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de personnes dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher toutes les personnes).
	 * 
	 * @return List<Personne> La collection des personnes trouvees.
	 * @throws RecordNotFoundPersonneException Exception lancee dans le cas : La collection de personnes recherchee est introuvable. 
	 */
	public List<Personne> findAll() throws RecordNotFoundPersonneException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une personne dans les donnees persistantes.
	 * 
	 * @param pMail Le mail de la personne a rechercher.
	 * @return Personne La personne trouvee.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : Le mail de la personne fourni est invalide.
	 * @throws IllegalTransactionPersonneException Lancee dans le cas : La transaction demandee est illegale.
	 * @throws RecordNotFoundPersonneException Lancee dans le cas : La personne est introuvable.
	 */
	public Personne findByMail(String pMail) throws InvalidArgumentPersonneException, IllegalTransactionPersonneException, RecordNotFoundPersonneException;
}
