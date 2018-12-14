/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.tacticrh.constant.UtilisateurRole;

/**
 * @author 
 *
 * <br/><b>ENTITE : 'UTILISATEUR'</b>
 */
@SuppressWarnings("serial")
@Entity
public abstract class Utilisateur extends Personne implements Serializable {

	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	@Transient
	private static final Logger LOGGER = LoggerFactory.getLogger(Utilisateur.class);

	
	

	@NotNull
	@Column(nullable = false, unique = true)
	private String identifiant;
	
	@Column(nullable = false)
	private String motDePasse;
	
	@Column(nullable = false)
	private UtilisateurRole role;
	
	private Date dateInscription;
	
	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Utilisateur() {
		
		super(); 
		
		LOGGER.info("CLASS : Utilisateur -- METHOD : Utilisateur -- ARGUMENTS : None -- BEGIN");
		LOGGER.info("CLASS : Utilisateur -- METHOD : Utilisateur -- ARGUMENTS : None -- END");
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
	 * @param pRole
	 */
	public Utilisateur(String         pCivilite
					, String          pNom
					, String          pPrenom
					, int             pAge
					, String          pTelephone
					, String          pMail
					, String          pMotDePasse
					, UtilisateurRole pRole) {
		
		super(pCivilite, pNom, pPrenom, pAge, pTelephone, pMail);
		
		LOGGER.info("CLASS : Utilisateur -- METHOD : Utilisateur -- ARGUMENTS : String, String, String, int, String, String, String, UtilisateurRole -- BEGIN");

		this.identifiant = pMail;
		this.motDePasse  = pMotDePasse;
		this.role        = pRole;
		
		LOGGER.info("CLASS : Utilisateur -- METHOD : Utilisateur -- ARGUMENTS : String, String, String, int, String, String, String, UtilisateurRole -- END");
	}

	/**
	 * <b>CONSTRUCTEUR AVEC DES ARGUMENTS DE TYPE ENTITE</b>
	 * 
	 * @param pPersonne
	 * @param pMotDePasse
	 * @param pRole
	 */
	public Utilisateur(Personne pPersonne, String pMotDePasse, UtilisateurRole pRole) {
		
		super(pPersonne);
		
		LOGGER.info("CLASS : Utilisateur -- METHOD : Utilisateur -- ARGUMENTS : Personne, String, UtilisateurRole -- BEGIN");

		////////////////////////////////////////////////////////////////////////
		// REGLE METIER : ON COPIE L'ATTRIBUT 'MAIL' DANS L'ATTRIBUT 'IDENTIFIANT'.
		////////////////////////////////////////////////////////////////////////
		this.identifiant = pPersonne.getMail();
		this.motDePasse  = pMotDePasse;
		this.role        = pRole;
		
		LOGGER.info("CLASS : Utilisateur -- METHOD : Utilisateur -- ARGUMENTS : Personne, String, UtilisateurRole -- END");
	}

	/**
	 * <b>CONSTRUCTEUR AVEC DES ARGUMENTS DE TYPE ENTITE</b>
	 * 
	 * @param pUtilisateur
	 * @param pRole
	 */
	public Utilisateur(Utilisateur pUtilisateur, UtilisateurRole pRole) {
		
		super((Personne)pUtilisateur);
		
		LOGGER.info("CLASS : Utilisateur -- METHOD : Utilisateur -- ARGUMENTS : Utilisateur, UtilisateurRole -- BEGIN");

		////////////////////////////////////////////////////////////////////////
		// REGLE METIER : ON COPIE L'ATTRIBUT 'MAIL' DANS L'ATTRIBUT 'IDENTIFIANT'.
		////////////////////////////////////////////////////////////////////////
		this.identifiant = pUtilisateur.getMail();
		this.motDePasse  = pUtilisateur.getMotDePasse();
		this.role        = pRole;
		
		LOGGER.info("CLASS : Utilisateur -- METHOD : Utilisateur -- ARGUMENTS : Utilisateur, UtilisateurRole -- END");
	}

	


	public String          getIdentifiant    () { return this.identifiant;     }
	public String          getMotDePasse     () { return this.motDePasse;      }
	public UtilisateurRole getRole           () { return this.role;            }
	public Date            getDateInscription() { return this.dateInscription; }




	public void setIdentifiant     (String          pIdentifiant    ) { this.identifiant     = pIdentifiant;     }
	public void setMotDePasse      (String          pMotDePasse     ) { this.motDePasse      = pMotDePasse;      }
	public void setRole            (UtilisateurRole pRole           ) { this.role            = pRole;            }
	public void setDateInscription (Date            pDateInscription) { this.dateInscription = pDateInscription; }
}
