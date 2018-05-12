<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>email</title>
<!--MAIL BOX-->
<link href="css/main-style/main.css" rel="stylesheet" type="text/css" />
<link href="css/mail-box/mailbox.css" rel="stylesheet" type="text/css" />


<!--HIDE & SHOW SCRIPT-->
<script type="text/javascript">
//<![CDATA[
function showSlidingDiv(ctrl){
if($(ctrl).children('img').attr("src") == 'images/mail-image2.gif') {
$(ctrl).children('img').attr("src","images/mail-img3.gif");
$(ctrl).parent().parent().parent().children().attr("style","display:block;");
$('#page4').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});
}
else {
$(ctrl).children('img').attr("src","images/mail-image2.gif");
$(ctrl).parent().parent().next().attr("style","display:none;");
$('#page4').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});
}

}
//]]>
</script>


<script type="text/javascript">

function send_response_mail(divWrap,idMessage){
	//console.log(text);
	//alert(divWrap.find('textarea').val()+" "+idRequest);
	
				if( submitOnce==0){
				
				submitOnce=1;
	
	aa= $.post('addRespMessageEmailAjax',{ "idMessage": idMessage,"msg_body":divWrap.find('textarea').val() ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
		//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
		//	bod=data;
		
		//alert(data);


		 str= "  <div class='padding-left21'>";
		 str+="   <div class='inner-list-cover'>";
		 str+="   <div class='inner-list-left-div'><img src='/<s:property value='@constant.Application@FOLDER_MEMBER_IMAGE_URL'/>/<s:property value='#session[@constant.Application@USER_KEY].avatarUrl'/>' alt='' width='59' height='59' border='0' align='left' class='img-border-blue' /></div>";
		 str+="   <div class='inner-list-right-div'>";
		 str+="     <p><span class='size-txt12'><em><b><s:property value='#session[@constant.Application@USER_KEY].login' />  :</b></em></span><br />";
		 str+=divWrap.find('textarea').val();
		 str+="  </div>";
		 str+="</div>";
		 str+="  </div>";

	  

							  divWrap.before(str);
	//reinitialiseScrollPane();

	},"html");
		
	}
}

$(function()
{
// this initialises the demo scollpanes on the page.

$('#page4').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});

});

</script>
<script type="text/javascript">

var propa=0;
function confirm_delete_inbox (idMail,name,wrap){
	propa=idMail;
	
	//$("#member_name").html(name);
	 centerPopup();
	 loadPopup();
	var p=$(wrap).parent().parent().parent().parent().parent().parent().parent();
	$('#button_delete').unbind('click');
	 $("#button_delete").click(function(){
			
			if( submitOnce==0){
				
				submitOnce=1;
		 $.post('deleteMail',{ "idMessage": idMail ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
				//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
				//	bod=data;
				if(data!='0'){
					
					}
				else{
					
					}
				//console.log(wrap);
				//console.log(p);
				p.hide();	
				disablePopup();
			 // $('#page2').prepend(data);
			
			},"html");
			
		 }
			return false;
		 });
	
}

function confirm_delete_myMail (idMail,name,wrap){
	propa=idMail;
	
	//$("#member_name").html(name);
	 centerPopup();
	 loadPopup();
	var p=$(wrap).parent().parent().parent().parent().parent().parent().parent();
	$('#button_delete').unbind('click');
	 $("#button_delete").click(function(){
			
			if( submitOnce==0){
				
				submitOnce=1;
		    $.post('deleteMail',{ "idMessage": idMail ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
				//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
				//	bod=data;
				if(data!='0'){
					
					}
				else{
					
					}
				//console.log(wrap);
				//console.log(p);
				p.hide();	
				disablePopup();
			 // $('#page2').prepend(data);
			
			},"html");
		    }
				
			return false;
		 });
	
}

