<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book store application servlet jsp</title>
</head>
<body>
<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>isbn</th>
				<th>title</th>
				<th>price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.id }"/></td>
				<td><c:out value="${book.isbn }"/></td>
				<td><c:out value="${book.title }"/></td>
				<td><c:out value="${book.price }"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
<a href="addBook.jsp">addBook</a>
</html>