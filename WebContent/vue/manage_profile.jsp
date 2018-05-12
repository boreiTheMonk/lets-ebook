
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

   
     
        <title>gestion profil</title>
       
           	<script type="text/javascript" src="javascript/jquery.validate.js"></script>
<script type="text/javascript" src="javascript/jquery.i18n.properties-1.0.4.js"></script>
        <script type="text/javascript" src="<s:url value='/vue/manage_profile.js'/>"></script>

<link href="<s:url value='/jquery/juploadify/css/default.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/jquery/juploadify/css/uploadify.css'/>" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<s:url value='/jquery/juploadify/scripts/swfobject.js'/>"></script>
<script type="text/javascript" src="<s:url value='/jquery/juploadify/scripts/jquery.uploadify.v2.1.0.min.js'/>"></script>
   
   
 <!--COMBOBOX ATTACHED FILES-->
<link href="css/combo-box/combobox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/combo-box/jquery.dimensions.js"></script>
<script type="text/javascript" src="js/combo-box/jquery.combobox.pikabu.js"></script>
<!--FORM VALIDATION ATTACHED FILES-->
<link href="css/form-validation/formvalidation.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/form-validation/formvalidation.js"></script>
<script type="text/javascript" src="javascript/jquery.i18n.properties-1.0.4.js"></script>
  <script type="text/javascript" src="javascript/jquery.validate.js"></script>
