<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
         <script type="text/javascript" src="<s:url value="/javascript/jquery-1.4.js"/>" ></script>
         <script type="text/javascript" src="<s:url value='/vue/curvycorners.src.js'/>"></script>
         <link rel="stylesheet" media="screen" type="text/css" href="<s:url value="/vue/menu_categories.css"/>" />
         <link rel="stylesheet" media="screen" type="text/css" href="<s:url value="/vue/menu_fonctionalite.css"/>" />
         <link rel="stylesheet" media="screen" type="text/css" href="<s:url value="/vue/menu_principal.css"/>" />
         
         <script type="text/javascript" src="<s:url value='/vue/menu_principal.js'/>" ></script>
     <script type="text/javascript" src="<s:url value='/vue/menu_principal.css.js'/>"></script>
</head>
<body>
<%
 /*   menu site
            <a href="index.php?page=profil">gerer son profil</a> ***  <a href="index.php?page=groupes">gerer ses groupes</a>*** <a href="index.php?page=mesLivres">gerer ses livres</a> ***
            *** <a href="index.php?page=mail">gerer ses mails</a>  recherche auteur: <input type="text" name="" id="" /> <a href="index.php?page=rechercheAuteur"> go</a>
*/ %>
                    <ul id="nav">
    <li><a href="show_home" id="m_home">Home</a></li>
    <li><a href="#" id="m_library">bibliotheque</a></li>
    <li><a href="#" id="m_message">message</a>
        <ul>
            <li><a href="#">3.1 jQuery</a>
                <ul>
                    <li><a href="#">3.1.1 Download</a></li>
                    <li><a href="#">3.1.2 Tutorial</a></li>
                </ul>
            </li>
            <li><a href="show_my_groups">groups</a></li>
            <li><a href="#">3.3 Prototype</a></li>
        </ul>
    </li>
    <li><a href="show_profil" id="m_profile">profil</a></li>
    <li><a href="#" id="m_logout">2logout</a></li>
    <li><form action="getResBooks" ><span >  <a href="#" onclick="submit();" id="m_search"  > recherche <input type="text" name="searchWord" id="" /><input type="submit" value="."> go</a></span></form></li>
</ul>

                    <div style="clear: both"></div>
</body>
</html>