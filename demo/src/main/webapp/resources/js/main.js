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
