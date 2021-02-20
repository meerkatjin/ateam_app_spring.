<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
/*메인 내용물 사이즈*/
.main-content-size { margin: 10px 0; text-align: left; }
.main-content-size.notice { width: 29%; margin-right: 9px; }
.main-content-size.recipe { width: 69%; margin-left: 8px; }
.main-content-size-harf { width: 49.5%; margin: 10px 0; }
.main-content-size-harf:nth-child(odd) { margin-right: 3px; }
.main-content-size-harf:nth-child(even) { margin-left: 3px; }
.main-content-con { width: 100%; padding: 5px 0; }
.main-content-title { justify-content: space-between; }
.main-content-title a { line-height: 64px; font-size: 12px; }
.main-content-title a:hover { color: #0000ff; }
.main-content-bord:not(:first-child) { margin-top: 20px; }

/* Hide the images by default */
.mySlides {
	display: none;
}

/* Number text (1/3 etc) */
.numbertext {
	color: #f2f2f2;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}

.row{
	position: absolute;
	bottom: 0;
	width: 100%;
}

/* Six columns side by side */
.column {
	float: left;
	border: solid 1px #000;
}

/* Add a transparency effect for thumnbail images */
.demo {
	opacity: 0.4;
}

.active, .demo:hover {
	opacity: 1;
}

.cursor {
  cursor: pointer;
}
</style>
<div style="position: relative;">
	<div class="mySlides">
		<div class="numbertext">1 / 3</div>
		<img src="imgs/main/maintitle1.jpg" style="width: 100%" />
	</div>
	
	<div class="mySlides">
		<div class="numbertext">2 / 3</div>
		<img src="imgs/main/maintitle2.jpg" style="width: 100%" />
	</div>
	
	<div class="mySlides">
		<div class="numbertext">3 / 3</div>
		<img src="imgs/main/maintitle3.jpg" style="width: 100%" />
	</div>
	
	<div class="row">
		<div class="column">
			<img class="demo cursor" src="imgs/main/maintitle1.small.jpg" style="width: 100%"
				onclick="currentSlide(1)" />
		</div>
		<div class="column">
			<img class="demo cursor" src="imgs/main/maintitle2.small.jpg" style="width: 100%"
				onclick="currentSlide(2)" />
		</div>
		<div class="column">
			<img class="demo cursor" src="imgs/main/maintitle3.small.jpg" style="width: 100%"
				onclick="currentSlide(3)" />
		</div>
	</div>
</div>
<div class="main-content-size notice">
	<div class="main-content-bord">
		<div class="flexSet-wrap main-content-title">
			<h3>공지</h3>
			<a href="list.no">더보기 ></a>
		</div>
		<div class="main-content-con bottomtop-border-2px">
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
		</div>
	</div>
	<div class="main-content-bord">
		<div class="flexSet-wrap main-content-title">
			<h3>Q&amp;A</h3>
			<a href="list.qa">더보기 ></a>
		</div>
		<div class="main-content-con bottomtop-border-2px">
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
		</div>
	</div>
	<div class="main-content-bord">
		<div class="flexSet-wrap main-content-title">
			<h3>게시판</h3>
			<a href="list.bo">더보기 ></a>
		</div>
		<div class="main-content-con bottomtop-border-2px">
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
			<hr>
			<a href="#">dd</a>
		</div>
	</div>
</div>

<div class="main-content-size recipe ">
	<div class="flexSet-wrap main-content-title">
		<h3>레시피</h3>
		<a href="list.rp">더보기 ></a>
	</div>
	<div class="flexSet-wrap main-content-con top-border-2px">
		<div class="main-content-size-harf bottom-border-2px">
			<img src="imgs/test/test.food.img.jpg" style="width: 100%">
			<p>대충 여기 안에 레시피 설명 넣으면 될듯</p>
		</div>
		<div class="main-content-size-harf bottom-border-2px">
			<img src="imgs/test/test.food.img.jpg" style="width: 100%">
			<p>대충 여기 안에 레시피 설명 넣으면 될듯</p>
		</div>
		<div class="main-content-size-harf bottom-border-2px">
			<img src="imgs/test/test.food.img.jpg" style="width: 100%">
			<p>대충 여기 안에 레시피 설명 넣으면 될듯</p>
		</div>
		<div class="main-content-size-harf bottom-border-2px">
			<img src="imgs/test/test.food.img.jpg" style="width: 100%">
			<p>대충 여기 안에 레시피 설명 넣으면 될듯</p>
		</div>
	</div>
</div>

<script>
var slideIndex = 1;
var timerId = null;
showSlides(slideIndex);

function increasIndex(){
  showSlides(slideIndex++);
}

function currentSlide(n) {
  clearTimeout(timerId);
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  var captionText = document.getElementById("caption");
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  if (slideIndex > slides.length) {slideIndex = 1}  
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
  
  timerId = setTimeout(increasIndex, 5000);
}
</script>