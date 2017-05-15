package fr.iut2.sil4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class exempleServlet
 */
@WebServlet("/ExempleHttpServletToHTML")
public class ExempleHttpServletToHTML extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// DATA
	private Date dateInit;
	private int nombreChargementPage;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExempleHttpServletToHTML() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		dateInit = new Date();
		nombreChargementPage = 0;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Content type
		response.setContentType("text/html");
    	response.setCharacterEncoding("UTF-8");
		
		// Content 
		PrintWriter out = response.getWriter() ;
		out.println ("<!DOCTYPE html>") ;
		out.println ("<html>");
		out.println ("<head>");
		out.println ("<title>Bonjour tout le monde !</title>") ;
		out.println ("</head>");
		out.println ("<body>");
		out.println ("<p>Hello world!</p>") ;

		out.println ("<p>Nombre chargement de la page : " + ++nombreChargementPage + "</p>") ;
		out.println ("<p>Date de la visite : " + new Date() + "</p>") ;
		out.println ("<p>Date d'initialisation de la servlet : " + dateInit + "</p>") ;
		out.println ("</body>");
		out.println ("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
