<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8"?>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>livre</title>
<!--         <link rel="stylesheet" media="screen" type="text/css" title="Design" href="block.css" />-->
   <!--POPUP ATTACHED FILEES-->
<link rel="stylesheet" href="css/popup/popup.css" type="text/css" media="screen" />
<script src="js/popup/popup.js" type="text/javascript"></script>
<script type="text/javascript" >
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
<!--RATING STAR ATTACHED FILEES-->
<script src='js/rating-star/jquery.dimensions.js' type="text/javascript" language="javascript"></script>
<script src='js/rating-star/jquery.MetaData.js' type="text/javascript" language="javascript"></script>
<script src='js/rating-star/jquery.rating.big.js' type="text/javascript" language="javascript"></script>
<link href='css/rating-star/jquery.rating.big.css' type="text/css" rel="stylesheet"/>
<!--VERTICAL SCROLLER ATTACHED FILEES-->
<link rel="stylesheet" type="text/css" media="all" href="css/verticaly-scroller/demoStyles.css" />
<link rel="stylesheet" type="text/css" media="all" 
href="css/verticaly-scroller/jScrollPane.css" />
<!--<script type="text/javascript" src="testjs/jquery.js"></script>-->
<script type="text/javascript" src="js/verticaly-scroller/jquery_002.js"></script>
<script type="text/javascript" src="js/verticaly-scroller/jScrollPane.js"></script>
<script type="text/javascript">

$(function()
{
// this initialises the demo scollpanes on the page.

$('#page2').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});

