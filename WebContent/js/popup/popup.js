/***************************/
//@Author: Adrian "yEnS" Mato Gondelle
//@website: www.yensdesign.com
//@email: yensamg@gmail.com
//@license: Feel free to use it, but keep this credits please!					
/***************************/

//SETTING UP OUR POPUP
//0 means disabled; 1 means enabled;
var popupStatus = 0;
var submitOnce = 0;

//loading popup with jQuery magic!
function loadLoginPopup(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$('.popupbig-innearea').show();
		$('.popup_passlost-innearea').hide();
		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#popupLogin").fadeIn("slow");
		popupStatus = 1;
		
	//	$.scrollTo( 'div#popupEditor',{duration:200} );
	}
}

//disabling popup with jQuery magic!
function disableLoginPopup(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$("#backgroundPopup").fadeOut("slow");
		$("#popupLogin").fadeOut("slow", function() {
		    // Animation complete.
			popupStatus = 0;
			submitOnce = 0;
		});
		
	}
}

//centering popup
function centerLoginPopup(){
	//request data for centering
	
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupLogin").height();
	var popupWidth = $("#popupLogin").width();
	//centering
	$("#popupLogin").css({
		"position": "absolute",
		"top": $(window).scrollTop()+($(window).height()/2)-(popupHeight),
		"left": windowWidth/2-popupWidth/2
	});
	
	//only need force for IE6
	
	$("#backgroundPopup").css({
		"height": windowHeight
	});
   }
	function show_lost_passForm(){
		$('.popupbig-innearea').hide();
		$('.popup_passlost-innearea').show('fast');
	
   }
	



//CONTROLLING EDITOR EVENTS IN jQuery

//loading popup with jQuery magic!
function loadEditorPopup(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#popupEditor").fadeIn("slow");
		popupStatus = 1;
	//	$.scrollTo( 'div#popupEditor',{duration:200} );
	}
}

//disabling popup with jQuery magic!
function disableEditorPopup(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$("#backgroundPopup").fadeOut("slow");
		$("#popupEditor").fadeOut("slow", function() {
		    // Animation complete.
			popupStatus = 0;
			submitOnce = 0;
		});
	
	}
}

//centering popup
function centerEditorPopup(){
	//request data for centering
	
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupEditor").height();
	var popupWidth = $("#popupEditor").width();
	//centering
	$("#popupEditor").css({
		"position": "absolute",
		"top": $(window).scrollTop()+($(window).height()/2)-(popupHeight),
		"left": windowWidth/2-popupWidth/2
	});
	
	//only need force for IE6
	
	$("#backgroundPopup").css({
		"height": windowHeight
	});
   }
	function show_lost_passForm(){
		$('.popupbig-innearea').hide();
		$('.popup_passlost-innearea').show('fast');
	
   }

//CONTROLLING CONFIRM BOX EVENTS IN jQuery

//loading popup with jQuery magic!
function loadPopup(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#popupContact").fadeIn("slow");
		popupStatus = 1;
		//$.scrollTo( 'div#popupContact',{duration:200} );
	}
}

//disabling popup with jQuery magic!
function disablePopup(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$("#backgroundPopup").fadeOut("slow");
		$("#popupContact").fadeOut("slow", function() {
		    // Animation complete.
			popupStatus = 0;
			submitOnce = 0;
		});
		
	}
}

