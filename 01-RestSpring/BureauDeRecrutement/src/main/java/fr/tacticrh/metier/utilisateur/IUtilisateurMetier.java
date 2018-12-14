/**
 * 
 */
package fr.tacticrh.metier.utilisateur;

import java.util.List;

import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.exception.utilisateur.RecordNotFoundUtilisateurException;
import fr.tacticrh.model.Utilisateur;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Utilisateur'.
 */
public interface IUtilisateurMetier {

	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter un utilisateur dans les donnees persistantes.
	 * 
	 * @param pUtilisateur L'utilisateur avec lequel l'ajout doit être fait.
	 * @return Utilisateur L'utilisateur ajouté.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne associee a l'utilisateur fourni est invalide.
	 * @throws InvalidArgumentUtilisateurException Lancee dans le cas : L'utilisateur fourni est invalide.
	 * @throws IllegalTransactionUtilisateurException Lancee dans le cas : La transaction demandée est illégale.
	 */
	public Utilisateur add(Utilisateur pUtilisateur) throws InvalidArgumentPersonneException
															, InvalidArgumentUtilisateurException
															, IllegalTransactionUtilisateurException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un utilisateur dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant de l'utilisateur.
	 * 
	 * @param pUtilisateurId L'identifiant de l'utilisateur a rechercher.
	 * @return Utilisateur L'utilisateur trouve.
	 * @throws RecordNotFoundUtilisateurException Exception lancee dans le cas : L'utilisateur recherche est introuvable. 
	 */
	public Utilisateur find(Long pUtilisateurId) throws RecordNotFoundUtilisateurException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection d'utilisateurs dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher tous les utilisateurs).
	 * 
	 * @return List<Utilisateur> La collection des utilisateurs trouves.
	 * @throws RecordNotFoundUtilisateurException Exception lancee dans le cas : La collection des utilisateurs recherchee est introuvable. 
	 */
	public List<Utilisateur> findAll() throws RecordNotFoundUtilisateurException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un utilisateur dans les donnees persistantes.
	 * 
	 * @param pPersonneMail Le mail de la personne associee a l'utilisateur.
	 * @return Utilisateur L'utilisateur trouve.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : Le mail de la personne fourni est invalide.
	 * @throws RecordNotFoundUtilisateurException Lancee dans le cas : L'utilisateur est introuvable.
	 * @throws IllegalTransactionUtilisateurException Lancee dans le cas : La transaction demandee est illegale.
	 */
	public Utilisateur findByPersonneMail(String pPersonneMail) throws InvalidArgumentPersonneException
																, RecordNotFoundUtilisateurException
																, IllegalTransactionUtilisateurException;
}
