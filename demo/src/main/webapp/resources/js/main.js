$(document).ready(function() {
	
	$("#Search").click(function() {
		var url = 'search'
		var width = $("#width").val();
		var profile = $("#profile").val();
		var rimsize = $("#rimsize").val();
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
				//console.log(JSON.stringify(response.products));				
			}
		});
	});
});