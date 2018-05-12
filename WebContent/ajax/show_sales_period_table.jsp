<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  
<table class="table_sales" summary="Employee Pay Sheet">
    <thead class="blue-txt">
    	<tr>
        	<th scope="col">Titre</th>
            <th scope="col">Prix de vente</th>
            <th scope="col">Date</th>
            <th scope="col">Gains</th>
            <th scope="col">Payé</th>
        </tr>
    </thead>
    <tbody>
      <s:iterator value="orderbooks" var="ob">
    	<tr>
        	<td><s:property value="#ob.name"/></td>
            <td><s:property value="#ob.price"/></td>
            <td><s:property value="#ob.orderCustomer.dateOrder"/></td>
            <td><s:property value="#ob.price*0.85"/></td>
            <td><s:if test="#ob.isTreated!=false">oui</s:if><s:else>non</s:else></td>
        </tr>

      </s:iterator>
    </tbody>
</table>

</body>
</html>