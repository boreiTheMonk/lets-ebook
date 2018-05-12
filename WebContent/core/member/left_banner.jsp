<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="float: left;position: relative;width: 120px; z-index: 300;">
  
     <div class="entete_menu">category</div>
   <div  class="menu_content"  style="z-index: 300;">
      <page:applyDecorator page="/core/list_categories.jsp" name="empty_inline" />
     
     <div id="petitbloc">
     <page:applyDecorator page="/core/hot_book.jsp" name="empty_inline" />
     </div>
     <div id="petitbloc">
     <page:applyDecorator page="/core/member/my_friends.jsp" name="empty_inline" />
     </div>
     <page:applyDecorator page="/core/member/my_note.jsp" name="empty_inline" />
      <div id="petitbloc">
     <page:applyDecorator page="/core/member/my_groups.jsp" name="empty_inline" />
     </div>
     <page:applyDecorator page="/core/member/my_request.jsp" name="empty_inline" />

     <div style="clear: both;">
     </div>
      
   </div>
<!--     <div  class="arriere" ></div>-->
</div>
</body>
</html>