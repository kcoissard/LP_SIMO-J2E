<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>


<jsp:useBean id="partie" class="jeu.Partie" scope="request"/>
<jsp:setProperty property="mainJoueur" name="partie"/>

<jsp:useBean id="resultat" class="jeu.Resultat" scope="session"/>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>jeu 2</title>
	</head>
	<body>
  
  		<%-- Element d'action : jsp:include --%>
  		<jsp:include page="/commun/entetedepage.jsp"/>
  
		<h3>Résultat (v2)</h3>
  	
	  	<%-- Element de script : Expression --%> 
	  	Joueur <img src="/Jeu/ressources/<%=partie.getMainJoueur()%>.jpg"/> 
  		vs Ordinateur <img src="/Jeu/ressources/<%=partie.getMainOrdinateur()%>.jpg"/>
		
		<%
  			if (partie.egalite()) { 
  		%>
				<h3>Egalité !</h3>
		<% 
				resultat.addEgalite();
			} else if (partie.joueurGagne()) { 
		%>
				<h3>Joueur gagne !</h3>
		<% 
				resultat.addGagne();
			} else {
		%>
				<h3>Ordinateur gagne !</h3>
		<% 
				resultat.addPerdu();
			}
		%>
  	
  		<p>nombre de victoires : <jsp:getProperty name="resultat" property="nombreVictoire" /></p>
  		<p>nombre de défaites : <jsp:getProperty name="resultat" property="nombreDefaite" /></p>
  		<p>nombre d'égalités : <jsp:getProperty name="resultat" property="nombreEgalite" /></p>
  	
		<p><a href="jeu.jsp">rejouer</a></p>
 	
 		<%-- Element d'action : jsp:include --%>
 		<jsp:include page="/commun/pieddepage.jsp"/>
 		
  	</body>
</html>
