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

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" type="text/css"/>

<!-- modal bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
#outer {
	width: 100%;
}

#inner {
	width: 1100px;
	margin: auto;
	padding: 100px 0;
}

.box {
	text-align: center;
	border: 1px solid gray;
	padding: 3em;
	width: 1100px;
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
	width: 535px;
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

</style>

<script type="text/javascript">
	$(function()
	{
		$(".tab_content").hide(); // ????????? ?????? ?????????
		$("ul.tab li:first").addClass("active").show(); // ?????? ??? ????????? 
		$(".tab_content:first").show(); // ?????? ??? ????????????

		$("ul.tab li").click(function()
		{
			$("ul.tab li").removeClass("active"); // ????????? ?????????
			$(this).addClass("active"); // ????????? ??? ?????????
			$(".tab_content").hide(); // ?????? ?????????

			var activeTab = $(this).find("a").attr("href"); // ????????? ??? ?????? href ??????
			$(activeTab).fadeIn();
			return false;
		});

	});
</script>

<script type="text/javascript">
	
	$(function()
	{ 
		// ????????? ?????? ?????? ??????
		$(".inbodyDelete").click(function()
		{
			if(confirm("?????? ????????? ???????????? ?????? ?????????????????????????"))
	         {				
	            $(location).attr("href", "inbodydelete.action?inbodyNo=" + $(this).val());
	         }
		});
		// ????????? ?????? ?????? ??????
		$(".eyebodyDelete").click(function()
		{
			if(confirm("?????? ????????? ???????????? ?????? ?????????????????????????"))
	         {				
	            $(location).attr("href", "eyebodydelete.action?eyebodyNo=" + $(this).val());
	         }
		});
	});
	
</script>

</head>
<body>

<c:import url="/WEB-INF/mainView/Header.jsp"></c:import>

	<div id="outer">
		<div id="inner" class="row">
				<div class="box">

					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-5">
							<h2>?????? ?????????</h2>
						</div>
						<div class="col-md-4 row">
							<span class="col-md-5" style="padding-top: 0.5em;">????????????</span>
							<input type="text" id="name" name="name" disabled="disabled" value="${havepoint }"
								class="form-control col-md-7" style="width:80px; text-align:right;" />
						</div>

					</div>
					<br>

					<div class="row">
						<div class="col-md-1"></div>
						<label for="name" class="col-md-1">??????</label> <input type="text"
							id="name" name="name" class="form-control col-md-2" style="width: 200px;"
							readonly="readonly" value="${member.memName }" /> <label
							for="age" class="col-md-1">??????</label> <input type="text" id="age"
							name="age" class="form-control col-md-2" readonly="readonly" style="width: 200px;"
							value="${member.age }" /> <label for="gender" class="col-md-1">??????</label>
						<input type="text" id="gender" name="gender"
							class="form-control col-md-2" readonly="readonly" style="width: 200px;"
							value="${member.gender }" />
					</div>
					<br>

					<div class="row">
						<div class="col-md-1"></div>
						<label for="tel" class="col-md-1">Tel.</label> <input type="tel"
							id="tel" name="tel" class="form-control col-md-2" style="width: 200px;"
							readonly="readonly" value="${member.tel }" /> <label
							for="hometel" class="col-md-1">HomeTel.</label> <input type="tel"
							id="hometel" name="hometel" class="form-control col-md-2" style="width: 200px;"
							readonly="readonly" value="${member.hometel }" /> <label
							for="email" class="col-md-1">email.</label> <input type="email"
							id="email" name="email" class="form-control col-md-2" style="width: 200px;"
							readonly="readonly" value="${member.email }" />
					</div>
					<br>

					<div class="row">
						<div class="col-md-1"></div>
						<label for="addr" class="col-md-1">??????</label> <input type="text"
							id="addr" name="addr" class="form-control col-md-4"
							style="width: 500px;" readonly="readonly"
							value="${member.addr } ${member.detailAddr }" />
						<div class="col-md-1"></div>
						<button type="button" class="btn btn-primary col-md-2"
							onclick="location.href='privacyupdateform.action'">????????? ??????</button>
					</div>
					<br> <br>

					<div class="row">
						<div class="col-md-1"></div>
						<button type="button" class="btn btn-primary col-md-2">??????</button>
						<button type="button" class="btn btn-primary col-md-2" onclick="location.href='instructorinsertform.action'">????????????</button>
						<button type="button" class="btn btn-primary col-md-2" onclick="location.href='pointform.action'">?????? ??????</button>
						<button type="button" class="btn btn-primary col-md-2" onclick="location.href='payrefund.action'">??????????????????</button>
						<button type="button" class="btn btn-primary col-md-2" onclick="location.href='withdrawalform.action'">????????????</button>
					</div>
				</div>
				<br><br><br>

				<div id="wrapper" class="row">
					<ul class="tab">
						<li><a href="#tab1">?????????</a></li>
						<li><a href="#tab2">?????????</a></li>
					</ul>

					<div class="tab_container">

						<div id="tab1" class="tab_content">
							<div style="text-align: right;">
								<button type="button" class="btn btn-primary btnInsert" onclick="location.href='inbodyinsertform.action'">????????? ??????</button>
							</div>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>??????</th>
										<th>??????(kg)</th>
										<th>???(cm)</th>
										<th>?????????(kg)</th>
										<th>?????????(kg)</th>
										<th>????????????(%)</th>
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
												<button type="button" class="btn btn-danger btnDelete inbodyDelete" value="${inbody.inbodyNo }" >??????</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<div id="tab2" class="tab_content">
							<form action="eyebodyinsert.action" method="post" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-7"></div>
									<div class="col-md-5 row">
										<input type="file" role="button" name="photoPath" class="btn btn-default col-md-9" >
										<input type="submit" value="????????? ??????" class="btn btn-primary col-md-3">
									</div>
								</div>
							</form>
							 
							<!-- Eyebody Grid-->
					        <section class="page-section bg-light" id="portfolio">
					                <div class="row">
					                	<c:forEach var="eyebody" items="${eyebodyList }">
					                    <div class="col-lg-4 col-sm-6 mb-4"">
					                        <div class="portfolio-item">
					                            <a class="portfolio-link" data-bs-toggle="modal" href="#${eyebody.eyebodyNo }"  style="height:300px;">
					                                <div class="portfolio-hover">
					                                    <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
					                                </div>
					                                <img class="img-fluid" src="${eyebody.photoPath }" alt="?????????" />
					                            </a>
					                            
					                            <div class="portfolio-caption">
					                                <div class="portfolio-caption-subheading text-muted">${eyebody.eyebodyDate }</div>
					                            </div>
					                        </div>
					                    </div>
					                    </c:forEach>
					                </div>
					        </section>
							<!-- Eyebody modal popup-->
							<c:forEach var="eyebody" items="${eyebodyList }">
					        <div class="portfolio-modal modal fade" id="${eyebody.eyebodyNo }" tabindex="-1" role="dialog" aria-hidden="true">
					            <div class="modal-dialog">
					                <div class="modal-content">
					                    <div class="close-modal" data-bs-dismiss="modal"><img src="assets/img/close-icon.svg" alt="Close modal" /></div>
					                    <div class="container">
					                        <div class="row justify-content-center">
					                            <div class="col-md-8">
					                                <div class="modal-body">
					                                    <!-- Project details-->
					                                    <p class="item-intro text-muted">${eyebody.eyebodyDate }</p>
					                                    <img class="img-fluid d-block mx-auto" src="${eyebody.photoPath }" alt="?????????" />
					                                	<button class="btn btn-danger eyebodyDelete" value="${eyebody.eyebodyNo }" >??????</button>
					                                </div>
					                            </div>
					                        </div>
					                    </div>
					                </div>
					            </div>
					        </div>
					        </c:forEach>
							
						</div>

					</div>

				</div>
		</div>
	</div>
	
	<div class="row">
		<c:import url="/WEB-INF/mainView/Footer.jsp"></c:import>
	</div>
</body>
</html>