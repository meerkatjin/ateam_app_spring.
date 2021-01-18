<%@page import="user.dto.AppUserDTO"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 요청값 json으로 반환하는 공용 페이지 --%>
<%
Gson gson = new Gson();
	String json = gson.toJson((AppUserDTO)request.getAttribute("jsonReturn"));
	
	out.println(json);
%>
