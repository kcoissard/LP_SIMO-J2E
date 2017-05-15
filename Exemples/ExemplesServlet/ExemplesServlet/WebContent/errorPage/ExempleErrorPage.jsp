<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- Directive de page : errorPage --%>
<%@ page errorPage="ErrorDiv.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemple error page</title>
</head>
<body>
	
	<h3>Division de 2 nombres au hasard compris entre 0 et 5</h3>
	<% 	int denom = (int) (Math.random() * 5);
		int numer = (int) (Math.random() * 5);
	%>
	Le résultat de la division de 
	<%=numer %> par <%=denom %> est : <%=numer/denom %>
	
</body>
</html>