<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<table>
<tr>
<td>Titulo</td>
<td>Valores</td>
</tr>
<c:forEach items="${products}" var="product">
<tr>
<td>${product.title}</td>
</tr>
</c:forEach>
</table>


</body>
</html>