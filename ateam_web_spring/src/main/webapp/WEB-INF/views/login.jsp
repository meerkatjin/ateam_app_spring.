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
				<legend>�α��� ȭ��</legend>
				<table border="1">
					<tr>
						<th><label for="user_email">�̸���</label></th>
						<td><input type="text" name="user_email"/></td>
					</tr>
					<tr>
						<th><label for="user_pw">��й�ȣ</label></th>
						<td><input type="password" name="user_pw"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="�α���"/>
							<input type="button" value="ȸ������"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button" value="��й�ȣ ã��"/></td>
					</tr>
				</table>
			</fieldset>		
		</form>
	</div>
</body>
</html>