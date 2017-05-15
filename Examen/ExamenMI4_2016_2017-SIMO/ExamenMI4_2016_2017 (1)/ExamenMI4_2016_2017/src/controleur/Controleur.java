package controleur;

import java.io.IOException;
import java.util.List;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;


import data.GestionFactory;
import data.InitDAO;
import data.Utilisateur;
import data.UtilisateurDAO;
import data.Voiture;
import data.VoitureDAO;

@SuppressWarnings("serial")
public class Controleur extends HttpServlet {

	private String urlAccueil;
	private String urlListUtilisateurs;
	private String urlListVoitures;
	private String urlDetailsIntervention;
	private String urlDetailsVoiture;

	// INIT
	public void init() throws ServletException {
		urlAccueil = getServletConfig().getInitParameter("urlAccueil");
		urlListUtilisateurs = getServletConfig().getInitParameter("urlListUtilisateurs");
		urlListVoitures = getServletConfig().getInitParameter("urlListVoitures");
		urlDetailsIntervention = getServletConfig().getInitParameter("urlDetailsIntervention");
		urlDetailsVoiture = getServletConfig().getInitParameter("urlDetailsVoiture");
		
		System.out.println("Ok init");

		// Création de la factory permettant la création d'EntityManager
		// (gestion des transactions)
		GestionFactory.open();

		///// INITIALISATION DE LA BD
		// Normalement l'initialisation se fait directement dans la base de données
		InitDAO.init();
	}
	
	@Override
	public void destroy() {
		super.destroy();

		// Fermeture de la factory
		//GestionFactory.close();
	}

	// POST
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// on passe la main au GET
		doGet(request, response);
	}

	// GET
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// On récupère la méthode d'envoi de la requête
		String method = request.getMethod().toLowerCase();

		// On récupère l'action à exécuter
		String action = request.getPathInfo();
		if (action == null) {
			action = "accueil";
			System.out.println("action == null");
		}
		
		System.out.println(action);

		// Ex�cution action
		if (method.equals("get") && action.equals("/listUtilisateurs")) {
			//maSession.setAttribute("previous_page", action);
			System.out.println("do get List user");
			doListUtilisateurs(request, response);

		} else if (method.equals("get") && action.equals("/listVoitures")) {
			//maSession.setAttribute("previous_page", action);
			System.out.println("do get List voitures");
			doListVoitures(request, response);

		} else if (method.equals("get") && action.equals("/detailVoiture")) {
			doDetailVoiture(request, response);
			
		} else {
			// ROOT PATH :
			doAccueil(request, response);
		}
		
		
		
		
	}

	
	//Fonction accueil
	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		loadJSP(urlAccueil, request, response);
	}

	//Fonction liste des utilisateurs
	private void doListUtilisateurs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doListUtilisateurs");
		EntityManager em = GestionFactory.factory.createEntityManager();
		em.getTransaction().begin();
		
		Collection<Utilisateur> utilisateurs = UtilisateurDAO.getAll();
		//List<Formation> formations = FormationDAO.getAll();
		
		//request.setAttribute("formations", formations);
		request.setAttribute("utilisateurs", utilisateurs);

		loadJSP(urlListUtilisateurs, request, response);
		
		//em.close();
	}
	
	//Fonction liste des utilisateurs
		private void doListVoitures(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("doListVoitures");
			EntityManager em = GestionFactory.factory.createEntityManager();
			em.getTransaction().begin();
			
			Collection<Voiture> voitures = VoitureDAO.getAll();
			//List<Formation> formations = FormationDAO.getAll();
			
			//request.setAttribute("formations", formations);
			request.setAttribute("voitures", voitures);

			loadJSP(urlListVoitures, request, response);
			
			//em.close();
		}
		
		//detail de la voiture
		private void doDetailVoiture(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			EntityManager em = GestionFactory.factory.createEntityManager();
			em.getTransaction().begin();

			Voiture voiture = new Voiture();
			voiture = VoitureDAO.retrieveById(Integer.parseInt(request.getParameter("id")));
			
			request.setAttribute("voiture", voiture);
			if (voiture == null) {
				System.out.println("Cas voiture null");
				voiture = new Voiture();
				 doListVoitures(request, response);
				 			 } else {
				 System.out.println("Cas existante");
				 loadJSP(urlDetailsVoiture, request, response);
			 }
			
			em.close();
		}
	
	
	/**
	 * Charge la JSP indiqu�e en param�tre
	 * 
	 * @param url
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadJSP(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// L'interface RequestDispatcher permet de transférer le contrôle à une
		// autre servlet
		// Deux méthodes possibles :
		// - forward() : donne le contrôle à une autre servlet. Annule le flux
		// de sortie de la servlet courante
		// - include() : inclus dynamiquement une autre servlet
		// + le contrôle est donné à une autre servlet puis revient à la servlet
		// courante (sorte d'appel de fonction).
		// + Le flux de sortie n'est pas supprimé et les deux se cumulent

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
