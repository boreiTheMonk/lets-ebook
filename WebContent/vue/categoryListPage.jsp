<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <s:iterator value="listCat" var="c">
     <div>     
         
          <ul>
          <s:url id="editBook" action="showBooks_by_Category" >
                  <s:param name="id_category" value="idCategory"/>
              </s:url>
             
              
              
              
          	<li><s:a href="%{editBook}"><s:property value="name"/></s:a>
          	</li>
          	<s:if test="!#c.categories.isEmpty">
          	
				<ul>
				<s:iterator value="categories" var="subC">
					<s:url id="editBooksubC" action="showBooks_by_Category" >
	                	<s:param name="id_category" value="#subC.idCategory"/>
	              	</s:url>
				
					<li><s:a href="%{editBooksubC}"><s:property value="#subC.name"/></s:a> </li>
					
					<s:iterator value="#subC.categories" var="subSubC">
					<ul>
						<li><s:property value="#subSubC.name"/> </li>
					</ul>
					</s:iterator>
				</s:iterator>
				</ul>
				
          	
          	</s:if>
          </ul>
            
            
        
          
     
 </div>
		</s:iterator>
		
		
          
</body>
</html>