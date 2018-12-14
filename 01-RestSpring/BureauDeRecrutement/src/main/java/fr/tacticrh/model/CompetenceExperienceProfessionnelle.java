/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.tacticrh.constant.CompetenceNiveau;


/**
 * @author Franck Taba Taba
 *
 * <br/><b>ENTITE : 'COMPETENCE_EXPERIENCE_PROFESSIONNELLE'</b>
 */
//@IdClass(CompetenceExperienceProfessionnelleId.class)
@SuppressWarnings("serial")
@Entity
public class CompetenceExperienceProfessionnelle implements Serializable {

	
	
	
	@Id
	private long competenceId;
	
	@Id
	private long experienceProfessionnelleId;
	
	
	
	
	@Column(name="niveau")
	private CompetenceNiveau niveau;
	
	
	//@PrimaryKeyJoinColumn(name="COMPETENCE__ID", referencedColumnName="ID")
	/* if this JPA model doesn't create a table for the "COMPETENCE_EXPERIENCE_PROFESSIONNELLE" entity,
	*  please comment out the @PrimaryKeyJoinColumn, and use the ff:
	*  @JoinColumn(name = "competenceId", updatable = false, insertable = false)
	* or @JoinColumn(name = "competenceId", updatable = false, insertable = false, referencedColumnName = "id")
	*/
	@ManyToOne
	@JoinColumn(name = "competenceIdFk", referencedColumnName = "id")
	private Competence competence;
	
	//@PrimaryKeyJoinColumn(name="EXPERIENCE_PROFESSIONNELLE__ID", referencedColumnName="ID")
	/* the same goes here:
	*  if this JPA model doesn't create a table for the "COMPETENCE_EXPERIENCE_PROFESSIONNELLE" entity,
	*  please comment out the @PrimaryKeyJoinColumn, and use the ff:
	*  @JoinColumn(name = "experienceProfessionnelleId", updatable = false, insertable = false)
	* or @JoinColumn(name = "experienceProfessionnelleId", updatable = false, insertable = false, referencedColumnName = "id")
	*/
	@ManyToOne
	@JoinColumn(name = "experienceProfessionnelleIdFk", referencedColumnName = "id")
	private ExperienceProfessionnelle experienceProfessionnelle;

	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public CompetenceExperienceProfessionnelle() { super(); }

	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 *
	 * @param pNiveau
	 */
	public CompetenceExperienceProfessionnelle(CompetenceNiveau pNiveau) {
		super();
		this.niveau = pNiveau;
	}

	
	
	
	public long                      getCompetenceId                () { return this.competenceId;                }
	public long                      getExperienceProfessionnelleId () { return this.experienceProfessionnelleId; }
	public CompetenceNiveau          getNiveau                      () { return this.niveau;                      }
	public Competence                getCompetence                  () { return this.competence;                  }
	public ExperienceProfessionnelle getExperienceProfessionnelle   () { return this.experienceProfessionnelle;   }

	
	
	
	public void setCompetenceId                (long                      pCompetenceId               ) { this.competenceId                = pCompetenceId;                }
	public void setExperienceProfessionnelleId (long                      pExperienceProfessionnelleId) { this.experienceProfessionnelleId = pExperienceProfessionnelleId; }
	public void setNiveau                      (CompetenceNiveau          pNiveau                     ) { this.niveau                      = pNiveau;                      }
	public void setCompetence                  (Competence                pCompetence                 ) { this.competence                  = pCompetence;                  }
	public void setExperienceProfessionnelle   (ExperienceProfessionnelle pExperienceProfessionnelle  ) { this.experienceProfessionnelle   = pExperienceProfessionnelle;   }
}
