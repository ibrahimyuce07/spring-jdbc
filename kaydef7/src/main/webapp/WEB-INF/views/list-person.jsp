<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<input type="button" value="Yeni Kişi Ekle" onclick="window.location.href='showFormForAdd'"> 
	<table>
		<tr>
			<th>id</th>
			<th>isim</th>
			<th>soyisim</th>
			<th>kan grubu</th>
			<th>cep tel</th>
			<th>adres</th>
			<th> action </th>
		</tr>
		<c:forEach var="tempPerson" items="${personList}">
		<c:url var="updateLink" value="/person/showFormForUpdate">
		<c:param name="personId" value="${tempPerson.id }"></c:param>
		</c:url>
		
			<tr>
				<td>${tempPerson.id}</td>
				<td>${tempPerson.isim}</td>
				<td>${tempPerson.soyisim}</td>
				<td>${tempPerson.kanGrubu}</td>
				<td>${tempPerson.cepTel}</td>
				<td>${tempPerson.adres}</td>
				<td> <a href="${updateLink }">Güncelle</a> </td>
				
			</tr>

		</c:forEach>
	</table>

</body>
</html>