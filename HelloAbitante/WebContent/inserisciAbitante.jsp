<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento abitante</title>
</head>
<body>

Inserimento dati abitante da inserire: <br><br>
<form action = "ExecuteInsertAbitanteServlet" method = "post">



<input type=hidden name="nomeInput" value="<%=request.getAttribute("nomeInput")%>"> 
<input type=hidden name="cognomeInput" value="<%=request.getAttribute("cognomeInput")%>">

<table>
<tr><td>Nome:</td><td> <input type="text" name = nomeIns></td></tr>
<tr><td>Cognome:</td><td> <input type="text" name = cognomeIns></td></tr>
<tr><td>Codice fiscale:</td><td><input type = "text" name = codicefiscaleIns></td></tr>
<tr><td>Eta':</td><td><input type = "text" name = etaIns ></td></tr>
<tr><td>Motto di vita:</td><td><input type = "text" name = mottodivitaIns></td></tr>

</table>

<input type =submit value = Inserisci>
</form>
<br>
<a href="searchForm.jsp">Torna alla home</a>

</body>
</html>