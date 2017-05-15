<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<%--  on récupère les paramètres d'initialisation de la servlet --%>
		<title><%= getServletContext().getInitParameter("title")%></title>
	</head>
	<body>

		<%-- Element d'action : jsp:include --%>
		<jsp:include page="<%= getServletContext().getInitParameter(\"entetedepage\")%>" />
	
		<%-- Formulaire --%>
		<h3>Choisissez une main</h3>
		<form method="post" action="<%= getServletContext().getContextPath()%>/do/resultat">
			<img src="<%= getServletContext().getContextPath()%>/ressources/pierre.jpg"/>
			<input type="radio" name="mainJoueur" value="pierre"/>Pierre
			<img src="<%= getServletContext().getContextPath()%>/ressources/papier.jpg"/>
			<input type="radio" name="mainJoueur" value="papier"/>Papier
			<img src="<%= getServletContext().getContextPath()%>/ressources/ciseaux.jpg"/>
			<input type="radio" name="mainJoueur" value="ciseaux"/>Ciseaux
			<input type="submit" value="Valider"/>
		</form>
		
		<%-- Element d'action : jsp:include --%>
		<jsp:include page="<%= getServletContext().getInitParameter(\"pieddepage\")%>"/>

	</body>
</html>
