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
                <td>${article.name}</td>
                <td>${article.price}</td>
                <td>${article.nbRestant}</td>
                <td><a href="updateCart?articleId=${article.id}&action=remove">-</a></td>
                <td>0</td>
                <td><a href="updateCart?articleId=${article.id}&action=add">+</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="cart">Voir le panier</a>
</body>
</html>
