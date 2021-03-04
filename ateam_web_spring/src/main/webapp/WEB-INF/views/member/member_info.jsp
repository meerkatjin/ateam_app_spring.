<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div align="center">
		<form action="main.jsp" method="post">
			<fieldset>
				<legend>로그인 화면</legend>
				<table border="1">
					<tr>
						<th><label for="user_email">이메일</label></th>
						<td><input type="text" name="user_email" disabled="disabled"/></td>
					</tr>
					<tr>
						<th><label for="user_pw">비밀번호</label></th>
						<td><input type="password" name="user_pw"/></td>
					</tr>
					<tr>
						<th><label for="user_pw_confirm">비밀번호 확인</label></th>
						<td><input type="password" name="user_pw_confirm"/></td>
					</tr>
					<tr>
						<th><label for="user_name">이름(닉네임)</label></th>
						<td><input type="password" name="user_name" disabled="disabled"/></td>
					</tr>
					<tr>
						<th><label for="user_addr">주소</label></th>
						<td><input type="password" name="user_addr"/></td>
					</tr>
					<tr>
						<th><label for="user_tel">전화번호</label></th>
						<td><input type="password" name="user_tel"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="수정완료"/>
							<input type="button" value="초기화하기"/>
						</td>
					</tr>
				</table>
			</fieldset>		
		</form>
	</div>