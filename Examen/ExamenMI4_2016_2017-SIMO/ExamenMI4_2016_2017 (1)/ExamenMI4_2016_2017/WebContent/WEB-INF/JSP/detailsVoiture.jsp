<%@page import="data.Voiture"%>

<%@ page import="java.util.*"%>
<%@ page import="data.*"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="voiture" type="data.Voiture" scope="request"/>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title><%=getServletContext().getInitParameter("title")%></title>
</head>
<body>

<%-- --%>
<jsp:include page="<%= getServletContext().getInitParameter(\"entetedepage\")%>" />


<%-- A compléter --%>
<h3>Détail de la voiture</h3>
<ul>
	<li><%= voiture.getImmatriculation() %></li>
	<li><%= voiture.getModele() %></li>
	<li>Proprio pas fini</li>
</ul>


<%--  --%>
<jsp:include page="<%= getServletContext().getInitParameter(\"pieddepage\")%>"/>
</body>
</html>