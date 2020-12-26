var index = {
		init : function() {
			var _this = this;
			$('.logoutbt').on('click', function () {
				_this.doLogin();
			});
		},
		doLogin : function() {
			$.ajax({
				type: 'GET',
				url: '/logout',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
			}).done(function(result) {
				window.location.href="login";
			}).fail(function (error) {
				alert(error);
			});
		}
};

index.init();