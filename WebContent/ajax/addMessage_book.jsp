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

<!--   <div> commentaires <a href="#" onclick="javascript:prompt('motif de l\'abus','rien');">[X]</a>-->
<div class="vertical-scroll-tab">
<div class="v-scroll-tab-left"><img
	src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="mb.member.avatarUrl"/>"
	alt="" width="59" height="59" border="0" align="left"
	class="img-border-orange" /></div>
<div class="v-scroll-tab-right">
<div class="right ver">
<ul class="vertical">
	<li><a href="#"><img src="images/plus-icon.jpg" alt=""
		border="0" /></a>
	<ul>
	  <li style="display: none;" ><a href="#">supprimer</a></li>
		                                  <li class="no-border"><span class="cursor" onClick="confirm_abuse('<s:property value='#mb.idMessage' />')"><a >abus</a></span></li>
	</ul>
	</li>
</ul>
</div>
<p><b><s:property value="mb.member.login" /> :</b><br />
<s:property value="mb.body" /></p>
</div>
</div>
<!--       </div>-->
</body>
</html>