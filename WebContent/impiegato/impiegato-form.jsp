<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="roma.academy.model.Impiegato"%>
<%@page import="roma.academy.dao.ImpiegatoDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	System.out.println("IMPIEGATO-FORM-INIZIO");
	Impiegato impiegatoToUpdate = new Impiegato();
	String idToUpdate = request.getParameter("id");
	System.out.println("IMPIEGATO-FORM: ID " + idToUpdate);
	if(idToUpdate != null){
		ImpiegatoDao impiegatoDao = new ImpiegatoDao();
		impiegatoToUpdate = impiegatoDao.getById(Integer.parseInt(idToUpdate));
		System.out.println("get-by-id method: " + impiegatoToUpdate.toString());
	}
	
	String formAction = idToUpdate != null ? "../ImpiegatoUpdateServlet" : "../ImpiegatoInsertServlet";
	System.out.println("FORM-ACTION: " + formAction);
%>

	<form action="<%=formAction%>" method="post">
		<%
			if ((Integer)impiegatoToUpdate.getId() != null){
				System.out.println("IMPIEGATO-FORM-UPDATE");
				System.out.println("ID TO UPDATE: " + (Integer)impiegatoToUpdate.getId());
				System.out.println(formAction);
		%>
		<input type="hidden" name="id" value="<%=impiegatoToUpdate.getId()%>">
		<%
			}
		%>
		Nome:<br> <input type="text" name="nome"  value="<%out.print(impiegatoToUpdate.getNome() != null ? impiegatoToUpdate.getNome() : "");%>"><br>
		
		Cognome:<br> <input type="text" name="cognome" value="<%out.print(impiegatoToUpdate.getCognome() != null ? impiegatoToUpdate.getCognome() : "");%>"><br>
		
		<input type="submit" value="submit">
		
	</form>
</body>
</html>