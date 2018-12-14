package fr.tacticrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tacticrh.model.Competence;

/**
 * @author Tcharou DALGALIAN
 *
 * <br/><b>INTERFACE QUI EXPOSE LES FONCTIONNALITES SUIVANTES : </b>
 * <br/>Les fonctionnalites de persistance pour l'entite 'Competence'.
*/

public interface ICompetenceDao extends JpaRepository<Competence, Long> {

}
