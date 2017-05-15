package data;

import data.Voiture;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class VoitureDAO {
	
//création d'une voiture
public static Voiture create(String immatriculation, String modele) {
		
		// Creation de l'entity manager
		EntityManager em = GestionFactory.factory.createEntityManager();
				
		//
		em.getTransaction().begin();

		// create new voiture
		Voiture voiture = new Voiture();
		voiture.setImmatriculation(immatriculation);
		voiture.setModele(modele);
		em.persist(voiture);

		// Commit
		em.getTransaction().commit();

		// Close the entity manager
		em.close();
		
		return voiture;
	}
	
	// Retrouve la voiture par son id
	public static Voiture retrieveById(int id) {
		
		// Creation de l'entity manager
		EntityManager em = GestionFactory.factory.createEntityManager();
			
		//
		Voiture voitu = em.find(Voiture.class, id);
		
	    // Close the entity manager
	    em.close();
				
		return voitu;
	}

	// Retourne l'ensemble des voitures
		public static List<Voiture> getAll() {

			// Creation de l'entity manager
			EntityManager em = GestionFactory.factory.createEntityManager();
					
			// Recherche 
			Query q = em.createQuery("SELECT v FROM Voiture v");

			@SuppressWarnings("unchecked")
			List<Voiture> listVoitures = q.getResultList();
			
			em.close();
			
			return listVoitures;
			
		}

}
