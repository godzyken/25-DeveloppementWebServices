/**
 * 
 */
package fr.tacticrh.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Franck Taba Taba
 *
 *<br/><b>ENTITE : 'Langue'</b>
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("LANGU")
public class Langue extends Competence {

	
		
	
	private String libelle;


	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Langue() { super();	}

	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 * @param pLibelle
	 */
	public Langue(String libelle) {
		super();
		
		this.libelle = libelle;
	}

	
	
	
	public String getLibelle() {return libelle;	}


	
	
	public void setLibelle(String libelle) {this.libelle = libelle;}
}
