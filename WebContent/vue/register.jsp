<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Inscription</title>

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

var classDesc= new Array();

<s:iterator value="classes" var="c" status="stat">
classDesc['<s:property value="#c.idClass"/>']="<s:property value='#c.description' escape='false' />";
</s:iterator  >

function showDescription(){
 	
	var choiceClass=$("#idClass").val();
	//alert( choiceClass);
	$("#description").html(classDesc[choiceClass]);
}

$(function() {
//$(".validated").blur(function() {
//$(this).validate.init(this);});

//add blue hover in the form
//$(".form dd").mouseover(function() {$(this).addClass("selected");});
//$(".form dd").mouseout(function() {
//$(this).removeClass("selected");});

$.validator.addMethod(
        "regex",
        function(value, element, regexp) {
            var check = false;
            var re = new RegExp(regexp);
            return this.optional(element) || re.test(value);
        },
        "Veuillez enlever les accents."
);


 $("#register_form").validate({

showErrors: function(errorMap, errorList) {
	
var output = '';
for (property in errorMap) {
  //output += property + ': ' + errorMap[property]+'; ';
 // $("#"+property).val("toto");

  //remplace . by \\. to interpret #m.att and not #m with att class
  element=property.replace(/\./,"\\.");
  $("#"+element).parent().addClass("error");
  $("#"+element).siblings(".msg").html(errorMap[property]);
}
tab=this.validElements();
//console.log(tab);
for (i =0; i < tab.length ; i++) {
	
	$(this.validElements()[i]).parent().removeClass("error");
	 $(this.validElements()[i]).siblings(".msg").html("");
}

		},
   rules: {
     'm.name': "required",
     'm.lastName': "required",
     'm.email': {
       required: true,
       email: true
     },
     
     'emailConfirm': {
         equalTo: "#m\\.email"
       
       
      
     },
     'm.login': {
    	 required: true,
         regex: /^[A-Za-z0-9_-]*$/ },
     'm.password': "required",
    'passwordConfirm': 
    {
         equalTo: "#m\\.password"
      
      
     
    },
     'ok_ok': "required"
   
   },
   messages: {
     'm.name': "champ obligatoire",
     'm.lastName': "champ obligatoire",
     'm.email': {
       required: "champ obligatoire",
       email: "mauvais format"
     },
     'emailConfirm': "les emails ne correspondent pas",
     'm.login': {
    	 required: "champ obligatoire",
    	 regex:"caractères autorisés a-z, _ et - "
         },
     'm.password': "champ obligatoire",
     'passwordConfirm': "les mots de passe ne correspondent pas"
	
   }
});


/*$('#officeItemList2').combobox( { 
	comboboxContainerClass: "comboboxContainer", 
	comboboxValueContainerClass: "comboboxValueContainer", 
	comboboxValueContentClass: "comboboxValueContent", 
	comboboxDropDownClass: "comboboxDropDownContainer", 
	comboboxDropDownButtonClass: "comboboxDropDownButton", 
	comboboxDropDownItemClass: "comboboxItem", 
	comboboxDropDownItemHoverClass: "comboboxItemHover", 
	comboboxDropDownGroupItemHeaderClass: "comboboxGroupItemHeader", 
	comboboxDropDownGroupItemContainerClass: "comboboxGroupItemContainer", 
	animationType: "slide", 
	width: "151px" }); 
	$('#officeItemList3').combobox( { 
	comboboxContainerClass: "comboboxContainer", 
	comboboxValueContainerClass: "comboboxValueContainer", 
	comboboxValueContentClass: "comboboxValueContent", 
	comboboxDropDownClass: "comboboxDropDownContainer", 
	comboboxDropDownButtonClass: "comboboxDropDownButton", 
	comboboxDropDownItemClass: "comboboxItem", 
	comboboxDropDownItemHoverClass: "comboboxItemHover", 
	comboboxDropDownGroupItemHeaderClass: "comboboxGroupItemHeader", 
	comboboxDropDownGroupItemContainerClass: "comboboxGroupItemContainer", 
	animationType: "slide", 
	width: "151px" }); */


});
</script>

