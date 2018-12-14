/**
 * 
 */
package fr.tacticrh.exception.utilisateur;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.tacticrh.exception.InvalidArgumentException;

/**
 * @author Franck Taba Taba
 * 
 * <b>EXCEPTION SPECIFIQUE AUX TRAITMENTS METIERS SUR L'ENTTE 'UTILISATEUR'.</b>
 * <br/><b>EXCEPTION LANCEE DANS LE CAS SUIVANT :</b>
 * <br/><b>L'ARGUMENT FOURNI EST INVALIDE</b>
 */
@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Argument invalide !")
public class InvalidArgumentUtilisateurException extends InvalidArgumentException {

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;


	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS.</b>
	 */
	public InvalidArgumentUtilisateurException () { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS.</b>
	 * 
	 * @param pMessage Le message
	 */
	public InvalidArgumentUtilisateurException (String pMessage) { super(pMessage); }
	
	/**
	 * <b>GETTER SUR LE MESSAGE</b>
	 * @return String Le message.
	 */
	public String getMessage() { return super.getMessage(); }
}
