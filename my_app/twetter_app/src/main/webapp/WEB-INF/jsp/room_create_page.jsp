<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form method = "POST" action = "/twetter_app/create_room">
			<label id = "form_name">スレッド名</label>
			<br><input type = "text" id = "room_name" name = "room_name">
			<br><label id = "form_profile">紹介文</label>
			<br><input type = "text" id = "room_profile" name = "room_profile">
			<br><input type = "submit" value = "スレッドを作成">
		</form>
	</div>
</body>
</html>