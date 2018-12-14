/**
 * 
 */
package fr.tacticrh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tcharou Dalgalian
 * 
 * <b>EXCEPTION LANCEE DANS LE CAS SUIVANT :</b>
 * <br/><b>L'ARGUMENT FOURNI EST INVALIDE</b>
 */
@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Argument invalide !")
public abstract class InvalidArgumentException extends Exception {

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <b>LE MESSAGE FOURNISSANT DES INFORMATIONS SUR L'EXCEPTION.</b>
	 */
	private String message;
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS.</b>
	 */
	public InvalidArgumentException () { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS.</b>
	 * 
	 * @param pMessage Le message
	 */
	public InvalidArgumentException (String pMessage) { 
		super(pMessage); 
		this.message = pMessage;
	}
	
	/**
	 * <b>GETTER SUR LE MESSAGE</b>
	 * @return String Le message.
	 */
	public String getMessage() { return this.message; }
}
