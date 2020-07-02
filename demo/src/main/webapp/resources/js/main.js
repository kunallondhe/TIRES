$(document).ready(function() {
	console.log("ready!");

	$("#Search").click(function() {
		var url = 'search'
		var width = $("#width").val();
		var profile = $("#profile").val();
		var rimsize = $("#rimsize").val();

		/*
		 * var json = { "width" : width, "profile" : profile, "rimsize" :
		 * rimsize };
		 */

		/*
		 * $.ajax({ contentType : "application/json", data :
		 * $(json).serialize(), type : "POST", url : url, dataType : 'json',
		 * success : function(response) {
		 * onsole.log(JSON.stringify(response.products));
		 * $("#content").html(response.products); } });
		 */

		$.ajax({
			contentType : "application/json",
			data : {
				"width" : width,
				"profile" : profile,
				"rimsize" : rimsize
			},
			type : "GET",
			url : url,
			dataType : 'json',
			success : function(response) {
				$("#content").load("product/plp");
				console.log(JSON.stringify(response.products));
				//$("#content").html(response.products);
			}
		});

	});
});