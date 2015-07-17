$(document).ready(function() { 
    

	$('.myButton').click(function(e) {
        e.preventDefault();
		//按钮最接近的Form提交
		var submitTarget = $(this).attr("href");

		//alert(submitTarget);
		if ("" != submitTarget) {
			$(this).closest('form').attr("action",submitTarget);
		}
		//		alert (ul);
		//alert($(this).closest('form').attr("action"));
		$(this).closest('form').submit();
    });
	//var $navId = $("#navId").attr("class");
	//alert($navId);
    $("#"+$("#navId").attr("class")).addClass("selected");


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

	
});