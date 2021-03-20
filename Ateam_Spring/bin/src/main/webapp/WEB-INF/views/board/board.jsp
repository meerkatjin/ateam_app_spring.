<%@page import="com.google.gson.Gson"%>
<%@page import="board.dto.BoardDTO"%>
<%@page import="com.google.gson.JsonArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
JsonArray arry = new JsonArray();
Gson gson = new Gson();
	String json = gson.toJson((BoardDTO)request.getAttribute("boardList"));
	
	out.println(json);
%>