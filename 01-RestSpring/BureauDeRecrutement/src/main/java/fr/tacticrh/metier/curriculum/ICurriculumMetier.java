/**
 * 
 */
package fr.tacticrh.metier.curriculum;

import java.util.List;

import fr.tacticrh.exception.candidature.IllegalTransactionCandidatureException;
import fr.tacticrh.exception.candidature.InvalidArgumentCandidatureException;
import fr.tacticrh.exception.curriculum.IllegalTransactionCurriculumException;
import fr.tacticrh.exception.curriculum.InvalidArgumentCurriculumException;
import fr.tacticrh.exception.curriculum.RecordNotFoundCurriculumException;
import fr.tacticrh.model.Curriculum;

/**
 * @author Tcharou Dalgalian
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les traitements metier relatifs a l'entite 'Curriculum'.
 */
public interface ICurriculumMetier {

	
	
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Ajouter ou modifier un curriculum dans les donnees persistantes.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature avec laquelle l'ajout doit être fait.
	 * @param pCurriculum Le curriculum avec lequel l'ajout doit être fait.
	 * @return Curriculum Le curriculum ajouté.
	 * @throws InvalidArgumentCurriculumException Lancee dans le cas : Le curriculum est invalide.
	 * @throws IllegalTransactionCurriculumException Lancee dans le cas : L'ajout demandé est illegal.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : L'identifiant de la candidature fourni est invalide.
	 * @throws IllegalTransactionCandidatureException Lancee dans le cas : L'ajout demandé est illegal.
	 */
	public Curriculum addUpdate(Long pCandidatureId, Curriculum pCurriculum) throws InvalidArgumentCurriculumException, IllegalTransactionCurriculumException, InvalidArgumentCandidatureException, IllegalTransactionCandidatureException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un curriculum dans les donnees persistantes.
	 * <br/>Critere de recherche : L'identifiant du curriculum.
	 * 
	 * @param pCurriculumId L'identifiant du curriculum a rechercher.
	 * @return Curriculum Le curriculum trouve.
	 * @throws RecordNotFoundCurriculumException Exception lancee dans le cas : Le curriculum recherche est introuvable. 
	 */
	public Curriculum find(Long pCurriculumId) throws RecordNotFoundCurriculumException;
	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher une collection de curriculums dans les donnees persistantes.
	 * <br/>Critere de recherche : Aucun (-> rechercher tous les curriculums).
	 * 
	 * @return List<Curriculum> La collection des curriculums trouves.
	 * @throws RecordNotFoundCurriculumException Exception lancee dans le cas : La collection de curriculums recherchee est introuvable. 
	 */
	public List<Curriculum> findAll() throws RecordNotFoundCurriculumException;

	
	/**
	 * <b>METHODE QUI EFFECTUE LES OPERATIONS SUIVANTES : </b>
	 * <br/>Rechercher un curriculum dans les donnees persistantes.
	 * 
	 * @param pCandidatureId L'identifiant de la candidature a rechercher.
	 * @return Curriculum Le curriculum trouve.
	 * @throws InvalidArgumentCandidatureException Lancee dans le cas : L'identifiant de candidature fourni est invalide.
	 * @throws IllegalTransactionCurriculumException Lancee dans le cas : La transaction demandee est illegale.
	 */
	public Curriculum findByCandidatureId(Long pCandidatureId) throws InvalidArgumentCandidatureException, IllegalTransactionCurriculumException;
}
