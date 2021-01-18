var debtObj = {
		init : function() {
			var _this = this;
			$('.logoutbt').on('click', function () {
				_this.logout();
			});
			$('.addbt').on('click', function () {
				_this.addDebtRecord();
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
				totalGive = totalGive + debtRecord[r].borrowing;
				totalTake = totalTake + debtRecord[r].borrowed;
			}
			$('.jnumber').text(totalGive);
			$('.snumber').text(totalTake);
		},
		addDebtRecord : function() {
			
			var giveNtake = $('input[name=money]:checked').val();
			var money = $('.money').val();
			var borrowed = giveNtake == "give" ? 0 : money;
			var borrowing = giveNtake == "give" ? money : 0;
			
			var data = {
				"debtId" : debt.id,
				"date" : $("select[name=years]").val() + '-' + $("select[name=months]").val() + '-' + $("select[name=days]").val(),
				"borrowed" : borrowed,
				"borrowing" : borrowing
			}
			
			$.ajax({
				type: 'PUT',
				url: '/debt/' + userId + '/record',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(data),
			}).done(function(result) {
				var urlVal = '/debtView?debtId=' + debt.id;
    			window.location.href=urlVal;
			}).fail(function (error) {
				alert(error);
			});
		}
}
debtObj.init();