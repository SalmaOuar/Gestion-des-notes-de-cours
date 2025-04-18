<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entities.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard Enseignant</title>
        <style>
            body {
                margin: 0;
                font-family: 'Segoe UI', sans-serif;
                background-color: #f3f6f9;
            }

            .header {
                background-color: #2c3e50;
                color: white;
                padding: 15px 30px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .header h1 {
                font-size: 22px;
                display: flex;
                align-items: center;
            }

            .header img {
                width: 32px;
                margin-right: 10px;
            }

            .content {
                padding: 40px;
                display: flex;
                flex-direction: column;
                align-items: flex-start;
            }

            .card {
                background-color: #ffffff;
                border-radius: 10px;
                padding: 20px 40px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                margin-bottom: 20px;
                display: flex;
                align-items: center;
                transition: 0.3s;
            }

            .card:hover {
                transform: translateY(-3px);
            }

            .card img {
                width: 48px;
                margin-right: 20px;
            }

            .card a {
                text-decoration: none;
                font-size: 18px;
                color: #3498db;
                font-weight: bold;
            }

            .logout {
                background-color: #e74c3c;
                color: white;
                border: none;
                padding: 12px 20px;
                border-radius: 6px;
                cursor: pointer;
                font-size: 15px;
                display: flex;
                align-items: center;
                text-decoration: none;
            }

            .logout:hover {
                background-color: #c0392b;
            }

            .logout img {
                width: 18px;
                margin-right: 8px;
            }
        </style>
    </head>
    <body>
        <div class="header">
            <h1>
                <img src="https://cdn-icons-png.flaticon.com/512/3135/3135768.png" alt="Enseignant">
                Tableau de bord Enseignant
            </h1>
            <div>Bienvenue Enseignant : <strong><%= user.getNom()%></strong></div>
        </div>

        <div class="content">
            <div class="card">
                <img src="https://cdn-icons-png.flaticon.com/512/1828/1828911.png" alt="Ajouter note">
                <a href="../notes.jsp">Ajouter une note</a>
            </div>

            <a href="../logout.jsp" class="logout">
                <img src="https://cdn-icons-png.flaticon.com/512/1828/1828490.png" alt="logout">
                Déconnexion
            </a>
        </div>
    </body>
</html>
