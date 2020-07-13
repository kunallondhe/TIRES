$('button[name=search]').click(
		function(e) {
			// Prevent default submission of form
			e.preventDefault();
			// Remove all errors
			$('input').next().remove();
			$('input').next().remove();

			var url = 'searchbysize'
			var width = $("#width").val();
			var profile = $("#profile").val();
			var rimsize = $("#rimsize").val();
			$.get({
				data : $('form[name=bysizeform]').serialize(),
				url : url,
				success : function(res) {
					if (res.validated) {
						// Set response
						$("#content").load("product/plp");
						// console.log(JSON.stringify(response.products));

					} else {
						// Set error messages
						$.each(res.errorMessages, function(key, value) {
							$('input[name=' + key + ']').after(
									'<br/><span class="error">' + value
											+ '</span>');
						});
					}
				}
			});
		});
$('button[name=add]').click(
		function(e) {
			// Prevent default submission of form
			e.preventDefault();
			// Remove all errors
			$('input').next().remove();
			$('input').next().remove();

			var url = 'product/add'
			var itemnumber = $("#itemnumber").val();
			var localisedName = $("#localisedName").val();
			var description = $("#description").val();
			var image = $("#image").val();
			var width = $("#width").val();
			var profile = $("#profile").val();
			var rimsize = $("#rimsize").val();
			var speedRating = $("#speedRating").val();

			$.get({
				data : $('form[name=addProduct]').serialize(),
				url : url,
			  	success : function(res) {
					if (res.validated) {
						// Set response
						// $("#content").load("product/plp");
						console.log(res);
					} else {
						// Set error messages
						$.each(res.errorMessages, function(key, value) {
							$('input[name=' + key + ']').after(
									'<br/><span class="error">' + value
											+ '</span>');
						});
					}
				}
			});
		});
