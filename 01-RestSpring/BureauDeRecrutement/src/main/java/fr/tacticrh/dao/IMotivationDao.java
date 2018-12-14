/**
 * 
 */
package fr.tacticrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.Motivation;

/**
 * @author Tcharou DALGALIAN
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Motivation'.
*/
public interface IMotivationDao extends JpaRepository<Motivation, Long> {

	@Query("SELECT mot FROM Motivation mot JOIN mot.candidatures can WHERE can.id = :xCandidatureId")
	public Motivation findByCandidatureId(@Param("xCandidatureId")Long pCandidatureId);
}
