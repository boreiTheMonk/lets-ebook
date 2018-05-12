<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>


<title>lets ebook - recherche</title>

<script type="text/javascript"
	src="<s:url value='/jquery/jquery_pagination/jquery.pagination.js'/>"></script>
<script type="text/javascript"
	src="<s:url value='/vue/resultat_recherche_Livre.js'/>"></script>
<link rel="stylesheet" media="screen" type="text/css"
	href="<s:url value="/css/pagination/pagination.css"/>" />
<!--        <script type="text/javascript" src="<s:url value='/jqueryui/js/jquery-1.3.2.min.js'/>"></script>-->
<!--  <script type="text/javascript" src="<s:url value='/jqueryui/js/jquery-ui-1.7.2.custom.min.js'/>"></script>-->
<!--<link rel="stylesheet" type="text/css"
	href="<s:url value='/css/custom-theme/jquery-ui-1.7.2.custom.css'/>" />

<script type="text/javascript"
	src="<s:url value='/javascript/ui.core.js'/>"></script>
<script type="text/javascript"
	src="<s:url value='/javascript/ui.tabs.js'/>"></script>


-->

	<script type="text/javascript" src="js/threeDots/jquery.ThreeDots.min.js"></script>
		<script type="text/javascript">

		$(function()
		{
		// this initialises the demo scollpanes on the page.
		
			$('.text_name_avatar').ThreeDots({max_rows:2, whole_word:false});
		
		});
		</script>

</head>
<body>

<div id="content-area">
<div class="border-heading-div">
<div class="bg-heading-div">
<div class="main-heading-div">Recherche</div>
<div class="top-heading-icon"><img src="images/recherche-icon.png"
	width="24" height="27" alt="" border="0" class="margin-top-4" /></div>
<div class="tabs-nav"><a id="tab_book" class="tab-select" href="javascript:initPaginationBook()">Livres(<span id="nbResBook"><s:property value="nbBooks"/></span>)</a><a id="tabAuth" href="javascript:initPaginationAuthor()">Auteurs(<span id="nbResAuthor"><s:property value="nbAuthors"/></span>)</a>
<a id="tab_group" href="javascript:initPaginationGroup()">Groupes(<span id="nbResGroup"><s:property value="nbGroups"/></span>)</a></div>
</div>
</div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="content-tab-cover left">
                <div class="tab-content left">
                  <div class="breadcrumb" style="visibility: hidden;"><a href="#">xoxoxox</a><span>/</span><a href="#">xoxoxox</a><span>/</span><a href="#">xoxoxox xox</a></div>
                 <div style="margin-bottom: 10px">r&eacute;sultat pour la recherche "<span id="word"><s:property value="searchWord" /></span>" : livres: <span id="nbRes"><s:property value="nbBooks"/></span> resultats, auteurs: <span id="nbRes"><s:property value="nbAuthors"/></span> resultats, groupes: <span id="nbRes"><s:property value="nbGroups"/></span> resultats</div>
				<div style="margin-bottom: 10px;font-size: 15px"> rechercher  "<span id="word"><s:property value="searchWord" /></span>" sur notre partenaire <a	href="http://www.amazon.fr/gp/search?ie=UTF8&keywords=<s:property value="searchWord" />&tag=multidb-21&index=books&linkCode=ur2&camp=1642&creative=6746" target="_blank">amazon</a></div>
<!--                   <div id="searchResults" > Chargement attendre un instant... </div>-->
<!--                   <div id="searchResults" > Chargement attendre un instant... </div>-->
<!--                   <div id="searchResults_author" > Chargement attendre un instant... </div>-->
                   <div id="searchResults" >  </div>
<!--                  <div id="searchResults" class="left"> This content will be replaced when pagination inits. </div>-->
                  <!-- Container element for all the Elements that are to be paginated -->
                  <div id="hiddenresult" class="display-none">
                    <div class="result">
                      <div class="horizontal-scroll-tab2"> <span ><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-gray" /> Xoxoxox
                        xox
                        xoxoxoxox </div>
                
             
                  </div>
                 </div>
                  <div class="pagination" style="clear: both;"></div>
                </div>
              </div>
            </div>
          </div>
</div>


</body>
</html>
