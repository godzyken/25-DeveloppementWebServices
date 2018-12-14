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
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Franck Taba Taba
 *
 * <br/><b>ENTITE : 'MOTIVATION'</b>
 */
@SuppressWarnings("serial")
@Entity
public class Motivation implements Serializable {
	
	

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//strategie de generation de la clé primaire
	private Long id;
	
	private String nom;
	private String format;
	
	@Lob
	private byte[] fichier;
	
	@OneToMany(mappedBy = "motivation")
	private List<Candidature> candidatures;
	
	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Motivation() { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 *
	 * @param pNom
	 * @param pFormat
	 * @param pFichier
	 */
	public Motivation(String pNom, String pFormat, byte[] pFichier) {
		super();
		this.nom = pNom;
		this.format = pFormat;
		this.fichier = pFichier;
	}

		


	public Long              getId           () { return this.id;           }
	public String            getNom          () { return this.nom;          }
	public String            getFormat       () { return this.format;       }
	public byte[]            getFichier      () { return this.fichier;      }
	
	@JsonIgnore
	public List<Candidature> getCandidatures () { return this.candidatures; }
	
	
	

	public void setId           (Long              pId           ) { this.id           = pId;            }
	public void setNom          (String            pNomMotivation) { this.nom          = pNomMotivation; }
	public void setFormat       (String            pFormat       ) { this.format       = pFormat;        }
	public void setFichier      (byte[]            pFichier      ) { this.fichier      = pFichier;       }
	
	public void setCandidatures (List<Candidature> pCandidatures ) { this.candidatures = pCandidatures;  }
}
