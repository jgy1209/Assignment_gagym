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
<title>MyExerciseMain</title>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" type="text/css"/>

<style type="text/css">
.outer {
	width: 100%;
}

.inner {
	width: 1100px;
	margin: auto;
	padding: 100px 0;
}
</style>

</head>
<body>
<c:import url="/WEB-INF/mainView/Header.jsp"></c:import>

<div class="outer">
	<div class="inner">
		<div class="row">
			<button class="btn btn-primary btn-xl text-uppercase col-md-4" onclick="location.href='myexerciseoneday.action'">나의 원데이클래스</button>
			<div class="col-md-4"></div>
			<button class="btn btn-primary btn-xl text-uppercase col-md-4">나의 수강예약</button>
		</div>
	</div>
</div>

<div class="row">
	<c:import url="/WEB-INF/mainView/Footer.jsp"></c:import>
</div>
</body>
</html>