function onClickMail(){
	
	$(".mail-list-cover").unbind('click');
	 $(".mail-list-cover").click(function() {
			
			
			//prevent showing detail when click suppr
			
			
			idMessage=$(this).find("input").val();

			if(propa==idMessage)
				return false;
			
					$("#myMails").removeClass('mail-select-tab');
					$("#writeMail").removeClass('mail-select-tab');
					$("#sendMail").removeClass('mail-select-tab');
					$("#consultMail").addClass('mail-select-tab');
					$("#page_content").load("ajax_showDetailMail",{idMessage:idMessage ,my_deco:"empty_inline"});
			});


	  } 

	


function reload_inbox(){
	//min= $('#page_content').children().size(); 
	min = 0;
	$("#page_content").load("listPaginateInbox",{my_deco:"empty_inline",min:min,max:10},function() {
		 // alert('Load was performed.');
		 
		  //from left-menu.js load hover menu
		 reload_menu_hover();
	/*	  $(".mail-list-cover").click(function() {
				//alert("X");
				
				//prevent showing detail when click suppr
				
				
				idMessage=$(this).find("input").val();

				if(propa==idMessage)
					return false;
				
						$("#myMails").removeClass('mail-select-tab');
						$("#writeMail").removeClass('mail-select-tab');
						$("#sendMail").removeClass('mail-select-tab');
						$("#consultMail").addClass('mail-select-tab');
						$("#page_content").load("ajax_showDetailMail",{idMessage:idMessage ,my_deco:"empty_inline"});
				});*/
				onClickMail();


		  } );
	
}

function reload_sentMail(){
	//min= $('#page_content').children().size(); 
	min = 0;
	$("#page_content").load("listPaginateMyMails",{my_deco:"empty_inline",min:min,max:10},function() {
		 // alert('Load was performed.');
		 //from left-menu.js load hover menu
		 reload_menu_hover();
		//add onclick event for details
		  onClickMail();


		  } );

	  
	
}



function show_mail_form(){

	
	
	//min= $('#page_content').children().size(); 
	min = 0;
	$("#page_content").load("showMailForm",{my_deco:"empty_inline"},function() {
		 // alert('Load was performed.');

 $("#sendMailbut").click(function() {
	 var i =$("#subject").val();
  var j = $("#mailbody").val();
		 //alert(i);
		 //alert(j);
		 //alert($("#idMember").val());
		if( submitOnce==0){
				
				submitOnce=1;
			aa= $.post('send_mail',{ "mail.subject":i,"mail.body":j,"idMember":($("#idMember").val())}, function(data,textStatus,http) {
				$("#myMails").addClass('mail-select-tab');
				$("#writeMail").removeClass('mail-select-tab');
				$("#sendMail").removeClass('mail-select-tab');
				$("#consultMail").removeClass('mail-select-tab');
				reload_inbox();
			},"html");
			submitOnce=0;
		}
		});
		 // alert('Load was performed.');
	}
	);
}

var treat=0;
function reload_next_msg_mail_sync(){
	//treat is for waiting fist ajax before next
	if(treat==0){
	treat=1;
	//event.stopImmediatePropagation();
	reload_next_msg_mail();
	
	}
	//alert("message added");
	//return false; //stop propagagation eg href #
	}
function reload_next_msg_mail(){
	var textStatus;
	
	
	//body=$('#message').text();
	//
	min= $('.mail').children().size(); 
	//min=0;
	aa= $.post("listPaginateInbox",{my_deco:"empty_inline",min:min,max:10}, function(data,textStatus,http) {
	//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
	//	bod=data;
	
	//alert("aa"+data+"aa"+min);
  $('.mail').append(data);
 //add onclick event for details
  onClickMail();
//from left-menu.js load hover menu
	 reload_menu_hover();

//return false; //stop propagagation eg href #

treat=0;
},"html");

//$('.wall').prepend(aa);
//alert(aa);
//alert(bod);
}


function reload_next_msg_mail_sent_sync(){
	//treat is for waiting fist ajax before next
	if(treat==0){
	treat=1;
	//event.stopImmediatePropagation();
	reload_next_msg_mail_sent();
	}
	//alert("message added");
	//return false; //stop propagagation eg href #
	}
