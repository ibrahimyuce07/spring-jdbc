<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="savePerson" modelAttribute="person" method="POST">

<form:hidden path="id"/>
<form:input path="isim"/>
<form:input path="soyisim"/>
<form:input path="kanGrubu"/>
<form:input path="cepTel"/>
<form:textarea path="adres"/>
<input type="submit">

</form:form>

</body>
</html>