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
<title>InstructorPageMain.jsp</title>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />

<style type="text/css">
	#outer{width: 100%;}
	.inner
	{
		width: 1100px;
		margin: auto;
		padding: 50px 0;
	}
	.btnTop{padding: 2em;}
	.TrainerPageTitle
	{
		text-align: center;
		font-size: 40px;
		font-weight: bold;
	}
	#TrainerPageNotice{margin-left: 85%;}
	#picture
	{
		width: 150px;
		height: 200px;
		margin: 0 0 25px 75px;
	}
	#pictureModify
	{
		margin-left: 80px;
		width: 150px;
	}
	#profile{margin-left: 50px;}
	#profile input{margin-bottom: 30px;}
	#profile h4
	{
		display: inline-block;
		width: 100px;
		text-align: center;
		font-size: 15pt;
		margin: 0 30px;
	}
	.table th,td{text-align: center;}
	#review
	{
		padding: 2em;
	}
	#trainerScheduleModify{margin-left: 70%;}
	#classLink
	{
		width: 1100px;
		text-align: center;
		margin: 50px 0;
	}
	#classBtn
	{
		margin-top: 50px;
		margin-left: 28%;
		margin-bottom: 50px;
	}
	#classBtn .btn{width: 120px;}
	#bottomBtn{margin-left: 24%;}
</style>
</head>
<body>

<c:import url="/WEB-INF/mainView/Header.jsp"></c:import>

