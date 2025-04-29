<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.NoteCours, dao.NoteCoursDao, entities.Enseignant, entities.Matiere, entities.CommentaireNote" %>

<%@ page import="entities.User, entities.Enseignant" %>
<%
    User u = (User) session.getAttribute("user");
    if (u == null) {
        response.sendRedirect("login.jsp?error=session");
        return;
    }

    if (!(u instanceof Enseignant)) {
        response.sendRedirect("login.jsp?error=unauthorized");
        return;
    }

    Enseignant ens = (Enseignant) u;
%>
<%
    NoteCoursDao dao = new NoteCoursDao();
   List<NoteCours> notes = dao.findByEnseignantWithCommentaires(ens);
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notes</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f5f7fa;
            padding: 40px;
            color: #333;
        }
        h2 {
            color: #2c3e50;
        }
        .note-card {
            background: #ffffff;
            padding: 20px;
            margin-bottom: 25px;
            border-radius: 8px;
            box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
        }
        .note-title {
            font-weight: bold;
            font-size: 1.1rem;
        }
        .note-content {
            margin-top: 5px;
            color: #555;
        }
        .form-ajout-note, .form-commentaire {
            margin-top: 20px;
        }
        input[type="text"], input[type="number"], select, textarea {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            margin-right: 10px;
            width: 200px;
        }
        textarea {
            resize: none;
            width: 300px;
            height: 60px;
        }
        button {
            padding: 10px 16px;
            background-color: #2d89ef;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }
        button:hover {
            background-color: #1b5cb8;
        }
        .commentaire {
            margin-top: 10px;
            margin-left: 20px;
            font-style: italic;
            background-color: #f0f0f0;
            padding: 8px;
            border-radius: 5px;
        }
        .commentaire-title {
            margin-top: 15px;
            font-weight: bold;
            color: #2c3e50;
        }
    </style>
</head>
<body>

    <h2>Notes</h2>

    <% for (NoteCours n : notes) { %>
        <div class="note-card">
            <div class="note-title"><%= n.getTitre() %> : <%= n.getContenu() %> /20</div>
            <div class="note-content">Matière : <%= n.getMatiere().getNom() %></div>

           
            <% List<CommentaireNote> comms = n.getCommentaires(); %>
            <% if (comms != null && !comms.isEmpty()) { %>
                <div class="commentaire-title">Commentaires :</div>
                <% for (CommentaireNote c : comms) { %>
                    <div class="commentaire">• <%= c.getContenu() %></div>
                <% } %>
            <% } else { %>
                <div class="commentaire">Aucun commentaire pour cette note.</div>
            <% } %>

            
            <form class="form-commentaire" method="post" action="CommentaireServlet">
                <input type="hidden" name="noteId" value="<%= n.getId() %>">
                <textarea name="contenu" placeholder="Ajouter un commentaire..." required></textarea>
                <br>
                <button type="submit">💬 Commenter</button>
            </form>
        </div>
    <% } %>

   
    <div class="note-card">
        <h3>Ajouter une nouvelle note</h3>
        <form class="form-ajout-note" method="post" action="NoteServlet">
            <input type="text" name="titre" placeholder="Titre" required>
            <input type="number" name="contenu" step="0.1" min="0" max="20" placeholder="Note" required>
            <select name="matiereId" required>
                <% for (Matiere m : new dao.MatiereDao().findAll()) { %>
                    <option value="<%= m.getId() %>"><%= m.getNom() %></option>
                <% } %>
            </select>
            <button type="submit">➕ Ajouter</button>
        </form>
    </div>

</body>
</html>
