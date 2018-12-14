/**
 * 
 */
package fr.tacticrh.constant;

/**
 * @author Tcharou Dalgalian
 *
 * <b>L'ENUMERATION DE TOUTES LES VALEURS POSSIBLES DE LA DONNEE SUIVANTE :</b>
 * <br/>L'ATTRIBUT 'COMPETENCE-NIVEAU' DE L'OBJET 'COMPETENCE-EXPERIENCE-PROFESSIONNELLE'
 */
public enum CompetenceNiveau {

	
	
	
	///////////////////////////////////////////////////////////////////////////
	//(1.)OBJETS DIRECTEMENT CONSTRUITS
	///////////////////////////////////////////////////////////////////////////
	DEBUTANT             ("Débutant(e)"  ),
	INTERMEDIAIRE        ("Intermédiaire"),
	CONFIRME             ("Confirmé(e)"  ),
	EXPERT               ("Expert(e)"    );
	
	
	
	
	/**
	 * <b>LA VALEUR DE L'ELEMENT ENUMERE</b>
	 */
	private String value = null;
	   
	
	
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENT</b>
	 */
	CompetenceNiveau(String pValue){
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
