var loginObj = {
		init : function() {
			var _this = this;
			$('.lgbt').on('click', function () {
				_this.doLogin();
			});
		},
		doLogin : function() {
			$.ajax({
				type: 'GET',
				url: '/user/login?userId=' + $('.id').val() + '&password=' + $('.pw').val(),
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
			}).done(function(result) {
				if (result == false) {
					alert("Invalid Password");
				} else {
					window.location.href="main";
				}
			}).fail(function (error) {
				alert(error);
			});
		}
};

loginObj.init();