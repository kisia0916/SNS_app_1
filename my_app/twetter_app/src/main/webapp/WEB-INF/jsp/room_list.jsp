<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Get_room_dto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%List<Get_room_dto> room_list = (List<Get_room_dto>) request.getAttribute("room_list"); %>
	<%for (Get_room_dto tweet: room_list) {%>
		<p><%=tweet.get_room_name()%></p>
		<p><%=tweet.get_room_profile()%></p>
		<form method = "POST" action = "/twetter_app/room_add/message_room">
			<input type = "hidden" name = "room_id" id = "room_id" value = "<%=tweet.get_id()%>">
			<button type = "submit" name = "conn_room">参加する</button>
		</form>
	<%} %>
</body>
</html>