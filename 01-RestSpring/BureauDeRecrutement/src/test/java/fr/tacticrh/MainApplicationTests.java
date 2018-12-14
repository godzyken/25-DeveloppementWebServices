package fr.tacticrh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tacticrh.daoTest.DaoTest;
import fr.tacticrh.metierTest.MetierTest;



/**
 * <b>CLASSE QUI IMPLEMENTE LA METHODE D'ENTREE DE L'APPLICATION DE TEST</b>
 * 
 * @author 1603599
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTests implements CommandLineRunner {

	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MainApplicationTests.class);
	
	/**
	 * <b>UN OBJET DE TYPE 'DAO-TEST'.</b>
	 */
	@Autowired
	private DaoTest daoTest;

	/**
	 * <b>UN OBJET DE TYPE 'METIER-TEST'.</b>
	 */
	@Autowired
	private MetierTest metierTest;

	

	
	/**
	 * <b>METHODE D'ENTREE DE L'APPLICATION DE TEST</b>
	 * @param args
	 */
	public static void main(String[] args) {
		
		LOGGER.info("CLASS : MainApplicationTests -- METHOD : main -- BEGIN");
		
		ApplicationContext applicationContext = SpringApplication.run(MainApplicationTests.class, args);
		
		afficherBeans(applicationContext);
		
		LOGGER.info("CLASS : MainApplicationTests -- METHOD : main -- END");
	}

	/**
	 * <b>METHODE PRINCIPALE DE L'APPLICATION DE TEST</b>
	 * @param args Une liste d'arguments.
	 */
	@Override
	public void run(String... arg0) throws Exception {
		
		LOGGER.info("CLASS : MainApplicationTests -- METHOD : run -- BEGIN");
		
		LOGGER.info("CLASS : MainApplicationTests -- METHOD : run -- END");
	}
	
	/**
	 * <b>METHODE QUI EXECUTE L'INTEGRALITE DES TESTS SUR L'APPLICATION.</b>
	 */
	@Test
	public void contextLoads() {
		
		LOGGER.info("CLASS : MainApplicationTests -- METHOD : contextLoads -- BEGIN");

		// LANCER LA SEQUENCE DES TESTS SUR LES DAO.
		this.daoTest.execute();
		
		// LANCER LA SEQUENCE DES TESTS SUR LES TRAITEMENTS METIER.
		this.metierTest.execute();
		
		LOGGER.info("CLASS : MainApplicationTests -- METHOD : contextLoads -- END");
	}
	

	
	/**
	 * <b>AFFICHER LA LISTE DES BEANS DU CONTEXTE DE L'APPLICATION DE TEST.</b>
	 * 
	 * @param pApplicationContext Le contexte de l'application.
	 */
	private static void afficherBeans(ApplicationContext pApplicationContext) {
		
		LOGGER.info("CLASS : MainApplicationTests -- METHOD : afficherBeans -- BEGIN");
		
		String[] beanNames = pApplicationContext.getBeanDefinitionNames();
		
		LOGGER.info("+-------------------------------------------------------------------------------+");
		LOGGER.info("| APPLICATION-CONTEXT : BEANS LIST                                              |");
		LOGGER.info("+-------------------------------------------------------------------------------+");
		for(String beanName : beanNames) {
			LOGGER.info("| beanName : [" + beanName + "]");
		}
		LOGGER.info("+-------------------------------------------------------------------------------+");
		
		LOGGER.info("CLASS : MainApplicationTests -- METHOD : afficherBeans -- END");
	}
}
