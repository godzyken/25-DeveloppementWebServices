/**
 * 
 */
package fr.tacticrh.constant;

/**
 * @author Tcharou Dalgalian
 *
 * <b>L'ENUMERATION DE TOUTES LES VALEURS POSSIBLES DE LA DONNEE SUIVANTE :</b>
 * <br/>L'ATTRIBUT 'ROLE' DE L'OBJET 'UTILISATEUR'
 */
public enum UtilisateurRole {

	
	
	
	///////////////////////////////////////////////////////////////////////////
	//(1.)OBJETS DIRECTEMENT CONSTRUITS
	///////////////////////////////////////////////////////////////////////////
	CANDIDAT       ("Candidat"       ),
	MANAGER        ("Manager"        ),
	ADMINISTRATEUR ("Administrateur" ),
	DEVELOPPEUR    ("Developpeur"    );
	
	
	
	
	/**
	 * <b>LA VALEUR DE L'ELEMENT ENUMERE</b>
	 */
	private String value = null;
	   
	
	
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENT</b>
	 */
	UtilisateurRole(String pValue){
		this.value = pValue;
	}
	   
	
	
	
	/**
	 * <b>RENVOYER LA VALEUR DE L'ELEMENT ENUMERE (SOUS FORME D'UNE CHAINE DE CARACTERES).</b>
	 * @return String La valeur de l'élément énuméré (sous forme d'une chaine de caractères).
	 */
	public String toString(){
		return this.value;
	}
	
}
