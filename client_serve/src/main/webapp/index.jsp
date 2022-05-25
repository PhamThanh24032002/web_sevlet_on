<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Danh Sách Sản Phẩm</h1>
	<a href="insert.jsp">Thêm mới</a>
	<table border="1">
		<tr>
			<th>STT</th>
			<th>Name</th>
			<th>Price</th>
			<th>Sale_price</th>
			<th>Description</th>
			<th>image</th>
			<th>status</th>
			<th>Funtion</th>
		</tr>
		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td>${p.sale_price}</td>
				<td>${p.description}</td>
				<td>${p.image}</td>
				<td>${p.status}</td>
				<td>
				<a href="DeleteProServlet?id=<fmt:formatNumber value="${p.id}" minFractionDigits="0" maxFractionDigits="0"/>">Xóa</a>
				<a href="EditProServlet?id=<fmt:formatNumber value="${p.id}" minFractionDigits="0" maxFractionDigits="0"/>">Sửa</a>
				</td>
			</tr>

		</c:forEach>


	</table>
</body>
</html>