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
<title>InstructorInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.css">
<script type="text/javascript" src="https://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


<!-- datepicker 관련 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>

<script>
$(document).ready (function () {
	
	// 자격증 추가
	$(".cBtnAdd").click (function () {                                        
		$(".cer").append (                        
			"<div class='row' style='padding-left: 10px;'><br><label for='cer' class='col-md-2'></label>"
			+ "<select id='cerName' name='cerName' class='form-control col-md-2' style='width:200px;'>"
			+ "<c:forEach var='cer' items='${cerList }'>"
			+ "<option value='${cer.cerName }'>${cer.cerName }</option>"
			+ "</c:forEach></select>"
			+ "<input type='text' name='cerDate' class='datepicker form-control col-md-4' placeholder='자격증발급날짜'>"
			+ "<input type='file' role='button' class='btn btn-default btnInsert col-md-3' name='proofPath' style='width:300px;'>"
			+ "<input type='button' class='btn btn-default btnRemove col-md-1' value='삭제'><br></div>"
			);
			$(document).find(".datepicker").removeClass('hasDatepicker').datepicker();
		
		$(".btnRemove").on("click", function () { 
			$(this).closest("div").remove();
		});
	});
	// 수상경력 추가
	$(".pBtnAdd").click (function () {                                        
		$(".prz").append (                        
			"<div class='row' style='padding-left: 10px;'><br><label for='prz' class='col-md-2'></label>"
			+ "<input type='text' name='przDate' class='form-control col-md-4 datepicker' placeholder='수상날짜'>"
	    	+ "<input type='text' name='przName' class='form-control col-md-3' placeholder='수상명' style='width:300px;'>"
	    	+ "<input type='text' name='przMedal' class='form-control col-md-3' placeholder='수상실적(메달)'>"
			+ "<input type='button' class='btn btn-default btnRemove col-md-1' value='삭제'><br></div>"
			);
			$(document).find(".datepicker").removeClass('hasDatepicker').datepicker();
		
		$(".btnRemove").on("click", function () { 
			$(this).closest("div").remove();
		});
	});
	// 활동경력 추가
	$(".eBtnAdd").click (function () {                                        
		$(".exp").append (                        
			"<div class='row' style='padding-left: 10px;'><br><label for='prz' class='col-md-2'></label>"
			+ "<input type='text' name='expStartDate' class='form-control col-md-4 datepicker' placeholder='시작날짜'>"
			+ "<input type='text' name='expEndDate' class='form-control col-md-4 datepicker' placeholder='마지막날짜'>"
	    	+ "<input type='text' name='przName' class='form-control col-md-2' placeholder='활동내역' style='width:300px;'>"
			+ "<input type='button' class='btn btn-default btnRemove col-md-1' value='삭제'><br></div>"
			);
			$(document).find(".datepicker").removeClass('hasDatepicker').datepicker();
		
		$(".btnRemove").on("click", function () { 
			$(this).closest("div").remove();
		});
	});
	// 활동지역 추가
	$(".aBtnAdd").click (function () {                                        
		$(".area").append (                        
			"<div class='row' style='padding-left: 10px;'><br><label for='prz' class='col-md-2'></label>"
			+ "<select id='cityName' name='cityName' class='form-control col-md-2' >"
			+ "<option value=''>-선택하세요-</option>"
			+ "<c:forEach var='city' items='${cityList }'>"
			+ "<option value='${city.cityNo }'>${city.cityName }</option>"
			+ "</c:forEach></select>"
			+ "<select name='sigunguName' id='sigunguName' class='form-control col-md-2' >"
			+ "<option value=''>-선택하세요-</option></select>"
			+ "<input type='button' class='btn btn-default btnRemove col-md-1' value='삭제'><br></div>"
			);
			$(document).find(".datepicker").removeClass('hasDatepicker').datepicker();
		
		$(".btnRemove").on("click", function () { 
			$(this).closest("div").remove();
		});
		
		
	});
	
	
	$(".datepicker").datepicker(
	{
		dateFormat: "yy-mm-dd"
		, changeMonth: true
		, changeYear: true
	});
	
	$("#cityName").change(function()
	//$(document).on("change","#cityName",function()
	{
		var params = "cityNo=" + $("#cityName > option:selected").val();
		 
		$.ajax(
		{
		    url: "areaajax.action"
		    , type: "POST"
		    , data: {cityNo: $("#cityName > option:selected").val()}
			, dataType: "text"
		    , success : function(data)
			{	    
		    	$("#sigunguName").html(data);
				
			}
			, error : function(e)
			{
				alert(e.responseText);
			}
		}); 
		
	});
	
});

