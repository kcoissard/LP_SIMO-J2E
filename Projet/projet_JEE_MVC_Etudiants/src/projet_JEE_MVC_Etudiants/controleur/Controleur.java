package projet_JEE_MVC_Etudiants.controleur;


import java.io.IOException;
import java.util.*;
//import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import projet_JEE_MVC_Etudiants.data.*;

/**
 * 
 * @author Kévin COISSARD
 * "Controler" Frontal
 */
@SuppressWarnings("serial")
public class Controleur extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String urlListeEtudiants;
	private String urlDetailEtudiant;

	private HttpSession session;
	
	// INIT
	@Override
	public void init() throws ServletException {
		
		//deux url à définir pour la liste et le détail
		urlListeEtudiants = getServletConfig().getInitParameter("urlListeEtudiants");
		urlDetailEtudiant = getServletConfig().getInitParameter("urlDetailEtudiant");
		
		//ouverture BDD
		GestionFactory.open();

		//création des données
		remplissageDonnees();
	}
	
	// DESTROY
	@Override
	public void destroy() {
		// pour fermer GestionFactory
		super.destroy();
		GestionFactory.close();
	}
	
	// POST
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// on passe la main au GET
		doGet(request, response);
	}
	
	// GET
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//pour récupérer les données en session
		session = request.getSession();

		// On récupère la méthode d'envoi de la requête
		String methode = request.getMethod().toLowerCase();
		
		// On récupère l'action à  éxécuter, si elle est nulle on affiche la liste par défaut
		String action = request.getPathInfo();
		if (action == null) {
			action = "/listeEtudiants";
		}
		
		// Éxécution de la bonne action
		if (methode.equals("get") && action.equals("/listeEtudiants")) {
			
			session.setAttribute("page_precedente", action);
			doListeEtudiants(request, response);
			
		} else if (methode.equals("get") && action.equals("/detailEtudiant")) {
			
			session.setAttribute("page_precedente", action);
			doDetailEtudiant(request, response);

		} else if (methode.equals("post") && action.equals("/modifierListe")) {
			
			doModifierListe(request, response);
			
		} else if (methode.equals("post") && action.equals("/modifierEtudiant")) {
			
			doModifierEtudiant(request, response);

		} else if (methode.equals("get") && action.equals("/ajouterAbsence")) {
			doAjouterAbsence(request, response);

		} else if (methode.equals("get") && action.equals("/supprimerAbsence")) {
			doSupprimerAbsence(request, response);
			
		} else {
			// Cas par défaut
			doListeEtudiants(request, response);
		}
	}

	
	

	/* ------------------------------------- FONCTIONS ACTION" --------------------------------------- */
	
	/**
	 * liste des étudiants selon leur licence et tous les étudiants si aucune licence n'est choisie
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doListeEtudiants(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id_licence;
		List<Licence> licences= new ArrayList<Licence>();
		List<Etudiant> etudiants= new ArrayList<Etudiant>();

		//On cherche à récupèrer le paramètre "licence"
		if ((request.getParameterMap().containsKey("licence") && !request.getParameter("licence").equals("-1"))) {
			//On récupère l'id reçu
			id_licence = Integer.parseInt(request.getParameter("licence"));
			//On récupère la licence selon l'id reçu
			Licence intitule_licence = LicenceDAO.getById(id_licence);
			//puis la liste d'étudiants de la licence
			etudiants = intitule_licence.getEtudiants();
			
		//A "-1" on affiche toutes les licences par défaut
		} else {
			etudiants = EtudiantDAO.getAll();
			id_licence = -1;
		}

		// Pour garder les bonnes données lors du retour vers la liste d'étudiants
		//licences
		session.setAttribute("id_licence", id_licence);
		request.setAttribute("id_licence", id_licence);
		request.setAttribute("licences", licences);
		//page precedente
		session.setAttribute("lien_precedent", url_precedent(request));
		//étudiants
		request.setAttribute("etudiants", etudiants);
		
		loadJSP(urlListeEtudiants, request, response);
	
	}
	
	/**
	 * Détail d'un étudiant via l'id passé en paramètre
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doDetailEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Etudiant etudiant = new Etudiant();
		
		//On récupère l'id passé dans l'URL
		etudiant = EtudiantDAO.retrieveById(Integer.parseInt(request.getParameter("id")));

		if (etudiant == null) {
			response.sendRedirect("listeEtudiants");
		} else {
			
			//On récupère toutes les licences possible
			List<Licence> licences = LicenceDAO.getAll();

			// On récupère l'id de la licence choisie via l'url
			String id_licence = "";
			if (session.getAttribute("id_licence") != null) {
				id_licence = session.getAttribute("id_licence").toString();
			}
			
			request.setAttribute("etudiant", etudiant);
			request.setAttribute("licences", licences);
			request.setAttribute("id_licence", id_licence);
		
		loadJSP(urlDetailEtudiant, request, response);
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doModifierListe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] ids = request.getParameterValues("id");
		for (String id : ids) {
				Etudiant etudiant = modifierEtudiant(request, Integer.parseInt(id));
		}
		// On retourne la licence choisie si c'est le cas :
		if (request.getParameterMap().containsKey("licence") && request.getParameter("licence") != "-1") {
			request.setAttribute("licence", request.getParameter("licence"));
		}
		
		doListeEtudiants(request, response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doModifierEtudiant(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		//On modifie l'étudiant et affiche son détail, sinon retour à la liste
		//test try catch
		try {
			Etudiant etudiantModifie = modifierEtudiant(request, Integer.parseInt(request.getParameter("id")));
			doDetailEtudiant(request, response);
		} catch (Exception e) {
			doListeEtudiants(request, response);
		}
	}
	
	/**
	 * Ajout d'une absence au click du bouton "+"
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doAjouterAbsence(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		modifierAbsence(request, response, "ajouterAbsence");
	}
	
	/**
	 * Ajout d'une absence au click du bouton "-"
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doSupprimerAbsence(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		modifierAbsence(request, response, "supprimerAbsence");
	}

	
	
	
	
	
	/* ----------------------------------- FONCTIONS UTILES POUR LES DO ------------------------------- */
	
	/**
	 * Pour pouvoir revenir sur la page précèdente sans perte de données
	 * @param request
	 * @return
	 */
	private String url_precedent(HttpServletRequest request) {
		return request.getPathInfo().substring(1) + "?" + request.getQueryString();
	}
	
	/**
	 * Modifie l'étudiant selon ce qui est récupéré dans les champs
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	private Etudiant modifierEtudiant(HttpServletRequest request, int id) {
		
		Etudiant etudiant = EtudiantDAO.retrieveById(id);
		// On affecte les données envoyées par le formulaire à l'étudiant si il
		if (request.getParameterMap().containsKey("nom")) {
			//le nom ne doit pas être vide
			if (!request.getParameter("nom").isEmpty()) {
				
				etudiant.setNom(request.getParameter("nom"));
			}
		}
		
		if (request.getParameterMap().containsKey("prenom")) {
			//le prenom ne doit pas être vide
			if (!request.getParameter("prenom").isEmpty()) {
				
				etudiant.setPrenom(request.getParameter("prenom"));
			}
		}
		
		if (request.getParameterMap().containsKey("moyenne")) {
			//le prenom ne doit pas être vide
			if (!request.getParameter("moyenne").isEmpty()) {
				
				etudiant.setMoyenne(Float.parseFloat(request.getParameter("moyenne")));
			}
		}

		int nb_absences = -1;
		//permet de modif le nb d'absences directement avec l'id
		String[] absences_params = { "absences[" + id + "]", "absences" };
		for (String absences_param : absences_params) {
			if (request.getParameterMap().containsKey(absences_param)) {
				if (!request.getParameter(absences_param).isEmpty()) {
					nb_absences = Integer.parseInt(request.getParameter(absences_param));
					if (nb_absences >= 0) {
						etudiant.setNbAbsences(nb_absences);
					}
				}
			}
		}
		
		float note_moyenne = 0;
		//permet de modif le nb d'absences directement avec l'id
		String[] moyenne_params = { "moyenne[" + id + "]", "moyenne" };
		for (String moyenne_param : moyenne_params) {
			if (request.getParameterMap().containsKey(moyenne_param)) {
				if (!request.getParameter(moyenne_param).isEmpty()) {
					note_moyenne = Float.parseFloat(request.getParameter(moyenne_param));
					if (note_moyenne >= 0) {
						etudiant.setMoyenne(note_moyenne);
					}
				}
			}
		}
		
		return EtudiantDAO.miseAJour(etudiant);
	}
	
	/**
	 * Modification du nombre d'absences au click des boutons "+" ou "-"
	 * @param request
	 * @param response
	 * @param typeModification
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modifierAbsence(HttpServletRequest request, HttpServletResponse response, String typeModification)throws ServletException, IOException {

		//même principe que pour la fonction modifierEtudiant
		Etudiant etudiant = new Etudiant();
		etudiant = EtudiantDAO.retrieveById(Integer.parseInt(request.getParameter("id")));
		
		//Selon le type de modification on appel la méthode qui correspond
		if (typeModification.equals("ajouterAbsence")) {
			etudiant.ajouterAbsence();
		}
		else if (typeModification.equals("supprimerAbsence")){
			etudiant.supprimerAbsence();
		}
		
		//Maj en base de l'étudiant pour ses absences
		EtudiantDAO.miseAJour(etudiant);
		
		//si la page précédente est un détail on y reste, sinon on retourne à la liste
		if (session.getAttribute("page_precedente").equals("/detailEtudiant")) {
			response.sendRedirect("detailEtudiant?id=" + etudiant.getId());
		} else if (session.getAttribute("page_precedente").equals("/listeEtudiants")) {
			response.sendRedirect("listeEtudiants");
		}
	}

	/* ------------------------------- CHARGEMENT DE DONNES EN BASE ----------------------------------- */
	/**
	 * Remplissage de données dans la base si les données se sont pas déjà éxistantes
	 */
	private void remplissageDonnees() {

		//Initialisation des licences
		Licence belli_simo = new Licence();
		Licence miaouh = new Licence();
		Licence big_d = new Licence();
		Licence lezotre = new Licence();
		
		//Ne pas les recréer les licences si elles éxistent déjà
			if (LicenceDAO.getAll().size() == 0) {
				belli_simo = LicenceDAO.creer("BELLI SIMO");
				miaouh = LicenceDAO.creer("MIAOUH");
				big_d = LicenceDAO.creer("BIG D");
				lezotre = LicenceDAO.creer("LEZOTR");
			}
		

		//s'il n'y a pas d'étudiants, on les ajoute en base
		if (EtudiantDAO.getAll().size() == 0) {
			Etudiant trompe = new Etudiant();
			trompe = EtudiantDAO.creer("Trompe", "DONALD", belli_simo);
			Etudiant franco = new Etudiant();
			franco = EtudiantDAO.creer("Français", "FRANCO", miaouh);
			Etudiant fidel = new Etudiant();
			fidel = EtudiantDAO.creer("Gastro", "FIDEL", big_d);
			Etudiant kim_kong = new Etudiant();
			kim_kong = EtudiantDAO.creer("Un", "KIM KONG", lezotre);
			
			Etudiant dalor = new Etudiant();
			dalor = EtudiantDAO.creer("Omer", "DALOR", belli_simo);
			Etudiant karena = new Etudiant();
			karena = EtudiantDAO.creer("Emma", "KARENA", miaouh);
			Etudiant lebriz = new Etudiant();
			lebriz = EtudiantDAO.creer("Sam", "LEBRIZ", big_d);
			Etudiant touille = new Etudiant();
			touille = EtudiantDAO.creer("Sacha", "TOUILLE", lezotre);
		}
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
	public void loadJSP(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
