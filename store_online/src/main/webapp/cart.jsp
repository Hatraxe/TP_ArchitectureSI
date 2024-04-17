<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Panier</title>
</head>
<body>
    <h1>Panier de ${sessionScope.currentUser}</h1>
    <table border="1">
        <tr>
            <th>Article</th>
            <th>Prix Unité</th>
            <th>Quantité</th>
            <th>Sous-total</th>
        </tr>
        <c:forEach items="${cart.items}" var="item">
            <tr>
                <td>${item.article.name}</td>
                <td>${item.article.price}</td>
                <td>${item.quantity}</td>
                <td>${item.article.price * item.quantity}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3">Total:</td>
            <td>${cart.totalPrice}</td>
        </tr>
    </table>
    <form>
        <input type="submit" value="Payer">
    </form>
    <a href="articles">Retour aux articles</a>
</body>
</html>
