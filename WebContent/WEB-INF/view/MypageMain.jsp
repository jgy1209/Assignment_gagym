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
<title>MyPageMain.jsp</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

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
	font-size: 10pt;
}

label {
	text-align: center;
	padding-top: 5px;
}

ul.tab {
	margin: 0;
	padding: 0;
	list-style: none;
	height: 32px;
	border-bottom: 1px solid #999;
	border-left: 1px solid #999;
	width: 100%;
}

ul.tab li {
	float: left;
	margin: 0;
	padding: 0;
	height: 31px;
	line-height: 31px;
	border: 1px solid #999;
	border-left: none;
	margin-bottom: -1px;
	overflow: hidden;
	position: relative;
	background: #e0e0e0;
}

ul.tab li a {
	text-decoration: none;
	color: #000;
	display: block;
	font-size: 1.3em;
	padding: 0 20px;
	border: 1px solid #fff;
	outline: none;
	width: 548px;
	height: 80px;
	text-align: center;
}

ul.tab li a:hover {
	background: #ccc;
}

html ul.tab li.active, html ul.tab li.active a:hover {
	background: #fff;
	border-bottom: 1px solid #fff;
}

.tab_container {
	border: 1px solid #999;
	border-top: none;
	overflow: hidden;
	clear: both;
	float: left;
	width: 100%;
	background: #fff;
}

.tab_content {
	padding: 20px;
	font-size: 1.2em;
}
.btn
{
	font-size: 10pt;
}
</style>

<script type="text/javascript">
	$(function()
	{
		$(".tab_content").hide(); // 처음에 전부 숨기기
		$("ul.tab li:first").addClass("active").show(); // 처음 탭 활성화 
		$(".tab_content:first").show(); // 처음 탭 보여주기

		$("ul.tab li").click(function()
		{
			$("ul.tab li").removeClass("active"); // 활성화 지우기
			$(this).addClass("active"); // 선택된 탭 활성화
			$(".tab_content").hide(); // 전부 숨기기

			var activeTab = $(this).find("a").attr("href"); // 선택된 탭 영역 href 찾기
			$(activeTab).fadeIn();
			return false;
		});

	});
</script>

</head>
<body>
	<div id="outer">
		<div id="inner">
			<form>
				<div class="container">

					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-5">
							<h2>나의 프로필</h2>
						</div>
						<div class="col-md-4">
							<span class="col-md-3" style="padding-top: 5px;">잔여아령</span>
							<input type="text" id="name" name="name" disabled="disabled"
								class="form-control col-md-2"  value="0" />
						</div>

					</div>
					<br>

					<div class="row">
						<div class="col-md-1"></div>
						<label for="name" class="col-md-1">이름</label> <input type="text"
							id="name" name="name" class="form-control col-md-2"
							readonly="readonly" value="${member.memName }" /> <label
							for="age" class="col-md-1">나이</label> <input type="text" id="age"
							name="age" class="form-control col-md-2" readonly="readonly"
							value="${member.age }" /> <label for="gender" class="col-md-1">성별</label>
						<input type="text" id="gender" name="gender"
							class="form-control col-md-2" readonly="readonly"
							value="${member.gender }" />
					</div>
					<br>

					<div class="row">
						<div class="col-md-1"></div>
						<label for="tel" class="col-md-1">Tel.</label> <input type="tel"
							id="tel" name="tel" class="form-control col-md-2"
							readonly="readonly" value="${member.tel }" /> <label
							for="hometel" class="col-md-1">HomeTel.</label> <input type="tel"
							id="hometel" name="hometel" class="form-control col-md-2"
							readonly="readonly" value="${member.hometel }" /> <label
							for="email" class="col-md-1">email.</label> <input type="email"
							id="email" name="email" class="form-control col-md-2"
							readonly="readonly" value="${member.email }" />
					</div>
					<br>

					<div class="row">
						<div class="col-md-1"></div>
						<label for="addr" class="col-md-1">주소</label> <input type="text"
							id="addr" name="addr" class="form-control col-md-5"
							style="width: 600px;" readonly="readonly"
							value="${member.addr } ${member.detailAddr }" />
						<div class="col-md-4" style="text-align: center;">
							<button type="button" class="btn btn-default"
								value="${member.memNo }">프로필 수정</button>
						</div>
					</div>
					<br> <br>

					<div class="row">
						<button type="button" class="btn btn-default col-md-3">알림</button>
						<button type="button" class="btn btn-default col-md-3">강사신청</button>
						<button type="button" class="btn btn-default col-md-3">결제환불내역</button>
						<button type="button" class="btn btn-default col-md-3" onclick="location.href='withdrawalform.action?memNo=${param.memNo}'">회원탈퇴</button>
					</div>
				</div>
				<br> <br>


				<div id="wrapper">
					<ul class="tab">
						<li><a href="#tab1">인바디</a></li>
						<li><a href="#tab2">눈바디</a></li>
					</ul>

					<div class="tab_container">

						<div id="tab1" class="tab_content">
							<div style="text-align: right;">
								<button type="button" class="btn btn-default btnInsert" onclick="location.href='inbodyinsertform.action?memNo=${param.memNo}'">인바디 등록</button>
							</div>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>날짜</th>
										<th>체중(kg)</th>
										<th>키(cm)</th>
										<th>골격근(kg)</th>
										<th>체지방(kg)</th>
										<th>체지방률(%)</th>
										<th>BMI</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="inbody" items="${inbodyList }">
										<tr>
											<td>${inbody.inbodyDate }</td>
											<td>${inbody.weight }</td>
											<td>${inbody.tall }</td>
											<td>${inbody.muscle }</td>
											<td>${inbody.bodyfat }</td>
											<td>${inbody.bodyfatPer }</td>
											<td>${inbody.bmi }</td>
											<td>
												<button type="button" class="btn btn-default btnDelete"
												 value="${member.memNo }">삭제</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<div id="tab2" class="tab_content">
							<div style="text-align: right;">
								<button type="button" class="btn btn-default btnInsert" onclick="location.href='eyebodyinsertform.action?memNo=${param.memNo}'">눈바디 등록</button>
							</div>
							
							<div>
								<div class="row">
									<c:forEach var="eyebody" items="${eyebodyList }">
									<div class="col-4">
										<div class="card">
											<div class="card-header">${eyebody.eyebodyNo }</div>
											<img src="images/img_01.png" alt="" />
											<div class="card-body">
												<h5 class="card-title">${eyebody.eyebodyDate }</h5>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
								
							</div>
						</div>

					</div>

				</div>

			</form>
		</div>
	</div>

</body>
</html>