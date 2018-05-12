<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"  />
<title><decorator:title default="DEFAULT TITLE"/></title>
<script type="text/javascript" src="js/jquery.js"></script>
<!--MAIN STYLESHEET-->
<link href="css/main-style/main.css" rel="stylesheet" type="text/css" />
<link href="css/mail-box/mailbox.css" rel="stylesheet" type="text/css" />
<!--TOP NAV ATTACHED FILES-->
<!--[if lte IE 7]>
<style type="text/css">html .jquerycssmenu{height: 1%;} /*Holly Hack for IE7 and below*/</style>
<![endif]-->
<!--   <script type="text/javascript" src="js/menu/jquery.min.js"></script>-->
<script type="text/javascript" src="js/menu/jquerycssmenu.js"></script>
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
$("#pb1").progressBar(0, {showText: false, width: 65, height: 6, boxImage:'images/progressbar.gif' , barImage: 'images/progressbg_blue.gif'});
});
</script>
<!--COMBOBOX ATTACHED FILES-->
<link href="css/combo-box/combobox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/combo-box/jquery.dimensions.js"></script>
<script type="text/javascript" src="js/combo-box/jquery.combobox.pikabu.js"></script>
<!--FORM VALIDATION ATTACHED FILES-->
<link href="css/form-validation/formvalidation.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/form-validation/formvalidation.js"></script>
 
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
$(".popupLoginClose").click(function(){
disableLoginPopup();
});
//Click out event!
$("#backgroundPopup").click(function(){
disablePopup();
});
//Click the button event!
});
</script>
 
 <!--FORM VALIDATION ATTACHED FILES-->
<link href="css/form-validation/form_login.css" rel="stylesheet" type="text/css" />

 <!-- end of common header -->
 
 <decorator:head />
</head>
<body>
<div id="header-cover">
  <div id="header-area">
    <div class="logo"><img src="images/logo.png" alt="" border="0" /></div>
    <!--LOGO END-->
    <div id="tagline-search">
      <div class="search-box">
        <div class="left"> <span class="margin-top2"><em>Recherche:</em></span> <span class="search-strip">&nbsp;&nbsp;&nbsp;&nbsp;avancée</span></div>
        <div class="left search-input-cover">
         <form action="getResBooks">
          <input name="searchWord" type="text" class="search-input" id="searchWord" />
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
          <li class="inbox-simple"><a href="main" >Accueil</a></li>
          <li class="inbox-simple"><a href="show_home">Bibliothèque</a></li>
          <li class="inbox-icon"><a href="show_home">Messages</a></li>
          <li class="inbox-simple"><a href="show_home">Groupes</a></li>
          <li class="inbox-simple"><a href="show_home"> Amis</a></li>
          <li class="inbox-simple"><a href="show_home">Favoris</a></li>
          <li class="btn-action"><a style="padding-left:11px;padding-right:11px;" href="javascript: centerLoginPopup(); loadLoginPopup();">Connexion</a></li>
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
            <li><span>news : </span><a style="color: #357fee;" href="#"> Bienvenue sur lets-ebook, le premier site communautaire de partage d'ebooks. Toute l'équipe de lets-ebook vous souhaite une bonne année 2011 !</a></li>
           
            
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
          <div class="left-advertising-add">
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
	<img src="http://ad.advertstream.com/ads.php?what=zone:25520&inf=no&n=" border="0" alt="" /></a>
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
            <div class="profile-div"><img src="images/profile-img2.jpg" alt="" width="115" height="115" border="0" class="img-border-white" /><br />
              <div class="progress-div">
                <div class="progress-div-left"> Login </div>
                <div class="profile-div-right"> <span>Niv. 00</span> <span  id="pb1" class="right"></span> </div>
              </div>
              <!--PROGRESS BAR DIV END-->
              <div  class="padding5">
                <p class="blue-txt txt-center size-txt15"><a href="javascript: centerLoginPopup(); loadLoginPopup();">Vous n'&ecirc;tes pas<br />
                  connect&eacute;</a></p>
                <p class="txt-center"><img src="images/profile-question-icon.gif" alt="" width="62" height="96" border="0" />&nbsp;</p>
              </div>
              <div class="profile-link-div"><a href="show_inscription">Inscris toi !</a></div>
            </div>
          </div>
          <!--PROFILE BOX END-->
          <div class="call-action2"><a class="a_empty" href="showAddMyEbook">PUBLIE!</a></div>
          <div class="call-action3"><a class="a_empty" href="show_referee"> Parrainage</a></div>
          <div class="right-advertising-add" style="height: 620px;">
          
