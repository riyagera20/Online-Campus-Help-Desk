<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<!--  <html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/OnlineHelpDesk/loginSuccess" method="post" modelAttribute="loginCredential">

		<table>
			<tr>
				<td>Enter Email:</td>
				<td><form:input path="userId" /></td>
				<td><form:errors path="userId" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>-->

<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login Page</title>
  <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  <link rel="stylesheet" type="text/css" href="css/loginForm.css">
  
    <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css">
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  
  <!--<spring:url value="/resources/css/loginForm.css" var="loginFormCSS" />
  <spring:url value="/resources/lib/bootstrap/css/bootstrap.min.css" var="bootStrapCSS" />
  <spring:url value="/resources/lib/bootstrap/js/bootstrap.min.js" var="bootStrapJS" />
  <spring:url value="/resources/lib/images/iec-logo.png" var="logoIMAGE" />
  <spring:url value="/resources/lib/images/clip-custumer-service-support.png" var="mainIMAGE" />
  
  <link href="${loginFormCSS } rel="stylesheet" />
  <link href="${bootStrapCSS } rel="stylesheet" />
  <script src="${bootStrapJS}"></script> -->
  
  <!-- <link href="${pageContext.request.contextPath }/resources/css/loginForm.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet" /> -->
  
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body >

<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">
    <img src="${pageContext.request.contextPath }/resources/lib/images/iec-logo.png" id="imgNav" class="d-inline-block align-top" alt="">
    <div class="d-inline-block align-top" style="margin-top: 10px">ABCD College of Engineering And Technology</div>
  </a>
</nav>
<div class="container-fluid">
	<h1 id="h1text1">Campus HelpDesk</h1>
	<img src="${pageContext.request.contextPath }/resources/lib/images/clip-custumer-service-support.png" alt="help-desk-picture">

    <div class="content">
 
      <div class="text">Login Form</div>
      <form:form action="/OnlineHelpDesk/loginSuccess" method="post" modelAttribute="loginCredential">
        <div class="field">
          <span class="fas fa-user"></span>
          <form:input type="text" name="userId" placeholder="User Id" path="userId" />
		</div>
        <div class="field">
          <span class="fas fa-lock"></span>
          <!-- <input type="password" name="password" placeholder="Password" required>  -->
          <form:password path="password" placeholder="Password"/>
          <!-- <label>Password</label> -->
        </div>
        <div class="forgot-pass"><a href="http://localhost:8585/CampusHelpDesk/ForgetPassword">Forgot Password?</a></div>
        <button class="signInButton" value="Submit">Sign in</button>
        
      </form:form>
  </div>
      </div>
</body>
</html>