$('.stara').rating({
	callback: function(value, link){
	//alert(value);
	if( submitOnce==0){
				
				submitOnce=1;
	aa= $.post('rateBookAjax',{ "rate":value,"bookId": "<s:property value='showBook.idBook' />" ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
		//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
		//	bod=data;
		alert(data);
		
	});
     
	submitOnce=0;
	}
	
	}
	});
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
		 
				$.post('delete_mess_book',{ "id_mess_book": idMail ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
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

 
		var treat=0;

		function add_msg(){
			var textStatus;
			var bod;
			body=$('textarea[name=message_wall]').val();
			//body=$('#message').text();
			//
			//alert("dd");
			if( submitOnce==0){
				
				submitOnce=1;
			aa= $.post('addMessage_book',{ "bookId":"<s:property value='bookId'/>","mb.body": body ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
			//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
			//	bod=data;
			//alert(data);
		  $('#page2').prepend(data);
		  disableEditorPopup();
		reinitialiseScrollPane();
		},"html");
			}
		//$('.wall').prepend(aa);
		//alert(aa);
		//alert(bod);
		}
		
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
			aa= $.post('loadMessagebook',{ "min": min,"max":5 ,"my_deco":"empty_inline","bookId":<s:property value='bookId'/>}, function(data,textStatus,http) {
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
		

	
		
		</script>
		  
   
    </head>
    <body>
     <div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Livre</div>
              <div class="top-heading-icon"><img src="images/livres-icon.png" width="23" height="28" alt="" border="0" class="margin-top-5" /></div>
              <div class="main-heading-txt"><em>Cat&eacute;gorie : <s:property value="showBook.category.name" />-<s:property value="showBook.category.category.name" /></em></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div">
              <div class="heading-consultation-page"><b><s:property value="showBook.title" /></b></div>
              <div class="Consultation-cover">
                 <div class="Consultation-left-div">
                                    <div class="description_book" style="height: 200px">
                  <p class="blue-txt size-txt12" ><b>description :</b></p>
                  <p class="size-txt12" style="height:160px;width:270px; overflow: auto;"> <s:property value="showBook.description" />   </p>
                  <p class="size-txt12"></p>
                  </div>
                  <p class="blue-txt"><em><s:property value="showBook.nbPages" /> pages</em></p>
                     <s:url id="url_show_author" action="show_author" >
                        <s:param name="idMember" value="showBook.member.idMember"/>
                     </s:url>
                  <p><span class="heading-blue14"><b>Auteur :</b></span> <span class="heading-blue16"><b><s:property value="author" /></b></span>
                 <br/><span class="heading-blue14" ><b>mis en ligne par :</b></span><span class="heading-blue16"><b><s:a href="%{url_show_author}"><s:property value="showBook.member.login" /></s:a></b></span>
                 </p>
                  <s:url id="url_edit_Book" action="showEditBook" >
			      	<s:param name="bookId" value="bookId"/>
			      </s:url>
			         <s:url id="url_sell_Book" action="info_sell_form" >
			      	<s:param name="bookId" value="bookId"/>
			      </s:url>
                  <div class="Consultation-btn-div"><s:a href="%{url_sell_Book}" cssClass="Consultation-btn1">Vendre</s:a> <s:a href="%{url_edit_Book}" cssClass="Consultation-btn1">Modifier</s:a> </div>
                </div>
                <!--
                
                <div class="Consultation-left-div">
                  <div class="description_book" style="height: 200px">
                  <p class="blue-txt size-txt12"><b>description :</b></p>
                  <p class="size-txt12"> <s:property value="showBook.description" /></p>
                  <p class="size-txt12"></p>
                  </div>
                  <span class="blue-txt"><em><strong><s:property value="showBook.nbPages" /> pages </strong></em></span>
         
                 <span class="heading-blue14"><b>auteur :</b></span><span class="heading-blue16"><b><a href="#"><s:property value="showBook.member.login" /></a></b></span></p>
                	 <div class="Consultation-btn-div"> <a href="#" class="Consultation-btn1">Editer</a> </div>
                </div>
                --><div class="Consultation-right-div">
                  <div class="consultation-profile-img"> <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="showBook.member.avatarUrlBig"/>" width="58px" alt="" border="0" class="img-border-blue" /> </div>
                  <div class="consultation-float-txt" style="display: none">xoxoxox xo xoxoxo</div>
                  <img src="/<s:property value='@constant.Application@FOLDER_BOOK_IMAGE_URL'/>/<s:property value='showBook.linkImageBig'/>" alt="" border="0" class="img-border-gray" width="208px" /> </div>
                <br />
				<div class="Consultation-discription-div">
                  <div class="size-txt12"><em style="visibility: hidden;">Xxoxoxo xo 1520000 xox<br />
                    nombre de telechargements : 35 fois </em>
                  <div class="mail-list-link-div">
                    <div class="rating-star-big">
                      <form name="api-readonly" id="api-readonly" action="">
                        <input type="radio" class="star {split:2}" name="api-readonly-test" value="1"/>
                        <input type="radio" class="star {split:2}" name="api-readonly-test" value="2"/>
                        <input type="radio" class="star {split:2}" name="api-readonly-test" value="3"/>
                        <input type="radio" class="star {split:2}" name="api-readonly-test" value="4"/>
                        <input type="radio" class="star {split:2}" name="api-readonly-test" value="5"/>
                        <input type="radio" class="star {split:2}" name="api-readonly-test" value="6"/>
                        <input type="radio" class="star {split:2}" name="api-readonly-test" value="7"/>
                        <input type="radio" class="star {split:2}" name="api-readonly-test" value="8"/>
                        <input type="radio" class="star {split:2}" name="api-readonly-test" value="9"/>
                        <input type="radio" class="star {split:2}" name="api-readonly-test" value="10"/>
                      </form>
                    </div>
                  </div>
                  <br />
                <!-- prix <span class="blue-txt">Xoxoxox</span> -->  
                  </div>
                </div>
              </div>
             
             <div class="Consultation-btn-div2"> 
              <%//<a href="/<s:property value="@constant.Application@FOLDER_BOOK_URL"/>/<s:property value="showBook.linkBook" />" class="Consultation-btn2"> %> 
              
               <a href="downloadBook?bookId=<s:property value="showBook.idBook" />" class="Consultation-btn2">
               
                télécharger<br />
                  le livre</a>
                  
                  <a style="visibility:hidden;" href="downloadBook?bookId=<s:property value="showBook.idBook" />" class="Consultation-btn3" >Acheter</a> </div>
              
              <div class="content-tab-cover">
                <div class="scrol-tab-icon-div">
                  <div class="left"><em>Commentaires :<a href="javascript:load_msg_sync();">Afficher plus</a></em></div>
                
                  <div class="right"><a href="javascript: centerEditorPopup(); loadEditorPopup();"> <img src="images/comment-write-icon.gif" alt="" width="26" height="16" border="0" align="right" /> </a></div>
                </div>
                <div class="tab-content">
                  <div class="right margin-bottom10">
                    <div class="holder osX">
                      <div id="page2" class="scroll-pane">
                       
                       <s:iterator value="resMessage" var="msg">
                        <s:date name="#msg.publishDate" format="dd/MM/yyyy à hh:mm" var="publish"/>
						<div class="vertical-scroll-tab">
							<div class="v-scroll-tab-left"><img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#msg.member.avatarUrl"/>" alt="" width="59" height="59" border="0" align="left" class="img-border-orange" /></div>
								<div class="v-scroll-tab-right">
									<div class="right ver">
									<ul class="vertical">
										<li><a href="#"><img src="images/plus-icon.jpg" alt="" border="0" /></a>
										<ul>
											 <s:if test="#msg.book.member.idMember==#session[@constant.Application@USER_KEY].idMember || #msg.member.idMember==#session[@constant.Application@USER_KEY].idMember">

											<li><span class="cursor" onclick="confirm_delete_message('<s:property value='#msg.idMessage' />','<s:property value='name' default="message" />',this);" ><a >supprimer</a></span></li>
												
											</s:if>
											<li class="no-border"><span class="cursor" onclick="confirm_abuse('<s:property value='#mg.idMessage' />')"><a >abus</a></span></li>
										</ul>
										</li>
									</ul>
									</div>
									<p><b><s:property value="#msg.member.login" /> :</b><br />
										<s:property value="#msg.body" /></p>
								</div>
								<div style="font-style: italic;text-align: right"> posté le : <s:property value="#publish"/></div >
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
