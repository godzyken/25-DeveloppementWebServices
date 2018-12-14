package fr.tacticrh.utilisateur.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <b>EXCEPTION DU TYPE CI-DESSOUS :</b><br/>
 * TYPE : 'PERSONNE INTROUVABLE'
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonneNotFoundException extends RuntimeException {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * <b>CONSTRUCTEUR AVEC UN ARGUMENT</b><br/>
     * @param pMessage Le message de l'exception
     */
	public PersonneNotFoundException(String pMessage) {
        super(pMessage);
    }
}
