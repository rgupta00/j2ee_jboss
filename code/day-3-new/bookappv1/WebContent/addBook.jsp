<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>addBook.jsp</title>
</head>
<body>
<form action="BookController" method="post">
  Enter isbn:<input type="text" name="isbn"/><br/>
  Enter title:<input type="text" name="title"/><br/>
  Enter price:<input type="text" name="price"/><br/>
  <input type="submit"/>
  
</form>
</body>
</html>