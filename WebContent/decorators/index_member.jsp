<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<% // <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"  />%>
<title><decorator:title default="DEFAULT TITLE"/></title>
<script type="text/javascript" src="js/jquery.js"></script>
<!--MAIN STYLESHEET-->
<link href="css/main-style/main.css" rel="stylesheet" type="text/css" />
<!--TOP NAV ATTACHED FILES-->
<!--[if lte IE 7]>
<style type="text/css">html .jquerycssmenu{height: 1%;} /*Holly Hack for IE7 and below*/</style>
<![endif]-->
<!--<script type="text/javascript" src="js/menu/jquery.min.js"></script>-->
<!--<script type="text/javascript" src="js/menu/jquerycssmenu.js"></script>-->
<!--LEFT NAV ATTACHED FILES-->
<script type="text/javascript" src="js/menu/left-menu.js"></script>
<!--NEWS TIKCER ATTACHED FILEES-->
<script type="text/javascript" src="js/news-ticker/jquery.li-scroller.1.0.js"></script>
<link href="css/news-ticker/jquery.li-scroller.1.0.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
$(function(){
$("ul#ticker01").liScroll({travelocity: 0.05});
$("ul#ticker01").css("visibility","visible");
});
</script>
<!--PROGRESS BAR ATTACHED FILES-->
<script type="text/javascript" src="js/progress-bar/jquery.progressbar.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
$("#pb1").progressBar(<s:property value='#session[@constant.Application@USER_KEY].levelMembers.iterator.next.level_1'/>, {showText: false, width: 65, height: 6, boxImage:'images/progressbar.gif' , barImage: 'images/progressbg_blue.gif'});
});
</script>
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
<link rel="stylesheet" type="text/css" media="all" href="css/verticaly-scroller/demoStyles.css" />
<link rel="stylesheet" type="text/css" media="all" 
href="css/verticaly-scroller/jScrollPane.css" />
<!--<script type="text/javascript" src="testjs/jquery.js"></script>-->
<!--<script type="text/javascript" src="js/verticaly-scroller/jquery_002.js"></script>-->
<script type="text/javascript" src="js/verticaly-scroller/jScrollPane.js"></script>
<script type="text/javascript">

$(function()
{
// this initialises the VERTICAL scollpanes on the page.

$('#page2').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});
//$('.jquerycssmenu ul li.inbox-simple a').css('padding-right','25px');
});
</script>
<script type="text/javascript" src="js/scroller/jquery_002.js"></script>
<!--HORIZONTAL SCROLLER ATTACHED FILEES-->
<link rel="stylesheet" type="text/css" media="all" href="css/horizontal-scroller/jScrollHorizontalPane.css" />
<script type="text/javascript" src="js/horizontal-scroller/jScrollHorizontalPane.js"></script>
<script type="text/javascript">
var idMsgAbuse=0;
$(function() {
var originalSizes = new Array();

// this initialises the HORIZONTAL scollpanes on the page.
$('#hpane1').jScrollHorizontalPane({showArrows:true});

//bug related to combine  jScrollHorizontalPane and jScrollPane without it  #page2 resize when rsizing windows
$('#page2').jScrollHorizontalPane({ resize: false});
/*$('.scroll-to').bind('click',function(){
$('#hpane1')[0].scrollTo(75);
return false;
});*/
});

function confirm_abuse(id){
	idMsgAbuse=id;
	
	 centerAbusePopup();
	 loadAbusePopup();
}


function send_abuse(){

//	alert ("send abuse");
//idMsgAbuse is id for msg
var msg=$("textarea[name=message_abuse]").val();

if( submitOnce==0){
	
	submitOnce=1;
	$.post('sendAbuse',{ "idMessageAbuse": idMsgAbuse ,"abuse_msg": msg ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
		disableAbusePopup();
	},"html");
}
	return false;

	
}

$(document).ready(function(){
	//CLOSING POPUP
	//Click the x event!
	$("#popupAbuseClose").click(function(){
	disableAbusePopup();
	});
	
	});



</script>

