<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html">

<%-- Directives de page import --%>
<%@ page import="java.util.*"%>
<%@ page import="jeu.JeuFactory"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Jeu 1</title>
	</head>
	<body>
  
  		<%-- Element d'action : jsp:include --%>
  		<jsp:include page="/commun/entetedepage.jsp"/>
  
  		<%-- Element de script : Déclaration --%> 
		<%!
			private int nombreVisites = 0;
			private String mainJoueur = null;
			private String mainOrdinateur= null;
	
			// Méthode exécutée au chargement de la JSP
			public void jspInit() {
				nombreVisites = 0;
			}
		%>
	
		<h3>Résultat</h3>
	
		<%-- Element de script : Scriptlet --%> 
		<%
			// Récupération du paramètre mainJoueur
			mainJoueur = request.getParameter("mainJoueur");
		
			// Classe JeuFactory importée par la directive "page import="fr.iut2.tc4.jeu1.JeuFactory"
			mainOrdinateur = JeuFactory.randomMain();
		%>
  	
	  	<%-- Element de script : Expression --%> 
	  	Joueur <img src="/Jeu/ressources/<%= mainJoueur %>.jpg"/> 
	  	vs Ordinateur <img src="/Jeu/ressources/<%= mainOrdinateur %>.jpg"/>
  	
  	
  		<%
  			if (mainJoueur.equals(mainOrdinateur)) { 
  		%>
		<h3>Egalité !</h3>
		<% 
			} else if ( (mainJoueur.equals("pierre") && (mainOrdinateur.equals("papier")))
						|| (mainJoueur.equals("papier") && (mainOrdinateur.equals("ciseaux")))
						|| (mainJoueur.equals("ciseaux") && (mainOrdinateur.equals("pierre")))) { 
		%>
		<h3>Ordinateur gagne !</h3>
		<% 
			} else {
		%>
		<h3>Joueur gagne !</h3>
		<% 
			}
		%>

		<p><a href="jeu.jsp">rejouer</a></p>
 
 		<%
 			// Type Date importé par la directive "page import="java.util.Date""
    		Date date = new Date();
 		
 			// Variable initialisée par la méthode jspInit exécutée lors de chargement de la JSP
    		nombreVisites++;
		%>
		
		<p>Au moment de l'exécution de ce script, nous sommes le <%= date %>.</p>
		<p>Cette page a été affichée <%= nombreVisites %> fois!</p>
 	
 		<%-- Element d'action : jsp:include --%>
 		<jsp:include page="/commun/pieddepage.jsp"/>
 		
  	</body>
</html>
