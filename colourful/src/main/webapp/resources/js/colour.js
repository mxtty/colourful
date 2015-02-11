$(document).ready(function() { 
    
	
	$('.myButton').click(function(e) {
    	//按钮最接近的Form提交
//		var ul = $("base").attr("href");
//		alert (ul);
		$(this).closest('form').submit();
    });

	$('.js-item-increase').click(function(e) {
		$(this).next("a").removeClass("decrease--disabled");
		var $quantity = $(this).siblings('span').text();
		$(this).siblings('span').text(++$quantity);
		
		//var $jsItmePrice = $(this).parents(".item").find('.js-item-price').text().slice(1);

		var $unitPrice = $(this).siblings('.js-unit-price').val();

		var $subTotal = $quantity *$unitPrice;
		
		//alert($unitPrice + "X" + $quantity +"="+$subTotal);
		
		//alert($quantity *$unitPrice);
		$(this).parents(".item").find('.js-item-price').text("￥" + $subTotal.toFixed(2));
		
		//alert("quantity :"+ $quantity);
		$(this).siblings('.js-quantity').attr("value",$quantity);
	
	});

	
	
	$('.js-item-decrease').click(function(e) {
		var $quantity = $(this).siblings('span').text();

		if(1 == $quantity){
			return;
		}
		

		$(this).siblings('span').text(--$quantity);
		
		//var $jsItmePrice = $(this).parents(".item").find('.js-item-price').text().slice(1);

		var $unitPrice = $(this).siblings('.js-unit-price').val();

		var $subTotal = $quantity *$unitPrice;
		
		//alert($unitPrice + "X" + $quantity +"="+$subTotal);
		
		//alert($quantity *$unitPrice);
		$(this).parents(".item").find('.js-item-price').text("￥" + $subTotal.toFixed(2));
		
		//alert("quantity :"+ $quantity);
		$(this).siblings('.js-quantity').attr("value",$quantity);
		
		if(1 == $quantity){
			$(this).addClass("decrease--disabled");
		}
		
		
    });

	
});