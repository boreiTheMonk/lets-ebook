 <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>lets ebook - annulation paiement</title>

<!--COMBOBOX ATTACHED FILES-->
<link href="css/combo-box/combobox.css" rel="stylesheet" type="text/css" />

<!--FORM VALIDATION ATTACHED FILES-->
<link href="css/form-validation/formvalidation.css" rel="stylesheet" type="text/css" />


</head>
<body>
 <div id="content-area">
          <div class="none-border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">annulation</div>
              <div class="top-heading-icon"><img src="images/upload-icon.png"   alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div style="text-align: center;margin: 10px 0;font-size: 15px">votre commande a été annulé. </div>
                 	
               <form action="showBook" >
                <div class="form-row">
                  <div class="form-col-left">
                    <div class="padding10">
                     <input type="hidden" name="bookId" id="button2" value="<s:property value='bookId'/>" class="btn-small-gray left" />
                      <input type="hidden" name="button2" id="button2" value="retour" class="btn-small-gray left" />
                    </div>
                  </div>
                  <div class="form-col-right">
                    <div class="padding-left15">
                      <input type="submit" name="button3" id="button3" value="revenir au livre" class="btn-large-blue" />
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
        
</body>
</html>