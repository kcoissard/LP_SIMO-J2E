<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Objets implicites</title>
</head>
<body>

	<%-- REQUEST --%>
   	request.CharacterEncoding = <%=request.getCharacterEncoding() %><br/>
   	
   	<%-- RESPONSE --%>
   	response.ContentType = <%=response.getContentType() %><br/>
   	
   	<%-- CONFIG --%>
   	config.ServletName = <%=config.getServletName() %><br/>
   	
	<%
	// OUT
	out.print("out : flot de sortie qui permet l'écriture sur la réponse");
	out.print("<br/>");
			
	// SESSION
	Integer nombreVisiteUtilisateur = (Integer)session.getAttribute("nombreVisiteUtilisateur");
	if (nombreVisiteUtilisateur == null) {
		nombreVisiteUtilisateur = 1;
		session.setAttribute("nombreVisiteUtilisateur", nombreVisiteUtilisateur);
	} else {
		nombreVisiteUtilisateur++;
		session.setAttribute("nombreVisiteUtilisateur", nombreVisiteUtilisateur);
	}
	%>
	session.nombreVisiteUtilisateur = <%=nombreVisiteUtilisateur %><br/>
	
	<%
	// APPLICATION
	Integer nombreVisiteApplication = (Integer)application.getAttribute("nombreVisiteApplication");
	if (nombreVisiteApplication == null) {
		nombreVisiteApplication = 1;
		application.setAttribute("nombreVisiteApplication", nombreVisiteApplication);
	} else {
		nombreVisiteApplication++;
		application.setAttribute("nombreVisiteApplication", nombreVisiteApplication);
	}
	%>
	application.nombreVisiteApplication = <%=nombreVisiteApplication %><br/>
	

</body>
</html>