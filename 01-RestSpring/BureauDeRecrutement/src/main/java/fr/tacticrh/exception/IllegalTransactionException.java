package fr.tacticrh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tcharou Dalgalian
 * 
 * <b>EXCEPTION LANCEE DANS LE CAS SUIVANT :</b>
 * <br/><b>LA TRANSACTION DEMANDEE EST ILLEGALE</b>
 */
@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Transaction illegale !")
public abstract class IllegalTransactionException extends Exception {

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
	public IllegalTransactionException () { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS.</b>
	 * 
	 * @param pMessage Le message
	 */
	public IllegalTransactionException (String pMessage) { 
		super(pMessage); 
		this.message = pMessage;
	}
	
	/**
	 * <b>GETTER SUR LE MESSAGE</b>
	 * @return String Le message.
	 */
	public String getMessage() { return this.message; }
}
