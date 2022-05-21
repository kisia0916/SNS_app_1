<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main id = "create">
	<h1>アカウント作成</h1>
	<main id = create_user>
		<form action = "/twetter_app/top_create" method = "POST">
			<label id = "name_label">ユーザー名</label><br>
			<input id = "create_name" type = "text" name = "create_name" required><br>
			<label id = "mail_label">メールアドレス</label><br>
			<input id = "create_mail" type = "text" name = "create_mail" required><br>
			<label id = label_pass>パスワード</label><br>
			<input id = "create_pass" type = "password" name = "create_pass" required><br>
			<label id = "profile_label">プロフィール</label><br>
			<textarea id="create_profile" name = "create_profile" required></textarea><br>
			<input id = "submit_button" type = "submit" value = "アカウントを作成">
		</form>
	</main>
</main>
</body>
</html>