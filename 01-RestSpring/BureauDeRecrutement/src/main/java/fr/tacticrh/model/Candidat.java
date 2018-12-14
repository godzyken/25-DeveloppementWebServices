package fr.tacticrh.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.tacticrh.constant.UtilisateurRole;



/**
 * @author Franck Taba Taba
 *
 * <br/><b>ENTITE : 'CANDIDAT'</b>
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("CANDI")
public class Candidat extends Utilisateur implements Serializable {
	
	

	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	@Transient
	private static final Logger LOGGER = LoggerFactory.getLogger(Candidat.class);

	
	
	
	@OneToMany(mappedBy = "candidat")
	private List<Candidature> candidatures;
	
	@OneToMany(mappedBy = "candidat")
	private List<EmploiVise> emploiVises;
	
	@OneToMany(mappedBy = "candidat")
	private List<Adresse> adresses;
	
	@OneToMany(mappedBy = "candidat")
	private List<Disponibilite> disponibilites;
	
	@OneToMany(mappedBy = "candidat")
	private List<ExperienceProfessionnelle> experienceProfessionnelles;

	@ManyToMany
	@JoinTable(name="CANDIDAT_FORMATION", joinColumns=@JoinColumn(name="candidat_id", nullable=false)
										, inverseJoinColumns=@JoinColumn(name="formation_id", nullable=false))
	private List<Formation> formations;

	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Candidat() { 
		
		super();
		
		LOGGER.info("CLASS : Candidat -- METHOD : Candidat -- ARGUMENTS : None -- BEGIN");
		LOGGER.info("CLASS : Candidat -- METHOD : Candidat -- ARGUMENTS : None -- BEGIN");
	}
	
	/**
	 * <b>CONSTRUCTEUR AVEC 8 ARGUMENTS</b>
	 * 
	 * @param pCivilite
	 * @param pNom
	 * @param pPrenom
	 * @param pAge
	 * @param pTelephone
	 * @param pMail
	 * @param pMotDePasse
	 */
	public Candidat(String            pCivilite
					, String          pNom
					, String          pPrenom
					, int             pAge
					, String          pTelephone
					, String          pMail
					, String          pMotDePasse) {
		
		super(pCivilite, pNom, pPrenom, pAge, pTelephone, pMail, pMotDePasse, UtilisateurRole.CANDIDAT);
		
		LOGGER.info("CLASS : Candidat -- METHOD : Candidat -- ARGUMENTS : String, String, String, int, String, String, String -- BEGIN");
		LOGGER.info("CLASS : Candidat -- METHOD : Candidat -- ARGUMENTS : String, String, String, int, String, String, String -- END");
	}
	
	/**
	 * <b>CONSTRUCTEUR AVEC DES ARGUMENTS DE TYPE ENTITE</b>
	 * 
	 * @param pUtilisateur
	 */
	public Candidat(Utilisateur pUtilisateur) {
		
		super(pUtilisateur, UtilisateurRole.CANDIDAT);
		
		LOGGER.info("CLASS : Candidat -- METHOD : Candidat -- ARGUMENTS : Utilisateur -- BEGIN");
		LOGGER.info("CLASS : Candidat -- METHOD : Candidat -- ARGUMENTS : Utilisateur -- END");
	}

	
	
	
	@JsonIgnore
	public List<Candidature>               getCandidatures               () { return this.candidatures;               }
	@JsonIgnore
	public List<EmploiVise>                getEmploiVises                () { return this.emploiVises;                }
	@JsonIgnore
	public List<Adresse>                   getAdresses                   () { return this.adresses;                   }
	@JsonIgnore
	public List<Disponibilite>             getDisponibilites             () { return this.disponibilites;             }
	@JsonIgnore
	public List<ExperienceProfessionnelle> getExperienceProfessionnelles () { return this.experienceProfessionnelles; }
	@JsonIgnore
	public List<Formation>                 getFormations                 () { return this.formations;                 }

	
	
	
	public void setCandidatures               (List<Candidature>               pCandidatures              ) { this.candidatures               = pCandidatures;               }
	public void setEmploiVises                (List<EmploiVise>                pEmploiVises               ) { this.emploiVises                = pEmploiVises;                }
	public void setAdresses                   (List<Adresse>                   pAdresses                  ) { this.adresses                   = pAdresses;                   }
	public void setDisponibilites             (List<Disponibilite>             pDisponibilites            ) { this.disponibilites             = pDisponibilites;             }
	public void setExperienceProfessionnelles (List<ExperienceProfessionnelle> pExperienceProfessionnelles) { this.experienceProfessionnelles = pExperienceProfessionnelles; }
	public void setFormations                 (List<Formation>                 pFormations                ) { this.formations                 = pFormations;                 }
}
