    var treat=0;
$(document).ready(function() {
    $('#wall').jScrollPane();
  
	    
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
		body=$('textarea[name=message]').text();
		//body=$('#message').text();
		//

		aa= $.post('addMessage_book',{ "mm.body": body ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
		//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
		//	bod=data;
		//alert(data);
	  $('#wall').prepend(data);
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
//		$target.parents("form").find('textarea[name=resp_message]').text("ennnnnfinin");
	///alert($target.parents("form").find('textarea[name=resp_message]').val());
		aa= $.post('addResponseMessage_book',{ "rmm.body": body ,"my_deco":"empty_inline","id_message_parent":id_message}, function(data,textStatus,http) {
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
		aa= $.post('loadMessage_book',{ "min": min,"max":5 ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
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