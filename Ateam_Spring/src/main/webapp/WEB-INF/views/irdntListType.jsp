<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="java.util.List"%>
<%@page import="frigecontents.dto.FrigeContentsDTO"%>
<%@page import="frigecontents.dto.FrigeViewDTO" %>
<%@page import="user.dto.AppUserDTO"%>
<%@page import="com.google.gson.Gson"%>
<%
JsonArray arry = new JsonArray();
Gson gson = new Gson();
	String json = gson.toJson((List<FrigeContentsDTO>)request.getAttribute("irdntListType"));
	
	out.println(json);
%>