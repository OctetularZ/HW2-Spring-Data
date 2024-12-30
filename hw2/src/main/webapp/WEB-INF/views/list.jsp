<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
    <h1>${title}</h1>
    <ul>
        <c:forEach var="item" items="${data}">
            <li>${item}</li>
            <br>
        </c:forEach>
    </ul>
</body>
</html>