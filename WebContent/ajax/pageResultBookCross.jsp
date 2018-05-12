
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% /*
<!--		<div style="border: solid">titre: <s:property value="title" /><br />-->
<!--		auteur : <s:property value="member.name" /> <s:property-->
<!--			value="member.lastName" /><br />-->
<!--		evaluation: ****** (best seller)</div>-->
*/
%>
<div class="wrap" style="overflow: hidden;">
<s:iterator value="resBooks" status="stat">
<s:if test="#stat.index % 5 == 0 && #stat.index!=0">
	</div><div class="wrap" style="overflow: hidden;">
	</s:if>
	<div class="horizontal-scroll-tab2">
		<span><span class="cursor" onClick="confirm_delete('<s:property value='idBook' />','<s:property value='title' />',this)"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></span></span> 
		<img src="/<s:property value='@constant.Application@FOLDER_BOOK_IMAGE_URL'/>/<s:property value='linkImage'/>" width="83px" height="103px" alt="" border="0"class="img-border-gray" />
		 <s:property value="title" /><br/>par <s:property value="member.login" />
	</div>
	


	
</s:iterator>
</div>
</body>
</html>