/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.tacticrh.constant.UtilisateurRole;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>ENTITE : 'MANAGER'</b>
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("MANAG")
public class Manager extends Utilisateur implements Serializable {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	@Transient
	private static final Logger LOGGER = LoggerFactory.getLogger(Manager.class);
	
	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Manager() {
		
		super(); 
		
		LOGGER.info("CLASS : Manager -- METHOD : Manager -- ARGUMENTS : None -- BEGIN");
		LOGGER.info("CLASS : Manager -- METHOD : Manager -- ARGUMENTS : None -- END");
	}
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 * 
	 * @param pCivilite
	 * @param pNom
	 * @param pPrenom
	 * @param pAge
	 * @param pTelephone
	 * @param pMail
	 * @param pMotDePasse
	 */
	public Manager(String             pCivilite
					, String          pNom
					, String          pPrenom
					, int             pAge
					, String          pTelephone
					, String          pMail
					, String          pMotDePasse) {
		
		super(pCivilite, pNom, pPrenom, pAge, pTelephone, pMail, pMotDePasse, UtilisateurRole.MANAGER);
		
		LOGGER.info("CLASS : Manager -- METHOD : Manager -- ARGUMENTS : String, String, String, int, String, String, String -- BEGIN");
		LOGGER.info("CLASS : Manager -- METHOD : Manager -- ARGUMENTS : String, String, String, int, String, String, String -- END");
	}
	
	/**
	 * <b>CONSTRUCTEUR AVEC DES ARGUMENTS DE TYPE ENTITE</b>
	 * 
	 * @param pUtilisateur
	 */
	public Manager(Utilisateur pUtilisateur) {
		
		super(pUtilisateur, UtilisateurRole.MANAGER);
		
		LOGGER.info("CLASS : Manager -- METHOD : Manager -- ARGUMENTS : Utilisateur -- BEGIN");
		LOGGER.info("CLASS : Manager -- METHOD : Manager -- ARGUMENTS : Utilisateur -- END");
	}
}
