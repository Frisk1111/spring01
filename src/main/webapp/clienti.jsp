<%@page import="java.util.List"%>
<%@page import="com.example.javadb.entities.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elenco delle regioni italiane</title>
</head>
<body>
<h1>Elenco delle regioni italiane</h1>

<%
// inizio codice java
List<Cliente> clienti = (List<Cliente>) request.getAttribute("elenco-clienti");
// fine codice java

for(Cliente c : clienti) {
%>
	<p><%=c %></p>	<!-- Ripeto n volte il paragrafo -->
<%
}
%>
</body>
</html>