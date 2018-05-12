<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:actionerror/><s:url/>

	<div id="petitblocright"> <form action="verifLogin">
  		inscription: <br />
   
    login <br />
    <input type="text" name="m.login"/>
    <br />
    password <br />
    <input type="text" name="m.password"/>
    <br /><input type="submit" value="se loguer" />
    
    <br /> <s:a href="show_inscription">pas encore inscrit.</s:a>
  
  </form>
  
  </div>
    
</body>
</html>

