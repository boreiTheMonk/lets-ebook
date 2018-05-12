<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>lets-ebook - confirmation de vente</title>

<!--COMBOBOX ATTACHED FILES-->
<link href="css/combo-box/combobox.css" rel="stylesheet" type="text/css" />

<!--FORM VALIDATION ATTACHED FILES-->
<link href="css/form-validation/formvalidation.css" rel="stylesheet" type="text/css" />


</head>
<body>
 <div id="content-area">
          <div class="none-border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Confirmation d'inscription</div>
              <div class="top-heading-icon"><img src="images/inscription-icon.png" width="19" height="30" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div style="text-align: center;margin: 10px 0;font-size: 15px">une demande d'autorisation de vente à été envoyé aux modérateur, <br/>vous serez notifié de leur réponse par email.
              merci de votre confiance<br/><br/>l'équipe lets-ebook <br/>
              
              </div>
                 	 <s:url id="show_Books" action="showMyBook" >
                        
                     </s:url>
               <form action="showMyBook" method="post" >
                <div class="form-row">
                <input type="hidden" name="bookId" value="<s:property  value='b.idBook'/>"/>
                  <div class="form-col-left">
                    <div class="padding10">
                      <input type="hidden" name="button2" id="button2" value="retour" class="btn-small-gray left" />
                    </div>
                  </div>
                  <div class="form-col-right">
                    <div class="padding-left15">
                      <input type="submit" name="button3" id="button3" value="mon livre" class="btn-blue" />
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
        
</body>
</html>