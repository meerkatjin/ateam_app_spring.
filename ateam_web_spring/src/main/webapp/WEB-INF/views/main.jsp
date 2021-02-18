<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
/*메인 내용물 사이즈*/
.main-content-size{ margin:10px 0; text-align: left;}
.main-content-size.notice{ width: 29%; margin-right:9px; }
.main-content-size.recipe{ width: 69%; margin-left:8px; }
.main-content-size-harf{ width: 49.5%; margin:10px 0;}
.main-content-size-harf:nth-child(odd){ margin-right: 3px; }
.main-content-size-harf:nth-child(even){ margin-left: 3px; }
.main-content-con{ width: 100%; padding: 5px 0;}
.main-content-title{ justify-content: space-between; }
.main-content-title a{ line-height: 64px; font-size: 12px;}
.main-content-title a:hover{ color: #0000ff; }
.main-content-bord:not(:first-child){ margin-top: 20px; }
</style>
<img src='imgs/maintitle1.jpg' style='width:100%;'/>
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
			<h3>Q&A</h3>
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
			<h3>커뮤니티</h3>
			<a href="commu.cu">더보기 ></a>
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
			<img src="imgs/test.food.img.jpg" style="width: 100%">
			<p>대충 여기 안에 레시피 설명 넣으면 될듯</p>
		</div>
		<div class="main-content-size-harf bottom-border-2px">
			<img src="imgs/test.food.img.jpg" style="width: 100%">
			<p>대충 여기 안에 레시피 설명 넣으면 될듯</p>
		</div>
		<div class="main-content-size-harf bottom-border-2px">
			<img src="imgs/test.food.img.jpg" style="width: 100%">
			<p>대충 여기 안에 레시피 설명 넣으면 될듯</p>
		</div>
		<div class="main-content-size-harf bottom-border-2px">
			<img src="imgs/test.food.img.jpg" style="width: 100%">
			<p>대충 여기 안에 레시피 설명 넣으면 될듯</p>
		</div>
	</div>
</div>