/**
 * 
 */
package fr.tacticrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tacticrh.model.Adresse;

/**
 * @author Franck Taba Taba
 * 
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Adresse'.
 *
 */
public interface IAdresseDao extends JpaRepository<Adresse, Long> {

}
