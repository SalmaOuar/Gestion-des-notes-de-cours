<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof entities.Enseignant)) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tableau de bord Enseignant</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap">
    <style>
        body {
            margin: 0;
            font-family: 'Roboto', sans-serif;
            background-image: url('../images/enseignant.jpg'); 
            background-size: cover;
            background-position: center;
            height: 120vh;
        }

        .header {
            background-color: rgba(0, 33, 64, 0.95);
            color: white;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header h2 {
            margin: 0;
        }

        .dashboard {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 100px;
        }

        .card {
            background-color: white;
            border-radius: 12px;
            padding: 30px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
            text-align: center;
            margin-bottom: 20px;
            transition: transform 0.3s ease;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .card img {
            width: 60px;
            margin-bottom: 15px;
        }

        .card a {
            text-decoration: none;
            font-weight: bold;
            font-size: 18px;
            color: #0069d9;
        }

        .logout-btn {
            padding: 12px 25px;
            background-color: #d9534f;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .logout-btn:hover {
            background-color: #c9302c;
        }
    </style>
</head>
<body>
    <div class="header">
        <h2>📘 Tableau de bord Enseignant</h2>
        <span>Bienvenue Enseignant : <strong><%= user.getNom() %></strong></span>
    </div>

    <div class="dashboard">
        <div class="card">
            <img src="https://cdn-icons-png.flaticon.com/512/1828/1828911.png" alt="Ajouter une note" />
            <a href="../notes.jsp">Ajouter une note</a>
        </div>
        <form action="../logout.jsp" method="post">
            <button type="submit" class="logout-btn">🚪 Déconnexion</button>
        </form>
    </div>
</body>
</html>
