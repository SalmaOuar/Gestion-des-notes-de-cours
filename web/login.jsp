<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion utilisateur</title>
    
    <!-- ✅ Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        body {
            background: linear-gradient(to right, #4facfe, #660033);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .login-box {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
            width: 100%;
            max-width: 400px;
        }
        .login-box h2 {
            margin-bottom: 25px;
            text-align: center;
            color: #333;
        }
        .form-control {
            border-radius: 6px;
        }
        .btn-primary {
            width: 100%;
            background-color: #660033;
        }
    </style>
</head>
<body>

    <div class="login-box">
        <h2>Connexion utilisateur</h2>
        <form action="LoginServlet" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Email :</label>
                <input type="text" id="email" name="email" class="form-control" required autofocus>
            </div>
            <div class="mb-3">
                <label for="motDePasse" class="form-label">Mot de passe :</label>
                <input type="password" id="motDePasse" name="motDePasse" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Se connecter</button>
        </form>
    </div>

</body>
</html>
