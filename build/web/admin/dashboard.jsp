<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entities.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof entities.Admin)) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard Admin</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <style>
        body {
            margin: 0;
            font-family: 'Poppins', sans-serif;
            background-color: #f3f5f7;
        }

        header {
            background-color: #2c3e50;
            padding: 20px 40px;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        header h1 {
            margin: 0;
            font-size: 24px;
            display: flex;
            align-items: center;
        }

        header img {
            width: 32px;
            margin-right: 10px;
        }

        .container {
            max-width: 1000px;
            margin: 50px auto;
            text-align: center;
        }

        .cards {
            display: flex;
            justify-content: center;
            gap: 40px;
            flex-wrap: wrap;
            margin-top: 40px;
        }

        .card {
            background-color: #fff;
            padding: 25px;
            width: 240px;
            border-radius: 10px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            transition: transform 0.3s;
        }

        .card:hover {
            transform: translateY(-8px);
        }

        .card img {
            width: 80px;
            height: 80px;
        }

        .card a {
            display: block;
            margin-top: 15px;
            text-decoration: none;
            color: #2980b9;
            font-weight: bold;
            font-size: 17px;
        }

        .logout {
            margin-top: 50px;
        }

        .logout a {
            background-color: #e74c3c;
            color: white;
            padding: 10px 25px;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
            transition: background 0.3s;
        }

        .logout a:hover {
            background-color: #c0392b;
        }
    </style>
    </head>
    <body>
        <header>
    <h1><img src="https://cdn-icons-png.flaticon.com/512/906/906175.png" alt="icon"> Tableau de bord Admin</h1>
    <div>Bienvenue Admin : <strong><%= user.getNom() %></strong></div>
</header>

<div class="container">
    <div class="cards">
        <div class="card">
            <img src="https://cdn-icons-png.flaticon.com/512/2232/2232688.png" alt="notes">
            <a href="../notes.jsp">Gérer les notes</a>
        </div>
        <div class="card">
            <img src="https://cdn-icons-png.flaticon.com/512/3659/3659899.png" alt="matières">
            <a href="../matieres.jsp">Gérer les matières</a>
        </div>
    </div>

    <div class="logout">
        <a href="../logout.jsp">📤 Déconnexion</a>
    </div>
</div>
    </body>
</html>
