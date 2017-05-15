<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ page import="java.util.*"%>
<%@ page import="controleur.*"%>
<%@ page import="data.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		
		
		<%--  on récupère les paramètres d'initialisation de la servlet --%>
		<title><%= getServletContext().getInitParameter("title")%></title>
	</head>
	<body>
	
	<ul class="nav nav-tabs">
		<li role="accueil" class="active"><a href="#">Accueil</a></li>
	  <li role="utilisateurs" ><a href="<%= getServletContext().getContextPath()%>/do/listUtilisateurs">Utilisateurs</a></li>
	  <li role="voitures"><a href="<%= getServletContext().getContextPath()%>/do/listVoitures">Voitures</a></li>
	</ul>

		<%--  --%>
		<jsp:include page="<%= getServletContext().getInitParameter(\"entetedepage\")%>" />
	
		<%-- Formulaire --%>
		<h3>Bienvenue dans note outil de gestion du parc automobile</h3>
		
		<p>Vous trouverez ci-dessous les différents liens utiles :</p>
		
		<%-- A compléter --%>
		<p><a href="<%= getServletContext().getContextPath()%>/do/listUtilisateurs">voir les utilisateurs</a></p>
		<p><a href="<%= getServletContext().getContextPath()%>/do/listVoitures">voir les voitures</a></p>
		
		
		
		<%--  --%>
		<jsp:include page="<%= getServletContext().getInitParameter(\"pieddepage\")%>"/>

	</body>
</html>
