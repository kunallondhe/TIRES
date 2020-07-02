<style type="text/css">
  span.error{
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
							<label>Width</label>
						</div>
						<div style=" clear: both;">
							<input type="text" name="width" id="width">
						</div>
					</div>
					<div>
						<div>
							<label>Profile</label>
						</div>
						<div>
							<input type="text" id="profile" name="profile">
						</div>
					</div>
					<div>
						<div>
							<label>Rim Size</label>
						</div>
						<div>
							<input type="text" id="rimsize" name="rimsize">
						</div>
					</div>

					<div>
						<div></div>
						<div>
							<button class="search-submit" type="submit">Search</button>
						</div>
					</div>
				</div>
			</form>

		</div>
		<p>
			<a href="<core:url value="/add"/>" class="bul">Add Product</a>
		</p>
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