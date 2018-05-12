<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>home</title>
       <%// <link rel="stylesheet" media="screen" type="text/css" title="Design" href="block.css" /> %>
		
		<script type="text/javascript" src="js/threeDots/jquery.ThreeDots.min.js"></script>

<script type="text/javascript" >
$(document).ready(function(){
//CLOSING POPUP
//Click the x event!
//is in layout member
$(".popupContactClose").click(function(){
disablePopup();
});


//Click the button event!
});
</script>


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
						
					 	$.post('delete_mess_member',{ "id_mess_member": idMail ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
							//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
							//	bod=data;
							 //alert("delete");
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
			//var doublesubmit = false;
			var textStatus;
			var bod;
			body=$('textarea[name=message_wall]').val();
			//body=$('#message').text();
			//
			//alert("dd");
			
			if( submitOnce==0){
				
			submitOnce=1;
			aa= $.post('addMessage',{ "mm.body": body ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
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
			aa= $.post('loadMessage_home',{ "min": min,"max":5 ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
			//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
			//	bod=data;
			
			//alert("aa"+data+"aa");
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
		
			$('.text_name_avatar').ThreeDots({max_rows:2, whole_word:false});
			$('.text_single_line_group').ThreeDots({max_rows:1, whole_word:false});

			//horizontal scroll
			  var conveyor=$(".horizontal-scroller");
		        var item = $(".horizontal-scroll-tab");
		      //  alert(item.length+" " + item.css("width")+" " + item.css("padding-left")+" "+item.length * (parseInt(item.css("width"))+66));
		        conveyor.css("width", item.length * (parseInt(item.css("width"))+parseInt(item.css("padding-left"))*2));
		        $('#hpane1').jScrollHorizontalPane({showArrows:true});
			
		});
		
		</script>
		
		
</head>
    

    <body>
     <div id="content-area">
          <div class="content-padd">
            <div class="content-area-border-div ">
              <div class="content-tab-cover left">
                <div class="inner-heading-cover">
                  <div class="inner-heading1">
                    <div class="inner-heading" style="font-size: 14px;font-weight: bold">Description</div>
                
                  </div>
                    <div class="inner-heading-txt" ><span class="size-txt12" ><s:property value="me.email"/></span></div>
                </div>
                <div class="tab-content left padding-top-zero">
                  <div class="padding-left15 left">
                    <div class="border-cover558">
                    
                     
                        <p><span style="font-weight: bold;">Description: </span><s:property value="me.description"/></p>
                        
                         <p><span style="font-weight: bold;">membres parrainés: </span><s:property value="referee"/></p>
                     </div>
                  </div>
                </div>
              </div>
              <div class="content-tab-cover ">
                <div class="inner-heading-cover">
                  <div class="inner-heading1">
                    <div class="inner-heading" style="font-size: 14px;font-weight: bold">Wall</div>
                    <div class="inner-heading-icon"><img src="images/consultation-icon.png" alt="" width="30" height="21" border="0" class="margin-top2" /></div>
                  </div>
                  <div class="inner-heading-txt"><a href="javascript:load_msg_sync();">Afficher plus</a></div>
                  <div class="write-icon"><a href="javascript: centerEditorPopup(); loadEditorPopup();"><img src="images/comment-write-icon.gif" alt="" width="26" height="16" border="0" align="right" /></a></div>
                </div>
                <div class="tab-content">
		            
		            
		                  <div class="holder osX">
		                    <div id="page2" class="scroll-pane">
		                    <s:iterator value="resMessage" var="msg">
		                    <s:date name="#msg.publishDate" format="dd/MM/yyyy à HH:mm" var="publish"/>
		                      <div class="vertical-scroll-tab" >
		                        <div class="v-scroll-tab-left"> <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#msg.memberByIdMemberSender.avatarUrl"/>" alt="" width="59" height="59" border="0" align="left" class="img-border-orange" /> </div>
		                        <div class="v-scroll-tab-right">
		                          <div class="right ver">
		                            <ul class="vertical">
		                              <li><a href="#"><img src="images/plus-icon.jpg" alt="" border="0"  /></a>
		                                <ul >
		                                  	 <s:if test="#msg.memberByIdMemberSender.idMember==#session[@constant.Application@USER_KEY].idMember || #msg.memberByIdMember.idMember==#session[@constant.Application@USER_KEY].idMember">

											<li><span class="cursor" onclick="confirm_delete_message('<s:property value='#msg.idMessage' />','<s:property value='name' default="message" />',this);" ><a >supprimer</a></span></li>
												
											</s:if>
		                                  <li class="no-border"><span class="cursor" onClick="confirm_abuse('<s:property value='#msg.idMessage' />')"><a >abus</a></span></li>
		                                </ul>
		                              </li>
		                            </ul>
		                          </div>
		                          <p><b><s:property value="#msg.memberByIdMemberSender.login"/> :</b><br />
		                           <s:property value="#msg.body"/> </p>
		                        </div>
		                        <div style="font-style: italic;text-align: right"> posté le : <s:property value="#publish"/></div >
		                      </div>
		                      </s:iterator>
		                       
		                    </div>
		                  </div>
                	
                </div>
              </div>
              <div class="content-tab-cover left">
                <div class="inner-border-heading-cover margin-top10">
                  <div class="inner-heading1">
                    <div class="inner-heading" style="font-size: 14px;font-weight: bold">Ouvrages</div>
                    <div class="inner-heading-icon"><img src="images/livres-icon.png" alt="" width="23" height="28" border="0" class="margin-top-2" /></div>
                  </div>
                  <div class="inner-heading-txt" style="visibility: hidden;"><span class="size-txt12">Xoxoxoxoxoxoxoxo xoxoxoxooxoxoxox xoxoxooxoxoxoxo</span></div>
                </div>
                <div class="tab-content left">
                  <div class="right margin-bottom10"><a href="show_MyBooks_full" class="right">plus</a></div>
                  <div class="holder-horizontal ohX left">
                    <div id="hpane1" class="scroll-pane-horizontal" >
                      <div class="horizontal-scroller">
                      	<s:iterator value="myBooks">
                      	 <s:url id="url_show_Book" action="showMyBook" >
                        <s:param name="bookId" value="idBook"/>
                     </s:url>
                      	
                        <div class="horizontal-scroll-tab"> <s:a href="%{url_show_Book}"><img src="/<s:property value='@constant.Application@FOLDER_BOOK_IMAGE_URL'/>/<s:property value='linkImage'/>" alt="" border="0" class="img-border-blue" width="83px" height="103px" /> </s:a>
						 <s:property value="title"/>	<br />
                          téléchargé <s:property value="nbDownload"/>	 fois<br />
                           </div>
                          </s:iterator>
                    
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="content-tab-cover left">
                <div class="inner-border-heading-cover margin-top10">
                  <div class="inner-heading1">
                    <div class="inner-heading" style="font-size: 14px;font-weight: bold">Mes amis</div>
                    <div class="inner-heading-icon"><img src="images/amis-icon.png" alt="" width="26" height="26" border="0" class="margin-top-3" /></div>
                  </div>
                </div>
                <div class="tab-content left">
                  <div class="amis-tab-cover">
                  

                  
                  
                  <s:iterator value="friendMembers" >
                  <s:url id="url_show_author" action="show_author" >
                        <s:param name="idMember" value="idMember"/>
                     </s:url>
                    <div class="amis-tab"><s:a href="%{url_show_author}"><img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="avatarUrl"/>" alt="" border="0" class="img-border-gray" height="48px" width="48px" /> </s:a>
                    <div class="text_name_avatar" style="width: 50px;padding: 1px;word-wrap:break-word;"> <span class="ellipsis_text"> <s:property value="login"/></span></div>
                    </div>
                  </s:iterator> 
                

                  </div>
                  <div class="right"><a href="showListFriends" class="right">plus</a></div>
                </div>
              </div>
              <div class="content-tab-cover left">
                <div class="inner-border-heading-cover">
                  <div class="inner-heading3">
                    <div class="inner-heading" style="font-size: 14px;font-weight: bold">Auteurs favoris</div>
                    <div class="inner-heading-icon"><img src="images/favorie-icon.png" alt="" width="41" height="26" border="0" class="margin-top1" /></div>
                  </div>
                  <div class="inner-heading-txt" style="visibility: hidden;"><span class="size-txt12" >classement???</span></div>
                </div>
                <div class="tab-content left">
                  <div class="amis-tab-cover">
                  
                  <s:iterator value="followMembers" >
                     <s:url id="url_show_author" action="show_author" >
                        <s:param name="idMember" value="idMember"/>
                     </s:url>
                    <div class="amis-tab"> <s:a href="%{url_show_author}"> <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="avatarUrl"/>" alt="" border="0" class="img-border-gray" height="48px" width="48px" /> </s:a>
                    <div class="text_name_avatar" style="width: 50px;padding: 1px;word-wrap:break-word;"> <span class="ellipsis_text"> <s:property value="login"/></span></div>
                    </div>
                  </s:iterator> 
                  
                  
                  </div>
                  <div class="right"><a href="showListFavouriteAuthors" class="right">plus</a></div>
                </div>
              </div>
              <div class="content-tab-cover left">
                <div class="inner-border-heading-cover">
                  <div class="inner-heading2">
                    <div class="inner-heading" style="font-size: 14px;font-weight: bold">Mes groupes</div>
                    <div class="inner-heading-icon"><img src="images/groupe-icon.png" alt="" width="38" height="24" border="0" class="margin-top-2" /></div>
                  </div>
                </div>
                <div class="tab-content left">
                  <div class="search-tab-cover left">
                     <s:iterator value="followGroups" >
                    <div class="search-tab">
                     <s:url id="show_group" action="showGroup" >
                        <s:param name="groupId" value="idGroup"/>
                     </s:url>
            
                      <table width="175" cellpadding="0" cellspacing="0" border="0">
                        <tr>
                          <td width="17" align="left" valign="top"><img src="images/blue-square.gif" alt="" border="0" /></td>
                          <td width="91" align="left" valign="top"><div class="text_single_line_group" >  <s:a href="%{show_group}"><b><span class="ellipsis_text">  <s:property value="name"/></span></b></s:a></div></td>
                          <td width="27" align="left" valign="top">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" valign="top">&nbsp;</td>
                          <td align="left" valign="top"><div class="text_single_line_group" > <span class="ellipsis_text">Type:  <s:property value="themes.iterator.next.name"/></span></div>
                            <div> <s:property value="members.size"/> membres</div></td>
                          
                        </tr>
                      </table>
                    </div>
                    </s:iterator>
                   

                  </div>
                  <div class="right margin-bottom10"><a href="show_MyJoinedGroup" class="right">plus</a></div>
                </div>
              </div>
                    <div class="content-tab-cover left">
                <div class="inner-border-heading-cover">
                  <div class="inner-heading2">
                    <div class="inner-heading" style="font-size: 14px;font-weight: bold">watchers</div>
                    <div class="inner-heading-icon"><img src="images/eye-icon.png" alt="" width="35" height="17" border="0" class="margin-top5" /></div>
                  </div>
                </div>
                <div class="tab-content left">
                  <div class="amis-tab-cover">
                    <s:iterator value="watcherMembers" >
                     <s:url id="url_show_author" action="show_author" >
                        <s:param name="idMember" value="idMember"/>
                     </s:url>
                    <div class="amis-tab"> <s:a href="%{url_show_author}"> <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="avatarUrl"/>" alt="" border="0" class="img-border-gray" height="48px" width="48px" /> </s:a>
                    <div class="text_name_avatar" style="width: 50px;padding: 1px;word-wrap:break-word;"> <span class="ellipsis_text"> <s:property value="login"/></span></div>
                    </div>
                  </s:iterator> 
                    
                   
                  </div>
                  <div class="right"><a href="showListWatchers" class="right">plus</a></div>
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
