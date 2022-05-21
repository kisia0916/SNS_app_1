<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login_user</h1>
	<form method = "post" action = "/twetter_app/top_login">
		<label for = mail>mailアドレス</label><br>
		<input type = "text" id = "mail" name = "mail"><br>
		<label for = "pass">パスワードを入力</label><br>
		<input type = "text" id = "pass" name = "pass"><br>
		<input type = "submit" value = "ログイン">
	</form>
</body>
</html>