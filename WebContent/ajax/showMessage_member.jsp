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
<s:iterator value="resMessage" var="msg">
<s:date name="#msg.publishDate" format="dd/MM/yyyy à HH:mm" var="publish"/>
	<div class="vertical-scroll-tab">
	<div class="v-scroll-tab-left"><img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#msg.memberByIdMemberSender.avatarUrl"/>"
		alt="" width="59" height="59" border="0" align="left"
		class="img-border-orange" /></div>
	<div class="v-scroll-tab-right">
	<div class="right ver">
	<ul class="vertical">
		<li><a href="#"><img src="images/plus-icon.jpg" alt=""
			border="0" /></a>
		<ul>
			 <s:if test="#msg.memberByIdMemberSender.idMember==#session[@constant.Application@USER_KEY].idMember || #msg.memberByIdMember.idMember==#session[@constant.Application@USER_KEY].idMember">

			<li><span class="cursor" onclick="confirm_delete_message('<s:property value='#msg.idMessage' />','<s:property value='name' default="message" />',this);" ><a >supprimer</a></span></li>
				
			</s:if>
            <li class="no-border"><span class="cursor" onClick="confirm_abuse('<s:property value='#mg.idMessage' />')"><a >abus</a></span></li>
			
			
		</ul>
		</li>
	</ul>
	</div>
	<p><b><s:property value="#msg.memberByIdMemberSender.login" />
	:</b><br />
	<s:property value="#msg.body" /></p>
	</div>
	<div style="font-style: italic;text-align: right"> posté le : <s:property value="#publish"/></div >
	</div>
</s:iterator>
<!--       </div>-->
</body>
</html>