<decorator:head />
</head>
<body>
<div id="header-cover">
  <div id="header-area">
    <div class="logo"><a href="main"><img src="images/logo.png" alt="" border="0" /></a></div>
    <!--LOGO END-->
    <div id="tagline-search">
      <div class="search-box">
        <div class="left"> <span class="margin-top2"><em>Recherche:</em></span> <span class="search-strip">&nbsp;&nbsp;&nbsp;&nbsp;avancée</span></div>
        <div class="left search-input-cover">
         <form action="getResBooks">
          <input name="searchWord" type="text" class="search-input" id="textfield" />
          <input name="button" type="submit" class="btn-ok" id="button" value="OK" />
         </form>
        </div>
      </div>
      <div class="tagline" style="margin-right: 20px">"lis, écris, publie ... à l'infini !"</div>
    </div>
    <!--TAGLINE AND SEARCH BOX END-->
    <div id="top-nav-area">
      <div id="myjquerymenu" class="jquerycssmenu">
        <ul>
          <li class="inbox-simple"><a href="show_home" >Profil</a>
          	<ul >
              <li ><a href="show_profil">Modifier</a></li>
				
            </ul>
          
          </li>
          <li class="inbox-simple"><a href="#">Bibliothèque</a>
           <ul >
              <li ><a href="showAddMyEbook">Upload</a></li>
              <li><a href="show_MyBooks_full">Mes livres</a></li>
             <li><a href="showBuyBook">Mes achats</a></li>
             <li><a href="showsales">Mes ventes</a></li>
           </ul>
          </li>
           <s:if test="#session[@constant.Application@SESSION_NB_EMAIL_NOT_READ]==null || #session[@constant.Application@SESSION_NB_EMAIL_NOT_READ]==0">
	              <li class="inbox-icon"><a href="#">Messages</a>
            <ul >
              <li ><a href="show_mail">Mes Messages</a></li>
             
            
            </ul>
          </li>
           
           </s:if>
           <s:else>
                 <li class="inbox-icon"><a href="#" style="color: #357fee;">Messages</a>
	            <ul >
	              <li ><a href="show_mail" style="color: #33eeff;">Mes Messages (<s:property value="#session[@constant.Application@SESSION_NB_EMAIL_NOT_READ]" />)</a></li>
	             
	            
	            </ul>
	          </li>
           
    
           
           </s:else>
         
          <li class="inbox-simple"><a href="showAllGroups">Groupes</a>
          	<ul >
              <li><a href="showNewGroup">Créer Groupe</a></li>
              <li><a href="show_MyOwnGroup">Mes Groupes</a></li>
               <li><a href="show_MyJoinedGroup">Groupes joints</a></li>
            </ul>
          
          </li>
          
             <s:if test="#session[@constant.Application@SESSION_NB_FRIENDREQ_NOT_READ]==null || #session[@constant.Application@SESSION_NB_FRIENDREQ_NOT_READ]==0">
          <li class="inbox-simple"><a href="#">Amis</a>
          <ul >
              <li ><a href="showListFriends">Mes Amis</a></li>
             <li><a href="show_friend_request">Demande d'amis </a></li>
		</ul>
          </li>
            </s:if>
            <s:else>
             <li class="inbox-simple"><a href="#" style="color: #357fee;">Amis</a>
          <ul >
              <li ><a href="showListFriends">Mes Amis</a></li>
             <li><a href="show_friend_request" style="color: #33eeff;">Demande amis (<s:property value="#session[@constant.Application@SESSION_NB_FRIENDREQ_NOT_READ]" />)</a></li>
		</ul>
          </li>
            
           
            </s:else>
          <li class="inbox-simple"><a href="#">Favoris</a>
           <ul >
              <li ><a href="show_MyFollowBooks_full">Livres</a></li>
             <li><a href="showListFavouriteAuthors">Auteur </a></li>
		</ul>
          </li>
          <li class="btn-action"><a style="padding-left:11px;padding-right:11px;" href="logout">Déconnexion</a></li>
        </ul>
        <br class="clear-left" />
      </div>
    </div>
    <!--TOP NAV END-->
  </div>
