<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WithdrawalForm.jsp</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.css">
<script type="text/javascript" src="https://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<style type="text/css">
	#outer
	{
		width:100%;
	}
	#inner
	{
		width:1100px;
	    margin: auto;
	}
	#box
	{
		width:600px;
		margin: 100px auto;
		text-align: center;
		border: 1px solid gray;
		border-radius: 7px;
		padding: 3em;
	}
</style>
</head>
<body>

	<div id="outer">
		<form action="withdrawalcheck.action" method="post">
			<div id="inner">
				<div class="panel-group" id="box" >
					<span id="user">${nameId.memName }(${nameId.memId })님</span>
					, 탈퇴하시겠습니까?
					<br><br>
					<input type="hidden" id="memNo" name="memNo" value="${param.memNo }">
					<div class="row" style="float: none; margin: 0 auto;">
						<label for="pw" class="col-md-4" style="padding: 5px;">비밀번호 확인</label> 
						<input type="password" id="pwdCheck" name="pwdCheck" class="form-control col-md-3" style="width:300px;">
					</div>
					<br><br>
				
					<button type="submit" class="btn btn-default">비밀번호 확인</button>
					<button type="button" class="btn btn-default" id="listBtn" onclick="location.href='mypagemain.action?memNo=${param.memNo }'">
						돌아가기
					</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>