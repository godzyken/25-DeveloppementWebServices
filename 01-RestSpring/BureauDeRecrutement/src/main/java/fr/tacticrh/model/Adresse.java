/**
 * 
 */
package fr.tacticrh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Franck Taba Taba 
 *
 * <br/><b>ENTITE : 'ADRESSE'</b>
 */
@SuppressWarnings("serial")
@Entity
public class Adresse implements Serializable {
	
	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //strategie de generation de la clé primaire
	private Long id;
	
	private int codePostal;
	private String ville;
	private String rue;
	private int numeroRue;

	@ManyToOne
	private Candidat candidat;
	
	
	

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	
	public Adresse() { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 *
	 * @param pCodePostal
	 * @param pVille
	 * @param pRue
	 * @param pNumeroRue
	 */
	public Adresse(int pCodePostal, String pVille, String pRue, int pNumeroRue) {
		super();
		this.codePostal = pCodePostal;
		this.ville = pVille;
		this.rue = pRue;
		this.numeroRue = pNumeroRue;
	}

	
	
	
	public Long     getId         () { return this.id;     	   }
	public int      getCodePostal () { return this.codePostal; }
	public String   getVille      () { return this.ville;	   }
	public String   getRue        () { return this.rue;        }
	public int      getNumeroRue  () { return this.numeroRue;  }
	
	public Candidat getCandidat   () { return this.candidat;   }

	
	
	
	public void setId         (Long     pId        ) { this.id         = pId;         }
	public void setCodePostal (int      pCodePostal) { this.codePostal = pCodePostal; }
	public void setVille      (String   pVille     ) { this.ville      = pVille;      }
	public void setRue        (String   pRue       ) { this.rue        = pRue;        }
	public void setNumeroRue  (int      pNumeroRue ) { this.numeroRue  = pNumeroRue;  }
	
	public void setCandidat   (Candidat pCandidat  ) { this.candidat   = pCandidat;   }
}
