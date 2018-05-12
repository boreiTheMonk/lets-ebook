<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
      
        <title>ajouter un nouveau livre</title>
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



</script>
    </head>
    <body>
    <div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">adresse de paiement</div>
              <div class="top-heading-icon"><img src="images/upload-icon.png" width="36" height="29" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="form-heading"><em>Ajouter une adresse pour le paiement</em></div>
              <form  method="post" id="form_add_book" action="addbook"  enctype="multipart/form-data">
                <dl class="form">
                      <dd >
             <s:actionerror/>
        			
        			<s:fielderror></s:fielderror>
                  </dd>
                  <dd >
                    <label for="b.title"><strong>adresse 1:</strong></label>
                    <div class="error_img"></div>
                    <input class="form-input1 validated" name="b.title" id="b.title" type="text"  value=""  />
                    <div class="msg"></div>
                  </dd>
                    <dd >
                    <label for="b.title"><strong>adresse 2:</strong></label>
                    <div class="error_img"></div>
                    <input class="form-input1 validated" name="b.title" id="b.title" type="text"  value=""  />
                    <div class="msg"></div>
                  </dd>
                  <dd >
                    <label for="b.nbPages"><strong>code postal :</strong></label>
                    <div class="error_img"></div>
                    <input name="b.nbPages" id="b.nbPages" type="text" maxlength="20" class="form-input1 validated"  />
                    <div  class="msg"></div>
                  </dd>
                    <dd >
                    <label for="b.nbPages"><strong>ville :</strong></label>
                    <div class="error_img"></div>
                    <input name="b.nbPages" id="b.nbPages" type="text" maxlength="20" class="form-input1 validated"  />
                    <div  class="msg"></div>
                  </dd>
                  
                </dl>
                <div class="combo-row">
                  <div class="combo-col-left"><strong>pays :</strong></div>
                  <div class="combo-col-right">
                    <div class="left margin-left-5">
                      <select name="category"  id="category">
                     
                      </select>
                    </div>
                  </div>
                </div>
                 
                
                <dl class="form">
                    <dd >
                    <label for="b.nbPages"><strong>url de votre site :</strong></label>
                    <div class="error_img"></div>
                    <input name="b.nbPages" id="b.nbPages" type="text" maxlength="20" class="form-input1 validated"  />
                    <div  class="msg"></div>
                  </dd>
                   <dd >
                    <label for="b.nbPages"><strong>téléphone:</strong></label>
                    <div class="error_img"></div>
                    <input name="b.nbPages" id="b.nbPages" type="text" maxlength="20" class="form-input1 validated"  />
                    <div  class="msg"></div>
                  </dd>
              
                </dl>
                    <div class="combo-row">
                  <div class="combo-col-left"><strong>moyen de paiement :</strong></div>
                  <div class="combo-col-right">
                    <div class="left margin-left-5">
                      <select name="category"  id="category">
                     
                      </select>
                    </div>
                  </div>
                </div>
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

