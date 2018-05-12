
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
         <s:iterator value="resGroup" >
                    <div class="search-tab">
                     <s:url id="show_group" action="showGroup" >
                        <s:param name="groupId" value="idGroup"/>
                     </s:url>
            
                      <table width="175" cellpadding="0" cellspacing="0" border="0">
                        <tr>
                          <td width="17" align="left" valign="top"><img src="images/blue-square.gif" alt="" border="0" /></td>
                          <td width="91" align="left" valign="top"><div class="text_single_line_group" >  <s:a href="%{show_group}"><b><span class="ellipsis_text">  <s:property value="name"/></span></b></s:a></div></td>
                          <td width="27" align="left" valign="top">&nbsp;</td>
                        </tr>
                        <tr>
                          <td align="left" valign="top">&nbsp;</td>
                          <td align="left" valign="top"><div class="text_single_line_group" > <span class="ellipsis_text">Type:  <s:property value="themes.iterator.next.name"/></span></div>
                            <div> <s:property value="members.size"/> membres</div></td>
                          <td align="left" valign="bottom"><span class="cursor" onclick="confirm_delete('<s:property value='idGroup' />','<s:property value='name' />',this);"><img src="images/cross-icon.gif" alt=""  border="0" /></span></td>
                        </tr>
                      </table>
                    </div>
                    </s:iterator>

</body>
</html>