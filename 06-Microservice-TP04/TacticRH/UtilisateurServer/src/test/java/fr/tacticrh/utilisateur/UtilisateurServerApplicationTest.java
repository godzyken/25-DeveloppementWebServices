package fr.tacticrh.utilisateur;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tacticrh.utilisateur.persistence.dao.DaoTest;


/**
 * <b>COMPOSANT POSSEDANT LES FONCTIONNALITES CI-DESSOUS:</b><br/>
 * <br/>
 * ->LES FONCTIONNALITES DE TEST DES DIFFERENTES COUCHES APPLICATIVES.<br/>
 * ->COUCHES APPLICATIVES : 'business', 'persistence'.<br/> 
 */    
@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilisateurServerApplicationTest {

	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
	 * <br/>
	 * Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurServerApplicationTest.class);

	/**
	 * <b>COMPOSANT DE PERSISTANCE RELATIF A L'ENTITE CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->ENTITE : 'Utilisateur'.<br/> 
	 */    
    @Autowired
    private DaoTest utilisateurDaoTest;
    
    
	@Test
	public void contextLoads() {
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : contextLoads -- BEGIN");
		
		this.utilisateurDaoTest.execute();
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : contextLoads -- END");
	}
}
