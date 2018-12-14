/**
 * 
 */
package fr.tacticrh.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Franck Taba Taba 
 *
 * <br/><b>ENTITE : 'LOGICIEL'</b>
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("LOGIC")
public class Logiciel extends Competence {

	
	
	
	private String libelle;

	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Logiciel() { super(); }

	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 * @param pLibelle
	 */
	public Logiciel(String pLibelle) {
		super();
		this.libelle = pLibelle;
	}

	
	
	
	public String getLibelle () { return this.libelle; }

	
	
	
	public void setLibelle (String pLibelle) { this.libelle = pLibelle; }
}
