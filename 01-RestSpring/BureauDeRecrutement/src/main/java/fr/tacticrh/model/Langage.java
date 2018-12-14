/**
 * 
 */
package fr.tacticrh.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Franck Taba Taba 
 *
 * <br/><b>ENTITE : 'LANGAGE'</b>
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("LANGA")
public class Langage extends Competence {

	
	
	
	private String libelle;

	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Langage() { super(); }

	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 * 
	 * @param pLibelle
	 */
	public Langage(String pLibelle) {
		super();
		this.libelle = pLibelle;
	}

	
	
	
	public String getLibelle () { return this.libelle; }

	
	
	
	public void setLibelle (String pLibelle) { this.libelle = pLibelle; }
}
