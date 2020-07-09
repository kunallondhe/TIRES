<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<div class="products">
	<div class="cl">&nbsp;</div>
	<div id="sessionId"></div>
	<ul>
		<core:forEach items="${products}" var="a">
			<li><a href="#"><img src="${a.image}"
					style="width: 220px; height: 220px;" alt="${a.localisedName}" /></a>
				<div class="product-info">
					<h3>${a.localisedName}</h3>
					<div class="product-desc">
						<h4>${a.itemNumber}</h4>
						<strong class="price">${a.width}/${a.profile}
							R${a.rimsize}</strong>
					</div>
				</div></li>
		</core:forEach>
	</ul>
	<div class="cl">&nbsp;</div>
</div>