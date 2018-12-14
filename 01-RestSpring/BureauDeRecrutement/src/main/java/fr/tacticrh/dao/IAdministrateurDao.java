/**
 * 
 */
package fr.tacticrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.Administrateur;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Administrateur'.
*/
public interface IAdministrateurDao extends JpaRepository<Administrateur, Long> {

	@Query("SELECT a FROM Administrateur a WHERE a.mail = :xPersonneMail")
	public Administrateur findByPersonneMail(@Param("xPersonneMail")String pPersonneMail);
}
