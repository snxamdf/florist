$.validator.setDefaults({
	ignore : "",
	submitHandler: function(form) {
		$("#messageBox").removeClass("show");
		$("#messageBox").addClass("hidden");
		form.submit();
	},
	highlight: function(element) {
		$(element).closest('div').addClass("has-error");
	},
	unhighlight: function(element) {
		$(element).closest('div').removeClass("has-error");
		$(element).qtip('destroy');
	},
	errorContainer: "#messageBox",
	errorPlacement: function(error, element) {
		$("#messageBox").removeClass("hidden");
		$("#messageBox").addClass("show");
		$("#messageBox").children("strong").text("输入有误，请先更正");
		var tips = $(element);
		if (element.context.type == "checkbox") {
			tips = $(element).parent().parent().parent();
		}
		if (element.context.type == "hidden") {
			tips = $(element).parent();
		}
		tips.qtip({
			position: {
				my: 'bottom left',
				at: 'top center'
			},
			style: {
				classes: 'qtip-red'
			},
			content: $(error).text()
		});
	}
});