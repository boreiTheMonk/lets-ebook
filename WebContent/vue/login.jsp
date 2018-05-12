<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>lets-ebook login</title>

<!--COMBOBOX ATTACHED FILES-->
<link href="css/combo-box/combobox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/combo-box/jquery.dimensions.js"></script>
<script type="text/javascript" src="js/combo-box/jquery.combobox.pikabu.js"></script>
<!--FORM VALIDATION ATTACHED FILES-->
<link href="css/form-validation/formvalidation.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/form-validation/formvalidation.js"></script>
<script type="text/javascript" src="javascript/jquery.i18n.properties-1.0.4.js"></script>
  <script type="text/javascript" src="javascript/jquery.validate.js"></script>
<script type="text/javascript" language="javascript">
$(function() {
//$(".validated").blur(function() {
//$(this).validate.init(this);});

//add blue hover in the form
//$(".form dd").mouseover(function() {$(this).addClass("selected");});
//$(".form dd").mouseout(function() {
//$(this).removeClass("selected");});

 $("#login_form").validate({

showErrors: function(errorMap, errorList) {
	
var output = '';
for (property in errorMap) {
  //output += property + ': ' + errorMap[property]+'; ';
 // $("#"+property).val("toto");

  //remplace . by \\. to interpret #m.att and not #m with att class
  element=property.replace(/\./,"\\.");
  $("[name="+element+"]").parent().addClass("error");
  $("[name="+element+"]").siblings(".msg").html(errorMap[property]);
}
tab=this.validElements();
console.log(tab);
for (i =0; i < tab.length ; i++) {
	
	$(this.validElements()[i]).parent().removeClass("error");
	 $(this.validElements()[i]).siblings(".msg").html("");
}

		},
   rules: {
   
     'm.login': "required",
     'm.password': "required"
   
   
   },
   messages: {
     'm.login': jQuery.i18n.prop('error.form.name'),
     'm.password': "renseignez le mot de passe"
     

   }
});


});
</script>

</head>
<body>
 <div id="content-area">
          <div class="none-border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Login</div>
              <div class="top-heading-icon"><img src="images/inscription-icon.png" width="19" height="30" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="form-heading"><em>Login :</em></div>
              <form action="verifLogin" method="post"  id="login_form">
                <dl class="form">
             
             
                 
               
                  <dd >
                    <label for="m.login"><strong>login :</strong></label>
                    <div class="error_img"></div>
                    <input class="form-input1" name="m.login" id="login" type="text" maxlength="20" value=""  />
                    <div class="msg"></div>
                  </dd>
                  <dd >
                    <label for="m.password"><strong>mot de passe :</strong></label>
                    <div id="xoxo5_img"></div>
                    <input name="m.password" id="password" type="password" maxlength="20" class="form-input1 validated"  />
                    <div class="msg"></div>
                  </dd>
                
                 
                 </dl>
                   <dl class="form">
                  <dd class="validated" id="xoxoFile3_li">
                    <label for="xoxoFile3"><strong> &nbsp;</strong></label>
                    <div id="xoxoFile3_img"></div>
                    <input type="checkbox"  name="stay"   value="true"  class="form-input-file validated" /> &nbsp;rester connect&eacute;
                    <div id="xoxoFile3_msg" ></div>
                  </dd>
                </dl>
                <dl class="form">
                  <dd class="fav_book">
                 <label><strong>&nbsp;</strong>
                 </label>
                 <div class="combo-cover">
                 	<i><a href="javascript:centerLoginPopup(); loadLoginPopup(); show_lost_passForm();"  >mot de passe oublié</a></i> </div> 
                 <div class="combo-cover">
                 	<i><a href="show_inscription"  >pas encore inscrit...</a></i> </div> 
                
                 </dd>
                </dl>
                 	
               
                <div class="form-row">
                  <div class="form-col-left">
                    <div class="padding10">
                      <input type="hidden" name="button2" id="button2" value="retour" class="btn-small-gray left" />
                    </div>
                  </div>
                  <div class="form-col-right">
                    <div class="padding-left15">
                      <input type="submit" name="button3" id="button3" value="Login" class="btn-blue" />
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
        
</body>
</html>