<div id="outer">
	
	<div class="inner">
		
		<div class="row">
		
			<h1 class="TrainerPageTitle">나의 강사 프로필</h1>
		
			<div class="btnTop col-md-12">
				<button type="button" id="TrainerPageNotice" class="btn-primary">알림</button>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-3">
				<img src="<%=cp %>/images/img.jpg" id="picture"><br>
				<button type="button" id="pictureModify" class="btn-primary">프로필 수정요청</button>
			</div>
			
			<div class="col-md-9">
				
				<div id="profile">
					<div class="form-group col-md-6">
						<h4>이름</h4>
						<input type="text" id="name" name="name" value="${profile.insName }" disabled="disabled"/>
					</div>
					<div class="form-group col-md-6">
						<h4>나이</h4>
						<input type="text" id="age" name="age" value="${profile.age }" disabled="disabled"/>
					</div>
					<div class="form-group col-md-6">
						<h4>성별</h4>
						<input type="text" id="gender" name="gender" value="${profile.gender }" disabled="disabled"/>
					</div>
					<div class="form-group col-md-6">
						<h4>이메일</h4>
						<input type="text" id="gender" name="gender" value="${profile.email }" disabled="disabled"/>
					</div>
					<div class="form-group col-md-6">
						<h4>팔로워수</h4>
						<input type="text" id="follower" name="follower" value="${follower }" disabled="disabled"/>
					</div>
					<div class="form-group col-md-6">
						<h4>전체평점</h4>
						<input type="text" id="grade" name="grade" value="${grade }" disabled="disabled"/>
					</div>
					<div class="form-group">
						<h3>활동지역</h3>
						<c:forEach var="area" items="${areas }">
							<input type="text" name="area" value="${area.area }" disabled="disabled"/>
						</c:forEach>
					</div>
					<div class="form-group">
						<h3>활동경력</h3>
						<table class="table table-bordered table-hover">
							<tr>
								<th>활동내용</th>
								<th>시작날짜</th>
								<th>종료날짜</th>
							</tr>
						<c:forEach var="experience" items="${experiences }">
							<tr>
								<td>${experience.expContent }</td>
								<td>${experience.expStartDate }</td>
								<td>${experience.expEndDate }</td>
							</tr>
						</c:forEach>
						</table>
					</div>
					<div class="form-group">
						<h3>수상경력</h3>
						<table class="table table-bordered table-hover">
							<tr>
								<th>수상내용</th>
								<th>수상메달</th>
								<th>수상날짜</th>
							</tr>
						<c:forEach var="prize" items="${prizes }">
							<tr>
								<td>${prize.przName }</td>
								<td>${prize.przMedal }</td>
								<td>${prize.przDate }</td>
							</tr>
						</c:forEach>
						</table>
					</div>
					<div class="form-group">
						<h3>자격증</h3>
						<table class="table table-bordered table-hover">
							<tr>
								<th>자격증명</th>
								<th>발급처</th>
								<th>취득날짜</th>
							</tr>
						<c:forEach var="certificate" items="${certificates }">
							<tr>
								<td>${certificate.cerName }</td>
								<td>${certificate.issueName }</td>
								<td>${certificate.cerDate }</td>
							</tr>
						</c:forEach>
						</table>
					</div>
					<div class="form-group">
						<h3>한줄소개</h3>
						<input type="text" class="form-control" value="${profile.introduce }" disabled="disabled"/>
					</div>
				</div>
				
			</div>
		
		</div>
		
		<div class="row">
		
			<div class="col-md-12">
			
				<div class="col-md-12" style="text-align: center">
					<h3>현재강좌</h3>
					<a href="강좌상세보기.action?classNo=${nowClass.classNo }">${nowClass.className }</a><br>
				</div>
					
				<c:forEach var="review" items="${reviews }">
				<div id="review" class="col-md-6">
					<h3>최신리뷰</h3>
					<textarea rows="5" cols="65" disabled="disabled">${review.reviewContent }</textarea><br>
				</div>
				</c:forEach>
				<div class="col-md-12" style="text-align: center">
					<a href="">리뷰 더보기</a>
				</div>
				
			</div>
		</div>
		
		
		<div class="row">
		
			<h1 class="TrainerPageTitle">스케줄표</h1>
		
			<div class="col-md-12 btnTop">
				<button type="button" id="trainerScheduleModify" class="btn-primary"
				style="width: 120px;">스케줄변경</button>
				<button type="button" id="studentWaiting" class="btn-primary"
				style="width: 120px;">회원 예약 대기</button>
			</div>
			
			<div id="scheduleList" style="width: 1100px; height: 500px; border: 1px solid;">
				스케줄표 들어갈 공간<br>
				추후 div에 걸린 스타일도 지우기
			</div>
			
			<div class="col-md-12">
				<h2 style="text-align: center;">스케줄 상세보기</h2>
				
				<table class="table table-bordered table-hover">
					<tr>
						<th>수강시간</th>
						<th>수강생명</th>
						<th>연락처</th>
						<th>수강생주소</th>
						<th>비고</th>
					</tr>
					<tr>
						<td>10:00~11:00</td>
						<td>홍길동(honggil)</td>
						<td>010-1111-1111</td>
						<td>경기도 xx시 xx동 xx아파트 xxx동 xxx호</td>
						<td>
							<button type="button" class="btn-primary">스케줄 취소</button>
						</td>
					</tr>
					<tr>
						<td>12:00~13:00</td>
						<td>김길동(kimgil)</td>
						<td>010-2222-2222</td>
						<td>경기도 xx시 xx동 xx빌라 xxx동 xxx호</td>
						<td>
							<button type="button" class="btn-primary">스케줄 취소</button>
						</td>
					</tr>
				</table>
				
			</div>
			
		</div>
		
		<div class="row">
		
			<h1 class="TrainerPageTitle">나의 강좌</h1>
			
			<div id="classLink">
				<a href="">여름 대비 몸짱 프로젝트 / 21.10.21 ~ 22.05.31</a>
			</div>
			
			<div id="classBtn">
				<button type="button" class="btn-primary">회원명단</button>
				<button type="button" class="btn-primary">강좌등록</button>
				<button type="button" class="btn-primary">강좌연장</button>
				<button type="button" class="btn-primary">강좌폐쇄</button>
			</div>
			
			<div id="classLink">
				<a href="">이전 강좌 목록</a>
			</div>
			
			<div id="bottomBtn">
				<button type="button" class="btn-primary" style="width: 300px;">원데이클래스 구직현황</button>
				<button type="button" class="btn-primary" style="width: 300px;">정산현황</button>
			</div>
			
		</div>
		
	</div>
	
</div>

<c:import url="/WEB-INF/mainView/Footer.jsp"></c:import>

</body>
</html>