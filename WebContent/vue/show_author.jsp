<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>lets-ebook Consultation auteur</title>
       <%// <link rel="stylesheet" media="screen" type="text/css" title="Design" href="block.css" /> %>
		
		<script type="text/javascript" src="js/threeDots/jquery.ThreeDots.min.js"></script>
		<script type="text/javascript" >
$(document).ready(function(){
//CLOSING POPUP
//Click the x event!
//is in layout member
$(".popupSupprClose").click(function(){
disableSupprPopup();
});


//Click the button event!
});
</script>
		
		<script type="text/javascript">
		function confirm_delete_message (idMail,name,wrap){
			
			
			//$("#member_name").html(name);
			 centerSupprPopup();
			 loadSupprPopup();
			var p=$(wrap).parent().parent().parent().parent().parent().parent().parent();
			$('#button_delete').unbind('click');
			 $("#button_delete").click(function(){
				if( submitOnce==0){
						
				submitOnce=1;	
				 
					  $.post('delete_mess_member',{ "id_mess_member": idMail ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
							//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
							//	bod=data;
							if(data!='0'){
								
								}
							else{
								
								}
							//console.log(wrap);
							//console.log(p);
							p.hide();	
							disableSupprPopup();
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
		//	alert("dd");
			
		if( submitOnce==0){
				
			submitOnce=1;
			
			aa= $.post('addMessage_auhor',{ 'login':'<s:property value="me.login"/>',"mm.body": body ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
			//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
			//	bod=data;
			//alert(data);
		  $('#page2').prepend(data);
		  disableEditorPopup();
		  $('textarea[name=message_wall]').val("");
		reinitialiseScrollPane();
		},"html");
			
		}	
			
			
		//$('.wall').prepend(aa);
		//alert(aa);
		//alert(bod);
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
	
				
					
			aa= $.post('loadMessage_member',{'login':'<s:property value="me.login"/>', "min": min,"max":5 ,"my_deco":"empty_inline","idMember":<s:property value='idMember'/>}, function(data,textStatus,http) {
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
		$("#popupContactClose").click(function(){
			disablePopup();
			});
		$("#popupEditorClose").click(function(){
			$('textarea[name=message_wall]').val("");
			disableEditorPopup();
			});
			$('.text_name_avatar').ThreeDots({max_rows:2, whole_word:false});
			$('.text_single_line_group').ThreeDots({max_rows:1, whole_word:false});

			//horizontal scroll
			  var conveyor=$(".horizontal-scroller");
		        var item = $(".horizontal-scroll-tab");
		      //  alert(item.length+" " + item.css("width")+" " + item.css("padding-left")+" "+item.length * (parseInt(item.css("width"))+66));
		        conveyor.css("width", item.length * (parseInt(item.css("width"))+parseInt(item.css("padding-left"))*2));
		        $('#hpane1').jScrollHorizontalPane({showArrows:true});
		});

		function sendFriendRequest(){
			
			if( submitOnce==0){
				
				submitOnce=1;
			aa= $.post('sendFriendRequest',{ "idMember":<s:property value='idMember'/>}, function(data,textStatus,http) {
				//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
				//	bod=data;
				
				//alert(data);
				
				var msg="un message a été envoyé<br />à <s:property value='me.login'/>";
				$("#msgContent").html(msg);
				centerPopup(); loadPopup();
			

				//return false; stop propagagation eg href #

			treat=1;
			},"html");
		
			}	
				
			}

		function sendFollowRequest(){
		
			if( submitOnce==0){
				
				submitOnce=1;
			
			aa= $.post('sendFollowRequest',{ "idMember":<s:property value='idMember'/>}, function(data,textStatus,http) {
				//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
				//	bod=data;
				
				//alert(data);
				
				var msg="vous suivez la progression de <br /> <s:property value='me.login'/>";
				$("#msgContent").html(msg);
				centerPopup(); loadPopup();
			
			//return false; //stop propagagation eg href #

			treat=1;
			},"html");
				
			}
			
			}
		
		</script>
		
		
</head>
    

    <body>

     <div id="content-area">
           <div class="none-border-heading-div">
            <div class="heading-poup-div">
              <div class="mlmenu menuA blindv blackwhite arrow delay inaccesible ">
                <ul id="plus-sign-right-menu">
                  <li>
                  <s:if test="me.avatarUrl!=null">
                  <a href="#"><img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="me.avatarUrl"/>" alt="" border="0" class="img-border-blue" height="62px" width="62px" /></a>
                    </s:if>
                     <s:else>
                   <a href="#"><img src="images/profile-img2.jpg" alt="" border="0" class="img-border-blue"  height="62px" width="62px"/></a>
                   </s:else>
                    
                    <s:if test="me.idMember!=#session[@constant.Application@USER_KEY].idMember">
                    
                    <ul id="heading-dropdown">
                    <s:if test="!friendSent_ok">
                      <li ><a href="javascript:sendFriendRequest()">ajout ami</a></li>
                   	</s:if >
                   	<s:else>
                   	<li style="display: none;"><a >attente ami..</a></li>
                   	</s:else>
                     <s:if test="!follow_ok">
                      <li ><a href="javascript:sendFollowRequest()">favoris</a></li>
                   	</s:if >
                   	<s:else>
                   	<li style="display: none;"><a >attente ami..</a></li>
                   	</s:else>
                   <% //showWriteMailAuthorForm?idMember=<s:property value="me.idMember"/> %>
                      <li><a href="showWriteMailAuthorForm?idMember=<s:property value="me.idMember"/>">lui écrire</a></li>
                        
                    </ul>
                    
                    </s:if>
                    
                  </li>
                </ul>
              </div>
            </div>
            <div class="bg-heading-div">
              <div class="main-heading-div"><s:property value="me.login"/> : </div>
              <div class="main-heading-txt"><span class="blue-txt">Classe : <s:property value="me.levelMembers.iterator.next.classMember.name" default="non spécifié"/>   /   Titre :  <s:property value="me.levelMembers.iterator.next.nameJob" default="non spécifié"/>   /     <s:property value='nbBooks'/> oeuvres publi&eacute;es</span></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div ">
              <div class="content-tab-cover left">
                <div class="inner-heading-cover">
                  <div class="inner-heading1">
                    <div class="inner-heading">Description</div>
                  </div>
                </div>
                <div class="tab-content left padding-top-zero">
                  <div class="padding-left15 left">
                    <div class="border-cover558">
                      <p><s:property value="me.description" default="pas encore renseigné"/></p>
                  
                     </div>
                  </div>
                </div>
              </div>
             
              <s:if test="friend_ok">
              
              <div class="content-tab-cover ">
                <div class="inner-heading-cover">
                  <div class="inner-heading1">
                    <div class="inner-heading">Wall</div>
                    <div class="inner-heading-icon"><img src="images/consultation-icon.png" alt="" width="30" height="21" border="0" class="margin-top2" /></div>
                  </div>
                  <div class="inner-heading-txt"><a href="javascript:load_msg_sync();">Afficher plus</a></div>
                  <div class="write-icon"><a href="javascript: centerEditorPopup(); loadEditorPopup();"><img src="images/comment-write-icon.gif" alt="" width="26" height="16" border="0" align="right" /></a></div>
                </div>
                <div class="tab-content">
		            
		            
		                  <div class="holder osX">
		                    <div id="page2" class="scroll-pane">

		                       
		                    </div>
		                  </div>
                	
                </div>
              </div>
              
              </s:if>
              <div class="content-tab-cover left">
                <div class="inner-border-heading-cover margin-top10">
                  <div class="inner-heading1">
                    <div class="inner-heading">Ouvrages</div>
                    <div class="inner-heading-icon"><img src="images/livres-icon.png" alt="" width="23" height="28" border="0" class="margin-top-2" /></div>
                  </div>
                  
                </div>
                <div class="tab-content left">
                  <div class="right margin-bottom10"><a href="show_AuthorBooks_full?idMember=<s:property value='idMember'/>" class="right">plus</a></div>
                  <div class="holder-horizontal ohX left">
                    <div id="hpane1" class="scroll-pane-horizontal" >
                      <div class="horizontal-scroller">
                      	<s:iterator value="resBooks">
                      	 <s:url id="url_show_Book" action="showBook" >
                        <s:param name="bookId" value="idBook"/>
                     </s:url>
                      	
                        <div class="horizontal-scroll-tab"> <s:a href="%{url_show_Book}">
                        
                         <s:if test="linkImage!=null">
                        <img src="/<s:property value='@constant.Application@FOLDER_BOOK_IMAGE_URL'/>/<s:property value='linkImage'/>" alt="" border="0" class="img-border-blue" width="83px" height="103px" /> 
						 </s:if>
							<s:else>
							<img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-blue" width="83px" height="103px" /> 
							
							</s:else>
						 </s:a>
						 <s:property value="title"/>	<br />
                          téléchargé <s:property value="nbDownload"/>	 fois<br />
                           </div>
                          </s:iterator>
                
                      </div>
                    </div>
                    
                  </div>
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
      <input type="button" name="button2" id="popupEditorClose" value="Fermer" class="btn-large-gray" />
      &nbsp;
      <input type="button" name="button3" id="popupEditorSubmit" onclick="add_msg()" value="Envoyer" class="btn-blue" />
    </div>
  </div>
</div>   

<div id="popupSuppr" class="popupsmall_bg">
  	<div class="popupsmall-innearea">
  	
  	
    <p class="size-txt12"><span id="member_name"></span> <br />confirmer la suppression
             
      
      </p>
    <input type="button" name="button2"  value="fermer" class="pop-btn-small-gray popupSupprClose" />
    <input type="button" name="button2" id="button_delete" value="ok" class="pop-btn-small-blue" />
  </div>

  
</div>
        

<div id="popupContact" class="popupsmall_bg">
  <div class="popupsmall-innearea">
    <p class="size-txt12" id="msgContent"> </p>

    <input type="button" name="button3" id="popupContactClose" value="fermer" class="pop-btn-small-blue" />
  </div>
</div>
    </body>
</html>
