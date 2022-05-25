<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa</title>
</head>
<body>

<h1>Sửa sản phẩm</h1>
<form action="EditProServlet" method="post">
 		<input type="text" name="id" value="${pro.id}" /><br>
	Name <input type="text" name="name"value="${pro.name}"/><br>
	Price <input type="text" name="price" value="${pro.price}"/><br>
	Sale_price <input type="text" name="sale_price" value="${pro.sale_price}" /><br>
	description <input type="text" name="description" value="${pro.description}"/><br>
	image <input type="text" name="image"  value="${pro.image}"/><br>
	 <p>status</p> <br>
	Ẩn<input type="radio" value="false" name="status"  checked="${!pro.status ? 'checked' : ''}"/>
	Hiện<input type="radio" value="true" name="status"  checked="${pro.status ? 'checked' : ''}" /><br>
	<button>Lưu</button>
</form>
</body>
</html>