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


    <s:iterator value="resMember" >
    <s:url id="url_show_author" action="show_author" >
                        <s:param name="idMember" value="idMember"/>
                     </s:url>
                     <div class="amis-tab">
    				<s:if test="avatarUrl!=null">
                      <s:a href="%{url_show_author}"><img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="avatarUrl"/>" alt="" border="0" class="img-border-gray" height="48px" width="48px" /></s:a> 
                   </s:if>
                   <s:else>
                   <s:a href="%{url_show_author}"><img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" height="48px" width="48px" /></s:a> 
                   </s:else>
                   
                    <div class="text_name_avatar" style="width: 50px;padding: 1px;word-wrap:break-word;"> <span class="ellipsis_text"> <s:property value="login"/></span></div>
                    </div>
   </s:iterator> 
 <% /*  <table style="border:solid">
  <s:iterator value="resMember">
            <tr >
                 <td>
                     <div id="test">	<a href="index.php?page=descAuteur"><img src="media/auteur.png" /></a></div>
                </td>
                <td>
                    <div style="border:solid">
                        <s:property value="name"/> <s:property value="lastname"/>,<br>
                         points centre interet, livre majeur
                    </div>
                </td>

            </tr>
     </s:iterator>      
       </table>
       */ %>
</body>
</html>