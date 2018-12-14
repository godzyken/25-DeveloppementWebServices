/**
 * 
 */
package fr.tacticrh.daoTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tacticrh.constant.CompetenceNiveau;
import fr.tacticrh.dao.IAdministrateurDao;
import fr.tacticrh.dao.IAdresseDao;
import fr.tacticrh.dao.ICandidatDao;
import fr.tacticrh.dao.ICandidatureDao;
import fr.tacticrh.dao.ICompetenceDao;
import fr.tacticrh.dao.ICurriculumDao;
import fr.tacticrh.dao.IDisponibiliteDao;
import fr.tacticrh.dao.IEmploiViseDao;
import fr.tacticrh.dao.IExperienceProfessionnelleDao;
import fr.tacticrh.dao.IFormationDao;
import fr.tacticrh.dao.IManagerDao;
import fr.tacticrh.dao.IMotivationDao;
import fr.tacticrh.dao.IPersonneDao;
import fr.tacticrh.dao.IUtilisateurDao;
import fr.tacticrh.model.Administrateur;
import fr.tacticrh.model.Adresse;
import fr.tacticrh.model.Candidat;
import fr.tacticrh.model.Candidature;
import fr.tacticrh.model.Competence;
import fr.tacticrh.model.Curriculum;
import fr.tacticrh.model.Disponibilite;
import fr.tacticrh.model.EmploiVise;
import fr.tacticrh.model.ExperienceProfessionnelle;
import fr.tacticrh.model.Formation;
import fr.tacticrh.model.Langage;
import fr.tacticrh.model.Langue;
import fr.tacticrh.model.Logiciel;
import fr.tacticrh.model.Manager;
import fr.tacticrh.model.Motivation;
import fr.tacticrh.model.Personne;
import fr.tacticrh.model.Utilisateur;




/**
 * @author Franck Taba Taba
 * 
 * <b>CLASSE QUI IMPLEMENTE LES TESTS DES DAO DE L'APPLICATION.</b>
 */
