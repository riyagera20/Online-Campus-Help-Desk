<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <!-- 
<link rel="stylesheet" href="styleP.css"> -->
    <link href="css/createpass.css" rel="stylesheet">
    <style type="text/css">
    	#imgNav{
  		height: 50px;
  		width: 50px;
		}
    </style>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">
    <img src="https://ayushbucket123.s3.ap-south-1.amazonaws.com/images/iec-logo.png" id="imgNav" class="d-inline-block align-top" alt="">
    <div class="d-inline-block align-top" style="margin-top: 10px;margin-left: 5px">IEC College of Engineering And Technology</div>
  </a>
</nav><!-- end of navbar-->
	<div class="container mb-lg-20">
		<section>
			<div class="card mx-auto">
				<div class="card-header text-center">
					<h3>Create Request</h3>
				</div>
				<div class="card-body align-center">
				<br>
				<br>
				<form:form action="/OnlineHelpDesk/submitrequest" data-toggle="validator" modelAttribute="createRequestDetails">
					<div class="form-group row justify-content-center">
						<label for="RequestorId" class="col-sm-3 control-label">Requestor Id:</label>
						<div class="col-sm-5">
							<form:input type="text" name="RequestorId" class="form-control" id="RequestorId" value="${requestor.requestorId }" path="requestorId"/>
						</div>
                    </div>
                    <div class="form-group row justify-content-center">
                    
						<label for="source" class="col-sm-3 control-label">Facility:</label>
						<div class="col-sm-5">
							<form:select name="facility" id="facility" path="facility" class="form-control">
								<!-- <option value="canteen">Canteen</option>
								<option value="classroom">Class-rooms</option>
								<option value="placement">Placement</option>
								<option value="labs">Labs</option>
								<option value="hostels">Hostels</option>
								<option value="computercenter">Computer Center</option>
								<option value="mess">Mess</option>
								<option value="gymnasium">Gymnasium</option>
								<option value="facultyclub">Faculty Club</option> -->
								
								<c:forEach items="${facilities}" var="facility" varStatus="status">
								<form:option value="${facility.facilityId}" label="${facility.facilityname}" />
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group row justify-content-center">
						<label for="source" class="col-sm-3 control-label">Severity:</label>
							<div class="col-sm-5">
								<form:select name="severiety" id="severiety" path="severiety" class="form-control">
									<form:option value="High" label="High" />
									<form:option value="Medium" label="Medium" />
									<form:option value="Low" label="Low" />
								</form:select>
							</div>
						</div>
						<div class="form-group row justify-content-center">
							<label for="description" class="col-sm-3 control-label">Description:</label>
							<div class="col-sm-5">
								<form:textarea name="description" class="form-control" id="description" path="description"/>
							</div>
						</div>
						<div class="row form-group justify-content-center">
							<div class="col-sm-5 ">
								
							</div>
							<div class="col-sm-5 ">
								<button type="submit" class="btn btn-primary">Submit</button>
								
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</section>
	</div>

</body>
</html>