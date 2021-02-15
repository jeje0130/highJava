<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session Login</title>
</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/sessionLogin.do">

	<table border="1">
		<tr>
			<td>ID : </td>
			<td><input name="userid" type="text" placeholder="ID를 입력하세요."></td>
		</tr>
		
		<tr>
			<td>PASS : </td>
			<td><input name="pass" type="password" placeholder="PassWord를 입력하세요."></td>
		</tr>
		
		<tr>
			<td colspan="2" style="text-align: center;"><input type="submit" name="chkid" value="Login"></td>
		</tr>
		
	</table>

</form>

</body>
</html>