<!--          <img src="images/right-add-img1.gif" alt="" width="102" height="373" border="0" align="right" /></div>-->

<a href="mailto:contact@multidb.fr?subject=demande%20de%20partenariat%20publcitaire"> <img src="images/pub.jpg" alt="pub"  border="0" align="right" /></a> 
<%  /*<script type="text/javascript"><!--
google_ad_client = "pub-2202219558922972";

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
      <!--RIGHT BAR END-->
      
    </div>
     <div style="margin-top:100px; padding: 0px 120px 0px 150px;min-height: 50px; text-align: center;font-size: 12px;clear: both;"> <a href="cgu" target="blank">conditions d'utilisations</a> | <a href="interdiction" target="blank">interdictions</a> |<a href="mailto:contact@multidb.fr"> nous écrire</a>| <a href="http://www.multidb.fr">http://www.multidb.fr</a>
        
        </div>
         <!--FOOTER BAR END-->
  </div>
</div>
  </div>
</div>
<!--MAIN CONTENT SECTION END-->
		<div id="popupLogin" class="popupbig_bg">
		  <div class="popupbig-innearea">
		   <form action="verifLogin" method="post">
		    <div class="popup-innearea-box" >
		    	 <dl class="form_login">
		    	<dd >
                    <label for="m.login"><strong>login :</strong></label>
                    <div class="error_img"></div>
                    <input class="form-input1" style="width:190px " name="m.login" id="m.login" type="text" maxlength="20" value=""  />
                    <div class="msg"></div>
                  </dd>
           
                  <dd >
                    <label for="m.password"><strong>mot de passe :</strong></label>
                    <div id="error_img"></div>
                    <input name="m.password" id="m.password" type="password" style="width:190px " class="form-input1 validated"  />
                    <div class="msg"></div>
                  </dd>
                     <dd class="validated" id="xoxoFile3_li">
                    <div id="xoxoFile3_img"></div>
                    <input type="checkbox" name="stay"   value="true" class="form-input-file validated" /> &nbsp;rester connect&eacute;
                    <div id="xoxoFile3_msg" ></div>
                  </dd>
                  <dd><i><a href="javascript: show_lost_passForm();"  >mot de passe oublié</a></i></dd>
                  </dl>
                  
		    </div>
		    <div class="right">
		      <input type="button" name="button2"  value="Fermer" class="btn-large-gray popupLoginClose" />
		      &nbsp;
		      <input type="submit" name="button3" value="Valider" class="btn-blue popupLoginSubmit" />
		    </div>
		    </form>
		  </div>
		  <div class="popup_passlost-innearea" style="display: none;">
		  	<form action="sendLostPassword">
		  	<div class="popup_passlost-innearea-box">
		  	<span style="font-weight:bold;font-size:12px;">Rentrez votre login, le mot de passe vous sera envoyé</span>
		  	 <dl class="form_lost_pass">
		    	<dd>
                    <label for="login"><strong>login :</strong></label>
                    <div class="error_img"></div>
                    <input name="login" id="login" type="text"  class="form-input1 validated"  />
                    <div class="msg"></div>
                  </dd>
                 
                  </dl>
                  
		    </div>
		    <div class="right">
		      <input type="button" name="button2"   value="Fermer" class="btn-large-gray popupLoginClose" />
		      &nbsp;
		      <input type="submit" name="button3"  value="Envoyer" class="btn-blue popupLoginSubmit" />
		    </div>
		  </form>
		  </div>
		</div>
		
		
		
		
		

		<script type="text/javascript">
    var advst_glob_scan = 1;
</script>
<script type="text/javascript" src="http://ad.advertstream.com/advst_f.php?affiliate=12146"></script>
</body>
</html>
