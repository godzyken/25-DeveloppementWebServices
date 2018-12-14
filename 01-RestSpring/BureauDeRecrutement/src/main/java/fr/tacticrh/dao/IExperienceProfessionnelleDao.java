package fr.tacticrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.ExperienceProfessionnelle;

/**
 * @author Tcharou DALGALIAN
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'ExperienceProfessionnelle'.
*/
public interface IExperienceProfessionnelleDao extends JpaRepository<ExperienceProfessionnelle, Long> {

	@Query("SELECT exp FROM ExperienceProfessionnelle exp JOIN exp.candidat candidat JOIN candidat.candidatures candidatures WHERE candidatures.id = :xCandidatureId")
	public List<ExperienceProfessionnelle> findByCandidatureId(@Param("xCandidatureId")Long pCandidatureId);

}
