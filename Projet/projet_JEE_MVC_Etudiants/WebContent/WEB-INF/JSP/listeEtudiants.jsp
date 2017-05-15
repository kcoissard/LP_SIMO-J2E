<%@ page import="java.util.*"%>
<%@ page import="projet_JEE_MVC_Etudiants.controleur.*"%>
<%@ page import="projet_JEE_MVC_Etudiants.data.*"%>

<%-- HEADER HTML et includes CSS --%>
<jsp:include page="/WEB-INF/JSP/commun/header.jsp"/>


	<%-- Element d'action : jsp:include --%>
	<jsp:include page="<%= getServletContext().getInitParameter(\"entetedepage\")%>" />

	<%-- Beans du controleur --%>
	<jsp:useBean id="etudiants" type="java.util.List<projet_JEE_MVC_Etudiants.data.Etudiant>" scope="request"/>
	<jsp:useBean id="licences" type="java.util.List<projet_JEE_MVC_Etudiants.data.Licence>" scope="request"/>
	<jsp:useBean id="id_licence" type="java.lang.Integer" scope="request"/>

	<%-- Liste des licences --%>
	<form method="get" action="listeEtudiants">
			<br /><jsp:include page="/WEB-INF/JSP/commun/listeLicences.jsp"/><br />
	</form>
		
		<%-- Liste des étudiants modifiable --%>
		<form method="post" action="modifierListe">
			<input type="hidden" name="licence" value="<%= id_licence %>">
			<table class="table table-striped"	>
				<tr	>
				  <th style="text-align:center;">Nom</th>
				  <th style="text-align:center;">Prénom</th>
				  <th style="text-align:center;">Moyenne Générale</th>
				  <th style="text-align:center;">Absence(s)</th>
				  <th style="text-align:center;">Licence</th>
				</tr>
				<% for (Etudiant etu : etudiants) {%> 
					<tr>
					  <input type="hidden" name="id" value="<%= etu.getId() %>">
					  <td><a href="detailEtudiant?id=<%= etu.getId() %>"><%= etu.getNom() %></a></td>
					  <td><a href="detailEtudiant?id=<%= etu.getId() %>"><%= etu.getPrenom() %></a></td>

					  <td>
					  	<input class="form-control" type="number" step="0.01" id="moyenne[<%= etu.getId() %>]" name="moyenne[<%= etu.getId() %>]" value="<%= etu.getMoyenne() %>">
					  </td>
					  <td>
					  	<span><%= etu.getNbAbsences() %>&nbsp;&nbsp;&nbsp;&nbsp;</span>
		
				   	  	  <a href="supprimerAbsence?id=<%= etu.getId() %>&licence=<%= id_licence %>" class="btn btn-default">
					   		 <span><strong>-</strong></span>
				   		  </a>
					  	  <a href="ajouterAbsence?id=<%= etu.getId() %>&licence=<%= id_licence %>" class="btn btn-default">
					   		 <span><strong>+</strong></span>
				   		  </a>
					  </td>
					  <td><%= etu.getLicence().getLibelle() %> </td>
					</tr>
					<%
				} %>
			</table>
			<input class="btn btn-default" type="submit" id="envoyer" name="envoyer" value="Modifier">
		</form>
	</body>
</html>