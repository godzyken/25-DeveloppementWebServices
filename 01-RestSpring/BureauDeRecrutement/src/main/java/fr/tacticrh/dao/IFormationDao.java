/**
 * 
 */
package fr.tacticrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.Formation;

/**
 * @author Tcharou DALGALIAN
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Formation'.
*/
public interface IFormationDao extends JpaRepository<Formation, Long> {
	
	@Query("SELECT for FROM Formation for JOIN for.candidats can WHERE can.id=:xCandidatId)")
	public List<Formation> findByCandidatId(@Param("xCandidatId")Long pCandidatId);
}
