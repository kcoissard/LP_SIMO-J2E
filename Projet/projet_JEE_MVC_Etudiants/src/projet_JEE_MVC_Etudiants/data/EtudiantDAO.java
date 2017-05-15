package projet_JEE_MVC_Etudiants.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class EtudiantDAO {
	
	/**
	 * retrouver un étudiant par son ID
	 * @param id
	 * @return
	 */
	public static Etudiant retrieveById(int id) {
		
		EntityManager em = GestionFactory.factory.createEntityManager();
		Etudiant etudiant = em.find(Etudiant.class, id);
	    em.close();
	    
		return etudiant;
	}
	
	/**
	 * création du nouvel étudiant
	 * @param prenom
	 * @param nom
	 * @param licence
	 * @param moyenne
	 * @return
	 */
	public static Etudiant creer(String prenom, String nom, Licence licence) {

		EntityManager em = GestionFactory.factory.createEntityManager();
		
		em.getTransaction().begin();

		Etudiant etudiant = new Etudiant();
		etudiant.setPrenom(prenom);
		etudiant.setNom(nom);
		etudiant.setLicence(licence);
		//etudiant.setMoyenne();//MOYENNE - random effectué dans la licence Etudiant
		etudiant.setNbAbsences(0);
		
		em.persist(etudiant);
		em.getTransaction().commit();
		em.close();

		return etudiant;
	}
	
	/**
	 * Mise à jour de l'étudiant en entrée
	 * @param etudiant
	 * @return
	 */
	public static Etudiant miseAJour(Etudiant etudiant) {

		EntityManager em = GestionFactory.factory.createEntityManager();

		em.getTransaction().begin();
		em.merge(etudiant);
		em.getTransaction().commit();
		em.close();

		return etudiant;
	}
	
	/**
	 *  Retourne l'ensemble des etudiants
	 * @return
	 */
	public static List<Etudiant> getAll() {

		EntityManager em = GestionFactory.factory.createEntityManager();

		// request - to catch them all 
		Query q = em.createQuery("SELECT e FROM Etudiant e");
		@SuppressWarnings("unchecked")
		List<Etudiant> etudiants = q.getResultList();
		return etudiants;
	}
	
	
	

}
