var debt = {
		init : function() {
			var _this = this;
			$('.logoutbt').on('click', function () {
				_this.logout();
			});
			_this.setTotal();
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
		},
		setTotal : function() {
			var totalGive = 0;
			var totalTake = 0;
			for (var r in debtRecord) {
				totalGive = totalSpend + debtRecord[r].borrowing;
				totalTake = totalImport + debtRecord[r].borrowed;
			}
			$('.jnumber').text(totalGive);
			$('.snumber').text(totalTake);
		}
}
debt.init();