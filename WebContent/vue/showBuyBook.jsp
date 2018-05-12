<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>home</title>
       <%// <link rel="stylesheet" media="screen" type="text/css" title="Design" href="block.css" /> %>
		
		<script type="text/javascript" src="js/threeDots/jquery.ThreeDots.min.js"></script>
		<script type="text/javascript">
		function add_msg(){
			//var doublesubmit = false;
			var textStatus;
			var bod;
			body=$('textarea[name=message_wall]').val();
			//body=$('#message').text();
			//
			//alert("dd");
			aa= $.post('addMessage',{ "mm.body": body ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
			//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
			//	bod=data;
			//alert(data);
		  $('#page2').prepend(data);
		  disableEditorPopup();
		  $('textarea[name=message_wall]').val("");
		reinitialiseScrollPane();
		},"html");
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
          <div class="none-border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Livres achetés <s:property value='me.login'/></div>
              <div class="top-heading-icon"><img src="images/inscription-icon.png" width="19" height="30" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>



<div class="content-padd">
<div class="content-area-border-div left">

<s:iterator value="myBuyedBook" var="bookIt">
 <s:date name="#bookIt.orderCustomer.dateOrder" format="dd/MM/yyyy" var="buyDate"/>
<div class="vertical-scroll-tab" style="overflow: hidden; margin: 15px;">
	<div class="v-scroll-tab-left" style="float: left;">
		<img src="/<s:property value='@constant.Application@FOLDER_BOOK_IMAGE_URL'/>/<s:property value='#bookIt.linkImageOrder'/>"
			alt="" width="83" height="103" border="0" align="left"
			class="img-border-orange" />
	</div>
	<div class="v-scroll-tab-right">
	
	<p>
		<b>date:</b> <s:property value="%{#buyDate}" /><br />
		titre : <s:property
		value="#bookIt.name" /><br />
	
	auteur : <s:property value="#bookIt.orderCustomer.member.login" /> <br />
	</p>
	
	<a target="_blank" href="showInvoice?refOrder=<s:property value="#bookIt.orderCustomer.refOrder" />&my_deco=empty_inline" class="btn-large-gray_link" >Facture</a> 
	<a href="downloadBuyBook?idOrderBook=<s:property value="#bookIt.idOrder" />" class="btn-large-blue_link" > Telecharger </a></div>
</div>

</s:iterator>



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
    </body>
</html>
