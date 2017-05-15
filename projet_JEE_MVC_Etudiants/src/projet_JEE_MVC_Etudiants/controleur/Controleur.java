package projet_JEE_MVC_Etudiants.controleur;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet_JEE_MVC_Etudiants.data.Etudiant;
import projet_JEE_MVC_Etudiants.data.GestionFactory;
import projet_JEE_MVC_Etudiants.data.TestAbsences;

@SuppressWarnings("serial")
public class Controleur extends HttpServlet {

	private String urlListeEtudiants;
	private String urlDetailEtudiant;
	private String urlRentrerNotes;
	
	// INIT
	public void init() throws ServletException {
		urlListeEtudiants = getServletConfig().getInitParameter("urlListeEtudiants");
		urlDetailEtudiant = getServletConfig().getInitParameter("urlDetailEtudiant");
		urlRentrerNotes = getServletConfig().getInitParameter("urlRentrerNotes");
		
		//ouverture BDD
		//GestionFactory.open();

		//création des données
		//fonction en bas 
	}
	
	// POST
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// on passe la main au GET
		doGet(request, response);
	}
	
	// GET
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		//doGet(request, response);
		// On récupère la méthode d'envoi de la requête
		String methode = request.getMethod().toLowerCase();
		
		// On récupère l'action à  éxécuter
		String action = request.getPathInfo();
		if (action == null) {
			action = "/listeEtudiants";
			System.out.println("action == null");
		}
		System.out.println(action);
		
		// Éxécution action
		if (methode.equals("get") && action.equals("/listeEtudiants")) {
			doListeEtudiants(request, response);

		} else if (methode.equals("post") && action.equals("/detailEtudiant")) {
			doDetailEtudiant(request, response);
			
		} else if (methode.equals("post") && action.equals("/rentrerNotes")) {
			doRentrerNotes(request, response);
		
		} else {
			// Autres cas
			doListeEtudiants(request, response);
		}
	}

	//
	private void doListeEtudiants(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	String classe = request.getParameter("classe");
	
	if(!classe.isEmpty())
	{
		System.out.println("classe n'est pas nulle ! classe="+classe);
	}
	else
	{
		System.out.println("classe est carrément nulle !"+classe);
	}

		loadJSP(urlListeEtudiants, request, response);
		
		
	}
	
	//
	private void doDetailEtudiant(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		loadJSP(urlDetailEtudiant, request, response);
		
		/* TRAITEMENT A RENTRER ICI */
		
		
		
		
		/*
		// Récupèrer l'attribut résultat de la session
		Resultat resultat = (Resultat)request.getSession().getAttribute("resultat");
		if (resultat == null) {
			resultat = new Resultat();
			request.getSession().setAttribute("resultat", resultat);
		}
		
		// Créer une objet de type jeu
		Partie partie = new Partie();
		partie.setMainJoueur(request.getParameter("mainJoueur"));
		
		// Traitement du résultat
		if (partie.egalite()) { 
			resultat.addEgalite();
		} else if (partie.joueurGagne()) {
			resultat.addGagne();
		} else {
			resultat.addPerdu();
		}
		
		// Mettre l'objet jeu en attribut de requÃªte
		request.setAttribute("partie", partie);
		
		loadJSP(urlResultat, request, response);
		*/
	}
	
	//
	private void doRentrerNotes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		loadJSP(urlRentrerNotes, request, response);
	}

	/**
	 * Charge la JSP indiquée en paramètre
	 * 
	 * @param url
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadJSP(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		L'interface RequestDispatcher permet de transférer le contrôle à  une autre servlet
//		Deux méthodes possibles :
//		- forward() : donne le contrôle Ã  une autre servlet. Annule le flux de sortie de la servlet courante
//		- include() : inclus dynamiquement une autre servlet
//			+ le contrôle est donné  une autre servlet puis revient à la servlet courante (sorte d'appel de fonction). 
//			+ Le flux de sortie n'est pas supprimÃ© et les deux se cumulent
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}


}
