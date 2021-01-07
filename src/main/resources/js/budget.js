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
	        	var urlVal = '/assetView?assetId=' + assetId + "&year=" + curYear + "&month=" + curMonth;
    			window.location.href=urlVal;
            });
            $('.mbt2').on('click', function() {
            	var urlVal = '/budgetView?assetId=' + assetId + "&year=" + curYear + "&month=" + curMonth;
    			window.location.href=urlVal;
            });
            $('.mbt3').on('click', function() {
            	
            });
            $('.addbt').on('click', function() {
            	_this.addBugetRecord();
            });
            
            $('.removeRecord').on('click', function() {
            	var tr = $(this).parent().parent();
    			var recordId = tr.children().eq(0).text();
            	
            	$.ajax({
    				type: 'DELETE',
    				url: '/budget/' + userId + '/',
    				dataType: 'json',
    				contentType: 'application/json; charset=utf-8',
    				data : recordId,
    			}).done(function(result) {
    				alert("삭제 되었습니다.");
    				var urlVal = '/budgetView?assetId=' + assetId + "&year=" + curYear + "&month=" + curMonth;
        			window.location.href=urlVal;
    			}).fail(function (error) {
    				alert(error);
    			});
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
		},
		addBugetRecord : function() {
			var spendOrimport = $('input[name=money]:checked').val();
			var money = $('.money').val();
			var data = {
				"assetId" : assetId,
				"userId" : userId,
				"date" : $("select[name=years]").val() + '-' + $("select[name=months]").val() + '-' + $("select[name=days]").val(),
				"about" : $('.meony_n').val(),
				"spend" : spendOrimport == "out" ? money : 0,
				"import_" : spendOrimport == "get" ? money : 0,
				"categoryId" : $("select[name=category]").val()
			}
			
			$.ajax({
				type: 'PUT',
				url: '/budget/' + userId + '/',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(data),
			}).done(function(result) {
				var urlVal = '/budgetView?assetId=' + assetId + "&year=" + curYear + "&month=" + curMonth;
    			window.location.href=urlVal;
			}).fail(function (error) {
				alert(error);
			});
		}
};

budget.init();