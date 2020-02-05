<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>form modifica</title>
</head>
<body>


<% Abitante abitante = (Abitante) request.getAttribute("abitantepreparatoperlamodifica"); %>

Modifica dati: <br><br>
<form action = "ExecuteModificaAbitanteServlet" method = "post">

<input type= hidden name = id value =<%= abitante.getIdAbitante() %>> <br>

<input type=hidden name="nomeInput" value="<%=request.getAttribute("nomeInput")%>"> 
<input type=hidden name="cognomeInput" value="<%=request.getAttribute("cognomeInput")%>">

<table>
<tr><td>Nome:</td><td> <input type="text" name = nomeMod value =<%= abitante.getNome() %>></td></tr>
<tr><td>Cognome:</td><td> <input type="text" name = cognomeMod value = <%= abitante.getCognome() %>></td></tr>
<tr><td>Codice fiscale:</td><td><input type = "text" name = codicefiscaleMod value = <%=abitante.getCodiceFiscale() %>></td></tr>
<tr><td>Eta':</td><td><input type = "text" name = etaMod value = <%=abitante.getEta() %>></td></tr>
<tr><td>Motto di vita:</td><td><input type = "text" name = mottodivitaMod value = <%=abitante.getMottoDiVita() %>></td></tr>

</table>

<input type =submit value = Modifica>
 

</form>

</body>
</html>