@Service
public class DaoTest {
	
	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DaoTest.class);
	
	
	@Autowired
	private IPersonneDao personneDao;
	
	@Autowired
	private IUtilisateurDao utilisateurDao;

	@Autowired
	private ICandidatDao candidatDao;
	
	@Autowired
	private IManagerDao managerDao;
	
	@Autowired
	private IAdministrateurDao administrateurDao;
	
	@Autowired
	private ICandidatureDao candidatureDao;

	@Autowired
	private ICurriculumDao curriculumDao;

	@Autowired
	private IMotivationDao motivationDao;

	@Autowired
	private IAdresseDao adresseDao;

	@Autowired
	private IEmploiViseDao emploiViseDao;
	
	@Autowired
	private IDisponibiliteDao disponibiliteDao;
	
	@Autowired
	private IFormationDao formationDao;	
	
	@Autowired
	private IExperienceProfessionnelleDao experienceProfessionnelleDao;
	
	@Autowired
	private ICompetenceDao competenceDao;
	
	
	
	
	
	/**
	 * <b>METHODE QUI EXECUTE LES TESTS DES DAO DE L'APPLICATION.</b>
	 */
	public void execute () {

		LOGGER.info("CLASS : DaoTest -- METHOD : execute -- BEGIN");
		
		LOGGER.info("+-----------------------------------------------------------+");
		LOGGER.info("|                 (01.)CREATION DES OBJETS                  |");
		LOGGER.info("+-----------------------------------------------------------+");
		
		////////////////////////////////////////////////////////////////////////
		//(01.01)CREER DES CANDIDATS
		////////////////////////////////////////////////////////////////////////
		Candidat candidatPK  = new Candidat("M.", "Kabeya"   , "Patrick", 40, "01.43.82.82.82", "patrick.kabeya@hotmail.com"   , "xxxx");
		Candidat candidatFTT = new Candidat("M.", "Taba Taba", "Franck" , 43, "01.43.82.82.82", "franck.tabataba@hotmail.com"  , "yyyy");
		Candidat candidatTD  = new Candidat("M.", "Dalgalian", "Tcharou", 48, "07.83.41.59.92", "tcharou.dalgalian@hotmail.com", "zzzz");
		
		candidatPK.setDateInscription  (new Date());
		candidatFTT.setDateInscription (new Date());
		candidatTD.setDateInscription  (new Date());
		
		List<Candidat> candidats = new ArrayList<Candidat>();
		
		candidats.add (candidatPK );
		candidats.add (candidatFTT);
		candidats.add (candidatTD );

		////////////////////////////////////////////////////////////////////////
		//(01.02)CREER DES MANAGERS
		////////////////////////////////////////////////////////////////////////
		Manager managerGDG  = new Manager("M.", "De Gestas"  , "Ghislain", 40, "01.47.10.10.10", "ghislain.degestas@hotmail.com"   , "aaaa");

		managerGDG.setDateInscription  (new Date());

		List<Manager> managers = new ArrayList<Manager>();
		
		managers.add(managerGDG);
		
		////////////////////////////////////////////////////////////////////////
		//(01.03)CREER DES ADMINISTRATEURS
		////////////////////////////////////////////////////////////////////////
		Administrateur administrateurGDG  = new Administrateur("M.", "Clotaire", "Patrice" , 35, "01.15.58.35.67", "patrice.clotaire@hotmail.com"  , "aaaa");

		administrateurGDG.setDateInscription  (new Date());
		
		List<Administrateur> administrateurs = new ArrayList<Administrateur>();
		
		administrateurs.add(administrateurGDG);

		////////////////////////////////////////////////////////////////////////
		//(01.04.)CREER DES CANDIDATURES
		////////////////////////////////////////////////////////////////////////
		Candidature candidaturePK01  = new Candidature (Long.valueOf (0001));
		Candidature candidaturePK02  = new Candidature (Long.valueOf (0002));
		Candidature candidatureFTT01 = new Candidature (Long.valueOf (0003));
		Candidature candidatureFTT02 = new Candidature (Long.valueOf (0004));
		Candidature candidatureTD01  = new Candidature (Long.valueOf (0005));
		
		candidaturePK01.setDateDepot  (new Date());
		candidaturePK02.setDateDepot  (new Date());
		candidatureFTT01.setDateDepot (new Date());
		candidatureFTT02.setDateDepot (new Date());
		candidatureTD01.setDateDepot  (new Date());
		
		List<Candidature> candidatures = new ArrayList<Candidature>();
		
		candidatures.add (candidaturePK01 );
		candidatures.add (candidaturePK02 );
		candidatures.add (candidatureFTT01);
		candidatures.add (candidatureFTT02);
		candidatures.add (candidatureTD01 );
		
		////////////////////////////////////////////////////////////////////////
		//(01.05.)CREER DES CURRICULUMS	
		////////////////////////////////////////////////////////////////////////
		//File fileCurriculumPK  = new File ("C:\\Users\\AA\\Workspaces\\01-RestSpring\\BureauDeRecrutement\\cv\\CV-Patrick.txt");
		//File fileCurriculumFTT = new File ("C:\\Users\\AA\\Workspaces\\01-RestSpring\\BureauDeRecrutement\\cv\\CV-Franck.txt" );
		//File fileCurriculumTD  = new File ("C:\\Users\\AA\\Workspaces\\01-RestSpring\\BureauDeRecrutement\\cv\\CV-Tcharou.txt");

		File fileCurriculumPK  = new File (".\\cv\\CV-Patrick.txt");
		File fileCurriculumFTT = new File (".\\cv\\CV-Franck.txt" );
		File fileCurriculumTD  = new File (".\\cv\\CV-Tcharou.txt");
		
		FileInputStream fileInputStreamCurriculumPK  = null;
		FileInputStream fileInputStreamCurriculumFTT = null;
		FileInputStream fileInputStreamCurriculumTD  = null;
		
		try {
			fileInputStreamCurriculumPK  = new FileInputStream (fileCurriculumPK );
			fileInputStreamCurriculumFTT = new FileInputStream (fileCurriculumFTT);
			fileInputStreamCurriculumTD  = new FileInputStream (fileCurriculumTD );
			
		} catch (FileNotFoundException fnfe) {
			LOGGER.info("Exception -- Creation d'un flux de lecture -- Message : " + fnfe.getMessage());
		}
		
		byte[] byteArrayCurriculumPK  = new byte [(int) fileCurriculumPK.length() ];
		byte[] byteArrayCurriculumFTT = new byte [(int) fileCurriculumFTT.length()];
		byte[] byteArrayCurriculumTD  = new byte [(int) fileCurriculumTD.length() ];

		try {
			fileInputStreamCurriculumPK.read  (byteArrayCurriculumPK );
			fileInputStreamCurriculumFTT.read (byteArrayCurriculumFTT);
			fileInputStreamCurriculumTD.read  (byteArrayCurriculumTD );
			
		} catch (IOException ioe) {
			LOGGER.info("Exception -- Lecture d'un flux vers un tableau d'octets -- Message : " + ioe.getMessage());
		}
		
		Curriculum curriculumPK  = new Curriculum ("CV-Patrick", "pdf", byteArrayCurriculumPK );
		Curriculum curriculumFTT = new Curriculum ("CV-Franck" , "pdf", byteArrayCurriculumFTT);
		Curriculum curriculumTD  = new Curriculum ("CV-Tcharou", "pdf", byteArrayCurriculumTD );
		
		List<Curriculum> curriculums = new ArrayList<Curriculum>();
		
		curriculums.add (curriculumPK );
		curriculums.add (curriculumFTT);
		curriculums.add (curriculumTD );
		
		////////////////////////////////////////////////////////////////////////
		//(01.06.)CREER DES MOTIVATIONS	
		////////////////////////////////////////////////////////////////////////
		//File fileMotivationPK  = new File ("C:\\Users\\AA\\Workspaces\\01-RestSpring\\BureauDeRecrutement\\lm\\LM-Patrick.txt");
		//File fileMotivationFTT = new File ("C:\\Users\\AA\\Workspaces\\01-RestSpring\\BureauDeRecrutement\\lm\\LM-Franck.txt" );
		//File fileMotivationTD  = new File ("C:\\Users\\AA\\Workspaces\\01-RestSpring\\BureauDeRecrutement\\lm\\LM-Tcharou.txt");

		File fileMotivationPK  = new File (".\\lm\\LM-Patrick.txt");
		File fileMotivationFTT = new File (".\\lm\\LM-Franck.txt" );
		File fileMotivationTD  = new File (".\\lm\\LM-Tcharou.txt");

		FileInputStream fileInputStreamMotivationPK  = null;
		FileInputStream fileInputStreamMotivationFTT = null;
		FileInputStream fileInputStreamMotivationTD  = null;

		try {
			fileInputStreamMotivationPK = new FileInputStream  (fileMotivationPK );
			fileInputStreamMotivationFTT = new FileInputStream (fileMotivationFTT);
			fileInputStreamMotivationTD = new FileInputStream  (fileMotivationTD );
			
		} catch (FileNotFoundException fnfe) {
			LOGGER.info("Exception -- Creation d'un flux de lecture -- Message : " + fnfe.getMessage());
		}
		
		byte[] byteArrayMotivationPK  = new byte[(int) fileMotivationPK.length() ];
		byte[] byteArrayMotivationFTT = new byte[(int) fileMotivationFTT.length()];
		byte[] byteArrayMotivationTD  = new byte[(int) fileMotivationTD.length() ];
		
		try {
			fileInputStreamMotivationPK.read  (byteArrayMotivationPK );
			fileInputStreamMotivationFTT.read (byteArrayMotivationFTT);
			fileInputStreamMotivationTD.read  (byteArrayMotivationTD );
			
		} catch (IOException ioe) {
			LOGGER.info("Exception -- Lecture d'un flux vers un tableau d'octets -- Message : " + ioe.getMessage());
		}
		
		Motivation motivationPK  = new Motivation ("LM-Patrick", "doc", byteArrayMotivationPK );
		Motivation motivationFTT = new Motivation ("LM-Franck" , "doc", byteArrayMotivationFTT);
		Motivation motivationTD  = new Motivation ("LM-Tcharou", "doc", byteArrayMotivationTD );
		
		List<Motivation> motivations = new ArrayList<Motivation>();
		
		motivations.add (motivationPK );
		motivations.add (motivationFTT);
		motivations.add (motivationTD );
		
		////////////////////////////////////////////////////////////////////////
		//(01.07.)CREER DES ADRESSES	
		////////////////////////////////////////////////////////////////////////
		Adresse adressePK  = new Adresse (37000, "Tours"     , "rue du Pont Wilson", 1);
		Adresse adresseFTT = new Adresse (67000, "Strasbourg", "rue Eurometropole" , 1);
		Adresse adresseTD  = new Adresse (75020, "Paris"     , "Square Got"        , 1);
		
		List<Adresse> adresses = new ArrayList<Adresse>();
		
		adresses.add (adressePK );
		adresses.add (adresseFTT);
		adresses.add (adresseTD );
		
		////////////////////////////////////////////////////////////////////////
		//(01.08.)CREER DES EMPLOI_VISES	
		////////////////////////////////////////////////////////////////////////
		EmploiVise emploiVisePK  = new EmploiVise ("Pharmacien", 35000);
		EmploiVise emploiViseFTT = new EmploiVise ("Comptable" , 35000);
		EmploiVise emploiViseTD  = new EmploiVise ("Traducteur", 35000);
		
		List<EmploiVise> emploiVises = new ArrayList<EmploiVise>();
		
		emploiVises.add (emploiVisePK );
		emploiVises.add (emploiViseFTT);
		emploiVises.add (emploiViseTD );

		////////////////////////////////////////////////////////////////////////
		//(01.09.)CREER DES DISPONIBILITES	
		////////////////////////////////////////////////////////////////////////
		Disponibilite disponibilitePK  = new Disponibilite (new Date());
		Disponibilite disponibiliteFTT = new Disponibilite (new Date());
		Disponibilite disponibiliteTD  = new Disponibilite (new Date());
		
		List<Disponibilite> disponibilites = new ArrayList<Disponibilite>();
		
		disponibilites.add (disponibilitePK );
		disponibilites.add (disponibiliteFTT);
		disponibilites.add (disponibiliteTD );
		
		////////////////////////////////////////////////////////////////////////
		//(01.10.)CREER DES FORMATIONS	
		////////////////////////////////////////////////////////////////////////
		Formation formationDevCpp    = new Formation ("Developpeur", "Bac+2", "C++"    , new Date());
		Formation formationDevJava   = new Formation ("Developpeur", "Bac+2", "Java"   , new Date());
		Formation formationDevNTiers = new Formation ("Developpeur", "Bac+4", "N-Tiers", new Date());
		
		List<Formation> formationsCursusComplet = new ArrayList<Formation>();
		List<Formation> formationsCursusAvance  = new ArrayList<Formation>();
		
		formationsCursusComplet.add (formationDevCpp   );
		formationsCursusComplet.add (formationDevJava  );
		formationsCursusComplet.add (formationDevNTiers);
		formationsCursusAvance.add  (formationDevNTiers);		
				
		////////////////////////////////////////////////////////////////////////
		//(01.11.)CREER DES EXPERIENCES_PROFESSIONNELLES
		////////////////////////////////////////////////////////////////////////
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
		
		Date date01_Debut = null;
		Date date01_Fin   = null;
		Date date02_Debut = null;
		Date date02_Fin   = null;

		try {
			date01_Debut = format.parse ("14/04/2010");
			date01_Fin   = format.parse ("25/05/2012");
			date02_Debut = format.parse ("03/03/2012");
			date02_Fin   = format.parse ("14/08/2015");
			
		} catch (ParseException e) {
			LOGGER.info("Exception -- Message : " + e.getMessage()); 
		}
		LOGGER.info("=> Date construite : " + date01_Debut); 
		LOGGER.info("=> Date construite : " + date01_Fin  ); 
		LOGGER.info("=> Date construite : " + date02_Debut); 
		LOGGER.info("=> Date construite : " + date02_Fin  ); 

	    ExperienceProfessionnelle experienceProfessionnelleSanofi      = new ExperienceProfessionnelle ("SANOFI"      , "SUPERVISEUR"        , date01_Debut, date01_Fin, "MARSEILLE"  );
	    ExperienceProfessionnelle experienceProfessionnelleBoulanger   = new ExperienceProfessionnelle ("BOULANGER"   , "CHEF DE RAYON"      , date02_Debut, date02_Fin, "STRASBOURG" );
	    ExperienceProfessionnelle experienceProfessionnelleOptique2000 = new ExperienceProfessionnelle ("OPTIQUE 2000", "RESPONSABLE MAGASIN", date01_Debut, date01_Fin, "PARIS"      );
	    ExperienceProfessionnelle experienceProfessionnelleCetelem     = new ExperienceProfessionnelle ("CETELEM"     , "Developpeur"        , date02_Debut, date02_Fin, "SAINT-OUEN" );
	    ExperienceProfessionnelle experienceProfessionnelleAirFrance   = new ExperienceProfessionnelle ("AIR FRANCE"  , "Developpeur"        , date01_Debut, date01_Fin, "ORLY"       );
	    ExperienceProfessionnelle experienceProfessionnelleNatixis     = new ExperienceProfessionnelle ("NATIXIS"     , "Developpeur"        , date02_Debut, date02_Fin, "CHARENTON"  );

	    List<ExperienceProfessionnelle> experienceProfessionnellesPK   = new ArrayList<ExperienceProfessionnelle>();
	    List<ExperienceProfessionnelle> experienceProfessionnellesFTT  = new ArrayList<ExperienceProfessionnelle>();
	    List<ExperienceProfessionnelle> experienceProfessionnellesTD   = new ArrayList<ExperienceProfessionnelle>();
		
	    experienceProfessionnellesPK.add  (experienceProfessionnelleSanofi     );
	    experienceProfessionnellesPK.add  (experienceProfessionnelleBoulanger  );
		experienceProfessionnellesFTT.add (experienceProfessionnelleOptique2000);
		experienceProfessionnellesFTT.add (experienceProfessionnelleCetelem    );
		experienceProfessionnellesTD.add  (experienceProfessionnelleAirFrance  );
		experienceProfessionnellesTD.add  (experienceProfessionnelleNatixis    );

		////////////////////////////////////////////////////////////////////////
		//(01.12.)CREER DES COMPETENCES
		////////////////////////////////////////////////////////////////////////
		Competence competenceCpp      = new Langage  ("C++"     );
		Competence competenceJava     = new Langage  ("Java"    );
		Competence competenceAnglais  = new Langue   ("Anglais" );
		Competence competenceFrancais = new Langue   ("Francais");
		Competence competenceSage     = new Logiciel ("SAGE"    );
		Competence competenceSap      = new Logiciel ("SAP"     );

		List<Competence> competencesSanofi      = new ArrayList<Competence>();
		List<Competence> competencesOptique2000 = new ArrayList<Competence>();
		List<Competence> competencesAirFrance   = new ArrayList<Competence>();
		
		competencesSanofi.add (competenceCpp    );
		competencesSanofi.add (competenceAnglais);
		competencesSanofi.add (competenceSage   );
		
		competencesOptique2000.add (competenceJava    );
		competencesOptique2000.add (competenceFrancais);
		competencesOptique2000.add (competenceSap     );
		competencesAirFrance.add   (competenceAnglais );
		
		
		
		
		LOGGER.info("+-----------------------------------------------------------+");
		LOGGER.info("|                 (02.)ASSOCIATION ENTRE LES OBJETS         |");
		LOGGER.info("+-----------------------------------------------------------+");
		
		////////////////////////////////////////////////////////////////////////
		//(02.01.)ASSOCIER CHAQUE CANDIDATURE AVEC UN CANDIDAT
		////////////////////////////////////////////////////////////////////////
		candidaturePK01.setCandidat  (candidatPK );
		candidaturePK02.setCandidat  (candidatPK );
		candidatureFTT01.setCandidat (candidatFTT);
		candidatureFTT02.setCandidat (candidatFTT);
		candidatureTD01.setCandidat  (candidatTD );
		
		////////////////////////////////////////////////////////////////////////
		//(02.02.)ASSOCIER CHAQUE CANDIDATURE AVEC UN CURRICULUM
		////////////////////////////////////////////////////////////////////////
		candidaturePK01.setCurriculum  (curriculumPK );
		candidaturePK02.setCurriculum  (curriculumPK );
		candidatureFTT01.setCurriculum (curriculumFTT);
		candidatureFTT02.setCurriculum (curriculumFTT);
		candidatureTD01.setCurriculum  (curriculumTD );
		
		////////////////////////////////////////////////////////////////////////
		//(02.03.)ASSOCIER CHAQUE CANDIDATURE AVEC UNE MOTIVATION
		////////////////////////////////////////////////////////////////////////
		candidaturePK01.setMotivation  (motivationPK );
		candidaturePK02.setMotivation  (motivationPK );
		candidatureFTT01.setMotivation (motivationFTT);
		candidatureFTT02.setMotivation (motivationFTT);
		candidatureTD01.setMotivation  (motivationTD );
		
		////////////////////////////////////////////////////////////////////////
		//(02.04.)ASSOCIER CHAQUE ADRESSE AVEC UN CANDIDAT
		////////////////////////////////////////////////////////////////////////
		adressePK.setCandidat  (candidatPK );
		adresseFTT.setCandidat (candidatFTT);
		adresseTD.setCandidat  (candidatTD );
		
		////////////////////////////////////////////////////////////////////////
		//(02.05.)ASSOCIER CHAQUE EMPLOI_VISE AVEC UN CANDIDAT
		////////////////////////////////////////////////////////////////////////
		emploiVisePK.setCandidat  (candidatPK );
		emploiViseFTT.setCandidat (candidatFTT);
		emploiViseTD.setCandidat  (candidatTD );

		////////////////////////////////////////////////////////////////////////
		//(02.06.)ASSOCIER CHAQUE DISPONIBILITE AVEC UN CANDIDAT
		////////////////////////////////////////////////////////////////////////
		disponibilitePK.setCandidat  (candidatPK );
		disponibiliteFTT.setCandidat (candidatFTT);
		disponibiliteTD.setCandidat  (candidatTD );
		
		////////////////////////////////////////////////////////////////////////
		//(02.07.)ASSOCIER CHAQUE CANDIDAT AVEC UNE FORMATION
		////////////////////////////////////////////////////////////////////////
		// L'ASSOCIATION N'EST PAS MISE EN BDD ! 
		// CAR LES OBJETS NE SONT PAS ENCORE PRESENTS EN BDD (DONC IL MANQUE LES CLES PRIMAIRES). 
		// CONSEQUENCE : L'ASSOCIATION SANS CLES PRIMAIRES NE FONCTIONNE PAS  !
		
		////////////////////////////////////////////////////////////////////////
		//(02.08.)ASSOCIER CHAQUE CANDIDAT AVEC UNE EXPERIENCE_PROFESSIONNELLE
		////////////////////////////////////////////////////////////////////////
		experienceProfessionnelleSanofi.setCandidat      (candidatPK );
		experienceProfessionnelleBoulanger.setCandidat   (candidatPK );
		experienceProfessionnelleOptique2000.setCandidat (candidatFTT);
		experienceProfessionnelleCetelem.setCandidat     (candidatFTT);
		experienceProfessionnelleAirFrance.setCandidat   (candidatTD );
		experienceProfessionnelleNatixis.setCandidat     (candidatTD );
		
		////////////////////////////////////////////////////////////////////////
		//(02.09.)ASSOCIER CHAQUE EXPERIENCE_PROFESSIONNELLE AVEC UNE LISTE DE COMPETENCES
		////////////////////////////////////////////////////////////////////////
		// L'ASSOCIATION N'EST PAS MISE EN BDD ! 
		// CAR LES OBJETS NE SONT PAS ENCORE PRESENTS EN BDD (DONC IL MANQUE LES CLES PRIMAIRES). 
		// CONSEQUENCE : L'ASSOCIATION SANS CLES PRIMAIRES NE FONCTIONNE PAS  !
		
		
		
		
		LOGGER.info("+-----------------------------------------------------------+");
		LOGGER.info("|                 (03.)INSERTION DES OBJETS EN BDD          |");
		LOGGER.info("+-----------------------------------------------------------+");
		
		////////////////////////////////////////////////////////////////////////
		//(03.01.)INSERER LES OBJETS METIER (ENTITES) EN BDD.
		//
		//        ->LES CURRICULUMS
		//        ->LES MOTIVATIONS
		//        ->LES CANDIDATS
		//        ->LES CANDIDATURES
		//        ->LES ADRESSES
		//        ->LES EMPLOI_VISES
		//        ->LES DISPONIBILITES
		//        ->LES FORMATIONS
		//        ->LES EXPERIENCES PROFESSIONNELLES
		//        ->LES COMPETENCES
		////////////////////////////////////////////////////////////////////////
		this.insererCurriculums     (curriculums    );
		this.insererMotivations     (motivations    );
		List<Candidat>  candidatsCreated  = this.insererCandidats  (candidats);
		this.insererManagers        (managers       );
		this.insererAdministrateurs (administrateurs);

		this.insererCandidatures    (candidatures   );
		this.insererAdresses        (adresses       );
		this.insererEmploiVises     (emploiVises    );
		this.insererDisponibilites  (disponibilites );
		List<Formation> formationsCreated = this.insererFormations (formationsCursusComplet);
		
		List<ExperienceProfessionnelle> experienceProfessionnellesPKCreated  = this.insererExperienceProfessionnelles (experienceProfessionnellesPK );
		List<ExperienceProfessionnelle> experienceProfessionnellesFTTCreated = this.insererExperienceProfessionnelles (experienceProfessionnellesFTT);
		List<ExperienceProfessionnelle> experienceProfessionnellesTDCreated  = this.insererExperienceProfessionnelles (experienceProfessionnellesTD );

		List<Competence> competencesSanofiCreated      = this.insererCompetences (competencesSanofi     );
		List<Competence> competencesOptique2000Created = this.insererCompetences (competencesOptique2000);
		

		
		
		LOGGER.info("+------------------------------------------------------------------------+");
		LOGGER.info("|                 (04.)ASSOCIATION ENTRE LES OBJETS DEJA PRESENTS EN BDD |");
		LOGGER.info("+------------------------------------------------------------------------+");
		
		////////////////////////////////////////////////////////////////////////
		//(04.07.)ASSOCIER CHAQUE CANDIDAT AVEC UNE LISTE DE FORMATIONS
		////////////////////////////////////////////////////////////////////////
		
		candidatPK  = candidatsCreated.get (0);
		candidatFTT = candidatsCreated.get (1);
		candidatTD  = candidatsCreated.get (2);
		
		formationDevCpp    = formationsCreated.get (0);
		formationDevJava   = formationsCreated.get (1);
		formationDevNTiers = formationsCreated.get (2);
		
		List<Formation> formationsCursusCompletCreated = new ArrayList<Formation>();
		List<Formation> formationsCursusAvanceCreated  = new ArrayList<Formation>();
		
		formationsCursusCompletCreated.add (formationDevCpp   );
		formationsCursusCompletCreated.add (formationDevJava  );
		formationsCursusCompletCreated.add (formationDevNTiers);
		
		formationsCursusAvanceCreated.add  (formationDevNTiers);
		
		candidatPK.setFormations  (formationsCursusCompletCreated);
		candidatFTT.setFormations (formationsCursusCompletCreated);
		candidatTD.setFormations  (formationsCursusAvanceCreated );
		
		////////////////////////////////////////////////////////////////////////
		//(04.09.)ASSOCIER CHAQUE EXPERIENCE_PROFESSIONNELLE AVEC UNE LISTE DE COMPETENCES
		////////////////////////////////////////////////////////////////////////
		
		experienceProfessionnelleSanofi      = experienceProfessionnellesPKCreated.get  (0);
		experienceProfessionnelleBoulanger   = experienceProfessionnellesPKCreated.get  (1);
		experienceProfessionnelleOptique2000 = experienceProfessionnellesFTTCreated.get (0);
		experienceProfessionnelleCetelem     = experienceProfessionnellesFTTCreated.get (1);
		experienceProfessionnelleAirFrance   = experienceProfessionnellesTDCreated.get  (0);
		experienceProfessionnelleNatixis     = experienceProfessionnellesTDCreated.get  (1);
				
		competenceCpp     = competencesSanofiCreated.get (0);
		competenceAnglais = competencesSanofiCreated.get (1);
		competenceSage    = competencesSanofiCreated.get (2);
		
		competenceJava     = competencesOptique2000Created.get (0);
		competenceFrancais = competencesOptique2000Created.get (1);
		competenceSap      = competencesOptique2000Created.get (2);
		
		experienceProfessionnelleSanofi.addCompetence   (competenceCpp    , CompetenceNiveau.CONFIRME);
		//experienceProfessionnelleSanofi.addCompetence (competenceAnglais, CompetenceNiveau.CONFIRME);
		//experienceProfessionnelleSanofi.addCompetence (competenceSage   , CompetenceNiveau.CONFIRME);
		
		experienceProfessionnelleOptique2000.addCompetence   (competenceJava    , CompetenceNiveau.CONFIRME);
		//experienceProfessionnelleOptique2000.addCompetence (competenceFrancais, CompetenceNiveau.CONFIRME);
		//experienceProfessionnelleOptique2000.addCompetence (competenceSap     , CompetenceNiveau.CONFIRME);
		
		
		
		
		LOGGER.info("+---------------------------------------------------------------------+");
		LOGGER.info("|                 (05.)INSERTION DES ASSOCIATIONS ENTRE OBJETS EN BDD |");
		LOGGER.info("+---------------------------------------------------------------------+");
		
		//TODO INSERTION AVEC RECHERCHE PREALABLE, EN BDD, DES OBJETS A INSERER.
		// ASSOCIATION FORMATION - CANDIDAT
		// ASSOCIATION COMPETENCE - EXPERIENCE_PROFESSIONNELLE
		
		this.insererCandidats (candidatsCreated);
		//this.insererExperienceProfessionnelles (experienceProfessionnellesPKCreated );
		//this.insererExperienceProfessionnelles (experienceProfessionnellesFTTCreated);
		
		
		
		
		LOGGER.info("+-----------------------------------------------------------+");
		LOGGER.info("|                 (06.)RECHERCHE DES OBJETS EN BDD          |");
		LOGGER.info("+-----------------------------------------------------------+");
		
		////////////////////////////////////////////////////////////////////////
		//(06.01.)RECHERCHER DES PERSONNES PAR ID
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+-----------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'PERSONNE' : RECHERCHE PAR ID              |");
		LOGGER.info("+-----------------------------------------------------------+");
		
		Optional<Personne> optionalFoundById = this.personneDao.findById(Long.valueOf(1));
		List<Personne> personnesFoundById = new ArrayList<Personne>();
		Personne personneFoundById = optionalFoundById.get();
		personnesFoundById.add (personneFoundById);
		this.afficherPersonnes (personnesFoundById);
		
		////////////////////////////////////////////////////////////////////////
		//(06.02.)RECHERCHER DES PERSONNES PAR MAIL
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'PERSONNE' : RECHERCHE PAR MAIL             |");
		LOGGER.info("+------------------------------------------------------------+");
		
		Personne personneFoundByMail        = this.personneDao.findByMail ("patrick.kabeya@hotmail.com");
		List<Personne> personnesFoundByMail = new ArrayList<Personne>();
		personnesFoundByMail.add (personneFoundByMail);
		this.afficherPersonnes   (personnesFoundByMail);
		
		////////////////////////////////////////////////////////////////////////
		//(06.03.)RECHERCHER DES UTILISATEURS PAR IDENTIFIANT
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+----------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'UTILISATEUR' : RECHERCHE PAR IDENTIFIANT |");
		LOGGER.info("+----------------------------------------------------------+");
		
		Utilisateur utilisateurFoundByIdentifiant = this.utilisateurDao.findByIdentifiant ("patrick.kabeya@hotmail.com");
		List<Utilisateur> utilisateursFoundByIdentifiant = new ArrayList<Utilisateur>();
		utilisateursFoundByIdentifiant.add (utilisateurFoundByIdentifiant);
		this.afficherUtilisateurs          (utilisateursFoundByIdentifiant);

		////////////////////////////////////////////////////////////////////////
		//(06.04.)RECHERCHER DES UTILISATEURS PAR MAIL DE LA PERSONNE
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+------------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'UTILISATEUR' : RECHERCHE PAR MAIL DE LA PERSONNE |");
		LOGGER.info("+------------------------------------------------------------------+");
		
		Utilisateur utilisateurFoundByPersonneMail        = this.utilisateurDao.findByPersonneMail ("patrick.kabeya@hotmail.com");
		List<Utilisateur> utilisateursFoundByPersonneMail = new ArrayList<Utilisateur>();
		utilisateursFoundByPersonneMail.add (utilisateurFoundByPersonneMail);
		this.afficherUtilisateurs   (utilisateursFoundByPersonneMail);

		////////////////////////////////////////////////////////////////////////
		//(06.05.)RECHERCHER DES CANDIDATS PAR MAIL DE LA PERSONNE ASSOCIEE
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+---------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'CANDIDAT' : RECHERCHE PAR MAIL DE LA PERSONNE |");
		LOGGER.info("+---------------------------------------------------------------+");
		
		Candidat candidatFoundByMail        = this.candidatDao.findByPersonneMail ("patrick.kabeya@hotmail.com");
		List<Personne> candidatsFoundByMail = new ArrayList<Personne>();
		candidatsFoundByMail.add (candidatFoundByMail);
		this.afficherPersonnes   (candidatsFoundByMail);
		
		////////////////////////////////////////////////////////////////////////
		//(06.06.)RECHERCHER DES CANDIDATURES
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+-------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'CANDIDATURE' : RECHERCHE PAR ID DU CANDIDAT |");
		LOGGER.info("+-------------------------------------------------------------+");
		
		List<Candidature> candidaturesFound = this.candidatureDao.findByCandidatId (Long.valueOf(2));
		this.afficherCandidatures (candidaturesFound);
		
		////////////////////////////////////////////////////////////////////////
		//(06.07.)RECHERCHER DES CURRICULUMS
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+------------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'CURRICULUM' : RECHERCHE PAR ID DE LA CANDIDATURE |");
		LOGGER.info("+------------------------------------------------------------------+");
		
		Curriculum curriculumFound        = this.curriculumDao.findByCandidatureId (Long.valueOf(3));
		List<Curriculum> curriculumsFound = new ArrayList<Curriculum>();
		curriculumsFound.add     (curriculumFound);
		this.afficherCurriculums (curriculumsFound);
		
		////////////////////////////////////////////////////////////////////////
		//(06.08.)RECHERCHER DES MOTIVATIONS
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+------------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'MOTIVATION' : RECHERCHE PAR ID DE LA CANDIDATURE |");
		LOGGER.info("+------------------------------------------------------------------+");
		
		Motivation motivationFound        = this.motivationDao.findByCandidatureId (Long.valueOf(5));
		List<Motivation> motivationsFound = new ArrayList<Motivation>();
		motivationsFound.add     (motivationFound );
		this.afficherMotivations (motivationsFound);
		
		////////////////////////////////////////////////////////////////////////
		//(06.09.)RECHERCHER DES EXPERIENCES PROFESSIONNELLES
		////////////////////////////////////////////////////////////////////////
		LOGGER.info("+----------------------------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'EXPERIENCE PROFESSIONNELLE' : RECHERCHE PAR ID DE LA CANDIDATURE |");
		LOGGER.info("+----------------------------------------------------------------------------------+");
		
		List<ExperienceProfessionnelle> experienceProfessionnellesFound1 = this.experienceProfessionnelleDao.findByCandidatureId (Long.valueOf(1));
		List<ExperienceProfessionnelle> experienceProfessionnellesFound3 = this.experienceProfessionnelleDao.findByCandidatureId (Long.valueOf(3));
		List<ExperienceProfessionnelle> experienceProfessionnellesFound5 = this.experienceProfessionnelleDao.findByCandidatureId (Long.valueOf(5));
		
		this.afficherExperienceProfessionnelles (experienceProfessionnellesFound1);
		this.afficherExperienceProfessionnelles (experienceProfessionnellesFound3);
		this.afficherExperienceProfessionnelles (experienceProfessionnellesFound5);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : execute -- END");
	}
	
	
	
	
	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'CANDIDAT'</b>
	 * 
	 * @param pCandidats Une liste de candidats.
	 * @return List<Candidat> La liste des objets crees (de type 'Candidat').
	 */
	private List<Candidat> insererCandidats(List<Candidat> pCandidats) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererCandidats -- BEGIN");
		
		LOGGER.info("+----------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'CANDIDAT' : INSERTION              |");
		LOGGER.info("+----------------------------------------------------+");

		List<Candidat> candidatsCreated = new ArrayList<Candidat>();
		
		for (Candidat candidat : pCandidats) {
			Candidat candidatCreated = this.candidatDao.save(candidat);
			candidatsCreated.add(candidatCreated);
		}
		this.afficherCandidats(candidatsCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererCandidats -- END");
		return candidatsCreated;
	}

	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'MANAGER'</b>
	 * 
	 * @param pManagers Une liste de managers.
	 * @return List<Manager> La liste des objets crees (de type 'Manager').
	 */
	private List<Manager> insererManagers(List<Manager> pManagers) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererManagers -- BEGIN");
		
		LOGGER.info("+----------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'MANAGER' : INSERTION               |");
		LOGGER.info("+----------------------------------------------------+");

		List<Manager> managersCreated = new ArrayList<Manager>();
		
		for (Manager manager : pManagers) {
			Manager managerCreated = this.managerDao.save(manager);
			managersCreated.add(managerCreated);
		}
		this.afficherManagers(managersCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererManagers -- END");
		return managersCreated;
	}

	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'ADMINISTRATEUR'</b>
	 * 
	 * @param pAdministrateurs Une liste d'administrateurs.
	 * @return List<Administrateur> La liste des objets crees (de type 'Administrateur').
	 */
	private List<Administrateur> insererAdministrateurs(List<Administrateur> pAdministrateurs) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererAdministrateurs -- BEGIN");
		
		LOGGER.info("+----------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'ADMINISTRATEUR' : INSERTION        |");
		LOGGER.info("+----------------------------------------------------+");

		List<Administrateur> administrateursCreated = new ArrayList<Administrateur>();
		
		for (Administrateur administrateur : pAdministrateurs) {
			Administrateur administrateurCreated = this.administrateurDao.save(administrateur);
			administrateursCreated.add(administrateurCreated);
		}
		this.afficherAdministrateurs(administrateursCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererAdministrateurs -- END");
		return administrateursCreated;
	}

	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'CANDIDATURE'</b>
	 * 
	 * @param pCandidatures Une liste de candidatures.
	 * @return List<Candidature> La liste des objets crees (de type 'Candidature').
	 */
	private List<Candidature> insererCandidatures(List<Candidature> pCandidatures) {

		LOGGER.info("CLASS : DaoTest -- METHOD : insererCandidatures -- BEGIN");
		
		LOGGER.info("+----------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'CANDIDATURE' : INSERTION           |");
		LOGGER.info("+----------------------------------------------------+");

		List<Candidature> candidaturesCreated = new ArrayList<Candidature>();
		
		for (Candidature candidature : pCandidatures) {
			Candidature candidatureCreated = this.candidatureDao.save(candidature);
			candidaturesCreated.add(candidatureCreated);
		}
		this.afficherCandidatures(candidaturesCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererCandidatures -- END");
		return candidaturesCreated;
	}
	
	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'CURRICULUM'</b>
	 * 
	 * @param pCurriculums Une liste de curriculums.
	 * @return List<Curriculum> La liste des objets crees (de type 'Curriculum').
	 */
	private List<Curriculum> insererCurriculums(List<Curriculum> pCurriculums) {

		LOGGER.info("CLASS : DaoTest -- METHOD : insererCurriculums -- BEGIN");
		
		LOGGER.info("+----------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'CURRICULUM' : INSERTION            |");
		LOGGER.info("+----------------------------------------------------+");

		List<Curriculum> curriculumsCreated = new ArrayList<Curriculum>();
		
		for (Curriculum curriculum : pCurriculums) {
			Curriculum curriculumCreated = this.curriculumDao.save(curriculum);
			curriculumsCreated.add(curriculumCreated);
		}
		this.afficherCurriculums(curriculumsCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererCurriculums -- END");
		return curriculumsCreated;
	}
	
	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'MOTIVATION'</b>
	 * 
	 * @param pMotivations Une liste de motivations.
	 * @return List<Motivation> La liste des objets crees (de type 'Motivation').
	 */
	private List<Motivation> insererMotivations(List<Motivation> pMotivations) {

		LOGGER.info("CLASS : DaoTest -- METHOD : insererMotivations -- BEGIN");
		
		LOGGER.info("+----------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'MOTIVATION' : INSERTION            |");
		LOGGER.info("+----------------------------------------------------+");

		List<Motivation> motivationsCreated = new ArrayList<Motivation>();
		
		for (Motivation motivation : pMotivations) {
			Motivation motivationCreated = this.motivationDao.save(motivation);
			motivationsCreated.add(motivationCreated);
		}
		this.afficherMotivations(motivationsCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererMotivations -- END");
		return motivationsCreated;
	}
	
	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'ADRESSE'</b>
	 * 
	 * @param pAdresses Une liste d'adresses.
	 * @return List<Adresse> La liste des objets crees (de type 'Adresse').
	 */
	private List<Adresse> insererAdresses(List<Adresse> pAdresses) {

		LOGGER.info("CLASS : DaoTest -- METHOD : insererAdresses -- BEGIN");
		
		LOGGER.info("+----------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'ADRESSE' : INSERTION               |");
		LOGGER.info("+----------------------------------------------------+");

		List<Adresse> adressesCreated = new ArrayList<Adresse>();
		
		for (Adresse adresse : pAdresses) {
			Adresse adresseCreated = this.adresseDao.save(adresse);
			adressesCreated.add(adresseCreated);
		}
		this.afficherAdresses(adressesCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererAdresses -- END");
		return adressesCreated;
	}
	
	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'EMPLOI_VISE'</b>
	 * 
	 * @param pEmploiVises Une liste d'emploi vises.
	 * @return List<EmploiVise> La liste des objets crees (de type 'EmploiVise').
	 */
	private List<EmploiVise> insererEmploiVises(List<EmploiVise> pEmploiVises) {

		LOGGER.info("CLASS : DaoTest -- METHOD : insererEmploiVises -- BEGIN");
		
		LOGGER.info("+----------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'EMPLOI_VISE' : INSERTION           |");
		LOGGER.info("+----------------------------------------------------+");

		List<EmploiVise> emploiVisesCreated = new ArrayList<EmploiVise>();
		
		for (EmploiVise emploiVise : pEmploiVises) {
			EmploiVise emploiViseCreated = this.emploiViseDao.save(emploiVise);
			emploiVisesCreated.add(emploiViseCreated);
		}
		this.afficherEmploiVises(emploiVisesCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererEmploiVises -- END");
		return emploiVisesCreated;
	}
	
	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'DISPONIBILITE'</b>
	 * 
	 * @param pDisponibilites Une liste de disponibilites.
	 * @return List<Disponibilite> La liste des objets crees (de type 'Disponibilite').
	 */
	private List<Disponibilite> insererDisponibilites(List<Disponibilite> pDisponibilites) {

		LOGGER.info("CLASS : DaoTest -- METHOD : insererDisponibilites -- BEGIN");
		
		LOGGER.info("+----------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'DISPONIBILITE' : INSERTION         |");
		LOGGER.info("+----------------------------------------------------+");

		List<Disponibilite> disponibilitesCreated = new ArrayList<Disponibilite>();
		
		for (Disponibilite disponibilite : pDisponibilites) {
			Disponibilite disponibiliteCreated = this.disponibiliteDao.save(disponibilite);
			disponibilitesCreated.add(disponibiliteCreated);
		}
		this.afficherDisponibilites(disponibilitesCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererDisponibilites -- END");
		return disponibilitesCreated;
	}
	
	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'FORMATION'</b>
	 * 
	 * @param pFormations Une liste de formations.
	 * @return List<Formation> La liste des objets crees (de type 'Formation').
	 */
	private List<Formation> insererFormations(List<Formation> pFormations) {

		LOGGER.info("CLASS : DaoTest -- METHOD : insererFormations -- BEGIN");
		
		LOGGER.info("+----------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'FORMATION' : INSERTION             |");
		LOGGER.info("+----------------------------------------------------+");

		List<Formation> formationsCreated = new ArrayList<Formation>();
		
		for (Formation formation : pFormations) {
			Formation formationCreated = this.formationDao.save(formation);
			formationsCreated.add(formationCreated);
		}
		this.afficherFormations(formationsCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererFormations -- END");
		return formationsCreated;
	}
	
	
	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'EXPERIENCE PROFESSIONNELLE'</b>
	 * 
	 * @param pExperienceProfessionnelles Une liste d'experiences professionnelles.
	 * @return List<ExperienceProfessionnelle> La liste des objets crees (de type 'Experience Professionnelle').
	 */
	private List<ExperienceProfessionnelle> insererExperienceProfessionnelles(List<ExperienceProfessionnelle> pExperienceProfessionnelles) {

		LOGGER.info("CLASS : DaoTest -- METHOD : insererExperienceProfessionnelles -- BEGIN");
		
		LOGGER.info("+---------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'EXPERIENCE PROFESSIONNELLE' : INSERTION |");
		LOGGER.info("+---------------------------------------------------------+");

		List<ExperienceProfessionnelle> experienceProfessionnellesCreated = new ArrayList<ExperienceProfessionnelle>();
		
		for (ExperienceProfessionnelle experienceProfessionnelle : pExperienceProfessionnelles) {
			ExperienceProfessionnelle experienceprofessionnelleCreated = this.experienceProfessionnelleDao.save(experienceProfessionnelle);
			experienceProfessionnellesCreated.add(experienceprofessionnelleCreated);
		}
		this.afficherExperienceProfessionnelles(experienceProfessionnellesCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererExperienceProfessionnelles -- END");
		return experienceProfessionnellesCreated;
	}
	
	/**
	 * <b>INSERER UNE LISTE D'OBJETS DE TYPE : 'COMPETENCE'</b>
	 * 
	 * @param pCompetences Une liste de competences.
	 * @return List<Competence> La liste des objets crees (de type 'Competence').
	 */
	private List<Competence> insererCompetences(List<Competence> pCompetences) {

		LOGGER.info("CLASS : DaoTest -- METHOD : insererCompetences -- BEGIN");
		
		LOGGER.info("+---------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'COMPETENCE' : INSERTION                 |");
		LOGGER.info("+---------------------------------------------------------+");

		List<Competence> competencesCreated = new ArrayList<Competence>();
		
		for (Competence competence : pCompetences) {
			Competence competenceCreated = this.competenceDao.save(competence);
			competencesCreated.add(competenceCreated);
		}
		this.afficherCompetences(competencesCreated);
		
		LOGGER.info("CLASS : DaoTest -- METHOD : insererCompetences -- END");
		return competencesCreated;
	}
	
	
	
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'CANDIDAT'</b>
	 * @param pCandidats Une liste de candidats.
	 */
	private void afficherCandidats(List<Candidat> pCandidats) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherCandidats -- BEGIN");
		
		LOGGER.info("+--------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'CANDIDAT' :          |");
		LOGGER.info("+--------------------------------------+");
		LOGGER.info("| ID :                                 |");
		LOGGER.info("+--------------------------------------+");
		
		for(Candidat candidat : pCandidats) {
			LOGGER.info("| " + candidat.getId() + "\t\t\t\t\t\t\t\t\t|");
			LOGGER.info("+--------------------------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherCandidats -- END");
	}
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'MANAGER'</b>
	 * @param pManagers Une liste de managers.
	 */
	private void afficherManagers(List<Manager> pManagers) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherManagers -- BEGIN");
		
		LOGGER.info("+--------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'MANAGER' :           |");
		LOGGER.info("+--------------------------------------+");
		LOGGER.info("| ID :                                 |");
		LOGGER.info("+--------------------------------------+");
		
		for(Manager manager : pManagers) {
			LOGGER.info("| " + manager.getId() + "\t\t\t\t\t\t\t\t\t|");
			LOGGER.info("+--------------------------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherManagers -- END");
	}

	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'ADMINISTRATEUR'</b>
	 * @param pAdministrateurs Une liste d'administrateurs.
	 */
	private void afficherAdministrateurs(List<Administrateur> pAdministrateurs) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherAdministrateurs -- BEGIN");
		
		LOGGER.info("+--------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'ADMINISTRATEUR' :    |");
		LOGGER.info("+--------------------------------------+");
		LOGGER.info("| ID :                                 |");
		LOGGER.info("+--------------------------------------+");
		
		for(Administrateur administrateur : pAdministrateurs) {
			LOGGER.info("| " + administrateur.getId() + "\t\t\t\t\t\t\t\t\t|");
			LOGGER.info("+--------------------------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherAdministrateurs -- END");
	}

	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'UTILISATEUR'</b>
	 * @param pUtilisateurs Une liste d'utilisateurs.
	 */
	private void afficherUtilisateurs(List<Utilisateur> pUtilisateurs) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherUtilisateurs -- BEGIN");
		
		LOGGER.info("+------------------------------------------------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'UTILISATEUR' :                                                                       |");
		LOGGER.info("+------+-------------------------------+-------------------+---------------+---------------------------+");
		LOGGER.info("| ID : | IDENTIFIANT :                 | MOT DE PASSE :    | ROLE :        | DATE D'INSCRIPTION :      |");
		LOGGER.info("+------+-------------------------------+-------------------+---------------+---------------------------+");
		
		for(Utilisateur utilisateur : pUtilisateurs) {
			LOGGER.info("| " + utilisateur.getId() + "\t| " + utilisateur.getIdentifiant() + "\t| " + utilisateur.getMotDePasse() + "\t\t\t\t| " + utilisateur.getRole() + "\t\t| " + utilisateur.getDateInscription() + "\t\t|");
			LOGGER.info("+------+-------------------------------+-------------------+---------------+---------------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherUtilisateurs -- END");
	}
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'PERSONNE'</b>
	 * @param pPersonnes Une liste de personnes.
	 */
	private void afficherPersonnes(List<Personne> pPersonnes) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherPersonnes -- BEGIN");
		
		LOGGER.info("+------------------------------------------------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'PERSONNE' :                                                                          |");
		LOGGER.info("+------+-----------+-----------+-----------+-------+-------------------+-------------------------------+");
		LOGGER.info("| ID : | CIVILITE :| NOM :     | PRENOM :  | AGE : | TELEPHONE :       | MAIL :                        |");
		LOGGER.info("+------+-----------+-----------+-----------+-------+-------------------+-------------------------------+");
		
		for(Personne personne : pPersonnes) {
			LOGGER.info("| " + personne.getId() + "\t| " + personne.getCivilite() + "\t\t| " + personne.getNom() + "\t| " + personne.getPrenom() + "\t| " + personne.getAge() + "\t| " + personne.getTelephone() + "\t| " + personne.getMail() + "\t|");
			LOGGER.info("+------+-----------+-----------+-----------+-------+-------------------+-------------------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherPersonnes -- END");
	}
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'CANDIDATURE'</b>
	 * @param pCandidatures Une liste de candidatures.
	 */
	private void afficherCandidatures(List<Candidature> pCandidatures) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherCandidatures -- BEGIN");
		
		LOGGER.info("+------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'CANDIDATURE' :           |");
		LOGGER.info("+------+-----------------------------------+");
		LOGGER.info("| ID : | DATE DE DEPOT :                   |");
		LOGGER.info("+------+-----------------------------------+");
		
		for(Candidature candidature : pCandidatures) {
			LOGGER.info("| " + candidature.getId() + "\t| " + candidature.getDateDepot() + "\t\t|");
			LOGGER.info("+------+-----------------------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherCandidatures -- END");
	}
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'CURRICULUM'</b>
	 * @param pCurriculums Une liste de curriculums.
	 */
	private void afficherCurriculums(List<Curriculum> pCurriculums) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherCurriculums -- BEGIN");
		
		LOGGER.info("+----------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'CURRICULUM' :                |");
		LOGGER.info("+------+-------------------+-------------------+");
		LOGGER.info("| ID : | NOM :             | TYPE DE FORMAT :  |");
		LOGGER.info("+------+-------------------+-------------------+");
		
		for(Curriculum curriculum : pCurriculums) {
			LOGGER.info("| " + curriculum.getId() + "\t| " + curriculum.getNom() + "\t\t| " + curriculum.getFormat()  + "\t\t\t\t|");
			LOGGER.info("+------+-------------------+-------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherCurriculums -- END");
	}
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'MOTIVATION'</b>
	 * @param pMotivations Une liste de motivations.
	 */
	private void afficherMotivations(List<Motivation> pMotivations) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherMotivations -- BEGIN");
		
		LOGGER.info("+----------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'MOTIVATION' :                |");
		LOGGER.info("+------+-------------------+-------------------+");
		LOGGER.info("| ID : | NOM :             | TYPE DE FORMAT :  |");
		LOGGER.info("+------+-------------------+-------------------+");
		
		for(Motivation motivation : pMotivations) {
			LOGGER.info("| " + motivation.getId() + "\t| " + motivation.getNom() + "\t\t| " + motivation.getFormat()  + "\t\t\t\t|");
			LOGGER.info("+------+-------------------+-------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherMotivations -- END");
	}
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'ADRESSE'</b>
	 * @param pAdresses Une liste d'adresses.
	 */
	private void afficherAdresses(List<Adresse> pAdresses) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherAdresses -- BEGIN");
		
		LOGGER.info("+------------------------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'ADRESSE' :                                                   |");
		LOGGER.info("+------+---------------+-------------------+-----------------------+-----------+");
		LOGGER.info("| ID : | CODE POSTAL : | VILLE :           | RUE :                 | NUMERO :  |");
		LOGGER.info("+------+---------------+-------------------+-----------------------+-----------+");
		
		for(Adresse adresse : pAdresses) {
			LOGGER.info("| " + adresse.getId() + "\t| " + adresse.getCodePostal() + "\t\t\t| " + adresse.getVille() + "\t\t\t\t| " + adresse.getRue() + "\t\t| " +adresse.getNumeroRue() + "\t\t\t|");
			LOGGER.info("+------+---------------+-------------------+-----------------------+-----------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherAdresses -- END");
	}

	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'EMPLOI_VISE'</b>
	 * @param pEmploiVises Une liste d'emploi vises.
	 */
	private void afficherEmploiVises(List<EmploiVise> pEmploiVises) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherEmploiVises -- BEGIN");
		
		LOGGER.info("+------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'EMPLOI_VISE' :           |");
		LOGGER.info("+------+-------------------+---------------+");
		LOGGER.info("| ID : | LIBELLE :         | SALAIRE :     |");
		LOGGER.info("+------+-------------------+---------------+");
		
		for(EmploiVise emploiVise : pEmploiVises) {
			LOGGER.info("| " + emploiVise.getId() + "\t| " + emploiVise.getLibelle() + "\t\t| " + emploiVise.getSalaire() + "\t\t\t|");
			LOGGER.info("+------+-------------------+---------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherEmploiVises -- END");
	}
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'DISPONIBILITE'</b>
	 * @param pDisponibilites Une liste de disponibilites.
	 */
	private void afficherDisponibilites(List<Disponibilite> pDisponibilites) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherDisponibilites -- BEGIN");
		
		LOGGER.info("+------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'DISPONIBILITE' :         |");
		LOGGER.info("+------+-----------------------------------+");
		LOGGER.info("| ID : | DELAI :                           |");
		LOGGER.info("+------+-----------------------------------+");
		
		for(Disponibilite disponibilite : pDisponibilites) {
			LOGGER.info("| " + disponibilite.getId() + "\t| " + disponibilite.getDelai() + "\t\t|");
			LOGGER.info("+------+-----------------------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherDisponibilites -- END");
	}
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'FORMATION'</b>
	 * @param pFormations Une liste de formations.
	 */
	private void afficherFormations(List<Formation> pFormations) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherFormations -- BEGIN");
		
		LOGGER.info("+------------------------------------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'FORMATION' :                                                             |");
		LOGGER.info("+------+---------------+---------------+-------------------+-------------------------------+");
		LOGGER.info("| ID : | LIBELLE :     | NIVEAU :      | DOMAINE :         | DATE :                        |");
		LOGGER.info("+------+---------------+---------------+-------------------+-------------------------------+");
		
		for(Formation formation : pFormations) {
			LOGGER.info("| " + formation.getId() + "\t| " + formation.getLibelle() + "\t| " + formation.getNiveau() + "\t\t\t| " + formation.getDomaine() + "\t\t\t\t| " + formation.getDateValidation() + "\t|");
			LOGGER.info("+------+---------------+---------------+-------------------+-------------------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherFormations -- END");
	}
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'EXPERIENCE PROFESSIONNELLE'</b>
	 * @param pExperienceProfessionnelles Une liste d'experiences professionnelles.
	 */
	private void afficherExperienceProfessionnelles(List<ExperienceProfessionnelle> pExperienceProfessionnelles) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherExperienceProfessionnelles -- BEGIN");
		
		LOGGER.info("+--------------------------------------------------------------------------------------------------------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'EXPERIENCE PROFESSIONNELLE' :                                                                                  |");
		LOGGER.info("+------+---------------+---------------------------+-------------------------------+----------------------------+----------------+");
		LOGGER.info("| ID : | EMPLOYEUR :   | FONCTION :                | DATE DE DEBUT :               | DATE DE FIN :              | LIEU :         |");
		LOGGER.info("+------+---------------+---------------------------+-------------------------------+----------------------------+----------------+");
		
		for(ExperienceProfessionnelle experienceProfessionnelle : pExperienceProfessionnelles) {
			LOGGER.info("| " + experienceProfessionnelle.getId() + "\t| " + experienceProfessionnelle.getEmployeur() + "\t\t| " + experienceProfessionnelle.getFonction() + "\t| " + experienceProfessionnelle.getDateDebut() + "\t| " + experienceProfessionnelle.getDateFin() + "\t| " + experienceProfessionnelle.getLieu() + "\t|");
			LOGGER.info("+------+---------------+---------------------------+-------------------------------+----------------------------+----------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherExperienceProfessionnelles -- END");
	}
	
	/**
	 * <b>AFFICHER UNE LISTE D'OBJETS DE TYPE : 'COMPETENCE'</b>
	 * @param pCompetences Une liste de competences.
	 */
	private void afficherCompetences(List<Competence> pCompetences) {
		
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherCompetences -- BEGIN");
		
		LOGGER.info("+------------------------------+");
		LOGGER.info("| OBJETS DE TYPE 'COMPETENCE' :|");
		LOGGER.info("+------------------------------+");
		LOGGER.info("| ID :                         |");
		LOGGER.info("+------------------------------+");
		
		for(Competence competence : pCompetences) {
			LOGGER.info("| " + competence.getId() + "\t\t\t\t\t\t\t|");
			LOGGER.info("+------------------------------+");
		}
		LOGGER.info("CLASS : DaoTest -- METHOD : afficherCompetences -- END");
	}
}
