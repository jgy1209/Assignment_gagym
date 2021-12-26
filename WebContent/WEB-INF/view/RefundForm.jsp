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
<title>RefundForm.jsp</title>
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
		margin: auto;
		text-align: center;
		border: 1px solid gray;
		border-radius: 7px;
		padding: 3em;
	}
</style>
</head>
<body>
	<div id="outer">
		<form action="refund.action" method="post">
			<div id="inner">
				<div class="panel-group" id="box" style="margin-top: 100px;">
					[<span>${point.point } </span>]아령을 환불하시겠습니까?<br>
					환불 예정 금액은 [<span>${point.pointPay }</span>] 원 입니다
					<input type="hidden" name="pointPayNo" value="${point.pointPayNo }">
					<input type="hidden" name="pointPay" value="${point.pointPay }">
					<input type="hidden" name="memNo" value="${point.memNo }">
					<br><br>
					<div id="box" style="width: 500px;">
						아령 환불 규정<br>
						- 당일 환불 : 수수료 제외 100% 환불 처리<br>
						- 당일이 아닌 경우의 미사용 환불 : 수수료 제외 80% 환불 처리<br>
						- 사용 환불 : 환불 불가 <br>
					</div>
					<br><br>
				
					<button type="submit" class="btn">환불</button>
					<button type="reset" class="btn" onclick="location.href='payrefund.action?memNo=${point.memNo}'">취소</button>
				</div>
			</div>
		</form>
</body>
</html>