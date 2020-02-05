<%@page import="java.util.List"%>
<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultato della ricerca</title>
</head>
<body>
<b>Risultato della ricerca</b>
<% if (request.getAttribute("nomeInput") != ""){%>
<br>Nome che inizia per: <%=request.getAttribute("nomeInput") %>
<% } %>
<% if (request.getAttribute("cognomeInput") != ""){%>
<br>Cognome che inizia per: <%=request.getAttribute("cognomeInput") %><br>
<% } %>

	<table border="2" align="center">
		<thead>
			<tr>
				<td>Colonna Nome</td>
				<td>Colonna Cognome</td>
				<td colspan="3" align="center">Azione</td>
			</tr>
		</thead>

		<%
			List<Abitante> listaDaServlet = (List<Abitante>) request.getAttribute("listAbitantiAttributeName");
			for (Abitante abitanteItem : listaDaServlet) {
		%>
		<tr>
			<td><%=abitanteItem.getNome()%></td>
			<td><%=abitanteItem.getCognome()%></td>
			<td><a
				href="VisualizzaDettaglioServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante()%>">Dettaglio</a></td>
			<td><a
				href="PrepareModificaAbitanteServlet?
				idDaInviareComeParametro=<%=abitanteItem.getIdAbitante()%>
				&nomeInput=<%=request.getAttribute("nomeInput")%>
				&cognomeInput=<%=request.getAttribute("cognomeInput")%>">Modifica</a></td>
			<td><a
				href="PrepareCancellaAbitanteServlet?
				idDaInviareComeParametro=<%=abitanteItem.getIdAbitante()%>
				&nomeInput=<%=request.getAttribute("nomeInput")%>
				&cognomeInput=<%=request.getAttribute("cognomeInput")%>">Cancella</a></td>
		</tr>
		<%
			}
		%>



	</table>
	
	<center>
	<form action =PrepareInsertAbitanteServlet method = "post">
	<input type=hidden name = nomeInput value = <%=request.getAttribute("nomeInput")%>>
	<input type=hidden name = cognomeInput value = <%=request.getAttribute("cognomeInput")%>>
	<input type = submit value = "Inserisci nuovo">
	</form>
	</center>
	
	<br>
	<br>
	<a href="searchForm.jsp">Torna alla home</a>

</body>
</html>