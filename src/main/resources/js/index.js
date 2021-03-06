var assetIndex = 0;
var debtIndex = 0;

var index = {		
		init : function() {
			var _this = this;
			$('.logoutbt').on('click', function () {
				_this.logout();
			});
			$('.bank').on('click', function() {
				_this.goAssetView();
			});
			$('.bij').on('click', function() {
				_this.goDebtView();
			});
            $('.plus1').on('click',function(){
               $('.madal_layer').show();
               $('.modal').show();
            });
            $('.closebt').on('click',function(){
               $('.madal_layer').hide();
               $('.modal').hide();
            });
            $('.plus2').on('click',function(){
                $('.madal_layer').show();
                $('.modal2').show();
            });
            $('.closebt2').on('click',function(){
               $('.madal_layer').hide();
               $('.modal2').hide();
            });
            $('.addbt').on('click', function() {
            	_this.addAsset();
            });
            $('.leftbt1').on('click', function() {
            	_this.showAgoAsset();
            });
            $('.rightbt1').on('click', function() {
            	_this.showNextAsset();
            });
            $('.leftbt2').on('click', function() {
            	_this.showAgoDebt();
            });
            $('.rightbt2').on('click', function() {
            	_this.showNextDebt();
            });
            
            $('.logo').on('click',function(){
                window.location.href="main";
            });
            $('.flogo').on('click',function(){
                window.location.href="main";
            });
            $('.addbt2').on('click', function() {
            	_this.addDebt();
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
			
			var urlVar = '/assetView?assetId=';
			if (assetList.length == 0) {
				urlVar = urlVar + '-1';
			} else {
				urlVar = urlVar + assetList[assetIndex].id;
			}
			
			window.location.href=urlVar;
		},
		goDebtView : function() {
			var urlVar = '/debtView?debtId=';
			if (debtList.length == 0) {
				urlVar = urlVar + '-1';
			} else {
				urlVar = urlVar + debtList[debtIndex].id;
			}
			window.location.href=urlVar;
		},
		addAsset : function() {
			var data = {
				"assetName" : $('.bank_name').val(),
				"account" : $('.money').val(),
				"userId" : userId
			};
			
        	$.ajax({
				type: 'PUT',
				url: '/asset/' + userId + '/',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(data),
			}).done(function(result) {
				alert("SUCESS")
				window.location.href="main";
			}).fail(function (error) {
				alert(error);
			});
		},
		addDebt : function() {
			var giveNtake = $('input[name=money]:checked').val();
			var money = $('.debtMoney').val();
			var data = {
				"userId" : userId,
				"name" : $('.name').val(),
				"account" : giveNtake == "give" ? money : -1 * money
			}
			
			$.ajax({
				type: 'PUT',
				url: '/debt/' + userId,
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(data),
			}).done(function(result) {
				window.location.href="main";
			}).fail(function (error) {
				alert(error);
			});
		},
		showNextAsset : function() {
			assetIndex = assetIndex + 1;
			if (assetIndex == assetList.length) {
				assetIndex = 0;
			}
			var account = assetList[assetIndex].account.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			$('.bank').text(assetList[assetIndex].assetName);
			$('.assetAccount').text(account);
		},
		showAgoAsset : function() {
			assetIndex = assetIndex - 1;
			if (assetIndex == -1) {
				assetIndex = assetList.length - 1;
			}
			var account = assetList[assetIndex].account.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			$('.bank').text(assetList[assetIndex].assetName);
			$('.assetAccount').text(assetList[assetIndex].account);
		},
		showNextDebt : function() {
			debtIndex = debtIndex + 1;
			if (debtIndex == debtList.length) {
				debtIndex = 0;
			}
			var account = debtList[debtIndex].account.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			$('.bij').text(debtList[debtIndex].name);
			$('.debtAccount').text(account);
		},
		showAgoDebt : function() {
			debtIndex = debtIndex - 1;
			if (debtIndex == -1) {
				debtIndex = debtList.length - 1;
			}
			var account = debtList[debtIndex].account.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			$('.bij').text(debtList[debtIndex].name);
			$('.debtAccount').text(account);
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
                
    $('.madal_layer').hide();
    $('.modal').hide();   
    $('.modal2').hide();
});
