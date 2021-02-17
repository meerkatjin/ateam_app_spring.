<%@page import="recipe.dto.RecipeIrdntDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
JsonArray arry = new JsonArray();
Gson gson = new Gson();
    String json = gson.toJson((List<RecipeIrdntDTO>)request.getAttribute("recipeIrdnt"));
    
    out.println(json);
%>