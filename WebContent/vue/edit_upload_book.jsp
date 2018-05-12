<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>edition de  livre</title>
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
			subCategories[<s:property value="#i"/>]["id"]="<s:property value="#c.idCategory"/>" ;
			subCategories[<s:property value="#i"/>]["value"]="<s:property value="#subC.idCategory"/>" ;
			subCategories[<s:property value="#i"/>]["text"]="<s:property value="#subC.name"/>" ;
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
<script type="text/javascript" >

	$(document).ready(function() {
		updateSubCategories();

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
		});

</script>
    </head>
    <body>
    <div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Livre</div>
              <div class="top-heading-icon"><img src="images/upload-icon.png" width="36" height="29" alt="" border="0" class="margin-top-5" /></div>
           	<div class="tabs-nav"><a class="tab-select">Upload</a><a href="showEditBook?bookId=<s:property value='bookId' />" >Informations</a></div>
            </div>
          	
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="form-heading"><em>Editer mon livre (upload)</em></div>
              <form  method="post"  action="validModifUploadBook"  enctype="multipart/form-data">
                <dl class="form">
                      <dd >
             <s:actionerror/>
        			
        			<s:fielderror></s:fielderror>
                  </dd>
                 <dd >
                 <input type="hidden" name="bookId" value="<s:property value="bookId" />"/>
                   <label for="bookFile"> <strong>nouveau lien :</strong></label>
                    <div class="error_img"></div>
                    <input type="file" name="bookFile" id="bookFile" class="form-input-file validated" />
                    <div class="msg"></div>
                  </dd>
                  <dd >
                   <label for="image"> <strong>nouvelle image :</strong></label>
                    <div class="error_img"></div>
                    <input type="file" name="image" id="image" class="form-input-file validated" />
                    <div  class="msg"></div>
                  </dd>
                </dl>
          
                 <div class="form-row">
                  <p class="txt-center" ><img src="images/exclamation.gif" alt="" border="0"  /> reuploader une oeuvre payante sera re-validé a la vente sous 24h</p>
                </div>
                <div class="combo-row center">
                 <input name="button3" type="submit" class="btn-large-red" id="button3" value="valider!" />
                 
                </div>
              </form>
            </div>
          </div>
        </div>
        <s:actionerror/>
        <s:fielderror></s:fielderror>
            </body>
</html>

