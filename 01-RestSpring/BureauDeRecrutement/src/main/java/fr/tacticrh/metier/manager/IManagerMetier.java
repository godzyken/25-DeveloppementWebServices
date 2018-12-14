/**
 * 
 */
package fr.tacticrh.metier.manager;

import java.util.List;

import fr.tacticrh.exception.manager.IllegalTransactionManagerException;
import fr.tacticrh.exception.manager.InvalidArgumentManagerException;
import fr.tacticrh.exception.manager.RecordNotFoundManagerException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.model.Manager;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Manager'.
 */
public interface IManagerMetier {

	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter un manager dans les donnees persistantes.
	 * 
	 * @param pManager Le manager avec lequel l'ajout doit être fait.
	 * @return Manager Le manager ajouté.
	 * @throws InvalidArgumentManagerException Lancee dans le cas : Le manager fourni est invalide.
	 * @throws InvalidArgumentUtilisateurException Lancee dans le cas : L'utilisateur associee au manager fourni est invalide.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne associee au manager fourni est invalide.
	 * @throws IllegalTransactionUtilisateurException Lancee dans le cas : La transaction demandée est illégale.
	 */
	public Manager add(Manager pManager) throws InvalidArgumentManagerException
												, InvalidArgumentUtilisateurException
												, InvalidArgumentPersonneException
												, IllegalTransactionUtilisateurException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un manager dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant du manager.
	 * 
	 * @param pManagerId L'identifiant du manager a rechercher.
	 * @return Manager Le manager trouve.
	 * @throws RecordNotFoundManagerException Lancee dans le cas : Le manager recherche est introuvable. 
	 */
	public Manager find(Long pManagerId) throws RecordNotFoundManagerException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de managers dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher tous les managers).
	 * 
	 * @return List<Manager> La collection des managers trouves.
	 * @throws RecordNotFoundManagerException Lancee dans le cas : La collection de managers recherchee est introuvable. 
	 */
	public List<Manager> findAll() throws RecordNotFoundManagerException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un manager dans les donnees persistantes.
	 * 
	 * @param pPersonneMail Le mail de la personne associee au manager.
	 * @return Manager Le manager trouve.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : Le mail de la personne fourni est invalide.
	 * @throws RecordNotFoundManagerException Lancee dans le cas : Le manager est introuvable.
	 * @throws IllegalTransactionManagerException Lancee dans le cas : La transaction demandee est illegale.
	 */
	public Manager findByPersonneMail(String pPersonneMail) throws InvalidArgumentPersonneException
																	, RecordNotFoundManagerException
																	, IllegalTransactionManagerException;
}
