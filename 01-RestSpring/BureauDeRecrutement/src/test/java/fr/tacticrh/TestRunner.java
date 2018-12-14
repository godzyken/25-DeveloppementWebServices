/**
 * 
 */
package fr.tacticrh;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <b>CLASSE QUI IMPLEMENTE LA METHODE DE LANCEMENT DE L'APPLICATION DE TEST</b>
 * 
 * @author chat_roux
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRunner {

	
	
	
	/**
	 * <b>METHODE DE LANCEMENT DE L'APPLICATION DE TEST</b>
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("CLASS : TestRunner -- METHOD : main -- BEGIN");

		ApplicationTest.main(args);
		
		System.out.println("CLASS : TestRunner -- METHOD : main -- END");
	}
}
