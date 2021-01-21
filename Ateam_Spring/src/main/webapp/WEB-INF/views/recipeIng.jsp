<%@page import="recipe.dto.RecipeIngDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
JsonArray arry = new JsonArray();
Gson gson = new Gson();
    String json = gson.toJson((List<RecipeIngDTO>)request.getAttribute("recipeIng"));
    
    out.println(json);
%>