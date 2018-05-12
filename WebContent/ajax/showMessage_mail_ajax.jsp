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
<!--

  <div class="mail-list-cover">
  	<div class="right ver">
	<ul class="vertical">
		<li><a href="#"><img src="images/plus-icon.jpg" alt=""
			border="0" /></a>
		<ul>
			<li><a href="#">supprimer</a></li>
			<li class="no-border"><a href="#">abus</a></li>
		</ul>
		</li>
	</ul>
	</div>
    <div class="mail-list-left-div"> <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#msg.memberByIdMemberSender.avatarUrl"/>" alt="" width="59" height="59" border="0" align="left" class="img-border-blue" /> </div>
    <div class="mail-list-right-div">
      <p><b class="size-txt12"><em><s:property value="#msg.member.login" /> :</em></b><br />
        <s:property value="#msg.body" /></p>
    	
    </div>
  </div>-->

  <s:if test="#msg.isRead==true || #msg.memberByIdMemberSender.idMember==#session[@constant.Application@USER_KEY].idMember">
	<div class="mail-list-cover">
	</s:if>
	<s:else>
	<div class="mail-list-cover" style="border:1px solid red;">
	</s:else>
	
	<input type="hidden" value="<s:property value="#msg.idMessage" />">
	<div class="v-scroll-tab-left">
	
	 <s:if test=" #msg.memberByIdMemberSender.idMember==#session[@constant.Application@USER_KEY].idMember">
	<img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#msg.memberByIdMember.avatarUrl"/>"
		alt="" width="59" height="59" border="0" align="left"
		class="img-border-orange" />
		</s:if>
	<s:else>
	<img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#msg.memberByIdMemberSender.avatarUrl"/>"
		alt="" width="59" height="59" border="0" align="left"
		class="img-border-orange" />
	</s:else>
		
		</div>
	<div class="v-scroll-tab-right">
	<div class="right ver">
	<ul class="vertical">
		<li><a href="#"><img src="images/plus-icon.jpg" alt=""
			border="0" /></a>
		<ul >
			<li><span class="cursor" onclick="confirm_delete_inbox('<s:property value='#msg.idMessage' />','<s:property value='name' default="message" />',this);" ><a >supprimer</a></span></li>
			
		</ul>
		</li>
	</ul>
	</div>
	<p><b>
	
	<s:if test=" #msg.memberByIdMemberSender.idMember==#session[@constant.Application@USER_KEY].idMember">
	<s:property value="#msg.memberByIdMember.login" />
	</s:if >
	<s:else>
	<s:property value="#msg.memberByIdMemberSender.login" />
	</s:else>
	
	
	:</b><br />
	<s:property value="#msg.body" /></p>
	</div>
	<div style="font-style: italic;text-align: right"> posté le : <s:property value="#publish"/></div >
	</div>
</s:iterator>



<!--       </div>-->
</body>
</html>