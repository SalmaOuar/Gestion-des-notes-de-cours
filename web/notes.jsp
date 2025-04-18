<%@page import="entities.Matiere"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.NoteCours" %>
<%@ page import="dao.NoteCoursDao" %>
<%@ page import="entities.Enseignant" %>
<%
    Enseignant ens = (Enseignant) session.getAttribute("user");
    NoteCoursDao dao = new NoteCoursDao();
    List<NoteCours> notes = dao.findByEnseignant(ens);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Mes Notes</h2>
        <ul>
            <% for (NoteCours n : notes) {%>
            <li><%= n.getTitre()%> : <%= n.getContenu()%></li>
                <% } %>
        </ul>
        <form method="post" action="NoteServlet">
            <input type="text" name="titre" placeholder="Titre">
            <input type="number" name="contenu" step="0.1" placeholder="Note">
            <select name="matiereId">
                <% for (Matiere m : new dao.MatiereDao().findAll()) {%>
                <option value="<%= m.getId()%>"><%= m.getNom()%></option>
                <% }%>
            </select>
            <button type="submit">Ajouter</button>
        </form>
    </body>
</html>
