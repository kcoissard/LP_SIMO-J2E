<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Jeu 2</title>
	</head>
	<body>
		<%-- Element d'action : jsp:include --%>
		<jsp:include page="/commun/entetedepage.jsp"/>
	
		<%-- Formulaire --%>
		<h3>Choisissez une main (v2)</h3>
		<form method="post" action="resultat.jsp">
			<img src="/Jeu/ressources/pierre.jpg"/><input type="radio" name="mainJoueur" value="pierre"/>Pierre
			<img src="/Jeu/ressources/papier.jpg"/><input type="radio" name="mainJoueur" value="papier"/>Papier
			<img src="/Jeu/ressources/ciseaux.jpg"/><input type="radio" name="mainJoueur" value="ciseaux"/>Ciseaux
			<input type="submit" value="Valider"/>
		</form>
		
		<%-- Element d'action : jsp:include --%>
		<jsp:include page="/commun/pieddepage.jsp"/>
		
	</body>
</html>
