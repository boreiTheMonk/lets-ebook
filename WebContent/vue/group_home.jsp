<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>groupe</title>
<!--MAIN STYLESHEET-->
<link href="css/main-style/main.css" rel="stylesheet" type="text/css" />
<link href="css/mail-box/mailbox.css" rel="stylesheet" type="text/css" />
<!--POPUP ATTACHED FILEES-->
<link rel="stylesheet" href="css/popup/popup.css" type="text/css" media="screen" />
<script src="js/popup/popup.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
$(document).ready(function(){
//CLOSING POPUP
//Click the x event!
$(".popupContactClose").click(function(){
disablePopup();
});
$("#popupEditorClose").click(function(){
disableEditorPopup();
});
//Click out event!
$("#backgroundPopup").click(function(){
disablePopup();
});

//Click the button event!
});
</script>
<!--VERTICAL SCROLLER ATTACHED FILEES-->

<link rel="stylesheet" type="text/css" media="all" href="css/verticaly-scroller/jScrollPane.css" />
<!--<script type="text/javascript" src="testjs/jquery.js"></script>-->

<script type="text/javascript" src="js/verticaly-scroller/jScrollPane.js"></script>
<script type="text/javascript">

function confirm_delete_message (idMail,name,wrap){
	
	
	//$("#member_name").html(name);
	 centerPopup();
	 loadPopup();
	var p=$(wrap).parent().parent().parent().parent().parent().parent().parent();
	$('#button_delete').unbind('click');
	 $("#button_delete").click(function(){
		 if( submitOnce==0){
				
				submitOnce=1;
	 
			$.post('delete_mess_group',{ "id_mess_group": idMail ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
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

function add_msg(){
	var textStatus;
	var bod;
	body=$('textarea[name=message_wall]').val();
	//body=$('#message').text();
	//
	//alert("dd");
	if( submitOnce==0){
				
				submitOnce=1;
	aa= $.post('addMessage_group',{ "groupId":"<s:property value='groupId'/>","mg.body": body ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
	//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
	//	bod=data;
	//alert(data);
  $('#page2').prepend(data);
  disableEditorPopup();
reinitialiseScrollPane();
},"html");
//$('.wall').prepend(aa);
//alert(aa);
//alert(bod);
	}
}

var treat=0;
function reinitialiseScrollPane ()
{
	$('#page2').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});
}

function load_msg_sync(){
//treat is for waiting fist ajax before next
if(treat==0){
treat=1;
//event.stopImmediatePropagation();
load_msg();
}
//alert("message added");
//return false; //stop propagagation eg href #
}

function load_msg(){
	var textStatus;
	var bod;
	body=$('textarea[name=message]').text();
	//body=$('#message').text();
	//
	min= $('#page2').children().size(); 
	//min=0;
	aa= $.post('loadMessageGroup',{ "min": min,"max":5 ,"my_deco":"empty_inline","groupId":<s:property value='groupId'/>}, function(data,textStatus,http) {
	//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
	//	bod=data;
	
	//alert(data);
  $('#page2').append(data);
reinitialiseScrollPane();
//from left-menu.js load hover menu
reload_menu_hover();
//return false; //stop propagagation eg href #

treat=0;
},"html");

//$('.wall').prepend(aa);
//alert(aa);
//alert(bod);
}

$(function()
{
// this initialises the demo scollpanes on the page.
load_msg_sync();
$('#page2').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});

});




</script>

</head>
<body>
 <div id="content-area">
           <div class="border-heading-div">
             <div class="bg-heading-div">
              <div class="main-heading-div">Info</div>
              <div class="top-heading-icon"><img src="images/groupe-icon.png" width="38" height="24" alt="" border="0" class="margin-top-4" /></div>
              <div class="main-heading-txt"><span class="blue-txt">genre : <s:property value="showGroup.themes.iterator.next.name"/>  /   sujet :   <s:property value="showGroup.name"/></span></div>
              <div class="tabs-nav" ><a class="tab-select">Home</a><a href="showGroup?groupId=<s:property value='groupId' />" >Info</a><a style="visibility: hidden;" href="showRequest?groupId=<s:property value='groupId' />">Requete</a></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div ">
              <div class="content-tab-cover ">
                <div class="inner-heading-cover">
                  <div class="inner-heading1">
                    <div class="inner-heading">Wall</div>
                    <div class="inner-heading-icon"><img src="images/consultation-icon.png" alt="" width="30" height="21" border="0" class="margin-top2" /></div>
                  </div>
                  <div class="inner-heading-txt"><a href="#">afficher plus</a></div>
                  <div class="write-icon"><a href="javascript: centerEditorPopup(); loadEditorPopup();"><img src="images/comment-write-icon.gif" alt="" width="26" height="16" border="0" align="right" /></a></div>
                </div>
                <div class="tab-content">
                  <div class="holder osX">
                    <div id="page2" class="scroll-pane">
                 
                 
                      
           
                    
          
                      
                      
                    </div>
                  </div>
                </div>
              </div>
              <div class="content-tab-cover left">
                <div class="inner-border-heading-cover margin-top10">
                  <div class="inner-heading1">
                    <div class="inner-heading">membres</div>
                    <div class="inner-heading-icon"><img src="images/amis-icon.png" alt="" width="26" height="26" border="0" /></div>
                  </div>
                  <div class="inner-heading-txt"><a href="#" class="size-txt12"><s:property value="countMember" /> membres</a></div>
                </div>
                <div class="tab-content left">
                  <div class="amis-tab-cover">
                    <s:iterator value="groupMembers" >
                    <div class="amis-tab">  <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="avatarUrl"/>" alt="" border="0" class="img-border-gray" height="48px" width="48px" /> 
                    <div class="text_name_avatar" style="width: 50px;padding: 1px;word-wrap:break-word;"> <span class="ellipsis_text"> <s:property value="login"/></span></div>
                    </div>
                  </s:iterator> 
                  </div>
                  <div class="right"><a href="showListGroupMember?groupId=<s:property value='groupId'/>" class="right">plus</a></div>
                </div>
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

  
</div>
        
        <div id="popupEditor" class="popupbig_bg">
  <div class="popupbig-innearea">
    <div class="popup-innearea-box" >
      <textarea name="message_wall" rows="" cols="" ></textarea>
    </div>
    <div class="right">
      <input type="submit" name="button2" id="popupEditorClose" value="Fermer" class="btn-large-gray" />
      &nbsp;
      <input type="button" name="button3" id="popupEditorSubmit" onclick="add_msg()" value="Envoyer" class="btn-blue" />
    </div>
  </div>
</div>   
</body>
</html>