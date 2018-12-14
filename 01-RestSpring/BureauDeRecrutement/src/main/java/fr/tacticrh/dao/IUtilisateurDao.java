/**
 * 
 */
package fr.tacticrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.tacticrh.model.Utilisateur;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Utilisateur'.
*/
public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long> {

	@Query("SELECT u FROM Utilisateur u WHERE u.identifiant = :xIdentifiant")
	public Utilisateur findByIdentifiant(@Param("xIdentifiant")String pIdentifiant);
	
	@Query("SELECT u FROM Utilisateur u WHERE u.mail = :xPersonneMail")
	public Utilisateur findByPersonneMail(@Param("xPersonneMail")String pPersonneMail);
}
