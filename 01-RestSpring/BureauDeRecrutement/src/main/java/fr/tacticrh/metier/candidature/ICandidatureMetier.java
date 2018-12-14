/**
 * 
 */
package fr.tacticrh.metier.candidature;

import java.util.List;

import fr.tacticrh.exception.candidat.InvalidArgumentCandidatException;
import fr.tacticrh.exception.candidature.IllegalTransactionCandidatureException;
import fr.tacticrh.exception.candidature.InvalidArgumentCandidatureException;
import fr.tacticrh.exception.candidature.RecordNotFoundCandidatureException;
import fr.tacticrh.exception.curriculum.InvalidArgumentCurriculumException;
import fr.tacticrh.exception.motivation.InvalidArgumentMotivationException;
import fr.tacticrh.model.Candidature;
import fr.tacticrh.model.Curriculum;
import fr.tacticrh.model.Motivation;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Candidature'.
 */
public interface ICandidatureMetier {

	
	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter une candidature dans les donnees persistantes.
	 * 
	 * @param pCandidatId L'identifiant du candidat avec lequel l'ajout doit être fait.
	 * @param pCandidature La candidature avec laquelle l'ajout doit être fait.
	 * @return Candidature La candidature ajoutée.
	 * @throws InvalidArgumentCandidatException Lancee dans le cas : L'identifiant du candidat est invalide.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : La candidature est invalide.
	 * @throws IllegalTransactionCandidatureException Lancee dans le cas : L'ajout demandé est illegal.
	 */
	public Candidature add(Long pCandidatId, Candidature pCandidature) throws InvalidArgumentCandidatException
																				, InvalidArgumentCandidatureException
																				, IllegalTransactionCandidatureException;

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter un curriculum à une candidature dans les donnees persistantes.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature sur laquelle l'ajout doit être fait.
	 * @param pCurriculum Le curriculum avec lequel l'ajout doit être fait.
	 * @return Candidature La candidature modifiée.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : L'identifiant de la candidature est invalide.
	 * @throws InvalidArgumentCurriculumException Lancee dans le cas : Le curriculum fourni est invalide.
	 * @throws IllegalTransactionCandidatureException Lancee dans le cas : L'ajout demandé est illegal.
	 */
	public Candidature addCurriculum(Long pCandidatureId, Curriculum pCurriculum) throws InvalidArgumentCandidatureException
																							, InvalidArgumentCurriculumException
																							, IllegalTransactionCandidatureException;

	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter une motivation à une candidature dans les donnees persistantes.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature sur laquelle l'ajout doit être fait.
	 * @param pMotivation La motivation avec laquelle l'ajout doit être fait.
	 * @return Candidature La candidature modifiée.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : L'identifiant de la candidature est invalide.
	 * @throws InvalidArgumentMotivationException Lancee dans le cas : La motivation fournie est invalide.
	 * @throws IllegalTransactionCandidatureException Lancee dans le cas : L'ajout demandé est illegal.
	 */
	public Candidature addMotivation(Long pCandidatureId, Motivation pMotivation) throws InvalidArgumentCandidatureException
																							, InvalidArgumentMotivationException
																							, IllegalTransactionCandidatureException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter ou modifier une candidature dans les donnees persistantes.
	 * 
	 * @param pPersonne La Personne avec laquelle l'ajout doit être fait.
	 * @param pCandidature La candidature avec laquelle l'ajout doit être fait.
	 * @return Candidature La candidature ajoutée.
	 * @throws InvalidArgumentPersonneException Lancee dans le cas : Le personne fournie est invalide.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : La candidature est invalide.
	 * @throws IllegalTransactionCandidatureException Lancee dans le cas : L'ajout demandé est illegal.
	 */
	//public Candidature addUpdateAvecCreationDePersonne(Personne pPersonne, Candidature pCandidature) throws InvalidArgumentPersonneException, InvalidArgumentCandidatureException, IllegalTransactionCandidatureException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une candidature dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant de la candidature.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature a rechercher.
	 * @return Candidature La candidature trouvee.
	 * @throws RecordNotFoundCandidatureException Exception lancee dans le cas : La candidature recherchee est introuvable. 
	 */
	public Candidature find(Long pCandidatureId) throws RecordNotFoundCandidatureException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de candidatures dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher toutes les candidatures).
	 * 
	 * @return List<Candidature> La collection des candidatures trouvees.
	 * @throws RecordNotFoundCandidatureException Exception lancee dans le cas : La collection de candidatures recherchee est introuvable. 
	 */
	public List<Candidature> findAll() throws RecordNotFoundCandidatureException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de candidatures dans les donnees persistantes.
	 * <br/>Critere de recherche : Le mail de la personne associee a la candidature.
	 * 
	 * @param pPersonneMail Le mail de la personne associee a la candidature a rechercher.
	 * @return List<Candidature> La collection des candidatures trouvees.
	 * @throws RecordNotFoundCandidatureException Exception lancee dans le cas : La candidature recherchee est introuvable. 
	 */
	public List<Candidature> findByPersonneMail(String pPersonneMail) throws RecordNotFoundCandidatureException;
}