</script>  

<style type="text/css">
	.outer
	{
		width:100%;
		margin: auto;
	}
	.inner
	{
		width:1100px;
	    margin: auto;
	}
	.form-control
	{
		width: 200px;
	}
</style>
</head>
<body>
<div class="outer">

<div class="panel-group inner">
	
	<div class="panel panel-default">
		
		<div class="panel-heading" id="title">
			<h1> 강사신청 </h1>
		</div>
		
		<div class="panel-body">
			<form action="instructorinsert.action" method="post">
				<input type="hidden" id="memNo" name="memNo" value="${param.memNo }">

				<!-- 자격증 -->
				<div class="form-group row">
					<div class="cer row">
						<label for="cer" class="col-md-2" style="padding-left: 40px;"> 자격증 </label>
						<select id="cerName" name="cerName" class="form-control col-md-2" >
							<c:forEach var="cer" items="${cerList }">
								<option value="${cer.cerNo }">${cer.cerName }</option>
							</c:forEach>
						</select> 
						<input type="text" name="cerDate" class="form-control col-md-4 datepicker" placeholder="자격증발급날짜"> 
						<input type="file" role="button" class="btn btn-default btnInsert col-md-3" name="proofPath" style="width:300px;">

						<input type="button" class="btn btn-default cBtnAdd col-md-1" value="추가"><br>
					</div>
				</div>

				<!-- 수상경력 -->
				<div class="form-group row">
					<div class="prz row">
						<label for="prz" class="col-md-2" style="padding-left: 40px;"> 수상경력 </label>
						<input type="text" name="przDate" class="form-control col-md-4 datepicker" placeholder="수상날짜">
				    	<input type="text" name="przName" class="form-control col-md-3" placeholder="수상명" style="width:300px;">
				    	<input type="text" name="przMedal" class="form-control col-md-3" placeholder="수상실적(메달)">
				    	
						<input type="button" class="btn btn-default pBtnAdd col-md-1" value="추가"><br>
					</div>
				</div>
				
				<!-- 활동경력 -->
				<div class="form-group row">
					<div class="exp row">
						<label for="exp" class="col-md-2" style="padding-left: 40px;"> 활동경력 </label>
						<input type="text" name="expStartDate" class="form-control col-md-4 datepicker" placeholder="시작날짜">
						<input type="text" name="expEndDate" class="form-control col-md-4 datepicker" placeholder="마지막날짜">
				    	<input type="text" name="przName" class="form-control col-md-2" placeholder="활동내역" style="width:300px;">
				    	
						<input type="button" class="btn btn-default eBtnAdd col-md-1" value="추가"><br>
					</div>
				</div>
				
				<!-- 활동지역 -->
				<div class="form-group row">
					<div class="area row">
						<label for="area" class="col-md-2" style="padding-left: 40px;"> 활동지역 </label>
						<select id="cityName" name="cityName" class="form-control col-md-2" >
							<option value="">-선택하세요-</option>
							<c:forEach var="city" items="${cityList }">
								<option value="${city.cityNo }">${city.cityName }</option>
							</c:forEach>
						</select> 
						<select name="sigunguName" id="sigunguName" class="form-control col-md-2" >
							<option value="">-선택하세요-</option>
						</select> 
						<input type="button" class="btn btn-default aBtnAdd col-md-1" value="추가"><br>
					</div>
				</div>
				
				
				<div style="text-align: center;">
					<button type="submit" class="btn btn-default">신청</button>
					<button type="button" class="btn btn-default">취소</button>
				</div>
			</form>
		</div><!-- close .panel-body -->
		
	</div><!-- close .panel .panel-default -->

</div>


</div>
</body>
</html>