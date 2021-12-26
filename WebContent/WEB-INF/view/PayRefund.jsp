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
<title>PayRefund.jsp</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<style type="text/css">
#outer {
	width: 100%;
	text-align: center;
}

#inner {
	width: 1100px;
	margin: auto;
}

.container {
	text-align: center;
	border: 1px solid gray;
	padding: 3em;
	width: 1100px;
}
th {
	text-align: center;
}

</style>

<script type="text/javascript">
	
	$(function()
	{ 
		<c:forEach var="point" items="${pointList }">
			if($("#repay${point.pointPayNo }").html() != 0)					// 환불 내역 존재
			{
				$("#refund${point.pointPayNo }").css('display', 'none');	// 환불 버튼 X
				$("#usepoint${point.pointPayNo }").html(" - ");				// 사용 아령 X
			}
			else
			{
				$("#repay${point.pointPayNo }").html("");
			}
			
			if($("#usepoint${point.pointPayNo }").html() > 0)				// 사용한 아령 존재
			{
				$("#refund${point.pointPayNo }").css('display', 'none');	// 환불 버튼 X
			}
			
		</c:forEach>
	});
	
</script>

</head>
<body>
	<div id="outer">
		<div id="inner">
			<div id="container" class="tab_content">
				<div>
					<h1>아령 결제 및 환불 내역</h1>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>결제날짜</th>
							<th>결제금액</th>
							<th>지급아령</th>
							<th>사용아령</th>
							<th></th>
							<th>환불날짜</th>
							<th>환불금액</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="point" items="${pointList }">
							<tr>
								<td>${point.payDate }</td>
								<td>${point.pointPay }</td>
								<td>${point.point }</td>
								<td id="usepoint${point.pointPayNo }">${point.usepoint }</td>
								<td>
									<button type="button" id="refund${point.pointPayNo }" name="refund" class="btn btn-default btnDelete" 
									value="${point.pointPayNo }" onclick="location.href='refundform.action?memNo=${param.memNo }&pointPayNo=${point.pointPayNo }&point=${point.point }'">환불</button>
								</td>
								<td>${point.pointReDate }</td>
								<td id="repay${point.pointPayNo }">${point.pointRepay }</td>
							</tr>
						</c:forEach>
						<tr style="text-align: right;">
							<td colspan="7">
								잔여아령 : <input type="text" id="havePoint" name="havePoint" disabled="disabled" 
											value="${havePoint }" style="width:80px; text-align:right;"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>