//centering popup
function centerPopup(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupContact").height();
	var popupWidth = $("#popupContact").width();
	//centering
	$("#popupContact").css({
		"position": "absolute",
		"top": $(window).scrollTop()+($(window).height()/2)-(popupHeight),
		"left": windowWidth/2-popupWidth/2
	});
	
	//only need force for IE6
	
	$("#backgroundPopup").css({
		"height": windowHeight
	});
	
}
	//loading popup with jQuery magic!
	function loadEventPopup(){
		//loads popup only if it is disabled
		if(popupStatus==0){
			$("#backgroundPopup").css({
				"opacity": "0.7"
			});
			$("#backgroundPopup").fadeIn("slow");
			$("#popupEvent").fadeIn("slow");
			popupStatus = 1;
			//$.scrollTo( 'div#popupContact',{duration:200} );
		}
	}

	//disabling popup with jQuery magic!
	function disableEventPopup(){
		//disables popup only if it is enabled
		if(popupStatus==1){
			$("#backgroundPopup").fadeOut("slow");
			$("#popupEvent").fadeOut("slow", function() {
			    // Animation complete.
				popupStatus = 0;
				submitOnce = 0;
			});
			
		}
	}

	//centering popup
	function centerEventPopup(){
		//request data for centering
		var windowWidth = document.documentElement.clientWidth;
		var windowHeight = document.documentElement.clientHeight;
		var popupHeight = $("#popupEvent").height();
		var popupWidth = $("#popupEvent").width();
		//centering
		$("#popupEvent").css({
			"position": "absolute",
			"top": $(window).scrollTop()+($(window).height()/2)-(popupHeight),
			"left": windowWidth/2-popupWidth/2
		});
		
		//only need force for IE6
		
		$("#backgroundPopup").css({
			"height": windowHeight
		});
	}

	
	
	
	//loading popup with jQuery magic!
	function loadAbusePopup(){
		//loads popup only if it is disabled
		if(popupStatus==0){
			$("#backgroundPopup").css({
				"opacity": "0.7"
			});
			$("#backgroundPopup").fadeIn("slow");
			$("#popupAbuse").fadeIn("slow");
			popupStatus = 1;
			//$.scrollTo( 'div#popupContact',{duration:200} );
		}
	}

	//disabling popup with jQuery magic!
	function disableAbusePopup(){
		//disables popup only if it is enabled
		if(popupStatus==1){
			$("#backgroundPopup").fadeOut("slow");
			$("#popupAbuse").fadeOut("slow", function() {
			    // Animation complete.
				popupStatus = 0;
				submitOnce = 0;
			});
			
		}
	}

	//centering popup
	function centerAbusePopup(){
		//request data for centering
		var windowWidth = document.documentElement.clientWidth;
		var windowHeight = document.documentElement.clientHeight;
		var popupHeight = $("#popupAbuse").height();
		var popupWidth = $("#popupAbuse").width();
		//centering
		$("#popupAbuse").css({
			"position": "absolute",
			"top": $(window).scrollTop()+($(window).height()/2)-(popupHeight),
			"left": windowWidth/2-popupWidth/2
		});
		
		//only need force for IE6
		
		$("#backgroundPopup").css({
			"height": windowHeight
		});
	}


	
	//loading popup with jQuery magic!
	function loadSupprPopup(){
		//loads popup only if it is disabled
		if(popupStatus==0){
			$("#backgroundPopup").css({
				"opacity": "0.7"
			});
			$("#backgroundPopup").fadeIn("slow");
			$("#popupSuppr").fadeIn("slow");
			popupStatus = 1;
			//$.scrollTo( 'div#popupContact',{duration:200} );
		}
	}

	//disabling popup with jQuery magic!
	function disableSupprPopup(){
		//disables popup only if it is enabled
		if(popupStatus==1){
			$("#backgroundPopup").fadeOut("slow");
			$("#popupSuppr").fadeOut("slow", function() {
			    // Animation complete.
				popupStatus = 0;
				submitOnce = 0;
			});
			
		}
	}

	//centering popup
	function centerSupprPopup(){
		//request data for centering
		var windowWidth = document.documentElement.clientWidth;
		var windowHeight = document.documentElement.clientHeight;
		var popupHeight = $("#popupSuppr").height();
		var popupWidth = $("#popupSuppr").width();
		//centering
		$("#popupSuppr").css({
			"position": "absolute",
			"top": $(window).scrollTop()+($(window).height()/2)-(popupHeight),
			"left": windowWidth/2-popupWidth/2
		});
		
		//only need force for IE6
		
		$("#backgroundPopup").css({
			"height": windowHeight
		});
		
	}

