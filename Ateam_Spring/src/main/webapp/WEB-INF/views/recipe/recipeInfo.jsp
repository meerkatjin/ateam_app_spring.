<%@page import="com.google.gson.JsonArray"%>
<%@page import="java.util.List"%>
<%@page import="recipe.dto.RecipeInfoDTO"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 요청값 json으로 반환하는 공용 페이지 --%>
<%
JsonArray arry = new JsonArray();
Gson gson = new Gson();
	String json = gson.toJson((List<RecipeInfoDTO>)request.getAttribute("recipeInfo"));
	
	out.println(json);
%>