</head>
<body>
 <div id="content-area">
          <div class="none-border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">inscription</div>
              <div class="top-heading-icon"><img src="images/inscription-icon.png" width="19" height="30" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="form-heading"><em>formulaire d'inscription :</em></div>
              <form action="save_register" method="post"  id="register_form" enctype="multipart/form-data">
                <dl class="form">
                  <dd  >
                  <input type="hidden" name="referee" value="<s:property value="referee"/>">
                		<span style="color: red;"><s:actionerror/></span>
                  </dd>
                 
                  <dd  >
                    <label for="m.name"><strong>nom :</strong></label>
                    <div class="error_img"></div>
                    <input class="form-input1 " name="m.name" id="m.name" type="text" maxlength="50" value="<s:property value="m.name"/>"  />
                    <div  class="msg"></div>
                  </dd>
                  <dd  >
                    <label for="m.lastName"><strong>pr&eacute;nom :</strong></label>
                    <div class="error_img"></div>
                    <input name="m.lastName" id="m.lastName" type="text" maxlength="50" class="form-input1 "  value="<s:property value="m.lastName"/>" />
                    <div  class="msg"></div>
                  </dd>
             
                  <dd  >
                    <label for="m.email"><strong>email :</strong></label>
                    <div class="error_img"></div>
                    <input name="m.email" id="m.email" type="text"  class="form-input1 "  value="<s:property value="m.email"/>" />
                    <div  class="msg"></div>
                  </dd>
                  <dd class="validated" id="textArea2_li">
                    <label for="emailConfirm"><strong>confirmation email :</strong></label>
                    <div class="error_img"></div>
                    <input name="emailConfirm" id="emailConfirm" type="text" 
 class="form-input1 validated"  />
                    <div  class="msg"></div>
                    
                  </dd>
                <dd style="display: none">
                    <label for="b.nbPages"><strong>radio :</strong></label>
                    <div class="error_img"></div>
                    <s:radio cssStyle="{display: block;}" label="Group"   name="groupSelect"   list="#{'true':'Yes', 'false':'No'}"   /> 

                    <div  class="msg"></div>
                  </dd>
                  <dd >
                    <label for="m.login"><strong>login :</strong></label>
                    <div class="error_img"></div>
                    <input class="form-input1" name="m.login" id="m.login" type="text" value="<s:property value="m.login"/>" maxlength="20"   />
                    <div class="msg"></div>
                  </dd>
                  <dd >
                    <label for="m.password"><strong>mot de passe :</strong></label>
                    <div id="xoxo5_img"></div>
                    <input name="m.password" id="m.password" type="password"  class="form-input1 validated"  />
                    <div class="msg"></div>
                  </dd>
                  <dd class="validated" id="xoxo6_li">
                    <label for="passwordConfirm"><strong>confirmation du mot de passe :</strong></label>
                    <div id="xoxo6_img"></div>
                    <input class="form-input1 validated" name="passwordConfirm" id="passwordConfirm" type="password" value=""  />
                    <div class="msg"></div>
                  </dd>
                
                </dl>
                <div class="combo-row">
                  <div class="combo-col-left"><strong>classe :</strong></div>
                  <div class="combo-col-right">
                    <div class="left margin-left-5">
                      <select name="idClass" class="validated" id="idClass" onchange="showDescription();">
                         <s:iterator value="classes" var="c" status="stat">
					<option value="<s:property value="idClass" />"><s:property value="name" /></option>
     
					</s:iterator>
                      </select>
                      <div id="description"></div>
                    </div>
                  </div>
                </div>
                <dl class="form">
                  <dd class="validated" id="xoxoFile3_li">
                    <label for="xoxoFile3"><strong>avatar :</strong></label>
                    <div id="xoxoFile3_img"></div>
                    <input type="file" name="imageMember" id="imageMember" class="form-input-file validated" />
                    <div id="xoxoFile3_msg" class="msg"></div>
                  </dd>
                </dl>
                 <dl class="form">
                  <dd class="validated" id="xoxoFile3_li">
                  <iframe width="580px" height="300px" src="cgu?my_deco=empty_inline" >   </iframe>
                  </dd>
                </dl>
                 <dl class="form">
                  <dd class="validated" id="xoxoFile3_li">
                    <label for="xoxoFile3"><strong> &nbsp;</strong></label>
                    <div id="xoxoFile3_img"></div>
                    <input type="checkbox" name="ok_ok" id="ok_ok"  class="form-input-file validated" /> &nbsp;j'accepte les conditions d'utilisation
                    <div id="xoxoFile3_msg" ></div>
                  </dd>
                </dl>
                <div class="combo-row" style="visibility: hidden;">
                  <div class="combo-col-left"><strong>s&eacute;lectionner pays :</strong></div>
                  <div class="combo-col-right">
                    <div class="left margin-left-5">
                      <select name="officeItemList2" class="validated" id="officeItemList2" >
                      
                      </select>
                    </div>
                  </div>
                </div>
                
                
                 
                
               
                <div class="form-row">
                  <div class="form-col-left">
                    <div class="padding10">
                      <input type="hidden" name="button2" id="button2" value="retour" class="btn-small-gray left" />
                    </div>
                  </div>
                  <div class="form-col-right">
                    <div class="padding-left15">
                      <input type="submit" name="button3" id="button3" value="Inscription" class="btn-blue" />
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
        
</body>
</html>