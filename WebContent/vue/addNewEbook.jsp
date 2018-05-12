<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
      
        <title>ajouter un nouveau livre</title>
         <script type="text/javascript" src="javascript/jquery.validate.js"></script>
<script type="text/javascript" src="javascript/jquery.i18n.properties-1.0.4.js"></script>

<script type="text/javascript">
var categories= new Array();
var subCategories= new Array();
<s:set name="i" value="0"/>

<s:iterator value="#application['catList']" var="c" status="stat">
categories[<s:property value="#stat.index" />]="<s:property value="name" />";
     	<s:if test="!#c.categories.isEmpty">
     	
			<s:iterator value="categories" var="subC" status="stat2">
			 subCategories[<s:property value="#i"/>]=new Array();
			subCategories[<s:property value="#i"/>]["id"]="<s:property escape="false" value="#c.idCategory"/>" ;
			subCategories[<s:property value="#i"/>]["value"]="<s:property escape="false" value="#subC.idCategory"/>" ;
			subCategories[<s:property value="#i"/>]["text"]="<s:property escape="false" value="#subC.name"/>" ;
			<s:set name="i" value="#i+1"/>
			</s:iterator>
     	</s:if>
	</s:iterator>

	function clearbox( name_select)
	{
	   // Set select to the element "selectbox."
	   var select=document.getElementById(name_select);
	   // Set options to an array of all "option" tags that
	   // are children of the select element.
	   var options=select.getElementsByTagName("option");
	   var i;
	   // Loop through the array of options and remove each
	   // each one from the parent's childNode list.
	   for (i=0; i < options.length ; i++)
	   {
	      select.removeChild(options[i]);
	   }// end for i
	   select.innerHTML="";
	}// end clearbox

	function updateSubCategories(){
		id_category = document.getElementById('category').options[document.getElementById('category').selectedIndex].value;
		select_rubrique=document.getElementById("subCategory");
		//select_rubrique.options = [];
		clearbox("subCategory");
		j=0;
		//if 0 means no sub category found
		bool=0;
		for (i=0;i < subCategories.length ; i++){
			
			if(subCategories[i]['id']==id_category){
				bool=1;
				opt = new Option();
				opt.value = subCategories[i]['value'];
				opt.text = subCategories[i]['text'];
				select_rubrique.options[j] = opt;
				j++;
				//select_rubrique.options[2] = opt;
			}
			
		}
		if(bool==0){
			opt = new Option();
			opt.value = id_category;
			opt.text = "";
			select_rubrique.options[0] = opt;
			}
	}

	
	
</script>
<!--COMBOBOX ATTACHED FILES-->
<link href="css/combo-box/combobox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/combo-box/jquery.dimensions.js"></script>
<script type="text/javascript" src="js/combo-box/jquery.combobox.pikabu.js"></script>
<!--FORM VALIDATION ATTACHED FILES-->
<link href="css/form-validation/formvalidation.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/form-validation/formvalidation.js"></script>
  <script type="text/javascript" src="javascript/jquery.validate.js"></script>
<script type="text/javascript" >

	$(document).ready(function() {
		//check if checkbox author is cliqued
		change_disabed_author();
		
		updateSubCategories();
		$('#category').change(function(){
			updateSubCategories();
		});
		/*$('#category').combobox( { 
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
	

			$('#subCategory').combobox( { 
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
				width: "151px" });*/


		 $("#form_add_book").validate({

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
			      'b.title': "required",
			      
			      'b.nbPages': {
			        required: true,
			        digits: true
			      },
			      
			      
			     
			      'bookFile': "required",
			      'b.description': "required",
			    	  'b.author': "required"
			    
			    },
			    messages: {
			      'b.title': "champ requis",
			      'me.lastName': "champ requis",
			      'b.nbPages': {
				        required: "champ requis",
				        digits: "donnez un entier"
				      },
			   
			    'bookFile': "champ requis",
			    'b.description': "champ requis",
		    	  'b.author': "champ requis"
			    
				    

			    }
			 });



		});

	function change_disabed_author(){

		
		if($("#b\\.isMine:checked'").val()=="true"){
			$("#b\\.author").attr("disabled", true);
			}
		else{
			$("#b\\.author").removeAttr("disabled"); 
			}
		}

