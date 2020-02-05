<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio abitante</title>
</head>
<body>

<% Abitante abitante = (Abitante) request.getAttribute("abitantecondettagli"); %>

nome: <%= abitante.getNome() %> <br>
cognome:<%= abitante.getCognome() %> <br>
eta:<%= abitante.getEta() %> <br>
codice Fiscale:<%= abitante.getCodiceFiscale() %> <br>
motto di vita:<%= abitante.getMottoDiVita() %> <br>
<br><br>
<a href ="searchForm.jsp">Torna alla home</a>

</body>
</html>