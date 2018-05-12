
jQuery.i18n.properties({
    name:'editUser',
    path:'bundle/',
    mode:'map',
    
    callback: function() {
        // We specified mode: 'both' so translated values will be
        // available as JS vars/functions and as a map
//alert("toto");
        // Accessing a simple value through the map
     //   jQuery.i18n.prop('msg_hello');
        // Accessing a value with placeholders through the map
       // jQuery.i18n.prop('msg_complex', ['John']);
       // alert(jQuery.i18n.prop('error.form_name'));
        // Accessing a simple value through a JS variable
       // alert(jQuery.i18n.prop('msg_hello')+' '+jQuery.i18n.prop('msg_world'));
        // Accessing a value with placeholders through a JS function
     //   alert( jQuery.i18n.prop('msg_complex', ['John']));
    }
});


  


var toto ="<s:property name='toto'  />";
 var lastinputAuthor ;
  var lastinputBook ;
 $(document).ready(function(){
 	
 	$("#image").uploadify({
		'uploader'       : 'jquery/juploadify/scripts/uploadify.swf',
		'script'         : 'uploadFileAjax',
		//'script'         : 'query/juploadify/scripts/uploadify.php',
		'cancelImg'      : 'jquery/juploadify/cancel.png',
		'folder'         : 'jquery/juploadify/uploads',
		'fileDataName'   : 'imageMember',
		'auto'           : true,
		'multi'          : false,
		//'onError': function(event,queueID,fileObj,errorObj){alert(errorObj.info);},
		'onComplete':function(event,queueID,fileObj,response){alert(response);}
	});
 	
 	  // alert(jQuery.i18n.prop('error_form_name'));
     
   /* $("#updateUser").validate({
   rules: {
   	//on pense a l'image
     'me.name': "required",
     'me.lastName': "required",
     'me.birth': "required",//verification pattern de date (avec un calendar)
     'me.description': "required",
     'me.email': {
       required: true,
       email: true
     },
     
     'emailConfirm': {
         equalTo: "#email"
       
       
      
     },
  
     'me.password': "required",
    'passwordConfirm': "required"
   
   },
   messages: {
     'me.name': jQuery.i18n.prop('error.form_name'),
     'me.lastName': jQuery.i18n.prop('error.form_lastname'),
     'me.birth': jQuery.i18n.prop('error.form_birth'),
     'me.description': jQuery.i18n.prop('error.form_description'),
     'me.emailConfirm': jQuery.i18n.prop('error_form_mail_bad'),
     //'me.nom': jQuery.i18n.prop('error.form.name'),
     //message prenom birth description passxord, password confirme, image
     'me.email': {
       required: jQuery.i18n.prop('error_form_mail'),
       email: jQuery.i18n.prop('error_form_mail_bad')
     }

   }



 });*/
 	
 	
 	
 	
 	
 	
 
	//append a last div input author in multiAuthor
 	//we start chose the last input in div multiAuthor 
 	lastinputAuthor = $("input[name=nameAuthor]:last");
 	unbindInputAuthor();
 	lastinputBook = $("input[name=nameBook]:last");
 	unbindInputBook();
})

function unbindInputAuthor(){
lastinputAuthor.unbind("keydown");
//alert("toto");
lastinputAuthor = $("input[name=nameAuthor]:last");
 	lastinputAuthor.bind("keydown",function(){
 	 	$(".fav_author:last").after($("<dd class='fav_author'><label >" +
 	 			"<strong>&nbsp;</strong></label>" +
 	 					"<div class='combo-cover'>" +
 	                      "<input name='nameAuthor' type='text' class='form-input1' />" +
 	                   " </div>" +
 	                 " </dd>"));
	unbindInputAuthor();
});


}

function unbindInputBook(){
lastinputBook.unbind("keydown");
lastinputBook = $("input[name=nameBook]:last");
 	lastinputBook.bind("keydown",function(){
 		//alert("ee");
 	$(".fav_book:last").after($("<dd class='fav_book'><label >" +
 			"<strong>&nbsp;</strong></label>" +
 					"<div class='combo-cover'>" +
                      "<input name='nameBook' type='text' class='form-input1' />" +
                   " </div>" +
                 " </dd>"));
	//alert("toto");
	unbindInputBook();
});

}