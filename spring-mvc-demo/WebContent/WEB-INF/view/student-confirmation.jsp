<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Confirmation</title>
</head>
<body>

	<h2>The student is confirmed: ${ student.firstName } ${ student.lastName }</h2>
	
	
	<h2>Country: ${ student.country }</h2>
	
	<h2>Favourite Language: ${ student.favouriteLanguage }</h2>
	
	<h2>Operating Systems:</h2> 
	
	<ul>
	
		<c:forEach var="temp" items="${ student.operatingSystems }">
		<li>${ temp }</li>
		</c:forEach>
		
	</ul>
	
	

</body>
</html>