<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!-- Header -->
<div id="header">
	<h1 id="logo">
		<a href="#">Tires.com</a>
	</h1>
	<!-- Cart -->
	<div id="cart">
		<core:if test="${not empty sessionScope.username}">
			<a href="signout" class="cart-link">Logout</a>
			<div class="cl">&nbsp;</div>
			<span><strong>You are logged in as</strong></span> &nbsp;&nbsp;<span><strong>${sessionScope.username}</strong></span>
		</core:if>
	</div>
	<!-- End Cart -->
	<!-- Navigation -->
	<div id="navigation">
		<ul>
			<li><a href="./">Home</a></li>
			<core:if test="${empty sessionScope.username}">
				<li><a href="./login">Admin Section</a></li>
			</core:if>
			<core:if test="${not empty sessionScope.username}">
				<li><a href="./view">Add Product</a></li>
			</core:if>
		</ul>
	</div>
	<!-- End Navigation -->
</div>
<!-- End Header -->