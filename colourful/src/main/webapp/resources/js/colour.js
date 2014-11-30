$(document).ready(function() { 
    
	
	$('.myButton').click(function(e) {
    	//按钮最接近的Form提交
//		var ul = $("base").attr("href");
//		alert (ul);
		$(this).closest('form').submit();
    });
});