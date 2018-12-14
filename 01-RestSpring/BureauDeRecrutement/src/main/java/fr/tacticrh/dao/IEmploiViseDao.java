package fr.tacticrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.EmploiVise;

/**
 * @author Tcharou DALGALIAN
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'EmploiVise'.
*/
public interface IEmploiViseDao extends JpaRepository<EmploiVise, Long> {

	@Query("SELECT epv FROM EmploiVise epv WHERE epv.candidat.id = :xCandidatId")
	public List<EmploiVise> findByCandidatId(@Param("xCandidatId")Long pCandidatId);	
}
