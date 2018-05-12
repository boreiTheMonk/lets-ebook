<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
       <!--VERTICAL SCROLLER ATTACHED FILEES-->
<link rel="stylesheet" type="text/css" media="all" href="css/verticaly-scroller/demoStyles.css" />
<link rel="stylesheet" type="text/css" media="all" 
href="css/verticaly-scroller/jScrollPane.css" />
<!--<script type="text/javascript" src="testjs/jquery.js"></script>-->
<script type="text/javascript" src="js/verticaly-scroller/jquery_002.js"></script>
<script type="text/javascript" src="js/verticaly-scroller/jScrollPane.js"></script>


<script src="js/bxslider/jquery.bxSlider.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/bx_styles/bx_styles.css" />


<script type="text/javascript">





$(function()
{
// this initialises the demo scollpanes on the page.

$('#page21').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});

});

</script>
<!--JCAROUSEL ATTACHED FILES-->
<link rel="stylesheet" href="css/jcarousel/style1.css" type="text/css" />
<script type="text/javascript" src="js/jcarousel/jcarousellite_1.js"></script>
<script type="text/javascript">
$(function() {
$(".slider").jCarouselLite({
btnNext: ".next",
btnPrev: ".prev",
visible: 6
});
});

/*$(document).ready(function(){
$('img.captify').captify({
// all of these options are... optional
// ---
// speed of the mouseover effect
speedOver: 'fast',
// speed of the mouseout effect
speedOut: 'normal',
// how long to delay the hiding of the caption after mouseout (ms)
hideDelay: 500,	
// 'fade', 'slide', 'always-on'
animation: 'slide',		
// text/html to be placed at the beginning of every caption
prefix: '',		
// opacity of the caption on mouse over
opacity: '0.7',					
// the name of the CSS class to apply to the caption box
className: 'caption-bottom',	
// position of the caption (top or bottom)
position: 'bottom',
// caption span % of the image
spanWidth: '100%'
});
});*/

</script>

        <title>lets ebook - accueil</title>
        
        
	<script type="text/javascript" src="js/threeDots/jquery.ThreeDots.min.js"></script>
		<script type="text/javascript">

		$(function()
		{
		// this initialises the demo scollpanes on the page.
		
			$('.text_name_avatar').ThreeDots();
		
			$('#slider-banner').bxSlider({
		            auto: true,
		            autoControls: true,
		            autoHover: true,
		            pager: false,
		            controls: false,
		            pause:7000
		        });

		
		});
		</script>
        
 </head>
 <body>

