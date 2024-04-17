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
        <c:forEach items="${ARTICLE_LIST}" var="article">
            <tr>
                <td>${article.nom}</td>
                <td>${article.prix}</td>
                <td>${article.nbRestant}</td>
                <td><a href="updateCart?articleId=${article.id}&action=remove">Enlever 1</a></td>
                <td>Actuellement dans votre panier</td>
                <td><a href="updateCart?articleId=${article.id}&action=add">Ajouter 1</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="cart">Voir le panier</a>
</body>
</html>