function reload_next_msg_mail_sent(){
	var textStatus;
	
	
	//body=$('#message').text();
	//
	min= $('.mail').children().size(); 
	//min=0;
	aa= $.post("listPaginateMyMails",{my_deco:"empty_inline",min:min,max:10}, function(data,textStatus,http) {
	//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
	//	bod=data;
	
	//alert("aa"+data+"aa"+min);
  $('.mail').append(data);

//add onclick event for details
  onClickMail();
  
//from left-menu.js load hover menu
	 reload_menu_hover();

//return false; //stop propagagation eg href #

treat=0;
},"html");

//$('.wall').prepend(aa);
//alert(aa);
//alert(bod);
}



$(document).ready(function() {
	reload_inbox();

	//CLOSING POPUP
	//Click the x event!
	$(".popupContactClose").click(function(){
		propa=0;
	disablePopup();
	});
	$(".popupEditorClose").click(function(){
	disableEditorPopup();
	});
	//Click out event!
	$(".backgroundPopup").click(function(){
	disablePopup();
	});
	
	$("#myMails").click(function() {
			$("#myMails").addClass('mail-select-tab');
			$("#writeMail").removeClass('mail-select-tab');
			$("#sendMail").removeClass('mail-select-tab');
			$("#consultMail").removeClass('mail-select-tab');
			reload_inbox();
	});
	$("#writeMail").click(function() {
			$("#myMails").removeClass('mail-select-tab');
			$("#consultMail").removeClass('mail-select-tab');
			$("#sendMail").removeClass('mail-select-tab');
			$("#writeMail").addClass('mail-select-tab');
			//$("#page_content").load("ajax_showWriteMail");
			show_mail_form();
	});
	/*	$("#page24").click(function() {
			$("#page22").removeClass('mail-select-tab');
			$("#page23").removeClass('mail-select-tab');
			$("#page25").removeClass('mail-select-tab');
			$("#page24").addClass('mail-select-tab');
			$("#page_content").load("24content.html");
	});*/
	$("#sendMail").click(function() {
		$("#sendMail").addClass('mail-select-tab');
		$("#writeMail").removeClass('mail-select-tab');
		$("#myMails").removeClass('mail-select-tab');
		$("#consultMail").removeClass('mail-select-tab');
		reload_sentMail();
	});
});



</script>
</head>
<body>



<div id="content-area">
          <div class="none-border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Mes Messages</div>
              <div class="top-heading-icon"><img src="images/mail-box-icon.png" width="30" height="21" alt="" border="0" class="margin-top1" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div">
              <div class="mail-box-cover">
                <div class="mail-box-left-div">
                  <ul>
                    <li><a  id="myMails" class="mail-select-tab">Bo&icirc;te de reception</a></li>
                    <li><a  id="writeMail">Ecrire</a></li>
                    <li><a  id="sendMail">Envoy&eacute;</a></li>
                    <li><a id="consultMail">Consultation</a></li>
                  </ul>
                </div>
                <div id="page_content"></div>
              </div>
            </div>
          </div>
        </div>
        
        
         <div id="popupContact" class="popupsmall_bg">
  	<div class="popupsmall-innearea">
    <p class="size-txt12"><span id="member_name"></span> <br />confirmer la suppression
             
      
      </p>
    <input type="button" name="button2"  value="fermer" class="pop-btn-small-gray popupContactClose" />
    <input type="button" name="button2" id="button_delete" value="ok" class="pop-btn-small-blue" />
  </div>
  <div class="response center" style="display: none">
      <p class="size-txt12"> 
          <span id="confirmTxt">livre inséré avec succès</span>
      </p>
  	<input type="button" name="button2"  value="fermer" class="pop-btn-small-gray" />
  </div>
  
</div>


        <div id="popupEditor" class="popupbig_bg">
  <div class="popupbig-innearea">
    <div class="popup-innearea-box" >
      <textarea cols="" rows=""></textarea>
    </div>
    <div class="right">
      <input type="button" name="button2" id="popupEditorClose" value="fermer" class="btn-large-gray" />
      &nbsp;
      <input type="button" name="button3" id="popupEditorSubmit" value="commenter" class="btn-blue" />
    </div>
  </div>
</div>


     




</body>
</html>