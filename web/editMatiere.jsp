<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.MatiereDao, entities.Matiere" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Matiere m = new MatiereDao().findById(id);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier Matière</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">

        <div class="container mt-5 bg-white p-4 rounded shadow-sm">
            <h4 class="text-warning">✏ Modifier la matière</h4>
            <form method="post" action="MatiereServlet" class="mt-4">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="<%= m.getId()%>">

                <div class="mb-3">
                    <label class="form-label">Nom de la matière :</label>
                    <input type="text" name="nom" class="form-control" value="<%= m.getNom()%>" required>
                </div>

                <button type="submit" class="btn btn-primary">💾 Enregistrer</button>
                <a href="matieres.jsp" class="btn btn-secondary">Retour</a>
            </form>
        </div>
    </body>
</html>
