
	$(document).ready(function() {

	
		$("#div_menu_category ul li ").hover(function() {
			$(this).addClass("ui-state-hover ui-corner-all");
			}, function() {
			$(this).removeClass("ui-state-hover ui-corner-all");
			}
			
		);
			//$("li ul ").css({display: "none"}); // Opera Fix
		$("ul li").hover(function(){
			
					$(this).find('ul:first').css({visibility: "visible",display: "none"}).show();
		},function(){
		$(this).find('ul:first').css({visibility: "hidden"});
				});
		
$("#div_menu_category ul li ").addClass("theme_menu");
	});
	
	function reload_menu_hover(){
		$("ul li").unbind('mouseenter').unbind('mouseleave');

		$("ul li").hover(function(){
			
			$(this).find('ul:first').css({visibility: "visible",display: "none"}).show();
},function(){
$(this).find('ul:first').css({visibility: "hidden"});
		});
	}
