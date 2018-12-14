/**
 * 
 */
package fr.tacticrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.Curriculum;

/**
 * @author Tcharou DALGALIAN
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Curriculum'.
*/
public interface ICurriculumDao extends JpaRepository<Curriculum, Long> {
	
	@Query("SELECT cur FROM Curriculum cur JOIN cur.candidatures can WHERE can.id = :xCandidatureId")
	public Curriculum findByCandidatureId(@Param("xCandidatureId")Long pCandidatureId);
}
