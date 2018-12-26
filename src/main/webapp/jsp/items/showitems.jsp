<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>

    <c:forEach var="items" items="${itemslist}">
        <tr>
        <td>${items.itContent}</td>
        </tr>
        <tr>
            <td>A:${items.aKey}    B:${items.bKey}    C:${items.cKey}    D:${items.dKey}</td>
        </tr>
        <tr>
            <td>${items.answer}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
