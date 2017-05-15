package projet_JEE_MVC_Etudiants.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LicenceDAO {

	/**
	 * creer un type de licence
	 * @param libelle
	 * @return
	 */
	public static Licence creer(String libelle) {
			
		EntityManager em = GestionFactory.factory.createEntityManager();
		em.getTransaction().begin();

		//nouvelle licence
		Licence licence = new Licence();
		licence.setLibelle(libelle);
		
		//enregistrement en base
		em.persist(licence);
		em.getTransaction().commit();

		em.close();
		
		return licence;
	}

	/**
	 * Retrouver une licence par son ID
	 * @param id
	 * @return
	 */
	public static Licence getById(int id){
		
		EntityManager em = GestionFactory.factory.createEntityManager();
		Licence licence = em.find(Licence.class, id);
		em.close();
		
		return licence;
	}
	
	/**
	 * Pour r�cup�rer toutes les licences
	 * @return
	 */
	public static List<Licence> getAll() {

		EntityManager em = GestionFactory.factory.createEntityManager();
				
		// Requ�te 
		Query q = em.createQuery("SELECT l FROM Licence l");

		//M�thode magique pour r�cuperer le resultat damns une liste
		@SuppressWarnings("unchecked")
		List<Licence> listeLicence = q.getResultList();
		
		return listeLicence;
	}
	
	/**
	 * Retrouver une licence par son libell� - permet dans le controleur de charger les licences �xistantes sans les recreer
	 * @param libelle
	 * @return
	 */
	public static Licence getByLibelle(String libelle) {

		EntityManager em = GestionFactory.factory.createEntityManager();
				
		// Requ�te
		Query q = em.createQuery("SELECT l FROM Licence l WHERE l.libelle = :libelle")
				.setParameter("libelle", libelle);
		
		// M�thode magique pour r�cuperer le resultat dans une liste
		List<Licence> list = q.getResultList();
		
		return list.get(0);
	}
	

}
