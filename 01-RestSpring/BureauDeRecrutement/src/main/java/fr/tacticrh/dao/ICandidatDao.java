package fr.tacticrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.Candidat;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Candidat'.
*/
public interface ICandidatDao extends JpaRepository<Candidat, Long> {
	
	@Query("SELECT c FROM Candidat c WHERE c.mail = :xPersonneMail")
	public Candidat findByPersonneMail(@Param("xPersonneMail")String pPersonneMail);
}
