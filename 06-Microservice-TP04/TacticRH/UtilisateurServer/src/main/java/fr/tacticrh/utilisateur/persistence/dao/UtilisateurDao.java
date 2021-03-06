package fr.tacticrh.utilisateur.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.tacticrh.utilisateur.persistence.model.Utilisateur;


/**
 * <b>COMPOSANT POSSEDANT LES FONCTIONNALITES CI-DESSOUS:</b><br/>
 * ->LES FONCTIONNALITES DE PERSISTANCE SUR L'ENTITE CONCERNEE<br/>
 * ->ENTITE : 'Utilisateur'.<br/> 
 */    
@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>{
	
	public List<Utilisateur> findByRole_Libelle(String pLibelle);
}
