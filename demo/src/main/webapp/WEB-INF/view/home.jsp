<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<core:url value="/" var="home" scope="request" />
<core:url value="/resources/css/ie6.css" var="ie6" />
<core:url value="/resources/css/style.css" var="mainstyle" />
<core:url value="/resources/js/jquery-3.5.1.min.js" var="jqueryJs" />
<core:url value="/resources/js/main.js" var="jmain" />

<link href="${ie6}" rel="stylesheet" />
<link href="${mainstyle}" rel="stylesheet" />
</head>
<body>
	<!-- Shell -->
	<div class="shell">
		<%@include file="./shared/header.jsp"%>
		<!-- Main -->
		<div id="main">
			<div class="cl">&nbsp;</div>
			<!-- Content -->
			<div id="content">
				
			</div>
			<!-- End Content -->
			<%@include file="./shared/search.jsp"%>
			<div class="cl">&nbsp;</div>
		</div>
		<!-- End Main -->
		<!-- Side Full -->
		<div class="side-full"></div>
		<!-- End Side Full -->
		<%@include file="./shared/footer.jsp"%>
	</div>
	<!-- End Shell -->

	<script src="${jqueryJs}"></script>
	<script src="${jmain}"></script>
</body>
</html>
