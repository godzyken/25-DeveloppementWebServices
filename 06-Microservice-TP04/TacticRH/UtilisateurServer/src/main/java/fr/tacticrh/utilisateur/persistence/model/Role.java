package fr.tacticrh.utilisateur.persistence.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collection;

/**
 * <b>ENTITE DU MODELE CONCEPTUEL DE DONNEES DE L'APPLICATION</b><br/>
 *    ENTITE : Role<br/>
 *    <br/>
 * @author 1603599
 */
@Data
@Entity
public class Role implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
	 * <br/>
	 * Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	@Transient
	private static final Logger LOGGER = LoggerFactory.getLogger(Role.class);
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "role")
    @JsonManagedReference
    private Collection<Utilisateur> utilisateurs;

    
    /**
     * <b>CONSTRUCTEUR AVEC LES ARGUMENTS : AUCUN</b><br/>
     * <br/>
     */
    public Role() {
    }

    /**
     * <b>CONSTRUCTEUR AVEC LES ARGUMENTS : TOUS LES ATTRIBUTS</b><br/>
     * <br/>
     * @param pId
     * @param pLibelle
     */
    public Role(Long pId, String pLibelle) {
    	
        this.id      = pId;
        this.libelle = pLibelle;
    }

    /**
     * <b>CONSTRUCTEUR AVEC LES ARGUMENTS : TOUS LES ATTRIBUTS SAUF L'ID</b><br/>
     * <br/>
     * @param pLibelle
     */
    public Role(String pLibelle) {
    	
        this.libelle = pLibelle;
    }
    
    public Long   getId      () { return this.id;      }
    public String getLibelle () { return this.libelle; }

    public void setId      (Long   pId     ) { this.id      = pId;      }
    public void setLibelle (String pLibelle) { this.libelle = pLibelle; }


    @Override
    public String toString() {
        return "Role {" 
        				   + "id"      + "='" + this.id      + "'"
        			+ ", " + "libelle" + "='" + this.libelle + "'"
        			+ '}';
    }
}