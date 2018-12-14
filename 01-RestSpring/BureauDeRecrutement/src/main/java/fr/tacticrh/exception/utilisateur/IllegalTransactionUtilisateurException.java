/**
 * 
 */
package fr.tacticrh.exception.utilisateur;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.tacticrh.exception.IllegalTransactionException;

/**
 * @author Franck Taba Taba
 * 
 * <b>EXCEPTION SPECIFIQUE AUX TRAITMENTS METIERS SUR L'ENTTE 'UTILISATEUR'.</b>
 * <br/><b>EXCEPTION LANCEE DANS LE CAS SUIVANT :</b>
 * <br/><b>LA TRANSACTION DEMANDEE EST ILLEGALE</b>
 */
@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Transaction illegale !")
public class IllegalTransactionUtilisateurException extends IllegalTransactionException {

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;
	

	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS.</b>
	 */
	public IllegalTransactionUtilisateurException () { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS.</b>
	 * 
	 * @param pMessage Le message
	 */
	public IllegalTransactionUtilisateurException (String pMessage) { super(pMessage); }
	
	/**
	 * <b>GETTER SUR LE MESSAGE</b>
	 * @return String Le message.
	 */
	public String getMessage() { return super.getMessage(); }
}
