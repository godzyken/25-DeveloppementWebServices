/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author Franck Taba Taba
 *
 * <br/><b>ENTITE : 'FORMATION'</b>
 */
@SuppressWarnings("serial")
@Entity
public class Formation implements Serializable {
		
		
		
	
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//strategie de generation de la clé primaire
		private Long id;
		
		private String libelle;
		private String niveau;
		private String domaine;
		private Date dateValidation;
		
		//@JoinTable(name="FORMATION_CANDIDAT", joinColumns=@JoinColumn(name="formation_id", nullable=false)
		//									, inverseJoinColumns=@JoinColumn(name="candidat_id", nullable=false))
		@ManyToMany(mappedBy="formations")
		private List<Candidat> candidats;
		
		
		
				
		/**
		 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
		 */
		public Formation() { super(); }
		
		/**
		 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
		 *
		 * @param pLibelle
		 * @param pNiveau
		 * @param pDomaine
		 * @param pDate
		 */
		public Formation(String pLibelle, String pNiveau, String pDomaine, Date pDate) {
			super();
			this.libelle = pLibelle;
			this.niveau = pNiveau;
			this.domaine = pDomaine;
			this.dateValidation = pDate;
		}

		
		
		
		public Long           getId             () { return this.id;             }
		public String         getLibelle        () { return this.libelle;        }
		public String         getNiveau         () { return this.niveau;         }
		public String         getDomaine        () { return this.domaine;        }
		public Date           getDateValidation () { return this.dateValidation; }
		
		@JsonIgnore
		public List<Candidat> getCandidats      () { return this.candidats;      }

		
		
		
		public void setId             (Long           pId            ) { this.id             = pId;             }
		public void setLibelle        (String         pLibelle       ) { this.libelle        = pLibelle;        }
		public void setNiveau         (String         pNiveau        ) { this.niveau         = pNiveau;         }
		public void setDomaine        (String         pDomaine       ) { this.domaine        = pDomaine;        }
		public void setDateValidation (Date           pDateValidation) { this.dateValidation = pDateValidation; }
		
		public void setCandidats      (List<Candidat> pCandidats     ) { this.candidats      = pCandidats;      }
}
