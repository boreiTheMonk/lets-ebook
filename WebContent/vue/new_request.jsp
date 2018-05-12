<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
              <div class="main-heading-div">requ&ecirc;te</div>
              <div class="top-heading-icon"><img src="images/inscription-icon.png" width="19" height="30" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="form-heading"><em>nouvelle requete pour <s:property value="showGroup.name" /></em></div>
              <form action="saveRequest" method="post"  id="login_form">
                 <input  name="groupId"  type="hidden"  value="<s:property value='groupId' />"  />
                <dl class="form">
             
             
                 
               
                  <dd >
                    <label for="title"><strong>Titre :</strong></label>
                    <div class="error_img"></div>
                    <input class="form-input1" name="rq.title" id="title" type="text" maxlength="20" value=""  />
                    <div class="msg"></div>
                  </dd>
                  <dd >
                    <label for="description""><strong>Description :</strong></label>
                    <div id="xoxo5_img"></div>
                    <input name="rq.description" id="description" type="text" maxlength="20" class="form-input1 validated"  />
                    <div class="msg"></div>
                  </dd>
             
                 
                 </dl>
                 	
               
                <div class="form-row">
                 
                  <div class="form-col-right">
                    <div class="padding-left15">
                      <input type="submit" name="button3" id="button3" value="Creer" class="btn-blue" />
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
        
</body>
</html>