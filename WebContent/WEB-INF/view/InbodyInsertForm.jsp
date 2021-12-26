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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>InbodyInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.css">
<script type="text/javascript" src="https://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<style type="text/css">
	.outer
	{
		width:100%;
		margin: auto;
	}
	.inner
	{
		width:800px;
	    margin: auto;
	}
	.form-control
	{
		width: 400px;
	}
	.input-group-addon
	{
		width: 80px;
	}
</style>

</head>
<body>
<div class="outer">

		<div class="panel-group inner">
			
			<div class="panel panel-default">
				
				<div class="panel-heading" id="title">
					<h1> 인바디 등록 </h1>
				</div>
				
				<!--  체중	키	골격근	체지방	체지방률 -->
				<div class="panel-body row">
						<form action="inbodyinsert.action" method="post" id="inbodyInsertForm">
							<div class="col-md-3"></div>
							<div class="form-group col-md-9">
								<input type="hidden" id="memNo" name="memNo" value="${param.memNo }">
								
								<div class="input-group">
									<div class="input-group-addon">체중</div>
									<input type="text" id="weight" name="weight" required="required" class="form-control">
									<div class="input-group-addon">kg</div>
								</div>
								
								<br>
								
								<div class="input-group">
									<div class="input-group-addon">키</div>
									<input type="text" id="tall" name="tall" required="required" class="form-control">
									<div class="input-group-addon">cm</div>
								</div>
								
								<br>
								
								<div class="input-group">
									<div class="input-group-addon">골격근</div>
									<input type="text" id="muscle" name="muscle" required="required" class="form-control">
									<div class="input-group-addon">kg</div>
								</div>
								
								<br>
								
								<div class="input-group">
									<div class="input-group-addon">체지방</div>
									<input type="text" id="bodyfat" name="bodyfat" required="required" class="form-control">
									<div class="input-group-addon">kg</div>
								</div>
								
								<br>
								
								<div class="input-group">
									<div class="input-group-addon">체지방률</div>
									<input type="text" id="bodyfatPer" name="bodyfatPer" required="required" class="form-control">
									<div class="input-group-addon">%</div>
								</div>
								
								<br>
								
								<div class="col-md-3"></div>
								<div>
									<button type="submit" class="btn btn-default" id="submitBtn">
										추가
									</button>
									<button type="button" class="btn btn-default" id="listBtn" onclick="location.href='mypagemain.action'">
										취소
									</button>
									<br><br>
								</div>
							</div>
						</form>
				</div><!-- close .panel-body -->
				
			</div><!-- close .panel .panel-default -->
		
		</div>
		

</div>
</body>
</html>