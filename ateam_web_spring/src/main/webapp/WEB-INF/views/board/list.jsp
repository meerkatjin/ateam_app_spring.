<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style type="text/css">
.menu ul li { float: left; margin-right: 40px; font-size: 18px; font-weight: bold;}
.btn-write ul { margin: 0; }
.btn-write ul li { float: right; margin-bottom: 20px; font-weight: bold;}
.menu { height: 50px; }
.btn-write ul { margin: 0; }
.btn-write ul li { float: right; margin-bottom: 20px; font-weight: bold; }
</style>

<div class="menu">
<ul>
	<li><a href="list.no">공지사항</a></li>
	<li><a href="list.qa">Q&amp;A</a></li>
	<li><a href="list.bo">게시판</a></li>
</ul>
</div>

<div id="list-top">
<form action="list.bo" method="post">
<div class="btn-write">
	<ul>
		<li><select name="search">
			<option value="all" ${page.search eq 'all' ? 'selected' :''}>전체</option>
			<option value="board_title" ${page.search eq 'board_title' ? 'selected' :''}>제목</option>
			<option value="board_content" ${page.search eq 'board_content' ? 'selected' :''}>내용</option>
			<option value="writer" ${page.search eq 'writer' ? 'selected' :''}>작성자</option>
			</select>
		</li>
		<li><input type='text' name='keyword' value='${page.keyword}' class='w-px200'/></li>
		<li><a class='btn-fill' onclick="$('form').submit()">검색</a></li>
	</ul>
	<ul>
		<!-- 로그인했을 경우에만 글쓰기 버튼 보이게 -->
		<c:if test="${!empty loginInfo}">
			<li><a class="btn-fill" href="new.bo" maxlength="100">글쓰기</a></li>
		</c:if>
	</ul>
</div>
<input type='hidden' name='curPage' value='1'/>
</form>
</div>

<table class="board">
<tr>
	<th class="w-px80">번호</th>
	<th>제목</th>
	<th class="w-px120">작성자</th>
	<th class="w-px120">작성일</th>
	<th class="w-px120">첨부파일</th>
	<th class="w-px120">조회수</th>
</tr>
<c:forEach items="${page.list}" var="vo">
<tr>
	<td style="color: #999;">${vo.no}</td>
	<td class="left"><a href="view.bo?board_no=${vo.board_no}">${vo.board_title}</a></td>
	<td>${vo.name}</td>
	<fmt:formatDate value="${vo.create_dt}" var="create_dt" pattern="yyyy-MM-dd" />
	<td>${create_dt}</td>
	<td>${empty vo.filename ? '' : '<img class="file-img" src="imgs/file.jpg"/>'}</td>
	<td>${vo.board_readcount}</td>
</tr>
</c:forEach>
</table>

<div class="btnSet">
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>	