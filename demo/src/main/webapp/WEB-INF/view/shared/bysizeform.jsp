<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style type="text/css">
span.error {
	color: red;
}
</style>

<!-- Sidebar -->
<div id="sidebar">
	<!-- Search -->
	<div class="box search">
		<h2>
			<span>Search by Size</span>
		</h2>
		<div class="box-content">

			<form action="searchbysize" method="get" name="bysizeform">
				<div>
					<div>
						<div>
							<label><spring:message code="label.search.width" /></label>
						</div>
						<div>
							<input type="text" name="width" id="width">
						</div>
					</div>
					<div>
						<div>
							<label><spring:message code="label.search.profile" /></label>
						</div>
						<div>
							<input type="text" id="profile" name="profile">
						</div>
					</div>
					<div>
						<div>
							<label><spring:message code="label.search.rimsize" /></label>
						</div>
						<div>
							<input type="text" id="rimsize" name="rimsize">
						</div>
					</div>

					<div>
						<div></div>
						<div>
							<button class="search-submit" name="search" type="submit">Search</button>
						</div>
					</div>
				</div>
			</form>

		</div>
	</div>
	<!-- End Search -->
	<!-- Categories -->
	<div class="box categories">
		<h2>
			Advertisement <span></span>
		</h2>
		<div class="box-content"></div>
	</div>
	<!-- End Categories -->
</div>
<!-- End Sidebar -->