</script>
    </head>
    <body>
    <div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Upload</div>
              <div class="top-heading-icon"><img src="images/upload-icon.png" width="36" height="29" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="form-heading"><em>Ajouter un livre</em></div>
              <form  method="post" id="form_add_book" action="addbook"  enctype="multipart/form-data">
                <dl class="form">
                      <dd >
             <s:actionerror/>
        			
        			<s:fielderror></s:fielderror>
                  </dd>
                  <dd >
                    <label for="b.title"><strong>titre :</strong></label>
                    <div class="error_img"></div>
                    <input class="form-input1 validated" name="b.title" id="b.title" type="text"  value="<s:property value="b.title" />"  />
                    <div class="msg"></div>
                  </dd>
                  <dd >
                    <label for="b.nbPages"><strong>nombre de pages :</strong></label>
                    <div class="error_img"></div>
                    <input name="b.nbPages" id="b.nbPages" type="text" maxlength="20" class="form-input1 validated" value="<s:property value="b.nbPages" />"  />
                    <div  class="msg"></div>
                  </dd>
                  <dd >
                    <label for="bookFile"><strong>lien :</strong></label>
                    <div class="error_img"></div>
                    <input type="file" name="bookFile" id="bookFile" class="form-input-file validated" />
                    <div class="msg"></div>
                  </dd>
                  <dd >
                    <label for="image"><strong>image :</strong></label>
                    <div class="error_img"></div>
                    <input type="file" name="image" id="image" class="form-input-file validated" />
                    <div  class="msg"></div>
                  </dd>
                </dl>
                <div class="combo-row">
                  <div class="combo-col-left"><strong>catégorie :</strong></div>
                  <div class="combo-col-right">
                    <div class="left margin-left-5">
                      <select name="category"  id="category">
                     <s:iterator value="#application['catList']" var="c" status="stat">
					<option value="<s:property value="idCategory" />"><s:property value="name" /></option>
     
					</s:iterator>
                      </select>
                    </div>
                  </div>
                </div>
                 <div class="combo-row">
                  <div class="combo-col-left"><strong>sous catégorie :</strong></div>
                  <div class="combo-col-right">
                    <div class="left margin-left-5">
                      <select name="id_category"  id="subCategory">
                        <option value="1">Xoxoxo</option>
                        <option value="3">Xoxoxoxo</option>
                        <option value="4">Xoxo</option>
                        <option value="5">Xoxox</option>
                      </select>
                    </div>
                  </div>
                </div>
                
                <dl class="form">
                  <dd >
                    <label for="b.description"><strong>description :</strong></label>
                    <div class="error_img"></div>
                    <textarea name="b.description" id="b.description" cols="45" rows="5" class="form-text-area1 validated"><s:property value="b.description" /></textarea>
                    <div  class="msg"></div>
                  </dd>
                 <dd >
                    <label ><strong>je suis l'auteur :</strong></label>
                    <div id="xoxo3_img"></div>
                    
                    <input type="checkbox" onclick="change_disabed_author()" id="b.isMine" name="b.isMine" <s:if test="b.isMine ==true"> checked="checked" </s:if> value="true"  />
                    <div  class="msg"></div>
                  </dd>
                   <dd >
                    <label for="b.author"><strong>auteur :</strong></label>
                    <div class="error_img"></div>
                    <input name="b.author" id="b.author" type="text" maxlength="50" class="form-input1 validated"  />
                    <div  class="msg"></div>
                  </dd>
                          <dd >
                    <label ><strong>vendre le livre :</strong></label>
                    <div id="xoxo3_img"></div>
                    
                    <input type="checkbox"  id="b.isSell" name="b.isSell" <s:if test="b.isSell ==true"> checked="checked" </s:if> value="true"  />
                    <div  class="msg"></div>
                  </dd>
                </dl>
                
                <div class="form-row">
                  <p class="txt-center" id="form-note"><img src="images/exclamation.gif" alt="" border="0"  /> veuillez vous référer aux conditions générales d'utilisation</p>
                </div>
                <div class="combo-row">
                  <div class="combo-col-left"></div>
                   <div class="combo-row center">
                 <input name="button3" type="submit" class="btn-large-red" id="button3" value="valider!" />
                 
                </div>
                </div>
              </form>
            </div>
          </div>
        </div>
       
            </body>
</html>

