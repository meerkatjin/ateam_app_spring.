<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Community Write</title>
</head>
<body>
	<form action="commu_write">
		<fieldset align="center">
			<legend>게시글 작성</legend>
			<table border="1" align="center">
				<tr>
					<th>작성자</th>
					<td colspan="5"><input type="text" /></td>
				</tr>
				<tr>
					<th>제목</th><!--  get.제목 -->
					<td colspan="5"><input type="text" /></td>
				</tr>
				<tr>
					<th>분류</th>
					<td colspan="5">
						<select>
							<option>QnA</option>	
							<option>레시피공유</option>	
							<option>후기</option>	
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="5">
						<textarea rows="50" cols="50"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="5">
						<input type="submit" value="작성하기"/>
						<input type="reset" value="작성글 초기화"/>
					</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>