<script type="text/javascript" >
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
	 $("#updateUser_form").validate({

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
		      'me.name': "required",
		      'me.lastName': "required",
		      'me.email': {
		        required: true,
		        email: true
		      },
		      
		      
		     
		     'passwordConfirm': 
		     {
		          equalTo: "#me\\.password"
		    
		     }
		     //,'imageMember': "required"
		    
		    },
		    messages: {
		      'me.name': "champ requis",
		      'me.lastName': "champ requis",
		      'me.email': {
		        required: "champ requis",
		        email: "champ incorrect"
		      },
		    'emailConfirm': "champ pas identique",
		   
		    'passwordConfirm': "champ requis"
		  // , 'imageMember': "champ requis"
			    

		    }
		 });

	/*	$('#officeItemList2').combobox( { 
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
              <div class="main-heading-div">Editer Profil <s:property value='me.login'/></div>
              <div class="top-heading-icon"><img src="images/inscription-icon.png" width="19" height="30" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="form-heading"><em>Editer Profil :</em></div>
              <form action="updateUser" id="updateUser_form" method="post" enctype="multipart/form-data">
                <dl class="form">
                  <dd >
                    <label for="me.name"><strong>nom :</strong></label>
                    <div id="xoxo1_img"></div>
                    <input class="form-input1 " name="me.name" id="me.name" type="text"  value="<s:property value='me.name'/>"  />
                    <div id="xoxo1_msg" class="msg"></div>
                  </dd>
                  <dd class="validated" id="xoxo2_li">
                    <label for="me.lastName"><strong>prénom :</strong></label>
                    <div id="xoxo2_img"></div>
                    <input name="me.lastName" id="me.lastName" type="text" value="<s:property value='me.lastName'/>"  class="form-input1 validated"  />
                    <div  class="msg"></div>
                  </dd>
                  <dd >
                    <label ><strong>sexe :</strong></label>
                    <div id="xoxo3_img"></div>
                    
                    <input type="radio" name="me.gender" <s:if test="me.gender =='m'"> checked="checked" </s:if> value="m"  />
                    &nbsp;<b>M</b>
                    <input type="radio" name="me.gender" value="f" <s:if test="me.gender =='f'"> checked="checked" </s:if>/>
                    &nbsp;<b>F</b>
                    <div  class="msg"></div>
                  </dd>
                  <dd >
                    <label for="me.birth"><strong>date de naissance (dd/mm/yyyy):</strong></label>
                    <div id="xoxoDate_img"></div>
                    <input name="me.birth" id="me.birth" value="<s:property value='me.birth'/>" type="text" maxlength="20" class="form-input1 validated"  />
                    <div class="msg"></div>
                  </dd>
                  <dd >
                    <label for="me.description"><strong>présentation :</strong></label>
                    <div id="textArea2_img"></div>
                    <textarea name="me.description" id="me.description"  cols="45" rows="5" class="form-text-area1 validated"><s:property value='me.description'/></textarea>
                    <div  class="msg"></div>
                  </dd>
                  <dd class="fav_book">
                    <label ><strong>livre favoris :</strong></label>
                    <div id="Double1_img"></div>
                    <div class="combo-cover">
                      <input name="nameBook" type="text" class="form-input1 validated" id="Double1" value="<s:property value='nameBook[0]'/>" />
                    </div>
                    <div  class="msg"></div>
                  </dd>
                 <s:iterator value="nameBook" begin="1">
                
                 <dd class="fav_book">
                 <label><strong>&nbsp;</strong>
                 </label>
                 <div class="combo-cover">
                 	<input name="nameBook" class="form-input1" type="text" value="<s:property />"/> </div> 
                 </dd>
                 
                  </s:iterator>
                  <s:if test="nameBook.size >0">
                   <dd class="fav_book">
                    <label ><strong>&nbsp;</strong></label>
                    <div class="combo-cover">
                      <input name="nameBook" type="text" class="form-input1" />
                    </div>
                  </dd>
                  
                  </s:if>
                  
                
                  <dd class="fav_author">
                    <label ><strong>auteurs favoris :</strong></label>
                    <div class="combo-cover">
                      <input name="nameAuthor" type="text" class="form-input1" value="<s:property  value='nameAuthor[0]' />"/>
                    </div>
                  </dd>
                  
                  <s:iterator value="nameAuthor" begin="1">
                
                 <dd class="fav_author">
                 <label><strong>&nbsp;</strong>
                 </label>
                 <div class="combo-cover">
                 	<input name="nameAuthor" class="form-input1" type="text" value="<s:property />"/> </div> 
                 </dd>
                 
                  </s:iterator>
                  
                  <s:if test="nameAuthor.size >0">
                   <dd class="fav_author">
                    <label ><strong>&nbsp;</strong></label>
                    <div class="combo-cover">
                      <input name="nameAuthor" type="text" class="form-input1" />
                    </div>
                  </dd>
                  
                  </s:if>
               
                  <dd >
                    <label for="me.email"><strong>adresse email :</strong></label>
                    <div id="xoxo4_img"></div>
                    <input class="form-input1 validated" name="me.email" id="me.email" type="text" maxlength="60" value="<s:property value='me.email'/>"  />
                    <div id="xoxo4_msg" class="msg"></div>
                  </dd>
                  
                  <!--
                  
                  <dd >
                    <label for="emailConfirm"><strong>confirmation mail :</strong></label>
                    <div id="xoxo5_img"></div>
                    <input name="emailConfirm" id="emailConfirm" value="<s:property value='emailConfirm'/>"  type="text" maxlength="60" class="form-input1 validated"  />
                    <div class="msg"></div>
                  </dd>
                  
                  
                  -->
                  
                  <dd >
                    <label for="me.password"><strong>mot de passe :</strong></label>
                    <div ></div>
                    <input  name="me.password" id="me.password"  type="password"   class="form-input1 validated" />
                    <div  class="msg"></div>
                  </dd>
                  <dd class="validated" id="xoxo7_li">
                    <label for="passwordConfirm"><strong>confirmation du mot de passe :</strong></label>
                    <div id="xoxo7_img"></div>
                    <input name="passwordConfirm"  id="passwordConfirm" type="password"  class="form-input1 validated"  />
                    <div  class="msg"></div>
                  </dd>
                </dl>
       
                <dl class="form">
                  <dd class="validated" id="xoxoFile3_li">
                    <label for="xoxoFile3"><strong>avatar :</strong></label>
                    <div id="xoxoFile3_img"></div>
                    <input type="file" name="imageMember" id="imageMember" class="form-input-file validated" />
                    <div id="xoxoFile3_msg" class="msg"></div>
                  </dd>
                </dl>
                <div class="combo-row" style="display: none;">
                  <div class="combo-col-left"><strong>xxxxxx :</strong></div>
                  <div class="combo-col-right">
                    <select name="officeItemList3" class="validated" id="officeItemList3">
                      <option value="1">Xoxoxo</option>
                      <option value="3">Xoxoxoxo</option>
                      <option value="4">Xoxo</option>
                      <option value="5">Xoxox</option>
                    </select>
                  </div>
                </div>
                <!--
                <dl class="form">
                  <dd class="validated" id="xoxo8_li">
                    <label for="xoxo8"><strong>avatar :</strong></label>
                    <div id="xoxo8_img"></div>
                    <input class="form-input1 validated" name="xoxo8" id="xoxo8" type="text" maxlength="20" value=""  />
                    <div id="xoxo8_msg" class="msg"></div>
                  </dd>
                  <dd class="validated" id="xoxo9_li">
                    <label for="xoxo9"><strong>xxxxxx :</strong></label>
                    <div id="xoxo9_img"></div>
                    <input name="xoxo9" id="xoxo9" type="text" maxlength="20" class="form-input1 validated"  />
                    <div id="xoxo9_msg" class="msg"></div>
                  </dd>
                </dl>
                -->
                <div class="form-row">
                  <div class="form-col-left" style="visibility: hidden;">
                    <div class="padding10">
                      <input type="submit" name="button2" id="button2" value="Xoxox" class="btn-small-gray left" />
                    </div>
                  </div>
                  <div class="form-col-right"  >
                    <div class="padding-left15">
                      <input type="submit" name="button3" id="button3" value="valider" class="btn-blue" />
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
       
    </body>
</html>
