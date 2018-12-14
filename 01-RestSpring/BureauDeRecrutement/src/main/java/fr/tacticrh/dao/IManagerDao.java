/**
 * 
 */
package fr.tacticrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.Manager;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Manager'.
*/
public interface IManagerDao extends JpaRepository<Manager, Long> {

	@Query("SELECT m FROM Manager m WHERE m.mail = :xPersonneMail")
	public Manager findByPersonneMail(@Param("xPersonneMail")String pPersonneMail);
}
