<%@ page  contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>annotation::param</title>
	</head>
	<body>
		<h3>@requestParam 어노테이션 실습</h3>
		
		<a href="/Ch04_1/index">index</a>
		
		<h4>param1 실습</h4>
		<form action="/Ch04_1/annotation/param1" method="post">
			<input type="text" name="uid"/><br>
			<input type="submit" value="전송"/>
		</form>
		
		<h4>param2 실습</h4>
		<form action="/Ch04_1/annotation/param2" method="post">
			<input type="text" name="uid"/><br>
			<input type="text" name="name"/><br>
			<input type="submit" value="전송"/>
		</form>
		
		<h4>param3 실습</h4>
		<form action="/Ch04_1/annotation/param3" method="post">
			<input type="text" name="uid"/><br>
			<input type="text" name="name"/><br>
			<input type="text" name="hp"/><br>
			<input type="text" name="age"/><br>
			<input type="submit" value="전송"/>
		</form>
	
	</body>
</html>