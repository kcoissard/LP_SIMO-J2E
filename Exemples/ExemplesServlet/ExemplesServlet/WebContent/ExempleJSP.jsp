<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>

<!DOCTYPE html>

<%!
	// DATA
	private Date dateInit;
	private int nombreChargementPage;

	// INITIALISATION
	public void jspInit() {
		dateInit = new Date();
		nombreChargementPage = 0;
	}
%>

<html>
	<head>
		<title>Bonjour tout le monde !</title>
	</head>
	<body>

		<%-- Content --%>
		<p>Hello world !</p>

		<p>Nombre chargement de la page : <%= ++nombreChargementPage%></p>
		<p>Date de la visite : <%= new Date()%></p>
		<p>Date d'initialisation de la servlet : <%= dateInit%></p>
		
	</body>
</html>
