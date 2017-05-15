package data;

import data.UtilisateurDAO;
import data.VoitureDAO;
import data.GestionFactory;

import javax.persistence.EntityManager;

public class InitDAO {

	
public static void init() {
		
		///// INITIALISATION DE LA BD
		// Normalement l'initialisation se fait directement dans la base de données
		EntityManager em = GestionFactory.factory.createEntityManager();
		em.getTransaction().begin();
	
		if(UtilisateurDAO.getAll().size() == 0){
			// Créaation des users
			Utilisateur francis = UtilisateurDAO.create("Francis", "Brunet-Manquat", "a");
			Utilisateur philippe = UtilisateurDAO.create("Philippe", "Martin", "a");
			Utilisateur mario = UtilisateurDAO.create("Mario", "Cortes-Cornax", "a");
			Utilisateur francoise = UtilisateurDAO.create("Francoise", "Coat", "a");
			Utilisateur laurent = UtilisateurDAO.create("Laurent", "Bonnaud", "a");
			Utilisateur sebastien = UtilisateurDAO.create("Sebastien", "Bourdon", "a");
			Utilisateur mathieu = UtilisateurDAO.create("Mathieu", "Gatumel", "a");
		}
		
		if(VoitureDAO.getAll().size() == 0){
			// Créaation des users
			Voiture limousine = VoitureDAO.create("AB-02-ME", "Limousine");
			Voiture lamborghini = VoitureDAO.create("AC-01-EM", "Lamborghini");
			Voiture ferrari = VoitureDAO.create("AD-01-EM", "Ferrari");
			Voiture bentley = VoitureDAO.create("AE-01-EM", "Bentley");
			Voiture peugeot = VoitureDAO.create("AF-01-EM", "Peugeot");
			Voiture citroen = VoitureDAO.create("AG-01-EM", "Citroen");
		}
		
		em.close();
	}


}
