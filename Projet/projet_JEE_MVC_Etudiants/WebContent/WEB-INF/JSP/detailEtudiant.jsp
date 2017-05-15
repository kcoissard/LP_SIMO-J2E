<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- Directives de page import --%>
<%@ page import="java.util.*"%>
<%@ page import="projet_JEE_MVC_Etudiants.data.*"%>

<%-- HEADER HTML et includes CSS --%>
<jsp:include page="/WEB-INF/JSP/commun/header.jsp"/>

	<%-- Beans du controleur --%>
	<jsp:useBean id="etudiant" type="projet_JEE_MVC_Etudiants.data.Etudiant" scope="request"/>
	<jsp:useBean id="id_licence" type="java.lang.String" scope="request"/>
	<jsp:useBean id="licences" type="java.util.Collection<projet_JEE_MVC_Etudiants.data.Licence>" scope="request"/>
	


	<%-- Element d'action : jsp:include --%>
	<jsp:include page="<%= getServletContext().getInitParameter(\"entetedepage\")%>" />
	

	<a href="/projet_JEE_MVC_Etudiants/do/listeEtudiants" class="btn btn-default" style="margin-bottom:15px;">Retour à la liste</a><br />
	
	
	<form class="form-horizontal" method="post" action="modifierEtudiant">
	  <input type="hidden" name="id" value="<%= etudiant.getId() %>">
	  <div class="form-group">
	    <label for="prenom" class="col-md-2 control-label">Prénom</label>
	    <div class="col-md-6">
	      <input type="input" class="form-control" name="prenom" id="prenom" value="<%= etudiant.getPrenom() %>" size="20">
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <label for="nom" class="col-md-2 control-label">Nom</label>
	    <div class="col-md-6">
	    	<input type="input" class="form-control" name="nom" id="nom" value="<%= etudiant.getNom() %>" size="20">
	    </div>
	  </div>
	  
	  <div class="form-group">
		  	<div class="col-md-2 control-label"><strong>Absence</strong></div>
		  <div class="col-md-4">
		    <input type="number" class="form-control" name="absence" id="absence" value="<%= etudiant.getNbAbsences() %>">
		  </div>
	  
    	<div class="col-md-2">
    		<a href="ajouterAbsence?id=<%= etudiant.getId() %>" class="btn btn-default">
	   		 <span class="col-md-1">+</span>
   		  </a>
   	  	  <a href="supprimerAbsence?id=<%= etudiant.getId() %>" class="btn btn-default">
	   		 <span class="col-md-1">-</span>
   		  </a>
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <div class="col-md-2 control-label"><strong>Moyenne Générale</strong></div>
	    <div class="col-md-6">
	      <input type="number" step="0.01" class="form-control" name="moyenne" id="moyenne" value="<%= etudiant.getMoyenne() %>">
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Modifier l'étudiant</button>
	    </div>
	  </div>
	</form>
</body>
</html>