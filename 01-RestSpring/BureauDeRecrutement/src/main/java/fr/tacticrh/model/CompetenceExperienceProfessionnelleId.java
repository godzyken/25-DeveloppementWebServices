/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>CLASSE : 'COMPETENCE_EXPERIENCE_PROFESSIONNELLE_ID'</b>
 */
@SuppressWarnings("serial")
@Embeddable
public class CompetenceExperienceProfessionnelleId implements Serializable {

	
	
	
	private long competenceId;
	private long experienceProfessionnelleId;
	
	
	
	
	public CompetenceExperienceProfessionnelleId() { super(); }

	public CompetenceExperienceProfessionnelleId(Long pCompetenceId, Long pExperienceProfessionnelleId) {
		super();
		this.competenceId = pCompetenceId;
		this.experienceProfessionnelleId = pExperienceProfessionnelleId;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return (int)(competenceId + experienceProfessionnelleId);
	}
	
	@Override
	public boolean equals(Object pObject) {
		
		if (pObject == null) {
			return false;
		}
		if (!(pObject instanceof CompetenceExperienceProfessionnelleId)) {
			return false;
		}
		CompetenceExperienceProfessionnelleId otherId = (CompetenceExperienceProfessionnelleId) pObject;
		
		boolean competenceIdsAreEqual = (otherId.competenceId == this.competenceId);
		boolean experienceProfessionnelleIdsAreEqual = (otherId.experienceProfessionnelleId == this.experienceProfessionnelleId);
		boolean result = competenceIdsAreEqual && experienceProfessionnelleIdsAreEqual;
		
		return result;
	}
}
