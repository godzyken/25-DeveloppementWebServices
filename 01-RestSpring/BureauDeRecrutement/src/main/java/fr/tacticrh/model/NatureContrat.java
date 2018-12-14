/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Tcharou DALGALIAN
 *
 * <br/><b>ENTITE : 'NATURE_CONTRAT'</b>
 */
@SuppressWarnings("serial")
@Entity
public class NatureContrat implements Serializable {

	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//strategie de generation de la clé primaire
	private Long id;
	
	private String libelle;

	
	@OneToMany(mappedBy = "natureContrat")
	private List<Contrat> contrats;
	
	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public NatureContrat() { super(); }

	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 *
	 * @param pLibelle
	 */
	public NatureContrat(String pLibelle) {
		super();
		this.libelle = pLibelle;
	}
	
	
	
	
	public Long          getId       () { return this.id;       }
	public String        getLibelle  () { return this.libelle;  }
	
	@JsonIgnore
	public List<Contrat> getContrats () { return this.contrats; }
	
	
	

	public void setId       (Long          pId      ) { this.id       = pId;       }
	public void setLibelle  (String        pLibelle ) { this.libelle  = pLibelle;  }
	public void setContrats (List<Contrat> pContrats) { this.contrats = pContrats; }
}
