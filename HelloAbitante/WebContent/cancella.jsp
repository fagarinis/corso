<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cancellazione</title>
</head>
<body>

	Ecco i dati del cliente:
	<br>

	<%
		Abitante abitante = (Abitante) request.getAttribute("abitantepreparatoperlacancellazione");
	%>

	nome:
	<%=abitante.getNome()%>
	<br> cognome:<%=abitante.getCognome()%>
	<br> eta:<%=abitante.getEta()%>
	<br> codice Fiscale:<%=abitante.getCodiceFiscale()%>
	<br> motto di vita:<%=abitante.getMottoDiVita()%>
	<br>
	<br> vuoi cancellare?
	
	<form action= "ExecuteCancellaAbitanteServlet"  method="post">

		<input type=hidden name="idabitantedacancellare" value="<%=abitante.getIdAbitante()%>"> 
		<input type="submit" value="Cancella">
		
		<input type=hidden name="nomeInput" value="<%=request.getAttribute("nomeInput")%>"> 
		<input type=hidden name="cognomeInput" value="<%=request.getAttribute("cognomeInput")%>">

	</form>
<br>
<a href ="searchForm.jsp">Torna alla home</a>




</body>
</html>