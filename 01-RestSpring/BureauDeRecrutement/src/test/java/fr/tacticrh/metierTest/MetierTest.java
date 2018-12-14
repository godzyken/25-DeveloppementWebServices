/**
 * 
 */
package fr.tacticrh.metierTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tacticrh.constant.UtilisateurRole;
import fr.tacticrh.exception.candidat.InvalidArgumentCandidatException;
import fr.tacticrh.exception.candidature.IllegalTransactionCandidatureException;
import fr.tacticrh.exception.candidature.InvalidArgumentCandidatureException;
import fr.tacticrh.exception.curriculum.IllegalTransactionCurriculumException;
import fr.tacticrh.exception.curriculum.InvalidArgumentCurriculumException;
import fr.tacticrh.exception.motivation.InvalidArgumentMotivationException;
import fr.tacticrh.exception.personne.InvalidArgumentPersonneException;
import fr.tacticrh.exception.utilisateur.IllegalTransactionUtilisateurException;
import fr.tacticrh.exception.utilisateur.InvalidArgumentUtilisateurException;
import fr.tacticrh.metier.candidat.ICandidatMetier;
import fr.tacticrh.metier.candidature.ICandidatureMetier;
import fr.tacticrh.metier.curriculum.ICurriculumMetier;
import fr.tacticrh.model.Candidat;
import fr.tacticrh.model.Candidature;
import fr.tacticrh.model.Curriculum;
import fr.tacticrh.model.Motivation;


/**
 * @author Tcharou Dalgalian
 * 
 * <b>CLASSE QUI IMPLEMENTE LES TESTS SUR LES TRAITEMENTS METIER DE L'APPLICATION</b>
 */
