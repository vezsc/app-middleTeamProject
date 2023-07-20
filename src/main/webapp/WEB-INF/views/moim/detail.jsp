<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모임 참가신청... 디테일..</title>
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
.board_view {
  border-collapse: collapse;
  width: 100%;
  margin-bottom: 20px;
}

.board_view caption {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 10px;
}

.board_view th {
  background-color: #f2f2f2;
  border: 1px solid #ddd;
  padding: 10px;
  text-align: center;
  vertical-align: middle;
}

.board_view td {
  border: 1px solid #ddd;
  padding: 10px;
  vertical-align: top;
}

.board_view th:first-child,
.board_view td:first-child {
  width: 10%;
}

.board_view th:nth-child(2),
.board_view td:nth-child(2) {
  width: 40%;
}

.board_view th:nth-child(3),
.board_view td:nth-child(3) {
  width: 15%;
}

.board_view th:last-child,
.board_view td:last-child {
  width: 35%;
}

.btn {
  display: inline-block;
  padding: 10px 20px;
  background-color: blue;
  color: white;
  text-align: center;
  font-size: 16px;
  cursor: pointer;
  border: none;
  border-radius: 5px;
  margin-right: 10px;
  margin-bottom: 10px;
  text-decoration: none;
}

.btn:hover {
  background-color: #3e8e41;
}

.complete {
  display: inline-block;
  padding: 10px 20px;
  background-color: blue;
  color: white;
  text-align: center;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  margin-right: 10px;
  margin-bottom: 10px;
  text-decoration: none;
}


</style>
</head>
<body>
	<div class="board_view_container">
  <table class="board_view">
    <caption>상세보기</caption>
    <colgroup>
      <col width="15%">
      <col width="35%">
      <col width="15%">
      <col width="35%">
    </colgroup>
    <tbody>
      <tr>
        <th>제목</th>
        <td>${targetBoard.title}</td>
        <th>모이는 시간</th>
        <td>${targetBoard.time}</td>
      </tr>
      <tr>
        <th>작성자</th>
        <td>${targetBoard.writer}</td>
        <th>참여 인원</th>
        <td>${currentUsers } / ${targetBoard.totalUsers}</td>
      </tr>
      <tr>
        <th>내용</th>
        <td colspan="3">${targetBoard.body}</td>
      </tr>
    </tbody>
  </table>
  <div class="buttons">
    <a href="/cautionDetailBoard?countryNm=${countryNm }" id="list" class="btn">목록으로</a>
    <c:choose>
    
		<c:when test="${sessionScope.logonUser.nick eq targetBoard.writer }">		
	    	<a href="/deleteBoard?boardId=${targetBoard.id }&countryNm=${countryNm }" class="btn">삭제하기</a>
		</c:when>
    	<c:otherwise>
    		<c:if test="${currentUsers < targetBoard.totalUsers && complete eq null}">
    			<a href="/apply?countryNm=${countryNm }&boardId=${targetBoard.id }&entry=${sessionScope.logonUser.id }" class="btn">참가신청</a>
    		</c:if>
    		<c:if test="${complete ne null}">
    			<p class="complete">참가완료</p>
    		</c:if>
    	</c:otherwise>
    </c:choose>
  </div>
</div>
	
	<!--${sessionScope.logonUser.id eq board.writer}-->
</body>
</html>