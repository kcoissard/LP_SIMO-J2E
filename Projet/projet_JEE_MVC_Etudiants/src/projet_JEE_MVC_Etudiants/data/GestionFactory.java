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