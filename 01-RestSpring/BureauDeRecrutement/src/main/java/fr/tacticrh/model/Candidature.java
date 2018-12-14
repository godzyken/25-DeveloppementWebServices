/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Franck Taba Taba
 * 
 * <br/><b>ENTITE : 'CANDIDATURE'</b>
 */
@SuppressWarnings("serial")
@Entity
public class Candidature implements Serializable {
	
	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //strategie de generation de la clé primaire
	private Long id;
	
	private Date dateDepot;
	private long referenceOffre;
	
	@ManyToOne	
	private Candidat candidat;

	@ManyToOne
	private Curriculum curriculum;
	
	@ManyToOne
	private Motivation motivation;
	
	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Candidature() { super(); }

	/**
	 * <b>CONSTRUCTEUR AVEC 1 ARGUMENTS</b>
	 */
	public Candidature(long pReferenceOffre) {
		super();
		this.referenceOffre = pReferenceOffre;
	}
	
	
	

	public Long       getId            () { return this.id;	            }
	public Date       getDateDepot     () { return this.dateDepot;      }
	public long       getReferenceOffre() { return this.referenceOffre; }
	
	public Candidat   getCandidat      () { return this.candidat;       }
	public Curriculum getCurriculum    () { return this.curriculum;     }
	public Motivation getMotivation    () { return this.motivation;     }

	
	
	
	public void setId             (Long       pId            ) { this.id             = pId;             }
	public void setDateDepot      (Date       pDateDepot     ) { this.dateDepot      = pDateDepot;      }
	public void setReferenceOffre (long       pReferenceOffre) { this.referenceOffre = pReferenceOffre; }
	
	public void setCandidat       (Candidat   pCandidat      ) { this.candidat       = pCandidat;       }
	public void setCurriculum     (Curriculum pCurriculum    ) { this.curriculum     = pCurriculum;     }
	public void setMotivation     (Motivation pMotivation    ) { this.motivation     = pMotivation;     }
}



