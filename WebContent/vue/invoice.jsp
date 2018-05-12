<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>lets-ebook - facture</title>
<style type="text/css">
<!--
body {
  font-family:Tahoma;
}

img {
  border:0;
}

#page {
  width:800px;
  margin:0 auto;
  padding:15px;

}

#logo {
  float:left;
  margin:0;
}

#address {
 
  height:181px;
  margin-left:280px; 
}

table {
  width:100%;
}

td {
padding:5px;
}

tr.odd {
  background:#e1ffe1;
}
-->
</style>
</head>
<body>
<div id="page">
  <div id="logo">
    <a href="http://www.lets-ebook.com"><img src="images/logo.png"></a>
  </div><!--end logo-->
  
  <div id="address">

    <p>MultiDB <br />
    <a href="mailto:contact@multidb.fr">contact@multidb.fr</a>
    <br /><br />
    Commande # <s:property value="myorderCustomer.refOrder"/><br />
    <s:date name="myorderCustomer.dateOrder" format="dd/MM/yyyy" var="orderDate"/>
    créé le <s:property value="#orderDate"/><br />
    </p>

  </div><!--end address-->

  <div id="content">
    <p>
      <strong>Détail client</strong><br />
      Nom: <s:property value="myorderCustomer.member.name"/>, <s:property value="myorderCustomer.member.lastName"/><br />
      Email: <s:property value="myorderCustomer.member.email"/><br />
      Paiement: carte de crédit  </p>

    <hr>
    <table>
      <tr>
      	<td><strong>Description</strong></td>
      	<!--   <td><strong>Qty</strong></td>
      	<td><strong>Unit Price</strong></td>-->
      	<td><strong>Prix</strong>
      	</td>
      </tr>
       <s:iterator value="myorderCustomer.orderBooks" >
      <tr class="odd">
      	<td><s:property value="name"/></td>
      	<td><s:property value="price"/> EUR </td>
      	
      	<% 
      	//</tr><tr class="even"><td>..<td>
      	//<td>4.95</td>
      	
      	%>
      	
      	</tr>
      	</s:iterator>
 		<tr><td>&nbsp;</td><td>&nbsp;</td><td><strong>Total</strong></td><td><strong><s:property value="myorderCustomer.price"/> EUR</strong></td></tr>
    </table>
    <hr>
    <p>
      Merci pour votre achat!  cette transction apparaîtra comme intitulé "lets ebook".<br />
      Pour des questions supplémentaires, veuillez nous contacter sur <a href="mailto:contact@multidb.fr">contact@multidb.fr</a>.
    </p>

    <hr>

  </div><!--end content-->
</div><!--end page-->
</body>

</html>