/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>ENTITE : 'DISPONIBILITE'</b>
 */
@SuppressWarnings("serial")
@Entity
public class Disponibilite implements Serializable {
	
	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //strategie de generation de la clé primaire
	private Long id;
	
	private Date delai;
	
	@ManyToOne
	private Candidat candidat;

	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	
	public Disponibilite() { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 */
	
	public Disponibilite(Date pDelai) {
		super();
		this.delai = pDelai;
	}

	
	
	
	public Long     getId       () { return this.id;       }
	public Date     getDelai    () { return this.delai;    }
	
	public Candidat getCandidat () { return this.candidat; }

	
		
	
	public void setId       (Long     pId       ) { this.id       = pId;       }
	public void setDelai    (Date     pDelai    ) { this.delai    = pDelai;    }
	
	public void setCandidat (Candidat pCandidat ) { this.candidat = pCandidat; }
}
