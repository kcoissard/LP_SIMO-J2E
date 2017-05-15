package fr.iut2.sil4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ExempleGenericServlet
 */
@WebServlet("/ExempleGenericServletToHTML")
public class ExempleGenericServletToHTML extends GenericServlet {
	private static final long serialVersionUID = 1L;
    
	// DATA
	private Date dateInit;
	private int nombreChargementPage;
	
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ExempleGenericServletToHTML() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	dateInit = new Date();
    	nombreChargementPage = 0;
    }
    
	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    	
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

}
