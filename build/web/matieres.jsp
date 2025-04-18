<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.Matiere" %>
<%@ page import="dao.MatiereDao" %>
<%
    MatiereDao dao = new MatiereDao();
    List<Matiere> matieres = dao.findAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matieres Page</title>
    </head>
    <body>
        <h2>Liste des matières</h2>
        <ul>
            <% for (Matiere m : matieres) {%>
            <li><%= m.getNom()%></li>
                <% }%>
        </ul>
        <form method="post" action="MatiereServlet">
            <input type="text" name="nom" placeholder="Nouvelle matière">
            <button type="submit">Ajouter</button>
        </form>
    </body>
</html>
