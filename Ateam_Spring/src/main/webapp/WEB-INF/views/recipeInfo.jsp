<%@page import="recipeinfo.dto.RecipeInfoDTO"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Gson gson = new Gson();
String json = gson.toJson((RecipeInfoDTO)request.getAttribute("recipeInfo"));

out.println(json);
%>