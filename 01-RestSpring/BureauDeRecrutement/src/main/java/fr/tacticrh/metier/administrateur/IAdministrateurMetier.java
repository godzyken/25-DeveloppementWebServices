/**
 * 
 */
package fr.tacticrh.metier.administrateur;

import java.util.List;

import fr.tacticrh.exception.administrateur.IllegalTransactionAdministrateurException;
import fr.tacticrh.exception.administrateur.InvalidArgumentAdministrateurException;
import fr.tacticrh.exception.administrateur.RecordNotFoundAdministrateurException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.model.Administrateur;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Administrateur'.
 */
public interface IAdministrateurMetier {

	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter un administrateur dans les donnees persistantes.
	 * 
	 * @param pAdministrateur L'administrateur avec lequel l'ajout doit être fait.
	 * @return Administrateur L'administrateur ajouté.
	 * @throws InvalidArgumentAdministrateurException Lancee dans le cas : L'administrateur fourni est invalide.
	 * @throws InvalidArgumentUtilisateurException Lancee dans le cas : L'utilisateur associee a l'administrateur fourni est invalide.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne associee a l'administrateur fourni est invalide.
	 * @throws IllegalTransactionUtilisateurException Lancee dans le cas : La transaction demandée est illégale.
	 */
	public Administrateur add(Administrateur pAdministrateur) throws InvalidArgumentAdministrateurException
															, InvalidArgumentUtilisateurException
															, InvalidArgumentPersonneException
															, IllegalTransactionUtilisateurException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un administrateur dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant de l'administrateur.
	 * 
	 * @param pAdministrateurId L'identifiant de l'administrateur a rechercher.
	 * @return Administrateur L'administrateur trouve.
	 * @throws RecordNotFoundAdministrateurException Lancee dans le cas : L'administrateur recherche est introuvable. 
	 */
	public Administrateur find(Long pAdministrateurId) throws RecordNotFoundAdministrateurException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection d'administrateurs dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher tous les administrateurs).
	 * 
	 * @return List<Administrateur> La collection des administrateurs trouves.
	 * @throws RecordNotFoundAdministrateurException Lancee dans le cas : La collection des administrateurs recherchee est introuvable. 
	 */
	public List<Administrateur> findAll() throws RecordNotFoundAdministrateurException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un administrateur dans les donnees persistantes.
	 * 
	 * @param pPersonneMail Le mail de la personne associee a l'administrateur.
	 * @return Administrateur L'administrateur trouve.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : Le mail de la personne fourni est invalide.
	 * @throws RecordNotFoundAdministrateurException Lancee dans le cas : L'administrateur est introuvable.
	 * @throws IllegalTransactionAdministrateurException Lancee dans le cas : La transaction demandee est illegale.
	 */
	public Administrateur findByPersonneMail(String pPersonneMail) throws InvalidArgumentPersonneException
																	, RecordNotFoundAdministrateurException
																	, IllegalTransactionAdministrateurException;
}
