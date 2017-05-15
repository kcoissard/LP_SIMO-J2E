<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="partie" class="jeu.data.Partie" scope="request"/>
<jsp:useBean id="resultat" class="jeu.data.Resultat" scope="session"/>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<%--  on récupère les paramètres d'initialisation de la servlet --%>
		<title><%= getServletContext().getInitParameter("title")%></title>
	</head>
	<body>
  
  		<%-- Element d'action : jsp:include --%>
  		<jsp:include page="<%= getServletContext().getInitParameter(\"entetedepage\")%>"/>
  
		<h3>Résultat</h3>
  	
	  	<%-- Element de script : Expression --%> 
	  	Joueur <img src="<%= getServletContext().getContextPath()%>/ressources/<%=partie.getMainJoueur()%>.jpg"/> 
  		vs Ordinateur <img src="<%= getServletContext().getContextPath()%>/ressources/<%=partie.getMainOrdinateur()%>.jpg"/>
		
		<h3>
  		<% 	if (partie.egalite()) { 
			out.append("Egalité !");
		} else if (partie.joueurGagne()) {
			out.append("Joueur gagne !");
		} else {
			out.append("Ordinateur gagne !");
		}%>
		</h3>
		
  		<p>nombre de victoires : <jsp:getProperty name="resultat" property="nombreVictoire" /></p>
  		<p>nombre de défaites : <jsp:getProperty name="resultat" property="nombreDefaite" /></p>
  		<p>nombre d'égalités : <jsp:getProperty name="resultat" property="nombreEgalite" /></p>
  	
		<p><a href="<%= getServletContext().getContextPath()%>/do/jeu">rejouer</a></p>
 	
 		<%-- Element d'action : jsp:include --%>
 		<jsp:include page="<%= getServletContext().getInitParameter(\"pieddepage\")%>"/>
 		
  	</body>
</html>
