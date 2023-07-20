<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
body {
  background-color: #f2f2f2;
  font-family: Arial, sans-serif;
}

form {
  margin: 50px auto;
  width: 300px;
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}

h2 {
  margin-top: 0;
  font-size: 24px;
  text-align: center;
}

div {
  margin-bottom: 10px;
}

input[type="text"],
input[type="password"] {
  padding: 10px;
  width: 100%;
  border: none;
  border-bottom: 2px solid #ccc;
  font-size: 16px;
}

input[type="text"]:focus,
input[type="password"]:focus {
  outline: none;
  border-bottom-color: #4CAF50;
}

p.error {
  color: #f00;
  font-size: 14px;
  text-align: center;
}

button {
  display: block;
  margin: 20px auto;
  padding: 10px 20px;
  background-color: #4CAF50;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  font-size: 16px;
}

button:hover {
  background-color: #3e8e41;
}
</style>
</head>
<body>
	<form action="/user/login-ta" method="post">
		<div style="text-align: center">
			<h2>로그인 창</h2>
			<div>
				아이디 : <input type="text" name="id" />
			</div>
			<div>
				비밀번호 : <input type="password" name="pass" />
			</div>
			<p>
				<c:if test="${param.cause eq 'error' }">
				아이디 또는 비밀번호가 틀렸습니다
			</c:if>
			</p>
			<button>전송</button>
		</div>
		
	</form>

</body>
</html>