<%@page import="user.dto.AppUserDTO"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
Gson gson = new Gson();
	String json = gson.toJson((AppUserDTO)request.getAttribute("appLogin"));
	
	out.println(json);
%>
