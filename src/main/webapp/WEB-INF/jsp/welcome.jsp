<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Requestor Id:</h1>
${requestor.requestorId }
<h1>Requestor Name:</h1>
${requestor.firstName }

<h1>Requestor Home Page</h1>
<form:form method='get' action='/OnlineHelpDesk/createRequest'>
<input type='submit' value='Create Request' />
</form:form>

<c:forEach items="${facilities}" var="facility" varStatus="status">
${facility.facilityId}${facility.facilityname}${facility.facilityDescription}<br>
</c:forEach>
</body>
</html>