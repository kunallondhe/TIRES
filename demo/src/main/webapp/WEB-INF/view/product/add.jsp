<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ page import="java.util.concurrent.ThreadLocalRandom" %>
<style type="text/css">
span.error {
	color: red;
}
</style>
<div class="products">
	<form action="add" method="post" name="addProduct">
		<div>
			<div>
				<div>
					<label><spring:message code="label.add.itemnumber" /></label>
				</div>
				<div>
					<input type="text" id="itemnumber" name="itemnumber" value="${ThreadLocalRandom.current().nextInt(555555, 999999)}">
				</div>
			</div>
			<div>
				<div>
					<label><spring:message code="label.add.localisedName" /></label>
				</div>
				<div>
					<input type="text" id="localisedName" name="localisedName"
						style="width: 320px;">
				</div>
			</div>
			<div>
				<div>
					<label><spring:message code="label.add.description" /></label>
				</div>
				<div>
					<textarea rows="5" cols="50" id="description" name="description">
					</textarea>
				</div>
			</div>
			<div>
				<div>
					<label><spring:message code="label.add.image" /></label>
				</div>
				<div>
					<input type="text" id="image" name="image" style="width: 320px;">
				</div>
			</div>
			<div>
				<div>
					<label><spring:message code="label.add.width" /></label>
				</div>
				<div>
					<input type="text" name="width" id="width" value="${ThreadLocalRandom.current().nextInt(210, 325)}">
				</div>
			</div>
			<div>
				<div>
					<label><spring:message code="label.add.profile" /></label>
				</div>
				<div>
					<input type="text" id="profile" name="profile" value="${ThreadLocalRandom.current().nextInt(35, 60)}">
				</div>
			</div>
			<div>
				<div>
					<label><spring:message code="label.add.rimsize" /></label>
				</div>
				<div>
					<input type="text" id="rimsize" name="rimsize" value="${ThreadLocalRandom.current().nextInt(15, 22)}">
				</div>
			</div>
			<div>
				<div>
					<label><spring:message code="label.add.speedRating" /></label>
				</div>
				<div>
					<input type="text" id="speedRating" name="speedRating">
				</div>
			</div>
			<div>
				<div></div>
				<div>
					<button class="add-submit" name="add" type="submit">Save</button>
				</div>
			</div>
		</div>
	</form>

</div>