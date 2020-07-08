<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="roma.academy.model.Impiegato"%>
<%@page import="roma.academy.dao.ImpiegatoDao"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String miaVar = (String)request.getSession().getAttribute("miaVar");
ImpiegatoDao impiegatoDao = new ImpiegatoDao();
ArrayList<Impiegato> tmp = impiegatoDao.getList();
if(miaVar != null) out.print(miaVar);
%>


	<table border="1px">
	<tr>
		<th>Id</th>
    	<th>Nome</th>
    	<th>Cognome</th>
 	 </tr>

<%
	for(int i=0; i< tmp.size(); i++) { 
  			Impiegato imp = tmp.get(i); 
%> 
						<tr>
							    <td><% out.print(imp.getId()); %><br /></td>
							    <td><%=imp.getNome()%><br /></td>
								<td><%=imp.getCognome()%><br /></td>
								<td>
									<form action="<%=request.getServletContext().getContextPath()%>/ImpiegatoDeleteByIdServlet" method="post">
										<input type="hidden" name="id" value="<%=imp.getId()%>">
										<input type="submit" value="CANCELLA">
									</form>
								</td>
								<td>
									<form action="<%=request.getServletContext().getContextPath()%>/impiegato/impiegato-form.jsp">
										<input type="hidden" name="id" value="<%=imp.getId()%>">
										<input type="submit" value="MODIFICA">
									</form>
								</td>
								
						</tr>

<% 
	}  		
%> 
 
	</table>
	<table>
		<tr>
			<td>
				<form action="<%=request.getServletContext().getContextPath()%>/impiegato/impiegato-form.jsp" method="get">
					<input type="submit" value="INSERISCI IMPIEGATO">
				</form>
			</td>		
		</tr>
	</table>
	

	
</body>
</html>