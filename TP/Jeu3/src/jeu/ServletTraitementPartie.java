package jeu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/servlettraitementpartie")
public class ServletTraitementPartie extends HttpServlet {

	// POST
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// on passe la main au GET
		doGet(request, response);
	}

	// GET
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// Récupérer l'attribut resultat de la session
		Resultat resultat = (Resultat) request.getSession().getAttribute("resultat");
		if (resultat == null) {
			resultat = new Resultat();
			request.getSession().setAttribute("resultat", resultat);
		}

		// Créer une objet de type Partie
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

		// Mettre l'objet jeu en attribut de requête
		request.setAttribute("partie", partie);

		// Méthode qui transfère le contrôle à une autre servlet
		loadJSP("/resultat.jsp", request, response);
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
