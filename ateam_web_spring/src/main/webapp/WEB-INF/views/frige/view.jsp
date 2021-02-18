<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My 냉장고</title>
<style type="text/css">
.container {
	width: 100%;
}
.view {
	display: inline-block;
	width: 49%;
	height: 500px;
	margin-bottom: 30px;
}
</style>
</head>
<body>
<div class="container">
	<h3 align="left">My 냉장고</h3>
	<div class="view" id="camera" style="position: relative; left: -1%;">A</div>
	<div class="view" id="irdnt_list" style="position: relative; right: -1%;">
		<div id="filter">
			
		</div>
		<div id="type-filter"></div>
		<div id="irdnt_items">
		B
		</div>
	</div>
</div>
</body>
</html>