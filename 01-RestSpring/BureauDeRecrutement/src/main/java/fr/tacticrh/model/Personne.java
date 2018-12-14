package fr.tacticrh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;



/**
 * @author 
 *
 * <br/><b>ENTITE : 'PERSONNE'</b>
 */
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_PERSONNE", discriminatorType=DiscriminatorType.STRING, length=5)
public abstract class Personne implements Serializable {
	
	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//strategie de generation de la clé primaire
	private Long id;
	
	private String civilite;
	private String nom;
	private String prenom;
	private int age;
	private String telephone;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String mail;
	
	

	
	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
	 */
	public Personne() { super(); }
	
	/**
	 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
	 *
	 * @param pCivilite
	 * @param pNom
	 * @param pPrenom
	 * @param pAge
	 * @param pTelephone
	 * @param pMail
	 */
	public Personne(String pCivilite, String pNom, String pPrenom, int pAge, String pTelephone, String pMail) {
		super();
		this.civilite  = pCivilite;
		this.nom       = pNom;
		this.prenom    = pPrenom;
		this.age       = pAge;
		this.telephone = pTelephone;
		this.mail      = pMail;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC DES ARGUMENTS DE TYPE ENTITE</b>
	 * 
	 * @param pPersonne
	 */
	public Personne(Personne pPersonne) {
		super();
		this.civilite  = pPersonne.getCivilite();
		this.nom       = pPersonne.getNom();
		this.prenom    = pPersonne.getPrenom();
		this.age       = pPersonne.getAge();
		this.telephone = pPersonne.getTelephone();
		this.mail      = pPersonne.getMail();
	}

	
	
	
	public Long     getId        () { return this.id;        }
	public String   getCivilite  () { return this.civilite;  }
	public String   getNom       () { return this.nom;       }
	public String   getPrenom    () { return this.prenom;    }
	public int      getAge       () { return this.age;       }
	public String   getTelephone () { return this.telephone; }
	public String   getMail      () { return this.mail;      }
	
	
	
	
	public void setId       (Long     pId       ) { this.id        = pId;        }
	public void setCivilite (String   pCivilite ) { this.civilite  = pCivilite;  }
	public void setNom      (String   pNom      ) { this.nom       = pNom;       }
	public void setPrenom   (String   pPrenom   ) { this.prenom    = pPrenom;    }
	public void setAge      (int      pAge      ) { this.age       = pAge;       }
	public void setTelephone(String   pTelephone) { this.telephone = pTelephone; }
	public void setMail     (String   pMail     ) { this.mail      = pMail;      }
}
