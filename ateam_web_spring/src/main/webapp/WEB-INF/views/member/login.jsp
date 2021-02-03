<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login Page</title>
</head>
<body>
	<div align="center">
		<form action="main.jsp" method="post">
			<fieldset>
				<legend>로그인 화면</legend>
				<table border="1">
					<tr>
						<th><label for="user_email">이메일</label></th>
						<td><input type="text" name="user_email"/></td>
					</tr>
					<tr>
						<th><label for="user_pw">비밀번호</label></th>
						<td><input type="password" name="user_pw"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="로그인"/>
							<input type="button" value="회원가입"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button" value="비밀번호 찾기"/></td>
					</tr>
				</table>
			</fieldset>		
		</form>
	</div>
</body>
</html>