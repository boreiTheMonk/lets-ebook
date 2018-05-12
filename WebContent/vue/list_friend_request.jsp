<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>liste d'auteur</title>
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
$("#popupContactClose").click(function(){
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


		
function accept_req(wrapper,name,idRequestF){
	//alert("accepte");
	//centerPopup(); loadPopup();
	
			if( submitOnce==0){
				
				submitOnce=1;	
	
	 $.post('confirm_friend',{"idRequestF":idRequestF, "okFriend":true ,"login_friend":name,"my_deco":"empty_inline"}, function(data,textStatus,http) {
		//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
		//	bod=data;
		//alert(data);
	if(data=='true')
		  wrapper.remove();
	else
		$("#confirmTxt").html("error dans le programme, contactez l'administrateur "); 

	$("#confirmTxt").html(name+ " est devenu votre ami");  
	centerPopup(); loadPopup();
	},"html");
	
	 }
		
}

function decline(wrapper,name,idRequestF){
	//alert("refuse");
	
				if( submitOnce==0){
				
				submitOnce=1;
	$.post('confirm_friend',{"idRequestF":idRequestF,"okFriend":false ,"login_friend":name ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
		//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
		//	bod=data;
		//alert(data);
	if(data==true)
		  wrapper.remove();

	$("#confirmTxt").html(name+ " refus&eacute, cela restera anonyme");  
	centerPopup(); loadPopup();
	},"html");
	
	}
}



</script>

</head>
<body>

<div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Amis en attente</div>
              <div class="top-heading-icon"><img src="images/amis-icon.png" width="26" height="26" alt="" border="0" class="margin-top-3" /></div>
              <div class="main-heading-right-txt" style="visibility: hidden"><span class="blue-txt size-txt12" >Xoxoxo : 235</span></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="content-tab-cover left">
                <div class="tab-content left">
                 
         				  
		                      <s:iterator value="reqF" var="req">
		                          <s:url id="url_show_author" action="show_author" >
                        			<s:param name="idMember" value="#req.memberByIdMember.idMember"/>
                    			 </s:url> 
		                       <div class="vertical-scroll-tab" >
		                        <div class="v-scroll-tab-left"> 
		                         <s:a href="%{url_show_author}">
		                        <s:if test="avatarUrl!=null">
		                        <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#req.memberByIdMember.avatarUrl"/>" alt="" width="59" height="59" border="0" align="left" class="img-border-orange" /> 
		                        </s:if>
		                        <s:else>
                    			 <img src="images/amis-img.gif" alt="" width="59" height="59" border="0" align="left" class="img-border-orange" /> 
                   				</s:else>
		                       	</s:a>
		                        </div>
		                        <div class="v-scroll-tab-right">
		                          
		                          <p><b><s:property value="#req.memberByIdMember.login" default="Login de la personne"/> :</b><br /></p>
		                           
		                           <div>
      								<input type="button" name="button3" id="popupEditorSubmit" onclick="accept_req($(this).parent().parent().parent(),'<s:property value="#req.memberByIdMember.login" />','<s:property value="#req.idRequestFriend" />')" value="Accepter" class="btn-blue" />&nbsp;
		                         	<input type="button" name="button2" id="popupEditorClose" onclick="decline($(this).parent().parent().parent(),'<s:property value="#req.memberByIdMember.login" />','<s:property value="#req.idRequestFriend" />')" value="Refuser" class="btn-large-gray" />
     								  </div>
		                        </div>
		                      </div>                 
                 			</s:iterator>
                 
            
                </div>
              </div>
            </div>
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
 <div id="popupContact" class="popupsmall_bg">
  <div class="popupsmall-innearea">
    <p class="size-txt12"> <span id="confirmTxt"></span><br />
      </p>
    <input type="button" name="button2" id="popupContactClose" value="Ok" class="pop-btn-small-blue" />
    
  </div>
</div>   
</body>
</html>