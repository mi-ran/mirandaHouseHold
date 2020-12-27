var assetIndex = 0;
var debtIndex = 0;

var index = {		
		init : function() {
			var _this = this;
			$('.logoutbt').on('click', function () {
				_this.logout();
			});
			$('.jasanarea').on('click', function() {
				_this.goAssetView();
			});
            $('.plus1').on('click',function(){
               $('.madal_layer').show();
               $('.modal').show();
            });
            $('.closebt').on('click',function(){
               $('.madal_layer').hide();
               $('.modal').hide();
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
		goAssetView : function() {
			var assetList = $('#assetList');
			alert(assetList[0]);
			$.ajax({
				type: 'GET',
				url: '/assetView?assetId=',
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
    
            $(document).ready(function(){     
                for (var i = 2021; i<=3500; i++) {
                    $('.years').append(new Option(i));
                }
                for (var i = 1; i<=12; i++) {
                    $('.months').append(new Option(i));
                }
                for (var i =1; i<=31; i++) {
                    $('.days').append(new Option(i));
                }
            });