<div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Home</div>
              <div class="top-heading-icon"><img src="images/home-icon.png" width="27" height="24" alt="" border="0" /></div>
              <div class="main-heading-right-txt"><em><s:property value="nbMembers"/> inscrits / <s:property value="nbBooks"/> oeuvres publi&eacute;es</em></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div">
              <div class="home-content-cover ">
                <div class="benner-area">
                <% /*	<ul id="slider-banner">
                	<li>
	                	<a href="show_referee" ><img src="images/index-banner.png" alt="" width="598" height="218" border="0" class="img-border-orange" usemap="#regl"/></a>
	                	<map name="regl" id="regl">
	                	<area shape="rect" coords="411,205,598,218" href="reglement" alt="" />
	                	<area shape="rect" coords="0,0,598,205" href="show_referee" alt="" />
	                	</map>
                	</li> 
					<li>*/%>
						<a href="showAddMyEbook" ><img src="images/index-banner3.jpg" alt="" width="598" height="218" border="0" class="img-border-orange" usemap="#regl"/></a>
					<% /*</li>
					
					</ul>*/%>
                </div>
                
                
                <div class="message-alert-div" style="visibility:  hidden;"> nouveau message!<a href="#"><img src="images/message-alert-icon.gif" alt="" width="47" height="19" border="0" class="margin-left10" /></a></div>
                <div class="video-area">
                  <div class="video-area-left">
                    <div class="border-cssSpanCurveWhite1"> <span class="span3"></span> <span class="span4"></span>
                      <div class="v-video-list-content">
                        <div class="v-video-heading">Nouveaux inscrits  :</div>
                        
                         <s:iterator value="newMember">
                          <s:url id="url_show_author" action="show_author" >
                        <s:param name="idMember" value="idMember"/>
                     </s:url>
                        <div class="v-video-tab"> 
                        <s:if test="avatarUrl!=null">
                        <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="avatarUrl"/>" class="margin-right10" width="53px" height="53px" alt="" border="0" align="left" />
                        </s:if>
                       <s:else>
                        <img src="images/amis-img.gif" class="margin-right10" width="53px" height="53px" alt="" border="0" align="left" />
                       </s:else>
                        
                          <p class="size-txt12"><s:a href="%{url_show_author}"><div class="text_name_avatar" style="width: 170px"><strong class='ellipsis_text'><s:property value="login"/></strong></div></s:a>
                           classe :<br />
                            <s:property value="levelMembers.iterator.next.classMember.name"/></p>
                        </div>
                        </s:iterator><!--
                        
                        <div class="v-video-tab"> <img src="images/video-list-image.gif" class="margin-right10" alt="" border="0" align="left" />
                          <p class="size-txt12"><a href="#"><strong>Xoxoxoxox</strong></a><br />
                            xoxo<br />
                            xoxoxoxoxo</p>
                        </div>
                        <div class="v-video-tab"> <img src="images/video-list-image.gif" class="margin-right10" alt="" border="0" align="left" />
                          <p class="size-txt12"><a href="#"><strong>Xoxoxoxox</strong></a><br />
                            xoxo<br />
                            xoxoxoxoxo</p>
                        </div>
                        <div class="v-video-tab"> <img src="images/video-list-image.gif" class="margin-right10" alt="" border="0" align="left" />
                          <p class="size-txt12"><a href="#"><strong>Xoxoxoxox</strong></a><br />
                            xoxo<br />
                            xoxoxoxoxo</p>
                        </div>
                        <div class="v-video-tab"> <img src="images/video-list-image.gif" class="margin-right10" alt="" border="0" align="left" />
                          <p class="size-txt12"><a href="#"><strong>Xoxoxoxox</strong></a><br />
                            xoxo<br />
                            xoxoxoxoxo</p>
                        </div>
                      -->
                      </div>
                      <span class="span4"></span> <span class="span3"></span> </div>
                  </div>
                  <div class="video-area-right">
                    <div class="margin-bottom10">
                    
                    
                    
            <object type="application/x-shockwave-flash" style="width:388px; height:259px;" data="http://www.youtube.com/v/BK0ebUDOQzQ">
<param name="movie" value="http://www.youtube.com/v/BK0ebUDOQzQ" />
</object>
              
<!--                    <img src="images/video-player.gif" alt="" width="388" height="211" border="0" />-->
                    
                    </div>
                    <div><b>News</b>
                      <div class="vertical-video-scroller">
                        <div class="holder osX">
                          <div id="page21">
                            <div class="padding5"> 
  
    <p ><span style="font-weight: bold">6 janvier 2011:</span><br/>
Toute l'équipe lets-ebook vous souhaite une bonne année 2011 et vous annonce la fin du premier jeu concours !
<br/><br/>
<span style="font-size:14px;font-weight:bold;color:red;">Vainqueur : Starbuck </span>
<br/><br/>

L'équipe lets-ebook

</p>                           
 
  <p ><span style="font-weight: bold">24 décembre 2010 :</span><br/>
Toute l'équipe de lets-ebook vous souhaite de bonnes fêtes de fin d'année. <br/><br/>

L'équipe lets-ebook

</p> 
 
 <p ><span style="font-weight: bold">4 décembre 2010 :</span><br/>
l'équipe lets ebook travaille actuellement sur l'amelioration du site. Donnez votre avis en discutant sur le groupe <a href="showGroup?groupId=4" >Fans du site! </a><br/><br/>

L'équipe lets-ebook

</p> 
                            
<p ><span style="font-weight: bold">4 décembre 2010 :</span><br/>
Attention profitez des derniers jours pour tenter de gagner votre ipad. le 31 décembre le jeu s'arrête alors profitez en!<br/>

L'équipe lets-ebook

</p> 
          
<p ><span style="font-weight: bold">07 Novembre 2010 :</span><br/>
EXCEPTIONNEL, prolongement du concours iPad jusqu'au 31 décembre ! Parrainez vos amis et gagner votre iPad !<br/>

L'équipe lets-ebook

