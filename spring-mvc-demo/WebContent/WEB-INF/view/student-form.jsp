<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName"/>
	
	<br><br>
	
	Last name: <form:input path="lastName"/> 
	
	<br><br>
	
	Country: <form:select path="country">
	<!--  
		<form:option value="Brazil" label="Brazil"/>
		<form:option value="India" label="India"/>
		<form:option value="France" label="France"/>
		<form:option value="Germany" label="Germany"/>
	-->
		<form:options items="${ student.countryOptions }"/>
	
	</form:select>
	
	<br><br>
	
	<h4>Favourite Language:</h4>
	
	<form:radiobutton path="favouriteLanguage" value="Java"/> Java <br>
	<form:radiobutton path="favouriteLanguage" value="C/C++"/> C/C++ <br>
	<form:radiobutton path="favouriteLanguage" value="Python"/> Python <br>
	<form:radiobutton path="favouriteLanguage" value="JavaScript"/> JavaScript 
	
	<br><br>
	
	<h4>Operating Systems:</h4>
	
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
	Windows <form:checkbox path="operatingSystems" value="Windows"/>
	
	<br><br>
	
	<input type="submit" value="submit">
	
	</form:form>

</body>
</html>