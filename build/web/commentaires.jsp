<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.CommentaireNote" %>
<%@ page import="entities.Enseignant" %>
<%@ page import="dao.CommentaireNoteDao" %>
<%
    Enseignant ens = (Enseignant) session.getAttribute("user");
    List<CommentaireNote> commentaires = new CommentaireNoteDao().findByEnseignant(ens);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Mes commentaires</h2>
        <ul>
            <% for (CommentaireNote c : commentaires) {%>
            <li><%= c.getNote().getTitre()%> : <%= c.getContenu()%></li>
                <% }%>
        </ul>
    </body>
</html>
