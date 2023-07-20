<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
div {
 
  margin: 0 auto;
  width: 50%;
  padding: 5px;
  text-align: center;
 
}
h2 {
  font-size: 30px;
  font-weight: bold;
}
h3 {
  font-size: 18px;
}
h4 {
  font-size: 20px;
}
input {
  font-size: 18px;
  padding: 10px;
  border-radius: 5px;
  border: none;
  margin-bottom: 10px;

}
button {
  font-size: 20px;
  padding: 10px 20px;
  background-color: #0099ff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
button:hover {
  background-color: #0066cc;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  border-bottom: 2px solid #0072C6;
  font-size: 18px;
}

button[type=submit] {
  background-color: #0072C6;
  color: #FFFFFF;
  border: none;
  padding: 15px 20px;
  margin-top: 30px;
  font-size: 20px;
  border-radius: 5px;
  cursor: pointer;
}

  </style>
</head>
<body>
<div>
<form action="/user/join-td" method="post" >
	<h2>가입을 시작합니다</h2>
			<p style="text-align: center;">
				회원가입하시면 <br /> 다양한 서비스를 이용하실 수 있습니다.
			</p>
			<div >
				<h4 >* 사용할 아이디</h4>
				<input type="text" placeholder="아이디" name="id" />
			</div>
			<div >
				<h4 >* 사용할 비밀번호</h4>
				<input type="password" placeholder="비밀번호" name="pass" />
			</div>
			<div >
				<h4 >* 사용할 대표 닉네임</h4>
				<input type="text" placeholder="대표 닉네임" name="nick" />
			</div>

			<h3 style="text-align: center;">* 모든 정보는 필수 기입 정보 입니다.</h3>
			<div>
				<button type="submit" >다음</button>
			</div>
</form>
</div>	
</body>
</html>