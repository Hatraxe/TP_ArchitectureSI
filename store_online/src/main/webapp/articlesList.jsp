<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste des articles</title>
</head>
<body>
    <h1>Bienvenue, ${sessionScope.currentUser}</h1> <!-- Affichage du nom d'utilisateur -->
    <h2>Liste des articles</h2>
    <table border="1">
        <tr>
            <th>Nom</th>
            <th>Prix</th>
            <th>Restant</th>
            <th>Enlever 1 au panier</th>
            <th>Actuellement dans votre panier</th>
            <th>Ajouter 1 au panier</th>
        </tr>
        <c:forEach items="${ARTICLE_LIST}" var="result">
            <tr>
                <td>${result.nom}</td>
                <td>${result.prix}</td>
                <td>${result.nbRestant}</td>
                <td>Enlever 1 au panier</td>
                <td>Actuellement dans votre panier</td>
                <td>Ajouter 1 au panier</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
