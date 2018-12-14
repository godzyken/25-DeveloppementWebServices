
package fr.tacticrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.Personne;


/**
 * @author Tcharou DALGALIAN
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Personne'.
*/
public interface IPersonneDao extends JpaRepository<Personne, Long> {

	/*
	@Query("SELECT p FROM Personne p WHERE p.candidat.id = :xCandidatId")
	public Personne findByCandidatId(@Param("xCandidatId")Long pCandidatId);
	*/

	@Query("SELECT p FROM Personne p WHERE p.mail = :xMail")
	public Personne findByMail(@Param("xMail")String pMail);
}
