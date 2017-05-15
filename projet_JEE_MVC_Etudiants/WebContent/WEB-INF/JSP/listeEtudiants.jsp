<%@ page import="java.util.*"%>
<%@ page import="projet_JEE_MVC_Etudiants.controleur.*"%>
<%@ page import="projet_JEE_MVC_Etudiants.data.*"%>

<%-- HEADER --%>
<jsp:include page="/WEB-INF/JSP/commun/header.jsp"/>


		<%-- Element d'action : jsp:include --%>
		<jsp:include page="<%= getServletContext().getInitParameter(\"entetedepage\")%>" />
			
	
	
	<div class="conteneur_index">
	<!-- Liste des classes en bouton-formulaire : SIMO, BIG-DATA ... -->
		<jsp:include page="/WEB-INF/JSP/commun/listeClasses.jsp"/>
		
		<table class="table table-striped table_etu">
		    
			<thead>
				<tr class="active">
					<td><strong>Nom</strong></td>
					<td><strong>Prénom</strong></td>
					<td><strong>Absences</strong></td>
					<td><strong>Moyenne Générale</strong></td>
					<td><strong>Fiche Etudiant</strong></td>
				</tr>
			</thead>
		
			<tbody>
			
			<%
				for(Etudiant etu : GestionFactory.getEtudiants()){
			%>	<tr>
					<td><%= etu.getNom() %></td>
					<td><%= etu.getPrenom() %></td>
					<td>absences</td>
					<td><%= etu.getMoyenne() %></td>
					<td>
						<form method="post" action="<%= getServletContext().getContextPath()%>/do/detailEtudiant">
							
							<input type="hidden" name="idEtudiant" value="<%= etu.getId() %>"/>
							<button type="submit">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</form>
					</td>
						<!-- detail.jsp?idEtudiant=// etu.getId() -->
				</tr>
			<%
				}
			%>
			</tbody>
			
			<tfoot>
				<tr class="info">
					<td colspan="2">CLASSE ****</td>
					<td>Tot ABS</td>
					<td>Tot Moy</td>
					<td>
						<form method="post" action="<%= getServletContext().getContextPath()%>/do/rentrerNotes">
							
							<input type="hidden" name="idEtudiant" /><!-- Rentrer value nom de classe ici -->
							<button type="submit">
								<span id="boutonRentrerNotes">Ajouter des notes</span>
							</button>
						</form>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	
	
	
		<%-- Element d'action : jsp:include --%>

	</body>
</html>