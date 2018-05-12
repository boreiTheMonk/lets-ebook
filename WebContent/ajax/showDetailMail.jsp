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


<div class="holder osX mail-box-right-div">
  <div id="page2" class="scroll-pane-mailbox">
  <s:date name="mail.publishDate" format="dd/MM/yyyy à HH:mm" var="publish"/>
  <% //because of gold border, need to rechecck 
  /* <s:if test="%{mail.memberByIdMemberSender.idMember!=#session[@constant.Application@USER_KEY].idMember}">
    <div class="mail-list-cover">
      <div class="mail-list-left-div"> <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="mail.memberByIdMemberSender.avatarUrl"/>" alt="" width="59" height="59" border="0" align="left" class="img-border-blue" /> </div>
      <div class="mail-list-right-div">
        <p><span class="size-txt12"><em><b><s:property value="mail.memberByIdMemberSender.login" /> :</b></em></span><br />
        <s:property value="mail.body" /></p>
      </div>
    <div style="font-style: italic;text-align: right"> posté le : <s:property value="#publish"/></div >
    </div>
    </s:if>
    <s:else>
    <div class="padding-left21">
      <div class="inner-list-cover">
        <div  class="inner-list-left-div"><img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="mail.memberByIdMemberSender.avatarUrl"/>" alt="" width="59" height="59" border="0" align="left" class="img-border-blue" /></div>
        <div class="inner-list-right-div">
          <p><span class="size-txt12"><em><b><s:property value="mail.memberByIdMemberSender.login" />  :</b></em></span><br />
            <s:property value="mail.body" />
       
        </div>
        <div style="font-style: italic;text-align: right"> posté le : <s:property value="#publish"/></div >
      </div>
      
    </div>
    </s:else>*/
    
  %>
    <s:iterator value="mail.messageEmailsForIdMessageRoots" var="msg">
  
    <s:date name="#msg.publishDate" format="dd/MM/yyyy à HH:mm" var="datep"/>
       <s:if test="%{#msg.memberByIdMemberSender.idMember!=#session[@constant.Application@USER_KEY].idMember}">
    <div class="mail-list-cover">
      <div class="mail-list-left-div"> <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#msg.memberByIdMemberSender.avatarUrl"/>" alt="" width="59" height="59" border="0" align="left" class="img-border-blue" /> </div>
      <div class="mail-list-right-div">
        <p><span class="size-txt12"><em><b><s:property value="#msg.memberByIdMemberSender.login" /> :</b></em></span><br />
         <s:property value="#msg.body" /></p>
      </div>
      <div style="font-style: italic;text-align: right"> posté le : <s:property value="#datep"/></div >
    </div>
    </s:if>
    <s:else>
    <div class="padding-left21">
      <div class="inner-list-cover">
        <div class="inner-list-left-div"><img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#msg.memberByIdMemberSender.avatarUrl"/>" alt="" width="59" height="59" border="0" align="left" class="img-border-blue" /></div>
        <div class="inner-list-right-div">
          <p><span class="size-txt12"><em><b><s:property value="#msg.memberByIdMemberSender.login" />  :</b></em></span><br />
            <s:property value="#msg.body" />
        </div>
         <div style="font-style: italic;text-align: right"> posté le : <s:property value="#datep"/></div >
      </div>
    </div>
    </s:else>
    
    </s:iterator>
    
     <div class="padding-left21">
      <div class="inner-list-cover">
        <div class="inner-list-left-div"><img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#session[@constant.Application@USER_KEY].avatarUrl"/>" alt="" width="59" height="59" border="0" align="left" class="img-border-blue" /></div>
        <div class="inner-list-right-div">
          <p><span class="size-txt12"><em><b><s:property value="#session[@constant.Application@USER_KEY].login" />  :</b></em></span><br />
            <textarea style="overflow:auto;" cols="33" rows="15"></textarea></p>
     		 <div class="mail-list-link-div">
                <input type="submit" name="button2" id="button2" value="publier" class="btn-small-gray" onclick="send_response_mail($(this).parent().parent().parent().parent(),<s:property value='mail.idMessage' />);" />
             </div>
        </div>
      </div>
    </div>
    
    
    
    </div>
    
    </div>
</body>
</html>