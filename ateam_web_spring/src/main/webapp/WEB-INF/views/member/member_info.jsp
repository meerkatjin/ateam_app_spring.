<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Member Info</title>
</head>
<body>
	<div align="center">
		<form action="main.jsp" method="post">
			<fieldset>
				<legend>�α��� ȭ��</legend>
				<table border="1">
					<tr>
						<th><label for="user_email">�̸���</label></th>
						<td><input type="text" name="user_email" disabled="disabled"/></td>
					</tr>
					<tr>
						<th><label for="user_pw">��й�ȣ</label></th>
						<td><input type="password" name="user_pw"/></td>
					</tr>
					<tr>
						<th><label for="user_pw_confirm">��й�ȣ Ȯ��</label></th>
						<td><input type="password" name="user_pw_confirm"/></td>
					</tr>
					<tr>
						<th><label for="user_name">�̸�(�г���)</label></th>
						<td><input type="password" name="user_name" disabled="disabled"/></td>
					</tr>
					<tr>
						<th><label for="user_addr">�ּ�</label></th>
						<td><input type="password" name="user_addr"/></td>
					</tr>
					<tr>
						<th><label for="user_tel">��ȭ��ȣ</label></th>
						<td><input type="password" name="user_tel"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="�����Ϸ�"/>
							<input type="button" value="�ʱ�ȭ�ϱ�"/>
						</td>
					</tr>
				</table>
			</fieldset>		
		</form>
	</div>
</body>
</html>