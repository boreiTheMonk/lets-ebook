/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 //config

 var curvyCornersVerbose = false; 
    var curvyCornersNoAutoScan = false;
    var treat=0;
$(document).ready(function() {
    $('#wall').jScrollPane();
   
    //vars
	var conveyor = $(".content-conveyor", $("#sliderContent")),
	item = $(".item_book", $("#sliderContent"));
    var sliderOpts = {
	  max: (item.length * parseInt(item.css("width"))) - parseInt($(".viewer", $("#sliderContent")).css("width")),
      slide: function(e, ui) { 
        conveyor.css("left", "-" + ui.value + "px");
        
      }
    };
	
	//set length of conveyor
	conveyor.css("width", item.length * parseInt(item.css("width")));
			

    $("#slider").slider(sliderOpts);
    
    curvyCorners({
	      tl: {radius: 5},
	      tr: {radius: 5},
	      bl: {radius: 5},
	      br: {radius: 5},
	      antiAlias: true
	    },"#info_membre");
	    
	$("#send_message").bind('click', function(event) {
		//event.stopImmediatePropagation();
	add_msg();
	//alert("message added");
	return false; //stop propagagation eg href #
});





$("#load_message").bind('click', function(event) {
	//treat is for waiting fist ajax before next
	if(treat==0){
	treat=1;
	//event.stopImmediatePropagation();
	load_msg();
	}
	//alert("message added");
	return false; //stop propagagation eg href #
});

});

function reinitialiseScrollPane ()
				{
					$('#wall').jScrollPane();
				}


function add_msg(){
	var textStatus;
	var bod;
	body=$('textarea[name=message_wall]').val();
	//body=$('#message').text();
	//
	alert("dd");
	aa= $.post('addMessage',{ "mm.body": body ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
	//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
	//	bod=data;
	alert(data);
  $('#page2').prepend(data);
reinitialiseScrollPane();
},"html");
//$('.wall').prepend(aa);
//alert(aa);
//alert(bod);
}

function add_resp_msg(event){
	//var textStatus;
	//var bod;
	
	 var $target = $(event.target);
	id_message=$target.parents("form").find("input[name=my_id_message]").attr("value");
	body=$target.parents("form").find('textarea[name=resp_message]').val();
	//body=$('#message').text();
	//
//	$target.parents("form").find('textarea[name=resp_message]').text("ennnnnfinin");
///alert($target.parents("form").find('textarea[name=resp_message]').val());
	aa= $.post('addResponseMessage',{ "rmm.body": body ,"my_deco":"empty_inline","id_message_parent":id_message}, function(data,textStatus,http) {
	//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
	//	bod=data;
	alert(data);
 // $('#wall').prepend(data);
reinitialiseScrollPane();
},"html");

}

function load_msg(){
	var textStatus;
	var bod;
	body=$('textarea[name=message]').text();
	//body=$('#message').text();
	//
	min= $('#wall').children().size(); 
	//min=0;
	aa= $.post('loadMessage_home',{ "min": min,"max":5 ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
	//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
	//	bod=data;
	
	//alert(data);
  $('#wall').append(data);
reinitialiseScrollPane();
$(".send_resp_message").bind('click', function(event) {
		//event.stopImmediatePropagation();
	alert("toto");
	add_resp_msg(event);
	//alert("message added");
	return false; //stop propagagation eg href #
});


treat=0;
},"html");

//$('.wall').prepend(aa);
//alert(aa);
//alert(bod);
}
