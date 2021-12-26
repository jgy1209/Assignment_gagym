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
<title>main</title>
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

.form-control {
	width: 220px;
}
</style>
<script type="text/javascript">
	
	$(function()
	{ 
		// 수정 버튼 클릭
		$("#updateBtn").click(function()
		{
			$(location).attr("href", "mypagemain.action?memNo=" + $(this).val())	//get방식
		});
		
	});
	
</script>

</head>
<body>
	<div id="outer">
		<div id="inner">

			<button type="button" id="updateBtn" class="btn btn-default" value="MEMBER-5">마이페이지</button>


		</div>
	</div>

</body>
</html>