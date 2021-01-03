var asset = {		
		init : function() {
			var _this = this;
			$('.logoutbt').on('click', function () {
				_this.logout();
			});
			
			$('.pbt').on('click',function(){
	           $('.madal_layer').removeClass('hide');
	           $('.modal').removeClass('hide');
	        });
	            
	        $('.closebt').on('click',function(){
	           $('.madal_layer').addClass('hide');
	           $('.modal').addClass('hide');
	        });

	        $(".js-example-tokenizer").select2({
	            tags: true,
	            tokenSeparators: [',', ' ']
	        });
	        
	        $(".addbt").on('click', function() {
	        	_this.addRecord();
	        });
            
            $('.logo').on('click',function(){
                window.location.href="main";
            });
            $('.flogo').on('click',function(){
                window.location.href="main";
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
		addRecord : function() {
			var spendOrimport = $('input[name=money]:checked').val();
			var money = $('.money').val();
			var data = {
				"assetId" : assetObj.id,
				"userId" : userId,
				"date" : $("select[name=years]").val() + '-' + $("select[name=months]").val() + '-' + $("select[name=days]").val(),
				"about" : $('.meony_n').val(),
				"spend" : spendOrimport == "out" ? money : 0,
				"import_" : spendOrimport == "get" ? money : 0,
				"account" : 0,
				"categoryId" : $("select[name=category]").val()
			}
			
			$.ajax({
				type: 'PUT',
				url: '/record/' + userId + '/',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(data),
			}).done(function(result) {
				var urlVal = '/assetView?assetId=' + assetObj.id;
				window.location.href=urlVal;
			}).fail(function (error) {
				alert(error);
			});
		},
		setTotal : function() {
			var totalSpend = 0;
			var totalImport = 0;
			for (var r in recordList) {
				totalSpend = totalSpend + recordList[r].spend;
				totalImport = totalImport + recordList[r].import_;
			}
			$('.jnumber').text(totalSpend);
			$('.snumber').text(totalImport);
		}
};

asset.init();

function pad(n, width) {
    n = n + '';
    return n.length >= width ? n : new Array(width - n.length + 1).join('0') + n;
}

$(document).ready(function(){
    for (var i = 2021; i<=3500; i++) {
        $('.years').append(new Option(i));
    }
    for (var i = 1; i<=12; i++) {
        $('.months').append(new Option(pad(i, 2)));
    }
    for (var i =1; i<=31; i++) {
        $('.days').append(new Option(pad(i, 2)));
    }
    for (var category in categoryList) {
    	$('.js-example-tokenizer').append(new Option(categoryList[category].name));
    }
});