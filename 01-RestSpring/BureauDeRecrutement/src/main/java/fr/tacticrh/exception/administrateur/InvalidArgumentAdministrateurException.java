/**
 * 
 */
package fr.tacticrh.exception.administrateur;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.tacticrh.exception.InvalidArgumentException;

/**
 * @author Franck Taba Taba
 * 
 * <b>EXCEPTION SPECIFIQUE AUX TRAITMENTS METIERS SUR L'ENTTE 'ADMINISTRATEUR'.</b>
 * <br/><b>EXCEPTION LANCEE DANS LE CAS SUIVANT :</b>
 * <br/><b>L'ARGUMENT FOURNI EST INVALIDE</b>
 */
@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Argument invalide !")
public class InvalidArgumentAdministrateurException extends InvalidArgumentException {

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;


	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS.</b>
	 */
	public InvalidArgumentAdministrateurException () { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS.</b>
	 * 
	 * @param pMessage Le message
	 */
	public InvalidArgumentAdministrateurException (String pMessage) { super(pMessage); }
	
	/**
	 * <b>GETTER SUR LE MESSAGE</b>
	 * @return String Le message.
	 */
	public String getMessage() { return super.getMessage(); }
}
