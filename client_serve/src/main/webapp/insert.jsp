 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới</title>
</head>
<body>

<h1>Thêm sản phẩm</h1>
<form action="InsertProServlet" method="post">
	Name <input type="text" name="name"/><br>
	Price <input type="text" name="price"/><br>
	Sale_price <input type="text" name="sale_price"/><br>
	description <input type="text" name="description"/><br>
	image <input type="text" name="image"/><br>
	 <p>status</p> <br>
	Ẩn<input type="radio" value="false" name="status" checked="checked"/>
	Hiện<input type="radio" value="true" name="status"/><br>
	<button>Lưu</button>
</form>
</body>
</html>