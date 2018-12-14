/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.tacticrh.constant.CompetenceNiveau;

/**
 * @author Tcharou Dalgalian
 *
 * <br/><b>ENTITE : 'EXPERIENCE_PROFESSIONNELLE'</b>
 */
@SuppressWarnings("serial")
@Entity
public class ExperienceProfessionnelle implements Serializable {

	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//strategie de generation de la clé primaire
	private Long id;
	
	private String employeur;
	private String fonction;
	private Date dateDebut;
	private Date dateFin;
	private String lieu;

	
	@ManyToOne
	private Candidat candidat;
	
	@OneToMany(mappedBy = "experienceProfessionnelle")
	private List<Contrat> contrats;
	
	
	@OneToMany(mappedBy = "experienceProfessionnelle")
	private List<CompetenceExperienceProfessionnelle> competenceExperienceProfessionnelles = new ArrayList<CompetenceExperienceProfessionnelle>();
	
	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public ExperienceProfessionnelle() { super(); }

	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 *
	 * @param pEmployeur
	 * @param pFonction
	 * @param pDateDebut
	 * @param pDateFin
	 * @param pLieu
	 */
	public ExperienceProfessionnelle(String pEmployeur, String pFonction, Date pDateDebut, Date pDateFin, String pLieu) {
		super();
		this.employeur = pEmployeur;
		this.fonction = pFonction;
		this.dateDebut = pDateDebut;
		this.dateFin = pDateFin;
		this.lieu = pLieu;
	}

	
	
	
	public Long                                      getId                                   () { return this.id;                                   }
	public String                                    getEmployeur                            () { return this.employeur;                            }
	public String                                    getFonction                             () { return this.fonction;                             }
	public Date                                      getDateDebut                            () { return this.dateDebut;                            }
	public Date                                      getDateFin                              () { return this.dateFin;                              }
	public String                                    getLieu                                 () { return this.lieu;                                 }
	
	public Candidat                                  getCandidat                             () { return this.candidat;                             }
	@JsonIgnore
	public List<Contrat>                             getContrats                             () { return this.contrats;                             }
	@JsonIgnore
	public List<CompetenceExperienceProfessionnelle> getCompetenceExperienceProfessionnelles () { return this.competenceExperienceProfessionnelles; }

	
	
	
	public void setId                                   (Long                                      pId                                  ) { this.id                                   = pId;                                   }
	public void setEmployeur                            (String                                    pEmployeur                           ) { this.employeur                            = pEmployeur;                            }
	public void setFonction                             (String                                    pFonction                            ) { this.fonction                             = pFonction;                             }
	public void setDateDebut                            (Date                                      pDateDebut                           ) { this.dateDebut                            = pDateDebut;                            }
	public void setDateFin                              (Date                                      pDateFin                             ) { this.dateFin                              = pDateFin;                              }
	public void setLieu                                 (String                                    pLieu                                ) { this.lieu                                 = pLieu;                                 }

	public void setCandidat                             (Candidat                                  pCandidat                            ) { this.candidat                             = pCandidat;                             }
	public void setContrats                             (List<Contrat>                             pContrats                            ) { this.contrats                             = pContrats;                             }
	public void setCompetenceExperienceProfessionnelles (List<CompetenceExperienceProfessionnelle> pCompetenceExperienceProfessionnelles) { this.competenceExperienceProfessionnelles = pCompetenceExperienceProfessionnelles; }
	
	
	
	
	/**
	 * <b>PERFORM FOLLOWING ACTIONS :</b>
	 * <br/>
	 * <br/>(01.)Create an association-object establishing the relationship between both objects specified below.
	 * <br/>(02.)Add this association-object into both objects specified below.
	 * <br/>
	 * <br/>(03.)The objects involved in both operations defined above are :
	 * <br/>     ->The actual 'ExperienceProfessionnelle'-object.
	 * <br/>     ->The provided 'Competence'-object.
	 * 
	 * @param pCompetence
	 * @param pNiveau
	 */
	public void addCompetence(Competence pCompetence, CompetenceNiveau pNiveau) {
	
		///////////////////////////////////////////////////////////////////////////////////////
		// (01.)Create an association-object establishing the relationship between both objects specified below :
		//      ->The actual 'ExperienceProfessionnelle'-object.
		//      ->The provided 'Competence'-object.
		///////////////////////////////////////////////////////////////////////////////////////
		CompetenceExperienceProfessionnelle competenceExperienceProfessionnelle = new CompetenceExperienceProfessionnelle();
		
		competenceExperienceProfessionnelle.setExperienceProfessionnelle (this);
		competenceExperienceProfessionnelle.setCompetence (pCompetence);
		
		competenceExperienceProfessionnelle.setExperienceProfessionnelleId (this.getId());
		competenceExperienceProfessionnelle.setCompetenceId (pCompetence.getId());
		
		competenceExperienceProfessionnelle.setNiveau (pNiveau);
		
		///////////////////////////////////////////////////////////////////////////////////////
		// (02.)Add this association-object into both objects specified below :
		//      ->The actual 'ExperienceProfessionnelle'-object.
		//      ->The provided 'Competence'-object.
		///////////////////////////////////////////////////////////////////////////////////////
		if (this.competenceExperienceProfessionnelles == null) {
			this.competenceExperienceProfessionnelles = new ArrayList<CompetenceExperienceProfessionnelle>();
		}
		this.competenceExperienceProfessionnelles.add(competenceExperienceProfessionnelle);
		
		pCompetence.getCompetenceExperienceProfessionnelles().add(competenceExperienceProfessionnelle);
	}
}
