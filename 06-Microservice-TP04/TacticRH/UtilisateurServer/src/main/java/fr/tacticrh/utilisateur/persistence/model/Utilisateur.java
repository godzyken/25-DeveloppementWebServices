package fr.tacticrh.utilisateur.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * <b>ENTITE DU MODELE CONCEPTUEL DE DONNEES DE L'APPLICATION</b><br/>
 *    ENTITE : User<br/>
 *    <br/>
 * @author 1603599
 */
@EqualsAndHashCode(callSuper=true)
@Data
@OnDelete(action = OnDeleteAction.CASCADE)
@DiscriminatorValue("UTI")
@Entity
public class Utilisateur extends Personne implements Serializable {

	
	@Transient
	private static final long serialVersionUID = 1L;

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
	 * <br/>
	 * Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	@Transient
	private static final Logger LOGGER = LoggerFactory.getLogger(Utilisateur.class);

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false, unique = true)
    private String motDePasse;

    @ManyToOne(fetch=FetchType.EAGER)
    @JsonBackReference
    private Role role;

    
    /**
     * <b>CONSTRUCTEUR AVEC LES ARGUMENTS : AUCUN</b><br/>
     * <br/>
     */
    public Utilisateur() {
    }
    
    /**
     * <b>CONSTRUCTEUR AVEC LES ARGUMENTS : TOUS LES ATTRIBUTS</b><br/>
     * <br/>
     * @param pPersonne
     * @param pMail
     * @param pMotDePasse
     * @param pRole
     */
    public Utilisateur(Personne pPersonne
    					, String pMail, String pMotDePasse, Role pRole) {
    	
        super(pPersonne);

    	this.mail       = pMail;
        this.motDePasse = pMotDePasse;
        this.role       = pRole;
    }

    /**
     * <b>CONSTRUCTEUR DE RECOPIE</b><br/>
     * <br/>
     * @param pUser
     */
    public Utilisateur(Utilisateur pUser) {
    	
        super((Personne)pUser);

        this.mail       = pUser.getMail();
        this.motDePasse = pUser.getMotDePasse();
        this.role       = pUser.getRole();
    }
}
