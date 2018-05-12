<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="<s:url name="/vue/menu_categories.css"/>" />
      <script type="text/javascript" src="<s:url name='/vue/menu_change.js'/>" ></script>
<style type="text/css">
	/*	* { padding: 0; margin: 0; }
		body { background-color: #ccc; text-align: center; }
		.cornered, .gradient, .categorie_content, .dropshadow, .combo, .liquid { width: 250px; background-color: #fff; margin: 20px auto; }
		h4 { height: 50px; text-align: center; line-height: 2em; font-size: 1.5em; background: transparent  center repeat-x; }
		p { text-align: justify; background: transparent; */
                /* url('gradient.jpg') center repeat-x;
                 padding: 15px; }
		.xtra, .xtra2 { width: 250px; background-color: #fff; margin: 20px auto; }
		.xtra3 { width: 90%; background-color: #fff; margin: 20px auto; }*/
		.ui-state-hover, .ui-widget-content .ui-state-hover {
background:#d2d2d2;
}
	</style>

</head>
<body>
	
	
  	<div class="categorie_hat" >   </div>
        
        
                
        <% // <img src="images/backgr_menu.png" class="img_menu" style="left:0px;top:0px;width:100%;height:100%;"/> %>
        
        


    	<div id="div_menu_category" class ="ui-corner-all" style="width: 115px;margin-left: 10px;margin-top: 10px;border: 1px solid #ccc;background: white;z-index: 300;">
  <ul> 
    
    <li><a href="#">Actualite</a> 
      
      <ul class ="ui-corner-all ulone" style="width: 150px;border: 1px solid #ccc;;background: white;z-index: 5;"> 
        <li><a href="#">Divertissement</a></li> 
        <li><a href="#">Politique</a></li> 
        <li><a href="#">Economie</a></li>
        <li><a href="#">Sant&</a></li> 
        <li><a href="#">Sport</a></li> 
        <li><a href="#">Autre</a></li>  
      </ul> 
      
    </li> 
    <li><a href="#">Divertissement</a> 
       <ul class ="ui-corner-all ulone"  style="width: 150px;border: 1px solid #ccc;;background: white;"> 
        <li><a href="#">People</a></li> 
        <li><a href="#">Cinema </a></li> 
        <li><a href="#">Musique</a></li> 
        <li><a href="#">Autre</a></li> 
      
         
        
      </ul> 
    </li>
    <li><a href="#">Finance</a> 
       <ul class ="ui-corner-all ulone" style="width: 150px;border: 1px solid #ccc;;background: white;"> 
        <li><a href="#">Personnel</a>
           <ul  class ="ui-corner-all ultwo" style="width: 150px;border: 1px solid #ccc;;background: white;"> 
		        <li><a href="#">Creer sa societ&eacute;</a></li> 
		        <li><a href="#">pr&ecirc;t</a></li> 
		        <li><a href="#">Epargne</a></li> 
		        <li><a href="#">Dette</a></li> 
           </ul> 
        
        
        
        </li> 
        <li><a href="#">Entreprise</a></li> 
       
      </ul> 
    </li> 
    <li><a href="#">Romans</a> 
      
      <ul class ="ui-corner-all ulone" style="width: 150px;border: 1px solid #ccc;;background: white;z-index: 5;"> 
        <li><a href="#">science fiction</a></li> 
        <li><a href="#">Fantastique</a></li> 
        <li><a href="#">Eroic Fantasy</a></li>
        <li><a href="#">Thriller</a></li> 
        <li><a href="#">Policier</a></li> 
        <li><a href="#">Historique</a></li>  
        <li><a href="#">Autre</a></li> 
      </ul> 
      
    </li> 
    <li ><a  href="#"   >Poeme</a></li> 
    <li ><a  href="#"   >Nouvelles</a></li>
    <li ><a  href="#"   >Mangas</a></li>  
     <li ><a  href="showAllcategories"   >Afficher tout</a></li> 
  </ul>

</div>
    
    
        
        
        <div class="categorie_tail">  </div>
        <script type="text/javascript"
src="development-bundle/jquery-1.3.2.js"></script>
<script type="text/javascript">
/*$(function() {
$("div.menu_content ul li ul li").hover(function() {
$(this).addClass("ui-state-hover");
}, function() {
$(this).removeClass("ui-state-hover");
});
});*/
</script>
</body>
</html>