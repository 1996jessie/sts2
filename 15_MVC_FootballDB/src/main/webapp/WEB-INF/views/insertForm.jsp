<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
insertForm.jsp<br>
<form action="insert" method="post">
<table border=1>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>비번</td>
		<td><input type="text" name="pw"></td>
	</tr>
	<tr>
		<td>우승예상국가</td>
		<td>
			<input type="radio" name="win" value="한국">한국
			<input type="radio" name="win" value="미국">미국
			<input type="radio" name="win" value="독일">독일
			<input type="radio" name="win" value="스페인">스페인
		</td>
	</tr>
	<tr>
		<td>16강예상국가</td>
		<td>
			<input type="checkbox" name="round16" value="한국">한국
			<input type="checkbox" name="round16" value="멕시코">멕시코
			<input type="checkbox" name="round16" value="독일">독일
			<input type="checkbox" name="round16" value="브라질">브라질
			<input type="checkbox" name="round16" value="스위스">스위스
			<input type="checkbox" name="round16" value="잉글랜드">잉글랜드
		</td>
	</tr>
	<tr>
		<td colspan=2>
			<input type="submit" value="입력">
			<a href="">목록보기</a>
		</td>
	</tr>
</table>
</form>