@Service
public class MetierTest {
	
	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MetierTest.class);
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites metier relatives a l'entite 'Candidat'.
	 */
	@Autowired
	private ICandidatMetier candidatMetier;

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites metier relatives a l'entite 'Candidature'.
	 */
	@Autowired
	private ICandidatureMetier candidatureMetier;
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES :</b>
	 * <br/>Les fonctionnalites metier relatives a l'entite 'Curriculum'.
	 */
	@Autowired
	private ICurriculumMetier curriculumMetier;

	
	
	
	/**
	 * <b>METHODE QUI EXECUTE LES TESTS SUR LES TRAITEMENTS METIER DE L'APPLICATION.</b>
	 * <br/>TOUTES LES METHODES DE TEST (CI-DESSOUS) DOIVENT ETRE APPELEES ICI.
	 */
	public void execute () {

		LOGGER.info("CLASS : MetierTest -- METHOD : execute -- BEGIN");
		
		this.testerCandidatureAjouter();
		this.testerCurriculumRechercher();
		
		LOGGER.info("CLASS : MetierTest -- METHOD : execute -- END");
	}
	
	
	
	
	/**
	 * <b>METHODE QUI TESTE LES OPERATIONS SUIVANTES : </b> 
	 *     ->L'AJOUT D'UNE CANDIDATURE EN BDD.
	 *     ->CAS OU LA PERSONNE ET LE CANDIDAT NE SONT PAS PRESENTS EN BDD.
	 */
	private void testerCandidatureAjouter() {
		
		LOGGER.info("CLASS : MetierTest -- METHOD : testerCandidatureAjouter -- BEGIN");
		
		////////////////////////////////////////////////////////////////////////
		// (01.)CREER LES OBJETS SUIVANTS :
		//      ->UN CANDIDAT 
		//      ->UNE CANDIDATURE
		//      ->UN CURRICULUM
		//      ->UNE MOTIVATION
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+------------------------------------------------------------------------------------------------------------+");
		LOGGER.info("|                 (01.)CREATION DES OBJETS 'CANDIDAT', 'CANDIDATURE', 'CURRICULUM' ET 'MOTIVATION'           |");
		LOGGER.info("+------------------------------------------------------------------------------------------------------------+");
		Candidat candidatDB = new Candidat("M.","Bonneau", "Didier", 58, "03.67.15.25.18", "didier.bono@gmail.fr", "tttt");
		candidatDB.setRole(UtilisateurRole.CANDIDAT);
		
		Candidature candidatureOffre154 = new Candidature(154);
		
		File fileCurriculumDB  = new File (".\\cv\\CV-Didier.txt");
		File fileMotivationDB  = new File (".\\lm\\LM-Didier.txt");
		
		FileInputStream fileInputStreamCurriculumDB  = null;
		FileInputStream fileInputStreamMotivationDB  = null;
		
		try {
			fileInputStreamCurriculumDB  = new FileInputStream (fileCurriculumDB);
			fileInputStreamMotivationDB  = new FileInputStream (fileMotivationDB);
			
		} catch (FileNotFoundException fnfe) {
			LOGGER.info("Exception -- Creation d'un flux de lecture -- Message : " + fnfe.getMessage());
		}
		
		byte[] byteArrayCurriculumDB  = new byte [(int) fileCurriculumDB.length()];
		byte[] byteArrayMotivationDB  = new byte [(int) fileMotivationDB.length()];
		
		try {
			fileInputStreamCurriculumDB.read (byteArrayCurriculumDB );
			fileInputStreamMotivationDB.read (byteArrayMotivationDB );
			
		} catch (IOException ioe) {
			LOGGER.info("Exception -- Lecture d'un flux vers un tableau d'octets -- Message : " + ioe.getMessage());
		}
		
		Curriculum curriculumDB = new Curriculum("CV-Didier", "PDF", byteArrayCurriculumDB);
		Motivation motivationDB = new Motivation("LM-Didier", "DOC", byteArrayMotivationDB);
		
		////////////////////////////////////////////////////////////////////////
		// (02.)INSERER EN BDD LES OBJETS SUIVANTS :
		//      ->LE CANDIDAT CI-DESSUS
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+----------------------------------------------------------+");
		LOGGER.info("|                 (02.)INSERTION DU CANDIDAT               |");
		LOGGER.info("+----------------------------------------------------------+");
		Candidat candidatCreated = null;
		try {
			candidatCreated = candidatMetier.add(candidatDB);
			
		} catch (InvalidArgumentCandidatException e) {
			LOGGER.info("InvalidArgumentCandidatException -- Message : " + e.getMessage());
			
		} catch (InvalidArgumentUtilisateurException e) {
			LOGGER.info("InvalidArgumentUtilisateurException -- Message : " + e.getMessage());
			
		} catch (InvalidArgumentPersonneException e) {
			LOGGER.info("InvalidArgumentPersonneException -- Message : " + e.getMessage());

		} catch (IllegalTransactionUtilisateurException e) {
			LOGGER.info("IllegalTransactionUtilisateurException -- Message : " + e.getMessage());
		}

		////////////////////////////////////////////////////////////////////////
		// (03.)INSERER EN BDD LES OBJETS SUIVANTS :
		//      ->LA CANDIDATURE CI-DESSUS
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+----------------------------------------------------------------+");
		LOGGER.info("|                 (03.)INSERTION DE LA CANDIDATURE               |");
		LOGGER.info("+----------------------------------------------------------------+");
		Candidature candidatureCreated = null;
		
		try {
			candidatureCreated = candidatureMetier.add (candidatCreated.getId(), candidatureOffre154);
			
		} catch (InvalidArgumentCandidatException e) {
			LOGGER.info("InvalidArgumentCandidatException -- Message : " + e.getMessage());	
			
		} catch (InvalidArgumentCandidatureException e) {
			LOGGER.info("InvalidArgumentCandidatureException -- Message : " + e.getMessage());	
			
		} catch (IllegalTransactionCandidatureException e) {
			LOGGER.info("IllegalTransactionCandidatureException -- Message : " + e.getMessage());	
		}
		
		////////////////////////////////////////////////////////////////////////
		// (04.)INSERER EN BDD LES OBJETS SUIVANTS :
		//      ->LE CURRICULUM CI-DESSUS
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+----------------------------------------------------------------+");
		LOGGER.info("|                 (04.)INSERTION DU CURRICULUM                   |");
		LOGGER.info("+----------------------------------------------------------------+");
		
		try {
			candidatureMetier.addCurriculum (candidatureCreated.getId(), curriculumDB);
			
		} catch (InvalidArgumentCandidatureException e) {
			LOGGER.info("InvalidArgumentCandidatureException -- Message : " + e.getMessage());	
			
		} catch (InvalidArgumentCurriculumException e) {
			LOGGER.info("InvalidArgumentCurriculumException -- Message : " + e.getMessage());	
			
		} catch (IllegalTransactionCandidatureException e) {
			LOGGER.info("IllegalTransactionCandidatureException -- Message : " + e.getMessage());	
		}
		
		////////////////////////////////////////////////////////////////////////
		// (05.)INSERER EN BDD LES OBJETS SUIVANTS :
		//      ->LA MOTIVATION CI-DESSUS
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+----------------------------------------------------------------+");
		LOGGER.info("|                 (05.)INSERTION DE LA MOTIVATION                |");
		LOGGER.info("+----------------------------------------------------------------+");
		
		try {
			candidatureMetier.addMotivation (candidatureCreated.getId(), motivationDB);
			
		} catch (InvalidArgumentCandidatureException e) {
			LOGGER.info("InvalidArgumentCandidatureException -- Message : " + e.getMessage());	
			
		} catch (InvalidArgumentMotivationException e) {
			LOGGER.info("InvalidArgumentMotivationException -- Message : " + e.getMessage());	
			
		} catch (IllegalTransactionCandidatureException e) {
			LOGGER.info("IllegalTransactionCandidatureException -- Message : " + e.getMessage());	
		}
		
		LOGGER.info("CLASS : MetierTest -- METHOD : testerCandidatureAjouter -- END");
	}
	
	/**
	 * <b>METHODE QUI TESTE LES OPERATIONS SUIVANTES : </b> 
	 *     ->LA RECHERCHE D'UN CURRICULUM EN BDD.
	 *     ->CRITERE DE RECHERCHE : L'IDENTIFIANT DE LA CANDIDATURE
	 */
	private void testerCurriculumRechercher() {
		
		LOGGER.info("CLASS : MetierTest -- METHOD : testerCurriculumRechercher -- BEGIN");
		
		try {
			this.curriculumMetier.findByCandidatureId(Long.valueOf(4));
			
		} catch (InvalidArgumentCandidatureException e) {
			LOGGER.info("InvalidArgumentCandidatureException -- Message : " + e.getMessage());
			
		} catch (IllegalTransactionCurriculumException e) {
			LOGGER.info("IllegalTransactionCurriculumException -- Message : " + e.getMessage());
		}
		
		LOGGER.info("CLASS : MetierTest -- METHOD : testerCurriculumRechercher -- END");
	}
}
