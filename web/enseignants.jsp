<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.EnseignantDao" %>
<%@ page import="entities.Enseignant" %>

<%
    List<Enseignant> enseignants = new EnseignantDao().findAll();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gérer les Enseignants</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-5 bg-light">

<div class="container bg-white p-4 rounded shadow-sm">
    <h2 class="mb-4">Liste des enseignants</h2>

    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th>Nom</th>
                <th>Email</th>
                <th>Spécialité</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% for (Enseignant e : enseignants) { %>
                <tr>
                    <td><%= e.getNom() %></td>
                    <td><%= e.getEmail() %></td>
                    <td><%= e.getSpecialite() %></td>
                    <td>
                        <form method="post" action="EnseignantServlet" style="display:inline;">
                            <input type="hidden" name="id" value="<%= e.getId() %>">
                            <input type="hidden" name="action" value="delete">
                            <button class="btn btn-danger btn-sm" onclick="return confirm('Supprimer cet enseignant ?')">🗑 Supprimer</button>
                        </form>

                        <form method="get" action="editEnseignant.jsp" style="display:inline;">
                            <input type="hidden" name="id" value="<%= e.getId() %>">
                            <button class="btn btn-warning btn-sm">✏ Modifier</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <hr>

    <h4>Ajouter un enseignant</h4>
    <form method="post" action="EnseignantServlet" class="row g-3 mt-3">
         <input type="hidden" name="action" value="create">
        <div class="col-md-4">
            <input type="text" name="nom" class="form-control" placeholder="Nom" required>
        </div>
        <div class="col-md-4">
            <input type="email" name="email" class="form-control" placeholder="Email" required>
        </div>
        <div class="col-md-4">
            <input type="text" name="specialite" class="form-control" placeholder="Spécialité" required>
        </div>
        <div class="col-md-12">
            <input type="password" name="password" class="form-control" placeholder="Mot de passe" required>
        </div>
        <div class="col-md-12 text-end">
            <button type="submit" class="btn btn-primary">➕ Ajouter</button>
        </div>
    </form>
</div>

</body>
</html>
