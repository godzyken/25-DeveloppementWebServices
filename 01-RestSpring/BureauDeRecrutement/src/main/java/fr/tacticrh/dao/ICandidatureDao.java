package fr.tacticrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.Candidature;

/**
 * @author Tcharou DALGALIAN
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Candidature'.
*/
public interface ICandidatureDao extends JpaRepository<Candidature, Long> {
	
	@Query("SELECT c FROM Candidature c WHERE c.candidat.id = :xCandidatId")
	public List<Candidature> findByCandidatId(@Param("xCandidatId")Long pCandidatId);	
	
	@Query("SELECT c.candidatures FROM Candidat c WHERE c.mail = :xPersonneMail")
	public List<Candidature> findByPersonneMail(@Param("xPersonneMail")String pPersonneMail);	
}
