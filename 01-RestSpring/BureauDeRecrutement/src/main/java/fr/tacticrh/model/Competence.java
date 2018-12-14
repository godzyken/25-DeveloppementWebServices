/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.tacticrh.constant.CompetenceNiveau;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>ENTITE : 'COMPETENCE'</b>
 */
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="NATURE_COMPETENCE", discriminatorType=DiscriminatorType.STRING, length=5)
public abstract class Competence implements Serializable {
	
	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//strategie de generation de la clé primaire
	private Long id	;

	
	@OneToMany(mappedBy="competence", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CompetenceExperienceProfessionnelle> competenceExperienceProfessionnelles = new ArrayList<CompetenceExperienceProfessionnelle>();
	

	
		
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Competence() { super(); }

   
   
   
	public Long                                      getId                                   () { return this.id;                                   }
	@JsonIgnore
	public List<CompetenceExperienceProfessionnelle> getCompetenceExperienceProfessionnelles () { return this.competenceExperienceProfessionnelles; }


	
	
	public void setId                                   (Long                                      pId                                  ) { this.id                                   = pId;                                   }
	public void setCompetenceExperienceProfessionnelles (List<CompetenceExperienceProfessionnelle> pCompetenceExperienceProfessionnelles) { this.competenceExperienceProfessionnelles = pCompetenceExperienceProfessionnelles; }
	
	
	
	
	/**
	 * <b>PERFORM FOLLOWING ACTIONS :</b>
	 * <br/>
	 * <br/>(01.)Create an association-object establishing the relationship between both objects specified below.
	 * <br/>(02.)Add this association-object into both objects specified below.
	 * <br/>
	 * <br/>(03.)The objects involved in both operations defined above are :
	 * <br/>     ->The actual 'Competence'-object.
	 * <br/>     ->The provided 'ExperienceProfessionnelle'-object.
	 * 
	 * @param pExperienceProfessionnelle
	 * @param pNiveau
	 */
	public void addExperienceProfessionnelle(ExperienceProfessionnelle pExperienceProfessionnelle, CompetenceNiveau pNiveau) {
	
		///////////////////////////////////////////////////////////////////////////////////////
		// (01.)Create an association-object establishing the relationship between both objects specified below :
		//      ->The actual 'Competence'-object.
		//      ->The provided 'ExperienceProfessionnelle'-object.
		///////////////////////////////////////////////////////////////////////////////////////
		CompetenceExperienceProfessionnelle competenceExperienceProfessionnelle = new CompetenceExperienceProfessionnelle();
		
		competenceExperienceProfessionnelle.setCompetence (this);
		competenceExperienceProfessionnelle.setExperienceProfessionnelle (pExperienceProfessionnelle);
		
		competenceExperienceProfessionnelle.setCompetenceId (this.getId());
		competenceExperienceProfessionnelle.setExperienceProfessionnelleId (pExperienceProfessionnelle.getId());
		
		competenceExperienceProfessionnelle.setNiveau (pNiveau);
		
		///////////////////////////////////////////////////////////////////////////////////////
		// (02.)Add this association-object into both objects specified below :
		//      ->The actual 'Competence'-object.
		//      ->The provided 'ExperienceProfessionnelle'-object.
		///////////////////////////////////////////////////////////////////////////////////////
		if (this.competenceExperienceProfessionnelles == null) {
			this.competenceExperienceProfessionnelles = new ArrayList<CompetenceExperienceProfessionnelle>();
		}
		this.competenceExperienceProfessionnelles.add(competenceExperienceProfessionnelle);
		
		pExperienceProfessionnelle.getCompetenceExperienceProfessionnelles().add(competenceExperienceProfessionnelle);
	}
}
