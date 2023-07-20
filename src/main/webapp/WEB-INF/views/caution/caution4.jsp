<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>국가별 단계표출</title>
<style>
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
			font-family: Arial, sans-serif;
			margin: 0;
		}
		.container {
			background-color: white;
			border-radius: 10px;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
			margin: 30px auto;
			max-width: 800px;
			padding: 20px;
		}
		.header {
			display: flex;
			flex-wrap: wrap;
			justify-content: space-between;
			margin-bottom: 20px;
		}
		.header img {
			margin-right: 10px;
		}
		.header a img {
			margin-left: 10px;
		}
		table {
			border-collapse: collapse;
			width: 100%;
		}
		td, th {
			border: 1px solid #dddddd;
			padding: 8px;
			text-align: left;
			vertical-align: top;
		}
		tr {
			background-color: #F6F6F6;
		}
		ul {
			list-style: none;
			margin: 0;
			padding-left: 0;
		}
		li {
			margin-bottom: 8px;
		}
		li b {
			font-weight: bold;
		}
		.left {
			padding-right: 8px;
			text-align: right;
			vertical-align: top;
			width: 15%;
		}
		.right {
			width: 85%;
			
		}
		.continent {
			vertical-align: middle;
			align : center;
		}
				@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
*{
	font-family: 'GmarketSansMedium';
}
	</style>
</head>
<body>
	<div style="width: 700px; margin: auto">
		<div>
		<a href="/caution?alarmLvl=1"><img src="/resource/image/step1.png" width ="350"height ="116"/></a><a href="/caution?alarmLvl=2"><img src="/resource/image/step2.png" width ="350"height ="116"/></a>
			<a href="/caution?alarmLvl=3"><img src="/resource/image/step3.png" width ="350" height ="116"/></a><img src="/resource/image/4단계.png" width ="350"height ="116"/>
		</div>
		
		<div>
			<table style="width: 100%">
				<tr>
					<td class="continent">아프리카</td>
					<td class="right">
						<ul>
							<c:forEach items="${africa }" var="one">
								<a href="/cautionDetail?countryNm=${one.countryNm }" style="text-decoration: none;color:black;"><li><b>${one.countryNm }</b> (${one.remark })</li></a>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="continent">미주</td>
					<td class="right">
						<ul>
							<c:forEach items="${america }" var="one">
								<a href="/cautionDetail?countryNm=${one.countryNm }" style="text-decoration: none;color:black;"><li><b>${one.countryNm }</b> (${one.remark })</li></a>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="continent">아주</td>
					<td class="right">
						<ul>
							<c:forEach items="${asia }" var="one">
								<a href="/cautionDetail?countryNm=${one.countryNm }" style="text-decoration: none;color:black;"><li><b>${one.countryNm }</b> (${one.remark })</li></a>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="continent">유럽</td>
					<td class="right">
						<ul>
							<c:forEach items="${europe }" var="one">
								<a href="/cautionDetail?countryNm=${one.countryNm }" style="text-decoration: none;color:black;"><li><b>${one.countryNm }</b> (${one.remark })</li></a>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="continent">중동</td>
					<td class="right">
						<ul>
							<c:forEach items="${middleEast }" var="one">
								<a href="/cautionDetail?countryNm=${one.countryNm }" style="text-decoration: none;color:black;"><li><b>${one.countryNm }</b> (${one.remark })</li></a>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>