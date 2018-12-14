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
 * <br/><b>ENTITE : 'CONTRAT'</b>
 */
@SuppressWarnings("serial")
@Entity
public class Contrat implements Serializable {
	
	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //strategie de generation de la clé primaire
	private Long id;

	
	@ManyToOne
	private ExperienceProfessionnelle experienceProfessionnelle;

	@ManyToOne
	private TypeContrat typeContrat;
	
	@ManyToOne
	private NatureContrat natureContrat;

	
	
	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Contrat() { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 */

	
	
	
	public Long                      getId                        () { return this.id;	                      }
	
	public ExperienceProfessionnelle getExperienceProfessionnelle () { return this.experienceProfessionnelle; }
	public TypeContrat               getTypeContrat               () { return this.typeContrat;               }
	public NatureContrat             getNatureContrat             () { return this.natureContrat;             }

	
	
	
	public void setId                        (Long pId                                            ) { this.id                        = pId;                        }
	
	public void setExperienceProfessionnelle (ExperienceProfessionnelle pExperienceProfessionnelle) { this.experienceProfessionnelle = pExperienceProfessionnelle; }
	public void setTypeContrat               (TypeContrat               pTypeContrat              ) { this.typeContrat               = pTypeContrat;               }
	public void setNatureContrat             (NatureContrat             pNatureContrat            ) { this.natureContrat             = pNatureContrat;             }
}

