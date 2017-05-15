<%@ page import="data.Voiture"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="voitures" type="java.util.List<data.Voiture>" scope="request"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<title><%=getServletContext().getInitParameter("title")%></title>
</head>
<body>

	
	<ul class="nav nav-tabs">
		<li role="accueil"><a href="<%= getServletContext().getContextPath()%>/do/accueil">Accueil</a></li>
	  <li role="utilisateurs" ><a href="<%= getServletContext().getContextPath()%>/do/listUtilisateurs">Utilisateurs</a></li>
	  <li role="voitures"  class="active"><a href="#">Voitures</a></li>
	</ul>

<%-- --%>
<jsp:include page="<%= getServletContext().getInitParameter(\"entetedepage\")%>" />
		
<%-- A compléter --%>
	<table class="table table-bordered table-striped">
		<tr>
		  <th>Immatriculation</th>
		  <th>Modèle</th>
		  <th>Propriétaire</th>
		</tr>
		<% for (Voiture voit : voitures) { %> 
			<tr>
			  <td><%= voit.getImmatriculation() %></td>
			  <td><%= voit.getModele() %></td>
			  <td><a href="#"></a></td>
			</tr>
			<%
		} %>
	</table>

<%-- --%>
<jsp:include page="<%= getServletContext().getInitParameter(\"pieddepage\")%>"/>
</body>
</html>