</div>
<!--HEADER END-->
<div id="content-cover">
  <div class="bg-content-section1">
    <div class="bg-content-section2">
      <div id="slide-cover">
        <div id="slide">
          <ul id="ticker01" style="visibility: hidden;">
    	<li><span>news : </span><a style="color: #357fee;" href="#">Bienvenue sur lets-ebook, le premier site communautaire de partage d'ebooks. Toute l'équipe de lets-ebook vous souhaite une bonne année 2011 !</a></li>
        
          </ul>
        </div>
      </div>
      <!--NEWS TICKER END-->
      <div id="main-content-div">
        <div id="left-bar">
          <div class="heading-left-nav"><span><strong>Cat&eacute;gories</strong></span></div>
          <div id="left-nav">
            <div class="vertical">
             
              <ul>
              
               	   <s:iterator value="#application['catList']" var="c">                  
          			<s:url id="editBook" action="showBooks_by_Category" >
                  	 <s:param name="id_category" value="idCategory"/>
              		</s:url>                                             
          			<li><s:a href="%{editBook}"><s:property value="name"/></s:a>
          	
          			 <s:if test="!#c.categories.isEmpty">
					  <ul>
						<s:iterator value="categories" var="subC">
						 <s:url id="editBooksubC" action="showBooks_by_Category" >
	                	  <s:param name="id_category" value="#subC.idCategory"/>
	              		</s:url>
							<li><s:a href="%{editBooksubC}"><s:property value="#subC.name"/></s:a> </li>
						</s:iterator>
				   	  </ul>				
          		     </s:if>
          		              		     
            	    </li>
				   </s:iterator>
               
              
              </ul>
              
              
            </div>
     		<div class="white-box-cover cssSpanCurveWhite">
              <div> <span class="span3"></span><span class="span4"></span></div>
              <div class="white-box"> <strong class="size-txt13 blue-txt">Livre du moment :</strong><img src="/<s:property value="#application['bookofthedaylink']"/>" alt="" width="92" height="119" border="0" /><br />
                <span class="size-txt12 margin-top-5">"<s:property value="#application['bookoftheday'].title"/>"
                
                
                 <% //par <s:property value="#application['bookoftheday'].member.login"/> %>
                 
                 
                 </span><br />
                  <s:url id="url_show_Book" action="showBook" >
					       	<s:param name="bookId" value="#application['bookoftheday'].idBook"/>
					    	</s:url>
                <s:a href="%{url_show_Book}" class="size-txt13 margin-top-5"><em><strong>Consulter </strong></em></s:a></div>
              <div> <span class="span4"></span><span class="span3"></span></div>
            </div>
            <div class="call-action1"><a class="a_empty" href="showFaq">FAQ</a></div>
          </div>
          <!--LEFT NAV END-->
          <div class="left-advertising-add" >
<!--          <img src="images/left-add-img1.png" alt="" width="107" height="221" border="0" />-->


  <script type="text/javascript">
	var advst_zoneid = 25520;
	var advst_width = 120;
	var advst_height = 600;
	var advst_border_style = "solid";
	var advst_border_color = "000000";
	var advst_title_color = "336699";
	var advst_title_bgcolor = "FFFFFF";
	var advst_text_color = "000000";
	var advst_text_bgcolor = "FFFFFF";
	var advst_url_color = "008000";
	var advst_url_bgcolor = "FFFFFF";
	var advst_page_scan = 1;
	var advst_withpos = 1;
	var advst_parrainage = "0";
</script>
<script type="text/javascript" src="http://ad.advertstream.com/advst_p.php"></script>
<noscript>
	<a href="http://ad.advertstream.com/adsclick.php?what=zone:25520&inf=no&n=" target="_blank">
	<img src="http://ad.advertstream.com/ads.php?what=zone:25520&inf=no&n=" border="0" alt=""></a>
