package projet_JEE_MVC_Etudiants.data;

import java.util.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestionFactory {
	
	// Nom de l'unit� de persistence 
	// Permet le lien avec le fichier persistence.xml pr�sent dans le dossier WebContent/WEB-INF/classes/META-INF
	// Ce fichier contient les propri�t�s de connexion � la base de donn�es
	private static final String PERSISTENCE_UNIT_NAME = "Projet_JPA";
	
	// Factory pour la cr�ation d'EntityManager (gestion des transactions)
	public static EntityManagerFactory factory;
	
	
	// Creation de la factory
	public static void open() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);;
	}
	
	// Fermeture de la factory
	public static void close() {
		factory.close();
	}
	
}

/*
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import projet_JEE_MVC_Etudiants.data.Etudiant;

public class GestionFactory {

	/////// SIMULATION DE LA PERSISTANCE DES ETUDIANTS ET DES ABSENCES
	
	// CHARGER en premier à l'execution du projet (car constante : static final)
	private static final HashMap<Integer, Etudiant> LISTE_ID_ETUDIANTS = intializeListEtudiants();
	private static final HashMap<Integer, Integer> LISTE_ID_ABSENCES = intializelistEtudiantAbsence();

	// Initialisation des �tudiants
	private static HashMap<Integer, Etudiant> intializeListEtudiants() {

		// Cr�ation des �tudiants
		Etudiant etu1 = new Etudiant(0, "Trompe", "DONALD", "assr");
		Etudiant etu2 = new Etudiant(1, "Fran�ais", "FRANCO", "simo");
		Etudiant etu3 = new Etudiant(2, "Gastro", "FIDEL", "big-data");
		Etudiant etu4 = new Etudiant(3, "Un", "KIM KONG", "miaw");

		// Cr�ation du hasmap (association cl�/valeur)
		// Association id -> etudiant
		HashMap<Integer, Etudiant> listEtudiantsTemp = new HashMap<>();
		listEtudiantsTemp.put(etu1.getId(), etu1);
		listEtudiantsTemp.put(etu2.getId(), etu2);
		listEtudiantsTemp.put(etu3.getId(), etu3);
		listEtudiantsTemp.put(etu4.getId(), etu4);


		//
		return listEtudiantsTemp;
	}

	// Initialisation des absences
	private static final HashMap<Integer, Integer> intializelistEtudiantAbsence() {

		// Cr�ation du hashmap (association cl�/valeur)
		// Association etudiant id -> absences
		HashMap<Integer, Integer> listEtudiantAbsenceTemp = new HashMap<>();
		
		// Le nombre d'absences est g�n�r� al�atoirement
		Random rand = new Random();
		for (Etudiant etudiant : LISTE_ID_ETUDIANTS.values()) {
			listEtudiantAbsenceTemp.put(etudiant.getId(), rand.nextInt(10));
		}

		//
		return listEtudiantAbsenceTemp;
	}

	
	/////// METHODES A UTILISER
	// Retourne l'ensemble des etudiants
	public static Collection<Etudiant> getEtudiants() {
		return LISTE_ID_ETUDIANTS.values();
	}

	// Retourne un étudiant en fonction de son id 
	public static Etudiant getEtudiantById(int id) {
		return LISTE_ID_ETUDIANTS.get(id);
	}

	// Retourne le nombre d'absences d'un etudiant en fonction de son id 
	public static Integer getAbsencesByEtudiantId(int id) {
		return LISTE_ID_ABSENCES.get(id);
	}

}*/