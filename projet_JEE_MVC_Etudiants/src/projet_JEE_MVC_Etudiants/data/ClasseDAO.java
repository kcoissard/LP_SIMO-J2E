package projet_JEE_MVC_Etudiants.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class ClasseDAO {
	
public static Classe create(String libelle) {
		
		// Creation de l'entity manager
		EntityManager em = GestionFactory.factory.createEntityManager();
		
		// create
		em.getTransaction().begin();

		// create new classe
		Classe classe = new Classe();
		classe.setLibelle(libelle);
		em.persist(classe);

		// Commit
		em.getTransaction().commit();

		// Close the entity manager
		em.close();
		
		return classe;
	}
	
	
	public static int removeAll() {
		
		// Creation de l'entity manager
		EntityManager em = GestionFactory.factory.createEntityManager();

		//
		em.getTransaction().begin();
		
		// RemoveAll
		int deletedCount = em.createQuery("DELETE FROM Classe").executeUpdate();

		// Commit
		em.getTransaction().commit();
		
		// Close the entity manager
		em.close();
		
		return deletedCount;
	}
	
	public static Classe getById(int id){
		// Creation de l'entity manager
		EntityManager em = GestionFactory.factory.createEntityManager();
		
		Classe classe = em.find(Classe.class, id);
		
		em.close();
		
		return classe;
	}
	
	public static Classe getByLibelle(String libelle) {

		// Creation de l'entity manager
		EntityManager em = GestionFactory.factory.createEntityManager();
				
		// Recherche 
		Query q = em.createQuery("SELECT f FROM Classe f WHERE f.libelle = :libelle")
				.setParameter("libelle", libelle);
		
		List<Classe> list = q.getResultList();
		return list.get(0);
	}
	
	
	public static List<Classe> getAll() {

		// Creation de l'entity manager
		EntityManager em = GestionFactory.factory.createEntityManager();
				
		// Recherche 
		Query q = em.createQuery("SELECT g FROM Classe g");

		@SuppressWarnings("unchecked")
		List<Classe> listClasse = q.getResultList();
		
		return listClasse;
	}
	
	public static Long count(){
		// Creation de l'entity manager
		EntityManager em = GestionFactory.factory.createEntityManager();

		// Comptage
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(Classe.class)));
		return em.createQuery(cq).getSingleResult();
	}



}