</noscript>






          </div>
        </div>
        <!--LEFT BAR END-->
        <!--   <div id="content-area"> -->
     	<decorator:body />
        <!-- </div>  -->
        <!--MAIN CONTENT AREA END-->
        <div id="right-bar">
          <div class="orange-box-cover">
            <div class="profile-div">
            <s:if test="#session[@constant.Application@USER_KEY].avatarUrl!=null">
           <a href="show_home"> <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#session[@constant.Application@USER_KEY].avatarUrlBig"/>" alt="" width="115" height="115" border="0" class="img-border-gray" /></a><br />
            </s:if> 
             <s:else>
                 <img src="images/profile-img2.jpg" alt="" width="115" height="115" border="0" class="img-border-gray" /><br />
             </s:else> 
              <div class="progress-div">
                <div class="progress-div-left" > Niv<s:property value="#session[@constant.Application@USER_KEY].levelMembers.iterator.next.level.numbr"/> </div>
                <div class="profile-div-right"> <span><s:property value="#session[@constant.Application@USER_KEY].levelMembers.iterator.next.exp"/> EXP</span> <span  id="pb1" class="right"></span> 
                </div>
              </div>
              <!--PROGRESS BAR DIV END-->
              <div class="padding5 size-txt12 line-height12">
                <div style="margin: 5px 0px 12px 0px;text-align: center;font-weight: bold;font-size: 15px;font-style: italic"> <s:property value="#session[@constant.Application@USER_KEY].login" /></div>
                <div style="margin: 5px 0px;height:25px; overflow: hidden;">
                
             <span style="color:#00A0C6"> Titre: </span><span style="font-weight: bold"><s:property value="#session[@constant.Application@USER_KEY].levelMembers.iterator.next.nameJob"/> </span></div>
                <div style="margin: 7px 0px;height: 110px;display: none;"><a href="#"> <span style="color:#00A0C6">Description</span></a>
               <s:property value="#session[@constant.Application@USER_KEY].description" />
              
            
              </div>
                  <div style="margin: 5px 0px 5px 0px;height:25px; overflow: hidden;"><span style="color:#00A0C6">Classe:<br /></span> <span style="font-weight: bold"><s:property value="#session[@constant.Application@USER_KEY].levelMembers.iterator.next.classMember.name" /></span><br /></div> 
                 <div style="margin: 5px 0px"> <span style="color:#00A0C6">Oeuvres: </span><s:property value="#session[@constant.Application@SESSION_NB_BOOK]"/></div>
               
                  <div style="margin: 7px 0px;height: 65px; overflow: hidden"> <span style="color:#00A0C6">Description: </span><s:property value="#session[@constant.Application@USER_KEY].description" /></div>
                 </div>
                  
            </div>
          </div>
          <!--PROFILE BOX END-->
          <div class="call-action2"><a class="a_empty" href="showAddMyEbook">PUBLIE!</a></div>
          <div class="call-action3"><a class="a_empty" href="show_referee"> Parrainage</a></div>
          <div class="right-advertising-add">
<!--          <img src="images/right-add-img1.gif" alt="" width="102" height="373" border="0" align="right" />-->
  <a href="mailto:contact@multidb.fr?subject=demande%20de%20partenariat%20publcitaire"> <img src="images/pub.jpg" alt="pub"  border="0" align="right" /></a> 
  <% /* 
     <script type="text/javascript"><!--
google_ad_client = "pub-2202219558922972";
 //120x600, date de création 03/08/10 
google_ad_slot = "8861707878";
google_ad_width = 120;
google_ad_height = 600;
google_language = 'fr'; 
//-->
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>     
          
*/ %>
   
          </div>
        </div>
        <!--RIGHT BAR END-->
        <div style="margin-top:100px; padding: 0px 120px 0px 150px;min-height: 50px; text-align: center;font-size: 12px;clear: both;"> <a href="cgu" target="blank">conditions d'utilisations</a> | <a href="interdiction" target="blank">interdictions</a> |<a href="mailto:contact@multidb.fr"> nous écrire</a>| <a href="http://www.multidb.fr">http://www.multidb.fr</a>
        
        </div>
         <!--FOOTER BAR END-->
      </div>
    </div>
  </div>
</div>



       <div id="popupAbuse" class="popupbig_bg">
  <div class="popupbig-innearea">
    <div class="popup-innearea-box" >
      <textarea name="message_abuse" rows="" cols="" ></textarea>
    </div>
    <div class="right">
      <input type="submit" name="button2" id="popupAbuseClose" value="Fermer" class="btn-large-gray" />
      &nbsp;
      <input type="button" name="button3" id="popupAbuseSubmit" onclick="send_abuse()" value="Envoyer" class="btn-blue" />
    </div>
  </div>
</div>   


<!--MAIN CONTENT SECTION END-->
<script type="text/javascript">
    var advst_glob_scan = 1;
</script>
<script type="text/javascript" src="http://ad.advertstream.com/advst_f.php?affiliate=12146"></script>
</body>
</html>

