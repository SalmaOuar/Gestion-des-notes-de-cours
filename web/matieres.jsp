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
    <meta charset="UTF-8">
    <title>Gestion des Matières</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5 bg-white p-4 rounded shadow-sm">
    <h2 class="mb-4 text-primary">📚 Liste des matières</h2>

    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th>Nom</th>
                <th style="width: 180px;">Actions</th>
            </tr>
        </thead>
        <tbody>
            <% for (Matiere m : matieres) { %>
                <tr>
                    <td><%= m.getNom() %></td>
                    <td>
                        <form method="post" action="MatiereServlet" class="d-inline">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="<%= m.getId() %>">
                            <button type="submit" class="btn btn-sm btn-danger"
                                    onclick="return confirm('Supprimer cette matière ?')">🗑 Supprimer</button>
                        </form>

                        <form method="get" action="editMatiere.jsp" class="d-inline">
                            <input type="hidden" name="id" value="<%= m.getId() %>">
                            <button type="submit" class="btn btn-sm btn-warning">✏ Modifier</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <hr>

    <h5 class="mb-3">➕ Ajouter une nouvelle matière</h5>
    <form method="post" action="MatiereServlet" class="row g-3">
        <input type="hidden" name="action" value="create">
        <div class="col-md-8">
            <input type="text" name="nom" class="form-control" placeholder="Nom de la matière" required>
        </div>
        <div class="col-md-4">
            <button type="submit" class="btn btn-success w-100">Ajouter</button>
        </div>
    </form>
</div>

</body>
</html>
