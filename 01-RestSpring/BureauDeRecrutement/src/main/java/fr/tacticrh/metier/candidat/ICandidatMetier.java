/**
 * 
 */
package fr.tacticrh.metier.candidat;

import java.util.List;

import fr.tacticrh.exception.candidat.IllegalTransactionCandidatException;
import fr.tacticrh.exception.candidat.InvalidArgumentCandidatException;
import fr.tacticrh.exception.candidat.RecordNotFoundCandidatException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.model.Candidat;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Candidat'.
 */
public interface ICandidatMetier {

	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter un candidat dans les donnees persistantes.
	 * 
	 * @param pCandidat Le candidat avec lequel l'ajout doit être fait.
	 * @return Candidat Le candidat ajouté.
	 * @throws InvalidArgumentCandidatException Lancee dans le cas : Le candidat fourni est invalide.
	 * @throws InvalidArgumentUtilisateurException Lancee dans le cas : L'utilisateur associee au candidat fourni est invalide.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : La personne associee au candidat fourni est invalide.
	 * @throws IllegalTransactionUtilisateurException Lancee dans le cas : La transaction demandée est illégale.
	 */
	public Candidat add(Candidat pCandidat) throws InvalidArgumentCandidatException
													, InvalidArgumentUtilisateurException
													, InvalidArgumentPersonneException
													, IllegalTransactionUtilisateurException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un candidat dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant du candidat.
	 * 
	 * @param pCandidatId L'identifiant du candidat a rechercher.
	 * @return Candidat Le candidat trouve.
	 * @throws RecordNotFoundCandidatException Exception lancee dans le cas : Le candidat recherche est introuvable. 
	 */
	public Candidat find(Long pCandidatId) throws RecordNotFoundCandidatException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de candidats dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher tous les candidats).
	 * 
	 * @return List<Candidat> La collection des candidats trouves.
	 * @throws RecordNotFoundCandidatException Exception lancee dans le cas : La collection de candidats recherchee est introuvable. 
	 */
	public List<Candidat> findAll() throws RecordNotFoundCandidatException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un candidat dans les donnees persistantes.
	 * 
	 * @param pPersonneMail Le mail de la personne associee au candidat.
	 * @return Candidat Le candidat trouve.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : Le mail de la personne fourni est invalide.
	 * @throws RecordNotFoundCandidatException Lancee dans le cas : Le candidat est introuvable.
	 * @throws IllegalTransactionCandidatException Lancee dans le cas : La transaction demandee est illegale.
	 */
	public Candidat findByPersonneMail(String pPersonneMail) throws InvalidArgumentPersonneException
																	, RecordNotFoundCandidatException
																	, IllegalTransactionCandidatException;
}
