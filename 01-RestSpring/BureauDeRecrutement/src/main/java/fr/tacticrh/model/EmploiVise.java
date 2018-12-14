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
 * <br/><b>ENTITE : 'EMPLOI_VISE'</b>
 */
@SuppressWarnings("serial")
@Entity
public class EmploiVise implements Serializable {
		
		
		
	
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//strategie de generation de la clé primaire
		private Long id;
		
		private String libelle;
		private int salaire;
		
		@ManyToOne
		private Candidat candidat;
		
		
		
				
		/**
		 * <b>CONSTRUCTEUR SANS ARGUMENTS</b>
		 */
		public EmploiVise() { super(); }
		
		/**
		 * <b>CONSTRUCTEUR AVEC ARGUMENTS</b>
		 *
		 * @param pLibelle
		 * @param pSalaire
		 */
		public EmploiVise(String pLibelle, int pSalaire) {
			super();
			this.libelle = pLibelle;
			this.salaire = pSalaire;
		}

		
		
		
		public Long     getId       () { return this.id;       }
		public String   getLibelle  () { return this.libelle;  }
		public int      getSalaire  () { return this.salaire;  }
		
		public Candidat getCandidat () { return this.candidat; }


		
		
		public void setId       (Long     pId         ) { this.id       = pId;          }
		public void setLibelle  (String   pEmploiVise ) { this.libelle  = pEmploiVise;  }
		public void setSalaire  (int      pSalaireVise) { this.salaire  = pSalaireVise; }
		
		public void setCandidat (Candidat pCandidat   ) { this.candidat = pCandidat;    }
}
