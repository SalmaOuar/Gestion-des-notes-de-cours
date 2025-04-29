<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.EnseignantDao" %>
<%@ page import="entities.Enseignant" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Enseignant enseignant = new EnseignantDao().findById(id);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Enseignant</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-5 bg-light">

<div class="container bg-white p-4 rounded shadow-sm">
    <h2 class="mb-4">Modifier Enseignant</h2>

    <form action="EnseignantServlet" method="post" class="row g-3">
        <!-- Champ caché pour l'ID -->
        <input type="hidden" name="id" value="<%= enseignant.getId() %>">
        <input type="hidden" name="action" value="update">

        <div class="col-md-4">
            <label class="form-label">Nom</label>
            <input type="text" name="nom" value="<%= enseignant.getNom() %>" class="form-control" required>
        </div>

        <div class="col-md-4">
            <label class="form-label">Email</label>
            <input type="email" name="email" value="<%= enseignant.getEmail() %>" class="form-control" required>
        </div>

        <div class="col-md-4">
            <label class="form-label">Spécialité</label>
            <input type="text" name="specialite" value="<%= enseignant.getSpecialite() %>" class="form-control" required>
        </div>

        <div class="col-md-12">
            <label class="form-label">Nouveau mot de passe (laisser vide si inchangé)</label>
            <input type="password" name="password" class="form-control">
        </div>

        <div class="col-md-12 text-end">
            <button type="submit" class="btn btn-warning">💾 Enregistrer les modifications</button>
            <a href="enseignants.jsp" class="btn btn-secondary">↩ Retour</a>
        </div>
    </form>
</div>

</body>
</html>
