package fr.tacticrh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tcharou Dalgalian
 * 
 * <b>EXCEPTION LANCEE DANS LE CAS SUIVANT :</b>
 * <br/><b>L'OBJET RECHERCHE N'A PAS ETE TROUVE</b>
 */
@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Objet introuvable !")
public abstract class RecordNotFoundException extends Exception {

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
	public RecordNotFoundException () { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS.</b>
	 * 
	 * @param pMessage Le message
	 */
	public RecordNotFoundException (String pMessage) { 
		super(pMessage); 
		this.message = pMessage;
	}
	
	/**
	 * <b>GETTER SUR LE MESSAGE</b>
	 * @return String Le message.
	 */
	public String getMessage() { return this.message; }
}
