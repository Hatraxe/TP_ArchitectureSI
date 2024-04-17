<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste des articles</title>
</head>
<body>
    <h1>Liste des articles</h1>
    <table border="1">
        <tr>
            
            <th>Nom</th>
            <th>Prix</th>
            <th>Restant</th>
            <th>Enlever 1 au panier</th>
            <th>Actuellement dans votre panier</th>
            <th>Ajouter 1 au panier</th>
    
        </tr>
        <c:forEach items="${RESULTS_LIST}" var="result">
            <tr>
                
                <!-- <td>${result.studentBean.firstName}</td>
                <td>${result.studentBean.name}</td>
                <td>${result.noteBean.note}</td> -->
            </tr>
        </c:forEach>
    </table>
   
</body>
</html>