</p> 
                            
 
 
 
<p ><span style="font-weight: bold">31 Octobre 2010</span><br/>
Vendre ses ebooks sera bientôt possible sur lets-ebook ! Restez connecté !<br/>

L'équipe lets-ebook

</p> 



<p ><span style="font-weight: bold">01 Octobre 2010</span><br/>
Chers adhérents, il ne vous reste plus qu'un mois pour profiter du jeu concours iPad !<br/>
Parrainez vos amis grâce au bouton ci-contre et gagnez votre iPad !<br/>
Bonne chance à tous.<br/>
L'équipe lets-ebook

</p> 
<br/>


<p ><span style="font-weight: bold">11 septembre 2010</span><br/>
Des idées pour améliorer le site ? N'hésitez pas à nous en faire part en nous écrivant par mail grâce au lien en bas de page ou en discutant dans le groupe
<a href="showGroup?groupId=4" >Fans du site! </a><br/>
L'équipe lets-ebook

</p> 
<br/>

<p ><span style="font-weight: bold">07 septembre 2010</span><br/>

Peu importe le livre que vous recherchez, nous saurons vous apporter une réponse.<br/>
L'équipe lets-ebook
</p> 
<br/>

<p ><span style="font-weight: bold">07 septembre 2010</span><br/>
Nouvelle fonctionnalité disponible : pour accéder à tous les groupes créés sur lets-ebook, cliquez sur "Groupes".<br/>
L'équipe lets-ebook

</p> 
<br/>

<p ><span style="font-weight: bold">03 Septembre 2010</span><br/>
Pour dynamiser votre profil, pensez à insérer un avatar et une description.<br/>
L'équipe lets-ebook

</p> 
<br/>


 <p ><span style="font-weight: bold">31 Aout 2010</span><br/>

Nouvelle fonctionnalité : pour chaque message, commentaire sur votre mur ou sur l'un de vos ebooks, un email vous parviendra pour vous avertir.<br/>
L'équipe lets-ebook.
</p> 
<br/>

 <p ><span style="font-weight: bold">30 Aout 2010</span><br/>

Il vous reste deux mois pour parrainer un maximum de personnes et tenter de gagner votre iPad !<br/>
Bonne chance à tous.
</p> 
<br/>


 <p ><span style="font-weight: bold">15 Août 2010</span><br/>
Félicitation à VEGETATOR qui dispose du niveau d'expérience le plus élévé sur le site: Niv. 23 pour 63 oeuvres diffusées sur lets-ebook!<br/>

</p> 
<br/>

   <p ><span style="font-weight: bold">04 Août 2010</span><br/>
Pour dynamiser votre profil, pensez à mettre un avatar !<br/>

</p> 
<br/>

   <p ><span style="font-weight: bold">04 Août 2010</span><br/>
Tous les documents sont acceptés sur lets-ebook : Livres libres de droit, Livres de votre création, Recettes de cuisine et tout autre document électronique !<br/>
Créez vos propres Sudokus grâce à la grille vierge déposée :  <a href="showBook?bookId=118"> ici </a> <br/>
Mais vous pouvez également tester votre humour en diffusant vos propres Histoires Drôles ! <br/>

Ecrivez, lisez, publiez sur lets-ebook !<br/></p> 
<br/>
 
   <p ><span style="font-weight: bold">03 Août 2010</span><br/>
Chaque jour, des nouveaux livres sont mis en ligne sur lets-ebook.<br/>
N'oubliez pas de consulter le livre du jour !<br/>
Aujourd'hui, "La lettre écarlate" par Nathaniel Hawthorne et mis en ligne par minette.<br/>

Vous êtes sur lets-ebook !<br/></p> 
<br/>
 
 
  <p ><span style="font-weight: bold">02 Août 2010</span><br/>
  Bienvenue sur lets-ebook !<br/>
Une idée pour améliorer le site ? Quelque chose d'innovant ?<br/>
Proposes nous ton idée en nous contactant sur l'onglet "nous écrire" ci-dessous et deviens un membre actif et reconnu du site.<br/>

A bientôt sur lets-ebook !</p> 
<br/>
 

 
 
 <p ><span style="font-weight: bold">28 juillet 2010</span><br/>Réouverture du site lets-ebook</p> 
