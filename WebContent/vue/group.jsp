<%@ taglib prefix="s" uri="/struts-tags"%>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        
       <%//  <link rel="stylesheet" media="screen" type="text/css" title="Design" href="<s:url value="/vue/block.css"/>" /> %>
        <title>groupe</title>
        <script type="text/javascript" >
        function insert_book(){
			
			var idBook=$("#idBook").val();
			//alert(idBook);
			if( submitOnce==0){
				
				submitOnce=1;
			$.post('add_book_group',{ "groupId":<s:property value='groupId' />,"bookId": idBook ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
				//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
				//	bod=data;
				if(data!='0'){
					$("#confirmTxt").html("livre déja inséré");
					}
				else{
					$("#confirmTxt").html("livre inséré avec succès");
					}
				
				$(".response").show();
	        	$(".popupsmall-innearea").hide();		
			 // $('#page2').prepend(data);
			
			},"html");

			}
            }
        
        $(document).ready(function() {
        var conveyor=$(".horizontal-scroller");
        var item = $(".horizontal-scroll-tab");
       // alert(item.length+" " + item.css("width")+" " + item.css("padding-left")+" "+item.length * (parseInt(item.css("width"))+66));
        conveyor.css("width", item.length * (parseInt(item.css("width"))+parseInt(item.css("padding-left"))*2));
        $('#hpane1').jScrollHorizontalPane({showArrows:true});

        /*$('.scroll-to').bind('click',function(){
        $('#hpane1')[0].scrollTo(75);
        return false;
        });*/
    	$("#popupEventClose").click(function(){
			disableEventPopup();
			 location.reload();
			});
        $(".pop-btn-small-gray").click(function(){
        	disablePopup();
        	$(".response").hide();
        	$(".popupsmall-innearea").show();
        	});
         });

        function followGroup(){
        	
			if( submitOnce==0){
							
			submitOnce=1;
			aa= $.post('addFollowGroup',{ "groupId":<s:property value='groupId'/>}, function(data,textStatus,http) {
				//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
				//	bod=data;
				
				//alert(data);
				
				var msg="Félicitation, vous avez rejoint ce groupe<br /> ";
				$("#msgContent").html(msg);
				centerEventPopup();
				 loadEventPopup();
			$("#butFollow").hide();
			//return false; //stop propagagation eg href #

			treat=1;
			},"html");
			}
			}
         </script>
        

    </head>
    <body>
      <div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Info</div>
              <div class="top-heading-icon"><img src="images/groupe-icon.png" width="38" height="24" alt="" border="0" class="margin-top-4" /></div>
              <div class="main-heading-txt"><span class="blue-txt">genre : <s:property value="showGroup.themes.iterator.next.name"/>  /   sujet :   <s:property value="showGroup.name"/></span></div>
              <div class="tabs-nav">
              
                     <s:if test="group_ok">
               <a href="show_group_home?groupId=<s:property value='groupId' />">Home</a>
               </s:if>
                  <s:else>
               
               </s:else>
              <a href="#" class="tab-select">Info</a>
        
            
              <%// <a href="showRequest?groupId=<s:property value='groupId' />">Requete</a>%>
              </div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="content-tab-cover left">
                <div class="inner-heading-cover">
                  <div class="inner-heading1">
                    <div class="inner-heading">Description</div>
                  </div>
                  <div class="write-icon" style="width: 100px"> 
                  <s:if test="!group_ok">
                  <input type="button" id="butFollow" class="btn-large-gray" value="joindre" onclick="followGroup()"/>
                  </s:if>
                  <%// <a href="javascript: centerEditorPopup(); loadEditorPopup();"><img src="images/comment-write-icon.gif" alt="" width="26" height="16" border="0" align="right" /></a>%>
                  
                  </div>
                </div>
                <div class="tab-content left">
                  <div class="padding-left15 left">
                    <div class="border-cover558">
                   
                      <s:property value="showGroup.description"/></div>
                  </div>
                </div>
              </div>
              <div class="content-tab-cover left">
                <div class="inner-border-heading-cover left">
                  <div class="inner-heading-cover">
                    <div class="inner-heading1" style="width: 150px">
                      <div class="inner-heading">Livres du groupe </div>
                      <div class="inner-heading-icon"><img src="images/livres-icon.png" alt="" width="23" height="28" border="0" /></div>
                    </div>
                    <div class="inner-heading-txt size-txt12">nombre de livres : <s:property value='nbBooks'/> </div>
                    
                    <s:if test="group_ok">
                    <div class="padding10  right">
                      <div class="big-plus-text">ajouter un livre&nbsp;&nbsp;</div>
                      <ul id="big-plus-sign-menu" class="vertical">
                        <li><a href="javascript:centerPopup(); loadPopup();"><img src="images/big-plus-sign.gif"  alt="" border="0" align="right" /></a>
                         <!--   <ul style="display: none;">
                            <li ><a href="#">xoxoxo</a></li>
                            <li class="no-border"><a href="#">xoxoxo</a></li>
                          </ul>-->
                        </li>
                      </ul>
                    </div>
                    </s:if>
                    
                  </div>
                </div>
                <div class="tab-content left">
                  <div class="right margin-bottom10"><a href="show_GroupBooks_full?groupId=<s:property value='groupId' />" class="right">plus</a></div>
                  <div class="holder-horizontal ohX left">
                    <div id="hpane1" class="scroll-pane-horizontal" >
                      <div class="horizontal-scroller">
                      <s:iterator value="books">
                      <s:url id="url_show_Book" action="showBook" >
       				<s:param name="bookId" value="idBook"/>
    					</s:url>
                      
                           <div class="horizontal-scroll-tab"> 
                           <s:a href="%{url_show_Book}"><img src="/<s:property value='@constant.Application@FOLDER_BOOK_IMAGE_URL'/>/<s:property value='linkImage'/>" alt="" border="0" class="img-border-blue" width="83px" height="103px" /> </s:a>
						 <s:property value="title"/>	<br />
                          téléchargé <s:property value="nbDownload"/> fois<br />
                          de <s:property value="member.login"/> </div>
                        </s:iterator>
                    <!--      <div class="horizontal-scroll-tab" style="display: none;"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-blue" /> Xoxoxox<br />
                          xox<br />
                          xoxoxoxoé </div>-->
                  
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              
               <s:if test="group_ok">
               <div class="content-tab-cover left">
                <div class="inner-border-heading-cover left">
                  <div class="inner-heading-cover">
                    <div class="inner-heading1" style="width: 150px">
                      <div class="inner-heading">Mes livres importés </div>
                      <div class="inner-heading-icon"><img src="images/livres-icon.png" alt="" width="23" height="28" border="0" /></div>
                    </div>
                    <div class="inner-heading-txt size-txt12">nombre de livres : <s:property value='nbBooks'/> </div>
                    
                   
                    <div class="padding10  right">
              
                    </div>
                    
                    
                  </div>
                </div>
                <div class="tab-content left">
                  <div class="right margin-bottom10"><a href="show_MyGroupBooks_full?groupId=<s:property value='groupId' />" class="right">plus</a></div>
                  <div class="holder-horizontal ohX left">
                    <div id="hpane1" class="scroll-pane-horizontal" >
                      <div class="horizontal-scroller">
                      <s:iterator value="myBooks">
                           <div class="horizontal-scroll-tab"> <img src="/<s:property value='@constant.Application@FOLDER_BOOK_IMAGE_URL'/>/<s:property value='linkImage'/>" alt="" border="0" class="img-border-blue" width="83px" height="103px" /> 
						 <s:property value="title"/>	<br />
                          téléchargé <s:property value="nbDownload"/> fois<br />
                          de <s:property value="member.login"/> </div>
                        </s:iterator>
                    <!--      <div class="horizontal-scroll-tab" style="display: none;"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-blue" /> Xoxoxox<br />
                          xox<br />
                          xoxoxoxoé </div>-->
                  
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              </s:if>
              
              
              
            </div>
          </div>
        </div>
          <div id="popupContact" class="popupsmall_bg">
  	<div class="popupsmall-innearea">
    <p class="size-txt12"> Veuillez choisir le livre à insérer<br />
                <select name="idBook"  id="idBook">
                   <s:iterator value="ownbook" var="b" >
					<option value="<s:property value="idBook" />"><s:property value="title" /></option>		
				   </s:iterator>
		        </select>
      
      </p>
    <input type="button" name="button2"  value="fermer" class="pop-btn-small-gray" />
    <input type="button" name="button2" onclick="insert_book()" value="ok" class="pop-btn-small-blue" />
  </div>
  <div class="response center" style="display: none">
      <p class="size-txt12"> 
          <span id="confirmTxt">livre inséré avec succès</span>
      </p>
  	<input type="button" name="button2"  value="fermer" class="pop-btn-small-gray" />
  </div>
  
</div>

<div id="popupEvent" class="popupsmall_bg">
  <div class="popupsmall-innearea">
    <p class="size-txt12" id="msgContent">groupe inscrit!! </p>

    <input type="button" name="button3" id="popupEventClose" value="fermer" class="pop-btn-small-blue" />
  </div>
</div>
    </body>
</html>
