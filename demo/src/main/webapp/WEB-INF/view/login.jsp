<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
</style>
<div class="login">
	<form action="signin" method="post">
		<div class="container2">
			<div>
				<label for="uname"><b>Username</b></label>
			</div>
			<div>
				<input type="text" placeholder="Enter Username" name="userid"
					required>
			</div>
			<div>
				<label for="psw"><b>Password</b></label>
			</div>
			<div>
				<input type="password" placeholder="Enter Password" name="passwd"
					required>
			</div>
			<div>&nbsp;</div>
			<div>
				<button type="submit" name="login">Login</button>
			</div>
			<div>&nbsp;</div>
			<div>
				<core:if test="${not empty sessionScope.message}">
					<span style="color: green"><core:out
							value="${sessionScope.message}" /></span>
					<core:remove var="message" scope="session" />
				</core:if>
			</div>
		</div>
	</form>
</div>
<br />

