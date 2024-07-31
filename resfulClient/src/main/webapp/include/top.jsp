<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<c:set var="path" scope="session"
	value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> 마주 골프 회원 관리 </title>
		<link href="${path}/include/css/top.css" rel="stylesheet" type="text/css"/>
		<style type="text/css">
		</style>
	</head>
	<body>
		<header> 골프연습장 회원관리 ver1.0 </header>
			<nav class=noto-sans-kr-uniquifier> &emsp;&emsp;
			<a href="${path}/list.jsp"> 목록 보기 </a>			
			<a href="${path}/index.jsp"> 홈으로 </a> &emsp;&emsp;
			
			</nav>