<br/>


 <p ><span style="font-weight: bold">28 Juillet 2010</span><br/>Evènement iPad à gagner ! Participez au jeu concours en parrainant un maximum de personnes.
Pour plus d'informations concernant le parrainage, consultez la FAQ.</p> 
<br/>


 <p ><span style="font-weight: bold">28 Juillet 2010</span><br/>Livre du jour : Pride and Prejudice.
De Jane Austen
Mis en ligne par Rocky </p> 
<br/>

 <p ><span style="font-weight: bold">28 Juillet 2010</span><br/>A venir très prochainement :
Vente de livres électronique / Choix des codes couleurs 
Et bien d'autres encore .</p> 
<br/>




                             </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="h-video-list-cover">
                  <div class="h-video-heading"> Livres R&eacute;cents :</div>
                  <div class="border-cssSpanCurveWhite2"> <span class="span3"></span> <span class="span4"></span>
                    <div class="h-video-content-cover">
                      <div id="list">
                        <div class="prev"><img src="images/video-bullet-left.gif" alt="prev" /></div>
                        <div class="slider">
                          <ul>
                           <s:iterator value="mylistbook">
                            <s:url id="url_show_Book" action="showBook" >
					       	<s:param name="bookId" value="idBook"/>
					    	</s:url>
                            <li> 
                            <s:a href="%{url_show_Book}">
                            <s:if test="linkImage!=null">
                            <img src="/<s:property value='@constant.Application@FOLDER_BOOK_IMAGE_URL'/>/<s:property value='linkImage'/>" alt="Bob" />
                            </s:if>
							<s:else>
							<img src="images/horizontal-scroll-img.jpg" />
							
							</s:else>
							</s:a>
                             <p style="width:57px;height:30px;overflow:hidden;"><s:property value="title"/><br />
                             
                                <s:property value='nbPages'/>p</p>
                            </li>
                            </s:iterator>
                            <!--<li> <img src="images/video-image.gif" alt="Bob" />
                              <p>xoxo xiox<br />
                                xoxxo</p>
                            </li>
                            <li> <img src="images/video-image.gif" alt="Bob" />
                              <p>xoxo xiox<br />
                                xoxxo</p>
                            </li>
                            <li> <img src="images/video-image.gif" alt="Bob" />
                              <p>xoxo xiox<br />
                                xoxxo</p>
                            </li>
                            <li> <img src="images/video-image.gif" alt="Bob" />
                              <p>xoxo xiox<br />
                                xoxxo</p>
                            </li>
                            <li> <img src="images/video-image.gif" alt="Bob" />
                              <p>xoxo xiox<br />
                                xoxxo</p>
                            </li>
                            <li> <img src="images/video-image.gif" alt="Bob" />
                              <p>xoxo xiox<br />
                                xoxxo</p>
                            </li>
                            <li> <img src="images/video-image.gif" alt="Bob" />
                              <p>xoxo xiox<br />
                                xoxxo</p>
                            </li>
                          -->
                          </ul>
                        </div>
                        <div class="next"><img  src="images/video-bullet-right.gif" alt="next" /></div>
                      </div>
                    </div>
                    <span class="span4"></span> <span class="span3"></span> </div>
                </div>
                
                
                
                 <div style="margin-top: 150px" class="h-video-list-cover">
                  <div class="h-video-heading"> Partenaires :</div>
                  <div class="border-cssSpanCurveWhite2" > <span class="span3"></span> <span class="span4"></span>
                 
                     <div class="h-video-content-cover">
                    	<div style="text-align:center;margin:0px 15px; display: inline;"><a href="http://iae.univ-poitiers.fr/" target="_blank" ><img height="150px" src="images/Logo_IAEPoitiers.jpg" alt="Bob" /></a> </div >
                    <div style="text-align:center;margin-right: 15px; display: inline;"><a href="http://www.lessavoirsinedits.fr/" target="_blank" ><img height="80px" src="images/partenaire2.jpg" alt="Bob" style="border: 1px solid"/></a> </div >
                   
                   
                    </div>
                   
                    <span  style="clear:both;"></span>
                    <span class="span4"></span> <span class="span3"></span>  </div>
             
                
                </div>
                
                
              </div>
            </div>
          </div>
        </div>
		
</body>
</html>

