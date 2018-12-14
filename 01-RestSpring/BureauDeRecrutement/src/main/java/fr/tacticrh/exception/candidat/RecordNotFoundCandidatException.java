/**
 * 
 */
package fr.tacticrh.exception.candidat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.tacticrh.exception.RecordNotFoundException;

/**
 * @author Franck Taba Taba
 * 
 * <b>EXCEPTION SPECIFIQUE AUX TRAITMENTS METIERS SUR L'ENTTE 'CANDIDAT'.</b>
 * <br/><b>EXCEPTION LANCEE DANS LE CAS SUIVANT :</b>
 * <br/><b>L'OBJET RECHERCHE N'A PAS ETE TROUVE</b>
 */
@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Objet introuvable !")
public class RecordNotFoundCandidatException extends RecordNotFoundException {

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS.</b>
	 */
	public RecordNotFoundCandidatException () { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS.</b>
	 * 
	 * @param pMessage Le message
	 */
	public RecordNotFoundCandidatException (String pMessage) { super(pMessage); }
	
	/**
	 * <b>GETTER SUR LE MESSAGE</b>
	 * @return String Le message.
	 */
	public String getMessage() { return super.getMessage(); }
}
