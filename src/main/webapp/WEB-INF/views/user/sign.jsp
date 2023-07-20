<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/styleUser.css" />
</head>
<body>
<div class="form-structor" >
	<form action="/user/join-task" method="post">
	<div class="signup">
		<h2 class="form-title" id="signup"><span>or</span>Sign up</h2>
		<div class="form-holder">
			<input type="text" class="input" placeholder="ID"  name="id" >
			<input type="text" class="input" placeholder="Nick"  name="nick" >
			<input type="password" class="input" placeholder="Password"  name="pass"/>
		</div>
		<button class="submit-btn">Sign up</button>
	</div>
	</form>
	
	<form action="/user/login-task" method="post">
	<div class="login slide-up">
		<div class="center">
			<h2 class="form-title" id="login"><span>or</span>Log in</h2>
			<div class="form-holder">
				<input type="text" class="input" placeholder="ID"  name="id"/>
				<input type="password" class="input" placeholder="Password" name="pass" />
			</div>
			<button class="submit-btn">Log in</button>
		</div>
	</div>
	</form>
	
</div>


<script type="text/javascript">
console.clear();

const loginBtn = document.getElementById('login');
const signupBtn = document.getElementById('signup');

loginBtn.addEventListener('click', (e) => {
	let parent = e.target.parentNode.parentNode;
	Array.from(e.target.parentNode.parentNode.classList).find((element) => {
		if(element !== "slide-up") {
			parent.classList.add('slide-up')
		}else{
			signupBtn.parentNode.classList.add('slide-up')
			parent.classList.remove('slide-up')
		}
	});
});

signupBtn.addEventListener('click', (e) => {
	let parent = e.target.parentNode;
	Array.from(e.target.parentNode.classList).find((element) => {
		if(element !== "slide-up") {
			parent.classList.add('slide-up')
		}else{
			loginBtn.parentNode.parentNode.classList.add('slide-up')
			parent.classList.remove('slide-up')
		}
	});
});


</script>
</body>
</html>