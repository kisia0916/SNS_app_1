<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Tweet_data_dto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%List<Tweet_data_dto> data_set = (List<Tweet_data_dto>) request.getAttribute("tweet_data");%>
	<div class = "main_form">
		<form action = "/twetter_app/top_mypage/tweet_page" method = "POST">
			<input type = "text" id = "tweet_data" name = "tweet_data">
			<input type = "submit" value = "投稿">
		</form>
	</div>
	<%
	for(Tweet_data_dto tweet: data_set) {
	%>
		<p><%= tweet.get_tweet_user() %></p>
		<p><%= tweet.get_tweet_text() %></p>
		<p><%= tweet.get_tweet_like() %></p>
		<form action = "/twetter_app/top_mypage/message_room" method = "POST">
			<input type = "hidden" name = "tweet_like" value = "not_null">
			<input type = "hidden" name = "tweet_like_num" value = "<%=tweet.get_tweet_like()%>">
			<input type = "hidden" name = "tweet_id" value = "<%=tweet.get_tweet_id() %>">
			<button type = "submit" name = "action">いいね</button>
		</form>
		<p><%= tweet.get_create_time() %></p>
	<%} %>
</body>
</html>