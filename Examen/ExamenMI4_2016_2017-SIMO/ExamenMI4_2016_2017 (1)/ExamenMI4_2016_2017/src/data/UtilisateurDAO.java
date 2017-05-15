package data;

import data.Utilisateur;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UtilisateurDAO {
	//création d'un user
	public static Utilisateur create(String prenom, String nom, String voiture) {
			
		//private string userCar;
		
			// Creation de l'entity manager
			EntityManager em = GestionFactory.factory.createEntityManager();
					
			//
			em.getTransaction().begin();

			// create new utilisateur
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setPrenom(prenom);
			utilisateur.setNom(nom);
			utilisateur.setVoiture(voiture);
			
			// Recherche voiture --> pas réussi à faire une pauvre jointure en jpa ...
			System.out.println("avant query");
			//Query q1 = em.createQuery("SELECT v FROM Voiture v Join");
			//Query q2 = em.createQuery("SELECT v FROM Voiture v JOIN v.utilisateurs u WHERE u.id = :id");
			
			//userCar = q.getResultList().toString();
			
			//utilisateur.setVoiture(voiture);
			//System.out.println(q.getResultList().toString());
			
			em.persist(utilisateur);

			// Commit
			em.getTransaction().commit();

			// Close the entity manager
			em.close();
			
			return utilisateur;
		}

	// Retourne l'ensemble des utilisateurs
	public static List<Utilisateur> getAll() {

		// Creation de l'entity manager
		EntityManager em = GestionFactory.factory.createEntityManager();
				
		// Recherche 
		Query q = em.createQuery("SELECT u FROM Utilisateur u");

		@SuppressWarnings("unchecked")
		List<Utilisateur> listUtilisateurs = q.getResultList();
		
		em.close();
		
		return listUtilisateurs;
	}

}
