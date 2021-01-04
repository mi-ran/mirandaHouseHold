var budget = {
		init : function() {
			var _this = this;
			$('.logoutbt').on('click', function () {
				_this.logout();
			});
			$('.logo').on('click',function(){
	            window.location.href="main";
	        });
	        $('.flogo').on('click',function(){
	            window.location.href="main";
	        });
	        $('.mbt1').on('click', function() {
            	
            });
            $('.mbt2').on('click', function() {
            	window.location.href="budgetView";
            });
            $('.mbt3').on('click', function() {
            	
            });
		},
		logout : function() {
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

budget.init();