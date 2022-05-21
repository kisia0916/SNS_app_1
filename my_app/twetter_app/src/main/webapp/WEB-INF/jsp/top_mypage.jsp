<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Mytweet_dto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<Mytweet_dto> data_set = (List<Mytweet_dto>) request.getAttribute("tweet_list");%>
<div class = user_name>
	<h1><%=request.getAttribute("name") %>さんようこそ</h1>
</div>
<div class = flower>
	<p>フォロワー</p>
	<p>フォロー中</p>
</div>
<div class = user_profile>
	<h3>プロフィール</h3>
	<p><%=request.getAttribute("profile") %></p>
</div>
<div class = "test_tweet">
	<a href="/twetter_app/top_mypage/tweet_page">ツートする</a>
</div>
<div>
	<%for(Mytweet_dto tweet:data_set){ %>
		<p><%= tweet.get_tweet_user() %></p>
		<p><%= tweet.get_tweet_text() %></p>
		<p><%= tweet.get_create_time() %></p>
		<form class="delete_form" action="/twetter_app/top_mypage" method="POST">
		<input type="hidden" name="tweet_id" value="<%= tweet.get_tweet_id() %>">
		<button type="submit" name="action">削除</button>
		</form>
	<%} %>
</div>
</body>
</html>