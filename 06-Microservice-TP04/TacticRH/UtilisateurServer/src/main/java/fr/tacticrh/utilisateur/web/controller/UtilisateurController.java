package fr.tacticrh.utilisateur.web.controller;

import java.util.List;

import fr.tacticrh.utilisateur.persistence.model.Utilisateur;

/**
 * <b>CLASSE EXPOSANT LES FONCTIONNALITES SUIVANTES :</b><br/>
 *    -->LES FONCTIONNALITES DE NAVIGATION ET DE RECEPTION DE REQUETE HTTP.<br/>
 *    -->TYPE D'ENTITE CONCERNEE : 'Utilisateur'
 *    <br/>
 */
public interface UtilisateurController {

	
	/**
	 * <b>EFFECTUER L'OPERATION DE CREATION CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->(01.)ENTITE A CREER : 'Utilisateur'.<br/> 
	 *    
	 * @param pUtilisateur L'entité a créer.
	 * @return Utilisateur L'entité créée.
     */
	public Utilisateur enregistrer(Utilisateur pUtilisateur);
    
    /**
	 * <b>EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->(01.)ENTITE RECHERCHEE : 'Utilisateur'.<br/> 
	 * ->(02.)CRITERE DE RECHERCHE : AUCUN.<br/> 
	 * ->(03.)CONDITION A SATISFAIRE : AUCUNE.<br/>
	 *    
	 * @return List<Utilisateur> La liste d'entités trouvées.
     */
	public List<Utilisateur> rechercherTous();

    /**
	 * <b>EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->(01.)ENTITE RECHERCHEE : 'Utilisateur'.<br/> 
	 * ->(02.)CRITERE DE RECHERCHE : L'ATTRIBUT 'id'.<br/> 
	 * ->(03.)CONDITION A SATISFAIRE : L'ATTRIBUT 'id' EST EGAL A LA VALEUR FOURNIE.<br/>
	 *    
	 * @param pId L'attribut 'id' de l'entité à rechercher.
	 * @return Utilisateur L'entité trouvée.
     */
	public Utilisateur rechercherParId(long pId);
	
    /**
	 * <b>EFFECTUER L'OPERATION DE MODIFICATION CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->(01.)ENTITE A MODIFIER : 'Utilisateur'.<br/> 
	 * ->(02.)CRITERE DE RECHERCHE : L'ATTRIBUT 'id'.<br/> 
	 * ->(03.)CONDITION A SATISFAIRE : L'ATTRIBUT 'id' EST EGAL A LA VALEUR FOURNIE.<br/>
	 *    
	 * @param pUtilisateur L'entité a modifier.
	 * @return Utilisateur L'entité modifiée.
     */
	public Utilisateur modifierParId(Utilisateur pUtilisateur);
    
    /**
	 * <b>EFFECTUER L'OPERATION DE SUPPRESSION CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->(01.)ENTITE A SUPPRIMER : 'Utilisateur'.<br/> 
	 * ->(02.)CRITERE DE RECHERCHE : L'ATTRIBUT 'id'.<br/> 
	 * ->(03.)CONDITION A SATISFAIRE : L'ATTRIBUT 'id' EST EGAL A LA VALEUR FOURNIE.<br/>
	 *    
	 * @param pId L'attribut 'id' de l'entité à supprimer.
	 * @return void
     */
	public void supprimerParId(long pId);
}
