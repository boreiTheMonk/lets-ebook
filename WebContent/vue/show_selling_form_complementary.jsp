<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
      
        <title>lets-ebook - information concernant le paiement</title>
         <script type="text/javascript" src="javascript/jquery.validate.js"></script>
<script type="text/javascript" src="javascript/jquery.i18n.properties-1.0.4.js"></script>


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
				$.validator.addMethod(
				        "regex",
				        function(value, element, regexp) {
				            var check = false;
				            var re = new RegExp(regexp);
				            return this.optional(element) || re.test(value);
				        },
				        "Veuillez enlever les accents."
				);

		 $("#form_info_sell").validate({

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
			    	'editBook.price':{
			    		required: true,
			    		number:true
			    	},
			    	'editBook.demoPage': {
			       	 required: true,
			            regex: /^(([1-9][0-9]*)|([1-9][0-9]*-[1-9][0-9]*))(,([1-9][0-9]*)|,([1-9][0-9]*-[1-9][0-9]*))*$/ }
			      
			      
				    

			    },
			    messages:{
			    	'editBook.price': {
			        	 required: "champ obligatoire",
			        	 number:"rentrez un nombre"
			             },
			    	 'editBook.demoPage': {
			        	 required: "champ obligatoire",
			        	 regex:"caractères invalide, ex : 1,2,6,12-19"
			             }
			    	
			    }
			 });



		});

	
</script>

<script type="text/javascript">

var newElementUpload=    " <div class=\"combo-row uploadWrapper\">"+
	                   "<div class=\"combo-col-left\"><label for=\"doc\"><strong>justificatifs de vente à uploader :</strong></label>"+
	                   " <div class=\"error_img\"></div>"+
	                    "</div>"+
	                  "<div class=\"combo-col-right\">"+
	                    " <input type=\"file\" name=\"doc\"  class=\"form-input-file validated\" />"+
	                    "<div  class=\"msg\"></div>"+
	                   " </div>"+
	                "</div>";
	 var lastupload; 
	                

function addFileInput(){
	//lastupload.unbind("change");
	//alert("toto");
	 $(".uploadWrapper:last").after($(newElementUpload));
	//unbindInputFile();
	
}

</script>
    </head>
    <body>
    <div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">information sur le livre à vendre</div>
              <div class="top-heading-icon"><img src="images/upload-icon.png" width="36" height="29" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="form-heading"><em>informations complémentaires</em></div>
              <form  method="post" id="form_info_sell" action="valid_info_sell"  enctype="multipart/form-data">
                <dl class="form">
                      <dd >
             <s:actionerror/>
        			<s:fielderror></s:fielderror>
                  </dd>
                  <dd >
                  <input type="hidden" name="bookId" value="<s:property value="bookId" />"/>
                    <label for="b.title"><strong>titre du livre :</strong></label>
       
                    <s:property value="b.title"  />
                    
                  </dd>
                  <dd >
                    <span style="font-style:italic;font-size:12px;color:GREY"> veuillez nous fournir les documents complémentaires attestant votre droit à vendre ce document" :</span>
           
                  </dd>
             
                  <dd >
              
                    <label for="bookFile"><strong>explications :</strong></label>
                    <div class="error_img"></div>
                    <textarea name="editBook.proofExplain"   cols="45" rows="5" class="form-text-area1 validated"><s:property value="editBook.proofExplain" /></textarea>
                    <div  class="msg"></div>
                  
                   </dd>

                </dl>
                 <div style="border:1px solid #E2D6C9;clear:both;float: left;padding: 10px 10px 0px 10px;margin: 10px ;">
	                
	             
	                <s:iterator value="uploadedDoc" var="doc">
	                     <div class="combo-row uploadWrapper">
	                   <div class="combo-col-left">
	                    </div>
	                  <div class="combo-col-right">
	                    <s:property value="#doc.name"/>
	                    </div>
	                 </div>
	              
	                </s:iterator>
	             
	                
	                
	                 <div class="combo-row uploadWrapper">
	                   <div class="combo-col-left"><label for="doc"><strong>justificatifs de vente à uploader :</strong></label>
	                    <div class="error_img"></div>
	                    </div>
	                  <div class="combo-col-right">
	                     <input type="file" name="doc"  class="form-input-file validated" />
	                    <div  class="msg"></div>
	                    </div>
	                 
	                </div>
	                  <div class="combo-row uploadWrapper">
	                   <div class="combo-col-left"><label for="doc"><strong>justificatifs de vente à uploader :</strong></label>
	                    <div class="error_img"></div>
	                    </div>
	                  <div class="combo-col-right">
	                     <input type="file" name="doc" class="form-input-file validated" />
	                    <div  class="msg"></div>
	                    </div>
	                 
	                </div>
	                
	                <div class="combo-row">
	             <div class="combo-col-left"> &nbsp;
	                    </div>
	                  <div class="combo-col-right">
	                     <input type="button" name="button3" id="button3" value="ajouter" class="btn-blue" onclick="addFileInput();"/>
	                    <div  class="msg"></div>
	                    </div>
	                 
	                </div>
	                
	              </div>
                
               
                
                <dl class="form">
                
                   <dd >
                    <label for="editBook.price"><strong>prix :</strong></label>
                    <div class="error_img"></div>
                    <input name="editBook.price" value="<s:property value="editBook.price" />" id="editBook.price" type="text" maxlength="50" class="form-input1 validated"  />
                    <div  class="msg"></div>
                  </dd>
                <dd >
                    <label for="editBook.demoPage"><strong>page de démo (ex 1,2,6,12-19) :</strong></label>
                    <div class="error_img"></div>
                    <input name="editBook.demoPage" value="<s:property value="editBook.demoPage"/>"  id="editBook.demoPage" type="text" maxlength="50" class="form-input1 validated"  />
                    <div  class="msg"></div>
                  </dd>
                </dl>
                
                <div class="form-row">
                  <p class="txt-center" ><img src="images/exclamation.gif" alt="" border="0"  /> l'oeuvre payante sera validé a la vente après verification sous 24h</p>
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

