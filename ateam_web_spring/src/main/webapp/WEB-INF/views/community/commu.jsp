<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Community Board</title>
</head>
<body>
	<form action="commu_write">
		<fieldset>
			<legend>게시판</legend>
			<table border="1">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일자</th>
				</tr>
				<tr>
					<td>blank</td>	<!--  get.번호 -->
					<td><a href="#">blank</a></td><!--  get.제목 -->
					<td>blank</td>	<!--  get.작성자 -->
					<td>blank</td>	<!--  조회수-->
					<td>blank</td>	<!--  get.작성일자 -->
					
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="게시물작성" /></td>
					<td colspan="2"><select>
							<option>QnA</option>
							<option>레시피공유</option>
							<option>후기</option>
					</select></td>
					<td><a href="#">검색</a></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>