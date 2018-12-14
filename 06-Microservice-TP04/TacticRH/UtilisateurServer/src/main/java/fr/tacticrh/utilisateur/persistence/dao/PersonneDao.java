package fr.tacticrh.utilisateur.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.tacticrh.utilisateur.persistence.model.Personne;


/**
 * <b>COMPOSANT POSSEDANT LES FONCTIONNALITES CI-DESSOUS:</b><br/>
 * ->LES FONCTIONNALITES DE PERSISTANCE SUR L'ENTITE CONCERNEE<br/>
 * ->ENTITE : 'Personne'.<br/> 
 */    
@Repository
public interface PersonneDao extends JpaRepository<Personne, Long>{
}
