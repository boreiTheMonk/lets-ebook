
	$(document).ready(function() {
//	//$('.categorie_content').gradient({ topcolor: '#fa9492', bottomcolor: '#ab4143', horizontal:false, opacity:50});
//	//$('.toto').gradient({ rightcolor: '#ab4143', leftcolor: '#fa9492', horizontal:false, opacity: 80});
//	
//	curvyCorners({
//	      tl: {radius: 5},
//	      tr: {radius: 5},
//	      bl: {radius: 5},
//	      br: {radius: 5},
//	      antiAlias: true
//	    },".menu");
//	
//	    curvyCorners({
//	      tl: {radius: 0},
//	      tr: {radius: 0},
//	      bl: {radius: 5},
//	      br: {radius: 5},
//	      antiAlias: true
//	    },".menu_content");
//	
//	
//	
//	
//	//$(".toto").bg(5);
//	//$(".menu").bg(15);
//	//$(".categorie_content").bg(14, [['#eee', '#82d614', '#666'], ['#eee', '#aaa'], ['#aaa', '#ddd']]);
//	
//	//$(".toto2").bg(5);
//	
//	//$('.categorie_content').gradient({from: 'fa9492', to: 'ab4143', direction: 'horizontal', position: 'top', length: null});
//	//$('.menu').corner("15px");//.parent().css('padding-bottom', '5px')
//	//$('.categorie_content').corner("15px");
//	//$('.menu').corner("15px");
//	//var elt= document.getElementById("totou");
//	// var style = {'gradient-start-color': 0xfa9492,'gradient-end-color': 0xab4143,
//	//                     'border-radius': 15};
//	      //  OSGradient.applyGradient(style, elt);
//	        //$('.categorie_content').corner("15px");
//	
//	//$(".categorie_content").backgroundCanvas();
//	 //alert("dqsf");
//	larg= $(".menu_content").width();
//	haut= $(".menu_content").height();
//	 //$(".arriere").width(larg);
//	 $(".arriere").width(120);
//	 $(".arriere").height(haut);
//	 //alert("dqsf");
//	// top = $(".categorie_content").offset().top;
//	//  left = $(".categorie_content").offset().left;
//	// $(".arriere").offset({top: (top+5), left: (left-7)});
//	// //alert("arriere"+(top+5)+" " +(left-7) );
//	////alert("categorie_content"+top+" " +left );
//	
//	
//	//alert(offset.top);
//	
//	    curvyCorners({
//	      tl: {radius: 5},
//	      tr: {radius: 5},
//	      bl: {radius: 5},
//	      br: {radius: 5},
//	      antiAlias: true
//	    },".arriere");
//	
//	     offset = $(".menu_content").offset();
//	 //alert(offset.top);
//	 //alert(offset.left);
//	 $(".arriere").offset({top: (offset.top+10), left: (offset.left-10)});
//	 //$(".arriere").offset({top: (578), left: (5)});
//	 // $(".ar").offset({top: (578), left: (5)});
	
	
		$("#div_menu_category ul li ").hover(function() {
			$(this).addClass("ui-state-hover ui-corner-all");
			}, function() {
			$(this).removeClass("ui-state-hover ui-corner-all");
			}
			
		);
			//$("li ul ").css({display: "none"}); // Opera Fix
		$("ul li").hover(function(){
					$(this).find('ul:first').css({visibility: "visible",display: "none"}).show("slide",300);
		},function(){
		$(this).find('ul:first').css({visibility: "hidden"});
				});
		
$("#div_menu_category ul li ").addClass("theme_menu");
	});
	
