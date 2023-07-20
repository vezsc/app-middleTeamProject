<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link
    href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro-v6@44659d9/css/all.min.css"
    rel="stylesheet" type="text/css" />
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />
<style type="text/css">
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
*{
	font-family: 'GmarketSansMedium';
}
  body {
	background-color: #8FCFD1;
  }
  
  .search-container {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .search-list {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 20px;
    justify-content: center;
    margin-top: 20px;
  }
</style>
</head>
<body>
<div class="search-container">
  <h1>검색 결과</h1>
  <div>
  	<form action="/search">
    <input type="text" name="countryNm" class="searchBox" id="q" list="qlist" autocomplete="off"> 
    <datalist id="qlist"></datalist>
    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
    </form>
  </div>
  <div class="search-list">
    <c:forEach items="${findSearch}" var="data">
    <div style="display: flex;">
      <a href="/cautionDetail?countryNm=${data.countryNm}" style="text-decoration: none; color: black;">
      	<img  src="${data.flagUrl }" style="width: 120px;height: 80px;"> 
      	<span style="display: flex; justify-content: center; font-size: 16px; font-weight: bold"> ${data.countryNm}</span></a>
    </div>
    </c:forEach>
    <c:if test="${empty findSearch  }">
    	검색 결과 없음
    </c:if>
  </div>
</div>

<script>
	document.querySelector("#q").onkeyup = function(evt){
		const val = evt.target.value;
		if(val.length == 0){
			return;
		}
		const xhr = new XMLHttpRequest();
		xhr.open("get", "/index/ajax?word="+ val, true); // 비동기 처리
		xhr.send();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState===4){
				const txt = xhr.responseText;
				console.log(typeof txt, txt);
				const obj = JSON.parse(txt);
				const cvt = obj.map(function(e){
					return "<option>" + e + "</option>"; 
				});
			document.querySelector("#qlist").innerHTML = cvt.join(""); 
			}
		}					
	}
	
	</script>
	</body>
</html>